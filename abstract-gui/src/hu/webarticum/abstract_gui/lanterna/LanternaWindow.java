package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;

import hu.webarticum.abstract_gui.framework.Event;
import hu.webarticum.abstract_gui.framework.EventListener;
import hu.webarticum.abstract_gui.framework.GeneralListenable;
import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;
import hu.webarticum.abstract_gui.framework.Window;

public class LanternaWindow extends AbstractLanternaEnvironmentMember implements Window {

    private TextualContent titleContent;
    
    private boolean isAttachedToScreen = false;
    
    private BasicWindow basicWindow = null;
    
    private LanternaPanel rootPanel;
    
    protected GeneralListenable generalListenable = new GeneralListenable();
    
    LanternaWindow(LanternaEnvironment environment, String title) {
        this(environment, new PlainContent(title));
    }
    
    LanternaWindow(LanternaEnvironment environment, TextualContent titleContent) {
        super(environment);
        
        this.titleContent = titleContent;
        rootPanel = environment.getFactory().createPanel();
    }
    
    @Override
    public void open() {
        if (!isAttachedToScreen) {
            MultiWindowTextGUI gui = getEnvironment().getGui();
            basicWindow = getNativeWindow();
            gui.addWindowAndWait(basicWindow);
            
            isAttachedToScreen = true;
        } else {
            basicWindow.setVisible(true);
        }
    }

    @Override
    public LanternaPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void refresh() {
        basicWindow.setTitle(titleContent.toString());
        rootPanel.refresh();
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

    public BasicWindow getNativeWindow() {
        if (basicWindow == null) {
            basicWindow = new BasicWindow(titleContent.toString());
            basicWindow.setComponent(rootPanel.getNativeComponent());
        }
        return basicWindow;
    }

}
