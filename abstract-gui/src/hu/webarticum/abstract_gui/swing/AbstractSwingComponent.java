package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Event;
import hu.webarticum.abstract_gui.framework.EventListener;
import hu.webarticum.abstract_gui.framework.GeneralListenable;
import hu.webarticum.abstract_gui.framework.TextualContent;


abstract public class AbstractSwingComponent extends AbstractSwingEnvironmentMember implements Component {

    protected GeneralListenable generalListenable = new GeneralListenable();
    
    AbstractSwingComponent(SwingEnvironment environment) {
        super(environment);
    }
    
    protected String contentToLabelString(TextualContent content) {
        if (content.isPlain()) {
            String labelText = content.toString();
            return labelText.matches("^<html") ? " " + labelText : labelText;
        } else {
            return "<html>" + content.toHtml() + "</html>";
        }
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

    abstract public java.awt.Component getNativeComponent();

}
