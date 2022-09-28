package android.support.v4.widget;
 class EdgeEffectCompatIcs {

    EdgeEffectCompatIcs()
    {
        return;
    }

    public static boolean draw(Object p1, android.graphics.Canvas p2)
    {
        return ((android.widget.EdgeEffect) p1).draw(p2);
    }

    public static void finish(Object p0)
    {
        ((android.widget.EdgeEffect) p0).finish();
        return;
    }

    public static boolean isFinished(Object p1)
    {
        return ((android.widget.EdgeEffect) p1).isFinished();
    }

    public static Object newEdgeEffect(android.content.Context p1)
    {
        return new android.widget.EdgeEffect(p1);
    }

    public static boolean onAbsorb(Object p1, int p2)
    {
        ((android.widget.EdgeEffect) p1).onAbsorb(p2);
        return 1;
    }

    public static boolean onPull(Object p1, float p2)
    {
        ((android.widget.EdgeEffect) p1).onPull(p2);
        return 1;
    }

    public static boolean onRelease(Object p2)
    {
        ((android.widget.EdgeEffect) p2).onRelease();
        return ((android.widget.EdgeEffect) p2).isFinished();
    }

    public static void setSize(Object p0, int p1, int p2)
    {
        ((android.widget.EdgeEffect) p0).setSize(p1, p2);
        return;
    }
}
