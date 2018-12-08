package hu.webarticum.abstractgui.implementation.swing;

import hu.webarticum.abstractgui.core.framework.Container;
import hu.webarticum.abstractgui.core.framework.Environment;
import hu.webarticum.abstractgui.core.framework.Factory;
import hu.webarticum.abstractgui.core.framework.text.Text;

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
    public SwingFrame createFrame(Container container, String title) {
        return new SwingFrame(environment, checkContainer(container), title);
    }

    @Override
    public SwingFrame createFrame(Container container, Text titleContent) {
        return new SwingFrame(environment, checkContainer(container), titleContent);
    }
    
    private AbstractSwingContainer checkContainer(Container container) {
        if (!(container instanceof AbstractSwingContainer)) {
            throw new IllegalArgumentException("Incompatible container type: " + container.getClass().getSimpleName());
        }
        return (AbstractSwingContainer)container;
    }

    @Override
    public SwingBorderContainer createBorderContainer() {
        return new SwingBorderContainer(environment);
    }

    @Override
    public SwingVerticalContainer createVerticalContainer() {
        return new SwingVerticalContainer(environment);
    }

    @Override
    public SwingHorizontalContainer createHorizontalContainer() {
        return new SwingHorizontalContainer(environment);
    }

    @Override
    public SwingFreeContainer createFreeContainer() {
        return new SwingFreeContainer(environment);
    }

    @Override
    public SwingButton createButton(String label) {
        return new SwingButton(environment, label);
    }

    @Override
    public SwingButton createButton(Text labelContent) {
        return new SwingButton(environment, labelContent);
    }

    @Override
    public SwingLabel createLabel(String label) {
        return new SwingLabel(environment, label);
    }

    @Override
    public SwingLabel createLabel(Text labelContent) {
        return new SwingLabel(environment, labelContent);
    }

    @Override
    public SwingTextField createTextField() {
        return new SwingTextField(environment);
    }

}
