package hu.webarticum.abstractgui.implementation.android;

import hu.webarticum.abstractgui.core.framework.Container;
import hu.webarticum.abstractgui.core.framework.Factory;
import hu.webarticum.abstractgui.core.framework.Frame;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class AndroidFactory implements Factory {

    private final AndroidEnvironment environment;

    public AndroidFactory(AndroidEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public AndroidEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public Frame createFrame(Container rootContainer, String title) {
        return new AndroidFrame(environment, checkContainer(rootContainer), title);
    }

    @Override
    public Frame createFrame(Container rootContainer, Text title) {
        return new AndroidFrame(environment, checkContainer(rootContainer), title);
    }

    private AbstractAndroidContainer checkContainer(Container container) {
        if (!(container instanceof AbstractAndroidContainer)) {
            throw new IllegalArgumentException("Incompatible container type: " + container.getClass().getSimpleName());
        }
        return (AbstractAndroidContainer)container;
    }

    @Override
    public AndroidBorderContainer createBorderContainer() {
        return new AndroidBorderContainer(environment);
    }

    @Override
    public AndroidVerticalContainer createVerticalContainer() {
        return new AndroidVerticalContainer(environment);
    }

    @Override
    public AndroidHorizontalContainer createHorizontalContainer() {
        return new AndroidHorizontalContainer(environment);
    }

    @Override
    public AndroidFreeContainer createFreeContainer() {
        return new AndroidFreeContainer(environment);
    }

    @Override
    public AndroidButton createButton(String label) {
        return new AndroidButton(environment, label);
    }

    @Override
    public AndroidButton createButton(Text text) {
        return new AndroidButton(environment, text);
    }

    @Override
    public AndroidLabel createLabel(String label) {
        return new AndroidLabel(environment, label);
    }

    @Override
    public AndroidLabel createLabel(Text text) {
        return new AndroidLabel(environment, text);
    }

    @Override
    public AndroidTextField createTextField() {
        return new AndroidTextField(environment);
    }

}
