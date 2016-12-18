package hu.webarticum.abstract_gui.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnvironmentDetector {
    
    static private List<String> environmentClassNames = new ArrayList<String>();
    static {
        registerEnvironmentClass("hu.webarticum.abstract_gui.swing.SwingEnvironment");
        registerEnvironmentClass("hu.webarticum.abstract_gui.android.AndroidEnvironment");
        registerEnvironmentClass("hu.webarticum.abstract_gui.lanterna.LanternaEnvironment");
    }
    
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

    static public void registerEnvironmentClass(Class<? extends Environment> environmentClass) {
        registerEnvironmentClass(environmentClass.getName());
    }

    static public void registerEnvironmentClass(String environmentClassName) {
        environmentClassNames.add(environmentClassName);
    }
    
    static public void unregisterEnvirenmentClass(Class<? extends Environment> environmentClass) {
        unregisterEnvirenmentClass(environmentClass);
    }

    static public void unregisterEnvirenmentClass(String environmentClassName) {
        environmentClassNames.remove(environmentClassName);
    }
    
    static public List<Environment> getEnvironments() {
        List<Environment> environments = new ArrayList<Environment>();
        for (String className: environmentClassNames) {
            try {
                environments.add((Environment)Class.forName(className).newInstance());
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return environments;
    }
    
    static public void reset() {
        defaultEnvironment = null;
    }
    
}
