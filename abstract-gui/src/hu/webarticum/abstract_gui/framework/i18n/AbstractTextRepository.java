package hu.webarticum.abstract_gui.framework.i18n;

import java.util.Locale;

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
    
}
