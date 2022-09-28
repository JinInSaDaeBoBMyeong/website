package android.support.v4.view;
 class ViewCompat$KitKatViewCompatImpl extends android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl {

    ViewCompat$KitKatViewCompatImpl()
    {
        return;
    }

    public int getAccessibilityLiveRegion(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatKitKat.getAccessibilityLiveRegion(p2);
    }

    public void setAccessibilityLiveRegion(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompatKitKat.setAccessibilityLiveRegion(p1, p2);
        return;
    }

    public void setImportantForAccessibility(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompatJB.setImportantForAccessibility(p1, p2);
        return;
    }
}
