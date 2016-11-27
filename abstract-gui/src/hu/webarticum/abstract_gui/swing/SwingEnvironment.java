package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Environment;

public class SwingEnvironment implements Environment {
    
    SwingFactory factory = null;
    
    public SwingFactory getFactory() {
        if (factory == null) {
            factory = new SwingFactory(this);
        }
        return factory;
    }
    
    @Override
    public int getPriority() {
        return PRIORITY_NORMAL;
    }
    
}
