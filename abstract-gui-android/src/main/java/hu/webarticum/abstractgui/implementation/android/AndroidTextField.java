package hu.webarticum.abstractgui.implementation.android;

import android.widget.EditText;

import hu.webarticum.abstractgui.core.framework.TextField;

public class AndroidTextField extends AbstractAndroidComponent implements TextField {

        private final EditText editText;

        AndroidTextField(AndroidEnvironment environment) {
            super(environment);

            this.editText = new EditText(environment.getActivity());
        }

        @Override
        public void refresh() {
        }

        @Override
        public void setValue(String value) {
            editText.setText(value);
        }

        @Override
        public String getValue() {
            return editText.getText().toString();
        }

        @Override
        public EditText getNativeComponent() {
            return editText;
        }


}
