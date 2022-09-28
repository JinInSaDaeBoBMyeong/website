package android.support.v4.view;
public class ScaleGestureDetectorCompat {
    static final android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorImpl IMPL;

    static ScaleGestureDetectorCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 19) {
            android.support.v4.view.ScaleGestureDetectorCompat.IMPL = new android.support.v4.view.ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl(0);
        } else {
            android.support.v4.view.ScaleGestureDetectorCompat.IMPL = new android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl(0);
        }
        return;
    }

    private ScaleGestureDetectorCompat()
    {
        return;
    }

    public static boolean isQuickScaleEnabled(Object p1)
    {
        return android.support.v4.view.ScaleGestureDetectorCompat.IMPL.isQuickScaleEnabled(p1);
    }

    public static void setQuickScaleEnabled(Object p1, boolean p2)
    {
        android.support.v4.view.ScaleGestureDetectorCompat.IMPL.setQuickScaleEnabled(p1, p2);
        return;
    }
}
