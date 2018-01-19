package hu.webarticum.abstractgui.core.framework;

public interface Listenable {

    public void on(Object eventType, EventListener listener);

    public void off(Object eventType, EventListener listener);
    
    public void runListeners(Object eventType, Event event);
    
}
