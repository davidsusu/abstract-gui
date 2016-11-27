package hu.webarticum.abstract_gui.framework;

public interface Panel extends Component {
    
    public void setLayout(Layout layout);

    public void add(Component component);
    
    public void add(Component component, int place);
    
    public void remove(Component component);
    
}
