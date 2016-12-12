package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.Component;

abstract public class AbstractLanternaComponent extends AbstractLanternaEnvironmentMember implements Component {

    AbstractLanternaComponent(LanternaEnvironment environment) {
        super(environment);
    }
    
    abstract public com.googlecode.lanterna.gui2.Component getNativeComponent();
    
}
