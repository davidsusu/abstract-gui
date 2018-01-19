package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.EnvironmentMember;

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
