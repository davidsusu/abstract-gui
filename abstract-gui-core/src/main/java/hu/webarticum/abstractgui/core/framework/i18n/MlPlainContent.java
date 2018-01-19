package hu.webarticum.abstractgui.core.framework.i18n;

import hu.webarticum.abstractgui.core.framework.HtmlUtil;
import hu.webarticum.abstractgui.core.framework.TextualContent;

public class MlPlainContent implements TextualContent {
    
    private final AbstractTextRepository repository;
    
    private Object key;
    
    MlPlainContent(AbstractTextRepository repository, Object key) {
        this.repository = repository;
        this.key = key;
    }
    
    @Override
    public String toHtml() {
        return HtmlUtil.textToHtml(repository.getText(key));
    }

    @Override
    public String toString() {
        return repository.getText(key);
    }

    @Override
    public boolean isPlain() {
        return true;
    }

}
