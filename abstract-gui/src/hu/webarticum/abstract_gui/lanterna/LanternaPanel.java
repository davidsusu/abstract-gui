package hu.webarticum.abstract_gui.lanterna;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaPanel extends AbstractLanternaComponent implements Panel {
    
    private final com.googlecode.lanterna.gui2.Panel panel;
    
    private AbstractLanternaLayout layout;
    
    private List<AbstractLanternaComponent> children = new ArrayList<AbstractLanternaComponent>();
    
    LanternaPanel(LanternaEnvironment environment, AbstractLanternaLayout layout) {
        super(environment);
        this.panel = new com.googlecode.lanterna.gui2.Panel(layout.getNativeLayout());
        this.layout = layout;
    }
    
    @Override
    public void setLayout(Layout layout) {
        if (!(layout instanceof AbstractLanternaLayout)) {
            throw new IllegalArgumentException("Incompatible layout type: " + layout.getClass().getSimpleName());
        }
        AbstractLanternaLayout lanternaLayout = (AbstractLanternaLayout)layout;
        panel.setLayoutManager(lanternaLayout.getNativeLayout());
        this.layout = lanternaLayout;

    }

    @Override
    public void add(Component component) {
        if (!(component instanceof AbstractLanternaComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        layout.add(this, component);
        children.add((AbstractLanternaComponent)component);
    }

    @Override
    public void add(Component component, int place) {
        if (!(component instanceof AbstractLanternaComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        layout.add(this, component, place);
        children.add((AbstractLanternaComponent)component);
    }

    @Override
    public void remove(Component component) {
        if (component instanceof AbstractLanternaComponent) {
            panel.removeComponent(((AbstractLanternaComponent)component).getNativeComponent());
        }
        children.remove(component);
    }

    @Override
    public List<AbstractLanternaComponent> getChildren() {
        return new ArrayList<AbstractLanternaComponent>(children);
    }

    @Override
    public void refresh() {
        for (AbstractLanternaComponent component: children) {
            component.refresh();
        }
    }

    @Override
    public com.googlecode.lanterna.gui2.Panel getNativeComponent() {
        return panel;
    }

}
