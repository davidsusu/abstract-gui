package hu.webarticum.abstractgui.core.framework;

import java.util.HashMap;
import java.util.Map;

public class Event {
    
    public enum Type {
        ACTION
    }
    
    private final Object type;
    
    private final Object target;
    
    private final Object nativeEvent;
    
    private final Map<String, Object> propertyMap;
    
    public Event() {
        this(null, null, null, null);
    }

    public Event(Object type) {
        this(type, null, null, null);
    }
    
    public Event(Object type, Object target) {
        this(type, target, null, null);
    }
    
    public Event(Object type, Object target, Object nativeEvent) {
        this(type, target, nativeEvent, null);
    }
    
    public Event(Object type, Object target, Object nativeEvent, Map<String, Object> propertyMap) {
        this.type = type;
        this.target = target;
        this.nativeEvent = nativeEvent;
        this.propertyMap = new HashMap<String, Object>();
        if (propertyMap != null) {
            this.propertyMap.putAll(propertyMap);
        }
    }

    public Object getType() {
        return type;
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
