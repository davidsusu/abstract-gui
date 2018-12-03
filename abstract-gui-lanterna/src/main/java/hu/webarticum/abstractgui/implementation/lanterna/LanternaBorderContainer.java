package hu.webarticum.abstractgui.implementation.lanterna;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.googlecode.lanterna.gui2.BorderLayout;

import hu.webarticum.abstractgui.core.framework.BorderContainer;
import hu.webarticum.abstractgui.core.framework.Component;

public class LanternaBorderContainer extends AbstractLanternaContainer implements BorderContainer {

    private final Map<Location, BorderLayout.Location> locations =
            new EnumMap<Location, BorderLayout.Location>(Location.class);

    private final Map<Location, AbstractLanternaComponent> children =
            new EnumMap<Location, AbstractLanternaComponent>(Location.class);

    public LanternaBorderContainer(LanternaEnvironment environment) {
        super(environment);
        panel.setLayoutManager(new BorderLayout());
        
        locations.put(Location.TOP, BorderLayout.Location.TOP);
        locations.put(Location.LEFT, BorderLayout.Location.LEFT);
        locations.put(Location.CENTER, BorderLayout.Location.CENTER);
        locations.put(Location.RIGHT, BorderLayout.Location.RIGHT);
        locations.put(Location.BOTTOM, BorderLayout.Location.BOTTOM);
    }

    @Override
    public void addTop(Component component) {
        add(component, Location.TOP);
    }

    @Override
    public void addLeft(Component component) {
        add(component, Location.LEFT);
    }

    @Override
    public void addCenter(Component component) {
        add(component, Location.CENTER);
    }

    @Override
    public void addRight(Component component) {
        add(component, Location.RIGHT);
    }

    @Override
    public void addBottom(Component component) {
        add(component, Location.BOTTOM);
    }

    @Override
    public void add(Component component, Object constraint) {
        AbstractLanternaComponent abstractComponent = checkComponent(component);
        remove(component);
        Location targetLocation = constraint instanceof Location ? (Location)constraint : Location.CENTER;
        com.googlecode.lanterna.gui2.Component nativeComponent = abstractComponent.getNativeComponent();
        panel.addComponent(nativeComponent, locations.get(targetLocation));
        children.put(targetLocation, abstractComponent);
    }
    
    @Override
    public List<AbstractLanternaComponent> getChildren() {
        return new ArrayList<AbstractLanternaComponent>(children.values());
    }
    
    @Override
    public void remove(Component component) {
        if (!(component instanceof AbstractLanternaComponent)) {
            return;
        }

        AbstractLanternaComponent abstractComponent = (AbstractLanternaComponent)component;
        com.googlecode.lanterna.gui2.Component nativeComponent = abstractComponent.getNativeComponent();
        children.values().remove(component);
        panel.removeComponent(nativeComponent);
    }

}
