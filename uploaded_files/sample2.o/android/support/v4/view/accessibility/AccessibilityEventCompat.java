package android.support.v4.view.accessibility;
public class AccessibilityEventCompat {
    private static final android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventVersionImpl IMPL = None;
    public static final int TYPES_ALL_MASK = 255;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    static AccessibilityEventCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.view.accessibility.AccessibilityEventCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventStubImpl();
        } else {
            android.support.v4.view.accessibility.AccessibilityEventCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventIcsImpl();
        }
        return;
    }

    private AccessibilityEventCompat()
    {
        return;
    }

    public static void appendRecord(android.view.accessibility.AccessibilityEvent p2, android.support.v4.view.accessibility.AccessibilityRecordCompat p3)
    {
        android.support.v4.view.accessibility.AccessibilityEventCompat.IMPL.appendRecord(p2, p3.getImpl());
        return;
    }

    public static android.support.v4.view.accessibility.AccessibilityRecordCompat asRecord(android.view.accessibility.AccessibilityEvent p1)
    {
        return new android.support.v4.view.accessibility.AccessibilityRecordCompat(p1);
    }

    public static android.support.v4.view.accessibility.AccessibilityRecordCompat getRecord(android.view.accessibility.AccessibilityEvent p2, int p3)
    {
        return new android.support.v4.view.accessibility.AccessibilityRecordCompat(android.support.v4.view.accessibility.AccessibilityEventCompat.IMPL.getRecord(p2, p3));
    }

    public static int getRecordCount(android.view.accessibility.AccessibilityEvent p1)
    {
        return android.support.v4.view.accessibility.AccessibilityEventCompat.IMPL.getRecordCount(p1);
    }
}
