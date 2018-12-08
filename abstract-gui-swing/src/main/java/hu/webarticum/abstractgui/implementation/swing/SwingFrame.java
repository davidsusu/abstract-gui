package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.JFrame;

import hu.webarticum.abstractgui.core.framework.Frame;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class SwingFrame extends AbstractSwingWindow implements Frame {
    
    SwingFrame(SwingEnvironment environment, AbstractSwingContainer rootContainer, String title) {
        this(environment, rootContainer, new PlainText(title));
    }
    
    SwingFrame(SwingEnvironment environment, AbstractSwingContainer rootContainer, Text titleContent) {
        super(environment, new JFrame(), rootContainer, titleContent);
    }

    @Override
    public JFrame getNativeWindow() {
        return (JFrame) super.getNativeWindow();
    }
    
}
