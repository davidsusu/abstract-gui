package hu.webarticum.abstractgui.implementation.android;

import android.text.Html;
import android.widget.TextView;

import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class AndroidLabel extends AbstractAndroidComponent implements Label {

    private Text labelContent;

    private final TextView textView;

    AndroidLabel(AndroidEnvironment environment, String label) {
        this(environment, new PlainText(label));
    }

    AndroidLabel(AndroidEnvironment environment, Text labelContent) {
        super(environment);

        this.labelContent = labelContent;
        this.textView = new TextView(environment.getActivity());

        refresh();
    }

    @Override
    public void refresh() {
        if (labelContent.isPlain()) {
            textView.setText(labelContent.toString());
        } else {
            textView.setText(Html.fromHtml(labelContent.toHtml()));
        }
    }

    @Override
    public TextView getNativeComponent() {
        return textView;
    }

}
