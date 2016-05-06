package hu.webarticum.abstract_gui.example;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hu.webarticum.abstract_gui.framework.Dialog;

public class SampleDialog implements SampleWindow, Dialog {
	
	protected SampleWindow parent;
	
	protected JDialog dialog;
	
	protected SampleContainer container;
	
	public SampleDialog(SampleWindow parent) {
		this.parent = parent;
		
		this.dialog = new JDialog(getTopFrame());
		
		java.awt.Container contentPane = this.dialog.getContentPane();
		
		contentPane.add(new JLabel("Valamilyen dialog"));
		
		this.container = new SampleContainer(this, contentPane);
		
		this.dialog.validate();
		this.dialog.pack();
	}

	public void setTitle(String title) {
		this.dialog.setTitle(title);
	}

	public String getTitle() {
		return this.dialog.getTitle();
	}

	@Override
	public JFrame getTopFrame() {
		if (parent!=null) {
			return parent.getTopFrame();
		} else {
			return null;
		}
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
		dialog.setVisible(true);
	}

	@Override
	public void hide() {
		dialog.setVisible(false);
	}

	@Override
	public void close() {
		dialog.setVisible(false);
		dialog.dispose();
	}
	
	@Override
	public SampleContainer getContainer() {
		return container;
	}
	
}
