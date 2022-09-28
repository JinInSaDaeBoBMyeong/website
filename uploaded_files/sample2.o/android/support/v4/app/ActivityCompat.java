package android.support.v4.app;
public class ActivityCompat extends android.support.v4.content.ContextCompat {

    public ActivityCompat()
    {
        return;
    }

    public static void finishAffinity(android.app.Activity p2)
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            p2.finish();
        } else {
            android.support.v4.app.ActivityCompatJB.finishAffinity(p2);
        }
        return;
    }

    public static boolean invalidateOptionsMenu(android.app.Activity p2)
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 11) {
            v0_1 = 0;
        } else {
            android.support.v4.app.ActivityCompatHoneycomb.invalidateOptionsMenu(p2);
            v0_1 = 1;
        }
        return v0_1;
    }

    public static void startActivity(android.app.Activity p2, android.content.Intent p3, android.os.Bundle p4)
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            p2.startActivity(p3);
        } else {
            android.support.v4.app.ActivityCompatJB.startActivity(p2, p3, p4);
        }
        return;
    }

    public static void startActivityForResult(android.app.Activity p2, android.content.Intent p3, int p4, android.os.Bundle p5)
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            p2.startActivityForResult(p3, p4);
        } else {
            android.support.v4.app.ActivityCompatJB.startActivityForResult(p2, p3, p4, p5);
        }
        return;
    }
}
