package android.support.v4.widget;
public class ContentLoadingProgressBar extends android.widget.ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    private boolean mDismissed;
    private boolean mPostedHide;
    private boolean mPostedShow;
    private long mStartTime;

    public ContentLoadingProgressBar(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public ContentLoadingProgressBar(android.content.Context p4, android.util.AttributeSet p5)
    {
        super(p4, p5, 0);
        super.mStartTime = -1;
        super.mPostedHide = 0;
        super.mPostedShow = 0;
        super.mDismissed = 0;
        super.mDelayedHide = new android.support.v4.widget.ContentLoadingProgressBar$1(super);
        super.mDelayedShow = new android.support.v4.widget.ContentLoadingProgressBar$2(super);
        return;
    }

    static synthetic boolean access$002(android.support.v4.widget.ContentLoadingProgressBar p0, boolean p1)
    {
        p0.mPostedHide = p1;
        return p1;
    }

    static synthetic long access$102(android.support.v4.widget.ContentLoadingProgressBar p1, long p2)
    {
        p1.mStartTime = p2;
        return p2;
    }

    static synthetic boolean access$202(android.support.v4.widget.ContentLoadingProgressBar p0, boolean p1)
    {
        p0.mPostedShow = p1;
        return p1;
    }

    static synthetic boolean access$300(android.support.v4.widget.ContentLoadingProgressBar p1)
    {
        return p1.mDismissed;
    }

    private void removeCallbacks()
    {
        this.removeCallbacks(this.mDelayedHide);
        this.removeCallbacks(this.mDelayedShow);
        return;
    }

    public void hide()
    {
        this.mDismissed = 1;
        this.removeCallbacks(this.mDelayedShow);
        long v0 = (System.currentTimeMillis() - this.mStartTime);
        if ((v0 < 500) && (this.mStartTime != -1)) {
            if (!this.mPostedHide) {
                this.postDelayed(this.mDelayedHide, (500 - v0));
                this.mPostedHide = 1;
            }
        } else {
            this.setVisibility(8);
        }
        return;
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        this.removeCallbacks();
        return;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        this.removeCallbacks();
        return;
    }

    public void show()
    {
        this.mStartTime = -1;
        this.mDismissed = 0;
        this.removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            this.postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = 1;
        }
        return;
    }
}
