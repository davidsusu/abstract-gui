package hu.webarticum.abstractgui.core.framework;

public interface Dialog extends Window {

    public boolean isModal();

    public Window getParent();
        
}
