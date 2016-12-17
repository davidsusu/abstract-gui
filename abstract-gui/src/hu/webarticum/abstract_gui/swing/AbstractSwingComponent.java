package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.TextualContent;


abstract public class AbstractSwingComponent extends AbstractSwingEnvironmentMember implements Component {
    
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
    
    abstract public java.awt.Component getNativeComponent();

}
