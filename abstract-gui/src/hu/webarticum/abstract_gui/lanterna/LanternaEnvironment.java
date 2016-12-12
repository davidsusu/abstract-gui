package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.Environment;

public class LanternaEnvironment implements Environment {
    
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
            
            // TODO: shared terminal...
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

}
