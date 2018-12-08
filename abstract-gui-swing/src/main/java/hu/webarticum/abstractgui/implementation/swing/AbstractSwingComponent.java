package hu.webarticum.abstractgui.implementation.swing;

import hu.webarticum.abstractgui.core.framework.Component;


abstract public class AbstractSwingComponent extends AbstractSwingActor implements Component {

    AbstractSwingComponent(SwingEnvironment environment) {
        super(environment);
    }
    
    abstract public java.awt.Component getNativeComponent();

}
