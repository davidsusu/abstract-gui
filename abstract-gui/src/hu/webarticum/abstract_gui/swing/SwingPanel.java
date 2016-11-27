package hu.webarticum.abstract_gui.swing;

import javax.swing.JPanel;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Layout;
import hu.webarticum.abstract_gui.framework.Panel;

public class SwingPanel extends AbstractSwingComponent implements Panel {
    
    private final JPanel panel;
    
    private AbstractSwingLayout layout;
    
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
    }

    @Override
    public void add(Component component, int place) {
        if (!(component instanceof AbstractSwingComponent)) {
            throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
        }
        layout.add(this, component, place);
    }

    @Override
    public void remove(Component component) {
        if (component instanceof AbstractSwingComponent) {
            panel.remove(((AbstractSwingComponent)component).getNativeComponent());
        }
    }

    @Override
    public JPanel getNativeComponent() {
        return panel;
    }

}
