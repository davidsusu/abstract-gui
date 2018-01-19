package hu.webarticum.abstractgui.core.framework.i18n;

import hu.webarticum.abstractgui.core.framework.HtmlUtil;
import hu.webarticum.abstractgui.core.framework.TextualContent;

public class MlHtmlContent implements TextualContent {

    private final AbstractTextRepository repository;
    
    private Object key;
    
    MlHtmlContent(AbstractTextRepository repository, Object key) {
        this.repository = repository;
        this.key = key;
    }
    
    @Override
    public String toHtml() {
        return repository.getText(key);
    }

    @Override
    public String toString() {
        return HtmlUtil.htmlToString(repository.getText(key));
    }

    @Override
    public boolean isPlain() {
        return false;
    }

}
