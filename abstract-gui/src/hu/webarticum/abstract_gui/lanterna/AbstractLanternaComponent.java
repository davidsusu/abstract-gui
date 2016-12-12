package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.Component;

abstract public class AbstractLanternaComponent implements Component {

    private final LanternaEnvironment environment;
    
    AbstractLanternaComponent(LanternaEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public LanternaEnvironment getEnvironment() {
        return environment;
    }
    
    abstract public com.googlecode.lanterna.gui2.Component getNativeComponent();
    
}
