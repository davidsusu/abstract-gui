package hu.webarticum.abstractgui.implementation.android;

import android.view.View;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;

public abstract class AbstractAndroidComponent extends AbstractAndroidEnvironmentMember implements Component {

    protected GeneralListenable generalListenable = new GeneralListenable();

    AbstractAndroidComponent(AndroidEnvironment environment) {
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

    public abstract View getNativeComponent();

}
