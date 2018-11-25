package hu.webarticum.abstractgui.core.framework.text;

import hu.webarticum.abstractgui.core.util.HtmlUtil;
import hu.webarticum.abstractgui.core.util.StringSupplier;

public class SuppliedPlainText implements Text {

    private final StringSupplier supplier;
    
    public SuppliedPlainText(StringSupplier supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public String toHtml() {
        return HtmlUtil.plainToHtml(supplier.get());
    }

    @Override
    public String toString() {
        return supplier.get();
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
