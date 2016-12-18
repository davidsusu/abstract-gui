package hu.webarticum.abstract_gui.framework;

import java.util.HashMap;
import java.util.Map;

public class Event {

    private final Object target;
    
    private final Object nativeEvent;
    
    private final Map<String, Object> propertyMap;
    
    // TODO event type
    
    public Event() {
        this(null, null, null);
    }
    
    public Event(Object target) {
        this(target, null, null);
    }
    
    public Event(Object target, Object nativeEvent) {
        this(target, nativeEvent, null);
    }
    
    public Event(Object target, Object nativeEvent, Map<String, Object> propertyMap) {
        this.target = target;
        this.nativeEvent = nativeEvent;
        this.propertyMap = new HashMap<String, Object>();
        if (propertyMap != null) {
            this.propertyMap.putAll(propertyMap);
        }
    }

    public Object getTarget() {
        return target;
    }

    public Component getTargetComponent() {
        if (target instanceof Component) {
            return (Component)target;
        } else {
            return null;
        }
    }

    public Object getNativeEventObject() {
        return nativeEvent;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getProperty(String propertyName) {
        return (T)propertyMap.get(propertyName);
    }
    
}
