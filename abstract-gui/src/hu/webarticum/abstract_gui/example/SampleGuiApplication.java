package hu.webarticum.abstract_gui.example;

import hu.webarticum.abstract_gui.framework.GuiApplication;
import hu.webarticum.abstract_gui.framework.Window;

public class SampleGuiApplication implements GuiApplication {

	@Override
	public SampleFrame createFrame() {
		return new SampleFrame();
	}

}
