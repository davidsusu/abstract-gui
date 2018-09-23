package hu.webarticum.abstractgui.implementation.swing;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import hu.webarticum.abstractgui.core.framework.Button;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class SwingButton extends AbstractSwingComponent implements Button {

    private Text labelContent;
    
    private final JButton button;

    SwingButton(SwingEnvironment environment, String label) {
        this(environment, new PlainText(label));
    }

    SwingButton(SwingEnvironment environment, Text labelContent) {
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
