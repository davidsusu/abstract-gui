package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.Container;
import hu.webarticum.abstractgui.core.framework.Factory;
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
    public LanternaFrame createFrame(Container container, String title) {
        return new LanternaFrame(environment, checkContainer(container), title);
    }

    @Override
    public LanternaFrame createFrame(Container container, Text titleContent) {
        return new LanternaFrame(environment, checkContainer(container), titleContent);
    }

    private AbstractLanternaContainer checkContainer(Container container) {
        if (!(container instanceof AbstractLanternaContainer)) {
            throw new IllegalArgumentException("Incompatible container type: " + container.getClass().getSimpleName());
        }
        return (AbstractLanternaContainer)container;
    }

    @Override
    public LanternaBorderContainer createBorderContainer() {
        return new LanternaBorderContainer(environment);
    }

    @Override
    public LanternaVerticalContainer createVerticalContainer() {
        return new LanternaVerticalContainer(environment);
    }

    @Override
    public LanternaHorizontalContainer createHorizontalContainer() {
        return new LanternaHorizontalContainer(environment);
    }

    @Override
    public LanternaFreeContainer createFreeContainer() {
        return new LanternaFreeContainer(environment);
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
    public LanternaLabel createLabel(String label) {
        return new LanternaLabel(environment, label);
    }

    @Override
    public LanternaLabel createLabel(Text labelContent) {
        return new LanternaLabel(environment, labelContent);
    }

    @Override
    public LanternaTextField createTextField() {
        return new LanternaTextField(environment);
    }

}
