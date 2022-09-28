package android.support.v4.view;
public class ViewGroupCompat {
    static final android.support.v4.view.ViewGroupCompat$ViewGroupCompatImpl IMPL = None;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static ViewGroupCompat()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 18) {
            if (v0 < 14) {
                if (v0 < 11) {
                    android.support.v4.view.ViewGroupCompat.IMPL = new android.support.v4.view.ViewGroupCompat$ViewGroupCompatStubImpl();
                } else {
                    android.support.v4.view.ViewGroupCompat.IMPL = new android.support.v4.view.ViewGroupCompat$ViewGroupCompatHCImpl();
                }
            } else {
                android.support.v4.view.ViewGroupCompat.IMPL = new android.support.v4.view.ViewGroupCompat$ViewGroupCompatIcsImpl();
            }
        } else {
            android.support.v4.view.ViewGroupCompat.IMPL = new android.support.v4.view.ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl();
        }
        return;
    }

    private ViewGroupCompat()
    {
        return;
    }

    public static int getLayoutMode(android.view.ViewGroup p1)
    {
        return android.support.v4.view.ViewGroupCompat.IMPL.getLayoutMode(p1);
    }

    public static boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return android.support.v4.view.ViewGroupCompat.IMPL.onRequestSendAccessibilityEvent(p1, p2, p3);
    }

    public static void setLayoutMode(android.view.ViewGroup p1, int p2)
    {
        android.support.v4.view.ViewGroupCompat.IMPL.setLayoutMode(p1, p2);
        return;
    }

    public static void setMotionEventSplittingEnabled(android.view.ViewGroup p1, boolean p2)
    {
        android.support.v4.view.ViewGroupCompat.IMPL.setMotionEventSplittingEnabled(p1, p2);
        return;
    }
}
