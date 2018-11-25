package hu.webarticum.abstractgui.core.framework;

import hu.webarticum.abstractgui.core.framework.text.Text;

public interface Factory extends EnvironmentMember {

    public Window createWindow(Container container, String title);

    public Window createWindow(Container container, Text title);

    public BorderContainer createBorderContainer();

    public VerticalContainer createVerticalContainer();

    public HorizontalContainer createHorizontalContainer();

    public FreeContainer createFreeContainer();

    public Button createButton(String label);

    public Button createButton(Text label);

    public Label createLabel(String label);

    public Label createLabel(Text label);

    public TextField createTextField();
    
}
