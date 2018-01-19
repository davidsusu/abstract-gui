package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.LayoutManager;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Layout;
import hu.webarticum.abstractgui.core.framework.Panel;

abstract public class AbstractLanternaLayout implements Layout {

    private final LanternaEnvironment environment;
    
    AbstractLanternaLayout(LanternaEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public LanternaEnvironment getEnvironment() {
        return environment;
    }
    
    protected void checkComponents(Panel panel, Component component) {
        if (!(panel instanceof LanternaPanel)) {
            throw new IllegalArgumentException("Incompatible panel type: " + panel.getClass().getSimpleName());
        }
        if (!(component instanceof AbstractLanternaComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
    }
    
    abstract public LayoutManager getNativeLayout();
    
}
