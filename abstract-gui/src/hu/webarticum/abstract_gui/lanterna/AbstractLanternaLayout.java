package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.LayoutManager;

import hu.webarticum.abstract_gui.framework.Layout;

abstract public class AbstractLanternaLayout implements Layout {

    private final LanternaEnvironment environment;
    
    AbstractLanternaLayout(LanternaEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public LanternaEnvironment getEnvironment() {
        return environment;
    }
    
    abstract public LayoutManager getNativeLayout();
    
}
