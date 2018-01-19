package hu.webarticum.abstractgui.core.framework;

public class PlainContent implements TextualContent {
    
    private final String text;
    
    private String html = null;
    
    public PlainContent(String text) {
        this.text = text;
    }
    
    @Override
    public String toHtml() {
        if (html == null) {
            html = HtmlUtil.textToHtml(text);
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
