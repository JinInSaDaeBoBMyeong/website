package android.support.v4.view;
 class ViewGroupCompatIcs {

    ViewGroupCompatIcs()
    {
        return;
    }

    public static boolean onRequestSendAccessibilityEvent(android.view.ViewGroup p1, android.view.View p2, android.view.accessibility.AccessibilityEvent p3)
    {
        return p1.onRequestSendAccessibilityEvent(p2, p3);
    }
}
