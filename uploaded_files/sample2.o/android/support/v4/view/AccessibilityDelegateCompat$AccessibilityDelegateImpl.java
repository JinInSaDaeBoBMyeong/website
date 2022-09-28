package android.support.v4.view;
interface AccessibilityDelegateCompat$AccessibilityDelegateImpl {

    public abstract boolean dispatchPopulateAccessibilityEvent();

    public abstract android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider();

    public abstract Object newAccessiblityDelegateBridge();

    public abstract Object newAccessiblityDelegateDefaultImpl();

    public abstract void onInitializeAccessibilityEvent();

    public abstract void onInitializeAccessibilityNodeInfo();

    public abstract void onPopulateAccessibilityEvent();

    public abstract boolean onRequestSendAccessibilityEvent();

    public abstract boolean performAccessibilityAction();

    public abstract void sendAccessibilityEvent();

    public abstract void sendAccessibilityEventUnchecked();
}
