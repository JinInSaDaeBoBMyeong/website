package android.support.v4.view.accessibility;
 class AccessibilityNodeInfoCompatJellyBean {

    AccessibilityNodeInfoCompatJellyBean()
    {
        return;
    }

    public static void addChild(Object p0, android.view.View p1, int p2)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).addChild(p1, p2);
        return;
    }

    public static Object findFocus(Object p1, int p2)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).findFocus(p2);
    }

    public static Object focusSearch(Object p1, int p2)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).focusSearch(p2);
    }

    public static int getMovementGranularities(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getMovementGranularities();
    }

    public static boolean isAccessibilityFocused(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isAccessibilityFocused();
    }

    public static boolean isVisibleToUser(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isVisibleToUser();
    }

    public static Object obtain(android.view.View p1, int p2)
    {
        return android.view.accessibility.AccessibilityNodeInfo.obtain(p1, p2);
    }

    public static boolean performAction(Object p1, int p2, android.os.Bundle p3)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).performAction(p2, p3);
    }

    public static void setAccesibilityFocused(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setAccessibilityFocused(p1);
        return;
    }

    public static void setMovementGranularities(Object p0, int p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setMovementGranularities(p1);
        return;
    }

    public static void setParent(Object p0, android.view.View p1, int p2)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setParent(p1, p2);
        return;
    }

    public static void setSource(Object p0, android.view.View p1, int p2)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setSource(p1, p2);
        return;
    }

    public static void setVisibleToUser(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setVisibleToUser(p1);
        return;
    }
}
