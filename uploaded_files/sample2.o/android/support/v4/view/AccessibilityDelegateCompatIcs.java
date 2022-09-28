package android.support.v4.view;
 class AccessibilityDelegateCompatIcs {

    AccessibilityDelegateCompatIcs()
    {
        return;
    }

    public static boolean dispatchPopulateAccessibilityEvent(Object p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return ((android.view.View$AccessibilityDelegate) p1).dispatchPopulateAccessibilityEvent(p2, p3);
    }

    public static Object newAccessibilityDelegateBridge(android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge p1)
    {
        return new android.support.v4.view.AccessibilityDelegateCompatIcs$1(p1);
    }

    public static Object newAccessibilityDelegateDefaultImpl()
    {
        return new android.view.View$AccessibilityDelegate();
    }

    public static void onInitializeAccessibilityEvent(Object p0, android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        ((android.view.View$AccessibilityDelegate) p0).onInitializeAccessibilityEvent(p1, p2);
        return;
    }

    public static void onInitializeAccessibilityNodeInfo(Object p0, android.view.View p1, Object p2)
    {
        ((android.view.View$AccessibilityDelegate) p0).onInitializeAccessibilityNodeInfo(p1, ((android.view.accessibility.AccessibilityNodeInfo) p2));
        return;
    }

    public static void onPopulateAccessibilityEvent(Object p0, android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        ((android.view.View$AccessibilityDelegate) p0).onPopulateAccessibilityEvent(p1, p2);
        return;
    }

    public static boolean onRequestSendAccessibilityEvent(Object p1, android.view.ViewGroup p2, android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        return ((android.view.View$AccessibilityDelegate) p1).onRequestSendAccessibilityEvent(p2, p3, p4);
    }

    public static void sendAccessibilityEvent(Object p0, android.view.View p1, int p2)
    {
        ((android.view.View$AccessibilityDelegate) p0).sendAccessibilityEvent(p1, p2);
        return;
    }

    public static void sendAccessibilityEventUnchecked(Object p0, android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        ((android.view.View$AccessibilityDelegate) p0).sendAccessibilityEventUnchecked(p1, p2);
        return;
    }
}
