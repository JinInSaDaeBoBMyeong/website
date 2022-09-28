package android.support.v4.view;
public class ViewParentCompat {
    static final android.support.v4.view.ViewParentCompat$ViewParentCompatImpl IMPL;

    static ViewParentCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.view.ViewParentCompat.IMPL = new android.support.v4.view.ViewParentCompat$ViewParentCompatStubImpl();
        } else {
            android.support.v4.view.ViewParentCompat.IMPL = new android.support.v4.view.ViewParentCompat$ViewParentCompatICSImpl();
        }
        return;
    }

    private ViewParentCompat()
    {
        return;
    }

    public static boolean requestSendAccessibilityEvent(android.view.ViewParent p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return android.support.v4.view.ViewParentCompat.IMPL.requestSendAccessibilityEvent(p1, p2, p3);
    }
}
