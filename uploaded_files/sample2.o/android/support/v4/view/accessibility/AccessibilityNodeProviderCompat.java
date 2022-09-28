package android.support.v4.view.accessibility;
public class AccessibilityNodeProviderCompat {
    private static final android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;

    static AccessibilityNodeProviderCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 19) {
            if (android.os.Build$VERSION.SDK_INT < 16) {
                android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl();
            } else {
                android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl();
            }
        } else {
            android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl();
        }
        return;
    }

    public AccessibilityNodeProviderCompat()
    {
        this.mProvider = android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.IMPL.newAccessibilityNodeProviderBridge(this);
        return;
    }

    public AccessibilityNodeProviderCompat(Object p1)
    {
        this.mProvider = p1;
        return;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int p2)
    {
        return 0;
    }

    public java.util.List findAccessibilityNodeInfosByText(String p2, int p3)
    {
        return 0;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat findFocus(int p2)
    {
        return 0;
    }

    public Object getProvider()
    {
        return this.mProvider;
    }

    public boolean performAction(int p2, int p3, android.os.Bundle p4)
    {
        return 0;
    }
}
