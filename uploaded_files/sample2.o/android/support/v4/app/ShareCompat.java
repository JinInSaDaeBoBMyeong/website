package android.support.v4.app;
public class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static android.support.v4.app.ShareCompat$ShareCompatImpl IMPL;

    static ShareCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            if (android.os.Build$VERSION.SDK_INT < 14) {
                android.support.v4.app.ShareCompat.IMPL = new android.support.v4.app.ShareCompat$ShareCompatImplBase();
            } else {
                android.support.v4.app.ShareCompat.IMPL = new android.support.v4.app.ShareCompat$ShareCompatImplICS();
            }
        } else {
            android.support.v4.app.ShareCompat.IMPL = new android.support.v4.app.ShareCompat$ShareCompatImplJB();
        }
        return;
    }

    public ShareCompat()
    {
        return;
    }

    static synthetic android.support.v4.app.ShareCompat$ShareCompatImpl access$000()
    {
        return android.support.v4.app.ShareCompat.IMPL;
    }

    public static void configureMenuItem(android.view.Menu p4, int p5, android.support.v4.app.ShareCompat$IntentBuilder p6)
    {
        android.view.MenuItem v0 = p4.findItem(p5);
        if (v0 != null) {
            android.support.v4.app.ShareCompat.configureMenuItem(v0, p6);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Could not find menu item with id ").append(p5).append(" in the supplied menu").toString());
        }
    }

    public static void configureMenuItem(android.view.MenuItem p1, android.support.v4.app.ShareCompat$IntentBuilder p2)
    {
        android.support.v4.app.ShareCompat.IMPL.configureMenuItem(p1, p2);
        return;
    }

    public static android.content.ComponentName getCallingActivity(android.app.Activity p3)
    {
        android.content.ComponentName v0_0 = p3.getCallingActivity();
        if (v0_0 == null) {
            v0_0 = ((android.content.ComponentName) p3.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY"));
        }
        return v0_0;
    }

    public static String getCallingPackage(android.app.Activity p3)
    {
        String v0 = p3.getCallingPackage();
        if (v0 == null) {
            v0 = p3.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
        }
        return v0;
    }
}
