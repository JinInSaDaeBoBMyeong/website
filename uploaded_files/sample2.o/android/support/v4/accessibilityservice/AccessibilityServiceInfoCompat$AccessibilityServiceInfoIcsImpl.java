package android.support.v4.accessibilityservice;
 class AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl extends android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl {

    AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl()
    {
        return;
    }

    public boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo p2)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(p2);
    }

    public int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo p2)
    {
        int v0_1;
        if (!this.getCanRetrieveWindowContent(p2)) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public String getDescription(android.accessibilityservice.AccessibilityServiceInfo p2)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getDescription(p2);
    }

    public String getId(android.accessibilityservice.AccessibilityServiceInfo p2)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getId(p2);
    }

    public android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo p2)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getResolveInfo(p2);
    }

    public String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo p2)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getSettingsActivityName(p2);
    }
}
