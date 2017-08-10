package hu.webarticum.abstract_gui.framework;


public interface Factory extends EnvironmentMember {

    public Window createWindow(String title);

    public Window createWindow(TextualContent titleContent);

    public AbsoluteLayout createAbsoluteLayout();
    
    public BorderLayout createBorderLayout();

    public LinearLayout createLinearLayout(LinearLayout.Direction direction);
    
    public GridLayout createGridLayout(int columns);
    
    public Panel createPanel();

    public Panel createPanel(Layout layout);

    public Button createButton(String label);

    public Button createButton(TextualContent labelContent);

    public Label createLabel(String label);

    public Label createLabel(TextualContent labelContent);

    public TextField createTextField();
    
}
