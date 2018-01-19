package hu.webarticum.abstractgui.core.framework;

public class PlainContentView implements TextualContent {
    
    private final TextualContent baseContent;
    
    public PlainContentView(TextualContent baseContent) {
        this.baseContent = baseContent;
    }
    
    @Override
    public String toHtml() {
        return baseContent.toHtml();
    }

    @Override
    public String toString() {
        return baseContent.toString();
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
