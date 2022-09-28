package android.support.v4.view;
 class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl extends android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl {

    AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl()
    {
        return;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object p3, android.view.View p4)
    {
        int v1_0;
        Object v0 = android.support.v4.view.AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(p3, p4);
        if (v0 == null) {
            v1_0 = 0;
        } else {
            v1_0 = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat(v0);
        }
        return v1_0;
    }

    public Object newAccessiblityDelegateBridge(android.support.v4.view.AccessibilityDelegateCompat p2)
    {
        return android.support.v4.view.AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1(this, p2));
    }

    public boolean performAccessibilityAction(Object p2, android.view.View p3, int p4, android.os.Bundle p5)
    {
        return android.support.v4.view.AccessibilityDelegateCompatJellyBean.performAccessibilityAction(p2, p3, p4, p5);
    }
}
