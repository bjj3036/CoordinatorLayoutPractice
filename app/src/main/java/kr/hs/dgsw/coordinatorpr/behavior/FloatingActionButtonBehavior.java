package kr.hs.dgsw.coordinatorpr.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FloatingActionButtonBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private static final String TAG = "FloatingActionButtonBehavior";

    public FloatingActionButtonBehavior() {
    }

    public FloatingActionButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        Log.i("CoordinatorPR", "TranslationY: " + dependency.getTranslationY() + ", Height: " + dependency.getHeight() + ", translationY: " + translationY);
        child.setTranslationY(translationY);

        return true;
    }

}
