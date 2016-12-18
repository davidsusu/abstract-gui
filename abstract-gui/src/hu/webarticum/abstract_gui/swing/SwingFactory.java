package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.Label;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.TextField;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class SwingFactory implements Factory {
    
    private final SwingEnvironment environment;
    
    SwingFactory(SwingEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public SwingWindow createWindow(String title) {
        return new SwingWindow(environment, title);
    }

    @Override
    public SwingWindow createWindow(TextualContent titleContent) {
        return new SwingWindow(environment, titleContent);
    }

    @Override
    public SwingAbsoluteLayout createAbsoluteLayout() {
        return new SwingAbsoluteLayout(environment);
    }

    @Override
    public SwingBorderLayout createBorderLayout() {
        return new SwingBorderLayout(environment);
    }

    @Override
    public SwingPanel createPanel() {
        return createPanel(createBorderLayout());
    }

    @Override
    public SwingPanel createPanel(Layout layout) {
        if (!(layout instanceof AbstractSwingLayout)) {
            throw new IllegalArgumentException("Incompatible layout type: " + layout.getClass().getSimpleName());
        }
        return new SwingPanel(environment, (AbstractSwingLayout)layout);
    }

    @Override
    public SwingButton createButton(String label) {
        return new SwingButton(environment, label);
    }

    @Override
    public SwingButton createButton(TextualContent labelContent) {
        return new SwingButton(environment, labelContent);
    }

    @Override
    public Label createLabel(String label) {
        return new SwingLabel(environment, label);
    }

    @Override
    public Label createLabel(TextualContent labelContent) {
        return new SwingLabel(environment, labelContent);
    }

    @Override
    public TextField createTextField() {
        return new SwingTextField(environment);
    }
    
}
