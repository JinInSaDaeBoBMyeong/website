package android.support.v4.widget;
 class ScrollerCompat$ScrollerCompatImplBase implements android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl {

    ScrollerCompat$ScrollerCompatImplBase()
    {
        return;
    }

    public void abortAnimation(Object p1)
    {
        ((android.widget.Scroller) p1).abortAnimation();
        return;
    }

    public boolean computeScrollOffset(Object p3)
    {
        return ((android.widget.Scroller) p3).computeScrollOffset();
    }

    public Object createScroller(android.content.Context p2, android.view.animation.Interpolator p3)
    {
        android.widget.Scroller v0_1;
        if (p3 == null) {
            v0_1 = new android.widget.Scroller(p2);
        } else {
            v0_1 = new android.widget.Scroller(p2, p3);
        }
        return v0_1;
    }

    public void fling(Object p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18)
    {
        ((android.widget.Scroller) p10).fling(p11, p12, p13, p14, p15, p16, p17, p18);
        return;
    }

    public void fling(Object p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20)
    {
        ((android.widget.Scroller) p10).fling(p11, p12, p13, p14, p15, p16, p17, p18);
        return;
    }

    public float getCurrVelocity(Object p2)
    {
        return 0;
    }

    public int getCurrX(Object p2)
    {
        return ((android.widget.Scroller) p2).getCurrX();
    }

    public int getCurrY(Object p2)
    {
        return ((android.widget.Scroller) p2).getCurrY();
    }

    public int getFinalX(Object p2)
    {
        return ((android.widget.Scroller) p2).getFinalX();
    }

    public int getFinalY(Object p2)
    {
        return ((android.widget.Scroller) p2).getFinalY();
    }

    public boolean isFinished(Object p2)
    {
        return ((android.widget.Scroller) p2).isFinished();
    }

    public boolean isOverScrolled(Object p2)
    {
        return 0;
    }

    public void notifyHorizontalEdgeReached(Object p1, int p2, int p3, int p4)
    {
        return;
    }

    public void notifyVerticalEdgeReached(Object p1, int p2, int p3, int p4)
    {
        return;
    }

    public void startScroll(Object p1, int p2, int p3, int p4, int p5)
    {
        ((android.widget.Scroller) p1).startScroll(p2, p3, p4, p5);
        return;
    }

    public void startScroll(Object p7, int p8, int p9, int p10, int p11, int p12)
    {
        ((android.widget.Scroller) p7).startScroll(p8, p9, p10, p11, p12);
        return;
    }
}
