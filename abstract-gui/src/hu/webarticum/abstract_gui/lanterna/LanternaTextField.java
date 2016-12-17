package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.TextBox;

import hu.webarticum.abstract_gui.framework.TextField;

public class LanternaTextField extends AbstractLanternaComponent implements TextField {
    
    private final TextBox textBox;
    
    LanternaTextField(LanternaEnvironment environment) {
        super(environment);
        
        this.textBox = new TextBox();
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

}
