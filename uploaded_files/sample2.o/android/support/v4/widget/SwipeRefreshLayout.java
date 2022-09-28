package android.support.v4.widget;
public class SwipeRefreshLayout extends android.view.ViewGroup {
    private static final float ACCELERATE_INTERPOLATION_FACTOR = 16320;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 64;
    private static final int INVALID_POINTER = 255;
    private static final int[] LAYOUT_ATTRS = None;
    private static final String LOG_TAG = "";
    private static final float MAX_SWIPE_DISTANCE_FACTOR = 1058642330;
    private static final float PROGRESS_BAR_HEIGHT = 16512;
    private static final int REFRESH_TRIGGER_DISTANCE = 120;
    private static final long RETURN_TO_ORIGINAL_POSITION_TIMEOUT = 300;
    private final android.view.animation.AccelerateInterpolator mAccelerateInterpolator;
    private int mActivePointerId;
    private final android.view.animation.Animation mAnimateToStartPosition;
    private final Runnable mCancel;
    private float mCurrPercentage;
    private int mCurrentTargetOffsetTop;
    private final android.view.animation.DecelerateInterpolator mDecelerateInterpolator;
    private float mDistanceToTriggerSync;
    private int mFrom;
    private float mFromPercentage;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private int mOriginalOffsetTop;
    private android.support.v4.widget.SwipeProgressBar mProgressBar;
    private int mProgressBarHeight;
    private boolean mRefreshing;
    private final Runnable mReturnToStartPosition;
    private final android.view.animation.Animation$AnimationListener mReturnToStartPositionListener;
    private boolean mReturningToStart;
    private final android.view.animation.Animation$AnimationListener mShrinkAnimationListener;
    private android.view.animation.Animation mShrinkTrigger;
    private android.view.View mTarget;
    private int mTouchSlop;

    static SwipeRefreshLayout()
    {
        android.support.v4.widget.SwipeRefreshLayout.LOG_TAG = android.support.v4.widget.SwipeRefreshLayout.getSimpleName();
        int[] v0_3 = new int[1];
        v0_3[0] = 16842766;
        android.support.v4.widget.SwipeRefreshLayout.LAYOUT_ATTRS = v0_3;
        return;
    }

