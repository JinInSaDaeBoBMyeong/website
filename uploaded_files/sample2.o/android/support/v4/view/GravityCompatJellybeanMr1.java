package android.support.v4.view;
 class GravityCompatJellybeanMr1 {

    GravityCompatJellybeanMr1()
    {
        return;
    }

    public static void apply(int p0, int p1, int p2, android.graphics.Rect p3, int p4, int p5, android.graphics.Rect p6, int p7)
    {
        android.view.Gravity.apply(p0, p1, p2, p3, p4, p5, p6, p7);
        return;
    }

    public static void apply(int p0, int p1, int p2, android.graphics.Rect p3, android.graphics.Rect p4, int p5)
    {
        android.view.Gravity.apply(p0, p1, p2, p3, p4, p5);
        return;
    }

    public static void applyDisplay(int p0, android.graphics.Rect p1, android.graphics.Rect p2, int p3)
    {
        android.view.Gravity.applyDisplay(p0, p1, p2, p3);
        return;
    }

    public static int getAbsoluteGravity(int p1, int p2)
    {
        return android.view.Gravity.getAbsoluteGravity(p1, p2);
    }
}
