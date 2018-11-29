package hu.webarticum.abstractgui.implementation.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Container;

public abstract class AbstractSwingContainer extends AbstractSwingComponent implements Container {

    protected final JPanel panel = new JPanel();

    protected List<AbstractSwingComponent> children = new ArrayList<AbstractSwingComponent>();

    public AbstractSwingContainer(SwingEnvironment environment) {
        super(environment);
    }

    @Override
    public List<AbstractSwingComponent> getChildren() {
        return new ArrayList<AbstractSwingComponent>(children);
    }

    @Override
    public void remove(Component component) {
        if (component instanceof AbstractSwingComponent) {
            panel.remove(((AbstractSwingComponent)component).getNativeComponent());
        }
        children.remove(component);
    }

    @Override
    public void refresh() {
        for (AbstractSwingComponent component: children) {
            component.refresh();
        }
    }
    
    @Override
    public JPanel getNativeComponent() {
        return panel;
    }

    protected AbstractSwingComponent checkComponent(Component component) {
        if (!(component instanceof AbstractSwingComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        return (AbstractSwingComponent)component;
    }

}
