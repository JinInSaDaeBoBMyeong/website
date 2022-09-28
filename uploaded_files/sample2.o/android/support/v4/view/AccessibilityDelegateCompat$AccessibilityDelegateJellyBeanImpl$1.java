package android.support.v4.view;
 class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1 implements android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean {
    final synthetic android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl this$0;
    final synthetic android.support.v4.view.AccessibilityDelegateCompat val$compat;

    AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1(android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl p1, android.support.v4.view.AccessibilityDelegateCompat p2)
    {
        this.this$0 = p1;
        this.val$compat = p2;
        return;
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return this.val$compat.dispatchPopulateAccessibilityEvent(p2, p3);
    }

    public Object getAccessibilityNodeProvider(android.view.View p3)
    {
        int v1_1;
        android.support.v4.view.accessibility.AccessibilityNodeProviderCompat v0 = this.val$compat.getAccessibilityNodeProvider(p3);
        if (v0 == null) {
            v1_1 = 0;
        } else {
            v1_1 = v0.getProvider();
        }
        return v1_1;
    }

    public void onInitializeAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        this.val$compat.onInitializeAccessibilityEvent(p2, p3);
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p3, Object p4)
    {
        this.val$compat.onInitializeAccessibilityNodeInfo(p3, new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat(p4));
        return;
    }

    public void onPopulateAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        this.val$compat.onPopulateAccessibilityEvent(p2, p3);
        return;
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p2, android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        return this.val$compat.onRequestSendAccessibilityEvent(p2, p3, p4);
    }

    public boolean performAccessibilityAction(android.view.View p2, int p3, android.os.Bundle p4)
    {
        return this.val$compat.performAccessibilityAction(p2, p3, p4);
    }

    public void sendAccessibilityEvent(android.view.View p2, int p3)
    {
        this.val$compat.sendAccessibilityEvent(p2, p3);
        return;
    }

    public void sendAccessibilityEventUnchecked(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        this.val$compat.sendAccessibilityEventUnchecked(p2, p3);
        return;
    }
}
