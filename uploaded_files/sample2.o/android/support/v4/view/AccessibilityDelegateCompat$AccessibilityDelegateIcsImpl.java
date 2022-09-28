package android.support.v4.view;
 class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl extends android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateStubImpl {

    AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl()
    {
        return;
    }

    public boolean dispatchPopulateAccessibilityEvent(Object p2, android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        return android.support.v4.view.AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(p2, p3, p4);
    }

    public Object newAccessiblityDelegateBridge(android.support.v4.view.AccessibilityDelegateCompat p2)
    {
        return android.support.v4.view.AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1(this, p2));
    }

    public Object newAccessiblityDelegateDefaultImpl()
    {
        return android.support.v4.view.AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
    }

    public void onInitializeAccessibilityEvent(Object p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        android.support.v4.view.AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(p1, p2, p3);
        return;
    }

    public void onInitializeAccessibilityNodeInfo(Object p2, android.view.View p3, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p4)
    {
        android.support.v4.view.AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(p2, p3, p4.getInfo());
        return;
    }

    public void onPopulateAccessibilityEvent(Object p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        android.support.v4.view.AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(p1, p2, p3);
        return;
    }

    public boolean onRequestSendAccessibilityEvent(Object p2, android.view.ViewGroup p3, android.view.View p4, android.view.accessibility.AccessibilityEvent p5)
    {
        return android.support.v4.view.AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(p2, p3, p4, p5);
    }

    public void sendAccessibilityEvent(Object p1, android.view.View p2, int p3)
    {
        android.support.v4.view.AccessibilityDelegateCompatIcs.sendAccessibilityEvent(p1, p2, p3);
        return;
    }

    public void sendAccessibilityEventUnchecked(Object p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        android.support.v4.view.AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(p1, p2, p3);
        return;
    }
}
