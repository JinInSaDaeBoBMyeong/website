package android.support.v4.view;
 class ViewCompatICS {

    ViewCompatICS()
    {
        return;
    }

    public static boolean canScrollHorizontally(android.view.View p1, int p2)
    {
        return p1.canScrollHorizontally(p2);
    }

    public static boolean canScrollVertically(android.view.View p1, int p2)
    {
        return p1.canScrollVertically(p2);
    }

    public static void onInitializeAccessibilityEvent(android.view.View p0, android.view.accessibility.AccessibilityEvent p1)
    {
        p0.onInitializeAccessibilityEvent(p1);
        return;
    }

    public static void onInitializeAccessibilityNodeInfo(android.view.View p0, Object p1)
    {
        p0.onInitializeAccessibilityNodeInfo(((android.view.accessibility.AccessibilityNodeInfo) p1));
        return;
    }

    public static void onPopulateAccessibilityEvent(android.view.View p0, android.view.accessibility.AccessibilityEvent p1)
    {
        p0.onPopulateAccessibilityEvent(p1);
        return;
    }

    public static void setAccessibilityDelegate(android.view.View p0, Object p1)
    {
        p0.setAccessibilityDelegate(((android.view.View$AccessibilityDelegate) p1));
        return;
    }
}
