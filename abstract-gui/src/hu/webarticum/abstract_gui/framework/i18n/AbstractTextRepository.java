package hu.webarticum.abstract_gui.framework.i18n;

import java.util.Locale;

import hu.webarticum.abstract_gui.framework.TextualContent;

abstract public class AbstractTextRepository {
    
    abstract public String getText(Object key);

    abstract public Locale getLocale();

    abstract public void setLocale(Locale locale);

    public MlPlainContent createMlPlainContent(Object key) {
        return new MlPlainContent(this, key);
    }

    public MlHtmlContent createMlHtmlContent(Object key) {
        return new MlHtmlContent(this, key);
    }

    public FormatPlainContent createFormatPlainContent(String formatString, Object... valueContents) {
        return new FormatPlainContent(this, formatString, valueContents);
    }

    public FormatPlainContent createFormatPlainContent(TextualContent formatContent, Object... valueContents) {
        return new FormatPlainContent(this, formatContent, valueContents);
    }

    public FormatHtmlContent createFormatHtmlContent(String formatString, Object... valueContents) {
        return new FormatHtmlContent(this, formatString, valueContents);
    }

    public FormatHtmlContent createFormatHtmlContent(TextualContent formatContent, Object... valueContents) {
        return new FormatHtmlContent(this, formatContent, valueContents);
    }
    
}
