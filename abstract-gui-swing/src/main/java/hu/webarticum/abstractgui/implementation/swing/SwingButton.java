package hu.webarticum.abstractgui.implementation.swing;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import hu.webarticum.abstractgui.core.framework.Button;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.PlainContent;
import hu.webarticum.abstractgui.core.framework.TextualContent;

public class SwingButton extends AbstractSwingComponent implements Button {

    private TextualContent labelContent;
    
    private final JButton button;

    SwingButton(SwingEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    SwingButton(SwingEnvironment environment, TextualContent labelContent) {
        super(environment);
        
        this.labelContent = labelContent;
        this.button = new JButton(contentToLabelString(labelContent));
        this.button.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                generalListenable.runListeners(Event.Type.ACTION, new Event(Event.Type.ACTION, button));
            }
            
        });
    }

    @Override
    public void refresh() {
        button.setText(contentToLabelString(labelContent));
    }

    @Override
    public JButton getNativeComponent() {
        return button;
    }
    
}
