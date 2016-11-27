package hu.webarticum.abstract_gui;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.EnvironmentDetector;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.HtmlContent;
import hu.webarticum.abstract_gui.framework.Panel;
import hu.webarticum.abstract_gui.framework.BorderLayout;
import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.Window;

public class Main {
    
    public static void main(String[] args) {
        Environment environment = EnvironmentDetector.getDefaultEnvironment();
        Factory factory = environment.getFactory();
        Window window = factory.createWindow("This is a window!");
        Panel panel = window.getRootPanel();
        
        Button button1 = factory.createButton("Button1");
        Button button2 = factory.createButton("Button2");
        Button button3 = factory.createButton(new HtmlContent("Button3 <i>with</i> <b><u>HTML</u></b>"));
        Button button4 = factory.createButton("Button4");
        Button button5 = factory.createButton("Button5");

        panel.add(button1, BorderLayout.AREA_TOP);
        panel.add(button2, BorderLayout.AREA_LEFT);
        panel.add(button3, BorderLayout.AREA_CENTER);
        panel.add(button4, BorderLayout.AREA_RIGHT);
        panel.add(button5, BorderLayout.AREA_BOTTOM);
        
        window.open();
    }
    
}
