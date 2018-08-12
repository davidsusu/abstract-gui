package hu.webarticum.abstractgui.implementation.swing;

import java.awt.LayoutManager;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Layout;
import hu.webarticum.abstractgui.core.framework.Panel;

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

    public LayoutManager getNativeLayoutFor(java.awt.Container nativeContainer) {
        return getNativeLayout();
    }
    
}