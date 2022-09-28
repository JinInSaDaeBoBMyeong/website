package android.support.v4.view.accessibility;
 class AccessibilityManagerCompatIcs {

    AccessibilityManagerCompatIcs()
    {
        return;
    }

    public static boolean addAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager p1, Object p2)
    {
        return p1.addAccessibilityStateChangeListener(((android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener) p2));
    }

    public static java.util.List getEnabledAccessibilityServiceList(android.view.accessibility.AccessibilityManager p1, int p2)
    {
        return p1.getEnabledAccessibilityServiceList(p2);
    }

    public static java.util.List getInstalledAccessibilityServiceList(android.view.accessibility.AccessibilityManager p1)
    {
        return p1.getInstalledAccessibilityServiceList();
    }

    public static boolean isTouchExplorationEnabled(android.view.accessibility.AccessibilityManager p1)
    {
        return p1.isTouchExplorationEnabled();
    }

    public static Object newAccessibilityStateChangeListener(android.support.v4.view.accessibility.AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge p1)
    {
        return new android.support.v4.view.accessibility.AccessibilityManagerCompatIcs$1(p1);
    }

    public static boolean removeAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager p1, Object p2)
    {
        return p1.removeAccessibilityStateChangeListener(((android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener) p2));
    }
}
