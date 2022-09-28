package android.support.v4.widget;
public class ScrollerCompat {
    static final int CHASE_FRAME_TIME = 16;
    private static final String TAG = "ScrollerCompat";
    android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl mImpl;
    Object mScroller;

    private ScrollerCompat(int p2, android.content.Context p3, android.view.animation.Interpolator p4)
    {
        if (p2 < 14) {
            if (p2 < 9) {
                this.mImpl = new android.support.v4.widget.ScrollerCompat$ScrollerCompatImplBase();
            } else {
                this.mImpl = new android.support.v4.widget.ScrollerCompat$ScrollerCompatImplGingerbread();
            }
        } else {
            this.mImpl = new android.support.v4.widget.ScrollerCompat$ScrollerCompatImplIcs();
        }
        this.mScroller = this.mImpl.createScroller(p3, p4);
        return;
    }

    ScrollerCompat(android.content.Context p2, android.view.animation.Interpolator p3)
    {
        this(android.os.Build$VERSION.SDK_INT, p2, p3);
        return;
    }

    public static android.support.v4.widget.ScrollerCompat create(android.content.Context p1)
    {
        return android.support.v4.widget.ScrollerCompat.create(p1, 0);
    }

    public static android.support.v4.widget.ScrollerCompat create(android.content.Context p1, android.view.animation.Interpolator p2)
    {
        return new android.support.v4.widget.ScrollerCompat(p1, p2);
    }

    public void abortAnimation()
    {
        this.mImpl.abortAnimation(this.mScroller);
        return;
    }

    public boolean computeScrollOffset()
    {
        return this.mImpl.computeScrollOffset(this.mScroller);
    }

    public void fling(int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18)
    {
        this.mImpl.fling(this.mScroller, p11, p12, p13, p14, p15, p16, p17, p18);
        return;
    }

    public void fling(int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22)
    {
        this.mImpl.fling(this.mScroller, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
        return;
    }

    public float getCurrVelocity()
    {
        return this.mImpl.getCurrVelocity(this.mScroller);
    }

    public int getCurrX()
    {
        return this.mImpl.getCurrX(this.mScroller);
    }

    public int getCurrY()
    {
        return this.mImpl.getCurrY(this.mScroller);
    }

    public int getFinalX()
    {
        return this.mImpl.getFinalX(this.mScroller);
    }

    public int getFinalY()
    {
        return this.mImpl.getFinalY(this.mScroller);
    }

    public boolean isFinished()
    {
        return this.mImpl.isFinished(this.mScroller);
    }

    public boolean isOverScrolled()
    {
        return this.mImpl.isOverScrolled(this.mScroller);
    }

    public void notifyHorizontalEdgeReached(int p3, int p4, int p5)
    {
        this.mImpl.notifyHorizontalEdgeReached(this.mScroller, p3, p4, p5);
        return;
    }

    public void notifyVerticalEdgeReached(int p3, int p4, int p5)
    {
        this.mImpl.notifyVerticalEdgeReached(this.mScroller, p3, p4, p5);
        return;
    }

    public void startScroll(int p7, int p8, int p9, int p10)
    {
        this.mImpl.startScroll(this.mScroller, p7, p8, p9, p10);
        return;
    }

    public void startScroll(int p8, int p9, int p10, int p11, int p12)
    {
        this.mImpl.startScroll(this.mScroller, p8, p9, p10, p11, p12);
        return;
    }
}
