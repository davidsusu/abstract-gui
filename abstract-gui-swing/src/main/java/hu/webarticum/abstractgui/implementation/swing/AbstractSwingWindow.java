package hu.webarticum.abstractgui.implementation.swing;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.RootPaneContainer;

import hu.webarticum.abstractgui.core.framework.Container;
import hu.webarticum.abstractgui.core.framework.Dialog;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.text.Text;

public abstract class AbstractSwingWindow extends AbstractSwingActor implements Window {

    private final java.awt.Window window;
    
    private final AbstractSwingContainer rootContainer;
    
    private final Text titleContent;

    AbstractSwingWindow(
        SwingEnvironment environment, java.awt.Window window,
        AbstractSwingContainer rootContainer, Text titleContent
    ) {
        super(environment);
        this.window = window;
        this.titleContent = titleContent;
        this.rootContainer = rootContainer;
        applyRootContainer(window, rootContainer);
        applyTitle(window, titleContent);
    }

    @Override
    public void open() {
        window.setVisible(true);
        window.setMinimumSize(new Dimension(400, 300)); // FIXME
        window.pack(); // FIXME
    }

    @Override
    public void hide() {
        window.setVisible(false);
    }

    @Override
    public void close() {
        window.dispose();
    }

    @Override
    public AbstractSwingContainer getRootContainer() {
        return rootContainer;
    }
    
    @Override
    public Dialog createDialog(Container container, String title) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Dialog createDialog(Container container, Text title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refresh() {
        applyTitle(window, titleContent);
        rootContainer.refresh();
    }

    public java.awt.Window getNativeWindow() {
        return window;
    }

    private static void applyRootContainer(java.awt.Window window, AbstractSwingContainer rootContainer) {
        if (window instanceof RootPaneContainer) {
            ((RootPaneContainer) window).setContentPane(rootContainer.getNativeComponent());
        }
    }

    private static void applyTitle(java.awt.Window window, Text title) {
        if (window instanceof java.awt.Dialog) {
            ((java.awt.Dialog) window).setTitle(title.toString());
        } else if (window instanceof Frame) {
            ((Frame) window).setTitle(title.toString());
        }
    }
    
}
