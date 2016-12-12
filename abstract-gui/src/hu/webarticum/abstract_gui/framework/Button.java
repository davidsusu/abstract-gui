package hu.webarticum.abstract_gui.framework;

public interface Button extends Component {
    
    public void addActionListener(ActionListener actionListener);

    public void removeActionListener(ActionListener actionListener);
    
}
