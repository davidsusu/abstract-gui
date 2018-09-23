package hu.webarticum.abstractgui.core.framework.text;

import java.util.Locale;

public class LocalizedMultilingualTextRepository implements LocalizedTextRepository, MultilingualTextRepository {

	private final MultilingualTextRepository multilingualTextRepository;
	
	private Locale currentLocale;
	
	
	public LocalizedMultilingualTextRepository(MultilingualTextRepository multilingualTextRepository) {
		this.multilingualTextRepository = multilingualTextRepository;
		this.currentLocale = multilingualTextRepository.getDefaultLocale();
	}


	@Override
	public Locale getDefaultLocale() {
		return multilingualTextRepository.getDefaultLocale();
	}

	public void setLocale(Locale locale) {
		this.currentLocale = locale;;
	}

	@Override
	public Locale getLocale() {
		return currentLocale;
	}
	
	@Override
	public LocalizedText get(Object key) {
		return multilingualTextRepository.get(key, currentLocale);
	}

	@Override
	public LocalizedText get(Object key, Locale locale) {
		return multilingualTextRepository.get(key, locale);
	}
	
	public DynamicLocalizedRepositoryText getDynamic(Object key) {
		return new DynamicLocalizedRepositoryText(this, key);
	}
	
}
