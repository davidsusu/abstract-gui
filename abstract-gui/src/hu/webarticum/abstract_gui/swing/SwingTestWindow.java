package hu.webarticum.abstract_gui.swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import hu.webarticum.abstract_gui.framework.TestWindow;

public class SwingTestWindow extends AbstractComponent implements TestWindow {
    
    private JFrame frame;
    
    SwingTestWindow(SwingEnvironment environment, String title) {
        super(environment);
        
        frame = new JFrame(title);
        frame.setSize(300, 200);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JButton("BUTTON"), BorderLayout.CENTER);
    }
    
    @Override
    public void open() {
        frame.setVisible(true); 
    }
    
}
