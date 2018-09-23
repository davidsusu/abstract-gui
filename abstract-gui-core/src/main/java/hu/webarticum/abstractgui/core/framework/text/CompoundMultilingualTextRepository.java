package hu.webarticum.abstractgui.core.framework.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CompoundMultilingualTextRepository implements MultilingualTextRepository {

	private final Locale defaultLocale;
	
	private final boolean allowOtherLanguages;
	
	private final boolean allowAnyLanguages;

	private final LocalizedText defaultText;
	
	List<MultilingualTextRepository> repositories = new ArrayList<MultilingualTextRepository>();
	

	public CompoundMultilingualTextRepository() {
		this(Locale.getDefault());
	}

	public CompoundMultilingualTextRepository(Locale defaultLocale) {
		this(defaultLocale, null);
	}

	public CompoundMultilingualTextRepository(Locale defaultLocale, LocalizedText defaultText) {
		this(defaultLocale, true, false, defaultText);
	}

	public CompoundMultilingualTextRepository(
		Locale defaultLocale, boolean allowOtherLanguages, boolean allowAnyLanguages, LocalizedText defaultText
	) {
		this.defaultLocale = defaultLocale;
		this.allowOtherLanguages = allowOtherLanguages;
		this.allowAnyLanguages = allowAnyLanguages;
		this.defaultText = defaultText;
	}


	@Override
	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public void add(MultilingualTextRepository repository) {
		repositories.add(repository);
	}
	
	@Override
	public LocalizedText get(Object key) {
		return get(key, defaultLocale);
	}

	@Override
	public LocalizedText get(Object key, Locale locale) {
		LocalizedText bestFound = null;

		boolean foundDefault = false;
		for (MultilingualTextRepository repository : repositories) {
			LocalizedText localizedText = repository.get(key, locale);
			if (localizedText != null) {
				Locale textLocale = localizedText.getLocale();
				if (textLocale.equals(locale)) {
					return localizedText;
				} else if (allowOtherLanguages && !foundDefault) {
					boolean isDefault = textLocale.equals(defaultLocale);
					if (isDefault || (allowAnyLanguages && bestFound == null)) {
						bestFound = localizedText;
						if (isDefault) {
							foundDefault = true;
						}
					}
				}
			}
		}
		
		return (bestFound != null) ? bestFound : defaultText;
	}

}
