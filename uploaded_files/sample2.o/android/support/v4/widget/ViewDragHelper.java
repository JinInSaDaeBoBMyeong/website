package android.support.v4.widget;
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = 255;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final android.view.animation.Interpolator sInterpolator;
    private int mActivePointerId;
    private final android.support.v4.widget.ViewDragHelper$Callback mCallback;
    private android.view.View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final android.view.ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private android.support.v4.widget.ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private android.view.VelocityTracker mVelocityTracker;

    static ViewDragHelper()
    {
        android.support.v4.widget.ViewDragHelper.sInterpolator = new android.support.v4.widget.ViewDragHelper$1();
        return;
    }

    private ViewDragHelper(android.content.Context p5, android.view.ViewGroup p6, android.support.v4.widget.ViewDragHelper$Callback p7)
    {
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new android.support.v4.widget.ViewDragHelper$2(this);
        if (p6 != null) {
            if (p7 != null) {
                this.mParentView = p6;
                this.mCallback = p7;
                android.view.ViewConfiguration v1 = android.view.ViewConfiguration.get(p5);
                this.mEdgeSize = ((int) ((1101004800 * p5.getResources().getDisplayMetrics().density) + 1056964608));
                this.mTouchSlop = v1.getScaledTouchSlop();
                this.mMaxVelocity = ((float) v1.getScaledMaximumFlingVelocity());
                this.mMinVelocity = ((float) v1.getScaledMinimumFlingVelocity());
                this.mScroller = android.support.v4.widget.ScrollerCompat.create(p5, android.support.v4.widget.ViewDragHelper.sInterpolator);
                return;
            } else {
                throw new IllegalArgumentException("Callback may not be null");
            }
        } else {
            throw new IllegalArgumentException("Parent view may not be null");
        }
    }

    private boolean checkNewEdgeDrag(float p6, float p7, int p8, int p9)
    {
        int v2 = 0;
        float v0 = Math.abs(p6);
        float v1 = Math.abs(p7);
        if (((this.mInitialEdgesTouched[p8] & p9) == p9) && (((this.mTrackingEdges & p9) != 0) && (((this.mEdgeDragsLocked[p8] & p9) != p9) && (((this.mEdgeDragsInProgress[p8] & p9) != p9) && ((v0 > ((float) this.mTouchSlop)) || (v1 > ((float) this.mTouchSlop))))))) {
            if ((v0 >= (1056964608 * v1)) || (!this.mCallback.onEdgeLock(p9))) {
                if (((this.mEdgeDragsInProgress[p8] & p9) == 0) && (v0 > ((float) this.mTouchSlop))) {
                    v2 = 1;
                }
            } else {
                float v3_24 = this.mEdgeDragsLocked;
                v3_24[p8] = (v3_24[p8] | p9);
            }
        }
        return v2;
    }

    private boolean checkTouchSlop(android.view.View p8, float p9, float p10)
    {
        int v2 = 1;
        if (p8 != null) {
            int v0;
            if (this.mCallback.getViewHorizontalDragRange(p8) <= 0) {
                v0 = 0;
            } else {
                v0 = 1;
            }
            int v1;
            if (this.mCallback.getViewVerticalDragRange(p8) <= 0) {
                v1 = 0;
            } else {
                v1 = 1;
            }
            if ((v0 == 0) || (v1 == 0)) {
                if (v0 == 0) {
                    if (v1 == 0) {
                        v2 = 0;
                    } else {
                        if (Math.abs(p10) <= ((float) this.mTouchSlop)) {
                            v2 = 0;
                        }
                    }
                } else {
                    if (Math.abs(p9) <= ((float) this.mTouchSlop)) {
                        v2 = 0;
                    }
                }
            } else {
                if (((p9 * p9) + (p10 * p10)) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                    v2 = 0;
                }
            }
        } else {
            v2 = 0;
        }
        return v2;
    }

    private float clampMag(float p4, float p5, float p6)
    {
        float v0 = Math.abs(p4);
        if (v0 >= p5) {
            if (v0 <= p6) {
                p6 = p4;
            } else {
                if (p4 <= 0) {
                    p6 = (- p6);
                }
            }
        } else {
            p6 = 0;
        }
        return p6;
    }

    private int clampMag(int p2, int p3, int p4)
    {
        int v0 = Math.abs(p2);
        if (v0 >= p3) {
            if (v0 <= p4) {
                p4 = p2;
            } else {
                if (p2 <= 0) {
                    p4 = (- p4);
                }
            }
        } else {
            p4 = 0;
        }
        return p4;
    }

    private void clearMotionHistory()
    {
        if (this.mInitialMotionX != null) {
            java.util.Arrays.fill(this.mInitialMotionX, 0);
            java.util.Arrays.fill(this.mInitialMotionY, 0);
            java.util.Arrays.fill(this.mLastMotionX, 0);
            java.util.Arrays.fill(this.mLastMotionY, 0);
            java.util.Arrays.fill(this.mInitialEdgesTouched, 0);
            java.util.Arrays.fill(this.mEdgeDragsInProgress, 0);
            java.util.Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
        return;
    }

    private void clearMotionHistory(int p4)
    {
        if (this.mInitialMotionX != null) {
            this.mInitialMotionX[p4] = 0;
            this.mInitialMotionY[p4] = 0;
            this.mLastMotionX[p4] = 0;
            this.mLastMotionY[p4] = 0;
            this.mInitialEdgesTouched[p4] = 0;
            this.mEdgeDragsInProgress[p4] = 0;
            this.mEdgeDragsLocked[p4] = 0;
            this.mPointersDown = (this.mPointersDown & ((1 << p4) ^ -1));
        }
        return;
    }

    private int computeAxisDuration(int p11, int p12, int p13)
    {
        int v6_11;
        if (p11 != 0) {
            int v2;
            int v5 = this.mParentView.getWidth();
            int v3 = (v5 / 2);
            float v0 = (((float) v3) + (((float) v3) * this.distanceInfluenceForSnapDuration(Math.min(1065353216, (((float) Math.abs(p11)) / ((float) v5))))));
            int v12_1 = Math.abs(p12);
            if (v12_1 <= 0) {
                v2 = ((int) (((((float) Math.abs(p11)) / ((float) p13)) + 1065353216) * 1132462080));
            } else {
                v2 = (Math.round((1148846080 * Math.abs((v0 / ((float) v12_1))))) * 4);
            }
            v6_11 = Math.min(v2, 600);
        } else {
            v6_11 = 0;
        }
        return v6_11;
    }

    private int computeSettleDuration(android.view.View p15, int p16, int p17, int p18, int p19)
    {
        float v9;
        int v18_1 = this.clampMag(p18, ((int) this.mMinVelocity), ((int) this.mMaxVelocity));
        int v19_1 = this.clampMag(p19, ((int) this.mMinVelocity), ((int) this.mMaxVelocity));
        int v2 = Math.abs(p16);
        int v3 = Math.abs(p17);
        int v4 = Math.abs(v18_1);
        int v5 = Math.abs(v19_1);
        int v7 = (v4 + v5);
        int v6 = (v2 + v3);
        if (v18_1 == 0) {
            v9 = (((float) v2) / ((float) v6));
        } else {
            v9 = (((float) v4) / ((float) v7));
        }
        float v11;
        if (v19_1 == 0) {
            v11 = (((float) v3) / ((float) v6));
        } else {
            v11 = (((float) v5) / ((float) v7));
        }
        return ((int) ((((float) this.computeAxisDuration(p16, v18_1, this.mCallback.getViewHorizontalDragRange(p15))) * v9) + (((float) this.computeAxisDuration(p17, v19_1, this.mCallback.getViewVerticalDragRange(p15))) * v11)));
    }

    public static android.support.v4.widget.ViewDragHelper create(android.view.ViewGroup p3, float p4, android.support.v4.widget.ViewDragHelper$Callback p5)
    {
        android.support.v4.widget.ViewDragHelper v0 = android.support.v4.widget.ViewDragHelper.create(p3, p5);
        v0.mTouchSlop = ((int) (((float) v0.mTouchSlop) * (1065353216 / p4)));
        return v0;
    }

    public static android.support.v4.widget.ViewDragHelper create(android.view.ViewGroup p2, android.support.v4.widget.ViewDragHelper$Callback p3)
    {
        return new android.support.v4.widget.ViewDragHelper(p2.getContext(), p2, p3);
    }

    private void dispatchViewReleased(float p5, float p6)
    {
        this.mReleaseInProgress = 1;
        this.mCallback.onViewReleased(this.mCapturedView, p5, p6);
        this.mReleaseInProgress = 0;
        if (this.mDragState == 1) {
            this.setDragState(0);
        }
        return;
    }

    private float distanceInfluenceForSnapDuration(float p5)
    {
        return ((float) Math.sin(((double) ((float) (((double) (p5 - 1056964608)) * 0.4712389167638204)))));
    }

    private void dragTo(int p9, int p10, int p11, int p12)
    {
        int v2 = p9;
        int v3 = p10;
        int v6 = this.mCapturedView.getLeft();
        int v7 = this.mCapturedView.getTop();
        if (p11 != 0) {
            v2 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, p9, p11);
            this.mCapturedView.offsetLeftAndRight((v2 - v6));
        }
        if (p12 != 0) {
            v3 = this.mCallback.clampViewPositionVertical(this.mCapturedView, p10, p12);
            this.mCapturedView.offsetTopAndBottom((v3 - v7));
        }
        if ((p11 != 0) || (p12 != 0)) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, v2, v3, (v2 - v6), (v3 - v7));
        }
        return;
    }

    private void ensureMotionHistorySizeForId(int p11)
    {
        if ((this.mInitialMotionX == null) || (this.mInitialMotionX.length <= p11)) {
            float[] v3 = new float[(p11 + 1)];
            float[] v4 = new float[(p11 + 1)];
            float[] v5 = new float[(p11 + 1)];
            float[] v6 = new float[(p11 + 1)];
            int[] v2 = new int[(p11 + 1)];
            int[] v0 = new int[(p11 + 1)];
            int[] v1 = new int[(p11 + 1)];
            if (this.mInitialMotionX != null) {
                System.arraycopy(this.mInitialMotionX, 0, v3, 0, this.mInitialMotionX.length);
                System.arraycopy(this.mInitialMotionY, 0, v4, 0, this.mInitialMotionY.length);
                System.arraycopy(this.mLastMotionX, 0, v5, 0, this.mLastMotionX.length);
                System.arraycopy(this.mLastMotionY, 0, v6, 0, this.mLastMotionY.length);
                System.arraycopy(this.mInitialEdgesTouched, 0, v2, 0, this.mInitialEdgesTouched.length);
                System.arraycopy(this.mEdgeDragsInProgress, 0, v0, 0, this.mEdgeDragsInProgress.length);
                System.arraycopy(this.mEdgeDragsLocked, 0, v1, 0, this.mEdgeDragsLocked.length);
            }
            this.mInitialMotionX = v3;
            this.mInitialMotionY = v4;
            this.mLastMotionX = v5;
            this.mLastMotionY = v6;
            this.mInitialEdgesTouched = v2;
            this.mEdgeDragsInProgress = v0;
            this.mEdgeDragsLocked = v1;
        }
        return;
    }

    private boolean forceSettleCapturedViewAt(int p12, int p13, int p14, int p15)
    {
        int v0_0 = 0;
        int v10 = this.mCapturedView.getLeft();
        int v6 = this.mCapturedView.getTop();
        int v2 = (p12 - v10);
        int v3 = (p13 - v6);
        if ((v2 != 0) || (v3 != 0)) {
            this.mScroller.startScroll(v10, v6, v2, v3, this.computeSettleDuration(this.mCapturedView, v2, v3, p14, p15));
            this.setDragState(2);
            v0_0 = 1;
        } else {
            this.mScroller.abortAnimation();
            this.setDragState(0);
        }
        return v0_0;
    }

    private int getEdgesTouched(int p4, int p5)
    {
        int v0 = 0;
        if (p4 < (this.mParentView.getLeft() + this.mEdgeSize)) {
            v0 = (0 | 1);
        }
        if (p5 < (this.mParentView.getTop() + this.mEdgeSize)) {
            v0 |= 4;
        }
        if (p4 > (this.mParentView.getRight() - this.mEdgeSize)) {
            v0 |= 2;
        }
        if (p5 > (this.mParentView.getBottom() - this.mEdgeSize)) {
            v0 |= 8;
        }
        return v0;
    }

    private void releaseViewForPointerUp()
    {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(android.support.v4.view.VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(android.support.v4.view.VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
        return;
    }

    private void reportNewEdgeDrags(float p4, float p5, int p6)
    {
        int v0 = 0;
        if (this.checkNewEdgeDrag(p4, p5, p6, 1)) {
            v0 = (0 | 1);
        }
        if (this.checkNewEdgeDrag(p5, p4, p6, 4)) {
            v0 |= 4;
        }
        if (this.checkNewEdgeDrag(p4, p5, p6, 2)) {
            v0 |= 2;
        }
        if (this.checkNewEdgeDrag(p5, p4, p6, 8)) {
            v0 |= 8;
        }
        if (v0 != 0) {
            android.support.v4.widget.ViewDragHelper$Callback v1_5 = this.mEdgeDragsInProgress;
            v1_5[p6] = (v1_5[p6] | v0);
            this.mCallback.onEdgeDragStarted(v0, p6);
        }
        return;
    }

    private void saveInitialMotion(float p4, float p5, int p6)
    {
        this.ensureMotionHistorySizeForId(p6);
        int v0_0 = this.mInitialMotionX;
        this.mLastMotionX[p6] = p4;
        v0_0[p6] = p4;
        int v0_3 = this.mInitialMotionY;
        this.mLastMotionY[p6] = p5;
        v0_3[p6] = p5;
        this.mInitialEdgesTouched[p6] = this.getEdgesTouched(((int) p4), ((int) p5));
        this.mPointersDown = (this.mPointersDown | (1 << p6));
        return;
    }

    private void saveLastMotion(android.view.MotionEvent p7)
    {
        int v1 = android.support.v4.view.MotionEventCompat.getPointerCount(p7);
        int v0 = 0;
        while (v0 < v1) {
            int v2 = android.support.v4.view.MotionEventCompat.getPointerId(p7, v0);
            float v3 = android.support.v4.view.MotionEventCompat.getX(p7, v0);
            float v4 = android.support.v4.view.MotionEventCompat.getY(p7, v0);
            this.mLastMotionX[v2] = v3;
            this.mLastMotionY[v2] = v4;
            v0++;
        }
        return;
    }

    public void abort()
    {
        this.cancel();
        if (this.mDragState == 2) {
            int v6 = this.mScroller.getCurrX();
            int v7 = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, v2, v3, (v2 - v6), (v3 - v7));
        }
        this.setDragState(0);
        return;
    }

    protected boolean canScroll(android.view.View p14, boolean p15, int p16, int p17, int p18, int p19)
    {
        int v1_5;
        if (!(p14 instanceof android.view.ViewGroup)) {
            if ((!p15) || ((!android.support.v4.view.ViewCompat.canScrollHorizontally(p14, (- p16))) && (!android.support.v4.view.ViewCompat.canScrollVertically(p14, (- p17))))) {
                v1_5 = 0;
            } else {
                v1_5 = 1;
            }
        } else {
            int v11 = p14.getScrollX();
            int v12 = p14.getScrollY();
            int v10 = (((android.view.ViewGroup) p14).getChildCount() - 1);
            while (v10 >= 0) {
                android.view.View v2 = ((android.view.ViewGroup) p14).getChildAt(v10);
                if (((p18 + v11) < v2.getLeft()) || (((p18 + v11) >= v2.getRight()) || (((p19 + v12) < v2.getTop()) || (((p19 + v12) >= v2.getBottom()) || (!this.canScroll(v2, 1, p16, p17, ((p18 + v11) - v2.getLeft()), ((p19 + v12) - v2.getTop()))))))) {
                    v10--;
                } else {
                    v1_5 = 1;
                }
            }
        }
        return v1_5;
    }

    public void cancel()
    {
        this.mActivePointerId = -1;
        this.clearMotionHistory();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = 0;
        }
        return;
    }

    public void captureChildView(android.view.View p4, int p5)
    {
        if (p4.getParent() == this.mParentView) {
            this.mCapturedView = p4;
            this.mActivePointerId = p5;
            this.mCallback.onViewCaptured(p4, p5);
            this.setDragState(1);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("captureChildView: parameter must be a descendant of the ViewDragHelper\'s tracked parent view (").append(this.mParentView).append(")").toString());
        }
    }

    public boolean checkTouchSlop(int p4)
    {
        int v1 = 0;
        while (v1 < this.mInitialMotionX.length) {
            if (!this.checkTouchSlop(p4, v1)) {
                v1++;
            } else {
                int v2_1 = 1;
            }
            return v2_1;
        }
        v2_1 = 0;
        return v2_1;
    }

    public boolean checkTouchSlop(int p10, int p11)
    {
        int v4 = 1;
        if (this.isPointerDown(p11)) {
            int v0;
            if ((p10 & 1) != 1) {
                v0 = 0;
            } else {
                v0 = 1;
            }
            int v1;
            if ((p10 & 2) != 2) {
                v1 = 0;
            } else {
                v1 = 1;
            }
            float v2 = (this.mLastMotionX[p11] - this.mInitialMotionX[p11]);
            float v3 = (this.mLastMotionY[p11] - this.mInitialMotionY[p11]);
            if ((v0 == 0) || (v1 == 0)) {
                if (v0 == 0) {
                    if (v1 == 0) {
                        v4 = 0;
                    } else {
                        if (Math.abs(v3) <= ((float) this.mTouchSlop)) {
                            v4 = 0;
                        }
                    }
                } else {
                    if (Math.abs(v2) <= ((float) this.mTouchSlop)) {
                        v4 = 0;
                    }
                }
            } else {
                if (((v2 * v2) + (v3 * v3)) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                    v4 = 0;
                }
            }
        } else {
            v4 = 0;
        }
        return v4;
    }

    public boolean continueSettling(boolean p10)
    {
        if (this.mDragState == 2) {
            boolean v6 = this.mScroller.computeScrollOffset();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            int v4 = (v2 - this.mCapturedView.getLeft());
            int v5 = (v3 - this.mCapturedView.getTop());
            if (v4 != 0) {
                this.mCapturedView.offsetLeftAndRight(v4);
            }
            if (v5 != 0) {
                this.mCapturedView.offsetTopAndBottom(v5);
            }
            if ((v4 != 0) || (v5 != 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, v2, v3, v4, v5);
            }
            if ((v6) && ((v2 == this.mScroller.getFinalX()) && (v3 == this.mScroller.getFinalY()))) {
                this.mScroller.abortAnimation();
                v6 = this.mScroller.isFinished();
            }
            if (!v6) {
                if (!p10) {
                    this.setDragState(0);
                } else {
                    this.mParentView.post(this.mSetIdleRunnable);
                }
            }
        }
        android.view.ViewGroup v0_18;
        if (this.mDragState != 2) {
            v0_18 = 0;
        } else {
            v0_18 = 1;
        }
        return v0_18;
    }

    public android.view.View findTopChildUnder(int p6, int p7)
    {
        int v2 = (this.mParentView.getChildCount() - 1);
        while (v2 >= 0) {
            int v0 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(v2));
            if ((p6 < v0.getLeft()) || ((p6 >= v0.getRight()) || ((p7 < v0.getTop()) || (p7 >= v0.getBottom())))) {
                v2--;
            }
            return v0;
        }
        v0 = 0;
        return v0;
    }

    public void flingCapturedView(int p10, int p11, int p12, int p13)
    {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), ((int) android.support.v4.view.VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId)), ((int) android.support.v4.view.VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId)), p10, p12, p11, p13);
            this.setDragState(2);
            return;
        } else {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
    }

    public int getActivePointerId()
    {
        return this.mActivePointerId;
    }

    public android.view.View getCapturedView()
    {
        return this.mCapturedView;
    }

    public int getEdgeSize()
    {
        return this.mEdgeSize;
    }

    public float getMinVelocity()
    {
        return this.mMinVelocity;
    }

    public int getTouchSlop()
    {
        return this.mTouchSlop;
    }

    public int getViewDragState()
    {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int p2, int p3)
    {
        return this.isViewUnder(this.mCapturedView, p2, p3);
    }

    public boolean isEdgeTouched(int p4)
    {
        int v1 = 0;
        while (v1 < this.mInitialEdgesTouched.length) {
            if (!this.isEdgeTouched(p4, v1)) {
                v1++;
            } else {
                int v2_1 = 1;
            }
            return v2_1;
        }
        v2_1 = 0;
        return v2_1;
    }

    public boolean isEdgeTouched(int p2, int p3)
    {
        if ((!this.isPointerDown(p3)) || ((this.mInitialEdgesTouched[p3] & p2) == 0)) {
            int v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        return v0_4;
    }

    public boolean isPointerDown(int p4)
    {
        int v0 = 1;
        if ((this.mPointersDown & (1 << p4)) == 0) {
            v0 = 0;
        }
        return v0;
    }

    public boolean isViewUnder(android.view.View p3, int p4, int p5)
    {
        int v0 = 0;
        if ((p3 != null) && ((p4 >= p3.getLeft()) && ((p4 < p3.getRight()) && ((p5 >= p3.getTop()) && (p5 < p3.getBottom()))))) {
            v0 = 1;
        }
        return v0;
    }

    public void processTouchEvent(android.view.MotionEvent p22)
    {
        int v3 = android.support.v4.view.MotionEventCompat.getActionMasked(p22);
        int v4 = android.support.v4.view.MotionEventCompat.getActionIndex(p22);
        if (v3 == 0) {
            this.cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(p22);
        switch (v3) {
            case 0:
                float v17_2 = p22.getX();
                float v18_2 = p22.getY();
                int v15_2 = android.support.v4.view.MotionEventCompat.getPointerId(p22, 0);
                android.view.View v16_2 = this.findTopChildUnder(((int) v17_2), ((int) v18_2));
                this.saveInitialMotion(v17_2, v18_2, v15_2);
                this.tryCaptureViewForDrag(v16_2, v15_2);
                int v7_1 = this.mInitialEdgesTouched[v15_2];
                if ((this.mTrackingEdges & v7_1) == 0) {
                } else {
                    this.mCallback.onEdgeTouched((this.mTrackingEdges & v7_1), v15_2);
                }
                break;
            case 1:
                if (this.mDragState == 1) {
                    this = this.releaseViewForPointerUp();
                }
                this.cancel();
                break;
            case 2:
                if (this.mDragState != 1) {
                    int v14_0 = android.support.v4.view.MotionEventCompat.getPointerCount(p22);
                    int v8_0 = 0;
                    while (v8_0 < v14_0) {
                        int v15_0 = android.support.v4.view.MotionEventCompat.getPointerId(p22, v8_0);
                        float v17_0 = android.support.v4.view.MotionEventCompat.getX(p22, v8_0);
                        float v18_0 = android.support.v4.view.MotionEventCompat.getY(p22, v8_0);
                        float v5 = (v17_0 - this.mInitialMotionX[v15_0]);
                        float v6 = (v18_0 - this.mInitialMotionY[v15_0]);
                        this.reportNewEdgeDrags(v5, v6, v15_0);
                        if (this.mDragState == 1) {
                            break;
                        }
                        android.view.View v16_1 = this.findTopChildUnder(((int) v17_0), ((int) v18_0));
                        if ((this.checkTouchSlop(v16_1, v5, v6)) && (this.tryCaptureViewForDrag(v16_1, v15_0))) {
                            break;
                        }
                        v8_0++;
                    }
                    this.saveLastMotion(p22);
                } else {
                    int v12 = android.support.v4.view.MotionEventCompat.findPointerIndex(p22, this.mActivePointerId);
                    int v10 = ((int) (android.support.v4.view.MotionEventCompat.getX(p22, v12) - this.mLastMotionX[this.mActivePointerId]));
                    int v11 = ((int) (android.support.v4.view.MotionEventCompat.getY(p22, v12) - this.mLastMotionY[this.mActivePointerId]));
                    this.dragTo((this.mCapturedView.getLeft() + v10), (this.mCapturedView.getTop() + v11), v10, v11);
                    this.saveLastMotion(p22);
                }
                break;
            case 3:
                if (this.mDragState == 1) {
                    this.dispatchViewReleased(0, 0);
                }
                this.cancel();
            case 4:
            default:
                break;
            case 5:
                int v15_3 = android.support.v4.view.MotionEventCompat.getPointerId(p22, v4);
                float v17_4 = android.support.v4.view.MotionEventCompat.getX(p22, v4);
                float v18_4 = android.support.v4.view.MotionEventCompat.getY(p22, v4);
                this.saveInitialMotion(v17_4, v18_4, v15_3);
                if (this.mDragState != 0) {
                    if (!this.isCapturedViewUnder(((int) v17_4), ((int) v18_4))) {
                    } else {
                        this.tryCaptureViewForDrag(this.mCapturedView, v15_3);
                    }
                } else {
                    this.tryCaptureViewForDrag(this.findTopChildUnder(((int) v17_4), ((int) v18_4)), v15_3);
                    int v7_0 = this.mInitialEdgesTouched[v15_3];
                    if ((this.mTrackingEdges & v7_0) == 0) {
                    } else {
                        this.mCallback.onEdgeTouched((this.mTrackingEdges & v7_0), v15_3);
                    }
                }
                break;
            case 6:
                int v15_1 = android.support.v4.view.MotionEventCompat.getPointerId(p22, v4);
                if ((this.mDragState == 1) && (v15_1 == this.mActivePointerId)) {
                    int v13 = -1;
                    int v14_1 = android.support.v4.view.MotionEventCompat.getPointerCount(p22);
                    int v8_1 = 0;
                    while (v8_1 < v14_1) {
                        int v9 = android.support.v4.view.MotionEventCompat.getPointerId(p22, v8_1);
                        if ((v9 == this.mActivePointerId) || ((this.findTopChildUnder(((int) android.support.v4.view.MotionEventCompat.getX(p22, v8_1)), ((int) android.support.v4.view.MotionEventCompat.getY(p22, v8_1))) != this.mCapturedView) || (!this.tryCaptureViewForDrag(this.mCapturedView, v9)))) {
                            v8_1++;
                        } else {
                            v13 = this.mActivePointerId;
                            break;
                        }
                    }
                    if (v13 == -1) {
                        this = this.releaseViewForPointerUp();
                    }
                }
                this.clearMotionHistory(v15_1);
                break;
        }
        return;
    }

    void setDragState(int p2)
    {
        if (this.mDragState != p2) {
            this.mDragState = p2;
            this.mCallback.onViewDragStateChanged(p2);
            if (p2 == 0) {
                this.mCapturedView = 0;
            }
        }
        return;
    }

    public void setEdgeTrackingEnabled(int p1)
    {
        this.mTrackingEdges = p1;
        return;
    }

    public void setMinVelocity(float p1)
    {
        this.mMinVelocity = p1;
        return;
    }

    public boolean settleCapturedViewAt(int p4, int p5)
    {
        if (this.mReleaseInProgress) {
            return this.forceSettleCapturedViewAt(p4, p5, ((int) android.support.v4.view.VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId)), ((int) android.support.v4.view.VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId)));
        } else {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
    }

    public boolean shouldInterceptTouchEvent(android.view.MotionEvent p14)
    {
        int v0 = android.support.v4.view.MotionEventCompat.getActionMasked(p14);
        int v1 = android.support.v4.view.MotionEventCompat.getActionIndex(p14);
        if (v0 == 0) {
            this.cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(p14);
        switch (v0) {
            case 0:
                float v9_2 = p14.getX();
                float v10_2 = p14.getY();
                int v7_3 = android.support.v4.view.MotionEventCompat.getPointerId(p14, 0);
                this.saveInitialMotion(v9_2, v10_2, v7_3);
                android.view.View v8_2 = this.findTopChildUnder(((int) v9_2), ((int) v10_2));
                if ((v8_2 == this.mCapturedView) && (this.mDragState == 2)) {
                    this.tryCaptureViewForDrag(v8_2, v7_3);
                }
                int v4_1 = this.mInitialEdgesTouched[v7_3];
                if ((this.mTrackingEdges & v4_1) == 0) {
                } else {
                    this.mCallback.onEdgeTouched((this.mTrackingEdges & v4_1), v7_3);
                }
                break;
            case 1:
            case 3:
                this.cancel();
                break;
            case 2:
                int v6 = android.support.v4.view.MotionEventCompat.getPointerCount(p14);
                int v5 = 0;
                while (v5 < v6) {
                    int v7_2 = android.support.v4.view.MotionEventCompat.getPointerId(p14, v5);
                    float v9_1 = android.support.v4.view.MotionEventCompat.getX(p14, v5);
                    float v10_1 = android.support.v4.view.MotionEventCompat.getY(p14, v5);
                    float v2 = (v9_1 - this.mInitialMotionX[v7_2]);
                    float v3 = (v10_1 - this.mInitialMotionY[v7_2]);
                    this.reportNewEdgeDrags(v2, v3, v7_2);
                    if (this.mDragState == 1) {
                        break;
                    }
                    android.view.View v8_1 = this.findTopChildUnder(((int) v9_1), ((int) v10_1));
                    if ((v8_1 != null) && ((this.checkTouchSlop(v8_1, v2, v3)) && (this.tryCaptureViewForDrag(v8_1, v7_2)))) {
                        break;
                    }
                    v5++;
                }
                this.saveLastMotion(p14);
                break;
            case 4:
            default:
                break;
            case 5:
                int v7_1 = android.support.v4.view.MotionEventCompat.getPointerId(p14, v1);
                float v9_0 = android.support.v4.view.MotionEventCompat.getX(p14, v1);
                float v10_0 = android.support.v4.view.MotionEventCompat.getY(p14, v1);
                this.saveInitialMotion(v9_0, v10_0, v7_1);
                if (this.mDragState != 0) {
                    if (this.mDragState != 2) {
                    } else {
                        android.view.View v8_0 = this.findTopChildUnder(((int) v9_0), ((int) v10_0));
                        if (v8_0 != this.mCapturedView) {
                        } else {
                            this.tryCaptureViewForDrag(v8_0, v7_1);
                        }
                    }
                } else {
                    int v4_0 = this.mInitialEdgesTouched[v7_1];
                    if ((this.mTrackingEdges & v4_0) == 0) {
                    } else {
                        this.mCallback.onEdgeTouched((this.mTrackingEdges & v4_0), v7_1);
                    }
                }
                break;
            case 6:
                this.clearMotionHistory(android.support.v4.view.MotionEventCompat.getPointerId(p14, v1));
                break;
        }
        boolean v11_3;
        if (this.mDragState != 1) {
            v11_3 = 0;
        } else {
            v11_3 = 1;
        }
        return v11_3;
    }

    public boolean smoothSlideViewTo(android.view.View p3, int p4, int p5)
    {
        this.mCapturedView = p3;
        this.mActivePointerId = -1;
        return this.forceSettleCapturedViewAt(p4, p5, 0, 0);
    }

    boolean tryCaptureViewForDrag(android.view.View p3, int p4)
    {
        int v0 = 1;
        if ((p3 != this.mCapturedView) || (this.mActivePointerId != p4)) {
            if ((p3 == null) || (!this.mCallback.tryCaptureView(p3, p4))) {
                v0 = 0;
            } else {
                this.mActivePointerId = p4;
                this.captureChildView(p3, p4);
            }
        }
        return v0;
    }
}
