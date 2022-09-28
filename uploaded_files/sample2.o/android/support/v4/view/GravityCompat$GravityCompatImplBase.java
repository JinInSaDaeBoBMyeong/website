package android.support.v4.view;
 class GravityCompat$GravityCompatImplBase implements android.support.v4.view.GravityCompat$GravityCompatImpl {

    GravityCompat$GravityCompatImplBase()
    {
        return;
    }

    public void apply(int p1, int p2, int p3, android.graphics.Rect p4, int p5, int p6, android.graphics.Rect p7, int p8)
    {
        android.view.Gravity.apply(p1, p2, p3, p4, p5, p6, p7);
        return;
    }

    public void apply(int p1, int p2, int p3, android.graphics.Rect p4, android.graphics.Rect p5, int p6)
    {
        android.view.Gravity.apply(p1, p2, p3, p4, p5);
        return;
    }

    public void applyDisplay(int p1, android.graphics.Rect p2, android.graphics.Rect p3, int p4)
    {
        android.view.Gravity.applyDisplay(p1, p2, p3);
        return;
    }

    public int getAbsoluteGravity(int p2, int p3)
    {
        return (-8388609 & p2);
    }
}
