package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.Frame;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class LanternaFrame extends AbstractLanternaWindow implements Frame {

    LanternaFrame(LanternaEnvironment environment, AbstractLanternaContainer rootContainer, String title) {
        this(environment, rootContainer, new PlainText(title));
    }
    
    LanternaFrame(LanternaEnvironment environment, AbstractLanternaContainer rootContainer, Text titleContent) {
        super(environment, rootContainer, titleContent);
    }
    
}
