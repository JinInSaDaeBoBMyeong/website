package android.support.v4.accessibilityservice;
 class AccessibilityServiceInfoCompatIcs {

    AccessibilityServiceInfoCompatIcs()
    {
        return;
    }

    public static boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return p1.getCanRetrieveWindowContent();
    }

    public static String getDescription(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return p1.getDescription();
    }

    public static String getId(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return p1.getId();
    }

    public static android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return p1.getResolveInfo();
    }

    public static String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return p1.getSettingsActivityName();
    }
}
