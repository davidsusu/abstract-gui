package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;

import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.GeneralListenable;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class LanternaWindow extends AbstractLanternaEnvironmentMember implements Window {

    private final Text titleContent;
    
    private BasicWindow basicWindow;
    
    private AbstractLanternaContainer rootContainer;
    
    protected GeneralListenable generalListenable = new GeneralListenable();

    private boolean isAttachedToScreen = false;
    
    LanternaWindow(LanternaEnvironment environment, AbstractLanternaContainer rootContainer, String title) {
        this(environment, rootContainer, new PlainText(title));
    }
    
    LanternaWindow(LanternaEnvironment environment, AbstractLanternaContainer rootContainer, Text titleContent) {
        super(environment);
        this.titleContent = titleContent;
        this.rootContainer = rootContainer;
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
    public AbstractLanternaContainer getRootContainer() {
        return rootContainer;
    }

    @Override
    public void refresh() {
        basicWindow.setTitle(titleContent.toString());
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
    
    public BasicWindow getNativeWindow() {
        if (basicWindow == null) {
            basicWindow = new BasicWindow(titleContent.toString());
            basicWindow.setComponent(rootContainer.getNativeComponent());
        }
        return basicWindow;
    }
    
}
