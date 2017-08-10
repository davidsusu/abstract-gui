package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.EnvironmentMember;


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
