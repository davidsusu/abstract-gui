package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.Factory;
import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.Layout;
import hu.webarticum.abstractgui.core.framework.LinearLayout;
import hu.webarticum.abstractgui.core.framework.TextField;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class LanternaFactory implements Factory {
    
    private final LanternaEnvironment environment;
    
    LanternaFactory(LanternaEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public LanternaEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public LanternaWindow createWindow(String title) {
        return new LanternaWindow(environment, title);
    }

    @Override
    public LanternaWindow createWindow(Text titleContent) {
        return new LanternaWindow(environment, titleContent);
    }

    @Override
    public LanternaAbsoluteLayout createAbsoluteLayout() {
        return new LanternaAbsoluteLayout(environment);
    }

    @Override
    public LanternaBorderLayout createBorderLayout() {
        return new LanternaBorderLayout(environment);
    }

    @Override
    public LanternaLinearLayout createLinearLayout(LinearLayout.Direction direction) {
        return new LanternaLinearLayout(environment, direction);
    }
    
    @Override
    public LanternaGridLayout createGridLayout(int columns) {
        return new LanternaGridLayout(environment, columns);
    }

    @Override
    public LanternaPanel createPanel() {
        return createPanel(createBorderLayout());
    }

    @Override
    public LanternaPanel createPanel(Layout layout) {
        if (!(layout instanceof AbstractLanternaLayout)) {
            throw new IllegalArgumentException("Incompatible layout type: " + layout.getClass().getSimpleName());
        }
        return new LanternaPanel(environment, (AbstractLanternaLayout)layout);
    }

    @Override
    public LanternaButton createButton(String label) {
        return new LanternaButton(environment, label);
    }

    @Override
    public LanternaButton createButton(Text labelContent) {
        return new LanternaButton(environment, labelContent);
    }

    @Override
    public Label createLabel(String label) {
        return new LanternaLabel(environment, label);
    }

    @Override
    public Label createLabel(Text labelContent) {
        return new LanternaLabel(environment, labelContent);
    }

    @Override
    public TextField createTextField() {
        return new LanternaTextField(environment);
    }

}
