package hu.webarticum.abstract_gui.framework.i18n;

import hu.webarticum.abstract_gui.framework.HtmlContent;
import hu.webarticum.abstract_gui.framework.HtmlUtil;
import hu.webarticum.abstract_gui.framework.TextualContent;

public class FormatHtmlContent implements TextualContent {
    
    final private TextualContent formatContent;
    
    final private Object[] valueContents;

    public FormatHtmlContent(String formatString, Object... valueContents) {
        this(new HtmlContent(formatString), valueContents);
    }
    
    public FormatHtmlContent(TextualContent formatContent, Object... valueContents) {
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
        return String.format(formatContent.toHtml(), manipulatedValueContents);
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
