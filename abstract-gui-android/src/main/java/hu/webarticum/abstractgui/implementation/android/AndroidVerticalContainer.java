package hu.webarticum.abstractgui.implementation.android;

import android.view.View;
import android.widget.LinearLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.VerticalContainer;

public class AndroidVerticalContainer extends AbstractStackedAndroidContainer implements VerticalContainer {

    private final LinearLayout linearLayout;

    public AndroidVerticalContainer(AndroidEnvironment environment) {
        super(environment);
        this.linearLayout = new LinearLayout(environment.getActivity());
        this.linearLayout.setOrientation(LinearLayout.VERTICAL);
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
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        linearLayout.addView(nativeComponent);
        registerChild(abstractComponent);
    }

    @Override
    public LinearLayout getNativeComponent() {
        return linearLayout;
    }

}
