package hu.webarticum.abstract_gui.swing;

import java.awt.Component;

import javax.swing.JButton;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class SwingButton extends AbstractSwingComponent implements Button {
    
    final JButton button;

    SwingButton(SwingEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    SwingButton(SwingEnvironment environment, TextualContent labelContent) {
        super(environment);
        if (labelContent.isPlain()) {
            String labelText = labelContent.toString();
            this.button = new JButton(labelText.matches("^<html") ? " " + labelText : labelText);
        } else {
            this.button = new JButton("<html>" + labelContent.toHtml() + "</html>");
        }
    }

    @Override
    public Component getNativeComponent() {
        return button;
    }
    
}