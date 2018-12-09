package hu.webarticum.abstractgui.implementation.android;

import android.view.View;

import hu.webarticum.abstractgui.core.framework.Button;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class AndroidButton extends AbstractLabeledAndroidComponent implements Button {

    private final android.widget.Button button;

    AndroidButton(AndroidEnvironment environment, String label) {
        this(environment, new PlainText(label));
    }

    AndroidButton(AndroidEnvironment environment, Text text) {
        super(environment, text);

        this.button = new android.widget.Button(environment.getActivity());
        this.button.setText(text.toString()); // TODO: html etc. ?
        this.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                generalListenable.runListeners(Event.Type.ACTION, new Event(button, null));
            }

        });
    }

    @Override
    public void refresh() {
        button.setText(getLabel());
    }

    @Override
    public android.widget.Button getNativeComponent() {
        return button;
    }

}
