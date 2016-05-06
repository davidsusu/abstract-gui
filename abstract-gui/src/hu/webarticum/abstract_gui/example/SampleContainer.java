package hu.webarticum.abstract_gui.example;

import hu.webarticum.abstract_gui.framework.Component;
import hu.webarticum.abstract_gui.framework.Container;

public class SampleContainer implements Container {
	
	private Component parent;
	
	private java.awt.Container component;
	
	public SampleContainer(Component parent, java.awt.Container component) {
		this.parent = parent;
		this.component = component;
	}
	
	@Override
	public Component getParent() {
		return parent;
	}

}
