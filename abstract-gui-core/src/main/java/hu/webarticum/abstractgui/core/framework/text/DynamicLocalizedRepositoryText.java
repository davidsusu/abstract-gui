package hu.webarticum.abstractgui.core.framework.text;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DynamicLocalizedRepositoryText implements LocalizedText {

	private final LocalizedTextRepository repository;

	private final Object key;
	
	private Map<Locale, LocalizedText> cache = new HashMap<Locale, LocalizedText>();
	
	
	public DynamicLocalizedRepositoryText(LocalizedTextRepository repository, Object key) {
		this.repository = repository;
		this.key = key;
	}
	

	public LocalizedTextRepository getRepository() {
		return repository;
	}
	
	@Override
	public String toString() {
		return getText().toString();
	}

	@Override
	public String toHtml() {
		return getText().toHtml();
	}

	@Override
	public boolean isPlain() {
		return getText().isPlain();
	}

	@Override
	public Locale getLocale() {
		return getText().getLocale();
	}
	
	private LocalizedText getText() {
		Locale locale = repository.getLocale();
		
		if (cache.containsKey(locale)) {
			return cache.get(locale);
		}
		
		LocalizedText text = repository.get(key);
		if (text == null) {
			text = new TextLocalizatorDecorator(new PlainText(""), locale);
		}
		
		cache.put(locale, text);
		
		return text;
	}
	
}
