package hu.webarticum.abstractgui.core.framework.text;

import java.util.Locale;

class TextLocalizatorDecorator implements LocalizedText {

	private final Text text;
	
	private final Locale locale;
	
	
	public TextLocalizatorDecorator(Text text, Locale locale) {
		this.text = text;
		this.locale = locale;
	}
	
	
	@Override
	public String toString() {
		return text.toString();
	}

	@Override
	public String toHtml() {
		return text.toHtml();
	}

	@Override
	public boolean isPlain() {
		return text.isPlain();
	}

	@Override
	public Locale getLocale() {
		return locale;
	}
	
	
	
}