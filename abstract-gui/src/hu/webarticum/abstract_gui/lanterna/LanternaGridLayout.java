package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.LayoutManager;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.GridLayout;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaGridLayout extends AbstractLanternaLayout implements GridLayout {
    
    private final com.googlecode.lanterna.gui2.GridLayout gridLayout;
    
    LanternaGridLayout(LanternaEnvironment environment, int columns) {
        super(environment);
        
        this.gridLayout = new com.googlecode.lanterna.gui2.GridLayout(columns);
    }

    @Override
    public void add(Panel panel, Component component) {
        // TODO Auto-generated method stub
        add(panel, component, null);
    }

    @Override
    public void add(Panel panel, Component component, Object constraint) {
        checkComponents(panel, component);
        com.googlecode.lanterna.gui2.Panel nativePanel = ((LanternaPanel)panel).getNativeComponent();
        com.googlecode.lanterna.gui2.Component nativeComponent = ((AbstractLanternaComponent)component).getNativeComponent();
        
        // XXX
        nativePanel.addComponent(nativeComponent);
    }

    @Override
    public LayoutManager getNativeLayout() {
        return gridLayout;
    }

}
