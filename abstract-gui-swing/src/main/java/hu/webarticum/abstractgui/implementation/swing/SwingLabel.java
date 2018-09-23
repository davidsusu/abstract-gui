package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.JLabel;

import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class SwingLabel extends AbstractSwingComponent implements Label {

    private Text labelContent;
    
    private final JLabel label;
    
    SwingLabel(SwingEnvironment environment, String label) {
        this(environment, new PlainText(label));
    }

    SwingLabel(SwingEnvironment environment, Text labelContent) {
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
