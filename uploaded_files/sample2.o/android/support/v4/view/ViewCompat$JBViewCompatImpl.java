package android.support.v4.view;
 class ViewCompat$JBViewCompatImpl extends android.support.v4.view.ViewCompat$ICSViewCompatImpl {

    ViewCompat$JBViewCompatImpl()
    {
        return;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View p3)
    {
        int v1_0;
        Object v0 = android.support.v4.view.ViewCompatJB.getAccessibilityNodeProvider(p3);
        if (v0 == null) {
            v1_0 = 0;
        } else {
            v1_0 = new android.support.v4.view.accessibility.AccessibilityNodeProviderCompat(v0);
        }
        return v1_0;
    }

    public int getImportantForAccessibility(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatJB.getImportantForAccessibility(p2);
    }

    public int getMinimumHeight(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatJB.getMinimumHeight(p2);
    }

    public int getMinimumWidth(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatJB.getMinimumWidth(p2);
    }

    public android.view.ViewParent getParentForAccessibility(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatJB.getParentForAccessibility(p2);
    }

    public boolean hasTransientState(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatJB.hasTransientState(p2);
    }

    public boolean performAccessibilityAction(android.view.View p2, int p3, android.os.Bundle p4)
    {
        return android.support.v4.view.ViewCompatJB.performAccessibilityAction(p2, p3, p4);
    }

    public void postInvalidateOnAnimation(android.view.View p1)
    {
        android.support.v4.view.ViewCompatJB.postInvalidateOnAnimation(p1);
        return;
    }

    public void postInvalidateOnAnimation(android.view.View p1, int p2, int p3, int p4, int p5)
    {
        android.support.v4.view.ViewCompatJB.postInvalidateOnAnimation(p1, p2, p3, p4, p5);
        return;
    }

    public void postOnAnimation(android.view.View p1, Runnable p2)
    {
        android.support.v4.view.ViewCompatJB.postOnAnimation(p1, p2);
        return;
    }

    public void postOnAnimationDelayed(android.view.View p2, Runnable p3, long p4)
    {
        android.support.v4.view.ViewCompatJB.postOnAnimationDelayed(p2, p3, p4);
        return;
    }

    public void setHasTransientState(android.view.View p1, boolean p2)
    {
        android.support.v4.view.ViewCompatJB.setHasTransientState(p1, p2);
        return;
    }

    public void setImportantForAccessibility(android.view.View p2, int p3)
    {
        if (p3 == 4) {
            p3 = 2;
        }
        android.support.v4.view.ViewCompatJB.setImportantForAccessibility(p2, p3);
        return;
    }
}
