package hu.webarticum.abstract_gui.swing;

import java.awt.LayoutManager;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.Panel;

abstract public class AbstractSwingLayout implements Layout {

    private final SwingEnvironment environment;
    
    AbstractSwingLayout(SwingEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public SwingEnvironment getEnvironment() {
        return environment;
    }
    
    protected void checkComponents(Panel panel, Component component) {
        if (!(panel instanceof SwingPanel)) {
            throw new IllegalArgumentException("Incompatible panel type: " + panel.getClass().getSimpleName());
        }
        if (!(component instanceof AbstractSwingComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
    }
    
    abstract public LayoutManager getNativeLayout();
    
}
