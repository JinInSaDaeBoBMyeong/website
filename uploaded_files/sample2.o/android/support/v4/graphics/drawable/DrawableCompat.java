package android.support.v4.graphics.drawable;
public class DrawableCompat {
    static final android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl IMPL;

    static DrawableCompat()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 19) {
            if (v0 < 11) {
                android.support.v4.graphics.drawable.DrawableCompat.IMPL = new android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl();
            } else {
                android.support.v4.graphics.drawable.DrawableCompat.IMPL = new android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl();
            }
        } else {
            android.support.v4.graphics.drawable.DrawableCompat.IMPL = new android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl();
        }
        return;
    }

    public DrawableCompat()
    {
        return;
    }

    public static boolean isAutoMirrored(android.graphics.drawable.Drawable p1)
    {
        return android.support.v4.graphics.drawable.DrawableCompat.IMPL.isAutoMirrored(p1);
    }

    public static void jumpToCurrentState(android.graphics.drawable.Drawable p1)
    {
        android.support.v4.graphics.drawable.DrawableCompat.IMPL.jumpToCurrentState(p1);
        return;
    }

    public static void setAutoMirrored(android.graphics.drawable.Drawable p1, boolean p2)
    {
        android.support.v4.graphics.drawable.DrawableCompat.IMPL.setAutoMirrored(p1, p2);
        return;
    }
}
