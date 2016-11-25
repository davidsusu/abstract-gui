package hu.webarticum.abstract_gui.swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.TestWindow;

public class SwingTestWindow extends AbstractSwingComponent implements TestWindow {
    
    private JFrame frame;
    
    SwingTestWindow(SwingEnvironment environment, String title) {
        super(environment);
        
        frame = new JFrame(title);
        frame.setSize(300, 200);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
    }
    
    @Override
    public void open() {
        frame.setVisible(true); 
    }

	@Override
	public void setInnerComponent(Component component) {
		if (!(component instanceof AbstractSwingComponent)) {
			throw new IllegalArgumentException("Incompatible component type: " + component.getClass().getSimpleName());
		}
		java.awt.Component nativeComponent = ((AbstractSwingComponent)component).getNativeComponent();
		frame.getContentPane().add(nativeComponent, BorderLayout.CENTER);
	}

	@Override
	public java.awt.Component getNativeComponent() {
		return frame;
	}
    
}
