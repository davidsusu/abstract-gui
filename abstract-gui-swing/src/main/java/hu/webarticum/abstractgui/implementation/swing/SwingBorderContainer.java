package hu.webarticum.abstractgui.implementation.swing;

import java.awt.BorderLayout;

import hu.webarticum.abstractgui.core.framework.BorderContainer;
import hu.webarticum.abstractgui.core.framework.Component;

public class SwingBorderContainer extends AbstractSwingContainer implements BorderContainer {

    public SwingBorderContainer(SwingEnvironment environment) {
        super(environment);
        panel.setLayout(new BorderLayout());
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
        addInternal(component, BorderLayout.PAGE_START);
    }

    @Override
    public void addLeft(Component component) {
        addInternal(component, BorderLayout.LINE_START);
    }

    @Override
    public void addCenter(Component component) {
        addInternal(component, BorderLayout.CENTER);
    }

    @Override
    public void addRight(Component component) {
        addInternal(component, BorderLayout.LINE_END);
    }

    @Override
    public void addBottom(Component component) {
        addInternal(component, BorderLayout.PAGE_END);
    }
    
    private void addInternal(Component component, String swingConstraint) {
        AbstractSwingComponent abstractComponent = checkComponent(component);
        panel.add(abstractComponent.getNativeComponent(), swingConstraint);
        children.add(abstractComponent);
    }
    
}
