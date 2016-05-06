package hu.webarticum.abstract_gui.example;

import javax.swing.JFrame;
import javax.swing.JLabel;

import hu.webarticum.abstract_gui.framework.Frame;

public class SampleFrame implements SampleWindow, Frame {

	protected SampleWindow parent;
	
	protected JFrame frame;
	
	protected SampleContainer container;

	public SampleFrame() {
		this(null);
	}
	
	public SampleFrame(SampleWindow parent) {
		this.parent = parent;
		
		this.frame = new JFrame();
		
		java.awt.Container contentPane = this.frame.getContentPane();
		
		contentPane.add(new JLabel("Valamilyen ablak"));
		
		this.container = new SampleContainer(this, contentPane);
		
		this.frame.validate();
		this.frame.pack();
	}

	public void setTitle(String title) {
		this.frame.setTitle(title);
	}

	public String getTitle() {
		return this.frame.getTitle();
	}

	@Override
	public JFrame getTopFrame() {
		return frame;
	}
	
	@Override
	public SampleWindow getParent() {
		return parent;
	}
	
	@Override
	public SampleDialog createDialog() {
		return new SampleDialog(this);
	}

	@Override
	public void show() {
		frame.setVisible(true);
	}

	@Override
	public void hide() {
		frame.setVisible(false);
	}

	@Override
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}
	
	@Override
	public SampleContainer getContainer() {
		return container;
	}
	
}
