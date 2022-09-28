package android.support.v4.view;
 class ViewCompatJB {

    ViewCompatJB()
    {
        return;
    }

    public static Object getAccessibilityNodeProvider(android.view.View p1)
    {
        return p1.getAccessibilityNodeProvider();
    }

    public static int getImportantForAccessibility(android.view.View p1)
    {
        return p1.getImportantForAccessibility();
    }

    public static int getMinimumHeight(android.view.View p1)
    {
        return p1.getMinimumHeight();
    }

    public static int getMinimumWidth(android.view.View p1)
    {
        return p1.getMinimumWidth();
    }

    public static android.view.ViewParent getParentForAccessibility(android.view.View p1)
    {
        return p1.getParentForAccessibility();
    }

    public static boolean hasTransientState(android.view.View p1)
    {
        return p1.hasTransientState();
    }

    public static boolean performAccessibilityAction(android.view.View p1, int p2, android.os.Bundle p3)
    {
        return p1.performAccessibilityAction(p2, p3);
    }

    public static void postInvalidateOnAnimation(android.view.View p0)
    {
        p0.postInvalidateOnAnimation();
        return;
    }

    public static void postInvalidateOnAnimation(android.view.View p0, int p1, int p2, int p3, int p4)
    {
        p0.postInvalidate(p1, p2, p3, p4);
        return;
    }

    public static void postOnAnimation(android.view.View p0, Runnable p1)
    {
        p0.postOnAnimation(p1);
        return;
    }

    public static void postOnAnimationDelayed(android.view.View p0, Runnable p1, long p2)
    {
        p0.postOnAnimationDelayed(p1, p2);
        return;
    }

    public static void setHasTransientState(android.view.View p0, boolean p1)
    {
        p0.setHasTransientState(p1);
        return;
    }

    public static void setImportantForAccessibility(android.view.View p0, int p1)
    {
        p0.setImportantForAccessibility(p1);
        return;
    }
}
