package android.support.v4.view;
 class ViewParentCompat$ViewParentCompatStubImpl implements android.support.v4.view.ViewParentCompat$ViewParentCompatImpl {

    ViewParentCompat$ViewParentCompatStubImpl()
    {
        return;
    }

    public boolean requestSendAccessibilityEvent(android.view.ViewParent p4, android.view.View p5, android.view.accessibility.AccessibilityEvent p6)
    {
        int v1_1;
        if (p5 != null) {
            ((android.view.accessibility.AccessibilityManager) p5.getContext().getSystemService("accessibility")).sendAccessibilityEvent(p6);
            v1_1 = 1;
        } else {
            v1_1 = 0;
        }
        return v1_1;
    }
}
