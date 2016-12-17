package hu.webarticum.abstract_gui.framework;


public interface Window extends EnvironmentMember, Listenable {
    
    public void open();
    
    public Panel getRootPanel();
    
    public void refresh();
    
}
