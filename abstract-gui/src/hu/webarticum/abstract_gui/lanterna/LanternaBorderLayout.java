package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.LayoutManager;

import hu.webarticum.abstract_gui.framework.BorderLayout;
import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaBorderLayout extends AbstractLanternaLayout implements BorderLayout {
    
    private final com.googlecode.lanterna.gui2.BorderLayout borderLayout;
    
    private com.googlecode.lanterna.gui2.BorderLayout.Location[] nativeConstants = {
        com.googlecode.lanterna.gui2.BorderLayout.Location.TOP,
        com.googlecode.lanterna.gui2.BorderLayout.Location.LEFT,
        com.googlecode.lanterna.gui2.BorderLayout.Location.CENTER,
        com.googlecode.lanterna.gui2.BorderLayout.Location.RIGHT,
        com.googlecode.lanterna.gui2.BorderLayout.Location.BOTTOM,
    };
    
    LanternaBorderLayout(LanternaEnvironment environment) {
        super(environment);
        
        borderLayout = new com.googlecode.lanterna.gui2.BorderLayout();
    }
    
    @Override
    public void add(Panel panel, Component component) {
        add(panel, component, AREA_CENTER);
    }

    @Override
    public void add(Panel panel, Component component, int place) {
        if (!(panel instanceof LanternaPanel)) {
            throw new IllegalArgumentException("Incompatible panel type: " + panel.getClass().getSimpleName());
        }
        if (!(component instanceof AbstractLanternaComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        com.googlecode.lanterna.gui2.Panel nativePanel = ((LanternaPanel)panel).getNativeComponent();
        com.googlecode.lanterna.gui2.Component nativeComponent = ((AbstractLanternaComponent)component).getNativeComponent();
        com.googlecode.lanterna.gui2.BorderLayout.Location nativeLayoutArea = nativeConstants[place];
        nativePanel.addComponent(nativeComponent, nativeLayoutArea);
    }

    @Override
    public LayoutManager getNativeLayout() {
        return borderLayout;
    }

}
