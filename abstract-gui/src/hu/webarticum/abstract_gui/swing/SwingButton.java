package hu.webarticum.abstract_gui.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.ActionListener;
import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class SwingButton extends AbstractSwingComponent implements Button {

    private TextualContent labelContent;
    
    private List<ActionListener> actionListeners = new ArrayList<ActionListener>();
    
    private final JButton button;

    SwingButton(SwingEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    SwingButton(SwingEnvironment environment, TextualContent labelContent) {
        super(environment);
        
        this.labelContent = labelContent;
        if (labelContent.isPlain()) {
            String labelText = labelContent.toString();
            this.button = new JButton(labelText.matches("^<html") ? " " + labelText : labelText);
        } else {
            this.button = new JButton("<html>" + labelContent.toHtml() + "</html>");
        }
        this.button.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener actionListener: actionListeners) {
                    actionListener.actionPerformed();
                }
            }
            
        });
    }

    @Override
    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }

    @Override
    public void removeActionListener(ActionListener actionListener) {
        actionListeners.remove(actionListener);
    }

    @Override
    public void refresh() {
        if (labelContent.isPlain()) {
            String labelText = labelContent.toString();
            button.setText(labelText.matches("^<html") ? " " + labelText : labelText);
        } else {
            button.setText("<html>" + labelContent.toHtml() + "</html>");
        }
    }

    @Override
    public Component getNativeComponent() {
        return button;
    }
    
}
