package android.support.v4.widget;
final class DrawerLayout$ChildAccessibilityDelegate extends android.support.v4.view.AccessibilityDelegateCompat {
    final synthetic android.support.v4.widget.DrawerLayout this$0;

    DrawerLayout$ChildAccessibilityDelegate(android.support.v4.widget.DrawerLayout p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p2, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p3)
    {
        super.onInitializeAccessibilityNodeInfo(p2, p3);
        if (!android.support.v4.widget.DrawerLayout.access$300(p2)) {
            p3.setParent(0);
        }
        return;
    }
}
