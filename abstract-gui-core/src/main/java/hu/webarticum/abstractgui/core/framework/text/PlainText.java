package hu.webarticum.abstractgui.core.framework.text;

import hu.webarticum.abstractgui.core.util.HtmlUtil;

public class PlainText implements Text {
    
    private final String text;
    
    private String html = null;
    
    public PlainText(String text) {
        this.text = text;
    }
    
    @Override
    public String toHtml() {
        if (html == null) {
            html = HtmlUtil.plainToHtml(text);
        }
        return html;
    }
    
    @Override
    public String toString() {
        return text;
    }
    
    @Override
    public boolean isPlain() {
        return true;
    }
    
}
