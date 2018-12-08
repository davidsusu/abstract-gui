package hu.webarticum.abstractgui.implementation.swing;

import hu.webarticum.abstractgui.core.framework.Actor;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;
import hu.webarticum.abstractgui.core.framework.text.Text;

public abstract class AbstractSwingActor extends AbstractSwingEnvironmentMember implements Actor {

    protected GeneralListenable generalListenable = new GeneralListenable();
    
    AbstractSwingActor(SwingEnvironment environment) {
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

}
