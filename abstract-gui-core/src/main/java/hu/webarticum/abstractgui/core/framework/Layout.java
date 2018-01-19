package hu.webarticum.abstractgui.core.framework;

public interface Layout extends EnvironmentMember {

    public void add(Panel panel, Component component);

    public void add(Panel panel, Component component, Object constraint);
    
}