    public SwipeRefreshLayout(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public SwipeRefreshLayout(android.content.Context p6, android.util.AttributeSet p7)
    {
        super(p6, p7);
        super.mRefreshing = 0;
        super.mDistanceToTriggerSync = -1082130432;
        super.mFromPercentage = 0;
        super.mCurrPercentage = 0;
        super.mActivePointerId = -1;
        super.mAnimateToStartPosition = new android.support.v4.widget.SwipeRefreshLayout$1(super);
        super.mShrinkTrigger = new android.support.v4.widget.SwipeRefreshLayout$2(super);
        super.mReturnToStartPositionListener = new android.support.v4.widget.SwipeRefreshLayout$3(super);
        super.mShrinkAnimationListener = new android.support.v4.widget.SwipeRefreshLayout$4(super);
        super.mReturnToStartPosition = new android.support.v4.widget.SwipeRefreshLayout$5(super);
        super.mCancel = new android.support.v4.widget.SwipeRefreshLayout$6(super);
        super.mTouchSlop = android.view.ViewConfiguration.get(p6).getScaledTouchSlop();
        super.mMediumAnimationDuration = super.getResources().getInteger(17694721);
        super.setWillNotDraw(0);
        super.mProgressBar = new android.support.v4.widget.SwipeProgressBar(super);
        super.mProgressBarHeight = ((int) (super.getResources().getDisplayMetrics().density * 1082130432));
        super.mDecelerateInterpolator = new android.view.animation.DecelerateInterpolator(1073741824);
        super.mAccelerateInterpolator = new android.view.animation.AccelerateInterpolator(1069547520);
        android.content.res.TypedArray v0 = p6.obtainStyledAttributes(p7, android.support.v4.widget.SwipeRefreshLayout.LAYOUT_ATTRS);
        super.setEnabled(v0.getBoolean(0, 1));
        v0.recycle();
        return;
    }

    static synthetic int access$000(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mFrom;
    }

    static synthetic int access$100(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mOriginalOffsetTop;
    }

    static synthetic android.view.animation.Animation$AnimationListener access$1000(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mReturnToStartPositionListener;
    }

    static synthetic void access$1100(android.support.v4.widget.SwipeRefreshLayout p0, int p1, android.view.animation.Animation$AnimationListener p2)
    {
        p0.animateOffsetToStartPosition(p1, p2);
        return;
    }

    static synthetic int access$1200(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mMediumAnimationDuration;
    }

    static synthetic android.view.animation.Animation access$1300(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mShrinkTrigger;
    }

    static synthetic android.view.animation.Animation$AnimationListener access$1400(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mShrinkAnimationListener;
    }

    static synthetic android.view.animation.DecelerateInterpolator access$1500(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mDecelerateInterpolator;
    }

    static synthetic android.view.View access$200(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mTarget;
    }

    static synthetic void access$300(android.support.v4.widget.SwipeRefreshLayout p0, int p1)
    {
        p0.setTargetOffsetTopAndBottom(p1);
        return;
    }

    static synthetic float access$400(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mFromPercentage;
    }

    static synthetic float access$402(android.support.v4.widget.SwipeRefreshLayout p0, float p1)
    {
        p0.mFromPercentage = p1;
        return p1;
    }

    static synthetic android.support.v4.widget.SwipeProgressBar access$500(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mProgressBar;
    }

    static synthetic int access$700(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mCurrentTargetOffsetTop;
    }

    static synthetic int access$702(android.support.v4.widget.SwipeRefreshLayout p0, int p1)
    {
        p0.mCurrentTargetOffsetTop = p1;
        return p1;
    }

    static synthetic float access$800(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        return p1.mCurrPercentage;
    }

    static synthetic float access$802(android.support.v4.widget.SwipeRefreshLayout p0, float p1)
    {
        p0.mCurrPercentage = p1;
        return p1;
    }

    static synthetic boolean access$902(android.support.v4.widget.SwipeRefreshLayout p0, boolean p1)
    {
        p0.mReturningToStart = p1;
        return p1;
    }

    private void animateOffsetToStartPosition(int p5, android.view.animation.Animation$AnimationListener p6)
    {
        this.mFrom = p5;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(((long) this.mMediumAnimationDuration));
        this.mAnimateToStartPosition.setAnimationListener(p6);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        this.mTarget.startAnimation(this.mAnimateToStartPosition);
        return;
    }

    private void ensureTarget()
    {
        if (this.mTarget == null) {
            if ((this.getChildCount() <= 1) || (this.isInEditMode())) {
                this.mTarget = this.getChildAt(0);
                this.mOriginalOffsetTop = (this.mTarget.getTop() + this.getPaddingTop());
            } else {
                throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
            }
        }
        if ((this.mDistanceToTriggerSync == -1082130432) && ((this.getParent() != null) && (((android.view.View) this.getParent()).getHeight() > 0))) {
            this.mDistanceToTriggerSync = ((float) ((int) Math.min((((float) ((android.view.View) this.getParent()).getHeight()) * 1058642330), (1123024896 * this.getResources().getDisplayMetrics().density))));
        }
        return;
    }

    private void onSecondaryPointerUp(android.view.MotionEvent p5)
    {
        int v2 = android.support.v4.view.MotionEventCompat.getActionIndex(p5);
        if (android.support.v4.view.MotionEventCompat.getPointerId(p5, v2) == this.mActivePointerId) {
            int v0;
            if (v2 != 0) {
                v0 = 0;
            } else {
                v0 = 1;
            }
            this.mLastMotionY = android.support.v4.view.MotionEventCompat.getY(p5, v0);
            this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p5, v0);
        }
        return;
    }

    private void setTargetOffsetTopAndBottom(int p2)
    {
        this.mTarget.offsetTopAndBottom(p2);
        this.mCurrentTargetOffsetTop = this.mTarget.getTop();
        return;
    }

    private void setTriggerPercentage(float p3)
    {
        if (p3 != 0) {
            this.mCurrPercentage = p3;
            this.mProgressBar.setTriggerPercentage(p3);
        } else {
            this.mCurrPercentage = 0;
        }
        return;
    }

    private void startRefresh()
    {
        this.removeCallbacks(this.mCancel);
        this.mReturnToStartPosition.run();
        this.setRefreshing(1);
        this.mListener.onRefresh();
        return;
    }

