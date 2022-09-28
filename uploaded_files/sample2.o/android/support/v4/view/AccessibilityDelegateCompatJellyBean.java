package android.support.v4.view;
 class AccessibilityDelegateCompatJellyBean {

    AccessibilityDelegateCompatJellyBean()
    {
        return;
    }

    public static Object getAccessibilityNodeProvider(Object p1, android.view.View p2)
    {
        return ((android.view.View$AccessibilityDelegate) p1).getAccessibilityNodeProvider(p2);
    }

    public static Object newAccessibilityDelegateBridge(android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean p1)
    {
        return new android.support.v4.view.AccessibilityDelegateCompatJellyBean$1(p1);
    }

    public static boolean performAccessibilityAction(Object p1, android.view.View p2, int p3, android.os.Bundle p4)
    {
        return ((android.view.View$AccessibilityDelegate) p1).performAccessibilityAction(p2, p3, p4);
    }
}
