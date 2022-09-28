package android.support.v4.view;
public class AccessibilityDelegateCompat {
    private static final Object DEFAULT_DELEGATE;
    private static final android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateImpl IMPL;
    final Object mBridge;

    static AccessibilityDelegateCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            if (android.os.Build$VERSION.SDK_INT < 14) {
                android.support.v4.view.AccessibilityDelegateCompat.IMPL = new android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateStubImpl();
            } else {
                android.support.v4.view.AccessibilityDelegateCompat.IMPL = new android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl();
            }
        } else {
            android.support.v4.view.AccessibilityDelegateCompat.IMPL = new android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl();
        }
        android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE = android.support.v4.view.AccessibilityDelegateCompat.IMPL.newAccessiblityDelegateDefaultImpl();
        return;
    }

    public AccessibilityDelegateCompat()
    {
        this.mBridge = android.support.v4.view.AccessibilityDelegateCompat.IMPL.newAccessiblityDelegateBridge(this);
        return;
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        return android.support.v4.view.AccessibilityDelegateCompat.IMPL.dispatchPopulateAccessibilityEvent(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View p3)
    {
        return android.support.v4.view.AccessibilityDelegateCompat.IMPL.getAccessibilityNodeProvider(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3);
    }

    Object getBridge()
    {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        android.support.v4.view.AccessibilityDelegateCompat.IMPL.onInitializeAccessibilityEvent(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4);
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p3, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p4)
    {
        android.support.v4.view.AccessibilityDelegateCompat.IMPL.onInitializeAccessibilityNodeInfo(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4);
        return;
    }

    public void onPopulateAccessibilityEvent(android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        android.support.v4.view.AccessibilityDelegateCompat.IMPL.onPopulateAccessibilityEvent(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4);
        return;
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p3, android.view.View p4, android.view.accessibility.AccessibilityEvent p5)
    {
        return android.support.v4.view.AccessibilityDelegateCompat.IMPL.onRequestSendAccessibilityEvent(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4, p5);
    }

    public boolean performAccessibilityAction(android.view.View p3, int p4, android.os.Bundle p5)
    {
        return android.support.v4.view.AccessibilityDelegateCompat.IMPL.performAccessibilityAction(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4, p5);
    }

    public void sendAccessibilityEvent(android.view.View p3, int p4)
    {
        android.support.v4.view.AccessibilityDelegateCompat.IMPL.sendAccessibilityEvent(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4);
        return;
    }

    public void sendAccessibilityEventUnchecked(android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        android.support.v4.view.AccessibilityDelegateCompat.IMPL.sendAccessibilityEventUnchecked(android.support.v4.view.AccessibilityDelegateCompat.DEFAULT_DELEGATE, p3, p4);
        return;
    }
}
