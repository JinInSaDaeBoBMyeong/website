package android.support.v4.view.accessibility;
 class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1 implements android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge {
    final synthetic android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl this$0;
    final synthetic android.support.v4.view.accessibility.AccessibilityNodeProviderCompat val$compat;

    AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1(android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl p1, android.support.v4.view.accessibility.AccessibilityNodeProviderCompat p2)
    {
        this.this$0 = p1;
        this.val$compat = p2;
        return;
    }

    public Object createAccessibilityNodeInfo(int p3)
    {
        Object v1_1;
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v0 = this.val$compat.createAccessibilityNodeInfo(p3);
        if (v0 != null) {
            v1_1 = v0.getInfo();
        } else {
            v1_1 = 0;
        }
        return v1_1;
    }

    public java.util.List findAccessibilityNodeInfosByText(String p7, int p8)
    {
        java.util.List v0 = this.val$compat.findAccessibilityNodeInfosByText(p7, p8);
        java.util.ArrayList v4_1 = new java.util.ArrayList();
        int v3 = v0.size();
        int v1 = 0;
        while (v1 < v3) {
            v4_1.add(((android.support.v4.view.accessibility.AccessibilityNodeInfoCompat) v0.get(v1)).getInfo());
            v1++;
        }
        return v4_1;
    }

    public Object findFocus(int p3)
    {
        Object v1_1;
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v0 = this.val$compat.findFocus(p3);
        if (v0 != null) {
            v1_1 = v0.getInfo();
        } else {
            v1_1 = 0;
        }
        return v1_1;
    }

    public boolean performAction(int p2, int p3, android.os.Bundle p4)
    {
        return this.val$compat.performAction(p2, p3, p4);
    }
}
