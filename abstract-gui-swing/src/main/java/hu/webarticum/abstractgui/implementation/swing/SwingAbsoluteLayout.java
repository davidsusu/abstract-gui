package hu.webarticum.abstractgui.implementation.swing;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.JPanel;

import hu.webarticum.abstractgui.core.framework.AbsoluteLayout;
import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Metrics;
import hu.webarticum.abstractgui.core.framework.Panel;

public class SwingAbsoluteLayout extends AbstractSwingLayout implements AbsoluteLayout {
    
    SwingAbsoluteLayout(SwingEnvironment environment) {
        super(environment);
    }
    
    @Override
    public void add(Panel panel, Component component) {
        add(panel, component, new Metrics(0, 0));
    }

    @Override
    public void add(Panel panel, Component component, Object constraint) {
        checkComponents(panel, component);
        int left = 0;
        int top = 0;
        if (constraint instanceof Metrics) {
            Metrics metrics = (Metrics)constraint;
            left = metrics.x;
            top = metrics.y;
        } else if (constraint instanceof Point) {
            Point point = (Point)constraint;
            left = point.x;
            top = point.y;
        }
        JPanel nativePanel = ((SwingPanel)panel).getNativeComponent();
        java.awt.Component nativeComponent = ((AbstractSwingComponent)component).getNativeComponent();
        Dimension preferredSize = nativeComponent.getPreferredSize();
        nativePanel.add(nativeComponent);
        nativeComponent.setBounds(left, top, preferredSize.width, preferredSize.height);
    }

    @Override
    public LayoutManager getNativeLayout() {
        return null;
    }

}
