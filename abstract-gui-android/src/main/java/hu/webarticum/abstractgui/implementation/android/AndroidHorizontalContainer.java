package hu.webarticum.abstractgui.implementation.android;

import android.view.View;
import android.widget.LinearLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.HorizontalContainer;

public class AndroidHorizontalContainer extends AbstractStackedAndroidContainer implements HorizontalContainer {

    private final LinearLayout linearLayout;

    public AndroidHorizontalContainer(AndroidEnvironment environment) {
        super(environment);
        this.linearLayout = new LinearLayout(environment.getActivity());
        this.linearLayout.setOrientation(LinearLayout.HORIZONTAL);
    }

    @Override
    public void add(Component component, Object constraint) {
        add(component);
    }

    @Override
    public void add(Component component) {
        AbstractAndroidComponent abstractComponent = checkComponent(component);
        View nativeComponent = abstractComponent.getNativeComponent();
        nativeComponent.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        linearLayout.addView(nativeComponent);
        registerChild(abstractComponent);
    }

    @Override
    public LinearLayout getNativeComponent() {
        return linearLayout;
    }

}
