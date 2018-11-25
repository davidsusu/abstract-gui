package hu.webarticum.abstractgui.core.framework.text;

import hu.webarticum.abstractgui.core.util.HtmlUtil;

public class HtmlSourceView implements Text {
    
    private final Text baseText;
    
    public HtmlSourceView(Text baseText) {
        this.baseText = baseText;
    }
    
    @Override
    public String toHtml() {
        return HtmlUtil.plainToHtml(toString());
    }

    @Override
    public String toString() {
        return baseText.toHtml();
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
