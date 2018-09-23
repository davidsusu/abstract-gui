package hu.webarticum.abstractgui.core.framework.text;

public class PlainTextView implements Text {
    
    private final Text baseText;
    
    public PlainTextView(Text baseText) {
        this.baseText = baseText;
    }
    
    @Override
    public String toHtml() {
        return baseText.toHtml();
    }

    @Override
    public String toString() {
        return baseText.toString();
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
