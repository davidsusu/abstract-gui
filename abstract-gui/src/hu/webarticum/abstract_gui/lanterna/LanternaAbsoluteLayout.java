package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.TerminalPosition;

import hu.webarticum.abstract_gui.framework.AbsoluteLayout;
import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Metrics;
import hu.webarticum.abstract_gui.framework.Panel;

public class LanternaAbsoluteLayout extends AbstractLanternaLayout implements AbsoluteLayout {
    
    private final com.googlecode.lanterna.gui2.AbsoluteLayout absoluteLayout;
    
    public LanternaAbsoluteLayout(LanternaEnvironment environment) {
        super(environment);
        
        absoluteLayout = new com.googlecode.lanterna.gui2.AbsoluteLayout();
    }
    
    @Override
    public void add(Panel panel, Component component) {
        add(panel, component, new Metrics(0, 0));
    }

    @Override
    public void add(Panel panel, Component component, Object constraint) {
        checkComponents(panel, component);
        LanternaEnvironment environment = getEnvironment();
        int column = 0;
        int row = 0;
        if (constraint instanceof Metrics) {
            Metrics metrics = (Metrics)constraint;
            column = (int)Math.round((double)metrics.x / environment.getCharacterWidth());
            row = (int)Math.round((double)metrics.y / environment.getCharacterHeight());
        } else if (constraint instanceof TerminalPosition) {
            TerminalPosition terminalPosition = (TerminalPosition)constraint;
            column = terminalPosition.getColumn();
            row = terminalPosition.getRow();
        }
        com.googlecode.lanterna.gui2.Panel nativePanel = ((LanternaPanel)panel).getNativeComponent();
        com.googlecode.lanterna.gui2.Component nativeComponent = ((AbstractLanternaComponent)component).getNativeComponent();
        nativePanel.addComponent(nativeComponent);
        nativeComponent.setPosition(new TerminalPosition(column, row));
        nativeComponent.setSize(nativeComponent.getPreferredSize());
    }

    @Override
    public com.googlecode.lanterna.gui2.AbsoluteLayout getNativeLayout() {
        return absoluteLayout;
    }

}
