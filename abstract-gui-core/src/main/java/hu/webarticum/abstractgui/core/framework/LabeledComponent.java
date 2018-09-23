package hu.webarticum.abstractgui.core.framework;

import hu.webarticum.abstractgui.core.framework.text.Text;

public interface LabeledComponent extends Component {

	public void setLabel(String label);

	public String getLabel();

	public void setText(Text text);

	public Text getText();
    
}
