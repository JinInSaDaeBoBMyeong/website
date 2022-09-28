package android.support.v4.widget;
public class DrawerLayout extends android.view.ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = False;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = True;
    private static final int DEFAULT_SCRIM_COLOR = 2566914048;
    private static final int[] LAYOUT_ATTRS = None;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 16256;
    private final android.support.v4.widget.DrawerLayout$ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private final android.support.v4.widget.DrawerLayout$ViewDragCallback mLeftCallback;
    private final android.support.v4.widget.ViewDragHelper mLeftDragger;
    private android.support.v4.widget.DrawerLayout$DrawerListener mListener;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mMinDrawerMargin;
    private final android.support.v4.widget.DrawerLayout$ViewDragCallback mRightCallback;
    private final android.support.v4.widget.ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private android.graphics.Paint mScrimPaint;
    private android.graphics.drawable.Drawable mShadowLeft;
    private android.graphics.drawable.Drawable mShadowRight;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    static DrawerLayout()
    {
        int[] v0_1 = new int[1];
        v0_1[0] = 16842931;
        android.support.v4.widget.DrawerLayout.LAYOUT_ATTRS = v0_1;
        return;
    }

    public DrawerLayout(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public DrawerLayout(android.content.Context p2, android.util.AttributeSet p3)
    {
        this(p2, p3, 0);
        return;
    }

    public DrawerLayout(android.content.Context p7, android.util.AttributeSet p8, int p9)
    {
        super(p7, p8, p9);
        super.mChildAccessibilityDelegate = new android.support.v4.widget.DrawerLayout$ChildAccessibilityDelegate(super);
        super.mScrimColor = -1728053248;
        super.mScrimPaint = new android.graphics.Paint();
        super.mFirstLayout = 1;
        float v0 = super.getResources().getDisplayMetrics().density;
        super.mMinDrawerMargin = ((int) ((1115684864 * v0) + 1056964608));
        float v1 = (1137180672 * v0);
        super.mLeftCallback = new android.support.v4.widget.DrawerLayout$ViewDragCallback(super, 3);
        super.mRightCallback = new android.support.v4.widget.DrawerLayout$ViewDragCallback(super, 5);
        super.mLeftDragger = android.support.v4.widget.ViewDragHelper.create(super, 1065353216, super.mLeftCallback);
        super.mLeftDragger.setEdgeTrackingEnabled(1);
        super.mLeftDragger.setMinVelocity(v1);
        super.mLeftCallback.setDragger(super.mLeftDragger);
        super.mRightDragger = android.support.v4.widget.ViewDragHelper.create(super, 1065353216, super.mRightCallback);
        super.mRightDragger.setEdgeTrackingEnabled(2);
        super.mRightDragger.setMinVelocity(v1);
        super.mRightCallback.setDragger(super.mRightDragger);
        super.setFocusableInTouchMode(1);
        android.support.v4.view.ViewCompat.setImportantForAccessibility(super, 1);
        android.support.v4.view.ViewCompat.setAccessibilityDelegate(super, new android.support.v4.widget.DrawerLayout$AccessibilityDelegate(super));
        android.support.v4.view.ViewGroupCompat.setMotionEventSplittingEnabled(super, 0);
        return;
    }

    static synthetic int[] access$100()
    {
        return android.support.v4.widget.DrawerLayout.LAYOUT_ATTRS;
    }

    static synthetic android.view.View access$200(android.support.v4.widget.DrawerLayout p1)
    {
        return p1.findVisibleDrawer();
    }

    static synthetic boolean access$300(android.view.View p1)
    {
        return android.support.v4.widget.DrawerLayout.includeChildForAccessibilitiy(p1);
    }

    private android.view.View findVisibleDrawer()
    {
        int v1 = this.getChildCount();
        int v2 = 0;
        while (v2 < v1) {
            int v0 = this.getChildAt(v2);
            if ((!this.isDrawerView(v0)) || (!this.isDrawerVisible(v0))) {
                v2++;
            }
            return v0;
        }
        v0 = 0;
        return v0;
    }

    static String gravityToString(int p2)
    {
        String v0_2;
        if ((p2 & 3) != 3) {
            if ((p2 & 5) != 5) {
                v0_2 = Integer.toHexString(p2);
            } else {
                v0_2 = "RIGHT";
            }
        } else {
            v0_2 = "LEFT";
        }
        return v0_2;
    }

    private static boolean hasOpaqueBackground(android.view.View p4)
    {
        int v1 = 0;
        android.graphics.drawable.Drawable v0 = p4.getBackground();
        if ((v0 != null) && (v0.getOpacity() == -1)) {
            v1 = 1;
        }
        return v1;
    }

    private boolean hasPeekingDrawer()
    {
        int v0 = this.getChildCount();
        int v1 = 0;
        while (v1 < v0) {
            if (!((android.support.v4.widget.DrawerLayout$LayoutParams) this.getChildAt(v1).getLayoutParams()).isPeeking) {
                v1++;
            } else {
                int v3_1 = 1;
            }
            return v3_1;
        }
        v3_1 = 0;
        return v3_1;
    }

    private boolean hasVisibleDrawer()
    {
        int v0_1;
        if (this.findVisibleDrawer() == null) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    private static boolean includeChildForAccessibilitiy(android.view.View p2)
    {
        if ((android.support.v4.view.ViewCompat.getImportantForAccessibility(p2) == 4) || (android.support.v4.view.ViewCompat.getImportantForAccessibility(p2) == 2)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public void addView(android.view.View p2, int p3, android.view.ViewGroup$LayoutParams p4)
    {
        if ((p3 <= 0) && ((p3 >= 0) || (this.getChildCount() <= 0))) {
            android.support.v4.view.ViewCompat.setImportantForAccessibility(p2, 1);
        } else {
            android.support.v4.view.ViewCompat.setImportantForAccessibility(p2, 4);
            android.support.v4.view.ViewCompat.setAccessibilityDelegate(p2, this.mChildAccessibilityDelegate);
        }
        super.addView(p2, p3, p4);
        return;
    }

    void cancelChildViewTouch()
    {
        if (!this.mChildrenCanceledTouch) {
            long v0 = android.os.SystemClock.uptimeMillis();
            android.view.MotionEvent v8 = android.view.MotionEvent.obtain(v0, v0, 3, 0, 0, 0);
            int v9 = this.getChildCount();
            int v10 = 0;
            while (v10 < v9) {
                this.getChildAt(v10).dispatchTouchEvent(v8);
                v10++;
            }
            v8.recycle();
            this.mChildrenCanceledTouch = 1;
        }
        return;
    }

    boolean checkDrawerViewAbsoluteGravity(android.view.View p3, int p4)
    {
        int v1_1;
        if ((this.getDrawerViewAbsoluteGravity(p3) & p4) != p4) {
            v1_1 = 0;
        } else {
            v1_1 = 1;
        }
        return v1_1;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        if ((!(p2 instanceof android.support.v4.widget.DrawerLayout$LayoutParams)) || (!super.checkLayoutParams(p2))) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public void closeDrawer(int p5)
    {
        android.view.View v0 = this.findDrawerWithGravity(p5);
        if (v0 != null) {
            this.closeDrawer(v0);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("No drawer view found with gravity ").append(android.support.v4.widget.DrawerLayout.gravityToString(p5)).toString());
        }
    }

    public void closeDrawer(android.view.View p5)
    {
        if (this.isDrawerView(p5)) {
            if (!this.mFirstLayout) {
                if (!this.checkDrawerViewAbsoluteGravity(p5, 3)) {
                    this.mRightDragger.smoothSlideViewTo(p5, this.getWidth(), p5.getTop());
                } else {
                    this.mLeftDragger.smoothSlideViewTo(p5, (- p5.getWidth()), p5.getTop());
                }
            } else {
                android.support.v4.widget.DrawerLayout$LayoutParams v0_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) p5.getLayoutParams());
                v0_1.onScreen = 0;
                v0_1.knownOpen = 0;
            }
            this.invalidate();
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("View ").append(p5).append(" is not a sliding drawer").toString());
        }
    }

    public void closeDrawers()
    {
        this.closeDrawers(0);
        return;
    }

    void closeDrawers(boolean p10)
    {
        int v5 = 0;
        int v1 = this.getChildCount();
        int v3 = 0;
        while (v3 < v1) {
            android.view.View v0 = this.getChildAt(v3);
            android.support.v4.widget.DrawerLayout$LayoutParams v4_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) v0.getLayoutParams());
            if ((this.isDrawerView(v0)) && ((!p10) || (v4_1.isPeeking))) {
                int v2 = v0.getWidth();
                if (!this.checkDrawerViewAbsoluteGravity(v0, 3)) {
                    v5 |= this.mRightDragger.smoothSlideViewTo(v0, this.getWidth(), v0.getTop());
                } else {
                    v5 |= this.mLeftDragger.smoothSlideViewTo(v0, (- v2), v0.getTop());
                }
                v4_1.isPeeking = 0;
            }
            v3++;
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (v5 != 0) {
            this.invalidate();
        }
        return;
    }

    public void computeScroll()
    {
        int v0 = this.getChildCount();
        float v3 = 0;
        int v1 = 0;
        while (v1 < v0) {
            v3 = Math.max(v3, ((android.support.v4.widget.DrawerLayout$LayoutParams) this.getChildAt(v1).getLayoutParams()).onScreen);
            v1++;
        }
        this.mScrimOpacity = v3;
        if ((this.mLeftDragger.continueSettling(1) | this.mRightDragger.continueSettling(1)) != 0) {
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
    }

    void dispatchOnDrawerClosed(android.view.View p6)
    {
        android.support.v4.widget.DrawerLayout$LayoutParams v1_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) p6.getLayoutParams());
        if (v1_1.knownOpen) {
            v1_1.knownOpen = 0;
            if (this.mListener != null) {
                this.mListener.onDrawerClosed(p6);
            }
            android.view.View v0 = this.getChildAt(0);
            if (v0 != null) {
                android.support.v4.view.ViewCompat.setImportantForAccessibility(v0, 1);
            }
            android.support.v4.view.ViewCompat.setImportantForAccessibility(p6, 4);
            if (this.hasWindowFocus()) {
                android.view.View v2 = this.getRootView();
                if (v2 != null) {
                    v2.sendAccessibilityEvent(32);
                }
            }
        }
        return;
    }

    void dispatchOnDrawerOpened(android.view.View p5)
    {
        android.support.v4.widget.DrawerLayout$LayoutParams v1_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) p5.getLayoutParams());
        if (!v1_1.knownOpen) {
            v1_1.knownOpen = 1;
            if (this.mListener != null) {
                this.mListener.onDrawerOpened(p5);
            }
            android.view.View v0 = this.getChildAt(0);
            if (v0 != null) {
                android.support.v4.view.ViewCompat.setImportantForAccessibility(v0, 4);
            }
            android.support.v4.view.ViewCompat.setImportantForAccessibility(p5, 1);
            this.sendAccessibilityEvent(32);
            p5.requestFocus();
        }
        return;
    }

    void dispatchOnDrawerSlide(android.view.View p2, float p3)
    {
        if (this.mListener != null) {
            this.mListener.onDrawerSlide(p2, p3);
        }
        return;
    }

    protected boolean drawChild(android.graphics.Canvas p30, android.view.View p31, long p32)
    {
        int v18 = this.getHeight();
        boolean v17 = this.isContentView(p31);
        int v13 = 0;
        int v14 = this.getWidth();
        int v21 = p30.save();
        if (v17) {
            int v10 = this.getChildCount();
            int v19 = 0;
            while (v19 < v10) {
                android.view.View v25 = this.getChildAt(v19);
                if ((v25 != p31) && ((v25.getVisibility() == 0) && ((android.support.v4.widget.DrawerLayout.hasOpaqueBackground(v25)) && ((this.isDrawerView(v25)) && (v25.getHeight() >= v18))))) {
                    if (!this.checkDrawerViewAbsoluteGravity(v25, 3)) {
                        int v26 = v25.getLeft();
                        if (v26 < v14) {
                            v14 = v26;
                        }
                    } else {
                        int v27 = v25.getRight();
                        if (v27 > v13) {
                            v13 = v27;
                        }
                    }
                }
                v19++;
            }
            p30.clipRect(v13, 0, v14, this.getHeight());
        }
        boolean v22 = super.drawChild(p30, p31, p32);
        p30.restoreToCount(v21);
        if ((this.mScrimOpacity <= 0) || (!v17)) {
            if ((this.mShadowLeft == null) || (!this.checkDrawerViewAbsoluteGravity(p31, 3))) {
                if ((this.mShadowRight != null) && (this.checkDrawerViewAbsoluteGravity(p31, 5))) {
                    int v23_0 = this.mShadowRight.getIntrinsicWidth();
                    int v11 = p31.getLeft();
                    float v8_1 = Math.max(0, Math.min((((float) (this.getWidth() - v11)) / ((float) this.mRightDragger.getEdgeSize())), 1065353216));
                    this.mShadowRight.setBounds((v11 - v23_0), p31.getTop(), v11, p31.getBottom());
                    this.mShadowRight.setAlpha(((int) (1132396544 * v8_1)));
                    this.mShadowRight.draw(p30);
                }
            } else {
                int v23_1 = this.mShadowLeft.getIntrinsicWidth();
                int v12 = p31.getRight();
                float v8_0 = Math.max(0, Math.min((((float) v12) / ((float) this.mLeftDragger.getEdgeSize())), 1065353216));
                this.mShadowLeft.setBounds(v12, p31.getTop(), (v12 + v23_1), p31.getBottom());
                this.mShadowLeft.setAlpha(((int) (1132396544 * v8_0)));
                this.mShadowLeft.draw(p30);
            }
        } else {
            this.mScrimPaint.setColor(((((int) (((float) ((this.mScrimColor & -16777216) >> 24)) * this.mScrimOpacity)) << 24) | (this.mScrimColor & 16777215)));
            p30.drawRect(((float) v13), 0, ((float) v14), ((float) this.getHeight()), this.mScrimPaint);
        }
        return v22;
    }

    android.view.View findDrawerWithGravity(int p7)
    {
        int v0 = (android.support.v4.view.GravityCompat.getAbsoluteGravity(p7, android.support.v4.view.ViewCompat.getLayoutDirection(this)) & 7);
        int v3 = this.getChildCount();
        int v4 = 0;
        while (v4 < v3) {
            int v1 = this.getChildAt(v4);
            if ((this.getDrawerViewAbsoluteGravity(v1) & 7) != v0) {
                v4++;
            }
            return v1;
        }
        v1 = 0;
        return v1;
    }

    android.view.View findOpenDrawer()
    {
        int v1 = this.getChildCount();
        int v2 = 0;
        while (v2 < v1) {
            int v0 = this.getChildAt(v2);
            if (!((android.support.v4.widget.DrawerLayout$LayoutParams) v0.getLayoutParams()).knownOpen) {
                v2++;
            }
            return v0;
        }
        v0 = 0;
        return v0;
    }

    protected android.view.ViewGroup$LayoutParams generateDefaultLayoutParams()
    {
        return new android.support.v4.widget.DrawerLayout$LayoutParams(-1, -1);
    }

    public android.view.ViewGroup$LayoutParams generateLayoutParams(android.util.AttributeSet p3)
    {
        return new android.support.v4.widget.DrawerLayout$LayoutParams(this.getContext(), p3);
    }

    protected android.view.ViewGroup$LayoutParams generateLayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        android.support.v4.widget.DrawerLayout$LayoutParams v0_1;
        if (!(p2 instanceof android.support.v4.widget.DrawerLayout$LayoutParams)) {
            if (!(p2 instanceof android.view.ViewGroup$MarginLayoutParams)) {
                v0_1 = new android.support.v4.widget.DrawerLayout$LayoutParams(p2);
            } else {
                v0_1 = new android.support.v4.widget.DrawerLayout$LayoutParams(((android.view.ViewGroup$MarginLayoutParams) p2));
            }
        } else {
            v0_1 = new android.support.v4.widget.DrawerLayout$LayoutParams(((android.support.v4.widget.DrawerLayout$LayoutParams) p2));
        }
        return v0_1;
    }

    public int getDrawerLockMode(int p3)
    {
        int v1_1;
        int v0 = android.support.v4.view.GravityCompat.getAbsoluteGravity(p3, android.support.v4.view.ViewCompat.getLayoutDirection(this));
        if (v0 != 3) {
            if (v0 != 5) {
                v1_1 = 0;
            } else {
                v1_1 = this.mLockModeRight;
            }
        } else {
            v1_1 = this.mLockModeLeft;
        }
        return v1_1;
    }

    public int getDrawerLockMode(android.view.View p3)
    {
        int v1_2;
        int v0 = this.getDrawerViewAbsoluteGravity(p3);
        if (v0 != 3) {
            if (v0 != 5) {
                v1_2 = 0;
            } else {
                v1_2 = this.mLockModeRight;
            }
        } else {
            v1_2 = this.mLockModeLeft;
        }
        return v1_2;
    }

    public CharSequence getDrawerTitle(int p3)
    {
        int v1_1;
        int v0 = android.support.v4.view.GravityCompat.getAbsoluteGravity(p3, android.support.v4.view.ViewCompat.getLayoutDirection(this));
        if (v0 != 3) {
            if (v0 != 5) {
                v1_1 = 0;
            } else {
                v1_1 = this.mTitleRight;
            }
        } else {
            v1_1 = this.mTitleLeft;
        }
        return v1_1;
    }

    int getDrawerViewAbsoluteGravity(android.view.View p3)
    {
        return android.support.v4.view.GravityCompat.getAbsoluteGravity(((android.support.v4.widget.DrawerLayout$LayoutParams) p3.getLayoutParams()).gravity, android.support.v4.view.ViewCompat.getLayoutDirection(this));
    }

    float getDrawerViewOffset(android.view.View p2)
    {
        return ((android.support.v4.widget.DrawerLayout$LayoutParams) p2.getLayoutParams()).onScreen;
    }

    boolean isContentView(android.view.View p2)
    {
        int v0_3;
        if (((android.support.v4.widget.DrawerLayout$LayoutParams) p2.getLayoutParams()).gravity != 0) {
            v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    public boolean isDrawerOpen(int p3)
    {
        int v1;
        android.view.View v0 = this.findDrawerWithGravity(p3);
        if (v0 == null) {
            v1 = 0;
        } else {
            v1 = this.isDrawerOpen(v0);
        }
        return v1;
    }

    public boolean isDrawerOpen(android.view.View p4)
    {
        if (this.isDrawerView(p4)) {
            return ((android.support.v4.widget.DrawerLayout$LayoutParams) p4.getLayoutParams()).knownOpen;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("View ").append(p4).append(" is not a drawer").toString());
        }
    }

    boolean isDrawerView(android.view.View p4)
    {
        int v2_1;
        if ((android.support.v4.view.GravityCompat.getAbsoluteGravity(((android.support.v4.widget.DrawerLayout$LayoutParams) p4.getLayoutParams()).gravity, android.support.v4.view.ViewCompat.getLayoutDirection(p4)) & 7) == 0) {
            v2_1 = 0;
        } else {
            v2_1 = 1;
        }
        return v2_1;
    }

    public boolean isDrawerVisible(int p3)
    {
        int v1;
        android.view.View v0 = this.findDrawerWithGravity(p3);
        if (v0 == null) {
            v1 = 0;
        } else {
            v1 = this.isDrawerVisible(v0);
        }
        return v1;
    }

    public boolean isDrawerVisible(android.view.View p4)
    {
        if (this.isDrawerView(p4)) {
            int v0_1;
            if (((android.support.v4.widget.DrawerLayout$LayoutParams) p4.getLayoutParams()).onScreen <= 0) {
                v0_1 = 0;
            } else {
                v0_1 = 1;
            }
            return v0_1;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("View ").append(p4).append(" is not a drawer").toString());
        }
    }

    void moveDrawerToOffset(android.view.View p7, float p8)
    {
        float v2 = this.getDrawerViewOffset(p7);
        int v4 = p7.getWidth();
        int v0 = (((int) (((float) v4) * p8)) - ((int) (((float) v4) * v2)));
        if (!this.checkDrawerViewAbsoluteGravity(p7, 3)) {
            v0 = (- v0);
        }
        p7.offsetLeftAndRight(v0);
        this.setDrawerViewOffset(p7, p8);
        return;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        this.mFirstLayout = 1;
        return;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        this.mFirstLayout = 1;
        return;
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent p11)
    {
        int v5 = 0;
        int v0 = android.support.v4.view.MotionEventCompat.getActionMasked(p11);
        int v1 = (this.mLeftDragger.shouldInterceptTouchEvent(p11) | this.mRightDragger.shouldInterceptTouchEvent(p11));
        int v2 = 0;
        switch (v0) {
            case 0:
                float v3 = p11.getX();
                float v4 = p11.getY();
                this.mInitialMotionX = v3;
                this.mInitialMotionY = v4;
                if ((this.mScrimOpacity > 0) && (this.isContentView(this.mLeftDragger.findTopChildUnder(((int) v3), ((int) v4))))) {
                    v2 = 1;
                }
                this.mDisallowInterceptRequested = 0;
                this.mChildrenCanceledTouch = 0;
                break;
            case 1:
            case 3:
                this.closeDrawers(1);
                this.mDisallowInterceptRequested = 0;
                this.mChildrenCanceledTouch = 0;
                break;
            case 2:
                if (!this.mLeftDragger.checkTouchSlop(3)) {
                } else {
                    this.mLeftCallback.removeCallbacks();
                    this.mRightCallback.removeCallbacks();
                }
                break;
            default:
                if (v1 != 0) {
                    v5 = 1;
                    return v5;
                } else {
                    if ((v2 == 0) && ((!this.hasPeekingDrawer()) && (!this.mChildrenCanceledTouch))) {
                        return v5;
                    } else {
                    }
                }
        }
        if ((v1 != 0) || ((v2 == 0) || ((!this.hasPeekingDrawer()) || (this.mChildrenCanceledTouch)))) {
        }
        return v5;
    }

    public boolean onKeyDown(int p2, android.view.KeyEvent p3)
    {
        if ((p2 != 4) || (!this.hasVisibleDrawer())) {
            int v0_2 = super.onKeyDown(p2, p3);
        } else {
            android.support.v4.view.KeyEventCompat.startTracking(p3);
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean onKeyUp(int p3, android.view.KeyEvent p4)
    {
        int v1_1;
        if (p3 != 4) {
            v1_1 = super.onKeyUp(p3, p4);
        } else {
            android.view.View v0 = this.findVisibleDrawer();
            if ((v0 != null) && (this.getDrawerLockMode(v0) == 0)) {
                this.closeDrawers();
            }
            if (v0 == null) {
                v1_1 = 0;
            } else {
                v1_1 = 1;
            }
        }
        return v1_1;
    }

    protected void onLayout(boolean p24, int p25, int p26, int p27, int p28)
    {
        this.mInLayout = 1;
        int v17 = (p27 - p25);
        int v6 = this.getChildCount();
        int v12 = 0;
        while (v12 < v6) {
            android.view.View v5 = this.getChildAt(v12);
            if (v5.getVisibility() != 8) {
                android.support.v4.widget.DrawerLayout$LayoutParams v13_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) v5.getLayoutParams());
                if (!this.isContentView(v5)) {
                    float v14;
                    int v8;
                    int v10 = v5.getMeasuredWidth();
                    int v7 = v5.getMeasuredHeight();
                    if (!this.checkDrawerViewAbsoluteGravity(v5, 3)) {
                        v8 = (v17 - ((int) (((float) v10) * v13_1.onScreen)));
                        v14 = (((float) (v17 - v8)) / ((float) v10));
                    } else {
                        v8 = ((- v10) + ((int) (((float) v10) * v13_1.onScreen)));
                        v14 = (((float) (v10 + v8)) / ((float) v10));
                    }
                    int v4;
                    if (v14 == v13_1.onScreen) {
                        v4 = 0;
                    } else {
                        v4 = 1;
                    }
                    switch ((v13_1.gravity & 112)) {
                        case 16:
                            int v11_0 = (p28 - p26);
                            int v9 = ((v11_0 - v7) / 2);
                            if (v9 >= v13_1.topMargin) {
                                if ((v9 + v7) > (v11_0 - v13_1.bottomMargin)) {
                                    v9 = ((v11_0 - v13_1.bottomMargin) - v7);
                                }
                            } else {
                                v9 = v13_1.topMargin;
                            }
                            v5.layout(v8, v9, (v8 + v10), (v9 + v7));
                            break;
                        case 80:
                            int v11_1 = (p28 - p26);
                            v5.layout(v8, ((v11_1 - v13_1.bottomMargin) - v5.getMeasuredHeight()), (v8 + v10), (v11_1 - v13_1.bottomMargin));
                            break;
                        default:
                            v5.layout(v8, v13_1.topMargin, (v8 + v10), (v13_1.topMargin + v7));
                    }
                    if (v4 != 0) {
                        this.setDrawerViewOffset(v5, v14);
                    }
                    int v15;
                    if (v13_1.onScreen <= 0) {
                        v15 = 4;
                    } else {
                        v15 = 0;
                    }
                    if (v5.getVisibility() != v15) {
                        v5.setVisibility(v15);
                    }
                } else {
                    v5.layout(v13_1.leftMargin, v13_1.topMargin, (v13_1.leftMargin + v5.getMeasuredWidth()), (v13_1.topMargin + v5.getMeasuredHeight()));
                }
            }
            v12++;
        }
        this.mInLayout = 0;
        this.mFirstLayout = 0;
        return;
    }

    protected void onMeasure(int p21, int p22)
    {
        int v15 = android.view.View$MeasureSpec.getMode(p21);
        int v11 = android.view.View$MeasureSpec.getMode(p22);
        int v16 = android.view.View$MeasureSpec.getSize(p21);
        int v12 = android.view.View$MeasureSpec.getSize(p22);
        if ((v15 != 1073741824) || (v11 != 1073741824)) {
            if (!this.isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            } else {
                if ((v15 != -2147483648) && (v15 == 0)) {
                    v16 = 300;
                }
                if ((v11 != -2147483648) && (v11 == 0)) {
                    v12 = 300;
                }
            }
        }
        this.setMeasuredDimension(v16, v12);
        int v4 = this.getChildCount();
        int v13 = 0;
        while (v13 < v4) {
            android.view.View v3 = this.getChildAt(v13);
            if (v3.getVisibility() != 8) {
                android.support.v4.widget.DrawerLayout$LayoutParams v14_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) v3.getLayoutParams());
                if (!this.isContentView(v3)) {
                    if (!this.isDrawerView(v3)) {
                        throw new IllegalStateException(new StringBuilder().append("Child ").append(v3).append(" at index ").append(v13).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ").append("Gravity.RIGHT or Gravity.NO_GRAVITY").toString());
                    } else {
                        int v5 = (this.getDrawerViewAbsoluteGravity(v3) & 7);
                        if ((0 & v5) == 0) {
                            v3.measure(android.support.v4.widget.DrawerLayout.getChildMeasureSpec(p21, ((this.mMinDrawerMargin + v14_1.leftMargin) + v14_1.rightMargin), v14_1.width), android.support.v4.widget.DrawerLayout.getChildMeasureSpec(p22, (v14_1.topMargin + v14_1.bottomMargin), v14_1.height));
                        } else {
                            throw new IllegalStateException(new StringBuilder().append("Child drawer has absolute gravity ").append(android.support.v4.widget.DrawerLayout.gravityToString(v5)).append(" but this ").append("DrawerLayout").append(" already has a ").append("drawer view along that edge").toString());
                        }
                    }
                } else {
                    v3.measure(android.view.View$MeasureSpec.makeMeasureSpec(((v16 - v14_1.leftMargin) - v14_1.rightMargin), 1073741824), android.view.View$MeasureSpec.makeMeasureSpec(((v12 - v14_1.topMargin) - v14_1.bottomMargin), 1073741824));
                }
            }
            v13++;
        }
        return;
    }

    protected void onRestoreInstanceState(android.os.Parcelable p5)
    {
        super.onRestoreInstanceState(((android.support.v4.widget.DrawerLayout$SavedState) p5).getSuperState());
        if (((android.support.v4.widget.DrawerLayout$SavedState) p5).openDrawerGravity != 0) {
            android.view.View v1 = this.findDrawerWithGravity(((android.support.v4.widget.DrawerLayout$SavedState) p5).openDrawerGravity);
            if (v1 != null) {
                this.openDrawer(v1);
            }
        }
        this.setDrawerLockMode(((android.support.v4.widget.DrawerLayout$SavedState) p5).lockModeLeft, 3);
        this.setDrawerLockMode(((android.support.v4.widget.DrawerLayout$SavedState) p5).lockModeRight, 5);
        return;
    }

    protected android.os.Parcelable onSaveInstanceState()
    {
        android.support.v4.widget.DrawerLayout$SavedState v4_1 = new android.support.v4.widget.DrawerLayout$SavedState(super.onSaveInstanceState());
        int v1 = this.getChildCount();
        int v2 = 0;
        while (v2 < v1) {
            android.view.View v0 = this.getChildAt(v2);
            if (this.isDrawerView(v0)) {
                android.support.v4.widget.DrawerLayout$LayoutParams v3_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) v0.getLayoutParams());
                if (v3_1.knownOpen) {
                    v4_1.openDrawerGravity = v3_1.gravity;
                    break;
                }
            }
            v2++;
        }
        v4_1.lockModeLeft = this.mLockModeLeft;
        v4_1.lockModeRight = this.mLockModeRight;
        return v4_1;
    }

    public boolean onTouchEvent(android.view.MotionEvent p14)
    {
        this.mLeftDragger.processTouchEvent(p14);
        this.mRightDragger.processTouchEvent(p14);
        switch ((p14.getAction() & 255)) {
            case 0:
                float v8_1 = p14.getX();
                float v9_1 = p14.getY();
                this.mInitialMotionX = v8_1;
                this.mInitialMotionY = v9_1;
                this.mDisallowInterceptRequested = 0;
                this.mChildrenCanceledTouch = 0;
                break;
            case 1:
                float v8_0 = p14.getX();
                float v9_0 = p14.getY();
                int v4 = 1;
                android.view.View v6 = this.mLeftDragger.findTopChildUnder(((int) v8_0), ((int) v9_0));
                if ((v6 != null) && ((this.isContentView(v6)) && ((((v8_0 - this.mInitialMotionX) * (v8_0 - this.mInitialMotionX)) + ((v9_0 - this.mInitialMotionY) * (v9_0 - this.mInitialMotionY))) < ((float) (this.mLeftDragger.getTouchSlop() * this.mLeftDragger.getTouchSlop()))))) {
                    android.view.View v3 = this.findOpenDrawer();
                    if (v3 != null) {
                        if (this.getDrawerLockMode(v3) != 2) {
                            v4 = 0;
                        } else {
                            v4 = 1;
                        }
                    }
                }
                this.closeDrawers(v4);
                this.mDisallowInterceptRequested = 0;
            case 2:
            default:
                break;
            case 3:
                this.closeDrawers(1);
                this.mDisallowInterceptRequested = 0;
                this.mChildrenCanceledTouch = 0;
                break;
        }
        return 1;
    }

    public void openDrawer(int p5)
    {
        android.view.View v0 = this.findDrawerWithGravity(p5);
        if (v0 != null) {
            this.openDrawer(v0);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("No drawer view found with gravity ").append(android.support.v4.widget.DrawerLayout.gravityToString(p5)).toString());
        }
    }

    public void openDrawer(android.view.View p5)
    {
        if (this.isDrawerView(p5)) {
            if (!this.mFirstLayout) {
                if (!this.checkDrawerViewAbsoluteGravity(p5, 3)) {
                    this.mRightDragger.smoothSlideViewTo(p5, (this.getWidth() - p5.getWidth()), p5.getTop());
                } else {
                    this.mLeftDragger.smoothSlideViewTo(p5, 0, p5.getTop());
                }
            } else {
                android.support.v4.widget.DrawerLayout$LayoutParams v0_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) p5.getLayoutParams());
                v0_1.onScreen = 1065353216;
                v0_1.knownOpen = 1;
            }
            this.invalidate();
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("View ").append(p5).append(" is not a sliding drawer").toString());
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean p2)
    {
        super.requestDisallowInterceptTouchEvent(p2);
        this.mDisallowInterceptRequested = p2;
        if (p2) {
            this.closeDrawers(1);
        }
        return;
    }

    public void requestLayout()
    {
        if (!this.mInLayout) {
            super.requestLayout();
        }
        return;
    }

    public void setDrawerListener(android.support.v4.widget.DrawerLayout$DrawerListener p1)
    {
        this.mListener = p1;
        return;
    }

    public void setDrawerLockMode(int p2)
    {
        this.setDrawerLockMode(p2, 3);
        this.setDrawerLockMode(p2, 5);
        return;
    }

    public void setDrawerLockMode(int p7, int p8)
    {
        int v0 = android.support.v4.view.GravityCompat.getAbsoluteGravity(p8, android.support.v4.view.ViewCompat.getLayoutDirection(this));
        if (v0 != 3) {
            if (v0 == 5) {
                this.mLockModeRight = p7;
            }
        } else {
            this.mLockModeLeft = p7;
        }
        if (p7 != 0) {
            android.support.v4.widget.ViewDragHelper v1;
            if (v0 != 3) {
                v1 = this.mRightDragger;
            } else {
                v1 = this.mLeftDragger;
            }
            v1.cancel();
        }
        switch (p7) {
            case 1:
                android.view.View v2 = this.findDrawerWithGravity(v0);
                if (v2 == null) {
                } else {
                    this.closeDrawer(v2);
                }
                break;
            case 2:
                android.view.View v3 = this.findDrawerWithGravity(v0);
                if (v3 == null) {
                } else {
                    this.openDrawer(v3);
                }
                break;
        }
        return;
    }

    public void setDrawerLockMode(int p5, android.view.View p6)
    {
        if (this.isDrawerView(p6)) {
            this.setDrawerLockMode(p5, ((android.support.v4.widget.DrawerLayout$LayoutParams) p6.getLayoutParams()).gravity);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("View ").append(p6).append(" is not a ").append("drawer with appropriate layout_gravity").toString());
        }
    }

    public void setDrawerShadow(int p2, int p3)
    {
        this.setDrawerShadow(this.getResources().getDrawable(p2), p3);
        return;
    }

    public void setDrawerShadow(android.graphics.drawable.Drawable p4, int p5)
    {
        int v0 = android.support.v4.view.GravityCompat.getAbsoluteGravity(p5, android.support.v4.view.ViewCompat.getLayoutDirection(this));
        if ((v0 & 3) == 3) {
            this.mShadowLeft = p4;
            this.invalidate();
        }
        if ((v0 & 5) == 5) {
            this.mShadowRight = p4;
            this.invalidate();
        }
        return;
    }

    public void setDrawerTitle(int p3, CharSequence p4)
    {
        int v0 = android.support.v4.view.GravityCompat.getAbsoluteGravity(p3, android.support.v4.view.ViewCompat.getLayoutDirection(this));
        if (v0 != 3) {
            if (v0 == 5) {
                this.mTitleRight = p4;
            }
        } else {
            this.mTitleLeft = p4;
        }
        return;
    }

    void setDrawerViewOffset(android.view.View p3, float p4)
    {
        android.support.v4.widget.DrawerLayout$LayoutParams v0_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) p3.getLayoutParams());
        if (p4 != v0_1.onScreen) {
            v0_1.onScreen = p4;
            this.dispatchOnDrawerSlide(p3, p4);
        }
        return;
    }

    public void setScrimColor(int p1)
    {
        this.mScrimColor = p1;
        this.invalidate();
        return;
    }

    void updateDrawerState(int p8, int p9, android.view.View p10)
    {
        int v3;
        int v0 = this.mLeftDragger.getViewDragState();
        int v2 = this.mRightDragger.getViewDragState();
        if ((v0 != 1) && (v2 != 1)) {
            if ((v0 != 2) && (v2 != 2)) {
                v3 = 0;
            } else {
                v3 = 2;
            }
        } else {
            v3 = 1;
        }
        if ((p10 != null) && (p9 == 0)) {
            android.support.v4.widget.DrawerLayout$LayoutParams v1_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) p10.getLayoutParams());
            if (v1_1.onScreen != 0) {
                if (v1_1.onScreen == 1065353216) {
                    this.dispatchOnDrawerOpened(p10);
                }
            } else {
                this.dispatchOnDrawerClosed(p10);
            }
        }
        if (v3 != this.mDrawerState) {
            this.mDrawerState = v3;
            if (this.mListener != null) {
                this.mListener.onDrawerStateChanged(v3);
            }
        }
        return;
    }
}
