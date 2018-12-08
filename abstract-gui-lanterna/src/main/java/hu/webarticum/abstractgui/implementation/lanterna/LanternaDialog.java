package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.Dialog;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class LanternaDialog extends AbstractLanternaWindow implements Dialog {

    private final AbstractLanternaWindow parent;
    
    private final boolean modal;
    
    LanternaDialog(
        AbstractLanternaWindow parent, boolean modal,
        AbstractLanternaContainer rootContainer, String title
    ) {
        this(parent, modal, rootContainer, new PlainText(title));
    }
    
    LanternaDialog(
        AbstractLanternaWindow parent, boolean modal,
        AbstractLanternaContainer rootContainer, Text titleContent
    ) {
        super(parent.getEnvironment(), rootContainer, titleContent);
        this.parent = parent;
        this.modal = modal;
    }

    @Override
    public boolean isModal() {
        return modal;
    }

    @Override
    public AbstractLanternaWindow getParent() {
        return parent;
    }
    
    // TODO: handle dialog specific things
    
}
