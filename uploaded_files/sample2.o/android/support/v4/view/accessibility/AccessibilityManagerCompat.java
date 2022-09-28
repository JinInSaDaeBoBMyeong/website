package android.support.v4.view.accessibility;
public class AccessibilityManagerCompat {
    private static final android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerVersionImpl IMPL;

    static AccessibilityManagerCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerStubImpl();
        } else {
            android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl();
        }
        return;
    }

    public AccessibilityManagerCompat()
    {
        return;
    }

    static synthetic android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerVersionImpl access$000()
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL;
    }

    public static boolean addAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager p1, android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat p2)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL.addAccessibilityStateChangeListener(p1, p2);
    }

    public static java.util.List getEnabledAccessibilityServiceList(android.view.accessibility.AccessibilityManager p1, int p2)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL.getEnabledAccessibilityServiceList(p1, p2);
    }

    public static java.util.List getInstalledAccessibilityServiceList(android.view.accessibility.AccessibilityManager p1)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL.getInstalledAccessibilityServiceList(p1);
    }

    public static boolean isTouchExplorationEnabled(android.view.accessibility.AccessibilityManager p1)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL.isTouchExplorationEnabled(p1);
    }

    public static boolean removeAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager p1, android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat p2)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompat.IMPL.removeAccessibilityStateChangeListener(p1, p2);
    }
}
