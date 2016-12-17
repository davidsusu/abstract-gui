package hu.webarticum.abstract_gui.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hu.webarticum.abstract_gui.lanterna.LanternaEnvironment;
import hu.webarticum.abstract_gui.swing.SwingEnvironment;

public class EnvironmentDetector {
    
    static private Environment defaultEnvironment = null;
    
    static public Environment getDefaultEnvironment() {
        if (defaultEnvironment == null) {
            List<Environment> environments = getAvailableEnvironments();
            if (!environments.isEmpty()) {
                defaultEnvironment = environments.get(0);
            }
        }
        return defaultEnvironment;
    }
    
    static public List<Environment> getAvailableEnvironments() {
        List<Environment> availableEnvironments = new ArrayList<Environment>();
        for (Environment environment: getEnvironments()) {
            if (environment.isAvailable()) {
                availableEnvironments.add(environment);
            }
        }
        Collections.sort(availableEnvironments, new Comparator<Environment>() {

            @Override
            public int compare(Environment environment1, Environment environment2) {
                return Integer.compare(environment1.getPriority(), environment2.getPriority());
            }
            
        });
        return availableEnvironments;
    }
    
    // XXX
    static public List<Environment> getEnvironments() {
        List<Environment> environments = new ArrayList<Environment>();
        //environments.add(new SwingEnvironment());
        environments.add(new LanternaEnvironment());
        return environments;
    }
    
    static public void reset() {
        defaultEnvironment = null;
    }
    
}
