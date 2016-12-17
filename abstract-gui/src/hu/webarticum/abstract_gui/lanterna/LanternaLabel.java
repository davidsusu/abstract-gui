package hu.webarticum.abstract_gui.lanterna;

import hu.webarticum.abstract_gui.framework.Label;
import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class LanternaLabel extends AbstractLanternaComponent implements Label {

    private TextualContent labelContent;
    
    private com.googlecode.lanterna.gui2.Label label;

    LanternaLabel(LanternaEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    LanternaLabel(LanternaEnvironment environment, TextualContent labelContent) {
        super(environment);
        
        this.labelContent = labelContent;
        label = new com.googlecode.lanterna.gui2.Label(labelContent.toString());
    }

    @Override
    public void refresh() {
        label.setText(labelContent.toString());
    }

    @Override
    public com.googlecode.lanterna.gui2.Label getNativeComponent() {
        return label;
    }

}
