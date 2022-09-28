package android.support.v4.view;
public class ViewPager extends android.view.ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final java.util.Comparator COMPARATOR = None;
    private static final boolean DEBUG = False;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = 255;
    private static final int[] LAYOUT_ATTRS = None;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE;
    private static final android.view.animation.Interpolator sInterpolator;
    private static final android.support.v4.view.ViewPager$ViewPositionComparator sPositionComparator;
    private int mActivePointerId;
    private android.support.v4.view.PagerAdapter mAdapter;
    private android.support.v4.view.ViewPager$OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private java.util.ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private android.support.v4.view.ViewPager$OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final java.util.ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private android.support.v4.widget.EdgeEffectCompat mLeftEdge;
    private android.graphics.drawable.Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private android.support.v4.view.ViewPager$PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private android.support.v4.view.ViewPager$OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private android.support.v4.view.ViewPager$PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private android.os.Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private android.support.v4.widget.EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private android.widget.Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private reflect.Method mSetChildrenDrawingOrderEnabled;
    private final android.support.v4.view.ViewPager$ItemInfo mTempItem;
    private final android.graphics.Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private android.view.VelocityTracker mVelocityTracker;

    static ViewPager()
    {
        android.support.v4.view.ViewPager$ViewPositionComparator v0_1 = new int[1];
        v0_1[0] = 16842931;
        android.support.v4.view.ViewPager.LAYOUT_ATTRS = v0_1;
        android.support.v4.view.ViewPager.COMPARATOR = new android.support.v4.view.ViewPager$1();
        android.support.v4.view.ViewPager.sInterpolator = new android.support.v4.view.ViewPager$2();
        android.support.v4.view.ViewPager.sPositionComparator = new android.support.v4.view.ViewPager$ViewPositionComparator();
        return;
    }

    public ViewPager(android.content.Context p6)
    {
        super(p6);
        super.mItems = new java.util.ArrayList();
        super.mTempItem = new android.support.v4.view.ViewPager$ItemInfo();
        super.mTempRect = new android.graphics.Rect();
        super.mRestoredCurItem = -1;
        super.mRestoredAdapterState = 0;
        super.mRestoredClassLoader = 0;
        super.mFirstOffset = -8388609;
        super.mLastOffset = 2139095039;
        super.mOffscreenPageLimit = 1;
        super.mActivePointerId = -1;
        super.mFirstLayout = 1;
        super.mNeedCalculatePageOffsets = 0;
        super.mEndScrollRunnable = new android.support.v4.view.ViewPager$3(super);
        super.mScrollState = 0;
        super.initViewPager();
        return;
    }

    public ViewPager(android.content.Context p6, android.util.AttributeSet p7)
    {
        super(p6, p7);
        super.mItems = new java.util.ArrayList();
        super.mTempItem = new android.support.v4.view.ViewPager$ItemInfo();
        super.mTempRect = new android.graphics.Rect();
        super.mRestoredCurItem = -1;
        super.mRestoredAdapterState = 0;
        super.mRestoredClassLoader = 0;
        super.mFirstOffset = -8388609;
        super.mLastOffset = 2139095039;
        super.mOffscreenPageLimit = 1;
        super.mActivePointerId = -1;
        super.mFirstLayout = 1;
        super.mNeedCalculatePageOffsets = 0;
        super.mEndScrollRunnable = new android.support.v4.view.ViewPager$3(super);
        super.mScrollState = 0;
        super.initViewPager();
        return;
    }

    static synthetic void access$000(android.support.v4.view.ViewPager p0, int p1)
    {
        p0.setScrollState(p1);
        return;
    }

    static synthetic android.support.v4.view.PagerAdapter access$200(android.support.v4.view.ViewPager p1)
    {
        return p1.mAdapter;
    }

    static synthetic int access$300(android.support.v4.view.ViewPager p1)
    {
        return p1.mCurItem;
    }

    static synthetic int[] access$400()
    {
        return android.support.v4.view.ViewPager.LAYOUT_ATTRS;
    }

    private void calculatePageOffsets(android.support.v4.view.ViewPager$ItemInfo p15, int p16, android.support.v4.view.ViewPager$ItemInfo p17)
    {
        int v6;
        int v1 = this.mAdapter.getCount();
        int v11 = this.getClientWidth();
        if (v11 <= 0) {
            v6 = 0;
        } else {
            v6 = (((float) this.mPageMargin) / ((float) v11));
        }
        if (p17 != null) {
            int v8 = p17.position;
            if (v8 >= p15.position) {
                if (v8 > p15.position) {
                    int v5_1 = (this.mItems.size() - 1);
                    float v7_3 = p17.offset;
                    int v9_3 = (v8 - 1);
                    while ((v9_3 >= p15.position) && (v5_1 >= 0)) {
                        android.support.v4.view.ViewPager$ItemInfo v3_8 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v5_1));
                        while ((v9_3 < v3_8.position) && (v5_1 > 0)) {
                            v5_1--;
                            v3_8 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v5_1));
                        }
                        while (v9_3 > v3_8.position) {
                            v7_3 -= (this.mAdapter.getPageWidth(v9_3) + v6);
                            v9_3--;
                        }
                        v7_3 -= (v3_8.widthFactor + v6);
                        v3_8.offset = v7_3;
                        v9_3--;
                    }
                }
            } else {
                int v5_0 = 0;
                float v7_2 = ((p17.offset + p17.widthFactor) + v6);
                int v9_2 = (v8 + 1);
                while ((v9_2 <= p15.position) && (v5_0 < this.mItems.size())) {
                    android.support.v4.view.ViewPager$ItemInfo v3_5 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v5_0));
                    while ((v9_2 > v3_5.position) && (v5_0 < (this.mItems.size() - 1))) {
                        v5_0++;
                        v3_5 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v5_0));
                    }
                    while (v9_2 < v3_5.position) {
                        v7_2 += (this.mAdapter.getPageWidth(v9_2) + v6);
                        v9_2++;
                    }
                    v3_5.offset = v7_2;
                    v7_2 += (v3_5.widthFactor + v6);
                    v9_2++;
                }
            }
        }
        float v12_56;
        int v4 = this.mItems.size();
        float v7_1 = p15.offset;
        int v9_1 = (p15.position - 1);
        if (p15.position != 0) {
            v12_56 = -8388609;
        } else {
            v12_56 = p15.offset;
        }
        float v12_59;
        this.mFirstOffset = v12_56;
        if (p15.position != (v1 - 1)) {
            v12_59 = 2139095039;
        } else {
            v12_59 = ((p15.offset + p15.widthFactor) - 1065353216);
        }
        this.mLastOffset = v12_59;
        int v2_1 = (p16 - 1);
        while (v2_1 >= 0) {
            android.support.v4.view.ViewPager$ItemInfo v3_3 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v2_1));
            while (v9_1 > v3_3.position) {
                int v10_1 = (v9_1 - 1);
                v7_1 -= (this.mAdapter.getPageWidth(v9_1) + v6);
                v9_1 = v10_1;
            }
            v7_1 -= (v3_3.widthFactor + v6);
            v3_3.offset = v7_1;
            if (v3_3.position == 0) {
                this.mFirstOffset = v7_1;
            }
            v2_1--;
            v9_1--;
        }
        float v7_0 = ((p15.offset + p15.widthFactor) + v6);
        int v9_0 = (p15.position + 1);
        int v2_0 = (p16 + 1);
        while (v2_0 < v4) {
            android.support.v4.view.ViewPager$ItemInfo v3_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v2_0));
            while (v9_0 < v3_1.position) {
                int v10_0 = (v9_0 + 1);
                v7_0 += (this.mAdapter.getPageWidth(v9_0) + v6);
                v9_0 = v10_0;
            }
            if (v3_1.position == (v1 - 1)) {
                this.mLastOffset = ((v3_1.widthFactor + v7_0) - 1065353216);
            }
            v3_1.offset = v7_0;
            v7_0 += (v3_1.widthFactor + v6);
            v2_0++;
            v9_0++;
        }
        this.mNeedCalculatePageOffsets = 0;
        return;
    }

    private void completeScroll(boolean p11)
    {
        int v2;
        if (this.mScrollState != 2) {
            v2 = 0;
        } else {
            v2 = 1;
        }
        if (v2 != 0) {
            this.setScrollingCacheEnabled(0);
            this.mScroller.abortAnimation();
            int v3 = this.getScrollX();
            int v4 = this.getScrollY();
            int v5 = this.mScroller.getCurrX();
            int v6 = this.mScroller.getCurrY();
            if ((v3 != v5) || (v4 != v6)) {
                this.scrollTo(v5, v6);
            }
        }
        this.mPopulatePending = 0;
        int v0 = 0;
        while (v0 < this.mItems.size()) {
            android.support.v4.view.ViewPager$ItemInfo v1_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v0));
            if (v1_1.scrolling) {
                v2 = 1;
                v1_1.scrolling = 0;
            }
            v0++;
        }
        if (v2 != 0) {
            if (!p11) {
                this.mEndScrollRunnable.run();
            } else {
                android.support.v4.view.ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            }
        }
        return;
    }

    private int determineTargetPage(int p7, float p8, int p9, int p10)
    {
        if ((Math.abs(p10) <= this.mFlingDistance) || (Math.abs(p9) <= this.mMinimumVelocity)) {
            int v3;
            if (p7 < this.mCurItem) {
                v3 = 1058642330;
            } else {
                v3 = 1053609165;
            }
            int v2 = ((int) ((((float) p7) + p8) + v3));
        } else {
            if (p9 <= 0) {
                v2 = (p7 + 1);
            } else {
                v2 = p7;
            }
        }
        if (this.mItems.size() > 0) {
            v2 = Math.max(((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(0)).position, Math.min(v2, ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get((this.mItems.size() - 1))).position));
        }
        return v2;
    }

    private void enableLayers(boolean p6)
    {
        int v0 = this.getChildCount();
        int v1 = 0;
        while (v1 < v0) {
            int v2;
            if (!p6) {
                v2 = 0;
            } else {
                v2 = 2;
            }
            android.support.v4.view.ViewCompat.setLayerType(this.getChildAt(v1), v2, 0);
            v1++;
        }
        return;
    }

    private void endDrag()
    {
        this.mIsBeingDragged = 0;
        this.mIsUnableToDrag = 0;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = 0;
        }
        return;
    }

    private android.graphics.Rect getChildRectInPagerCoordinates(android.graphics.Rect p5, android.view.View p6)
    {
        if (p5 == null) {
            p5 = new android.graphics.Rect();
        }
        if (p6 != null) {
            p5.left = p6.getLeft();
            p5.right = p6.getRight();
            p5.top = p6.getTop();
            p5.bottom = p6.getBottom();
            android.view.ViewParent v1 = p6.getParent();
            while (((v1 instanceof android.view.ViewGroup)) && (v1 != this)) {
                android.view.ViewGroup v0_1 = ((android.view.ViewGroup) v1);
                p5.left = (p5.left + v0_1.getLeft());
                p5.right = (p5.right + v0_1.getRight());
                p5.top = (p5.top + v0_1.getTop());
                p5.bottom = (p5.bottom + v0_1.getBottom());
                v1 = v0_1.getParent();
            }
        } else {
            p5.set(0, 0, 0, 0);
        }
        return p5;
    }

    private int getClientWidth()
    {
        return ((this.getMeasuredWidth() - this.getPaddingLeft()) - this.getPaddingRight());
    }

    private android.support.v4.view.ViewPager$ItemInfo infoForCurrentScrollPosition()
    {
        int v11;
        float v8 = 0;
        int v12 = this.getClientWidth();
        if (v12 <= 0) {
            v11 = 0;
        } else {
            v11 = (((float) this.getScrollX()) / ((float) v12));
        }
        if (v12 > 0) {
            v8 = (((float) this.mPageMargin) / ((float) v12));
        }
        int v5 = -1;
        float v4 = 0;
        float v6 = 0;
        int v0 = 1;
        android.support.v4.view.ViewPager$ItemInfo v3 = 0;
        int v1 = 0;
        while (v1 < this.mItems.size()) {
            android.support.v4.view.ViewPager$ItemInfo v2_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v1));
            if ((v0 == 0) && (v2_1.position != (v5 + 1))) {
                v2_1 = this.mTempItem;
                v2_1.offset = ((v4 + v6) + v8);
                v2_1.position = (v5 + 1);
                v2_1.widthFactor = this.mAdapter.getPageWidth(v2_1.position);
                v1--;
            }
            float v9 = v2_1.offset;
            if ((v0 == 0) && (v11 < v9)) {
                break;
            }
            if ((v11 >= ((v2_1.widthFactor + v9) + v8)) && (v1 != (this.mItems.size() - 1))) {
                v0 = 0;
                v5 = v2_1.position;
                v4 = v9;
                v6 = v2_1.widthFactor;
                v3 = v2_1;
                v1++;
            } else {
                v3 = v2_1;
                break;
            }
        }
        return v3;
    }

    private boolean isGutterDrag(float p4, float p5)
    {
        if (((p4 >= ((float) this.mGutterSize)) || (p5 <= 0)) && ((p4 <= ((float) (this.getWidth() - this.mGutterSize))) || (p5 >= 0))) {
            int v0_5 = 0;
        } else {
            v0_5 = 1;
        }
        return v0_5;
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
            this.mLastMotionX = android.support.v4.view.MotionEventCompat.getX(p5, v0);
            this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p5, v0);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
        return;
    }

    private boolean pageScrolled(int p11)
    {
        int v7_0 = 0;
        if (this.mItems.size() != 0) {
            android.support.v4.view.ViewPager$ItemInfo v1 = this.infoForCurrentScrollPosition();
            int v5 = this.getClientWidth();
            int v0 = v1.position;
            float v4 = (((((float) p11) / ((float) v5)) - v1.offset) / (v1.widthFactor + (((float) this.mPageMargin) / ((float) v5))));
            int v3 = ((int) (((float) (v5 + this.mPageMargin)) * v4));
            this.mCalledSuper = 0;
            this.onPageScrolled(v0, v4, v3);
            if (this.mCalledSuper) {
                v7_0 = 1;
            } else {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else {
            this.mCalledSuper = 0;
            this.onPageScrolled(0, 0, 0);
            if (!this.mCalledSuper) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        }
        return v7_0;
    }

    private boolean performDrag(float p18)
    {
        boolean v7 = 0;
        float v2 = (this.mLastMotionX - p18);
        this.mLastMotionX = p18;
        float v12 = (((float) this.getScrollX()) + v2);
        int v13 = this.getClientWidth();
        float v6 = (((float) v13) * this.mFirstOffset);
        float v11 = (((float) v13) * this.mLastOffset);
        int v5 = 1;
        int v10 = 1;
        android.support.v4.view.ViewPager$ItemInfo v3_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(0));
        android.support.v4.view.ViewPager$ItemInfo v4_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get((this.mItems.size() - 1)));
        if (v3_1.position != 0) {
            v5 = 0;
            v6 = (v3_1.offset * ((float) v13));
        }
        if (v4_1.position != (this.mAdapter.getCount() - 1)) {
            v10 = 0;
            v11 = (v4_1.offset * ((float) v13));
        }
        if (v12 >= v6) {
            if (v12 > v11) {
                if (v10 != 0) {
                    v7 = this.mRightEdge.onPull((Math.abs((v12 - v11)) / ((float) v13)));
                }
                v12 = v11;
            }
        } else {
            if (v5 != 0) {
                v7 = this.mLeftEdge.onPull((Math.abs((v6 - v12)) / ((float) v13)));
            }
            v12 = v6;
        }
        this.mLastMotionX = (this.mLastMotionX + (v12 - ((float) ((int) v12))));
        this.scrollTo(((int) v12), this.getScrollY());
        this.pageScrolled(((int) v12));
        return v7;
    }

    private void recomputeScrollPosition(int p15, int p16, int p17, int p18)
    {
        if ((p16 <= 0) || (this.mItems.isEmpty())) {
            int v9;
            android.support.v4.view.ViewPager$ItemInfo v6 = this.infoForPosition(this.mCurItem);
            if (v6 == null) {
                v9 = 0;
            } else {
                v9 = Math.min(v6.offset, this.mLastOffset);
            }
            int v10 = ((int) (((float) ((p15 - this.getPaddingLeft()) - this.getPaddingRight())) * v9));
            if (v10 != this.getScrollX()) {
                this.completeScroll(0);
                this.scrollTo(v10, this.getScrollY());
            }
        } else {
            int v1 = ((int) (((float) (((p15 - this.getPaddingLeft()) - this.getPaddingRight()) + p17)) * (((float) this.getScrollX()) / ((float) (((p16 - this.getPaddingLeft()) - this.getPaddingRight()) + p18)))));
            this.scrollTo(v1, this.getScrollY());
            if (!this.mScroller.isFinished()) {
                this.mScroller.startScroll(v1, 0, ((int) (this.infoForPosition(this.mCurItem).offset * ((float) p15))), 0, (this.mScroller.getDuration() - this.mScroller.timePassed()));
            }
        }
        return;
    }

    private void removeNonDecorViews()
    {
        int v1 = 0;
        while (v1 < this.getChildCount()) {
            if (!((android.support.v4.view.ViewPager$LayoutParams) this.getChildAt(v1).getLayoutParams()).isDecor) {
                this.removeViewAt(v1);
                v1--;
            }
            v1++;
        }
        return;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean p2)
    {
        android.view.ViewParent v0 = this.getParent();
        if (v0 != null) {
            v0.requestDisallowInterceptTouchEvent(p2);
        }
        return;
    }

    private void scrollToItem(int p9, boolean p10, int p11, boolean p12)
    {
        android.support.v4.view.ViewPager$ItemInfo v0 = this.infoForPosition(p9);
        int v1 = 0;
        if (v0 != null) {
            v1 = ((int) (((float) this.getClientWidth()) * Math.max(this.mFirstOffset, Math.min(v0.offset, this.mLastOffset))));
        }
        if (!p10) {
            if ((p12) && (this.mOnPageChangeListener != null)) {
                this.mOnPageChangeListener.onPageSelected(p9);
            }
            if ((p12) && (this.mInternalPageChangeListener != null)) {
                this.mInternalPageChangeListener.onPageSelected(p9);
            }
            this.completeScroll(0);
            this.scrollTo(v1, 0);
            this.pageScrolled(v1);
        } else {
            this.smoothScrollTo(v1, 0, p11);
            if ((p12) && (this.mOnPageChangeListener != null)) {
                this.mOnPageChangeListener.onPageSelected(p9);
            }
            if ((p12) && (this.mInternalPageChangeListener != null)) {
                this.mInternalPageChangeListener.onPageSelected(p9);
            }
        }
        return;
    }

    private void setScrollState(int p2)
    {
        if (this.mScrollState != p2) {
            this.mScrollState = p2;
            if (this.mPageTransformer != null) {
                android.support.v4.view.ViewPager$OnPageChangeListener v0_3;
                if (p2 == 0) {
                    v0_3 = 0;
                } else {
                    v0_3 = 1;
                }
                this.enableLayers(v0_3);
            }
            if (this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageScrollStateChanged(p2);
            }
        }
        return;
    }

    private void setScrollingCacheEnabled(boolean p2)
    {
        if (this.mScrollingCacheEnabled != p2) {
            this.mScrollingCacheEnabled = p2;
        }
        return;
    }

    private void sortChildDrawingOrder()
    {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren != null) {
                this.mDrawingOrderedChildren.clear();
            } else {
                this.mDrawingOrderedChildren = new java.util.ArrayList();
            }
            int v1 = this.getChildCount();
            int v2 = 0;
            while (v2 < v1) {
                this.mDrawingOrderedChildren.add(this.getChildAt(v2));
                v2++;
            }
            java.util.Collections.sort(this.mDrawingOrderedChildren, android.support.v4.view.ViewPager.sPositionComparator);
        }
        return;
    }

    public void addFocusables(java.util.ArrayList p8, int p9, int p10)
    {
        int v2 = p8.size();
        int v1 = this.getDescendantFocusability();
        if (v1 != 393216) {
            int v3 = 0;
            while (v3 < this.getChildCount()) {
                android.view.View v0 = this.getChildAt(v3);
                if (v0.getVisibility() == 0) {
                    android.support.v4.view.ViewPager$ItemInfo v4 = this.infoForChild(v0);
                    if ((v4 != null) && (v4.position == this.mCurItem)) {
                        v0.addFocusables(p8, p9, p10);
                    }
                }
                v3++;
            }
        }
        if (((v1 != 262144) || (v2 == p8.size())) && (((this.isFocusable()) && (((p10 & 1) != 1) || ((!this.isInTouchMode()) || (this.isFocusableInTouchMode())))) && (p8 != null))) {
            p8.add(this);
        }
        return;
    }

    android.support.v4.view.ViewPager$ItemInfo addNewItem(int p3, int p4)
    {
        android.support.v4.view.ViewPager$ItemInfo v0_1 = new android.support.v4.view.ViewPager$ItemInfo();
        v0_1.position = p3;
        v0_1.object = this.mAdapter.instantiateItem(this, p3);
        v0_1.widthFactor = this.mAdapter.getPageWidth(p3);
        if ((p4 >= 0) && (p4 < this.mItems.size())) {
            this.mItems.add(p4, v0_1);
        } else {
            this.mItems.add(v0_1);
        }
        return v0_1;
    }

    public void addTouchables(java.util.ArrayList p6)
    {
        int v1 = 0;
        while (v1 < this.getChildCount()) {
            android.view.View v0 = this.getChildAt(v1);
            if (v0.getVisibility() == 0) {
                android.support.v4.view.ViewPager$ItemInfo v2 = this.infoForChild(v0);
                if ((v2 != null) && (v2.position == this.mCurItem)) {
                    v0.addTouchables(p6);
                }
            }
            v1++;
        }
        return;
    }

    public void addView(android.view.View p4, int p5, android.view.ViewGroup$LayoutParams p6)
    {
        if (!this.checkLayoutParams(p6)) {
            p6 = this.generateLayoutParams(p6);
        }
        ((android.support.v4.view.ViewPager$LayoutParams) p6).isDecor = (((android.support.v4.view.ViewPager$LayoutParams) p6).isDecor | (p4 instanceof android.support.v4.view.ViewPager$Decor));
        if (!this.mInLayout) {
            super.addView(p4, p5, p6);
        } else {
            if ((((android.support.v4.view.ViewPager$LayoutParams) p6) == null) || (!((android.support.v4.view.ViewPager$LayoutParams) p6).isDecor)) {
                ((android.support.v4.view.ViewPager$LayoutParams) p6).needsMeasure = 1;
                this.addViewInLayout(p4, p5, p6);
            } else {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
        }
        return;
    }

    public boolean arrowScroll(int p14)
    {
        int v1 = this.findFocus();
        if (v1 != this) {
            if (v1 != 0) {
                int v3 = 0;
                android.view.ViewParent v6_0 = v1.getParent();
                while ((v6_0 instanceof android.view.ViewGroup)) {
                    if (v6_0 != this) {
                        v6_0 = v6_0.getParent();
                    } else {
                        v3 = 1;
                        break;
                    }
                }
                if (v3 == 0) {
                    StringBuilder v7_1 = new StringBuilder();
                    v7_1.append(v1.getClass().getSimpleName());
                    android.view.ViewParent v6_1 = v1.getParent();
                    while ((v6_1 instanceof android.view.ViewGroup)) {
                        v7_1.append(" => ").append(v6_1.getClass().getSimpleName());
                        v6_1 = v6_1.getParent();
                    }
                    android.util.Log.e("ViewPager", new StringBuilder().append("arrowScroll tried to find focus based on non-child current focused view ").append(v7_1.toString()).toString());
                    v1 = 0;
                }
            }
        } else {
            v1 = 0;
        }
        boolean v2 = 0;
        android.view.View v4 = android.view.FocusFinder.getInstance().findNextFocus(this, v1, p14);
        if ((v4 == null) || (v4 == v1)) {
            if ((p14 != 17) && (p14 != 1)) {
                if ((p14 == 66) || (p14 == 2)) {
                    v2 = this.pageRight();
                }
            } else {
                v2 = this.pageLeft();
            }
        } else {
            if (p14 != 17) {
                if (p14 == 66) {
                    int v5_0 = this.getChildRectInPagerCoordinates(this.mTempRect, v4).left;
                    android.graphics.Rect vtmp15 = this.getChildRectInPagerCoordinates(this.mTempRect, v1);
                    if ((v1 == 0) || (v5_0 > vtmp15.left)) {
                        v2 = v4.requestFocus();
                    } else {
                        v2 = this.pageRight();
                    }
                }
            } else {
                int v5_1 = this.getChildRectInPagerCoordinates(this.mTempRect, v4).left;
                android.graphics.Rect vtmp7 = this.getChildRectInPagerCoordinates(this.mTempRect, v1);
                if ((v1 == 0) || (v5_1 < vtmp7.left)) {
                    v2 = v4.requestFocus();
                } else {
                    v2 = this.pageLeft();
                }
            }
        }
        if (v2) {
            this.playSoundEffect(android.view.SoundEffectConstants.getContantForFocusDirection(p14));
        }
        return v2;
    }

    public boolean beginFakeDrag()
    {
        int v4 = 0;
        if (!this.mIsBeingDragged) {
            this.mFakeDragging = 1;
            this.setScrollState(1);
            this.mLastMotionX = 0;
            this.mInitialMotionX = 0;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            } else {
                this.mVelocityTracker = android.view.VelocityTracker.obtain();
            }
            long v0 = android.os.SystemClock.uptimeMillis();
            android.view.MotionEvent v8 = android.view.MotionEvent.obtain(v0, v0, 0, 0, 0, 0);
            this.mVelocityTracker.addMovement(v8);
            v8.recycle();
            this.mFakeDragBeginTime = v0;
            v4 = 1;
        }
        return v4;
    }

    protected boolean canScroll(android.view.View p12, boolean p13, int p14, int p15, int p16)
    {
        int v0_3;
        if (!(p12 instanceof android.view.ViewGroup)) {
            if ((!p13) || (!android.support.v4.view.ViewCompat.canScrollHorizontally(p12, (- p14)))) {
                v0_3 = 0;
            } else {
                v0_3 = 1;
            }
        } else {
            int v9 = p12.getScrollX();
            int v10 = p12.getScrollY();
            int v8 = (((android.view.ViewGroup) p12).getChildCount() - 1);
            while (v8 >= 0) {
                android.view.View v1 = ((android.view.ViewGroup) p12).getChildAt(v8);
                if (((p15 + v9) < v1.getLeft()) || (((p15 + v9) >= v1.getRight()) || (((p16 + v10) < v1.getTop()) || (((p16 + v10) >= v1.getBottom()) || (!this.canScroll(v1, 1, p14, ((p15 + v9) - v1.getLeft()), ((p16 + v10) - v1.getTop()))))))) {
                    v8--;
                } else {
                    v0_3 = 1;
                }
            }
        }
        return v0_3;
    }

    public boolean canScrollHorizontally(int p7)
    {
        int v2 = 1;
        int v3 = 0;
        if (this.mAdapter != null) {
            int v1 = this.getClientWidth();
            int v0 = this.getScrollX();
            if (p7 >= 0) {
                if (p7 > 0) {
                    if (v0 >= ((int) (((float) v1) * this.mLastOffset))) {
                        v2 = 0;
                    }
                    v3 = v2;
                }
            } else {
                if (v0 <= ((int) (((float) v1) * this.mFirstOffset))) {
                    v2 = 0;
                }
                v3 = v2;
            }
        }
        return v3;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        if ((!(p2 instanceof android.support.v4.view.ViewPager$LayoutParams)) || (!super.checkLayoutParams(p2))) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public void computeScroll()
    {
        if ((this.mScroller.isFinished()) || (!this.mScroller.computeScrollOffset())) {
            this.completeScroll(1);
        } else {
            int v0 = this.getScrollX();
            int v1 = this.getScrollY();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            if ((v0 != v2) || (v1 != v3)) {
                this.scrollTo(v2, v3);
                if (!this.pageScrolled(v2)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, v3);
                }
            }
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
    }

    void dataSetChanged()
    {
        int v7;
        int v0 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = v0;
        if ((this.mItems.size() >= ((this.mOffscreenPageLimit * 2) + 1)) || (this.mItems.size() >= v0)) {
            v7 = 0;
        } else {
            v7 = 1;
        }
        int v8 = this.mCurItem;
        int v5 = 0;
        int v3_0 = 0;
        while (v3_0 < this.mItems.size()) {
            android.support.v4.view.ViewPager$ItemInfo v4_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v3_0));
            int v9 = this.mAdapter.getItemPosition(v4_1.object);
            if (v9 != -1) {
                if (v9 != -2) {
                    if (v4_1.position != v9) {
                        if (v4_1.position == this.mCurItem) {
                            v8 = v9;
                        }
                        v4_1.position = v9;
                        v7 = 1;
                    }
                } else {
                    this.mItems.remove(v3_0);
                    v3_0--;
                    if (v5 == 0) {
                        this.mAdapter.startUpdate(this);
                        v5 = 1;
                    }
                    this.mAdapter.destroyItem(this, v4_1.position, v4_1.object);
                    v7 = 1;
                    if (this.mCurItem == v4_1.position) {
                        v8 = Math.max(0, Math.min(this.mCurItem, (v0 - 1)));
                        v7 = 1;
                    }
                }
            }
            v3_0++;
        }
        if (v5 != 0) {
            this.mAdapter.finishUpdate(this);
        }
        java.util.Collections.sort(this.mItems, android.support.v4.view.ViewPager.COMPARATOR);
        if (v7 != 0) {
            int v2 = this.getChildCount();
            int v3_1 = 0;
            while (v3_1 < v2) {
                android.support.v4.view.ViewPager$LayoutParams v6_1 = ((android.support.v4.view.ViewPager$LayoutParams) this.getChildAt(v3_1).getLayoutParams());
                if (!v6_1.isDecor) {
                    v6_1.widthFactor = 0;
                }
                v3_1++;
            }
            this.setCurrentItemInternal(v8, 0, 1);
            this.requestLayout();
        }
        return;
    }

    public boolean dispatchKeyEvent(android.view.KeyEvent p2)
    {
        if ((!super.dispatchKeyEvent(p2)) && (!this.executeKeyEvent(p2))) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent p7)
    {
        int v4_4;
        if (p7.getEventType() != 4096) {
            int v1 = this.getChildCount();
            int v2 = 0;
            while (v2 < v1) {
                android.view.View v0 = this.getChildAt(v2);
                if (v0.getVisibility() == 0) {
                    android.support.v4.view.ViewPager$ItemInfo v3 = this.infoForChild(v0);
                    if ((v3 != null) && ((v3.position == this.mCurItem) && (v0.dispatchPopulateAccessibilityEvent(p7)))) {
                        v4_4 = 1;
                        return v4_4;
                    }
                }
                v2++;
            }
            v4_4 = 0;
        } else {
            v4_4 = super.dispatchPopulateAccessibilityEvent(p7);
        }
        return v4_4;
    }

    float distanceInfluenceForSnapDuration(float p5)
    {
        return ((float) Math.sin(((double) ((float) (((double) (p5 - 1056964608)) * 0.4712389167638204)))));
    }

    public void draw(android.graphics.Canvas p9)
    {
        super.draw(p9);
        int v1 = 0;
        int v2 = android.support.v4.view.ViewCompat.getOverScrollMode(this);
        if ((v2 != 0) && ((v2 != 1) || ((this.mAdapter == null) || (this.mAdapter.getCount() <= 1)))) {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        } else {
            if (!this.mLeftEdge.isFinished()) {
                int v3_0 = p9.save();
                int v0_0 = ((this.getHeight() - this.getPaddingTop()) - this.getPaddingBottom());
                int v4_0 = this.getWidth();
                p9.rotate(1132920832);
                p9.translate(((float) ((- v0_0) + this.getPaddingTop())), (this.mFirstOffset * ((float) v4_0)));
                this.mLeftEdge.setSize(v0_0, v4_0);
                v1 = (0 | this.mLeftEdge.draw(p9));
                p9.restoreToCount(v3_0);
            }
            if (!this.mRightEdge.isFinished()) {
                int v3_1 = p9.save();
                int v4_1 = this.getWidth();
                int v0_1 = ((this.getHeight() - this.getPaddingTop()) - this.getPaddingBottom());
                p9.rotate(1119092736);
                p9.translate(((float) (- this.getPaddingTop())), ((- (this.mLastOffset + 1065353216)) * ((float) v4_1)));
                this.mRightEdge.setSize(v0_1, v4_1);
                v1 |= this.mRightEdge.draw(p9);
                p9.restoreToCount(v3_1);
            }
        }
        if (v1 != 0) {
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        android.graphics.drawable.Drawable v0 = this.mMarginDrawable;
        if ((v0 != null) && (v0.isStateful())) {
            v0.setState(this.getDrawableState());
        }
        return;
    }

    public void endFakeDrag()
    {
        if (this.mFakeDragging) {
            android.view.VelocityTracker v7 = this.mVelocityTracker;
            v7.computeCurrentVelocity(1000, ((float) this.mMaximumVelocity));
            int v2 = ((int) android.support.v4.view.VelocityTrackerCompat.getXVelocity(v7, this.mActivePointerId));
            this.mPopulatePending = 1;
            int v8 = this.getClientWidth();
            int v5 = this.getScrollX();
            android.support.v4.view.ViewPager$ItemInfo v1 = this.infoForCurrentScrollPosition();
            this.setCurrentItemInternal(this.determineTargetPage(v1.position, (((((float) v5) / ((float) v8)) - v1.offset) / v1.widthFactor), v2, ((int) (this.mLastMotionX - this.mInitialMotionX))), 1, 1, v2);
            this.endDrag();
            this.mFakeDragging = 0;
            return;
        } else {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
    }

    public boolean executeKeyEvent(android.view.KeyEvent p5)
    {
        boolean v0 = 0;
        if (p5.getAction() == 0) {
            switch (p5.getKeyCode()) {
                case 21:
                    v0 = this.arrowScroll(17);
                    break;
                case 22:
                    v0 = this.arrowScroll(66);
                    break;
                case 61:
                    if (android.os.Build$VERSION.SDK_INT >= 11) {
                        if (!android.support.v4.view.KeyEventCompat.hasNoModifiers(p5)) {
                            if (android.support.v4.view.KeyEventCompat.hasModifiers(p5, 1)) {
                                v0 = this.arrowScroll(1);
                            }
                        } else {
                            v0 = this.arrowScroll(2);
                        }
                    }
                    break;
            }
        }
        return v0;
    }

    public void fakeDragBy(float p19)
    {
        if (this.mFakeDragging) {
            this.mLastMotionX = (this.mLastMotionX + p19);
            float v16 = (((float) this.getScrollX()) - p19);
            int v17 = this.getClientWidth();
            float v13 = (((float) v17) * this.mFirstOffset);
            float v15 = (((float) v17) * this.mLastOffset);
            android.support.v4.view.ViewPager$ItemInfo v11_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(0));
            android.support.v4.view.ViewPager$ItemInfo v12_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get((this.mItems.size() - 1)));
            if (v11_1.position != 0) {
                v13 = (v11_1.offset * ((float) v17));
            }
            if (v12_1.position != (this.mAdapter.getCount() - 1)) {
                v15 = (v12_1.offset * ((float) v17));
            }
            if (v16 >= v13) {
                if (v16 > v15) {
                    v16 = v15;
                }
            } else {
                v16 = v13;
            }
            this.mLastMotionX = (this.mLastMotionX + (v16 - ((float) ((int) v16))));
            this.scrollTo(((int) v16), this.getScrollY());
            this.pageScrolled(((int) v16));
            android.view.MotionEvent v10 = android.view.MotionEvent.obtain(this.mFakeDragBeginTime, android.os.SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0, 0);
            this.mVelocityTracker.addMovement(v10);
            v10.recycle();
            return;
        } else {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
    }

    protected android.view.ViewGroup$LayoutParams generateDefaultLayoutParams()
    {
        return new android.support.v4.view.ViewPager$LayoutParams();
    }

    public android.view.ViewGroup$LayoutParams generateLayoutParams(android.util.AttributeSet p3)
    {
        return new android.support.v4.view.ViewPager$LayoutParams(this.getContext(), p3);
    }

    protected android.view.ViewGroup$LayoutParams generateLayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        return this.generateDefaultLayoutParams();
    }

    public android.support.v4.view.PagerAdapter getAdapter()
    {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int p5, int p6)
    {
        int v0;
        if (this.mDrawingOrder != 2) {
            v0 = p6;
        } else {
            v0 = ((p5 - 1) - p6);
        }
        return ((android.support.v4.view.ViewPager$LayoutParams) ((android.view.View) this.mDrawingOrderedChildren.get(v0)).getLayoutParams()).childIndex;
    }

    public int getCurrentItem()
    {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit()
    {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin()
    {
        return this.mPageMargin;
    }

    android.support.v4.view.ViewPager$ItemInfo infoForAnyChild(android.view.View p3)
    {
        while(true) {
            int v1_0;
            android.view.ViewParent v0 = p3.getParent();
            if (v0 == this) {
                v1_0 = this.infoForChild(p3);
            } else {
                if ((v0 == null) || (!(v0 instanceof android.view.View))) {
                    break;
                }
                p3 = ((android.view.View) v0);
            }
            return v1_0;
        }
        v1_0 = 0;
        return v1_0;
    }

    android.support.v4.view.ViewPager$ItemInfo infoForChild(android.view.View p5)
    {
        int v0 = 0;
        while (v0 < this.mItems.size()) {
            int v1_0 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v0));
            if (!this.mAdapter.isViewFromObject(p5, v1_0.object)) {
                v0++;
            }
            return v1_0;
        }
        v1_0 = 0;
        return v1_0;
    }

    android.support.v4.view.ViewPager$ItemInfo infoForPosition(int p4)
    {
        int v0 = 0;
        while (v0 < this.mItems.size()) {
            int v1_0 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v0));
            if (v1_0.position != p4) {
                v0++;
            }
            return v1_0;
        }
        v1_0 = 0;
        return v1_0;
    }

    void initViewPager()
    {
        this.setWillNotDraw(0);
        this.setDescendantFocusability(262144);
        this.setFocusable(1);
        android.content.Context v1 = this.getContext();
        this.mScroller = new android.widget.Scroller(v1, android.support.v4.view.ViewPager.sInterpolator);
        android.view.ViewConfiguration v0 = android.view.ViewConfiguration.get(v1);
        float v2 = v1.getResources().getDisplayMetrics().density;
        this.mTouchSlop = android.support.v4.view.ViewConfigurationCompat.getScaledPagingTouchSlop(v0);
        this.mMinimumVelocity = ((int) (1137180672 * v2));
        this.mMaximumVelocity = v0.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new android.support.v4.widget.EdgeEffectCompat(v1);
        this.mRightEdge = new android.support.v4.widget.EdgeEffectCompat(v1);
        this.mFlingDistance = ((int) (1103626240 * v2));
        this.mCloseEnough = ((int) (1073741824 * v2));
        this.mDefaultGutterSize = ((int) (1098907648 * v2));
        android.support.v4.view.ViewCompat.setAccessibilityDelegate(this, new android.support.v4.view.ViewPager$MyAccessibilityDelegate(this));
        if (android.support.v4.view.ViewCompat.getImportantForAccessibility(this) == 0) {
            android.support.v4.view.ViewCompat.setImportantForAccessibility(this, 1);
        }
        return;
    }

    public boolean isFakeDragging()
    {
        return this.mFakeDragging;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        this.mFirstLayout = 1;
        return;
    }

    protected void onDetachedFromWindow()
    {
        this.removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
        return;
    }

    protected void onDraw(android.graphics.Canvas p19)
    {
        this = super.onDraw(p19);
        if ((this.mPageMargin > 0) && ((this.mMarginDrawable != null) && ((this.mItems.size() > 0) && (this.mAdapter != null)))) {
            int v10 = this.getScrollX();
            int v11 = this.getWidth();
            float v7 = (((float) this.mPageMargin) / ((float) v11));
            int v5 = 0;
            android.support.v4.view.ViewPager$ItemInfo v3_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(0));
            float v8 = v3_1.offset;
            int v4 = this.mItems.size();
            int v6 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get((v4 - 1))).position;
            int v9 = v3_1.position;
            while (v9 < v6) {
                while ((v9 > v3_1.position) && (v5 < v4)) {
                    v5++;
                    v3_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v5));
                }
                float v1;
                if (v9 != v3_1.position) {
                    float v12 = this.mAdapter.getPageWidth(v9);
                    v1 = ((v8 + v12) * ((float) v11));
                    v8 += (v12 + v7);
                } else {
                    v1 = ((v3_1.offset + v3_1.widthFactor) * ((float) v11));
                    v8 = ((v3_1.offset + v3_1.widthFactor) + v7);
                }
                if ((((float) this.mPageMargin) + v1) > ((float) v10)) {
                    this.mMarginDrawable.setBounds(((int) v1), this.mTopPageBounds, ((int) ((((float) this.mPageMargin) + v1) + 1056964608)), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(p19);
                }
                if (v1 > ((float) (v10 + v11))) {
                    break;
                }
                v9++;
            }
        }
        return;
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent p15)
    {
        int v0_21;
        int v6 = (p15.getAction() & 255);
        if ((v6 != 3) && (v6 != 1)) {
            if (v6 != 0) {
                if (!this.mIsBeingDragged) {
                    if (this.mIsUnableToDrag) {
                        v0_21 = 0;
                        return v0_21;
                    }
                } else {
                    v0_21 = 1;
                    return v0_21;
                }
            }
            switch (v6) {
                case 0:
                    int v0_63 = p15.getX();
                    this.mInitialMotionX = v0_63;
                    this.mLastMotionX = v0_63;
                    int v0_64 = p15.getY();
                    this.mInitialMotionY = v0_64;
                    this.mLastMotionY = v0_64;
                    this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p15, 0);
                    this.mIsUnableToDrag = 0;
                    this.mScroller.computeScrollOffset();
                    if ((this.mScrollState != 2) || (Math.abs((this.mScroller.getFinalX() - this.mScroller.getCurrX())) <= this.mCloseEnough)) {
                        this.completeScroll(0);
                        this.mIsBeingDragged = 0;
                    } else {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = 0;
                        this.populate();
                        this.mIsBeingDragged = 1;
                        this.requestParentDisallowInterceptTouchEvent(1);
                        this.setScrollState(1);
                    }
                case 2:
                    int v7 = this.mActivePointerId;
                    if (v7 == -1) {
                    } else {
                        int v9 = android.support.v4.view.MotionEventCompat.findPointerIndex(p15, v7);
                        float v10 = android.support.v4.view.MotionEventCompat.getX(p15, v9);
                        float v8 = (v10 - this.mLastMotionX);
                        float v11 = Math.abs(v8);
                        float v12 = android.support.v4.view.MotionEventCompat.getY(p15, v9);
                        float v13 = Math.abs((v12 - this.mInitialMotionY));
                        if ((v8 == 0) || ((this.isGutterDrag(this.mLastMotionX, v8)) || (!this.canScroll(this, 0, ((int) v8), ((int) v10), ((int) v12))))) {
                            if ((v11 <= ((float) this.mTouchSlop)) || ((1056964608 * v11) <= v13)) {
                                if (v13 > ((float) this.mTouchSlop)) {
                                    this.mIsUnableToDrag = 1;
                                }
                            } else {
                                int v0_56;
                                this.mIsBeingDragged = 1;
                                this.requestParentDisallowInterceptTouchEvent(1);
                                this.setScrollState(1);
                                if (v8 <= 0) {
                                    v0_56 = (this.mInitialMotionX - ((float) this.mTouchSlop));
                                } else {
                                    v0_56 = (this.mInitialMotionX + ((float) this.mTouchSlop));
                                }
                                this.mLastMotionX = v0_56;
                                this.mLastMotionY = v12;
                                this.setScrollingCacheEnabled(1);
                            }
                            if ((!this.mIsBeingDragged) || (!this.performDrag(v10))) {
                            } else {
                                android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
                            }
                        } else {
                            this.mLastMotionX = v10;
                            this.mLastMotionY = v12;
                            this.mIsUnableToDrag = 1;
                            v0_21 = 0;
                        }
                    }
                    break;
                case 6:
                    this.onSecondaryPointerUp(p15);
                    break;
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = android.view.VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(p15);
            v0_21 = this.mIsBeingDragged;
        } else {
            this.mIsBeingDragged = 0;
            this.mIsUnableToDrag = 0;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = 0;
            }
            v0_21 = 0;
        }
        return v0_21;
    }

    protected void onLayout(boolean p31, int p32, int p33, int p34, int p35)
    {
        int v9 = this.getChildCount();
        int v24 = (p34 - p32);
        int v11 = (p35 - p33);
        int v19 = this.getPaddingLeft();
        int v21 = this.getPaddingTop();
        int v20 = this.getPaddingRight();
        int v18 = this.getPaddingBottom();
        int v22 = this.getScrollX();
        int v10 = 0;
        int v14_1 = 0;
        while (v14_1 < v9) {
            android.view.View v5_0 = this.getChildAt(v14_1);
            if (v5_0.getVisibility() != 8) {
                android.support.v4.view.ViewPager$LayoutParams v17_1 = ((android.support.v4.view.ViewPager$LayoutParams) v5_0.getLayoutParams());
                int v7 = 0;
                if (v17_1.isDecor) {
                    int v6_0;
                    int v23 = (v17_1.gravity & 112);
                    switch ((v17_1.gravity & 7)) {
                        case 1:
                            v6_0 = Math.max(((v24 - v5_0.getMeasuredWidth()) / 2), v19);
                            break;
                        case 2:
                        case 4:
                        default:
                            v6_0 = v19;
                            break;
                        case 3:
                            v6_0 = v19;
                            v19 += v5_0.getMeasuredWidth();
                            break;
                        case 5:
                            v6_0 = ((v24 - v20) - v5_0.getMeasuredWidth());
                            v20 += v5_0.getMeasuredWidth();
                            break;
                    }
                    int v7_0;
                    switch (v23) {
                        case 16:
                            v7_0 = Math.max(((v11 - v5_0.getMeasuredHeight()) / 2), v21);
                            break;
                        case 48:
                            v7_0 = v21;
                            v21 += v5_0.getMeasuredHeight();
                            break;
                        case 80:
                            v7_0 = ((v11 - v18) - v5_0.getMeasuredHeight());
                            v18 += v5_0.getMeasuredHeight();
                            break;
                        default:
                            v7_0 = v21;
                    }
                    int v6_1 = (v6_0 + v22);
                    v5_0.layout(v6_1, v7_0, (v5_0.getMeasuredWidth() + v6_1), (v5_0.getMeasuredHeight() + v7_0));
                    v10++;
                }
            }
            v14_1++;
        }
        int v8 = ((v24 - v19) - v20);
        int v14_0 = 0;
        while (v14_0 < v9) {
            android.view.View v5_1 = this.getChildAt(v14_0);
            if (v5_1.getVisibility() != 8) {
                android.support.v4.view.ViewPager$LayoutParams v17_3 = ((android.support.v4.view.ViewPager$LayoutParams) v5_1.getLayoutParams());
                if (!v17_3.isDecor) {
                    android.support.v4.view.ViewPager$ItemInfo v15 = this.infoForChild(v5_1);
                    if (v15 != null) {
                        int v6_2 = (v19 + ((int) (((float) v8) * v15.offset)));
                        int v7_1 = v21;
                        if (v17_3.needsMeasure) {
                            v17_3.needsMeasure = 0;
                            v5_1.measure(android.view.View$MeasureSpec.makeMeasureSpec(((int) (((float) v8) * v17_3.widthFactor)), 1073741824), android.view.View$MeasureSpec.makeMeasureSpec(((v11 - v21) - v18), 1073741824));
                        }
                        v5_1.layout(v6_2, v7_1, (v5_1.getMeasuredWidth() + v6_2), (v5_1.getMeasuredHeight() + v7_1));
                    }
                }
            }
            v14_0++;
        }
        this.mTopPageBounds = v21;
        this.mBottomPageBounds = (v11 - v18);
        this.mDecorChildCount = v10;
        if (this.mFirstLayout) {
            this.scrollToItem(this.mCurItem, 0, 0, 0);
        }
        this.mFirstLayout = 0;
        return;
    }

    protected void onMeasure(int p24, int p25)
    {
        this.setMeasuredDimension(android.support.v4.view.ViewPager.getDefaultSize(0, p24), android.support.v4.view.ViewPager.getDefaultSize(0, p25));
        int v15 = this.getMeasuredWidth();
        this.mGutterSize = Math.min((v15 / 10), this.mDefaultGutterSize);
        int v5 = ((v15 - this.getPaddingLeft()) - this.getPaddingRight());
        int v4 = ((this.getMeasuredHeight() - this.getPaddingTop()) - this.getPaddingBottom());
        int v16_0 = this.getChildCount();
        int v12_1 = 0;
        while (v12_1 < v16_0) {
            android.view.View v3_0 = this.getChildAt(v12_1);
            if (v3_0.getVisibility() != 8) {
                android.support.v4.view.ViewPager$LayoutParams v13_1 = ((android.support.v4.view.ViewPager$LayoutParams) v3_0.getLayoutParams());
                if ((v13_1 != null) && (v13_1.isDecor)) {
                    int v7;
                    int v11 = (v13_1.gravity & 7);
                    int v17 = (v13_1.gravity & 112);
                    int v18 = -2147483648;
                    int v8 = -2147483648;
                    if ((v17 != 48) && (v17 != 80)) {
                        v7 = 0;
                    } else {
                        v7 = 1;
                    }
                    if ((v11 != 3) && (v11 != 5)) {
                        int v6 = 0;
                    } else {
                        v6 = 1;
                    }
                    if (v7 == 0) {
                        if (v6 != 0) {
                            v8 = 1073741824;
                        }
                    } else {
                        v18 = 1073741824;
                    }
                    int v19 = v5;
                    int v9 = v4;
                    if (v13_1.width != -2) {
                        v18 = 1073741824;
                        if (v13_1.width != -1) {
                            v19 = v13_1.width;
                        }
                    }
                    if (v13_1.height != -2) {
                        v8 = 1073741824;
                        if (v13_1.height != -1) {
                            v9 = v13_1.height;
                        }
                    }
                    v3_0.measure(android.view.View$MeasureSpec.makeMeasureSpec(v19, v18), android.view.View$MeasureSpec.makeMeasureSpec(v9, v8));
                    if (v7 == 0) {
                        if (v6 != 0) {
                            v5 -= v3_0.getMeasuredWidth();
                        }
                    } else {
                        v4 -= v3_0.getMeasuredHeight();
                    }
                }
            }
            v12_1++;
        }
        this.mChildWidthMeasureSpec = android.view.View$MeasureSpec.makeMeasureSpec(v5, 1073741824);
        this.mChildHeightMeasureSpec = android.view.View$MeasureSpec.makeMeasureSpec(v4, 1073741824);
        this.mInLayout = 1;
        this.populate();
        this.mInLayout = 0;
        int v16_1 = this.getChildCount();
        int v12_0 = 0;
        while (v12_0 < v16_1) {
            android.view.View v3_1 = this.getChildAt(v12_0);
            if (v3_1.getVisibility() != 8) {
                android.support.v4.view.ViewPager$LayoutParams v13_3 = ((android.support.v4.view.ViewPager$LayoutParams) v3_1.getLayoutParams());
                if ((v13_3 == null) || (!v13_3.isDecor)) {
                    v3_1.measure(android.view.View$MeasureSpec.makeMeasureSpec(((int) (((float) v5) * v13_3.widthFactor)), 1073741824), this.mChildHeightMeasureSpec);
                }
            }
            v12_0++;
        }
        return;
    }

    protected void onPageScrolled(int p18, float p19, int p20)
    {
        if (this.mDecorChildCount > 0) {
            int v12_1 = this.getScrollX();
            int v10 = this.getPaddingLeft();
            int v11 = this.getPaddingRight();
            int v14 = this.getWidth();
            int v4_0 = this.getChildCount();
            int v8_0 = 0;
            while (v8_0 < v4_0) {
                android.view.View v3_1 = this.getChildAt(v8_0);
                android.support.v4.view.ViewPager$LayoutParams v9_3 = ((android.support.v4.view.ViewPager$LayoutParams) v3_1.getLayoutParams());
                if (v9_3.isDecor) {
                    int v5_0;
                    switch ((v9_3.gravity & 7)) {
                        case 1:
                            v5_0 = Math.max(((v14 - v3_1.getMeasuredWidth()) / 2), v10);
                            break;
                        case 2:
                        case 4:
                        default:
                            v5_0 = v10;
                            break;
                        case 3:
                            v5_0 = v10;
                            v10 += v3_1.getWidth();
                            break;
                        case 5:
                            v5_0 = ((v14 - v11) - v3_1.getMeasuredWidth());
                            v11 += v3_1.getMeasuredWidth();
                            break;
                    }
                    int v6 = ((v5_0 + v12_1) - v3_1.getLeft());
                    if (v6 != 0) {
                        v3_1.offsetLeftAndRight(v6);
                    }
                }
                v8_0++;
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(p18, p19, p20);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(p18, p19, p20);
        }
        if (this.mPageTransformer != null) {
            int v12_0 = this.getScrollX();
            int v4_1 = this.getChildCount();
            int v8_1 = 0;
            while (v8_1 < v4_1) {
                android.view.View v3_0 = this.getChildAt(v8_1);
                if (!((android.support.v4.view.ViewPager$LayoutParams) v3_0.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(v3_0, (((float) (v3_0.getLeft() - v12_0)) / ((float) this.getClientWidth())));
                }
                v8_1++;
            }
        }
        this.mCalledSuper = 1;
        return;
    }

    protected boolean onRequestFocusInDescendants(int p10, android.graphics.Rect p11)
    {
        int v5;
        int v6;
        int v2;
        int v1 = this.getChildCount();
        if ((p10 & 2) == 0) {
            v6 = (v1 - 1);
            v5 = -1;
            v2 = -1;
        } else {
            v6 = 0;
            v5 = 1;
            v2 = v1;
        }
        int v3 = v6;
        while (v3 != v2) {
            android.view.View v0 = this.getChildAt(v3);
            if (v0.getVisibility() == 0) {
                android.support.v4.view.ViewPager$ItemInfo v4 = this.infoForChild(v0);
                if ((v4 != null) && ((v4.position == this.mCurItem) && (v0.requestFocus(p10, p11)))) {
                    int v7_0 = 1;
                    return v7_0;
                }
            }
            v3 += v5;
        }
        v7_0 = 0;
        return v7_0;
    }

    public void onRestoreInstanceState(android.os.Parcelable p5)
    {
        if ((p5 instanceof android.support.v4.view.ViewPager$SavedState)) {
            super.onRestoreInstanceState(((android.support.v4.view.ViewPager$SavedState) p5).getSuperState());
            if (this.mAdapter == null) {
                this.mRestoredCurItem = ((android.support.v4.view.ViewPager$SavedState) p5).position;
                this.mRestoredAdapterState = ((android.support.v4.view.ViewPager$SavedState) p5).adapterState;
                this.mRestoredClassLoader = ((android.support.v4.view.ViewPager$SavedState) p5).loader;
            } else {
                this.mAdapter.restoreState(((android.support.v4.view.ViewPager$SavedState) p5).adapterState, ((android.support.v4.view.ViewPager$SavedState) p5).loader);
                this.setCurrentItemInternal(((android.support.v4.view.ViewPager$SavedState) p5).position, 0, 1);
            }
        } else {
            super.onRestoreInstanceState(p5);
        }
        return;
    }

    public android.os.Parcelable onSaveInstanceState()
    {
        android.support.v4.view.ViewPager$SavedState v0_1 = new android.support.v4.view.ViewPager$SavedState(super.onSaveInstanceState());
        v0_1.position = this.mCurItem;
        if (this.mAdapter != null) {
            v0_1.adapterState = this.mAdapter.saveState();
        }
        return v0_1;
    }

    protected void onSizeChanged(int p3, int p4, int p5, int p6)
    {
        super.onSizeChanged(p3, p4, p5, p6);
        if (p3 != p5) {
            this.recomputeScrollPosition(p3, p5, this.mPageMargin, this.mPageMargin);
        }
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p29)
    {
        int v24_52;
        if (!this.mFakeDragging) {
            if ((p29.getAction() != 0) || (p29.getEdgeFlags() == 0)) {
                if ((this.mAdapter != null) && (this.mAdapter.getCount() != 0)) {
                    if (this.mVelocityTracker == null) {
                        this.mVelocityTracker = android.view.VelocityTracker.obtain();
                    }
                    this.mVelocityTracker.addMovement(p29);
                    int v11 = 0;
                    switch ((p29.getAction() & 255)) {
                        case 0:
                            this.mScroller.abortAnimation();
                            this.mPopulatePending = 0;
                            this.populate();
                            int v24_48 = p29.getX();
                            this.mInitialMotionX = v24_48;
                            this.mLastMotionX = v24_48;
                            int v24_49 = p29.getY();
                            this.mInitialMotionY = v24_49;
                            this.mLastMotionY = v24_49;
                            this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p29, 0);
                            break;
                        case 1:
                            if (!this.mIsBeingDragged) {
                            } else {
                                android.view.VelocityTracker v18 = this.mVelocityTracker;
                                v18.computeCurrentVelocity(1000, ((float) this.mMaximumVelocity));
                                int v10 = ((int) android.support.v4.view.VelocityTrackerCompat.getXVelocity(v18, this.mActivePointerId));
                                this.mPopulatePending = 1;
                                int v19 = this.getClientWidth();
                                int v16 = this.getScrollX();
                                android.support.v4.view.ViewPager$ItemInfo v8 = this.infoForCurrentScrollPosition();
                                this.setCurrentItemInternal(this.determineTargetPage(v8.position, (((((float) v16) / ((float) v19)) - v8.offset) / v8.widthFactor), v10, ((int) (android.support.v4.view.MotionEventCompat.getX(p29, android.support.v4.view.MotionEventCompat.findPointerIndex(p29, this.mActivePointerId)) - this.mInitialMotionX))), 1, 1, v10);
                                this.mActivePointerId = -1;
                                this = this.endDrag();
                                v11 = (this.mLeftEdge.onRelease() | this.mRightEdge.onRelease());
                            }
                            break;
                        case 2:
                            if (!this.mIsBeingDragged) {
                                int v15 = android.support.v4.view.MotionEventCompat.findPointerIndex(p29, this.mActivePointerId);
                                float v20_0 = android.support.v4.view.MotionEventCompat.getX(p29, v15);
                                float v21 = Math.abs((v20_0 - this.mLastMotionX));
                                float v22 = android.support.v4.view.MotionEventCompat.getY(p29, v15);
                                float v23 = Math.abs((v22 - this.mLastMotionY));
                                if ((v21 > ((float) this.mTouchSlop)) && (v21 > v23)) {
                                    int v24_18;
                                    this.mIsBeingDragged = 1;
                                    this.requestParentDisallowInterceptTouchEvent(1);
                                    if ((v20_0 - this.mInitialMotionX) <= 0) {
                                        v24_18 = (this.mInitialMotionX - ((float) this.mTouchSlop));
                                    } else {
                                        v24_18 = (this.mInitialMotionX + ((float) this.mTouchSlop));
                                    }
                                    this.mLastMotionX = v24_18;
                                    this.mLastMotionY = v22;
                                    this.setScrollState(1);
                                    this.setScrollingCacheEnabled(1);
                                    android.view.ViewParent v14 = this.getParent();
                                    if (v14 != null) {
                                        v14.requestDisallowInterceptTouchEvent(1);
                                    }
                                }
                            }
                            if (!this.mIsBeingDragged) {
                            } else {
                                v11 = (0 | this.performDrag(android.support.v4.view.MotionEventCompat.getX(p29, android.support.v4.view.MotionEventCompat.findPointerIndex(p29, this.mActivePointerId))));
                            }
                            break;
                        case 3:
                            if (this.mIsBeingDragged) {
                                this.scrollToItem(this.mCurItem, 1, 0, 0);
                                this.mActivePointerId = -1;
                                this = this.endDrag();
                                v11 = (this.mLeftEdge.onRelease() | this.mRightEdge.onRelease());
                            } else {
                            }
                        case 4:
                        default:
                            break;
                        case 5:
                            int v9 = android.support.v4.view.MotionEventCompat.getActionIndex(p29);
                            this.mLastMotionX = android.support.v4.view.MotionEventCompat.getX(p29, v9);
                            this.mActivePointerId = android.support.v4.view.MotionEventCompat.getPointerId(p29, v9);
                            break;
                        case 6:
                            this = this.onSecondaryPointerUp(p29);
                            this.mLastMotionX = android.support.v4.view.MotionEventCompat.getX(p29, android.support.v4.view.MotionEventCompat.findPointerIndex(p29, this.mActivePointerId));
                            break;
                    }
                    if (v11 != 0) {
                        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
                    }
                    v24_52 = 1;
                } else {
                    v24_52 = 0;
                }
            } else {
                v24_52 = 0;
            }
        } else {
            v24_52 = 1;
        }
        return v24_52;
    }

    boolean pageLeft()
    {
        int v0 = 1;
        if (this.mCurItem <= 0) {
            v0 = 0;
        } else {
            this.setCurrentItem((this.mCurItem - 1), 1);
        }
        return v0;
    }

    boolean pageRight()
    {
        int v0 = 1;
        if ((this.mAdapter == null) || (this.mCurItem >= (this.mAdapter.getCount() - 1))) {
            v0 = 0;
        } else {
            this.setCurrentItem((this.mCurItem + 1), 1);
        }
        return v0;
    }

    void populate()
    {
        this.populate(this.mCurItem);
        return;
    }

    void populate(int p31)
    {
        android.support.v4.view.ViewPager$ItemInfo v21 = 0;
        int v15 = 2;
        if (this.mCurItem != p31) {
            if (this.mCurItem >= p31) {
                v15 = 17;
            } else {
                v15 = 66;
            }
            v21 = this.infoForPosition(this.mCurItem);
            this.mCurItem = p31;
        }
        if (this.mAdapter != null) {
            if (!this.mPopulatePending) {
                if (this.getWindowToken() != null) {
                    this.mAdapter.startUpdate(this);
                    int v22 = this.mOffscreenPageLimit;
                    int v26 = Math.max(0, (this.mCurItem - v22));
                    int v4 = this.mAdapter.getCount();
                    int v12 = Math.min((v4 - 1), (this.mCurItem + v22));
                    if (v4 == this.mExpectedAdapterCount) {
                        android.support.v4.view.ViewPager$ItemInfo v9 = 0;
                        int v8 = 0;
                        while (v8 < this.mItems.size()) {
                            int v17_8 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v8));
                            if (v17_8.position < this.mCurItem) {
                                v8++;
                            } else {
                                if (v17_8.position != this.mCurItem) {
                                    break;
                                }
                                v9 = v17_8;
                                break;
                            }
                        }
                        if ((v9 == null) && (v4 > 0)) {
                            v9 = this.addNewItem(this.mCurItem, v8);
                        }
                        if (v9 != null) {
                            int v17_0;
                            float v13 = 0;
                            int v18_0 = (v8 - 1);
                            if (v18_0 < 0) {
                                v17_0 = 0;
                            } else {
                                v17_0 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_0));
                            }
                            float v19;
                            int v7 = this.getClientWidth();
                            if (v7 > 0) {
                                v19 = ((1073741824 - v9.widthFactor) + (((float) this.getPaddingLeft()) / ((float) v7)));
                            } else {
                                v19 = 0;
                            }
                            int v23_0 = (this.mCurItem - 1);
                            while (v23_0 >= 0) {
                                if ((v13 < v19) || (v23_0 >= v26)) {
                                    if ((v17_0 == 0) || (v23_0 != v17_0.position)) {
                                        v13 += this.addNewItem(v23_0, (v18_0 + 1)).widthFactor;
                                        v8++;
                                        if (v18_0 < 0) {
                                            v17_0 = 0;
                                        } else {
                                            v17_0 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_0));
                                        }
                                    } else {
                                        v13 += v17_0.widthFactor;
                                        v18_0--;
                                        if (v18_0 < 0) {
                                            v17_0 = 0;
                                        } else {
                                            v17_0 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_0));
                                        }
                                    }
                                } else {
                                    if (v17_0 == 0) {
                                        break;
                                    }
                                    if ((v23_0 == v17_0.position) && (!v17_0.scrolling)) {
                                        this.mItems.remove(v18_0);
                                        this.mAdapter.destroyItem(this, v23_0, v17_0.object);
                                        v18_0--;
                                        v8--;
                                        if (v18_0 < 0) {
                                            v17_0 = 0;
                                        } else {
                                            v17_0 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_0));
                                        }
                                    }
                                }
                                v23_0--;
                            }
                            float v14 = v9.widthFactor;
                            int v18_1 = (v8 + 1);
                            if (v14 < 1073741824) {
                                int v17_2;
                                if (v18_1 >= this.mItems.size()) {
                                    v17_2 = 0;
                                } else {
                                    v17_2 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_1));
                                }
                                float v25;
                                if (v7 > 0) {
                                    v25 = ((((float) this.getPaddingRight()) / ((float) v7)) + 1073741824);
                                } else {
                                    v25 = 0;
                                }
                                int v23_1 = (this.mCurItem + 1);
                                while (v23_1 < v4) {
                                    if ((v14 < v25) || (v23_1 <= v12)) {
                                        if ((v17_2 == 0) || (v23_1 != v17_2.position)) {
                                            int v17_3 = this.addNewItem(v23_1, v18_1);
                                            v18_1++;
                                            v14 += v17_3.widthFactor;
                                            if (v18_1 >= this.mItems.size()) {
                                                v17_2 = 0;
                                            } else {
                                                v17_2 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_1));
                                            }
                                        } else {
                                            v14 += v17_2.widthFactor;
                                            v18_1++;
                                            if (v18_1 >= this.mItems.size()) {
                                                v17_2 = 0;
                                            } else {
                                                v17_2 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_1));
                                            }
                                        }
                                    } else {
                                        if (v17_2 == 0) {
                                            break;
                                        }
                                        if ((v23_1 == v17_2.position) && (!v17_2.scrolling)) {
                                            this.mItems.remove(v18_1);
                                            this.mAdapter.destroyItem(this, v23_1, v17_2.object);
                                            if (v18_1 >= this.mItems.size()) {
                                                v17_2 = 0;
                                            } else {
                                                v17_2 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v18_1));
                                            }
                                        }
                                    }
                                    v23_1++;
                                }
                            }
                            this.calculatePageOffsets(v9, v8, v21);
                        }
                        android.support.v4.view.ViewPager$ItemInfo v27_66;
                        if (v9 == null) {
                            v27_66 = 0;
                        } else {
                            v27_66 = v9.object;
                        }
                        this.mAdapter.setPrimaryItem(this, this.mCurItem, v27_66);
                        this.mAdapter.finishUpdate(this);
                        int v6 = this.getChildCount();
                        int v16_0 = 0;
                        while (v16_0 < v6) {
                            android.view.View v5_1 = this.getChildAt(v16_0);
                            android.support.v4.view.ViewPager$LayoutParams v20_1 = ((android.support.v4.view.ViewPager$LayoutParams) v5_1.getLayoutParams());
                            v20_1.childIndex = v16_0;
                            if ((!v20_1.isDecor) && (v20_1.widthFactor == 0)) {
                                int v17_6 = this.infoForChild(v5_1);
                                if (v17_6 != 0) {
                                    v20_1.widthFactor = v17_6.widthFactor;
                                    v20_1.position = v17_6.position;
                                }
                            }
                            v16_0++;
                        }
                        void v30_1 = this.sortChildDrawingOrder();
                        if (v30_1.hasFocus()) {
                            int v17_4;
                            android.view.View v10 = v30_1.findFocus();
                            if (v10 == null) {
                                v17_4 = 0;
                            } else {
                                v17_4 = v30_1.infoForAnyChild(v10);
                            }
                            if ((v17_4 == 0) || (v17_4.position != v30_1.mCurItem)) {
                                int v16_1 = 0;
                                while (v16_1 < v30_1.getChildCount()) {
                                    android.view.View v5_0 = v30_1.getChildAt(v16_1);
                                    int v17_5 = v30_1.infoForChild(v5_0);
                                    if ((v17_5 != 0) && ((v17_5.position == v30_1.mCurItem) && (v5_0.requestFocus(v15)))) {
                                        break;
                                    }
                                    v16_1++;
                                }
                            }
                        }
                    } else {
                        try {
                            String v24 = this.getResources().getResourceName(this.getId());
                        } catch (android.content.res.Resources$NotFoundException v11) {
                            v24 = Integer.toHexString(this.getId());
                        }
                        throw new IllegalStateException(new StringBuilder().append("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ").append(this.mExpectedAdapterCount).append(", found: ").append(v4).append(" Pager id: ").append(v24).append(" Pager class: ").append(this.getClass()).append(" Problematic adapter: ").append(this.mAdapter.getClass()).toString());
                    }
                }
            } else {
                this.sortChildDrawingOrder();
            }
        } else {
            this.sortChildDrawingOrder();
        }
        return;
    }

    public void removeView(android.view.View p2)
    {
        if (!this.mInLayout) {
            super.removeView(p2);
        } else {
            this.removeViewInLayout(p2);
        }
        return;
    }

    public void setAdapter(android.support.v4.view.PagerAdapter p11)
    {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate(this);
            int v0 = 0;
            while (v0 < this.mItems.size()) {
                android.support.v4.view.ViewPager$ItemInfo v1_1 = ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v0));
                this.mAdapter.destroyItem(this, v1_1.position, v1_1.object);
                v0++;
            }
            this.mAdapter.finishUpdate(this);
            this.mItems.clear();
            this.removeNonDecorViews();
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }
        android.support.v4.view.PagerAdapter v2 = this.mAdapter;
        this.mAdapter = p11;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new android.support.v4.view.ViewPager$PagerObserver(this, 0);
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = 0;
            boolean v3 = this.mFirstLayout;
            this.mFirstLayout = 1;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem < 0) {
                if (v3) {
                    this.requestLayout();
                } else {
                    this.populate();
                }
            } else {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, 0, 1);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = 0;
                this.mRestoredClassLoader = 0;
            }
        }
        if ((this.mAdapterChangeListener != null) && (v2 != p11)) {
            this.mAdapterChangeListener.onAdapterChanged(v2, p11);
        }
        return;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean p7)
    {
        if (android.os.Build$VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    int v3_2 = new Class[1];
                    v3_2[0] = Boolean.TYPE;
                    this.mSetChildrenDrawingOrderEnabled = android.view.ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", v3_2);
                } catch (Exception v0_0) {
                    android.util.Log.e("ViewPager", "Can\'t find setChildrenDrawingOrderEnabled", v0_0);
                }
                String v1_3 = this.mSetChildrenDrawingOrderEnabled;
                String v2_3 = new Object[1];
                v2_3[0] = Boolean.valueOf(p7);
                v1_3.invoke(this, v2_3);
                return;
            }
            try {
            } catch (Exception v0_1) {
                android.util.Log.e("ViewPager", "Error changing children drawing order", v0_1);
            }
        }
        return;
    }

    public void setCurrentItem(int p3)
    {
        int v0_1;
        this.mPopulatePending = 0;
        if (this.mFirstLayout) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        this.setCurrentItemInternal(p3, v0_1, 0);
        return;
    }

    public void setCurrentItem(int p2, boolean p3)
    {
        this.mPopulatePending = 0;
        this.setCurrentItemInternal(p2, p3, 0);
        return;
    }

    void setCurrentItemInternal(int p2, boolean p3, boolean p4)
    {
        this.setCurrentItemInternal(p2, p3, p4, 0);
        return;
    }

    void setCurrentItemInternal(int p6, boolean p7, boolean p8, int p9)
    {
        int v0 = 1;
        if ((this.mAdapter != null) && (this.mAdapter.getCount() > 0)) {
            if ((p8) || ((this.mCurItem != p6) || (this.mItems.size() == 0))) {
                if (p6 >= 0) {
                    if (p6 >= this.mAdapter.getCount()) {
                        p6 = (this.mAdapter.getCount() - 1);
                    }
                } else {
                    p6 = 0;
                }
                int v2 = this.mOffscreenPageLimit;
                if ((p6 > (this.mCurItem + v2)) || (p6 < (this.mCurItem - v2))) {
                    int v1 = 0;
                    while (v1 < this.mItems.size()) {
                        ((android.support.v4.view.ViewPager$ItemInfo) this.mItems.get(v1)).scrolling = 1;
                        v1++;
                    }
                }
                if (this.mCurItem == p6) {
                    v0 = 0;
                }
                if (!this.mFirstLayout) {
                    this.populate(p6);
                    this.scrollToItem(p6, p7, p9, v0);
                } else {
                    this.mCurItem = p6;
                    if ((v0 != 0) && (this.mOnPageChangeListener != null)) {
                        this.mOnPageChangeListener.onPageSelected(p6);
                    }
                    if ((v0 != 0) && (this.mInternalPageChangeListener != null)) {
                        this.mInternalPageChangeListener.onPageSelected(p6);
                    }
                    this.requestLayout();
                }
            } else {
                this.setScrollingCacheEnabled(0);
            }
        } else {
            this.setScrollingCacheEnabled(0);
        }
        return;
    }

    android.support.v4.view.ViewPager$OnPageChangeListener setInternalPageChangeListener(android.support.v4.view.ViewPager$OnPageChangeListener p2)
    {
        android.support.v4.view.ViewPager$OnPageChangeListener v0 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = p2;
        return v0;
    }

    public void setOffscreenPageLimit(int p5)
    {
        if (p5 < 1) {
            android.util.Log.w("ViewPager", new StringBuilder().append("Requested offscreen page limit ").append(p5).append(" too small; defaulting to ").append(1).toString());
            p5 = 1;
        }
        if (p5 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = p5;
            this.populate();
        }
        return;
    }

    void setOnAdapterChangeListener(android.support.v4.view.ViewPager$OnAdapterChangeListener p1)
    {
        this.mAdapterChangeListener = p1;
        return;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager$OnPageChangeListener p1)
    {
        this.mOnPageChangeListener = p1;
        return;
    }

    public void setPageMargin(int p3)
    {
        int v0 = this.mPageMargin;
        this.mPageMargin = p3;
        this.recomputeScrollPosition(this.getWidth(), this.getWidth(), p3, v0);
        this.requestLayout();
        return;
    }

    public void setPageMarginDrawable(int p2)
    {
        this.setPageMarginDrawable(this.getContext().getResources().getDrawable(p2));
        return;
    }

    public void setPageMarginDrawable(android.graphics.drawable.Drawable p2)
    {
        this.mMarginDrawable = p2;
        if (p2 != null) {
            this.refreshDrawableState();
        }
        int v0;
        if (p2 != null) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        this.setWillNotDraw(v0);
        this.invalidate();
        return;
    }

    public void setPageTransformer(boolean p7, android.support.v4.view.ViewPager$PageTransformer p8)
    {
        int v2 = 1;
        if (android.os.Build$VERSION.SDK_INT >= 11) {
            int v0;
            if (p8 == null) {
                v0 = 0;
            } else {
                v0 = 1;
            }
            int v4_0;
            if (this.mPageTransformer == null) {
                v4_0 = 0;
            } else {
                v4_0 = 1;
            }
            int v1;
            if (v0 == v4_0) {
                v1 = 0;
            } else {
                v1 = 1;
            }
            this.mPageTransformer = p8;
            this.setChildrenDrawingOrderEnabledCompat(v0);
            if (v0 == 0) {
                this.mDrawingOrder = 0;
            } else {
                if (p7) {
                    v2 = 2;
                }
                this.mDrawingOrder = v2;
            }
            if (v1 != 0) {
                this.populate();
            }
        }
        return;
    }

    void smoothScrollTo(int p2, int p3)
    {
        this.smoothScrollTo(p2, p3, 0);
        return;
    }

    void smoothScrollTo(int p16, int p17, int p18)
    {
        if (this.getChildCount() != 0) {
            int v2 = this.getScrollX();
            int v3 = this.getScrollY();
            int v4 = (p16 - v2);
            int v5 = (p17 - v3);
            if ((v4 != 0) || (v5 != 0)) {
                int v6_0;
                this.setScrollingCacheEnabled(1);
                this.setScrollState(2);
                int v12 = this.getClientWidth();
                int v9 = (v12 / 2);
                float v7 = (((float) v9) + (((float) v9) * this.distanceInfluenceForSnapDuration(Math.min(1065353216, ((1065353216 * ((float) Math.abs(v4))) / ((float) v12))))));
                int v18_1 = Math.abs(p18);
                if (v18_1 <= 0) {
                    v6_0 = ((int) ((1065353216 + (((float) Math.abs(v4)) / (((float) this.mPageMargin) + (((float) v12) * this.mAdapter.getPageWidth(this.mCurItem))))) * 1120403456));
                } else {
                    v6_0 = (Math.round((1148846080 * Math.abs((v7 / ((float) v18_1))))) * 4);
                }
                this.mScroller.startScroll(v2, v3, v4, v5, Math.min(v6_0, 600));
                android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.completeScroll(0);
                this.populate();
                this.setScrollState(0);
            }
        } else {
            this.setScrollingCacheEnabled(0);
        }
        return;
    }

    protected boolean verifyDrawable(android.graphics.drawable.Drawable p2)
    {
        if ((!super.verifyDrawable(p2)) && (p2 != this.mMarginDrawable)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }
}
