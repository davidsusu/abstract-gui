package hu.webarticum.abstract_gui.lanterna;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.gui2.Component;

import hu.webarticum.abstract_gui.framework.ActionListener;
import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class LanternaButton extends AbstractLanternaComponent implements Button {
    
    private TextualContent labelContent;
    
    private List<ActionListener> actionListeners = new ArrayList<ActionListener>();
    
    private final com.googlecode.lanterna.gui2.Button button;
    
    LanternaButton(LanternaEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    LanternaButton(LanternaEnvironment environment, TextualContent labelContent) {
        super(environment);
        
        this.labelContent = labelContent;
        button = new com.googlecode.lanterna.gui2.Button(labelContent.toString(), new Runnable() {
            
            @Override
            public void run() {
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
        button.setLabel(labelContent.toString());
    }

    @Override
    public Component getNativeComponent() {
        return button;
    }
    
}
