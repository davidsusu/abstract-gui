package hu.webarticum.abstractgui.implementation.android;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import hu.webarticum.abstractgui.core.framework.Environment;

public class AndroidEnvironment implements Environment {

    private boolean activityLayoutInited = false;

    private final Activity activity;

    private Toolbar toolbar = null;

    private ConstraintLayout contentConstraintLayout = null;

    private final AndroidFactory factory = new AndroidFactory(this);

    public AndroidEnvironment(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public AndroidFactory getFactory() {
        return factory;
    }

    @Override
    public boolean isAvailable() {
        try {
            Class.forName("android.widget.Button");
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public int getPriority() {
        return PRIORITY_NORMAL;
    }

    @Override
    public void invokeLater(Runnable runnable) {
        // FIXME: activity?
        runnable.run();
    }

    @Override
    public void invokeAndWait(Runnable runnable) throws InterruptedException {
        // FIXME: activity?
        runnable.run();
    }

    private void initActivityLayout() {
        if (activityLayoutInited) {
            return;
        }

        CoordinatorLayout coordinatorLayout = new CoordinatorLayout(activity);
        coordinatorLayout.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));
        coordinatorLayout.setFitsSystemWindows(true);

        AppBarLayout appBarLayout = new AppBarLayout(activity);
        coordinatorLayout.addView(appBarLayout, new CoordinatorLayout.LayoutParams(
            CoordinatorLayout.LayoutParams.MATCH_PARENT,
            CoordinatorLayout.LayoutParams.WRAP_CONTENT
        ));

        toolbar = new Toolbar(activity);
        toolbar.setTitle("");
        appBarLayout.addView(toolbar, new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT // FIXME: ?attr/actionBarSize
        ));

        contentConstraintLayout = new ConstraintLayout(activity);
        CoordinatorLayout.LayoutParams contentRelativeLayoutParams = new CoordinatorLayout.LayoutParams(
            CoordinatorLayout.LayoutParams.MATCH_PARENT,
            CoordinatorLayout.LayoutParams.WRAP_CONTENT
        );
        contentRelativeLayoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        coordinatorLayout.addView(contentConstraintLayout, contentRelativeLayoutParams);

        activity.setContentView(coordinatorLayout);
        activity.setActionBar(toolbar);

        /*
        <?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay" />

    </android.support.design.widget.AppBarLayout>

    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:context=".MainActivity"
        tools:showIn="@layout/activity_main">

    </android.support.constraint.ConstraintLayout>

</android.support.design.widget.CoordinatorLayout>
        */

        activityLayoutInited = true;
    }

    void setActiveWindow(AbstractAndroidWindow window) {

        // TODO: track active window

        initActivityLayout();
        toolbar.setTitle(window.getTitle().toString()); // XXX
        contentConstraintLayout.removeAllViews();
        ViewGroup rootViewGroup = window.getRootContainer().getNativeComponent();
        contentConstraintLayout.addView(rootViewGroup, new ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        ));
    }

}
