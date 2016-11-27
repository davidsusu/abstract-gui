package hu.webarticum.abstract_gui.swing;

import java.awt.LayoutManager;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.Layout;

abstract public class AbstractSwingLayout implements Layout {

    private final SwingEnvironment environment;
    
    AbstractSwingLayout(SwingEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public Environment getEnvironment() {
        return environment;
    }
    
    abstract public LayoutManager getNativeLayout();
    
}
