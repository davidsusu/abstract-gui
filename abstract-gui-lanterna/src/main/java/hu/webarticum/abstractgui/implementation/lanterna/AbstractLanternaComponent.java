package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;

abstract public class AbstractLanternaComponent extends AbstractLanternaEnvironmentMember implements Component {

    protected GeneralListenable generalListenable = new GeneralListenable();
    
    AbstractLanternaComponent(LanternaEnvironment environment) {
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

    abstract public com.googlecode.lanterna.gui2.Component getNativeComponent();
    
}
