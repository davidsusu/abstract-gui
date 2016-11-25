package hu.webarticum.abstract_gui;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.TestButton;
import hu.webarticum.abstract_gui.framework.TestWindow;
import hu.webarticum.abstract_gui.swing.SwingEnvironment;

public class Main {
    
    public static void main(String[] args) {
        Environment environment = new SwingEnvironment();
        Factory factory = environment.getFactory();
        TestWindow testWindow = factory.createTestWindow("This is a window!");
        TestButton testButton = factory.createTestButton("This is a button!");
        testWindow.setInnerComponent(testButton);
        testWindow.open();
    }
    
}