    private void updateContentOffsetTop(int p4)
    {
        int vtmp1 = this.mTarget.getTop();
        if (((float) p4) <= this.mDistanceToTriggerSync) {
            if (p4 < 0) {
                p4 = 0;
            }
        } else {
            p4 = ((int) this.mDistanceToTriggerSync);
        }
        this.setTargetOffsetTopAndBottom((p4 - vtmp1));
        return;
    }

    private void updatePositionTimeout()
    {
        this.removeCallbacks(this.mCancel);
        this.postDelayed(this.mCancel, 300);
        return;
    }

    public boolean canChildScrollUp()
    {
        int v1_0 = 1;
        if (android.os.Build$VERSION.SDK_INT >= 14) {
            v1_0 = android.support.v4.view.ViewCompat.canScrollVertically(this.mTarget, -1);
        } else {
            if (!(this.mTarget instanceof android.widget.AbsListView)) {
                if (this.mTarget.getScrollY() <= 0) {
                    v1_0 = 0;
                }
            } else {
                android.widget.AbsListView v0_1 = ((android.widget.AbsListView) this.mTarget);
                if ((v0_1.getChildCount() <= 0) || ((v0_1.getFirstVisiblePosition() <= 0) && (v0_1.getChildAt(0).getTop() >= v0_1.getPaddingTop()))) {
                    v1_0 = 0;
                }
            }
        }
        return v1_0;
    }

    public void draw(android.graphics.Canvas p2)
    {
        super.draw(p2);
        this.mProgressBar.draw(p2);
        return;
    }

