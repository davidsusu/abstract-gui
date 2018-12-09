package hu.webarticum.abstractgui.implementation.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import hu.webarticum.abstractgui.core.framework.Component;
import hu.webarticum.abstractgui.core.framework.FreeContainer;
import hu.webarticum.abstractgui.core.framework.Metrics;

public class AndroidFreeContainer extends AbstractStackedAndroidContainer implements FreeContainer {

    private final RelativeLayout relativeLayout;

    public AndroidFreeContainer(AndroidEnvironment environment) {
        super(environment);
        this.relativeLayout = new RelativeLayout(environment.getActivity());
    }

    @Override
    public void add(Component component, Object constraint) {
        Metrics metrics = constraint instanceof Metrics ? (Metrics) constraint : new Metrics(0, 0);
        addAt(component, metrics);
    }

    @Override
    public void addAt(Component component, Metrics metrics) {
        AbstractAndroidComponent abstractComponent = checkComponent(component);
        View nativeComponent = abstractComponent.getNativeComponent();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.leftMargin = metrics.getX();
        layoutParams.topMargin = metrics.getY();
        relativeLayout.addView(nativeComponent, layoutParams);
        registerChild(abstractComponent);
    }

    @Override
    public ViewGroup getNativeComponent() {
        return relativeLayout;
    }

}
