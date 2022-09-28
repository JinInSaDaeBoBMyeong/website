package android.support.v4.view.accessibility;
 class AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1 implements android.support.v4.view.accessibility.AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge {
    final synthetic android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl this$0;
    final synthetic android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat val$listener;

    AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1(android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl p1, android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat p2)
    {
        this.this$0 = p1;
        this.val$listener = p2;
        return;
    }

    public void onAccessibilityStateChanged(boolean p2)
    {
        this.val$listener.onAccessibilityStateChanged(p2);
        return;
    }
}
