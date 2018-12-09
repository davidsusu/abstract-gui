package hu.webarticum.abstractgui.implementation.android;

import hu.webarticum.abstractgui.core.framework.Frame;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class AndroidFrame extends AbstractAndroidWindow implements Frame {

    AndroidFrame(
        AndroidEnvironment environment, AbstractAndroidContainer rootContainer, String title
    ) {
        this(environment, rootContainer, new PlainText(title));
    }

    AndroidFrame(
            AndroidEnvironment environment, AbstractAndroidContainer rootContainer, Text title
    ) {
        super(environment, rootContainer, title);
    }

}
