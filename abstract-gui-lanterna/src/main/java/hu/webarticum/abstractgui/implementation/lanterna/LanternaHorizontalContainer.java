package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.LinearLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.HorizontalContainer;

public class LanternaHorizontalContainer extends AbstractLanternaContainer implements HorizontalContainer {

    LanternaHorizontalContainer(LanternaEnvironment environment) {
        super(environment);
        panel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
    }

    @Override
    public void add(Component component, Object constraint) {
        add(component);
    }

    @Override
    public void add(Component component) {
        AbstractLanternaComponent abstractComponent = checkComponent(component);
        com.googlecode.lanterna.gui2.Component nativeComponent = abstractComponent.getNativeComponent();
        panel.addComponent(nativeComponent);
        children.add(abstractComponent);
    }

}
