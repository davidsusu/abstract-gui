package hu.webarticum.abstract_gui.example;

import hu.webarticum.abstract_gui.framework.Dialog;
import hu.webarticum.abstract_gui.framework.Frame;
import hu.webarticum.abstract_gui.framework.GuiApplication;

public class Main {
	
	public static void main(String[] args) {
		GuiApplication guiApplication = new SampleGuiApplication();
		
		Frame frame = guiApplication.createFrame();
		frame.setTitle("Első ablak");
		frame.show();
		
		Dialog dialog = frame.createDialog();
		dialog.setTitle("Második ablak");
		dialog.show();
	}
	
}
