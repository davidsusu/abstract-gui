package hu.webarticum.abstract_gui.lanterna;

import java.io.IOException;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import hu.webarticum.abstract_gui.framework.Environment;

public class LanternaEnvironment implements Environment {

    private MultiWindowTextGUI gui = null;
    
    @Override
    public LanternaFactory getFactory() {
        return new LanternaFactory(this);
    }

    @Override
    public boolean isAvailable() {
        try {
            Class.forName("com.googlecode.lanterna.gui2.Button");
            
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
                return null;
            }
            gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        }
        return gui;
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
    
}
