package android.support.v4.view;
public class ViewParentCompatICS {

    public ViewParentCompatICS()
    {
        return;
    }

    public static boolean requestSendAccessibilityEvent(android.view.ViewParent p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return p1.requestSendAccessibilityEvent(p2, p3);
    }
}
