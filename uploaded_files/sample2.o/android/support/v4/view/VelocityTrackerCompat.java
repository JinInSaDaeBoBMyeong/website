package android.support.v4.view;
public class VelocityTrackerCompat {
    static final android.support.v4.view.VelocityTrackerCompat$VelocityTrackerVersionImpl IMPL;

    static VelocityTrackerCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 11) {
            android.support.v4.view.VelocityTrackerCompat.IMPL = new android.support.v4.view.VelocityTrackerCompat$BaseVelocityTrackerVersionImpl();
        } else {
            android.support.v4.view.VelocityTrackerCompat.IMPL = new android.support.v4.view.VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl();
        }
        return;
    }

    public VelocityTrackerCompat()
    {
        return;
    }

    public static float getXVelocity(android.view.VelocityTracker p1, int p2)
    {
        return android.support.v4.view.VelocityTrackerCompat.IMPL.getXVelocity(p1, p2);
    }

    public static float getYVelocity(android.view.VelocityTracker p1, int p2)
    {
        return android.support.v4.view.VelocityTrackerCompat.IMPL.getYVelocity(p1, p2);
    }
}
