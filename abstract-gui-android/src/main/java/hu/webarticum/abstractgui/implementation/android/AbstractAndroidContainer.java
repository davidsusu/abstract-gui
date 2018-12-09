package hu.webarticum.abstractgui.implementation.android;

import android.view.ViewGroup;

import java.util.List;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Container;

public abstract class AbstractAndroidContainer extends AbstractAndroidComponent implements Container {

    public AbstractAndroidContainer(AndroidEnvironment environment) {
        super(environment);
    }

    @Override
    public void refresh() {
        for (AbstractAndroidComponent component: getChildren()) {
            component.refresh();
        }
    }

    @Override
    public abstract List<AbstractAndroidComponent> getChildren();

    protected AbstractAndroidComponent checkComponent(Component component) {
        if (!(component instanceof AbstractAndroidComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        return (AbstractAndroidComponent)component;
    }

    @Override
    public abstract ViewGroup getNativeComponent();

}
