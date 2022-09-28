package android.support.v4.view.accessibility;
final class AccessibilityNodeProviderCompatJellyBean$1 extends android.view.accessibility.AccessibilityNodeProvider {
    final synthetic android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge val$bridge;

    AccessibilityNodeProviderCompatJellyBean$1(android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge p1)
    {
        this.val$bridge = p1;
        return;
    }

    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int p2)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) this.val$bridge.createAccessibilityNodeInfo(p2));
    }

    public java.util.List findAccessibilityNodeInfosByText(String p2, int p3)
    {
        return this.val$bridge.findAccessibilityNodeInfosByText(p2, p3);
    }

    public boolean performAction(int p2, int p3, android.os.Bundle p4)
    {
        return this.val$bridge.performAction(p2, p3, p4);
    }
}
