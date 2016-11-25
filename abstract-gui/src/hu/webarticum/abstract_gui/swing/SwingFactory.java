package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.TestWindow;

public class SwingFactory implements Factory {
    
    final SwingEnvironment environment;
    
    SwingFactory(SwingEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public TestWindow createTestWindow(String title, String buttonLabel) {
        return new SwingTestWindow(environment, title, buttonLabel);
    }
    
}
