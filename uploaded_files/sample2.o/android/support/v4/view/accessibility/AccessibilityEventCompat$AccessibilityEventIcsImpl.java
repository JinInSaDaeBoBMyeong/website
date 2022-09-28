package android.support.v4.view.accessibility;
 class AccessibilityEventCompat$AccessibilityEventIcsImpl extends android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventStubImpl {

    AccessibilityEventCompat$AccessibilityEventIcsImpl()
    {
        return;
    }

    public void appendRecord(android.view.accessibility.AccessibilityEvent p1, Object p2)
    {
        android.support.v4.view.accessibility.AccessibilityEventCompatIcs.appendRecord(p1, p2);
        return;
    }

    public Object getRecord(android.view.accessibility.AccessibilityEvent p2, int p3)
    {
        return android.support.v4.view.accessibility.AccessibilityEventCompatIcs.getRecord(p2, p3);
    }

    public int getRecordCount(android.view.accessibility.AccessibilityEvent p2)
    {
        return android.support.v4.view.accessibility.AccessibilityEventCompatIcs.getRecordCount(p2);
    }
}
