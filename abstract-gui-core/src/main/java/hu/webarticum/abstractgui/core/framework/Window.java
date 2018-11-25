package hu.webarticum.abstractgui.core.framework;


public interface Window extends EnvironmentMember, Listenable {
    
    public void open();
    
    public Container getRootContainer();
    
    public void refresh();
    
}
