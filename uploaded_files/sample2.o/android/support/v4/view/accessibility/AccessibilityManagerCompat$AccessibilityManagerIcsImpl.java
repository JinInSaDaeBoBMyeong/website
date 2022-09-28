package android.support.v4.view.accessibility;
 class AccessibilityManagerCompat$AccessibilityManagerIcsImpl extends android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerStubImpl {

    AccessibilityManagerCompat$AccessibilityManagerIcsImpl()
    {
        return;
    }

    public boolean addAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager p2, android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat p3)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(p2, p3.mListener);
    }

    public java.util.List getEnabledAccessibilityServiceList(android.view.accessibility.AccessibilityManager p2, int p3)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(p2, p3);
    }

    public java.util.List getInstalledAccessibilityServiceList(android.view.accessibility.AccessibilityManager p2)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(p2);
    }

    public boolean isTouchExplorationEnabled(android.view.accessibility.AccessibilityManager p2)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.isTouchExplorationEnabled(p2);
    }

    public Object newAccessiblityStateChangeListener(android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat p2)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(new android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1(this, p2));
    }

    public boolean removeAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager p2, android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat p3)
    {
        return android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(p2, p3.mListener);
    }
}
