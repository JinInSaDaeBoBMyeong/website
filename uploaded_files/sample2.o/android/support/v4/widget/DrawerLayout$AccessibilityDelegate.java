package android.support.v4.widget;
 class DrawerLayout$AccessibilityDelegate extends android.support.v4.view.AccessibilityDelegateCompat {
    private final android.graphics.Rect mTmpRect;
    final synthetic android.support.v4.widget.DrawerLayout this$0;

    DrawerLayout$AccessibilityDelegate(android.support.v4.widget.DrawerLayout p2)
    {
        this.this$0 = p2;
        this.mTmpRect = new android.graphics.Rect();
        return;
    }

    private void addChildrenForAccessibility(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p5, android.view.ViewGroup p6)
    {
        int v1 = p6.getChildCount();
        int v2 = 0;
        while (v2 < v1) {
            android.view.View v0 = p6.getChildAt(v2);
            if (android.support.v4.widget.DrawerLayout.access$300(v0)) {
                p5.addChild(v0);
            }
            v2++;
        }
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
        return;
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.View p7, android.view.accessibility.AccessibilityEvent p8)
    {
        int v4_3;
        if (p8.getEventType() != 32) {
            v4_3 = super.dispatchPopulateAccessibilityEvent(p7, p8);
        } else {
            java.util.List v1 = p8.getText();
            android.view.View v3 = android.support.v4.widget.DrawerLayout.access$200(this.this$0);
            if (v3 != null) {
                CharSequence v2 = this.this$0.getDrawerTitle(this.this$0.getDrawerViewAbsoluteGravity(v3));
                if (v2 != null) {
                    v1.add(v2);
                }
            }
            v4_3 = 1;
        }
        return v4_3;
    }

    public void onInitializeAccessibilityEvent(android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        super.onInitializeAccessibilityEvent(p2, p3);
        p3.setClassName(android.support.v4.widget.DrawerLayout.getName());
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p4, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p5)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v1 = android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.obtain(p5);
        super.onInitializeAccessibilityNodeInfo(p4, v1);
        p5.setClassName(android.support.v4.widget.DrawerLayout.getName());
        p5.setSource(p4);
        android.view.View v0_1 = android.support.v4.view.ViewCompat.getParentForAccessibility(p4);
        if ((v0_1 instanceof android.view.View)) {
            p5.setParent(((android.view.View) v0_1));
        }
        this.copyNodeInfoNoChildren(p5, v1);
        v1.recycle();
        this.addChildrenForAccessibility(p5, ((android.view.ViewGroup) p4));
        return;
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p2, android.view.View p3, android.view.accessibility.AccessibilityEvent p4)
    {
        int v0_1;
        if (!android.support.v4.widget.DrawerLayout.access$300(p3)) {
            v0_1 = 0;
        } else {
            v0_1 = super.onRequestSendAccessibilityEvent(p2, p3, p4);
        }
        return v0_1;
    }
}
