package android.support.v4.content;
public class IntentCompat {
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    private static final android.support.v4.content.IntentCompat$IntentCompatImpl IMPL;

    static IntentCompat()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 15) {
            if (v0 < 11) {
                android.support.v4.content.IntentCompat.IMPL = new android.support.v4.content.IntentCompat$IntentCompatImplBase();
            } else {
                android.support.v4.content.IntentCompat.IMPL = new android.support.v4.content.IntentCompat$IntentCompatImplHC();
            }
        } else {
            android.support.v4.content.IntentCompat.IMPL = new android.support.v4.content.IntentCompat$IntentCompatImplIcsMr1();
        }
        return;
    }

    private IntentCompat()
    {
        return;
    }

    public static android.content.Intent makeMainActivity(android.content.ComponentName p1)
    {
        return android.support.v4.content.IntentCompat.IMPL.makeMainActivity(p1);
    }

    public static android.content.Intent makeMainSelectorActivity(String p1, String p2)
    {
        return android.support.v4.content.IntentCompat.IMPL.makeMainSelectorActivity(p1, p2);
    }

    public static android.content.Intent makeRestartActivityTask(android.content.ComponentName p1)
    {
        return android.support.v4.content.IntentCompat.IMPL.makeRestartActivityTask(p1);
    }
}
