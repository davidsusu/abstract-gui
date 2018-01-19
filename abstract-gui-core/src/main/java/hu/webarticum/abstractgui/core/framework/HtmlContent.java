package hu.webarticum.abstractgui.core.framework;

public class HtmlContent implements TextualContent {
    
    private final String html;
    
    private String text = null;
    
    public HtmlContent(String html) {
        this.html = html;
    }
    
    @Override
    public String toHtml() {
        return html;
    }

    @Override
    public String toString() {
        if (text == null) {
            text = HtmlUtil.htmlToString(html);
        }
        return text;
    }

    @Override
    public boolean isPlain() {
        return false;
    }
    
}
