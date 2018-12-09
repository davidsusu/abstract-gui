package hu.webarticum.abstractgui.implementation.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import hu.webarticum.abstractgui.core.framework.BorderContainer;
import hu.webarticum.abstractgui.core.framework.Component;

public class AndroidBorderContainer extends AbstractAndroidContainer implements BorderContainer {

    private final RelativeLayout relativeLayout;

    private final Map<Location, RelativeLayout> wrappers =
            new EnumMap<Location, RelativeLayout>(Location.class);

    private final Map<Location, AbstractAndroidComponent> children =
            new EnumMap<Location, AbstractAndroidComponent>(Location.class);

    public AndroidBorderContainer(AndroidEnvironment environment) {
        super(environment);
        Context context = environment.getActivity();
        this.relativeLayout = new RelativeLayout(context);

        int topId = View.generateViewId();
        int leftId = View.generateViewId();
        int centerId = View.generateViewId();
        int rightId = View.generateViewId();
        int bottomId = View.generateViewId();

        RelativeLayout topLayout = new RelativeLayout(context);
        topLayout.setId(topId);
        topLayout.setGravity(RelativeLayout.CENTER_HORIZONTAL);
        RelativeLayout.LayoutParams topLayoutParams = createLayoutParamsForLocation(Location.TOP);
        topLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        topLayout.setLayoutParams(topLayoutParams);
        relativeLayout.addView(topLayout);
        wrappers.put(Location.TOP, topLayout);

        RelativeLayout bottomLayout = new RelativeLayout(context);
        bottomLayout.setId(bottomId);
        bottomLayout.setGravity(RelativeLayout.CENTER_HORIZONTAL);
        RelativeLayout.LayoutParams bottomLayoutParams = createLayoutParamsForLocation(Location.BOTTOM);
        bottomLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomLayout.setLayoutParams(bottomLayoutParams);
        relativeLayout.addView(bottomLayout);
        wrappers.put(Location.BOTTOM, bottomLayout);

        RelativeLayout leftLayout = new RelativeLayout(context);
        leftLayout.setId(leftId);
        leftLayout.setGravity(RelativeLayout.CENTER_VERTICAL);
        RelativeLayout.LayoutParams leftLayoutParams = createLayoutParamsForLocation(Location.LEFT);
        leftLayoutParams.addRule(RelativeLayout.BELOW, topId);
        leftLayoutParams.addRule(RelativeLayout.ABOVE, bottomId);
        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        leftLayout.setLayoutParams(leftLayoutParams);
        relativeLayout.addView(leftLayout);
        wrappers.put(Location.LEFT, leftLayout);

        RelativeLayout rightLayout = new RelativeLayout(context);
        rightLayout.setId(rightId);
        rightLayout.setGravity(RelativeLayout.CENTER_VERTICAL);
        RelativeLayout.LayoutParams rightLayoutParams = createLayoutParamsForLocation(Location.RIGHT);
        rightLayoutParams.addRule(RelativeLayout.BELOW, topId);
        rightLayoutParams.addRule(RelativeLayout.ABOVE, bottomId);
        rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightLayout.setLayoutParams(rightLayoutParams);
        relativeLayout.addView(rightLayout);
        wrappers.put(Location.RIGHT, rightLayout);

        RelativeLayout centerLayout = new RelativeLayout(context);
        centerLayout.setId(centerId);
        centerLayout.setGravity(RelativeLayout.CENTER_IN_PARENT);
        RelativeLayout.LayoutParams centerLayoutParams = createLayoutParamsForLocation(Location.CENTER);
        centerLayoutParams.addRule(RelativeLayout.BELOW, topId);
        centerLayoutParams.addRule(RelativeLayout.ABOVE, bottomId);
        centerLayoutParams.addRule(RelativeLayout.RIGHT_OF, leftId);
        centerLayoutParams.addRule(RelativeLayout.LEFT_OF, rightId);
        centerLayout.setLayoutParams(centerLayoutParams);
        relativeLayout.addView(centerLayout);
        wrappers.put(Location.CENTER, centerLayout);
    }

    @Override
    public void addTop(Component component) {
        add(component, Location.TOP);
    }

    @Override
    public void addLeft(Component component) {
        add(component, Location.LEFT);
    }

    @Override
    public void addCenter(Component component) {
        add(component, Location.CENTER);
    }

    @Override
    public void addRight(Component component) {
        add(component, Location.RIGHT);
    }

    @Override
    public void addBottom(Component component) {
        add(component, Location.BOTTOM);
    }

    @Override
    public void add(Component component, Object constraint) {
        AbstractAndroidComponent abstractComponent = checkComponent(component);
        remove(component);
        Location targetLocation = constraint instanceof Location ? (Location)constraint : Location.CENTER;
        View nativeComponent = abstractComponent.getNativeComponent();
        nativeComponent.setLayoutParams(createLayoutParamsForLocation(targetLocation));
        RelativeLayout targetWrapper = wrappers.get(targetLocation);
        targetWrapper.removeAllViews();
        targetWrapper.addView(nativeComponent);
        children.put(targetLocation, abstractComponent);
    }

    private RelativeLayout.LayoutParams createLayoutParamsForLocation(Location location) {
        int width = location == Location.LEFT || location == Location.RIGHT ?
                RelativeLayout.LayoutParams.WRAP_CONTENT :
                RelativeLayout.LayoutParams.MATCH_PARENT;
        int height = location == Location.TOP || location == Location.BOTTOM ?
                RelativeLayout.LayoutParams.WRAP_CONTENT :
                RelativeLayout.LayoutParams.MATCH_PARENT;
        return new RelativeLayout.LayoutParams(width, height);
    }

    @Override
    public List<AbstractAndroidComponent> getChildren() {
        return new ArrayList<>(children.values());
    }

    @Override
    public void remove(Component component) {
        if (!(component instanceof AbstractAndroidComponent)) {
            return;
        }

        AbstractAndroidComponent abstractComponent = (AbstractAndroidComponent)component;
        children.values().remove(component);
        for (Map.Entry<Location, RelativeLayout> entry : wrappers.entrySet()) {
            RelativeLayout wrapper = entry.getValue();
            if (wrapper.getChildCount() > 0) {
                View childView = wrapper.getChildAt(0);
                if (childView == abstractComponent.getNativeComponent()) {
                    wrapper.removeViewAt(0);
                    return;
                }
            }
        }
    }

    @Override
    public ViewGroup getNativeComponent() {
        return relativeLayout;
    }

}
