package android.support.v4.widget;
 class SlidingPaneLayout$AccessibilityDelegate extends android.support.v4.view.AccessibilityDelegateCompat {
    private final android.graphics.Rect mTmpRect;
    final synthetic android.support.v4.widget.SlidingPaneLayout this$0;

    SlidingPaneLayout$AccessibilityDelegate(android.support.v4.widget.SlidingPaneLayout p2)
    {
        this.this$0 = p2;
        this.mTmpRect = new android.graphics.Rect();
        return;
    }

    private void copyNodeInfoNoChildren(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p3, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p4)
    {
        android.graphics.Rect v0 = this.mTmpRect;
        p4.getBoundsInParent(v0);
        p3.setBoundsInParent(v0);
        p4.getBoundsInScreen(v0);
        p3.setBoundsInScreen(v0);
        p3.setVisibleToUser(p4.isVisibleToUser());
        p3.setPackageName(p4.getPackageName());
        p3.setClassName(p4.getClassName());
        p3.setContentDescription(p4.getContentDescription());
        p3.setEnabled(p4.isEnabled());
        p3.setClickable(p4.isClickable());
        p3.setFocusable(p4.isFocusable());
        p3.setFocused(p4.isFocused());
        p3.setAccessibilityFocused(p4.isAccessibilityFocused());
        p3.setSelected(p4.isSelected());
        p3.setLongClickable(p4.isLongClickable());
        p3.addAction(p4.getActions());
        p3.setMovementGranularities(p4.getMovementGranularities());
        return;
    }

    public boolean filter(android.view.View p2)
    {
        return this.this$0.isDimmed(p2);
    }

    public void onInitializeAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        super.onInitializeAccessibilityEvent(p2, p3);
        p3.setClassName(android.support.v4.widget.SlidingPaneLayout.getName());
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p7, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p8)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v4 = android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.obtain(p8);
        super.onInitializeAccessibilityNodeInfo(p7, v4);
        this.copyNodeInfoNoChildren(p8, v4);
        v4.recycle();
        p8.setClassName(android.support.v4.widget.SlidingPaneLayout.getName());
        p8.setSource(p7);
        android.view.View v3_0 = android.support.v4.view.ViewCompat.getParentForAccessibility(p7);
        if ((v3_0 instanceof android.view.View)) {
            p8.setParent(((android.view.View) v3_0));
        }
        int v1 = this.this$0.getChildCount();
        int v2 = 0;
        while (v2 < v1) {
            android.view.View v0 = this.this$0.getChildAt(v2);
            if ((!this.filter(v0)) && (v0.getVisibility() == 0)) {
                android.support.v4.view.ViewCompat.setImportantForAccessibility(v0, 1);
                p8.addChild(v0);
            }
            v2++;
        }
        return;
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p2, android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        int v0_1;
        if (this.filter(p3)) {
            v0_1 = 0;
        } else {
            v0_1 = super.onRequestSendAccessibilityEvent(p2, p3, p4);
        }
        return v0_1;
    }
}
