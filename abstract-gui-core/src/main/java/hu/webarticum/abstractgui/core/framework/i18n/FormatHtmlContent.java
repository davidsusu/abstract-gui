package hu.webarticum.abstractgui.core.framework.i18n;

import hu.webarticum.abstractgui.core.framework.HtmlContent;
import hu.webarticum.abstractgui.core.framework.HtmlUtil;
import hu.webarticum.abstractgui.core.framework.TextualContent;

public class FormatHtmlContent implements TextualContent {

    final private AbstractTextRepository repository;
    
    final private TextualContent formatContent;
    
    final private Object[] valueContents;

    public FormatHtmlContent(String formatString, Object... valueContents) {
        this(null, formatString, valueContents);
    }
    
    public FormatHtmlContent(TextualContent formatContent, Object... valueContents) {
        this(null, formatContent, valueContents);
    }

    public FormatHtmlContent(AbstractTextRepository repository, String formatString, Object... valueContents) {
        this(new HtmlContent(formatString), valueContents);
    }
    
    public FormatHtmlContent(AbstractTextRepository repository, TextualContent formatContent, Object... valueContents) {
        this.repository = repository;
        this.formatContent = formatContent;
        this.valueContents = valueContents;
    }

    @Override
    public String toHtml() {
        Object[] manipulatedValueContents = new Object[valueContents.length];
        for (int i = 0; i < valueContents.length; i++) {
            Object item = valueContents[i];
            if (item instanceof TextualContent) {
                item = ((TextualContent)item).toHtml();
            }
            manipulatedValueContents[i] = item;
        }
        if (repository == null) {
            return String.format(formatContent.toHtml(), manipulatedValueContents);
        } else {
            return String.format(repository.getLocale(), formatContent.toHtml(), manipulatedValueContents);
        }
    }

    @Override
    public String toString() {
        return HtmlUtil.htmlToString(toHtml());
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
