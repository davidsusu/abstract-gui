package hu.webarticum.abstract_gui.lanterna;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.lanterna.gui2.LayoutManager;

import hu.webarticum.abstract_gui.framework.BorderLayout;
import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaBorderLayout extends AbstractLanternaLayout implements BorderLayout {
    
    private final com.googlecode.lanterna.gui2.BorderLayout borderLayout;
    
    private Map<Object, com.googlecode.lanterna.gui2.BorderLayout.Location> nativeConstantMap =
        new HashMap<Object, com.googlecode.lanterna.gui2.BorderLayout.Location>()
    ;
    {
        nativeConstantMap.put(Location.TOP, com.googlecode.lanterna.gui2.BorderLayout.Location.TOP);
        nativeConstantMap.put(Location.LEFT, com.googlecode.lanterna.gui2.BorderLayout.Location.LEFT);
        nativeConstantMap.put(Location.CENTER, com.googlecode.lanterna.gui2.BorderLayout.Location.CENTER);
        nativeConstantMap.put(Location.RIGHT, com.googlecode.lanterna.gui2.BorderLayout.Location.RIGHT);
        nativeConstantMap.put(Location.BOTTOM, com.googlecode.lanterna.gui2.BorderLayout.Location.BOTTOM);
    }
    
    LanternaBorderLayout(LanternaEnvironment environment) {
        super(environment);
        
        borderLayout = new com.googlecode.lanterna.gui2.BorderLayout();
    }
    
    @Override
    public void add(Panel panel, Component component) {
        add(panel, component, Location.CENTER);
    }

    @Override
    public void add(Panel panel, Component component, Object constraint) {
        checkComponents(panel, component);
        com.googlecode.lanterna.gui2.Panel nativePanel = ((LanternaPanel)panel).getNativeComponent();
        com.googlecode.lanterna.gui2.Component nativeComponent = ((AbstractLanternaComponent)component).getNativeComponent();
        com.googlecode.lanterna.gui2.BorderLayout.Location nativeLayoutArea = nativeConstantMap.get(constraint);
        nativePanel.addComponent(nativeComponent, nativeLayoutArea);
    }

    @Override
    public LayoutManager getNativeLayout() {
        return borderLayout;
    }

}
