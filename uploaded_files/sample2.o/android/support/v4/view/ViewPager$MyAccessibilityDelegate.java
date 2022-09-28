package android.support.v4.view;
 class ViewPager$MyAccessibilityDelegate extends android.support.v4.view.AccessibilityDelegateCompat {
    final synthetic android.support.v4.view.ViewPager this$0;

    ViewPager$MyAccessibilityDelegate(android.support.v4.view.ViewPager p1)
    {
        this.this$0 = p1;
        return;
    }

    private boolean canScroll()
    {
        int v0 = 1;
        if ((android.support.v4.view.ViewPager.access$200(this.this$0) == null) || (android.support.v4.view.ViewPager.access$200(this.this$0).getCount() <= 1)) {
            v0 = 0;
        }
        return v0;
    }

    public void onInitializeAccessibilityEvent(android.view.View p4, android.view.accessibility.AccessibilityEvent p5)
    {
        super.onInitializeAccessibilityEvent(p4, p5);
        p5.setClassName(android.support.v4.view.ViewPager.getName());
        android.support.v4.view.accessibility.AccessibilityRecordCompat v0 = android.support.v4.view.accessibility.AccessibilityRecordCompat.obtain();
        v0.setScrollable(this.canScroll());
        if ((p5.getEventType() == 4096) && (android.support.v4.view.ViewPager.access$200(this.this$0) != null)) {
            v0.setItemCount(android.support.v4.view.ViewPager.access$200(this.this$0).getCount());
            v0.setFromIndex(android.support.v4.view.ViewPager.access$300(this.this$0));
            v0.setToIndex(android.support.v4.view.ViewPager.access$300(this.this$0));
        }
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p3, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p4)
    {
        super.onInitializeAccessibilityNodeInfo(p3, p4);
        p4.setClassName(android.support.v4.view.ViewPager.getName());
        p4.setScrollable(this.canScroll());
        if (this.this$0.canScrollHorizontally(1)) {
            p4.addAction(4096);
        }
        if (this.this$0.canScrollHorizontally(-1)) {
            p4.addAction(8192);
        }
        return;
    }

    public boolean performAccessibilityAction(android.view.View p5, int p6, android.os.Bundle p7)
    {
        android.support.v4.view.ViewPager v0 = 1;
        if (!super.performAccessibilityAction(p5, p6, p7)) {
            switch (p6) {
                case 4096:
                    if (!this.this$0.canScrollHorizontally(1)) {
                        v0 = 0;
                    } else {
                        this.this$0.setCurrentItem((android.support.v4.view.ViewPager.access$300(this.this$0) + 1));
                    }
                    break;
                case 8192:
                    if (!this.this$0.canScrollHorizontally(-1)) {
                        v0 = 0;
                    } else {
                        this.this$0.setCurrentItem((android.support.v4.view.ViewPager.access$300(this.this$0) - 1));
                    }
                    break;
                default:
                    v0 = 0;
            }
        }
        return v0;
    }
}
