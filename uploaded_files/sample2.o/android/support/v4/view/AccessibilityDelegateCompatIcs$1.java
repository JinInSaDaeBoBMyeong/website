package android.support.v4.view;
final class AccessibilityDelegateCompatIcs$1 extends android.view.View$AccessibilityDelegate {
    final synthetic android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge val$bridge;

    AccessibilityDelegateCompatIcs$1(android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge p1)
    {
        this.val$bridge = p1;
        return;
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return this.val$bridge.dispatchPopulateAccessibilityEvent(p2, p3);
    }

    public void onInitializeAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        this.val$bridge.onInitializeAccessibilityEvent(p2, p3);
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p2, android.view.accessibility.AccessibilityNodeInfo p3)
    {
        this.val$bridge.onInitializeAccessibilityNodeInfo(p2, p3);
        return;
    }

    public void onPopulateAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        this.val$bridge.onPopulateAccessibilityEvent(p2, p3);
        return;
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p2, android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        return this.val$bridge.onRequestSendAccessibilityEvent(p2, p3, p4);
    }

    public void sendAccessibilityEvent(android.view.View p2, int p3)
    {
        this.val$bridge.sendAccessibilityEvent(p2, p3);
        return;
    }

    public void sendAccessibilityEventUnchecked(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        this.val$bridge.sendAccessibilityEventUnchecked(p2, p3);
        return;
    }
}