package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Component;


abstract public class AbstractSwingComponent extends AbstractSwingEnvironmentMember implements Component {
    
    AbstractSwingComponent(SwingEnvironment environment) {
        super(environment);
    }
    
    abstract public java.awt.Component getNativeComponent();

}
