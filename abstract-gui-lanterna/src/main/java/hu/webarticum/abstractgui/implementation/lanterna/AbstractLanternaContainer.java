package hu.webarticum.abstractgui.implementation.lanterna;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.gui2.Panel;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Container;

public abstract class AbstractLanternaContainer extends AbstractLanternaComponent implements Container {

    protected final Panel panel = new com.googlecode.lanterna.gui2.Panel();
    
    protected List<AbstractLanternaComponent> children = new ArrayList<AbstractLanternaComponent>();
    
    AbstractLanternaContainer(LanternaEnvironment environment) {
        super(environment);
    }

    @Override
    public List<AbstractLanternaComponent>  getChildren() {
        return new ArrayList<AbstractLanternaComponent>(children);
    }

    @Override
    public void remove(Component component) {
        if (component instanceof AbstractLanternaComponent) {
            panel.removeComponent(((AbstractLanternaComponent)component).getNativeComponent());
        }
        children.remove(component);
    }

    @Override
    public void refresh() {
        for (AbstractLanternaComponent component: children) {
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
