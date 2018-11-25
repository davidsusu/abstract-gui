package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.gui2.AbsoluteLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.FreeContainer;
import hu.webarticum.abstractgui.core.framework.Metrics;

public class LanternaFreeContainer extends AbstractLanternaContainer implements FreeContainer {

    public LanternaFreeContainer(LanternaEnvironment environment) {
        super(environment);
        panel.setLayoutManager(new AbsoluteLayout());
    }

    @Override
    public void add(Component component, Object constraint) {
        Metrics metrics = constraint instanceof Metrics ? (Metrics) constraint : new Metrics(0, 0);
        addAt(component, metrics);
    }
    
    public void addAt(Component component, Metrics metrics) {
        AbstractLanternaComponent abstractComponent = checkComponent(component);
        com.googlecode.lanterna.gui2.Component nativeComponent = ((AbstractLanternaComponent)component).getNativeComponent();
        panel.addComponent(nativeComponent);
        int column = (int)Math.round((double)metrics.x / getEnvironment().getCharacterWidth());
        int row = (int)Math.round((double)metrics.y / getEnvironment().getCharacterHeight());
        nativeComponent.setPosition(new TerminalPosition(column, row));
        nativeComponent.setSize(nativeComponent.getPreferredSize());
        children.add(abstractComponent);
    }
    
}
