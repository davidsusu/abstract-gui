package hu.webarticum.abstract_gui.framework;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GeneralListenable implements Listenable {
    
    // TODO: like to Swing's ListenerList?
    
    private Map<Object, List<EventListener>> listenerMap = new HashMap<Object, List<EventListener>>();
    
    @Override
    public void on(Object eventType, EventListener listener) {
        List<EventListener> listeners;
        if (listenerMap.containsKey(eventType)) {
            listeners = listenerMap.get(eventType);
        } else {
            listeners = new ArrayList<EventListener>(1);
            listenerMap.put(eventType, listeners);
        }
        listeners.add(listener);
    }

    @Override
    public void off(Object eventType, EventListener listener) {
        List<EventListener> listeners;
        if (listenerMap.containsKey(eventType)) {
            listeners = listenerMap.get(eventType);
        } else {
            listeners = new ArrayList<EventListener>(1);
            listenerMap.put(eventType, listeners);
        }
        listeners.remove(listener);
    }

    @Override
    public void runListeners(Object eventType, Event event) {
        List<EventListener> listeners = listenerMap.get(eventType);
        if (listeners != null) {
            for (EventListener listener: listeners) {
                listener.occured(event);
            }
        }
    }
    
}
