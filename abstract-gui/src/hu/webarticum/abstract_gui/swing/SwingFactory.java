package hu.webarticum.abstract_gui.swing;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.Factory;

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
    public SwingTestWindow createTestWindow(String title) {
        return new SwingTestWindow(environment, title);
    }

	@Override
	public SwingTestButton createTestButton(String label) {
		return new SwingTestButton(environment, label);
	}
    
}
