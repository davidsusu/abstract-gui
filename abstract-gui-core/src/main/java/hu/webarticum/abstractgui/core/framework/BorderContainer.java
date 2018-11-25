package hu.webarticum.abstractgui.core.framework;

public interface BorderContainer extends Container {

    public enum Location {
        TOP, LEFT, CENTER, RIGHT, BOTTOM
    }

    public void addTop(Component component);

    public void addLeft(Component component);

    public void addCenter(Component component);

    public void addRight(Component component);

    public void addBottom(Component component);
    
}
