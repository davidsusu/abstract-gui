package hu.webarticum.abstractgui.implementation.swing;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import hu.webarticum.abstractgui.core.framework.BorderContainer;
import hu.webarticum.abstractgui.core.framework.Component;

public class SwingBorderContainer extends AbstractSwingContainer implements BorderContainer {

    private final Map<Location, String> locations =
            new EnumMap<Location, String>(Location.class);

    private final Map<Location, AbstractSwingComponent> children =
            new EnumMap<Location, AbstractSwingComponent>(Location.class);

    public SwingBorderContainer(SwingEnvironment environment) {
        super(environment);
        panel.setLayout(new BorderLayout());

        locations.put(Location.TOP, BorderLayout.PAGE_START);
        locations.put(Location.LEFT, BorderLayout.LINE_START);
        locations.put(Location.CENTER, BorderLayout.CENTER);
        locations.put(Location.RIGHT, BorderLayout.LINE_END);
        locations.put(Location.BOTTOM, BorderLayout.PAGE_END);
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
        AbstractSwingComponent abstractComponent = checkComponent(component);
        remove(component);
        Location targetLocation = constraint instanceof Location ? (Location)constraint : Location.CENTER;
        java.awt.Component nativeComponent = abstractComponent.getNativeComponent();
        panel.add(nativeComponent, locations.get(targetLocation));
        children.put(targetLocation, abstractComponent);
    }
    
    @Override
    public List<AbstractSwingComponent> getChildren() {
        return new ArrayList<AbstractSwingComponent>(children.values());
    }
    
    @Override
    public void remove(Component component) {
        if (!(component instanceof AbstractSwingComponent)) {
            return;
        }

        AbstractSwingComponent abstractComponent = (AbstractSwingComponent)component;
        java.awt.Component nativeComponent = abstractComponent.getNativeComponent();
        children.values().remove(component);
        panel.remove(nativeComponent);
    }

}
