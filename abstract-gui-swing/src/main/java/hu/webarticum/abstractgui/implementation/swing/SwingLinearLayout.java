package hu.webarticum.abstractgui.implementation.swing;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.LinearLayout;
import hu.webarticum.abstractgui.core.framework.Panel;

public class SwingLinearLayout extends AbstractSwingLayout implements LinearLayout {
    
    private java.awt.Container nativeContainer = null;
    
    private final LinearLayout.Direction direction;
    
    private BoxLayout boxLayout = null;
    
    SwingLinearLayout(SwingEnvironment environment, LinearLayout.Direction direction) {
        super(environment);
        this.direction = direction;
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
        return boxLayout;
    }

    @Override
    public LayoutManager getNativeLayoutFor(java.awt.Container nativeContainer) {
        if (this.nativeContainer != nativeContainer) {
            this.nativeContainer = nativeContainer;
                int axis = (direction == LinearLayout.Direction.HORIZONTAL) ? BoxLayout.LINE_AXIS : BoxLayout.PAGE_AXIS;
                boxLayout = new BoxLayout(nativeContainer, axis);
        }
        return boxLayout;
    }
    
}
