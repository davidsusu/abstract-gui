package hu.webarticum.abstractgui.core.framework;

import hu.webarticum.abstractgui.core.framework.text.Text;

public interface Window extends Actor {

    public void open();

    public void hide();

    public void close();
    
    public Container getRootContainer();
    
    public Dialog createDialog(Container container, String title);
    
    public Dialog createDialog(Container container, Text title);
    
}
