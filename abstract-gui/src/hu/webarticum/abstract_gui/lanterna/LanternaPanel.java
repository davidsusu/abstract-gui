package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaPanel extends AbstractLanternaComponent implements Panel {
    
    private final com.googlecode.lanterna.gui2.Panel panel;
    
    private AbstractLanternaLayout layout;
    
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
    }

    @Override
    public void add(Component component, int place) {
        if (!(component instanceof AbstractLanternaComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        layout.add(this, component, place);
    }

    @Override
    public void remove(Component component) {
        if (component instanceof AbstractLanternaComponent) {
            panel.removeComponent(((AbstractLanternaComponent)component).getNativeComponent());
        }
    }

    @Override
    public com.googlecode.lanterna.gui2.Panel getNativeComponent() {
        return panel;
    }

}
