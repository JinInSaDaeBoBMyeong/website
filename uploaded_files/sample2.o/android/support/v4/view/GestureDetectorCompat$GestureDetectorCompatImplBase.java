package android.support.v4.view;
 class GestureDetectorCompat$GestureDetectorCompatImplBase implements android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl {
    private static final int DOUBLE_TAP_TIMEOUT = 0;
    private static final int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private android.view.MotionEvent mCurrentDownEvent;
    private boolean mDeferConfirmSingleTap;
    private android.view.GestureDetector$OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final android.os.Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    private final android.view.GestureDetector$OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private android.view.MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private android.view.VelocityTracker mVelocityTracker;

    static GestureDetectorCompat$GestureDetectorCompatImplBase()
    {
        android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT = android.view.ViewConfiguration.getLongPressTimeout();
        android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT = android.view.ViewConfiguration.getTapTimeout();
        android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT = android.view.ViewConfiguration.getDoubleTapTimeout();
        return;
    }

    public GestureDetectorCompat$GestureDetectorCompatImplBase(android.content.Context p2, android.view.GestureDetector$OnGestureListener p3, android.os.Handler p4)
    {
        if (p4 == null) {
            this.mHandler = new android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this);
        } else {
            this.mHandler = new android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this, p4);
        }
        this.mListener = p3;
        if ((p3 instanceof android.view.GestureDetector$OnDoubleTapListener)) {
            this.setOnDoubleTapListener(((android.view.GestureDetector$OnDoubleTapListener) p3));
        }
        this.init(p2);
        return;
    }

    static synthetic android.view.MotionEvent access$000(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p1)
    {
        return p1.mCurrentDownEvent;
    }

    static synthetic android.view.GestureDetector$OnGestureListener access$100(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p1)
    {
        return p1.mListener;
    }

    static synthetic void access$200(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p0)
    {
        p0.dispatchLongPress();
        return;
    }

    static synthetic android.view.GestureDetector$OnDoubleTapListener access$300(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p1)
    {
        return p1.mDoubleTapListener;
    }

    static synthetic boolean access$400(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p1)
    {
        return p1.mStillDown;
    }

    static synthetic boolean access$502(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p0, boolean p1)
    {
        p0.mDeferConfirmSingleTap = p1;
        return p1;
    }

    private void cancel()
    {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = 0;
        this.mIsDoubleTapping = 0;
        this.mStillDown = 0;
        this.mAlwaysInTapRegion = 0;
        this.mAlwaysInBiggerTapRegion = 0;
        this.mDeferConfirmSingleTap = 0;
        if (this.mInLongPress) {
            this.mInLongPress = 0;
        }
        return;
    }

    private void cancelTaps()
    {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = 0;
        this.mAlwaysInTapRegion = 0;
        this.mAlwaysInBiggerTapRegion = 0;
        this.mDeferConfirmSingleTap = 0;
        if (this.mInLongPress) {
            this.mInLongPress = 0;
        }
        return;
    }

    private void dispatchLongPress()
    {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = 0;
        this.mInLongPress = 1;
        this.mListener.onLongPress(this.mCurrentDownEvent);
        return;
    }

    private void init(android.content.Context p6)
    {
        if (p6 != null) {
            if (this.mListener != null) {
                this.mIsLongpressEnabled = 1;
                android.view.ViewConfiguration v0 = android.view.ViewConfiguration.get(p6);
                int v2 = v0.getScaledTouchSlop();
                int v1 = v0.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = v0.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = v0.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = (v2 * v2);
                this.mDoubleTapSlopSquare = (v1 * v1);
                return;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        } else {
            throw new IllegalArgumentException("Context must not be null");
        }
    }

    private boolean isConsideredDoubleTap(android.view.MotionEvent p9, android.view.MotionEvent p10, android.view.MotionEvent p11)
    {
        int v2 = 0;
        if ((this.mAlwaysInBiggerTapRegion) && (((p11.getEventTime() - p10.getEventTime()) <= ((long) android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT)) && ((((((int) p9.getX()) - ((int) p11.getX())) * (((int) p9.getX()) - ((int) p11.getX()))) + ((((int) p9.getY()) - ((int) p11.getY())) * (((int) p9.getY()) - ((int) p11.getY())))) < this.mDoubleTapSlopSquare))) {
            v2 = 1;
        }
        return v2;
    }

    public boolean isLongpressEnabled()
    {
        return this.mIsLongpressEnabled;
    }

    public boolean onTouchEvent(android.view.MotionEvent p43)
    {
        int v6 = p43.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        int v22;
        this.mVelocityTracker.addMovement(p43);
        if ((v6 & 255) != 6) {
            v22 = 0;
        } else {
            v22 = 1;
        }
        int v25;
        if (v22 == 0) {
            v25 = -1;
        } else {
            v25 = android.support.v4.view.MotionEventCompat.getActionIndex(p43);
        }
        float v26 = 0;
        float v27 = 0;
        int v7 = android.support.v4.view.MotionEventCompat.getPointerCount(p43);
        int v18_1 = 0;
        while (v18_1 < v7) {
            if (v25 != v18_1) {
                v26 += android.support.v4.view.MotionEventCompat.getX(p43, v18_1);
                v27 += android.support.v4.view.MotionEventCompat.getY(p43, v18_1);
            }
            v18_1++;
        }
        int v12;
        if (v22 == 0) {
            v12 = v7;
        } else {
            v12 = (v7 - 1);
        }
        float v14 = (v26 / ((float) v12));
        float v15 = (v27 / ((float) v12));
        int v17_0 = 0;
        switch ((v6 & 255)) {
            case 0:
                if (this.mDoubleTapListener != null) {
                    boolean v16 = this.mHandler.hasMessages(3);
                    if (v16) {
                        this.mHandler.removeMessages(3);
                    }
                    if ((this.mCurrentDownEvent == null) || ((this.mPreviousUpEvent == null) || ((!v16) || (!this.isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, p43))))) {
                        this.mHandler.sendEmptyMessageDelayed(3, ((long) android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT));
                    } else {
                        this.mIsDoubleTapping = 1;
                        v17_0 = ((0 | this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent)) | this.mDoubleTapListener.onDoubleTapEvent(p43));
                    }
                }
                this.mLastFocusX = v14;
                this.mDownFocusX = v14;
                this.mLastFocusY = v15;
                this.mDownFocusY = v15;
                if (this.mCurrentDownEvent != null) {
                    this.mCurrentDownEvent.recycle();
                }
                this.mCurrentDownEvent = android.view.MotionEvent.obtain(p43);
                this.mAlwaysInTapRegion = 1;
                this.mAlwaysInBiggerTapRegion = 1;
                this.mStillDown = 1;
                this.mInLongPress = 0;
                this.mDeferConfirmSingleTap = 0;
                if (this.mIsLongpressEnabled) {
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageAtTime(2, ((this.mCurrentDownEvent.getDownTime() + ((long) android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT)) + ((long) android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT)));
                }
                this.mHandler.sendEmptyMessageAtTime(1, (this.mCurrentDownEvent.getDownTime() + ((long) android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT)));
                v17_0 |= this.mListener.onDown(p43);
                break;
            case 1:
                this.mStillDown = 0;
                android.view.MotionEvent v8 = android.view.MotionEvent.obtain(p43);
                if (!this.mIsDoubleTapping) {
                    if (!this.mInLongPress) {
                        if (!this.mAlwaysInTapRegion) {
                            android.view.VelocityTracker v29 = this.mVelocityTracker;
                            int v21 = android.support.v4.view.MotionEventCompat.getPointerId(p43, 0);
                            v29.computeCurrentVelocity(1000, ((float) this.mMaximumFlingVelocity));
                            float v31 = android.support.v4.view.VelocityTrackerCompat.getYVelocity(v29, v21);
                            float v30 = android.support.v4.view.VelocityTrackerCompat.getXVelocity(v29, v21);
                            if ((Math.abs(v31) > ((float) this.mMinimumFlingVelocity)) || (Math.abs(v30) > ((float) this.mMinimumFlingVelocity))) {
                                v17_0 = this.mListener.onFling(this.mCurrentDownEvent, p43, v30, v31);
                            }
                        } else {
                            v17_0 = this.mListener.onSingleTapUp(p43);
                            if ((this.mDeferConfirmSingleTap) && (this.mDoubleTapListener != null)) {
                                this.mDoubleTapListener.onSingleTapConfirmed(p43);
                            }
                        }
                    } else {
                        this.mHandler.removeMessages(3);
                        this.mInLongPress = 0;
                    }
                } else {
                    v17_0 = (0 | this.mDoubleTapListener.onDoubleTapEvent(p43));
                }
                if (this.mPreviousUpEvent != null) {
                    this.mPreviousUpEvent.recycle();
                }
                this.mPreviousUpEvent = v8;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = 0;
                }
                this.mIsDoubleTapping = 0;
                this.mDeferConfirmSingleTap = 0;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                break;
            case 2:
                if (this.mInLongPress) {
                } else {
                    float v23 = (this.mLastFocusX - v14);
                    float v24 = (this.mLastFocusY - v15);
                    if (!this.mIsDoubleTapping) {
                        if (!this.mAlwaysInTapRegion) {
                            if ((Math.abs(v23) < 1065353216) && (Math.abs(v24) < 1065353216)) {
                            } else {
                                v17_0 = this.mListener.onScroll(this.mCurrentDownEvent, p43, v23, v24);
                                this.mLastFocusX = v14;
                                this.mLastFocusY = v15;
                            }
                        } else {
                            int v11 = ((((int) (v14 - this.mDownFocusX)) * ((int) (v14 - this.mDownFocusX))) + (((int) (v15 - this.mDownFocusY)) * ((int) (v15 - this.mDownFocusY))));
                            if (v11 > this.mTouchSlopSquare) {
                                v17_0 = this.mListener.onScroll(this.mCurrentDownEvent, p43, v23, v24);
                                this.mLastFocusX = v14;
                                this.mLastFocusY = v15;
                                this.mAlwaysInTapRegion = 0;
                                this.mHandler.removeMessages(3);
                                this.mHandler.removeMessages(1);
                                this.mHandler.removeMessages(2);
                            }
                            if (v11 <= this.mTouchSlopSquare) {
                            } else {
                                this.mAlwaysInBiggerTapRegion = 0;
                            }
                        }
                    } else {
                        v17_0 = (0 | this.mDoubleTapListener.onDoubleTapEvent(p43));
                    }
                }
                break;
            case 3:
                this.cancel();
            case 4:
            default:
                break;
            case 5:
                this.mLastFocusX = v14;
                this.mDownFocusX = v14;
                this.mLastFocusY = v15;
                this.mDownFocusY = v15;
                this.cancelTaps();
                break;
            case 6:
                this.mLastFocusX = v14;
                this.mDownFocusX = v14;
                this.mLastFocusY = v15;
                this.mDownFocusY = v15;
                this.mVelocityTracker.computeCurrentVelocity(1000, ((float) this.mMaximumFlingVelocity));
                int v28 = android.support.v4.view.MotionEventCompat.getActionIndex(p43);
                int v19 = android.support.v4.view.MotionEventCompat.getPointerId(p43, v28);
                float v33 = android.support.v4.view.VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, v19);
                float v35 = android.support.v4.view.VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, v19);
                int v18_0 = 0;
                while (v18_0 < v7) {
                    if (v18_0 != v28) {
                        int v20 = android.support.v4.view.MotionEventCompat.getPointerId(p43, v18_0);
                        if (((v33 * android.support.v4.view.VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, v20)) + (v35 * android.support.v4.view.VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, v20))) < 0) {
                            this.mVelocityTracker.clear();
                            break;
                        }
                    }
                    v18_0++;
                }
                break;
        }
        return v17_0;
    }

    public void setIsLongpressEnabled(boolean p1)
    {
        this.mIsLongpressEnabled = p1;
        return;
    }

    public void setOnDoubleTapListener(android.view.GestureDetector$OnDoubleTapListener p1)
    {
        this.mDoubleTapListener = p1;
        return;
    }
}
