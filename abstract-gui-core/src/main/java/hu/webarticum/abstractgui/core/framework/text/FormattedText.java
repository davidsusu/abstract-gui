package hu.webarticum.abstractgui.core.framework.text;

import java.util.Locale;

import hu.webarticum.abstractgui.core.util.HtmlUtil;

public class FormattedText implements LocalizedText {

	private final Text formatText;
	
	private final Object[] arguments;
	
	private final Localized localized;
	
	
	public FormattedText(String format, Object... arguments) {
		this(new PlainText(format), arguments);
	}

	public FormattedText(Text format, Object... arguments) {
		this.formatText = format;
		this.arguments = arguments;
		
		Localized localized = null;
		if (format instanceof Localized) {
			localized = (Localized) format;
		} else {
			for (Object argument : arguments) {
				if (argument instanceof Localized) {
					localized = (Localized) argument;
					break;
				}
			}
		}
		this.localized = localized;
	}
	
	
	@Override
	public String toHtml() {
		Object[] sourceViews = new Object[arguments.length];
		for (int i = 0; i < arguments.length; i++) {
			if (arguments[i] instanceof Text) {
				sourceViews[i] = new HtmlSourceView((Text) arguments[i]);
			} else if (isFormattable(arguments[i])) {
				sourceViews[i] = arguments[i];
			} else {
				sourceViews[i] = new PlainText(HtmlUtil.textToHtml(arguments[i].toString()));
			}
		}
		return format(formatText.toString(), sourceViews);
	}
	
	private boolean isFormattable(Object object) {
		if (object instanceof Number) {
			return true;
		}
		
		if (object instanceof Boolean) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return format(formatText.toHtml(), arguments);
	}

	private String format(String format, Object[] argumentObjects) {
		Locale locale = getLocale();
		if (locale != null) {
			return String.format(locale, format, argumentObjects);
		} else {
			return String.format(format, argumentObjects);
		}
	}
	
	@Override
	public Locale getLocale() {
		return localized != null ? localized.getLocale() : null;
	}

	@Override
	public boolean isPlain() {
		return formatText.isPlain();
	}

}
