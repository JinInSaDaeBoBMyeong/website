package android.support.v4.view;
 class ScaleGestureDetectorCompatKitKat {

    private ScaleGestureDetectorCompatKitKat()
    {
        return;
    }

    public static boolean isQuickScaleEnabled(Object p1)
    {
        return ((android.view.ScaleGestureDetector) p1).isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(Object p0, boolean p1)
    {
        ((android.view.ScaleGestureDetector) p0).setQuickScaleEnabled(p1);
        return;
    }
}
