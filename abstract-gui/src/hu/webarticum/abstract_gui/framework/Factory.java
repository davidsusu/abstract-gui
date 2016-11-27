package hu.webarticum.abstract_gui.framework;


public interface Factory extends EnvironmentMember {
    
    public Window createWindow(String title);

    public BorderLayout createBorderLayout();
    
    public Panel createPanel();

    public Panel createPanel(Layout layout);

    public Button createButton(String label);

    public Button createButton(TextualContent labelContent);
    
}
