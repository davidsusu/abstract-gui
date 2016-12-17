package hu.webarticum.abstract_gui.swing;

import javax.swing.JTextField;

import hu.webarticum.abstract_gui.framework.TextField;

public class SwingTextField extends AbstractSwingComponent implements TextField {
    
    private final JTextField textField;
    
    SwingTextField(SwingEnvironment environment) {
        super(environment);
        
        this.textField = new JTextField();
    }
    
    @Override
    public void refresh() {
    }

    @Override
    public void setValue(String value) {
        textField.setText(value);
    }

    @Override
    public String getValue() {
        return textField.getText();
    }

    @Override
    public JTextField getNativeComponent() {
        return textField;
    }

}
