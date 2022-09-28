package android.support.v4.widget;
public abstract class AutoScrollHelper implements android.view.View$OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = 2139095039;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 1045220557;
    private static final float DEFAULT_RELATIVE_VELOCITY = 16256;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = 2139095039;
    public static final float NO_MIN = 0;
    public static final float RELATIVE_UNSPECIFIED = 0;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    private boolean mAnimating;
    private final android.view.animation.Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    private boolean mNeedsCancel;
    private boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    private final android.support.v4.widget.AutoScrollHelper$ClampedScroller mScroller;
    private final android.view.View mTarget;

    static AutoScrollHelper()
    {
        android.support.v4.widget.AutoScrollHelper.DEFAULT_ACTIVATION_DELAY = android.view.ViewConfiguration.getTapTimeout();
        return;
    }

    public AutoScrollHelper(android.view.View p10)
    {
        this.mScroller = new android.support.v4.widget.AutoScrollHelper$ClampedScroller();
        this.mEdgeInterpolator = new android.view.animation.AccelerateInterpolator();
        int v3_1 = new float[2];
        v3_1 = {0, 0};
        this.mRelativeEdges = v3_1;
        int v3_2 = new float[2];
        v3_2 = {2139095039, 2139095039};
        this.mMaximumEdges = v3_2;
        int v3_3 = new float[2];
        v3_3 = {0, 0};
        this.mRelativeVelocity = v3_3;
        int v3_4 = new float[2];
        v3_4 = {0, 0};
        this.mMinimumVelocity = v3_4;
        int v3_5 = new float[2];
        v3_5 = {2139095039, 2139095039};
        this.mMaximumVelocity = v3_5;
        this.mTarget = p10;
        android.util.DisplayMetrics v1 = android.content.res.Resources.getSystem().getDisplayMetrics();
        int v0 = ((int) ((1153753088 * v1.density) + 1056964608));
        int v2 = ((int) ((1134395392 * v1.density) + 1056964608));
        this.setMaximumVelocity(((float) v0), ((float) v0));
        this.setMinimumVelocity(((float) v2), ((float) v2));
        this.setEdgeType(1);
        this.setMaximumEdges(2139095039, 2139095039);
        this.setRelativeEdges(1045220557, 1045220557);
        this.setRelativeVelocity(1065353216, 1065353216);
        this.setActivationDelay(android.support.v4.widget.AutoScrollHelper.DEFAULT_ACTIVATION_DELAY);
        this.setRampUpDuration(500);
        this.setRampDownDuration(500);
        return;
    }

    static synthetic boolean access$100(android.support.v4.widget.AutoScrollHelper p1)
    {
        return p1.mAnimating;
    }

    static synthetic boolean access$102(android.support.v4.widget.AutoScrollHelper p0, boolean p1)
    {
        p0.mAnimating = p1;
        return p1;
    }

    static synthetic boolean access$200(android.support.v4.widget.AutoScrollHelper p1)
    {
        return p1.mNeedsReset;
    }

    static synthetic boolean access$202(android.support.v4.widget.AutoScrollHelper p0, boolean p1)
    {
        p0.mNeedsReset = p1;
        return p1;
    }

    static synthetic android.support.v4.widget.AutoScrollHelper$ClampedScroller access$300(android.support.v4.widget.AutoScrollHelper p1)
    {
        return p1.mScroller;
    }

    static synthetic boolean access$400(android.support.v4.widget.AutoScrollHelper p1)
    {
        return p1.shouldAnimate();
    }

    static synthetic boolean access$500(android.support.v4.widget.AutoScrollHelper p1)
    {
        return p1.mNeedsCancel;
    }

    static synthetic boolean access$502(android.support.v4.widget.AutoScrollHelper p0, boolean p1)
    {
        p0.mNeedsCancel = p1;
        return p1;
    }

    static synthetic void access$600(android.support.v4.widget.AutoScrollHelper p0)
    {
        p0.cancelTargetTouch();
        return;
    }

    static synthetic android.view.View access$700(android.support.v4.widget.AutoScrollHelper p1)
    {
        return p1.mTarget;
    }

    static synthetic int access$800(int p1, int p2, int p3)
    {
        return android.support.v4.widget.AutoScrollHelper.constrain(p1, p2, p3);
    }

    static synthetic float access$900(float p1, float p2, float p3)
    {
        return android.support.v4.widget.AutoScrollHelper.constrain(p1, p2, p3);
    }

    private void cancelTargetTouch()
    {
        long v0 = android.os.SystemClock.uptimeMillis();
        android.view.MotionEvent v8 = android.view.MotionEvent.obtain(v0, v0, 3, 0, 0, 0);
        this.mTarget.onTouchEvent(v8);
        v8.recycle();
        return;
    }

    private float computeTargetVelocity(int p10, float p11, float p12, float p13)
    {
        float v7_0 = 0;
        float v6 = this.getEdgeValue(this.mRelativeEdges[p10], p12, this.mMaximumEdges[p10], p11);
        if (v6 != 0) {
            float v2 = this.mMinimumVelocity[p10];
            float v1 = this.mMaximumVelocity[p10];
            float v5 = (this.mRelativeVelocity[p10] * p13);
            if (v6 <= 0) {
                v7_0 = (- android.support.v4.widget.AutoScrollHelper.constrain(((- v6) * v5), v2, v1));
            } else {
                v7_0 = android.support.v4.widget.AutoScrollHelper.constrain((v6 * v5), v2, v1);
            }
        }
        return v7_0;
    }

    private static float constrain(float p1, float p2, float p3)
    {
        if (p1 <= p3) {
            if (p1 >= p2) {
                p3 = p1;
            } else {
                p3 = p2;
            }
        }
        return p3;
    }

    private static int constrain(int p0, int p1, int p2)
    {
        if (p0 <= p2) {
            if (p0 >= p1) {
                p2 = p0;
            } else {
                p2 = p1;
            }
        }
        return p2;
    }

    private float constrainEdgeValue(float p5, float p6)
    {
        float v0_0 = 0;
        if (p6 != 0) {
            switch (this.mEdgeType) {
                case 0:
                case 1:
                    if (p5 < p6) {
                        if (p5 < 0) {
                            if ((this.mAnimating) && (this.mEdgeType == 1)) {
                                v0_0 = 1065353216;
                            }
                        } else {
                            v0_0 = (1065353216 - (p5 / p6));
                        }
                    }
                    break;
                case 2:
                    if (p5 < 0) {
                        v0_0 = (p5 / (- p6));
                    }
                    break;
                default:
            }
        }
        return v0_0;
    }

    private float getEdgeValue(float p8, float p9, float p10, float p11)
    {
        float v1;
        android.view.animation.Interpolator v5_0 = 0;
        float v0 = android.support.v4.widget.AutoScrollHelper.constrain((p8 * p9), 0, p10);
        float v2 = (this.constrainEdgeValue((p9 - p11), v0) - this.constrainEdgeValue(p11, v0));
        if (v2 >= 0) {
            if (v2 > 0) {
                v1 = this.mEdgeInterpolator.getInterpolation(v2);
                v5_0 = android.support.v4.widget.AutoScrollHelper.constrain(v1, -1082130432, 1065353216);
            }
        } else {
            v1 = (- this.mEdgeInterpolator.getInterpolation((- v2)));
        }
        return v5_0;
    }

    private void requestStop()
    {
        if (!this.mNeedsReset) {
            this.mScroller.requestStop();
        } else {
            this.mAnimating = 0;
        }
        return;
    }

    private boolean shouldAnimate()
    {
        int v3_1;
        android.support.v4.widget.AutoScrollHelper$ClampedScroller v1 = this.mScroller;
        int v2 = v1.getVerticalDirection();
        int v0 = v1.getHorizontalDirection();
        if (((v2 == 0) || (!this.canTargetScrollVertically(v2))) && ((v0 == 0) || (!this.canTargetScrollHorizontally(v0)))) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        return v3_1;
    }

    private void startAnimating()
    {
        if (this.mRunnable == null) {
            this.mRunnable = new android.support.v4.widget.AutoScrollHelper$ScrollAnimationRunnable(this, 0);
        }
        this.mAnimating = 1;
        this.mNeedsReset = 1;
        if ((this.mAlreadyDelayed) || (this.mActivationDelay <= 0)) {
            this.mRunnable.run();
        } else {
            android.support.v4.view.ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, ((long) this.mActivationDelay));
        }
        this.mAlreadyDelayed = 1;
        return;
    }

    public abstract boolean canTargetScrollHorizontally();

    public abstract boolean canTargetScrollVertically();

    public boolean isEnabled()
    {
        return this.mEnabled;
    }

    public boolean isExclusive()
    {
        return this.mExclusive;
    }

    public boolean onTouch(android.view.View p9, android.view.MotionEvent p10)
    {
        int v3 = 1;
        int v4 = 0;
        if (this.mEnabled) {
            switch (android.support.v4.view.MotionEventCompat.getActionMasked(p10)) {
                case 0:
                    this.mNeedsCancel = 1;
                    this.mAlreadyDelayed = 0;
                    this.mScroller.setTargetVelocity(this.computeTargetVelocity(0, p10.getX(), ((float) p9.getWidth()), ((float) this.mTarget.getWidth())), this.computeTargetVelocity(1, p10.getY(), ((float) p9.getHeight()), ((float) this.mTarget.getHeight())));
                    if ((this.mAnimating) || (!this.shouldAnimate())) {
                    } else {
                        this.startAnimating();
                    }
                    break;
                case 1:
                case 3:
                    this.requestStop();
                    break;
                default:
                    if (!this.mExclusive) {
                        v3 = 0;
                        v4 = v3;
                    } else {
                        if (!this.mAnimating) {
                        } else {
                        }
                    }
            }
            if ((!this.mExclusive) || (!this.mAnimating)) {
            }
        }
        return v4;
    }

    public abstract void scrollTargetBy();

    public android.support.v4.widget.AutoScrollHelper setActivationDelay(int p1)
    {
        this.mActivationDelay = p1;
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setEdgeType(int p1)
    {
        this.mEdgeType = p1;
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setEnabled(boolean p2)
    {
        if ((this.mEnabled) && (!p2)) {
            this.requestStop();
        }
        this.mEnabled = p2;
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setExclusive(boolean p1)
    {
        this.mExclusive = p1;
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setMaximumEdges(float p3, float p4)
    {
        this.mMaximumEdges[0] = p3;
        this.mMaximumEdges[1] = p4;
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setMaximumVelocity(float p5, float p6)
    {
        this.mMaximumVelocity[0] = (p5 / 1148846080);
        this.mMaximumVelocity[1] = (p6 / 1148846080);
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setMinimumVelocity(float p5, float p6)
    {
        this.mMinimumVelocity[0] = (p5 / 1148846080);
        this.mMinimumVelocity[1] = (p6 / 1148846080);
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setRampDownDuration(int p2)
    {
        this.mScroller.setRampDownDuration(p2);
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setRampUpDuration(int p2)
    {
        this.mScroller.setRampUpDuration(p2);
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setRelativeEdges(float p3, float p4)
    {
        this.mRelativeEdges[0] = p3;
        this.mRelativeEdges[1] = p4;
        return this;
    }

    public android.support.v4.widget.AutoScrollHelper setRelativeVelocity(float p5, float p6)
    {
        this.mRelativeVelocity[0] = (p5 / 1148846080);
        this.mRelativeVelocity[1] = (p6 / 1148846080);
        return this;
    }
}
