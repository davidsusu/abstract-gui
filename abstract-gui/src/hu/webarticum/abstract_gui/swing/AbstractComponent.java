package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Environment;


public class AbstractComponent implements Component {
    
    private final SwingEnvironment environment;
    
    AbstractComponent(SwingEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public Environment getEnvironment() {
        return environment;
    }

}
