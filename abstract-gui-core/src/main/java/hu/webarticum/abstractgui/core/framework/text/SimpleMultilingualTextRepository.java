package hu.webarticum.abstractgui.core.framework.text;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SimpleMultilingualTextRepository implements MultilingualTextRepository {

	private final Locale defaultLocale;
	
	private Map<Locale, TextRepository> repositoriesByLocale = new HashMap<Locale, TextRepository>();
	

	public SimpleMultilingualTextRepository() {
		this(Locale.getDefault());
	}

	public SimpleMultilingualTextRepository(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	@Override
	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public void put(Locale locale, TextRepository repository) {
		repositoriesByLocale.put(locale, repository);
	}

	@Override
	public LocalizedText get(Object key) {
		return get(key, defaultLocale);
	}

	@Override
	public LocalizedText get(Object key, Locale locale) {
		Text foundText = null;
		
		if (repositoriesByLocale.containsKey(locale)) {
			foundText = repositoriesByLocale.get(locale).get(key);
		}
		
		if (foundText == null && repositoriesByLocale.containsKey(defaultLocale)) {
			foundText = repositoriesByLocale.get(defaultLocale).get(key);
		}

		if (foundText == null) {
			return null;
		}
		
		return (foundText instanceof LocalizedText) ?
			(LocalizedText) foundText :
			new TextLocalizatorDecorator(foundText, locale)
		;
	}

}
