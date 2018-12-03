package hu.webarticum.abstractgui.implementation.lanterna;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.abstractgui.core.framework.Component;

public abstract class AbstractStackedLanternaContainer extends AbstractLanternaContainer {

    private List<AbstractLanternaComponent> children = new ArrayList<AbstractLanternaComponent>();

    public AbstractStackedLanternaContainer(LanternaEnvironment environment) {
        super(environment);
    }

    @Override
    public List<AbstractLanternaComponent> getChildren() {
        return new ArrayList<AbstractLanternaComponent>(children);
    }

    @Override
    public void remove(Component component) {
        if (!(component instanceof AbstractLanternaComponent)) {
            return;
        }
        
        AbstractLanternaComponent abstractComponent = (AbstractLanternaComponent)component;
        panel.removeComponent(abstractComponent.getNativeComponent());
        unregisterChild(abstractComponent);
    }

    protected void registerChild(AbstractLanternaComponent component) {
        children.add(component);
    }

    protected void unregisterChild(AbstractLanternaComponent component) {
        children.remove(component);
    }

}
