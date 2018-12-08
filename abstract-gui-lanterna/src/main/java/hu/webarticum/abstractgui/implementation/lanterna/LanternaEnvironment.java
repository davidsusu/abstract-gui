package hu.webarticum.abstractgui.implementation.lanterna;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.SeparateTextGUIThread;
import com.googlecode.lanterna.gui2.TextGUI;
import com.googlecode.lanterna.gui2.WindowShadowRenderer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import hu.webarticum.abstractgui.core.framework.Environment;

public class LanternaEnvironment implements Environment {
    
    private final LanternaFactory factory = new LanternaFactory(this);
    
    private final AtomicBoolean running = new AtomicBoolean(false);

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
        start();
        getGui().getGUIThread().invokeLater(runnable);
    }

    @Override
    public void invokeAndWait(Runnable runnable) throws InterruptedException {
        start();
        getGui().getGUIThread().invokeAndWait(runnable);
    }
    
    public void start() {
        if (running.compareAndSet(false, true)) {
            // FIXME: proper status handling?
            ((SeparateTextGUIThread)getGui().getGUIThread()).start();
        }
    }
    
    public void stop() {
        if (running.compareAndSet(true, false)) {
            // FIXME: proper status handling?
            ((SeparateTextGUIThread)getGui().getGUIThread()).stop();
        }
    }

    MultiWindowTextGUI getGui() {
        if (gui == null) {
            final Terminal terminal;
            Screen screen;
            try {
                terminal = new DefaultTerminalFactory().createTerminal();
                screen = new TerminalScreen(terminal) {

                    @Override
                    public synchronized void refresh(RefreshType refreshType) throws IOException {
                        super.refresh(refreshType);
                        try {
                            TerminalSize size = terminal.getTerminalSize();
                            terminal.newTextGraphics().putString(0, size.getRows() - 1,
                                "Switch between widows with ctrl(+shift)+w"
                            );
                        } catch (IOException e) {
                            // nothing to do
                        }
                    }
                    
                };
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
            gui = new MultiWindowTextGUI(
                new SeparateTextGUIThread.Factory(),
                screen,
                new DefaultWindowManager(),
                new WindowShadowRenderer(),
                new EmptySpace(TextColor.ANSI.BLUE)
            );
            gui.addListener(new TextGUI.Listener() {

                @Override
                public boolean onUnhandledKeyStroke(TextGUI textGUI, KeyStroke keyStroke) {
                    boolean ctrl = keyStroke.isCtrlDown();
                    boolean shift = keyStroke.isShiftDown();
                    Character character = keyStroke.getCharacter();
                    char ch = character == null ? Character.MIN_VALUE : character.charValue();
                    if (ctrl && ch == 'w') {
                        gui.cycleActiveWindow(shift);
                        // TODO: while not same and focusable
                        return true;
                    }
                    return false;
                }
                
            });
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
