package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.BorderLayout;

import hu.webarticum.abstractgui.core.framework.BorderContainer;
import hu.webarticum.abstractgui.core.framework.Component;

public class LanternaBorderContainer extends AbstractLanternaContainer implements BorderContainer {

    LanternaBorderContainer(LanternaEnvironment environment) {
        super(environment);
        panel.setLayoutManager(new BorderLayout());
    }

    @Override
    public void add(Component component, Object constraint) {
        if (constraint == Location.TOP) {
            addTop(component);
        } else if (constraint == Location.LEFT) {
            addLeft(component);
        } else if (constraint == Location.RIGHT) {
            addRight(component);
        } else if (constraint == Location.BOTTOM) {
            addBottom(component);
        } else {
            addCenter(component);
        }
    }

    @Override
    public void addTop(Component component) {
        addInternal(component, BorderLayout.Location.TOP);
    }

    @Override
    public void addLeft(Component component) {
        addInternal(component, BorderLayout.Location.LEFT);
    }

    @Override
    public void addCenter(Component component) {
        addInternal(component, BorderLayout.Location.CENTER);
    }

    @Override
    public void addRight(Component component) {
        addInternal(component, BorderLayout.Location.RIGHT);
    }

    @Override
    public void addBottom(Component component) {
        addInternal(component, BorderLayout.Location.BOTTOM);
    }
    
    private void addInternal(Component component, BorderLayout.Location lanternaConstraint) {
        AbstractLanternaComponent abstractComponent = checkComponent(component);
        panel.addComponent(abstractComponent.getNativeComponent(), lanternaConstraint);
        children.add(abstractComponent);
    }
    
}
