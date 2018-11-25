package hu.webarticum.abstractgui.core.framework.text;

import hu.webarticum.abstractgui.core.util.HtmlUtil;
import hu.webarticum.abstractgui.core.util.StringSupplier;

public class SuppliedHtmlText implements Text {

    private final StringSupplier supplier;
    
    public SuppliedHtmlText(StringSupplier supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public String toHtml() {
        return supplier.get();
    }

    @Override
    public String toString() {
        return HtmlUtil.htmlToPlain(supplier.get());
    }

    @Override
    public boolean isPlain() {
        return false;
    }

}
