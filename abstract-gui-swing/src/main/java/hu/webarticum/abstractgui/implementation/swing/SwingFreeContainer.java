package hu.webarticum.abstractgui.implementation.swing;

import java.awt.Dimension;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.FreeContainer;
import hu.webarticum.abstractgui.core.framework.Metrics;

public class SwingFreeContainer extends AbstractSwingContainer implements FreeContainer {

    public SwingFreeContainer(SwingEnvironment environment) {
        super(environment);
        panel.setLayout(null);
    }

    @Override
    public void add(Component component, Object constraint) {
        Metrics metrics = constraint instanceof Metrics ? (Metrics) constraint : new Metrics(0, 0);
        addAt(component, metrics);
    }
    
    public void addAt(Component component, Metrics metrics) {
        AbstractSwingComponent abstractComponent = checkComponent(component);
        java.awt.Component nativeComponent = abstractComponent.getNativeComponent();
        Dimension preferredSize = nativeComponent.getPreferredSize();
        panel.add(nativeComponent);
        nativeComponent.setBounds(metrics.x, metrics.y, preferredSize.width, preferredSize.height);
        children.add(abstractComponent);
    }
    
}
