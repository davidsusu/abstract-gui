package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.Label;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.TextField;
import hu.webarticum.abstract_gui.framework.TextualContent;

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
    public LanternaWindow createWindow(TextualContent titleContent) {
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
    public LanternaButton createButton(TextualContent labelContent) {
        return new LanternaButton(environment, labelContent);
    }

    @Override
    public Label createLabel(String label) {
        return new LanternaLabel(environment, label);
    }

    @Override
    public Label createLabel(TextualContent labelContent) {
        return new LanternaLabel(environment, labelContent);
    }

    @Override
    public TextField createTextField() {
        return new LanternaTextField(environment);
    }

}
