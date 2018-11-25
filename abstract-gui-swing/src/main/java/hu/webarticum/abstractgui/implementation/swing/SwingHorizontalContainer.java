package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.BoxLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.HorizontalContainer;

public class SwingHorizontalContainer extends AbstractSwingContainer implements HorizontalContainer {

    public SwingHorizontalContainer(SwingEnvironment environment) {
        super(environment);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
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
        children.add(abstractComponent);
    }

}
