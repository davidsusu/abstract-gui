package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.LayoutManager;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.LinearLayout;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaLinearLayout extends AbstractLanternaLayout implements LinearLayout {
    
    private final com.googlecode.lanterna.gui2.LinearLayout linearLayout;
    
    LanternaLinearLayout(LanternaEnvironment environment, LinearLayout.Direction direction) {
        super(environment);
        
        com.googlecode.lanterna.gui2.Direction lanternaDirection =
            direction == LinearLayout.Direction.HORIZONTAL ?
            com.googlecode.lanterna.gui2.Direction.HORIZONTAL :
            com.googlecode.lanterna.gui2.Direction.VERTICAL
        ;
        this.linearLayout = new com.googlecode.lanterna.gui2.LinearLayout(lanternaDirection);
    }

    @Override
    public void add(Panel panel, Component component) {
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
        return linearLayout;
    }

}
