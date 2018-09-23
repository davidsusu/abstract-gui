package hu.webarticum.abstractgui.core.framework;

import hu.webarticum.abstractgui.core.framework.text.Text;

public interface Factory extends EnvironmentMember {

    public Window createWindow(String title);

    public Window createWindow(Text title);

    public AbsoluteLayout createAbsoluteLayout();
    
    public BorderLayout createBorderLayout();

    public LinearLayout createLinearLayout(LinearLayout.Direction direction);
    
    public GridLayout createGridLayout(int columns);
    
    public Panel createPanel();

    public Panel createPanel(Layout layout);

    public Button createButton(String label);

    public Button createButton(Text label);

    public Label createLabel(String label);

    public Label createLabel(Text label);

    public TextField createTextField();
    
}
