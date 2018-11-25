package hu.webarticum.abstractgui.implementation.swing;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;
import hu.webarticum.abstractgui.core.framework.text.Text;


abstract public class AbstractSwingComponent extends AbstractSwingEnvironmentMember implements Component {

    protected GeneralListenable generalListenable = new GeneralListenable();
    
    AbstractSwingComponent(SwingEnvironment environment) {
        super(environment);
    }
    
    @Override
    public void on(Object eventType, EventListener listener) {
        generalListenable.on(eventType, listener);
    }

    @Override
    public void off(Object eventType, EventListener listener) {
        generalListenable.off(eventType, listener);
    }

    @Override
    public void runListeners(Object eventType, Event event) {
        generalListenable.runListeners(eventType, event);
    }

    protected String contentToLabelString(Text content) {
        if (content.isPlain()) {
            String labelText = content.toString();
            return labelText.matches("^<html") ? " " + labelText : labelText;
        } else {
            return "<html>" + content.toHtml() + "</html>";
        }
    }

    abstract public java.awt.Component getNativeComponent();

}
