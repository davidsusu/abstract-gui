package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.BoxLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.VerticalContainer;

public class SwingVerticalContainer extends AbstractStackedSwingContainer implements VerticalContainer {

    public SwingVerticalContainer(SwingEnvironment environment) {
        super(environment);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void add(Component component, Object constraint) {
        add(component);
    }

    @Override
    public void add(Component component) {
        AbstractSwingComponent abstractComponent = checkComponent(component);
        java.awt.Component nativeComponent = abstractComponent.getNativeComponent();
        panel.add(nativeComponent);
        registerChild(abstractComponent);
    }

}