    public boolean isRefreshing()
    {
        return this.mRefreshing;
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        this.removeCallbacks(this.mCancel);
        this.removeCallbacks(this.mReturnToStartPosition);
        return;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.mReturnToStartPosition);
        this.removeCallbacks(this.mCancel);
        return;
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent p9)
    {
        int v4_0 = 0;
        this.ensureTarget();
        int v0 = android.support.v4.view.MotionEventCompat.getActionMasked(p9);
        if ((this.mReturningToStart) && (v0 == 0)) {
            this.mReturningToStart = 0;
        }
        if ((this.isEnabled()) && ((!this.mReturningToStart) && (!this.canChildScrollUp()))) {
            switch (v0) {
                case 0:
                    String v5_7 = p9.getY();
                    this.mInitialMotionY = v5_7;
                    this.mLastMotionY = v5_7;
                    this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p9, 0);
                    this.mIsBeingDragged = 0;
                    this.mCurrPercentage = 0;
                    break;
                case 1:
                case 3:
                    this.mIsBeingDragged = 0;
                    this.mCurrPercentage = 0;
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    if (this.mActivePointerId != -1) {
                        int v1 = android.support.v4.view.MotionEventCompat.findPointerIndex(p9, this.mActivePointerId);
                        if (v1 >= 0) {
                            float v2 = android.support.v4.view.MotionEventCompat.getY(p9, v1);
                            if ((v2 - this.mInitialMotionY) <= ((float) this.mTouchSlop)) {
                            } else {
                                this.mLastMotionY = v2;
                                this.mIsBeingDragged = 1;
                            }
                        } else {
                            android.util.Log.e(android.support.v4.widget.SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        }
                    } else {
                        android.util.Log.e(android.support.v4.widget.SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but don\'t have an active pointer id.");
                    }
                    break;
                case 4:
                case 5:
                default:
                    break;
                case 4:
                case 5:
                    break;
                case 6:
                    this.onSecondaryPointerUp(p9);
                    break;
            }
            v4_0 = this.mIsBeingDragged;
        }
        return v4_0;
    }

    protected void onLayout(boolean p11, int p12, int p13, int p14, int p15)
    {
        int v6 = this.getMeasuredWidth();
        int v5 = this.getMeasuredHeight();
        this.mProgressBar.setBounds(0, 0, v6, this.mProgressBarHeight);
        if (this.getChildCount() != 0) {
            android.view.View v0 = this.getChildAt(0);
            int v2 = this.getPaddingLeft();
            int v3 = (this.mCurrentTargetOffsetTop + this.getPaddingTop());
            v0.layout(v2, v3, (v2 + ((v6 - this.getPaddingLeft()) - this.getPaddingRight())), (v3 + ((v5 - this.getPaddingTop()) - this.getPaddingBottom())));
        }
        return;
    }

    public void onMeasure(int p6, int p7)
    {
        super.onMeasure(p6, p7);
        if ((this.getChildCount() <= 1) || (this.isInEditMode())) {
            if (this.getChildCount() > 0) {
                this.getChildAt(0).measure(android.view.View$MeasureSpec.makeMeasureSpec(((this.getMeasuredWidth() - this.getPaddingLeft()) - this.getPaddingRight()), 1073741824), android.view.View$MeasureSpec.makeMeasureSpec(((this.getMeasuredHeight() - this.getPaddingTop()) - this.getPaddingBottom()), 1073741824));
            }
            return;
        } else {
            throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
        }
    }

    public boolean onTouchEvent(android.view.MotionEvent p10)
    {
        Runnable v5_0 = 0;
        int v0 = android.support.v4.view.MotionEventCompat.getActionMasked(p10);
        if ((this.mReturningToStart) && (v0 == 0)) {
            this.mReturningToStart = 0;
        }
        if ((this.isEnabled()) && ((!this.mReturningToStart) && (!this.canChildScrollUp()))) {
            switch (v0) {
                case 0:
                    int v7_9 = p10.getY();
                    this.mInitialMotionY = v7_9;
                    this.mLastMotionY = v7_9;
                    this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p10, 0);
                    this.mIsBeingDragged = 0;
                    this.mCurrPercentage = 0;
                    break;
                case 1:
                case 3:
                    this.mIsBeingDragged = 0;
                    this.mCurrPercentage = 0;
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int v2 = android.support.v4.view.MotionEventCompat.findPointerIndex(p10, this.mActivePointerId);
                    if (v2 >= 0) {
                        float v3 = android.support.v4.view.MotionEventCompat.getY(p10, v2);
                        float v4 = (v3 - this.mInitialMotionY);
                        if ((!this.mIsBeingDragged) && (v4 > ((float) this.mTouchSlop))) {
                            this.mIsBeingDragged = 1;
                        }
                        if (!this.mIsBeingDragged) {
                        } else {
                            if (v4 <= this.mDistanceToTriggerSync) {
                                this.setTriggerPercentage(this.mAccelerateInterpolator.getInterpolation((v4 / this.mDistanceToTriggerSync)));
                                this.updateContentOffsetTop(((int) v4));
                                if ((this.mLastMotionY <= v3) || (this.mTarget.getTop() != this.getPaddingTop())) {
                                    this.updatePositionTimeout();
                                } else {
                                    this.removeCallbacks(this.mCancel);
                                }
                            } else {
                                this.startRefresh();
                            }
                            this.mLastMotionY = v3;
                        }
                    } else {
                        android.util.Log.e(android.support.v4.widget.SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    }
                    break;
                case 4:
                default:
                    break;
                case 5:
                    int v1 = android.support.v4.view.MotionEventCompat.getActionIndex(p10);
                    this.mLastMotionY = android.support.v4.view.MotionEventCompat.getY(p10, v1);
                    this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p10, v1);
                    break;
                case 6:
                    this.onSecondaryPointerUp(p10);
                    break;
            }
            v5_0 = 1;
        }
        return v5_0;
    }

    public void requestDisallowInterceptTouchEvent(boolean p1)
    {
        return;
    }

    public void setColorScheme(int p1, int p2, int p3, int p4)
    {
        this.setColorSchemeResources(p1, p2, p3, p4);
        return;
    }

    public void setColorSchemeColors(int p2, int p3, int p4, int p5)
    {
        this.ensureTarget();
        this.mProgressBar.setColorScheme(p2, p3, p4, p5);
        return;
    }

    public void setColorSchemeResources(int p6, int p7, int p8, int p9)
    {
        android.content.res.Resources v0 = this.getResources();
        this.setColorSchemeColors(v0.getColor(p6), v0.getColor(p7), v0.getColor(p8), v0.getColor(p9));
        return;
    }

    public void setOnRefreshListener(android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener p1)
    {
        this.mListener = p1;
        return;
    }

    public void setRefreshing(boolean p2)
    {
        if (this.mRefreshing != p2) {
            this.ensureTarget();
            this.mCurrPercentage = 0;
            this.mRefreshing = p2;
            if (!this.mRefreshing) {
                this.mProgressBar.stop();
            } else {
                this.mProgressBar.start();
            }
        }
        return;
    }
}
