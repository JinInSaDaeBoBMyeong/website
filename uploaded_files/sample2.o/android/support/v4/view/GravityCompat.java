package android.support.v4.view;
public class GravityCompat {
    public static final int END = 8388613;
    static final android.support.v4.view.GravityCompat$GravityCompatImpl IMPL = None;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    static GravityCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 17) {
            android.support.v4.view.GravityCompat.IMPL = new android.support.v4.view.GravityCompat$GravityCompatImplBase();
        } else {
            android.support.v4.view.GravityCompat.IMPL = new android.support.v4.view.GravityCompat$GravityCompatImplJellybeanMr1();
        }
        return;
    }

    public GravityCompat()
    {
        return;
    }

    public static void apply(int p9, int p10, int p11, android.graphics.Rect p12, int p13, int p14, android.graphics.Rect p15, int p16)
    {
        android.support.v4.view.GravityCompat.IMPL.apply(p9, p10, p11, p12, p13, p14, p15, p16);
        return;
    }

    public static void apply(int p7, int p8, int p9, android.graphics.Rect p10, android.graphics.Rect p11, int p12)
    {
        android.support.v4.view.GravityCompat.IMPL.apply(p7, p8, p9, p10, p11, p12);
        return;
    }

    public static void applyDisplay(int p1, android.graphics.Rect p2, android.graphics.Rect p3, int p4)
    {
        android.support.v4.view.GravityCompat.IMPL.applyDisplay(p1, p2, p3, p4);
        return;
    }

    public static int getAbsoluteGravity(int p1, int p2)
    {
        return android.support.v4.view.GravityCompat.IMPL.getAbsoluteGravity(p1, p2);
    }
}
