package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.Component;

import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class LanternaButton extends AbstractLanternaComponent implements Button {
    
    final com.googlecode.lanterna.gui2.Button button;
    
    LanternaButton(LanternaEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    LanternaButton(LanternaEnvironment environment, TextualContent labelContent) {
        super(environment);
        
        button = new com.googlecode.lanterna.gui2.Button(labelContent.toString());
    }

    @Override
    public Component getNativeComponent() {
        return button;
    }
    
}
