package hu.webarticum.abstractgui.core.framework;

import java.util.List;

public interface Panel extends Component {
    
    public void setLayout(Layout layout);

    public void add(Component component);
    
    public void add(Component component, Object constraint);
    
    public List<? extends Component> getChildren();
    
    public void remove(Component component);
    
}
