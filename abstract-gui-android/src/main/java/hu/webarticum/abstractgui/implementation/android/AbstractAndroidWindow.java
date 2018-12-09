package hu.webarticum.abstractgui.implementation.android;

import hu.webarticum.abstractgui.core.framework.Container;
import hu.webarticum.abstractgui.core.framework.Dialog;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.text.Text;

public abstract class AbstractAndroidWindow extends AbstractAndroidActor implements Window {

    private Text title;

    private final AbstractAndroidContainer rootContainer;

    AbstractAndroidWindow(
        AndroidEnvironment environment, AbstractAndroidContainer rootContainer, Text title
    ) {
        super(rootContainer.getEnvironment());
        this.title = title;
        this.rootContainer = rootContainer;
    }

    // FIXME
    Text getTitle() {
        return title;
    }

    @Override
    public void open() {
        // XXX
        getEnvironment().setActiveWindow(this);
    }

    @Override
    public void hide() {
        // TODO
    }

    @Override
    public void close() {
        // TODO
    }

    @Override
    public AbstractAndroidContainer getRootContainer() {
        return rootContainer;
    }

    @Override
    public Dialog createDialog(Container container, String title) {
        // TODO
        return null;
    }

    @Override
    public Dialog createDialog(Container container, Text title) {
        // TODO
        return null;
    }

    @Override
    public void refresh() {
        // TODO: title etc.
        rootContainer.refresh();
    }

}
