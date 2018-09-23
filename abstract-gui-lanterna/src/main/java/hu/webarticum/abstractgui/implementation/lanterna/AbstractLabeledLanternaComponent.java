package hu.webarticum.abstractgui.implementation.lanterna;

import hu.webarticum.abstractgui.core.framework.LabeledComponent;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public abstract class AbstractLabeledLanternaComponent extends AbstractLanternaComponent implements LabeledComponent {

	private Text text;
	
	
	protected AbstractLabeledLanternaComponent(LanternaEnvironment environment, Text text) {
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
