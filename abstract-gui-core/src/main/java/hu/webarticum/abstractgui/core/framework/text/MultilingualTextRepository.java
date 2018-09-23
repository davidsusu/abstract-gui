package hu.webarticum.abstractgui.core.framework.text;

import java.util.Locale;

public interface MultilingualTextRepository extends TextRepository {

	public LocalizedText get(Object key);

	public LocalizedText get(Object key, Locale locale);
	
	public Locale getDefaultLocale();

}
