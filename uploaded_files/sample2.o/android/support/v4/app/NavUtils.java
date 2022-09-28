package android.support.v4.app;
public class NavUtils {
    private static final android.support.v4.app.NavUtils$NavUtilsImpl IMPL = None;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    static NavUtils()
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            android.support.v4.app.NavUtils.IMPL = new android.support.v4.app.NavUtils$NavUtilsImplBase();
        } else {
            android.support.v4.app.NavUtils.IMPL = new android.support.v4.app.NavUtils$NavUtilsImplJB();
        }
        return;
    }

    private NavUtils()
    {
        return;
    }

    public static android.content.Intent getParentActivityIntent(android.app.Activity p1)
    {
        return android.support.v4.app.NavUtils.IMPL.getParentActivityIntent(p1);
    }

    public static android.content.Intent getParentActivityIntent(android.content.Context p5, android.content.ComponentName p6)
    {
        android.content.Intent v2;
        String v1 = android.support.v4.app.NavUtils.getParentActivityName(p5, p6);
        if (v1 != null) {
            android.content.ComponentName v3_1 = new android.content.ComponentName(p6.getPackageName(), v1);
            if (android.support.v4.app.NavUtils.getParentActivityName(p5, v3_1) != null) {
                v2 = new android.content.Intent().setComponent(v3_1);
            } else {
                v2 = android.support.v4.content.IntentCompat.makeMainActivity(v3_1);
            }
        } else {
            v2 = 0;
        }
        return v2;
    }

    public static android.content.Intent getParentActivityIntent(android.content.Context p5, Class p6)
    {
        android.content.Intent v2;
        String v1 = android.support.v4.app.NavUtils.getParentActivityName(p5, new android.content.ComponentName(p5, p6));
        if (v1 != null) {
            android.content.ComponentName v3_1 = new android.content.ComponentName(p5, v1);
            if (android.support.v4.app.NavUtils.getParentActivityName(p5, v3_1) != null) {
                v2 = new android.content.Intent().setComponent(v3_1);
            } else {
                v2 = android.support.v4.content.IntentCompat.makeMainActivity(v3_1);
            }
        } else {
            v2 = 0;
        }
        return v2;
    }

    public static String getParentActivityName(android.app.Activity p2)
    {
        try {
            return android.support.v4.app.NavUtils.getParentActivityName(p2, p2.getComponentName());
        } catch (android.content.pm.PackageManager$NameNotFoundException v0) {
            throw new IllegalArgumentException(v0);
        }
    }

    public static String getParentActivityName(android.content.Context p4, android.content.ComponentName p5)
    {
        return android.support.v4.app.NavUtils.IMPL.getParentActivityName(p4, p4.getPackageManager().getActivityInfo(p5, 128));
    }

    public static void navigateUpFromSameTask(android.app.Activity p4)
    {
        android.content.Intent v0 = android.support.v4.app.NavUtils.getParentActivityIntent(p4);
        if (v0 != null) {
            android.support.v4.app.NavUtils.navigateUpTo(p4, v0);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Activity ").append(p4.getClass().getSimpleName()).append(" does not have a parent activity name specified.").append(" (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> ").append(" element in your manifest?)").toString());
        }
    }

    public static void navigateUpTo(android.app.Activity p1, android.content.Intent p2)
    {
        android.support.v4.app.NavUtils.IMPL.navigateUpTo(p1, p2);
        return;
    }

    public static boolean shouldUpRecreateTask(android.app.Activity p1, android.content.Intent p2)
    {
        return android.support.v4.app.NavUtils.IMPL.shouldUpRecreateTask(p1, p2);
    }
}
