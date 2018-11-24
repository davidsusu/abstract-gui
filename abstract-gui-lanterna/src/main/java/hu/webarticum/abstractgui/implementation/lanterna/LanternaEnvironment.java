package hu.webarticum.abstractgui.implementation.lanterna;

import java.io.IOException;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import hu.webarticum.abstractgui.core.framework.Environment;

public class LanternaEnvironment implements Environment {
    
    private final LanternaFactory factory = new LanternaFactory(this);

    private MultiWindowTextGUI gui = null;
    
    public LanternaEnvironment() {
    }
    
    public LanternaEnvironment(MultiWindowTextGUI gui) {
        this.gui = gui;
    }
    
    @Override
    public LanternaFactory getFactory() {
        return factory;
    }

    @Override
    public boolean isAvailable() {
        try {
            Class.forName("com.googlecode.lanterna.gui2.Button");
            
            
            // FIXME: is this necessary?
            Class<?> terminalFactoryClass = Class.forName("com.googlecode.lanterna.terminal.DefaultTerminalFactory");
            Object terminalFactory = terminalFactoryClass.newInstance();
            terminalFactoryClass.getMethod("setAutoOpenTerminalEmulatorWindow", boolean.class).invoke(terminalFactory, false);
            
            Object terminal = terminalFactoryClass.getMethod("createTerminal").invoke(terminalFactory);

            try {
                Class<?> awtWindowClass = Class.forName("java.awt.Window");
                if (awtWindowClass.isAssignableFrom(terminal.getClass())) {
                    awtWindowClass.getMethod("dispose").invoke(terminal);
                }
            } catch (Exception e) {
            }
            
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int getPriority() {
        return PRIORITY_NORMAL;
    }

    @Override
    public void invokeLater(Runnable runnable) {
        getGui().getGUIThread().invokeLater(runnable);
    }

    @Override
    public void invokeAndWait(Runnable runnable) throws InterruptedException {
        getGui().getGUIThread().invokeAndWait(runnable);
    }

    MultiWindowTextGUI getGui() {
        if (gui == null) {
            Screen screen;
            try {
                screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
            } catch (IOException e) {
                return null;
            }
            try {
                screen.startScreen();
            } catch (IOException e) {
                try {
                    screen.close();
                } catch (IOException ee) {
                    // nothing to do
                }
                return null;
            }
            gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        }
        return gui;
    }
    
    int getCharacterHeight() {
        // XXX
        return 20;
    }
    
    int getCharacterWidth() {
        // XXX
        return 12;
    }
    
}
