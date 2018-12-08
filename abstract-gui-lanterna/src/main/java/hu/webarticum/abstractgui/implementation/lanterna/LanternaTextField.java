package hu.webarticum.abstractgui.implementation.lanterna;

import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.input.KeyStroke;

import hu.webarticum.abstractgui.core.framework.TextField;

public class LanternaTextField extends AbstractLanternaComponent implements TextField {
    
    private final CustomTextBox textBox;
    
    LanternaTextField(LanternaEnvironment environment) {
        super(environment);
        
        this.textBox = new CustomTextBox();
    }
    
    @Override
    public void refresh() {
    }

    @Override
    public void setValue(String value) {
        textBox.setText(value);
    }

    @Override
    public String getValue() {
        return textBox.getText();
    }

    @Override
    public Component getNativeComponent() {
        return textBox;
    }
    
    
    // used for fix input handling (do not write anything while ctrl is down)
    class CustomTextBox extends TextBox {
        
        @Override
        public synchronized Result handleKeyStroke(KeyStroke keyStroke) {
            if (keyStroke.isCtrlDown()) {
                return Result.UNHANDLED;
            }
            return super.handleKeyStroke(keyStroke);
        }
        
    }

}
