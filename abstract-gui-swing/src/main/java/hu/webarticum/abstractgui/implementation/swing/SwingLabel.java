package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.JLabel;

import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.PlainContent;
import hu.webarticum.abstractgui.core.framework.TextualContent;

public class SwingLabel extends AbstractSwingComponent implements Label {

    private TextualContent labelContent;
    
    private final JLabel label;
    
    SwingLabel(SwingEnvironment environment, String label) {
        this(environment, new PlainContent(label));
    }

    SwingLabel(SwingEnvironment environment, TextualContent labelContent) {
        super(environment);
        
        this.labelContent = labelContent;
        this.label = new JLabel(contentToLabelString(labelContent));
    }
    
    @Override
    public void refresh() {
        label.setText(contentToLabelString(labelContent));
    }

    @Override
    public JLabel getNativeComponent() {
        return label;
    }

}
