package hu.webarticum.abstractgui.core.framework.text;

public interface LocalizedTextRepository extends TextRepository, Localized {

	public LocalizedText get(Object key);
	
}
