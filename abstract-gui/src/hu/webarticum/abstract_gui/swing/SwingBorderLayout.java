package hu.webarticum.abstract_gui.swing;

import javax.swing.JPanel;

import hu.webarticum.abstract_gui.framework.BorderLayout;
import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Panel;

public class SwingBorderLayout extends AbstractSwingLayout implements BorderLayout {
    
    private final java.awt.BorderLayout borderLayout;
    
    private String[] nativeConstants = {
        java.awt.BorderLayout.PAGE_START,
        java.awt.BorderLayout.LINE_START,
        java.awt.BorderLayout.CENTER,
        java.awt.BorderLayout.LINE_END,
        java.awt.BorderLayout.PAGE_END,
    };
    
    SwingBorderLayout(SwingEnvironment environment) {
        super(environment);
        this.borderLayout = new java.awt.BorderLayout();
    }

    @Override
    public java.awt.BorderLayout getNativeLayout() {
        return borderLayout;
    }

    @Override
    public void add(Panel panel, Component component) {
        add(panel, component, AREA_CENTER);
    }

    @Override
    public void add(Panel panel, Component component, int place) {
        if (!(panel instanceof SwingPanel)) {
            throw new IllegalArgumentException("Incompatible panel type: " + panel.getClass().getSimpleName());
        }
        if (!(component instanceof AbstractSwingComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        JPanel nativePanel = ((SwingPanel)panel).getNativeComponent();
        java.awt.Component nativeComponent = ((AbstractSwingComponent)component).getNativeComponent();
        String nativeLayoutArea = nativeConstants[place];
        nativePanel.add(nativeComponent, nativeLayoutArea);
    }
    
}
