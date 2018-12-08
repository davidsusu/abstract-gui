package hu.webarticum.abstractgui.implementation.lanterna;

import java.util.List;

import com.googlecode.lanterna.gui2.Panel;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Container;

public abstract class AbstractLanternaContainer extends AbstractLanternaComponent implements Container {

    protected final Panel panel = new Panel();
    
    AbstractLanternaContainer(LanternaEnvironment environment) {
        super(environment);
    }

    @Override
    public abstract List<AbstractLanternaComponent> getChildren();

    @Override
    public void refresh() {
        for (AbstractLanternaComponent component: getChildren()) {
            component.refresh();
        }
    }
    
    @Override
    public Panel getNativeComponent() {
        return panel;
    }

    protected AbstractLanternaComponent checkComponent(Component component) {
        if (!(component instanceof AbstractLanternaComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        return (AbstractLanternaComponent)component;
    }

}
