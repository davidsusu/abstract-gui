package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.JFrame;

import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class SwingWindow extends AbstractSwingEnvironmentMember implements Window {
    
    private Text titleContent;
    
    private final JFrame frame;
    
    private AbstractSwingContainer rootContainer;

    protected GeneralListenable generalListenable = new GeneralListenable();
    
    SwingWindow(SwingEnvironment environment, AbstractSwingContainer rootContainer, String title) {
        this(environment, rootContainer, new PlainText(title));
    }
    
    SwingWindow(SwingEnvironment environment, AbstractSwingContainer rootContainer, Text titleContent) {
        super(environment);
        this.titleContent = titleContent;
        this.rootContainer = rootContainer;
        frame = new JFrame(titleContent.toString());
        frame.setSize(300, 200); // FIXME: window size
        frame.setContentPane(rootContainer.getNativeComponent());
    }
    
    @Override
    public void open() {
        frame.setVisible(true); 
    }
    
    @Override
    public AbstractSwingContainer getRootContainer() {
        return rootContainer;
    }

    @Override
    public void refresh() {
        frame.setTitle(titleContent.toString());
        rootContainer.refresh();
    }

    @Override
    public void on(Object eventType, EventListener listener) {
        generalListenable.on(eventType, listener);
    }

    @Override
    public void off(Object eventType, EventListener listener) {
        generalListenable.off(eventType, listener);
    }

    @Override
    public void runListeners(Object eventType, Event event) {
        generalListenable.runListeners(eventType, event);
    }

    public JFrame getNativeWindow() {
        return frame;
    }
    
}
