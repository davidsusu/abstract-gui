package hu.webarticum.abstractgui.implementation.swing;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import hu.webarticum.abstractgui.core.framework.BorderLayout;
import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Panel;

public class SwingBorderLayout extends AbstractSwingLayout implements BorderLayout {
    
    private final java.awt.BorderLayout borderLayout;

    private Map<Object, String> nativeConstantMap = new HashMap<Object, String>();
    {
        nativeConstantMap.put(Location.TOP, java.awt.BorderLayout.PAGE_START);
        nativeConstantMap.put(Location.LEFT, java.awt.BorderLayout.LINE_START);
        nativeConstantMap.put(Location.CENTER, java.awt.BorderLayout.CENTER);
        nativeConstantMap.put(Location.RIGHT, java.awt.BorderLayout.LINE_END);
        nativeConstantMap.put(Location.BOTTOM, java.awt.BorderLayout.PAGE_END);
    }
    
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
        add(panel, component, Location.CENTER);
    }

    @Override
    public void add(Panel panel, Component component, Object constraint) {
        checkComponents(panel, component);
        JPanel nativePanel = ((SwingPanel)panel).getNativeComponent();
        java.awt.Component nativeComponent = ((AbstractSwingComponent)component).getNativeComponent();
        String nativeLayoutArea = nativeConstantMap.get(constraint);
        nativePanel.add(nativeComponent, nativeLayoutArea);
    }
    
}
