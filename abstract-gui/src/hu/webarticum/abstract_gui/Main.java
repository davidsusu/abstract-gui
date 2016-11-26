package hu.webarticum.abstract_gui;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.HtmlContent;
import hu.webarticum.abstract_gui.framework.TestButton;
import hu.webarticum.abstract_gui.framework.TestWindow;
import hu.webarticum.abstract_gui.swing.SwingEnvironment;

public class Main {
    
    public static void main(String[] args) {
    	Environment environment = new SwingEnvironment();
        Factory factory = environment.getFactory();
        TestWindow testWindow = factory.createTestWindow("This is a window!");
        TestButton testButton = factory.createTestButton(new HtmlContent("<u>H</u><i>ello</i>, <b>HTML</b>!"));
        testWindow.setInnerComponent(testButton);
        testWindow.open();
    }
    
}
