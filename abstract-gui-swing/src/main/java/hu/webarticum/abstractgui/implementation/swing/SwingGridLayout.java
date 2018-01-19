package hu.webarticum.abstractgui.implementation.swing;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.GridLayout;
import hu.webarticum.abstractgui.core.framework.Panel;

public class SwingGridLayout extends AbstractSwingLayout implements GridLayout {
    
    private final java.awt.GridLayout gridLayout;
    
    SwingGridLayout(SwingEnvironment environment, int columns) {
        super(environment);
        
        this.gridLayout = new java.awt.GridLayout(0, columns);
    }

    @Override
    public void add(Panel panel, Component component) {
        add(panel, component, null);
    }

    @Override
    public void add(Panel panel, Component component, Object constraint) {
        checkComponents(panel, component);
        JPanel nativePanel = ((SwingPanel)panel).getNativeComponent();
        java.awt.Component nativeComponent = ((AbstractSwingComponent)component).getNativeComponent();
        
        // XXX
        nativePanel.add(nativeComponent);
    }

    @Override
    public LayoutManager getNativeLayout() {
        return gridLayout;
    }
    
}
