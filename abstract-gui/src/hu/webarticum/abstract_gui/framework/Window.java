package hu.webarticum.abstract_gui.framework;

public interface Window extends Component {
	
	public Dialog createDialog();

	public void setTitle(String title);

	public String getTitle();
	
	public void show();

	public void hide();

	public void close();
	
	public Container getContainer();
	
}
