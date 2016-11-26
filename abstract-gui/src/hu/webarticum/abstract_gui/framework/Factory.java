package hu.webarticum.abstract_gui.framework;


public interface Factory extends EnvironmentMember {

    public TestWindow createTestWindow(String title);

    public TestButton createTestButton(String label);

    public TestButton createTestButton(TextualContent labelContent);
    
}
