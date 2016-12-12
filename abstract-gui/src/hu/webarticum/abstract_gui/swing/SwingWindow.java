package hu.webarticum.abstract_gui.swing;

import javax.swing.JFrame;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;
import hu.webarticum.abstract_gui.framework.Window;

public class SwingWindow extends AbstractSwingEnvironmentMember implements Window {
    
    private TextualContent titleContent;
    
    private final JFrame frame;
    
    private SwingPanel rootPanel;

    SwingWindow(SwingEnvironment environment, String title) {
        this(environment, new PlainContent(title));
    }
    
    SwingWindow(SwingEnvironment environment, TextualContent titleContent) {
        super(environment);
        
        this.titleContent = titleContent;
        frame = new JFrame(titleContent.toString());
        frame.setSize(300, 200);
        rootPanel = environment.getFactory().createPanel();
        frame.setContentPane(rootPanel.getNativeComponent());
    }
    
    @Override
    public void open() {
        frame.setVisible(true); 
    }
    
    @Override
    public SwingPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void refresh() {
        frame.setTitle(titleContent.toString());
        rootPanel.refresh();
    }
    
    public JFrame getNativeWindow() {
        return frame;
    }
    
}
