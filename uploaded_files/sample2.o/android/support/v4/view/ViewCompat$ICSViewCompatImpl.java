package android.support.v4.view;
 class ViewCompat$ICSViewCompatImpl extends android.support.v4.view.ViewCompat$HCViewCompatImpl {

    ViewCompat$ICSViewCompatImpl()
    {
        return;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat animate(android.view.View p3)
    {
        if (this.mViewPropertyAnimatorCompatMap == null) {
            this.mViewPropertyAnimatorCompatMap = new java.util.WeakHashMap();
        }
        android.support.v4.view.ViewPropertyAnimatorCompat v0_1 = ((android.support.v4.view.ViewPropertyAnimatorCompat) this.mViewPropertyAnimatorCompatMap.get(p3));
        if (v0_1 == null) {
            v0_1 = new android.support.v4.view.ViewPropertyAnimatorCompat(p3);
            this.mViewPropertyAnimatorCompatMap.put(p3, v0_1);
        }
        return v0_1;
    }

    public boolean canScrollHorizontally(android.view.View p2, int p3)
    {
        return android.support.v4.view.ViewCompatICS.canScrollHorizontally(p2, p3);
    }

    public boolean canScrollVertically(android.view.View p2, int p3)
    {
        return android.support.v4.view.ViewCompatICS.canScrollVertically(p2, p3);
    }

    public void onInitializeAccessibilityEvent(android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        android.support.v4.view.ViewCompatICS.onInitializeAccessibilityEvent(p1, p2);
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p2, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p3)
    {
        android.support.v4.view.ViewCompatICS.onInitializeAccessibilityNodeInfo(p2, p3.getInfo());
        return;
    }

    public void onPopulateAccessibilityEvent(android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        android.support.v4.view.ViewCompatICS.onPopulateAccessibilityEvent(p1, p2);
        return;
    }

    public void setAccessibilityDelegate(android.view.View p2, android.support.v4.view.AccessibilityDelegateCompat p3)
    {
        android.support.v4.view.ViewCompatICS.setAccessibilityDelegate(p2, p3.getBridge());
        return;
    }
}
