package hu.webarticum.abstract_gui.framework;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.abstract_gui.swing.SwingEnvironment;

public class EnvironmentDetector {
    
    static private Environment defaultEnvironment = null;
    
    static public Environment getDefaultEnvironment() {
        if (defaultEnvironment == null) {
            List<Environment> environments = getAvailableEnvironment();
            if (!environments.isEmpty()) {
                defaultEnvironment = environments.get(0);
            }
        }
        return defaultEnvironment;
    }
    
    // TODO
    static public List<Environment> getAvailableEnvironment() {
        List<Environment> environments = new ArrayList<Environment>();
        environments.add(new SwingEnvironment()); // XXX
        return environments;
    }
    
    static public void reset() {
        defaultEnvironment = null;
    }
    
}
