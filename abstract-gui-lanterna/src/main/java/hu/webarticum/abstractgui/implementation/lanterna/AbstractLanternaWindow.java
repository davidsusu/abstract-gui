package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Component;

import hu.webarticum.abstractgui.core.framework.Container;
import hu.webarticum.abstractgui.core.framework.Dialog;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class AbstractLanternaWindow extends AbstractLanternaActor implements Window {

    private CustomBasicWindow window = null;
    
    private final Text titleContent;

    private final AbstractLanternaContainer rootContainer;

    private boolean isAttachedToScreen = false;
    
    AbstractLanternaWindow(
        LanternaEnvironment environment, AbstractLanternaContainer rootContainer, Text titleContent
    ) {
        super(environment);
        this.titleContent = titleContent;
        this.rootContainer = rootContainer;
    }

    @Override
    public void open() {
        if (!isAttachedToScreen) {
            getEnvironment().getGui().addWindow(getNativeWindow());
            isAttachedToScreen = true;
        } else {
            window.setVisible(true);
        }
    }
    
    @Override
    public void hide() {
        window.setVisible(false);
    }
    
    @Override
    public void close() {
        window.setVisible(false);
    }

    @Override
    public AbstractLanternaContainer getRootContainer() {
        return rootContainer;
    }

    @Override
    public void refresh() {
        window.setTitle(titleContent.toString());
        rootContainer.refresh();
    }
    
    @Override
    public Dialog createDialog(Container container, String title) {
        return createDialog(container, new PlainText(title));
    }
    
    @Override
    public Dialog createDialog(Container container, Text title) {
        // TODO
        return null;
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
    
    public CustomBasicWindow getNativeWindow() {
        // FIXME: currently it works only with lazy initialization
        if (window == null) {
            window = new CustomBasicWindow(
                titleContent.toString(),
                rootContainer.getNativeComponent()
            );
        }
        return window;
    }
    
    
    // used for handling window focus
    class CustomBasicWindow extends BasicWindow {
        
        CustomBasicWindow(String title, Component component) {
            super(title);
            setComponent(component);
        }
        
        AbstractLanternaWindow getWrapper() {
            return AbstractLanternaWindow.this;
        }
        
    }
    
}
