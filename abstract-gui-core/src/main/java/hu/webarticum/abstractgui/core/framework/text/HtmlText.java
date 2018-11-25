package hu.webarticum.abstractgui.core.framework.text;

import hu.webarticum.abstractgui.core.util.HtmlUtil;

public class HtmlText implements Text {
    
    private final String html;
    
    private String text = null;
    
    public HtmlText(String html) {
        this.html = html;
    }
    
    @Override
    public String toHtml() {
        return html;
    }

    @Override
    public String toString() {
        if (text == null) {
            text = HtmlUtil.htmlToPlain(html);
        }
        return text;
    }

    @Override
    public boolean isPlain() {
        return false;
    }
    
}
