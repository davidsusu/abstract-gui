package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class LanternaLabel extends AbstractLanternaComponent implements Label {

    private Text labelContent;
    
    private com.googlecode.lanterna.gui2.Label label;

    LanternaLabel(LanternaEnvironment environment, String label) {
        this(environment, new PlainText(label));
    }

    LanternaLabel(LanternaEnvironment environment, Text labelContent) {
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
