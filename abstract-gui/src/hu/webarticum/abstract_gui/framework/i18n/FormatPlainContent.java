package hu.webarticum.abstract_gui.framework.i18n;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;


public class FormatPlainContent implements TextualContent {
    
    final private TextualContent formatContent;
    
    final private Object[] valueContents;

    public FormatPlainContent(String formatString, Object[] valueContents) {
        this(new PlainContent(formatString), valueContents);
    }
    
    public FormatPlainContent(TextualContent formatContent, Object[] valueContents) {
        this.formatContent = formatContent;
        this.valueContents = valueContents;
    }

    @Override
    public String toHtml() {
        return PlainContent.textToHtml(toString());
    }

    @Override
    public String toString() {
        return String.format(formatContent.toString(), valueContents);
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
