package hu.webarticum.abstract_gui.swing;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.Event;
import hu.webarticum.abstract_gui.framework.TextualContent;

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
                // XXX
                generalListenable.runListeners("click", new Event());
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
