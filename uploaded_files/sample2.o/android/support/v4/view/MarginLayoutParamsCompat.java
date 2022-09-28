package android.support.v4.view;
public class MarginLayoutParamsCompat {
    static final android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl IMPL;

    static MarginLayoutParamsCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 17) {
            android.support.v4.view.MarginLayoutParamsCompat.IMPL = new android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase();
        } else {
            android.support.v4.view.MarginLayoutParamsCompat.IMPL = new android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImplJbMr1();
        }
        return;
    }

    public MarginLayoutParamsCompat()
    {
        return;
    }

    public static int getLayoutDirection(android.view.ViewGroup$MarginLayoutParams p1)
    {
        return android.support.v4.view.MarginLayoutParamsCompat.IMPL.getLayoutDirection(p1);
    }

    public static int getMarginEnd(android.view.ViewGroup$MarginLayoutParams p1)
    {
        return android.support.v4.view.MarginLayoutParamsCompat.IMPL.getMarginEnd(p1);
    }

    public static int getMarginStart(android.view.ViewGroup$MarginLayoutParams p1)
    {
        return android.support.v4.view.MarginLayoutParamsCompat.IMPL.getMarginStart(p1);
    }

    public static boolean isMarginRelative(android.view.ViewGroup$MarginLayoutParams p1)
    {
        return android.support.v4.view.MarginLayoutParamsCompat.IMPL.isMarginRelative(p1);
    }

    public static void resolveLayoutDirection(android.view.ViewGroup$MarginLayoutParams p1, int p2)
    {
        android.support.v4.view.MarginLayoutParamsCompat.IMPL.resolveLayoutDirection(p1, p2);
        return;
    }

    public static void setLayoutDirection(android.view.ViewGroup$MarginLayoutParams p1, int p2)
    {
        android.support.v4.view.MarginLayoutParamsCompat.IMPL.setLayoutDirection(p1, p2);
        return;
    }

    public static void setMarginEnd(android.view.ViewGroup$MarginLayoutParams p1, int p2)
    {
        android.support.v4.view.MarginLayoutParamsCompat.IMPL.setMarginEnd(p1, p2);
        return;
    }

    public static void setMarginStart(android.view.ViewGroup$MarginLayoutParams p1, int p2)
    {
        android.support.v4.view.MarginLayoutParamsCompat.IMPL.setMarginStart(p1, p2);
        return;
    }
}
