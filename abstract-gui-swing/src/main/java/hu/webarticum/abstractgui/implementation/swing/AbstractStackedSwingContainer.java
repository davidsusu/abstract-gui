package hu.webarticum.abstractgui.implementation.swing;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.abstractgui.core.framework.Component;

public abstract class AbstractStackedSwingContainer extends AbstractSwingContainer {

    private List<AbstractSwingComponent> children = new ArrayList<AbstractSwingComponent>();

    public AbstractStackedSwingContainer(SwingEnvironment environment) {
        super(environment);
    }

    @Override
    public List<AbstractSwingComponent> getChildren() {
        return new ArrayList<AbstractSwingComponent>(children);
    }

    @Override
    public void remove(Component component) {
        if (!(component instanceof AbstractSwingComponent)) {
            return;
        }
        
        AbstractSwingComponent abstractComponent = (AbstractSwingComponent)component;
        panel.remove(abstractComponent.getNativeComponent());
        unregisterChild(abstractComponent);
    }

    protected void registerChild(AbstractSwingComponent component) {
        children.add(component);
    }

    protected void unregisterChild(AbstractSwingComponent component) {
        children.remove(component);
    }

}
