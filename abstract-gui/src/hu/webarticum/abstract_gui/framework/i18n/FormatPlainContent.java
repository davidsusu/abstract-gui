package hu.webarticum.abstract_gui.framework.i18n;

import hu.webarticum.abstract_gui.framework.HtmlUtil;
import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;


public class FormatPlainContent implements TextualContent {
    
    final private AbstractTextRepository repository;
    
    final private TextualContent formatContent;
    
    final private Object[] valueContents;

    public FormatPlainContent(String formatString, Object... valueContents) {
        this(null, formatString, valueContents);
    }
    
    public FormatPlainContent(TextualContent formatContent, Object... valueContents) {
        this(null, formatContent, valueContents);
    }

    public FormatPlainContent(AbstractTextRepository repository, String formatString, Object... valueContents) {
        this(new PlainContent(formatString), valueContents);
    }
    
    public FormatPlainContent(AbstractTextRepository repository, TextualContent formatContent, Object... valueContents) {
        this.repository = repository;
        this.formatContent = formatContent;
        this.valueContents = valueContents;
    }

    @Override
    public String toHtml() {
        return HtmlUtil.textToHtml(toString());
    }

    @Override
    public String toString() {
        if (repository == null) {
            return String.format(formatContent.toString(), valueContents);
        } else {
            return String.format(repository.getLocale(), formatContent.toString(), valueContents);
        }
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
