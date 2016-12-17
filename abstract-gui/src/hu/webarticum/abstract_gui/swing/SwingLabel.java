package hu.webarticum.abstract_gui.swing;

import javax.swing.JLabel;

import hu.webarticum.abstract_gui.framework.Label;
import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;

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
