package hu.webarticum.abstract_gui.swing;

import java.awt.Component;

import javax.swing.JButton;

import hu.webarticum.abstract_gui.framework.TestButton;

public class SwingTestButton extends AbstractSwingComponent implements TestButton {
	
	final JButton button;
	
	SwingTestButton(SwingEnvironment environment, String label) {
		super(environment);
		this.button = new JButton(label);
	}

	@Override
	public Component getNativeComponent() {
		return button;
	}
	
}
