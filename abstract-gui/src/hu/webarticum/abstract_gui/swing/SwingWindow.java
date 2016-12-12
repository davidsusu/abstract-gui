package hu.webarticum.abstract_gui.swing;

import javax.swing.JFrame;

import hu.webarticum.abstract_gui.framework.Window;

public class SwingWindow extends AbstractSwingEnvironmentMember implements Window {
    
    private final JFrame frame;
    
    private SwingPanel rootPanel;
    
    SwingWindow(SwingEnvironment environment, String title) {
        super(environment);
        
        frame = new JFrame(title);
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
        rootPanel.refresh();
    }
    
    public JFrame getNativeWindow() {
        return frame;
    }
    
}
