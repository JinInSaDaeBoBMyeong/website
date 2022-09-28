package android.support.v4.widget;
 class ScrollerCompatGingerbread {

    ScrollerCompatGingerbread()
    {
        return;
    }

    public static void abortAnimation(Object p0)
    {
        ((android.widget.OverScroller) p0).abortAnimation();
        return;
    }

    public static boolean computeScrollOffset(Object p1)
    {
        return ((android.widget.OverScroller) p1).computeScrollOffset();
    }

    public static Object createScroller(android.content.Context p1, android.view.animation.Interpolator p2)
    {
        android.widget.OverScroller v0_1;
        if (p2 == null) {
            v0_1 = new android.widget.OverScroller(p1);
        } else {
            v0_1 = new android.widget.OverScroller(p1, p2);
        }
        return v0_1;
    }

    public static void fling(Object p9, int p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17)
    {
        ((android.widget.OverScroller) p9).fling(p10, p11, p12, p13, p14, p15, p16, p17);
        return;
    }

    public static void fling(Object p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21)
    {
        ((android.widget.OverScroller) p11).fling(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
        return;
    }

    public static int getCurrX(Object p1)
    {
        return ((android.widget.OverScroller) p1).getCurrX();
    }

    public static int getCurrY(Object p1)
    {
        return ((android.widget.OverScroller) p1).getCurrY();
    }

    public static int getFinalX(Object p1)
    {
        return ((android.widget.OverScroller) p1).getFinalX();
    }

    public static int getFinalY(Object p1)
    {
        return ((android.widget.OverScroller) p1).getFinalY();
    }

    public static boolean isFinished(Object p1)
    {
        return ((android.widget.OverScroller) p1).isFinished();
    }

    public static boolean isOverScrolled(Object p1)
    {
        return ((android.widget.OverScroller) p1).isOverScrolled();
    }

    public static void notifyHorizontalEdgeReached(Object p0, int p1, int p2, int p3)
    {
        ((android.widget.OverScroller) p0).notifyHorizontalEdgeReached(p1, p2, p3);
        return;
    }

    public static void notifyVerticalEdgeReached(Object p0, int p1, int p2, int p3)
    {
        ((android.widget.OverScroller) p0).notifyVerticalEdgeReached(p1, p2, p3);
        return;
    }

    public static void startScroll(Object p0, int p1, int p2, int p3, int p4)
    {
        ((android.widget.OverScroller) p0).startScroll(p1, p2, p3, p4);
        return;
    }

    public static void startScroll(Object p6, int p7, int p8, int p9, int p10, int p11)
    {
        ((android.widget.OverScroller) p6).startScroll(p7, p8, p9, p10, p11);
        return;
    }
}
