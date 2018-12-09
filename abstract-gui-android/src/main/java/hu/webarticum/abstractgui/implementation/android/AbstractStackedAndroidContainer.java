package hu.webarticum.abstractgui.implementation.android;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.abstractgui.core.framework.Component;

public abstract class AbstractStackedAndroidContainer extends AbstractAndroidContainer {

    private List<AbstractAndroidComponent> children = new ArrayList<AbstractAndroidComponent>();

    public AbstractStackedAndroidContainer(AndroidEnvironment environment) {
        super(environment);
    }

    @Override
    public List<AbstractAndroidComponent> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public void remove(Component component) {
        if (!(component instanceof AbstractAndroidComponent)) {
            return;
        }

        AbstractAndroidComponent androidComponent = (AbstractAndroidComponent)component;
        getNativeComponent().removeView(androidComponent.getNativeComponent());
        unregisterChild(androidComponent);
    }

    protected void registerChild(AbstractAndroidComponent component) {
        children.add(component);
    }

    protected void unregisterChild(AbstractAndroidComponent component) {
        children.remove(component);
    }

}
