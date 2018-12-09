package hu.webarticum.abstractgui.implementation.android;

import hu.webarticum.abstractgui.core.framework.Actor;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;

public abstract class AbstractAndroidActor extends AbstractAndroidEnvironmentMember implements Actor {

    protected GeneralListenable generalListenable = new GeneralListenable();

    AbstractAndroidActor(AndroidEnvironment environment) {
        super(environment);
    }

    @Override
    public void on(Object eventType, EventListener listener) {
        generalListenable.on(eventType, listener);
    }

    @Override
    public void off(Object eventType, EventListener listener) {
        generalListenable.off(eventType, listener);
    }

    @Override
    public void runListeners(Object eventType, Event event) {
        generalListenable.runListeners(eventType, event);
    }

}
