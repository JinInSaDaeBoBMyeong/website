package android.support.v4.view.accessibility;
 class AccessibilityNodeInfoCompatKitKat {

    AccessibilityNodeInfoCompatKitKat()
    {
        return;
    }

    public static int getLiveRegion(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getLiveRegion();
    }

    public static void setLiveRegion(Object p0, int p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setLiveRegion(p1);
        return;
    }
}
