package hu.webarticum.abstractgui.core.framework;


public interface Window extends EnvironmentMember, Listenable {
    
    public void open();
    
    public Panel getRootPanel();
    
    public void refresh();
    
}
