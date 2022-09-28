package android.support.v4.accessibilityservice;
public class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = 255;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl IMPL;

    static AccessibilityServiceInfoCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 18) {
            if (android.os.Build$VERSION.SDK_INT < 14) {
                android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL = new android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl();
            } else {
                android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL = new android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl();
            }
        } else {
            android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL = new android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanMr2();
        }
        return;
    }

    private AccessibilityServiceInfoCompat()
    {
        return;
    }

    public static String capabilityToString(int p1)
    {
        String v0;
        switch (p1) {
            case 1:
                v0 = "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
                break;
            case 2:
                v0 = "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                v0 = "UNKNOWN";
                break;
            case 4:
                v0 = "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                break;
            case 8:
                v0 = "CAPABILITY_CAN_FILTER_KEY_EVENTS";
                break;
        }
        return v0;
    }

    public static String feedbackTypeToString(int p4)
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("[");
        while (p4 > 0) {
            int v1 = (1 << Integer.numberOfTrailingZeros(p4));
            p4 &= (v1 ^ -1);
            if (v0_1.length() > 1) {
                v0_1.append(", ");
            }
            switch (v1) {
                case 1:
                    v0_1.append("FEEDBACK_SPOKEN");
                    break;
                case 2:
                    v0_1.append("FEEDBACK_HAPTIC");
                    break;
                case 4:
                    v0_1.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    v0_1.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    v0_1.append("FEEDBACK_GENERIC");
                    break;
                default:
            }
        }
        v0_1.append("]");
        return v0_1.toString();
    }

    public static String flagToString(int p1)
    {
        String v0;
        switch (p1) {
            case 1:
                v0 = "DEFAULT";
                break;
            case 2:
                v0 = "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
                break;
            case 4:
                v0 = "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
                break;
            case 8:
                v0 = "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                break;
            case 16:
                v0 = "FLAG_REPORT_VIEW_IDS";
                break;
            case 32:
                v0 = "FLAG_REQUEST_FILTER_KEY_EVENTS";
                break;
            default:
                v0 = 0;
        }
        return v0;
    }

    public static boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL.getCanRetrieveWindowContent(p1);
    }

    public static int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL.getCapabilities(p1);
    }

    public static String getDescription(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL.getDescription(p1);
    }

    public static String getId(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL.getId(p1);
    }

    public static android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL.getResolveInfo(p1);
    }

    public static String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo p1)
    {
        return android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.IMPL.getSettingsActivityName(p1);
    }
}
