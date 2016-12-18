package hu.webarticum.abstract_gui.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.Panel;

public class SwingPanel extends AbstractSwingComponent implements Panel {
    
    private final JPanel panel;
    
    private AbstractSwingLayout layout;

    private List<AbstractSwingComponent> children = new ArrayList<AbstractSwingComponent>();
    
    SwingPanel(SwingEnvironment environment, AbstractSwingLayout layout) {
        super(environment);
        this.panel = new JPanel(layout.getNativeLayout());
        this.layout = layout;
    }

    @Override
    public void setLayout(Layout layout) {
        if (!(layout instanceof AbstractSwingLayout)) {
            throw new IllegalArgumentException("Incompatible layout type: " + layout.getClass().getSimpleName());
        }
        AbstractSwingLayout swingLayout = (AbstractSwingLayout)layout;
        panel.setLayout(swingLayout.getNativeLayout());
        this.layout = swingLayout;
    }

    @Override
    public void add(Component component) {
        if (!(component instanceof AbstractSwingComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        layout.add(this, component);
        children.add((AbstractSwingComponent)component);
    }

    @Override
    public void add(Component component, Object constraint) {
        if (!(component instanceof AbstractSwingComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        layout.add(this, component, constraint);
        children.add((AbstractSwingComponent)component);
    }

    @Override
    public void remove(Component component) {
        if (component instanceof AbstractSwingComponent) {
            panel.remove(((AbstractSwingComponent)component).getNativeComponent());
        }
        children.remove(component);
    }

    @Override
    public List<AbstractSwingComponent> getChildren() {
        return new ArrayList<AbstractSwingComponent>(children);
    }

    @Override
    public void refresh() {
        for (AbstractSwingComponent component: children) {
            component.refresh();
        }
    }

    @Override
    public JPanel getNativeComponent() {
        return panel;
    }

}
