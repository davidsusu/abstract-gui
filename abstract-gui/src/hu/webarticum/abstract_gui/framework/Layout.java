package hu.webarticum.abstract_gui.framework;

public interface Layout extends EnvironmentMember {

    public void add(Panel panel, Component component);

    public void add(Panel panel, Component component, int place);
    
}
