package android.support.v4.view.accessibility;
 class AccessibilityEventCompatIcs {

    AccessibilityEventCompatIcs()
    {
        return;
    }

    public static void appendRecord(android.view.accessibility.AccessibilityEvent p0, Object p1)
    {
        p0.appendRecord(((android.view.accessibility.AccessibilityRecord) p1));
        return;
    }

    public static Object getRecord(android.view.accessibility.AccessibilityEvent p1, int p2)
    {
        return p1.getRecord(p2);
    }

    public static int getRecordCount(android.view.accessibility.AccessibilityEvent p1)
    {
        return p1.getRecordCount();
    }
}
