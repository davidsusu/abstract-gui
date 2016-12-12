package hu.webarticum.abstract_gui.framework;


public interface Environment {
    
    static public final int PRIORITY_LOW = 10;
    
    static public final int PRIORITY_NORMAL = 20;
    
    static public final int PRIORITY_HIGH = 30;
    
    public Factory getFactory();

    public boolean isAvailable();
    
    public int getPriority();
    
}
