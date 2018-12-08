package hu.webarticum.abstractgui.implementation.swing;

import javax.swing.JDialog;

import hu.webarticum.abstractgui.core.framework.Dialog;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class SwingDialog extends AbstractSwingWindow implements Dialog {

    private final AbstractSwingWindow parent;
    
    private final boolean modal;
    
    SwingDialog(
        AbstractSwingWindow parent, boolean modal,
        AbstractSwingContainer rootContainer, String title
    ) {
        this(parent, modal, rootContainer, new PlainText(title));
    }
    
    SwingDialog(
        AbstractSwingWindow parent, boolean modal,
        AbstractSwingContainer rootContainer, Text titleContent
    ) {
        super(
            parent.getEnvironment(),
            new JDialog(
                parent.getNativeWindow(),
                modal ? java.awt.Dialog.ModalityType.MODELESS : JDialog.DEFAULT_MODALITY_TYPE
            ),
            rootContainer, titleContent
        );
        this.parent = parent;
        this.modal = modal;
    }

    @Override
    public JDialog getNativeWindow() {
        return (JDialog) super.getNativeWindow();
    }

    @Override
    public boolean isModal() {
        return modal;
    }

    @Override
    public AbstractSwingWindow getParent() {
        return parent;
    }
    
}
