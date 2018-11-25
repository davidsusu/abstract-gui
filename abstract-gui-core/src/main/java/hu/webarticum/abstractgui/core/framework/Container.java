package hu.webarticum.abstractgui.core.framework;

import java.util.List;

public interface Container extends Component {

    public void add(Component component, Object constraint);
    
    public List<? extends Component> getChildren();
    
    public void remove(Component component);
    
}
