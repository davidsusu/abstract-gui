package hu.webarticum.abstractgui.implementation.swing;

import hu.webarticum.abstractgui.core.framework.EnvironmentMember;


abstract public class AbstractSwingEnvironmentMember implements EnvironmentMember {
    
    private final SwingEnvironment environment;
    
    AbstractSwingEnvironmentMember(SwingEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public SwingEnvironment getEnvironment() {
        return environment;
    }
    
}
