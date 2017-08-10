package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.EnvironmentMember;

abstract public class AbstractLanternaEnvironmentMember implements EnvironmentMember {

    private final LanternaEnvironment environment;
    
    AbstractLanternaEnvironmentMember(LanternaEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public LanternaEnvironment getEnvironment() {
        return environment;
    }
    
}
