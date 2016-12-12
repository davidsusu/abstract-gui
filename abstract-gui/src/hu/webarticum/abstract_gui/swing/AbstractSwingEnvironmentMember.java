package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Environment;


abstract public class AbstractSwingEnvironmentMember implements Component {
    
    private final SwingEnvironment environment;
    
    AbstractSwingEnvironmentMember(SwingEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public Environment getEnvironment() {
        return environment;
    }
    
}
