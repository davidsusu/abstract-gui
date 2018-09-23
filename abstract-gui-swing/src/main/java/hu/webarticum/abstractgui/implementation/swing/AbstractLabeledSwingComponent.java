package hu.webarticum.abstractgui.implementation.swing;

import hu.webarticum.abstractgui.core.framework.LabeledComponent;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public abstract class AbstractLabeledSwingComponent extends AbstractSwingComponent implements LabeledComponent {

	private Text text;
	
	
	protected AbstractLabeledSwingComponent(SwingEnvironment environment, Text text) {
		super(environment);
		this.text = text;
	}
	

	@Override
	public void setLabel(String label) {
		setText(new PlainText(label));
	}

	@Override
	public String getLabel() {
		return getText().toString();
	}

	@Override
	public void setText(Text text) {
		this.text = text;
		refresh();
	}

	@Override
	public Text getText() {
		return text;
	}
    
}
