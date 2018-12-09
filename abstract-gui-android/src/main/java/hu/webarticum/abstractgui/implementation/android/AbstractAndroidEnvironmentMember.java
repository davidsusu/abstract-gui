package hu.webarticum.abstractgui.implementation.android;

import hu.webarticum.abstractgui.core.framework.EnvironmentMember;

public class AbstractAndroidEnvironmentMember implements EnvironmentMember {

    private final AndroidEnvironment environment;

    AbstractAndroidEnvironmentMember(AndroidEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public AndroidEnvironment getEnvironment() {
        return environment;
    }

}
