package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.Component;

import hu.webarticum.abstractgui.core.framework.Button;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class LanternaButton extends AbstractLanternaComponent implements Button {
    
    private Text labelContent;
    
    private final com.googlecode.lanterna.gui2.Button button;
    
    LanternaButton(LanternaEnvironment environment, String label) {
        this(environment, new PlainText(label));
    }

    LanternaButton(LanternaEnvironment environment, Text labelContent) {
        super(environment);
        
        this.labelContent = labelContent;
        button = new com.googlecode.lanterna.gui2.Button(labelContent.toString(), new Runnable() {
            
            @Override
            public void run() {
                generalListenable.runListeners(Event.Type.ACTION, new Event(button, null));
            }
            
        });
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
