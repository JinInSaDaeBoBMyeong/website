package android.support.v4.widget;
public class SlidingPaneLayout extends android.view.ViewGroup {
    private static final int DEFAULT_FADE_COLOR = 3435973836;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImpl IMPL = None;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private final android.support.v4.widget.ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private android.support.v4.widget.SlidingPaneLayout$PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    private final java.util.ArrayList mPostedRunnables;
    private boolean mPreservedOpenState;
    private android.graphics.drawable.Drawable mShadowDrawableLeft;
    private android.graphics.drawable.Drawable mShadowDrawableRight;
    private float mSlideOffset;
    private int mSlideRange;
    private android.view.View mSlideableView;
    private int mSliderFadeColor;
    private final android.graphics.Rect mTmpRect;

    static SlidingPaneLayout()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 17) {
            if (v0 < 16) {
                android.support.v4.widget.SlidingPaneLayout.IMPL = new android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase();
            } else {
                android.support.v4.widget.SlidingPaneLayout.IMPL = new android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJB();
            }
        } else {
            android.support.v4.widget.SlidingPaneLayout.IMPL = new android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJBMR1();
        }
        return;
    }

    public SlidingPaneLayout(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public SlidingPaneLayout(android.content.Context p2, android.util.AttributeSet p3)
    {
        this(p2, p3, 0);
        return;
    }

    public SlidingPaneLayout(android.content.Context p6, android.util.AttributeSet p7, int p8)
    {
        super(p6, p7, p8);
        super.mSliderFadeColor = -858993460;
        super.mFirstLayout = 1;
        super.mTmpRect = new android.graphics.Rect();
        super.mPostedRunnables = new java.util.ArrayList();
        float v0 = p6.getResources().getDisplayMetrics().density;
        super.mOverhangSize = ((int) ((1107296256 * v0) + 1056964608));
        android.view.ViewConfiguration.get(p6);
        super.setWillNotDraw(0);
        android.support.v4.view.ViewCompat.setAccessibilityDelegate(super, new android.support.v4.widget.SlidingPaneLayout$AccessibilityDelegate(super));
        android.support.v4.view.ViewCompat.setImportantForAccessibility(super, 1);
        super.mDragHelper = android.support.v4.widget.ViewDragHelper.create(super, 1056964608, new android.support.v4.widget.SlidingPaneLayout$DragHelperCallback(super, 0));
        super.mDragHelper.setMinVelocity((1137180672 * v0));
        return;
    }

    static synthetic boolean access$100(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.mIsUnableToDrag;
    }

    static synthetic void access$1000(android.support.v4.widget.SlidingPaneLayout p0, android.view.View p1)
    {
        p0.invalidateChildRegion(p1);
        return;
    }

    static synthetic java.util.ArrayList access$1100(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.mPostedRunnables;
    }

    static synthetic android.support.v4.widget.ViewDragHelper access$200(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.mDragHelper;
    }

    static synthetic float access$300(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.mSlideOffset;
    }

    static synthetic android.view.View access$400(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.mSlideableView;
    }

    static synthetic boolean access$502(android.support.v4.widget.SlidingPaneLayout p0, boolean p1)
    {
        p0.mPreservedOpenState = p1;
        return p1;
    }

    static synthetic void access$600(android.support.v4.widget.SlidingPaneLayout p0, int p1)
    {
        p0.onPanelDragged(p1);
        return;
    }

    static synthetic boolean access$700(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.isLayoutRtlSupport();
    }

    static synthetic int access$800(android.support.v4.widget.SlidingPaneLayout p1)
    {
        return p1.mSlideRange;
    }

    private boolean closePane(android.view.View p3, int p4)
    {
        int v0 = 0;
        if ((this.mFirstLayout) || (this.smoothSlideTo(0, p4))) {
            this.mPreservedOpenState = 0;
            v0 = 1;
        }
        return v0;
    }

    private void dimChildView(android.view.View p10, float p11, int p12)
    {
        android.support.v4.widget.SlidingPaneLayout$LayoutParams v4_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) p10.getLayoutParams());
        if ((p11 <= 0) || (p12 == 0)) {
            if (android.support.v4.view.ViewCompat.getLayerType(p10) != 0) {
                if (v4_1.dimPaint != null) {
                    v4_1.dimPaint.setColorFilter(0);
                }
                android.support.v4.widget.SlidingPaneLayout$DisableLayerRunnable v2_1 = new android.support.v4.widget.SlidingPaneLayout$DisableLayerRunnable(this, p10);
                this.mPostedRunnables.add(v2_1);
                android.support.v4.view.ViewCompat.postOnAnimation(this, v2_1);
            }
        } else {
            int v1 = ((((int) (((float) ((-16777216 & p12) >> 24)) * p11)) << 24) | (16777215 & p12));
            if (v4_1.dimPaint == null) {
                v4_1.dimPaint = new android.graphics.Paint();
            }
            v4_1.dimPaint.setColorFilter(new android.graphics.PorterDuffColorFilter(v1, android.graphics.PorterDuff$Mode.SRC_OVER));
            if (android.support.v4.view.ViewCompat.getLayerType(p10) != 2) {
                android.support.v4.view.ViewCompat.setLayerType(p10, 2, v4_1.dimPaint);
            }
            this.invalidateChildRegion(p10);
        }
        return;
    }

    private void invalidateChildRegion(android.view.View p2)
    {
        android.support.v4.widget.SlidingPaneLayout.IMPL.invalidateChildRegion(this, p2);
        return;
    }

    private boolean isLayoutRtlSupport()
    {
        int v0 = 1;
        if (android.support.v4.view.ViewCompat.getLayoutDirection(this) != 1) {
            v0 = 0;
        }
        return v0;
    }

    private void onPanelDragged(int p11)
    {
        if (this.mSlideableView != null) {
            int v4;
            boolean v1 = this.isLayoutRtlSupport();
            android.support.v4.widget.SlidingPaneLayout$LayoutParams v2_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams());
            int v0 = this.mSlideableView.getWidth();
            if (!v1) {
                v4 = p11;
            } else {
                v4 = ((this.getWidth() - p11) - v0);
            }
            int v5;
            if (!v1) {
                v5 = this.getPaddingLeft();
            } else {
                v5 = this.getPaddingRight();
            }
            int v3;
            if (!v1) {
                v3 = v2_1.leftMargin;
            } else {
                v3 = v2_1.rightMargin;
            }
            this.mSlideOffset = (((float) (v4 - (v5 + v3))) / ((float) this.mSlideRange));
            if (this.mParallaxBy != 0) {
                this.parallaxOtherViews(this.mSlideOffset);
            }
            if (v2_1.dimWhenOffset) {
                this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
            this.dispatchOnPanelSlide(this.mSlideableView);
        } else {
            this.mSlideOffset = 0;
        }
        return;
    }

    private boolean openPane(android.view.View p3, int p4)
    {
        int v0 = 1;
        if ((!this.mFirstLayout) && (!this.smoothSlideTo(1065353216, p4))) {
            v0 = 0;
        } else {
            this.mPreservedOpenState = 1;
        }
        return v0;
    }

    private void parallaxOtherViews(float p13)
    {
        int v1;
        boolean v4 = this.isLayoutRtlSupport();
        android.support.v4.widget.SlidingPaneLayout$LayoutParams v7_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams());
        if (!v7_1.dimWhenOffset) {
            v1 = 0;
        } else {
            float v9_0;
            if (!v4) {
                v9_0 = v7_1.leftMargin;
            } else {
                v9_0 = v7_1.rightMargin;
            }
            if (v9_0 > 0) {
            } else {
                v1 = 1;
            }
        }
        int v0 = this.getChildCount();
        int v3 = 0;
        while (v3 < v0) {
            android.view.View v8 = this.getChildAt(v3);
            if (v8 != this.mSlideableView) {
                int v6 = ((int) ((1065353216 - this.mParallaxOffset) * ((float) this.mParallaxBy)));
                this.mParallaxOffset = p13;
                int v2 = (v6 - ((int) ((1065353216 - p13) * ((float) this.mParallaxBy))));
                if (v4) {
                    v2 = (- v2);
                }
                v8.offsetLeftAndRight(v2);
                if (v1 != 0) {
                    float v9_9;
                    if (!v4) {
                        v9_9 = (1065353216 - this.mParallaxOffset);
                    } else {
                        v9_9 = (this.mParallaxOffset - 1065353216);
                    }
                    this.dimChildView(v8, v9_9, this.mCoveredFadeColor);
                }
            }
            v3++;
        }
        return;
    }

    private static boolean viewIsOpaque(android.view.View p5)
    {
        int v1 = 1;
        if (!android.support.v4.view.ViewCompat.isOpaque(p5)) {
            if (android.os.Build$VERSION.SDK_INT < 18) {
                android.graphics.drawable.Drawable v0 = p5.getBackground();
                if (v0 == null) {
                    v1 = 0;
                } else {
                    if (v0.getOpacity() != -1) {
                        v1 = 0;
                    }
                }
            } else {
                v1 = 0;
            }
        }
        return v1;
    }

    protected boolean canScroll(android.view.View p12, boolean p13, int p14, int p15, int p16)
    {
        int v0_3;
        if (!(p12 instanceof android.view.ViewGroup)) {
            if (p13) {
                if (!this.isLayoutRtlSupport()) {
                    p14 = (- p14);
                }
                if (android.support.v4.view.ViewCompat.canScrollHorizontally(p12, p14)) {
                    v0_3 = 1;
                    return v0_3;
                }
            }
            v0_3 = 0;
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

    public boolean canSlide()
    {
        return this.mCanSlide;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        if ((!(p2 instanceof android.support.v4.widget.SlidingPaneLayout$LayoutParams)) || (!super.checkLayoutParams(p2))) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean closePane()
    {
        return this.closePane(this.mSlideableView, 0);
    }

    public void computeScroll()
    {
        if (this.mDragHelper.continueSettling(1)) {
            if (this.mCanSlide) {
                android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.mDragHelper.abort();
            }
        }
        return;
    }

    void dispatchOnPanelClosed(android.view.View p2)
    {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(p2);
        }
        this.sendAccessibilityEvent(32);
        return;
    }

    void dispatchOnPanelOpened(android.view.View p2)
    {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(p2);
        }
        this.sendAccessibilityEvent(32);
        return;
    }

    void dispatchOnPanelSlide(android.view.View p3)
    {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(p3, this.mSlideOffset);
        }
        return;
    }

    public void draw(android.graphics.Canvas p11)
    {
        android.graphics.drawable.Drawable v4;
        super.draw(p11);
        if (!this.isLayoutRtlSupport()) {
            v4 = this.mShadowDrawableLeft;
        } else {
            v4 = this.mShadowDrawableRight;
        }
        int v5;
        if (this.getChildCount() <= 1) {
            v5 = 0;
        } else {
            v5 = this.getChildAt(1);
        }
        if ((v5 != 0) && (v4 != null)) {
            int v2;
            int v3;
            int v7 = v5.getTop();
            int v0 = v5.getBottom();
            int v6 = v4.getIntrinsicWidth();
            if (!this.isLayoutRtlSupport()) {
                v3 = v5.getLeft();
                v2 = (v3 - v6);
            } else {
                v2 = v5.getRight();
                v3 = (v2 + v6);
            }
            v4.setBounds(v2, v7, v3, v0);
            v4.draw(p11);
        }
        return;
    }

    protected boolean drawChild(android.graphics.Canvas p8, android.view.View p9, long p10)
    {
        android.support.v4.widget.SlidingPaneLayout$LayoutParams v1_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) p9.getLayoutParams());
        int v3 = p8.save(2);
        if ((this.mCanSlide) && ((!v1_1.slideable) && (this.mSlideableView != null))) {
            p8.getClipBounds(this.mTmpRect);
            if (!this.isLayoutRtlSupport()) {
                this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            } else {
                this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
            }
            p8.clipRect(this.mTmpRect);
        }
        boolean v2;
        if (android.os.Build$VERSION.SDK_INT < 11) {
            if ((!v1_1.dimWhenOffset) || (this.mSlideOffset <= 0)) {
                if (p9.isDrawingCacheEnabled()) {
                    p9.setDrawingCacheEnabled(0);
                }
                v2 = super.drawChild(p8, p9, p10);
            } else {
                if (!p9.isDrawingCacheEnabled()) {
                    p9.setDrawingCacheEnabled(1);
                }
                android.graphics.Bitmap v0 = p9.getDrawingCache();
                if (v0 == null) {
                    android.util.Log.e("SlidingPaneLayout", new StringBuilder().append("drawChild: child view ").append(p9).append(" returned null drawing cache").toString());
                    v2 = super.drawChild(p8, p9, p10);
                } else {
                    p8.drawBitmap(v0, ((float) p9.getLeft()), ((float) p9.getTop()), v1_1.dimPaint);
                    v2 = 0;
                }
            }
        } else {
            v2 = super.drawChild(p8, p9, p10);
        }
        p8.restoreToCount(v3);
        return v2;
    }

    protected android.view.ViewGroup$LayoutParams generateDefaultLayoutParams()
    {
        return new android.support.v4.widget.SlidingPaneLayout$LayoutParams();
    }

    public android.view.ViewGroup$LayoutParams generateLayoutParams(android.util.AttributeSet p3)
    {
        return new android.support.v4.widget.SlidingPaneLayout$LayoutParams(this.getContext(), p3);
    }

    protected android.view.ViewGroup$LayoutParams generateLayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        android.support.v4.widget.SlidingPaneLayout$LayoutParams v0_2;
        if (!(p2 instanceof android.view.ViewGroup$MarginLayoutParams)) {
            v0_2 = new android.support.v4.widget.SlidingPaneLayout$LayoutParams(p2);
        } else {
            v0_2 = new android.support.v4.widget.SlidingPaneLayout$LayoutParams(((android.view.ViewGroup$MarginLayoutParams) p2));
        }
        return v0_2;
    }

    public int getCoveredFadeColor()
    {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance()
    {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor()
    {
        return this.mSliderFadeColor;
    }

    boolean isDimmed(android.view.View p5)
    {
        int v1 = 0;
        if (p5 != null) {
            android.support.v4.widget.SlidingPaneLayout$LayoutParams v0_0 = p5.getLayoutParams();
            if ((this.mCanSlide) && ((((android.support.v4.widget.SlidingPaneLayout$LayoutParams) v0_0).dimWhenOffset) && (this.mSlideOffset > 0))) {
                v1 = 1;
            }
        }
        return v1;
    }

    public boolean isOpen()
    {
        if ((this.mCanSlide) && (this.mSlideOffset != 1065353216)) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    public boolean isSlideable()
    {
        return this.mCanSlide;
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
        int v2 = 0;
        int v0 = this.mPostedRunnables.size();
        while (v2 < v0) {
            ((android.support.v4.widget.SlidingPaneLayout$DisableLayerRunnable) this.mPostedRunnables.get(v2)).run();
            v2++;
        }
        this.mPostedRunnables.clear();
        return;
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent p14)
    {
        int v0 = android.support.v4.view.MotionEventCompat.getActionMasked(p14);
        if ((!this.mCanSlide) && ((v0 == 0) && (this.getChildCount() > 1))) {
            android.view.View v5 = this.getChildAt(1);
            if (v5 != null) {
                int v9_3;
                if (this.mDragHelper.isViewUnder(v5, ((int) p14.getX()), ((int) p14.getY()))) {
                    v9_3 = 0;
                } else {
                    v9_3 = 1;
                }
                this.mPreservedOpenState = v9_3;
            }
        }
        if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (v0 == 0))) {
            if ((v0 != 3) && (v0 != 1)) {
                int v4 = 0;
                switch (v0) {
                    case 0:
                        this.mIsUnableToDrag = 0;
                        float v7_1 = p14.getX();
                        float v8_1 = p14.getY();
                        this.mInitialMotionX = v7_1;
                        this.mInitialMotionY = v8_1;
                        if ((this.mDragHelper.isViewUnder(this.mSlideableView, ((int) v7_1), ((int) v8_1))) && (this.isDimmed(this.mSlideableView))) {
                            v4 = 1;
                        } else {
                        }
                    case 1:
                        break;
                    case 2:
                        float v7_0 = p14.getX();
                        float v8_0 = p14.getY();
                        float v1 = Math.abs((v7_0 - this.mInitialMotionX));
                        float v2 = Math.abs((v8_0 - this.mInitialMotionY));
                        if ((v1 <= ((float) this.mDragHelper.getTouchSlop())) || (v2 <= v1)) {
                        } else {
                            this.mDragHelper.cancel();
                            this.mIsUnableToDrag = 1;
                            int v9_19 = 0;
                        }
                        break;
                    default:
                        if (this.mDragHelper.shouldInterceptTouchEvent(p14)) {
                            v9_19 = 1;
                        } else {
                            if (v4 == 0) {
                                v9_19 = 0;
                            } else {
                            }
                        }
                }
                if ((!this.mDragHelper.shouldInterceptTouchEvent(p14)) && (v4 == 0)) {
                }
            } else {
                this.mDragHelper.cancel();
                v9_19 = 0;
            }
        } else {
            this.mDragHelper.cancel();
            v9_19 = super.onInterceptTouchEvent(p14);
        }
        return v9_19;
    }

    protected void onLayout(boolean p29, int p30, int p31, int p32, int p33)
    {
        boolean v12 = this.isLayoutRtlSupport();
        if (!v12) {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        }
        int v19;
        int v23 = (p32 - p30);
        if (!v12) {
            v19 = this.getPaddingLeft();
        } else {
            v19 = this.getPaddingRight();
        }
        int v18;
        if (!v12) {
            v18 = this.getPaddingRight();
        } else {
            v18 = this.getPaddingLeft();
        }
        int v20 = this.getPaddingTop();
        int v6 = this.getChildCount();
        int v24 = v19;
        int v16 = v24;
        if (this.mFirstLayout) {
            if ((!this.mCanSlide) || (!this.mPreservedOpenState)) {
                int v25_30 = 0;
            } else {
                v25_30 = 1065353216;
            }
            this.mSlideOffset = v25_30;
        }
        int v11_0 = 0;
        while (v11_0 < v6) {
            android.view.View v4 = this.getChildAt(v11_0);
            if (v4.getVisibility() != 8) {
                android.support.v4.widget.SlidingPaneLayout$LayoutParams v13_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) v4.getLayoutParams());
                int v10 = v4.getMeasuredWidth();
                int v17 = 0;
                if (!v13_1.slideable) {
                    if ((!this.mCanSlide) || (this.mParallaxBy == 0)) {
                        v24 = v16;
                    } else {
                        v17 = ((int) ((1065353216 - this.mSlideOffset) * ((float) this.mParallaxBy)));
                        v24 = v16;
                    }
                } else {
                    int v14;
                    int v22 = ((Math.min(v16, ((v23 - v18) - this.mOverhangSize)) - v24) - (v13_1.leftMargin + v13_1.rightMargin));
                    this.mSlideRange = v22;
                    if (!v12) {
                        v14 = v13_1.leftMargin;
                    } else {
                        v14 = v13_1.rightMargin;
                    }
                    int v25_18;
                    if ((((v24 + v14) + v22) + (v10 / 2)) <= (v23 - v18)) {
                        v25_18 = 0;
                    } else {
                        v25_18 = 1;
                    }
                    v13_1.dimWhenOffset = v25_18;
                    int v21 = ((int) (((float) v22) * this.mSlideOffset));
                    v24 += (v21 + v14);
                    this.mSlideOffset = (((float) v21) / ((float) this.mSlideRange));
                }
                int v8;
                int v7;
                if (!v12) {
                    v7 = (v24 - v17);
                    v8 = (v7 + v10);
                } else {
                    v8 = ((v23 - v24) + v17);
                    v7 = (v8 - v10);
                }
                v4.layout(v7, v20, v8, (v20 + v4.getMeasuredHeight()));
                v16 += v4.getWidth();
            }
            v11_0++;
        }
        if (this.mFirstLayout) {
            if (!this.mCanSlide) {
                int v11_1 = 0;
                while (v11_1 < v6) {
                    this.dimChildView(this.getChildAt(v11_1), 0, this.mSliderFadeColor);
                    v11_1++;
                }
            } else {
                if (this.mParallaxBy != 0) {
                    this.parallaxOtherViews(this.mSlideOffset);
                }
                if (((android.support.v4.widget.SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            }
            this.updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = 0;
        return;
    }

    protected void onMeasure(int p32, int p33)
    {
        int v25 = android.view.View$MeasureSpec.getMode(p32);
        int v27 = android.view.View$MeasureSpec.getSize(p32);
        int v12 = android.view.View$MeasureSpec.getMode(p33);
        int v13 = android.view.View$MeasureSpec.getSize(p33);
        if (v25 == 1073741824) {
            if (v12 == 0) {
                if (!this.isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else {
                    if (v12 == 0) {
                        v12 = -2147483648;
                        v13 = 300;
                    }
                }
            }
        } else {
            if (!this.isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else {
                if ((v25 != -2147483648) && (v25 == 0)) {
                    v27 = 300;
                }
            }
        }
        int v16 = 0;
        int v18 = -1;
        switch (v12) {
            case -2147483648:
                v18 = ((v13 - this.getPaddingTop()) - this.getPaddingBottom());
                break;
            case 1073741824:
                v18 = ((v13 - this.getPaddingTop()) - this.getPaddingBottom());
                v16 = v18;
                break;
        }
        float v23 = 0;
        int v4 = 0;
        int v24 = ((v27 - this.getPaddingLeft()) - this.getPaddingRight());
        int v26 = v24;
        int v6 = this.getChildCount();
        if (v6 > 2) {
            android.util.Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = 0;
        int v15_1 = 0;
        while (v15_1 < v6) {
            android.view.View v5_1 = this.getChildAt(v15_1);
            android.support.v4.widget.SlidingPaneLayout$LayoutParams v17_3 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) v5_1.getLayoutParams());
            if (v5_1.getVisibility() != 8) {
                if (v17_3.weight > 0) {
                    v23 += v17_3.weight;
                    if (v17_3.width == 0) {
                        v15_1++;
                    }
                }
                int v10_3;
                int v14_1 = (v17_3.leftMargin + v17_3.rightMargin);
                if (v17_3.width != -2) {
                    if (v17_3.width != -1) {
                        v10_3 = android.view.View$MeasureSpec.makeMeasureSpec(v17_3.width, 1073741824);
                    } else {
                        v10_3 = android.view.View$MeasureSpec.makeMeasureSpec((v24 - v14_1), 1073741824);
                    }
                } else {
                    v10_3 = android.view.View$MeasureSpec.makeMeasureSpec((v24 - v14_1), -2147483648);
                }
                int v8_2;
                if (v17_3.height != -2) {
                    if (v17_3.height != -1) {
                        v8_2 = android.view.View$MeasureSpec.makeMeasureSpec(v17_3.height, 1073741824);
                    } else {
                        v8_2 = android.view.View$MeasureSpec.makeMeasureSpec(v18, 1073741824);
                    }
                } else {
                    v8_2 = android.view.View$MeasureSpec.makeMeasureSpec(v18, -2147483648);
                }
                v5_1.measure(v10_3, v8_2);
                int v9 = v5_1.getMeasuredWidth();
                int v7 = v5_1.getMeasuredHeight();
                if ((v12 == -2147483648) && (v7 > v16)) {
                    v16 = Math.min(v7, v18);
                }
                int v29_59;
                v26 -= v9;
                if (v26 >= 0) {
                    v29_59 = 0;
                } else {
                    v29_59 = 1;
                }
                v17_3.slideable = v29_59;
                v4 |= v29_59;
                if (v17_3.slideable) {
                    this.mSlideableView = v5_1;
                }
            } else {
                v17_3.dimWhenOffset = 0;
            }
        }
        if ((v4 != 0) || (v23 > 0)) {
            int v11 = (v24 - this.mOverhangSize);
            int v15_0 = 0;
            while (v15_0 < v6) {
                android.view.View v5_0 = this.getChildAt(v15_0);
                if (v5_0.getVisibility() != 8) {
                    android.support.v4.widget.SlidingPaneLayout$LayoutParams v17_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) v5_0.getLayoutParams());
                    if (v5_0.getVisibility() != 8) {
                        if ((v17_1.width != 0) || (v17_1.weight <= 0)) {
                            int v22 = 0;
                        } else {
                            v22 = 1;
                        }
                        int v20_0;
                        if (v22 == 0) {
                            v20_0 = v5_0.getMeasuredWidth();
                        } else {
                            v20_0 = 0;
                        }
                        if ((v4 == 0) || (v5_0 == this.mSlideableView)) {
                            if (v17_1.weight > 0) {
                                int v8_0;
                                if (v17_1.width != 0) {
                                    v8_0 = android.view.View$MeasureSpec.makeMeasureSpec(v5_0.getMeasuredHeight(), 1073741824);
                                } else {
                                    if (v17_1.height != -2) {
                                        if (v17_1.height != -1) {
                                            v8_0 = android.view.View$MeasureSpec.makeMeasureSpec(v17_1.height, 1073741824);
                                        } else {
                                            v8_0 = android.view.View$MeasureSpec.makeMeasureSpec(v18, 1073741824);
                                        }
                                    } else {
                                        v8_0 = android.view.View$MeasureSpec.makeMeasureSpec(v18, -2147483648);
                                    }
                                }
                                if (v4 == 0) {
                                    v5_0.measure(android.view.View$MeasureSpec.makeMeasureSpec((v20_0 + ((int) ((v17_1.weight * ((float) Math.max(0, v26))) / v23))), 1073741824), v8_0);
                                } else {
                                    int v21 = (v24 - (v17_1.leftMargin + v17_1.rightMargin));
                                    int v10_1 = android.view.View$MeasureSpec.makeMeasureSpec(v21, 1073741824);
                                    if (v20_0 != v21) {
                                        v5_0.measure(v10_1, v8_0);
                                    }
                                }
                            }
                        } else {
                            if ((v17_1.width < 0) && ((v20_0 > v11) || (v17_1.weight > 0))) {
                                int v8_1;
                                if (v22 == 0) {
                                    v8_1 = android.view.View$MeasureSpec.makeMeasureSpec(v5_0.getMeasuredHeight(), 1073741824);
                                } else {
                                    if (v17_1.height != -2) {
                                        if (v17_1.height != -1) {
                                            v8_1 = android.view.View$MeasureSpec.makeMeasureSpec(v17_1.height, 1073741824);
                                        } else {
                                            v8_1 = android.view.View$MeasureSpec.makeMeasureSpec(v18, 1073741824);
                                        }
                                    } else {
                                        v8_1 = android.view.View$MeasureSpec.makeMeasureSpec(v18, -2147483648);
                                    }
                                }
                                v5_0.measure(android.view.View$MeasureSpec.makeMeasureSpec(v11, 1073741824), v8_1);
                            }
                        }
                    }
                }
                v15_0++;
            }
        }
        this.setMeasuredDimension(v27, ((this.getPaddingTop() + v16) + this.getPaddingBottom()));
        this.mCanSlide = v4;
        if ((this.mDragHelper.getViewDragState() != 0) && (v4 == 0)) {
            this.mDragHelper.abort();
        }
        return;
    }

    protected void onRestoreInstanceState(android.os.Parcelable p3)
    {
        super.onRestoreInstanceState(((android.support.v4.widget.SlidingPaneLayout$SavedState) p3).getSuperState());
        if (!((android.support.v4.widget.SlidingPaneLayout$SavedState) p3).isOpen) {
            this.closePane();
        } else {
            this.openPane();
        }
        this.mPreservedOpenState = ((android.support.v4.widget.SlidingPaneLayout$SavedState) p3).isOpen;
        return;
    }

    protected android.os.Parcelable onSaveInstanceState()
    {
        boolean v2_1;
        android.support.v4.widget.SlidingPaneLayout$SavedState v0_1 = new android.support.v4.widget.SlidingPaneLayout$SavedState(super.onSaveInstanceState());
        if (!this.isSlideable()) {
            v2_1 = this.mPreservedOpenState;
        } else {
            v2_1 = this.isOpen();
        }
        v0_1.isOpen = v2_1;
        return v0_1;
    }

    protected void onSizeChanged(int p2, int p3, int p4, int p5)
    {
        super.onSizeChanged(p2, p3, p4, p5);
        if (p2 != p4) {
            this.mFirstLayout = 1;
        }
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p12)
    {
        int v4;
        if (this.mCanSlide) {
            this.mDragHelper.processTouchEvent(p12);
            v4 = 1;
            switch ((p12.getAction() & 255)) {
                case 0:
                    float v5_1 = p12.getX();
                    float v6_1 = p12.getY();
                    this.mInitialMotionX = v5_1;
                    this.mInitialMotionY = v6_1;
                    break;
                case 1:
                    if (this.isDimmed(this.mSlideableView)) {
                        float v5_0 = p12.getX();
                        float v6_0 = p12.getY();
                        if (((((v5_0 - this.mInitialMotionX) * (v5_0 - this.mInitialMotionX)) + ((v6_0 - this.mInitialMotionY) * (v6_0 - this.mInitialMotionY))) < ((float) (this.mDragHelper.getTouchSlop() * this.mDragHelper.getTouchSlop()))) && (this.mDragHelper.isViewUnder(this.mSlideableView, ((int) v5_0), ((int) v6_0)))) {
                            this.closePane(this.mSlideableView, 0);
                        }
                    }
                    break;
                default:
            }
        } else {
            v4 = super.onTouchEvent(p12);
        }
        return v4;
    }

    public boolean openPane()
    {
        return this.openPane(this.mSlideableView, 0);
    }

    public void requestChildFocus(android.view.View p2, android.view.View p3)
    {
        super.requestChildFocus(p2, p3);
        if ((!this.isInTouchMode()) && (!this.mCanSlide)) {
            int v0_3;
            if (p2 != this.mSlideableView) {
                v0_3 = 0;
            } else {
                v0_3 = 1;
            }
            this.mPreservedOpenState = v0_3;
        }
        return;
    }

    void setAllChildrenVisible()
    {
        int v2 = 0;
        int v1 = this.getChildCount();
        while (v2 < v1) {
            android.view.View v0 = this.getChildAt(v2);
            if (v0.getVisibility() == 4) {
                v0.setVisibility(0);
            }
            v2++;
        }
        return;
    }

    public void setCoveredFadeColor(int p1)
    {
        this.mCoveredFadeColor = p1;
        return;
    }

    public void setPanelSlideListener(android.support.v4.widget.SlidingPaneLayout$PanelSlideListener p1)
    {
        this.mPanelSlideListener = p1;
        return;
    }

    public void setParallaxDistance(int p1)
    {
        this.mParallaxBy = p1;
        this.requestLayout();
        return;
    }

    public void setShadowDrawable(android.graphics.drawable.Drawable p1)
    {
        this.setShadowDrawableLeft(p1);
        return;
    }

    public void setShadowDrawableLeft(android.graphics.drawable.Drawable p1)
    {
        this.mShadowDrawableLeft = p1;
        return;
    }

    public void setShadowDrawableRight(android.graphics.drawable.Drawable p1)
    {
        this.mShadowDrawableRight = p1;
        return;
    }

    public void setShadowResource(int p2)
    {
        this.setShadowDrawable(this.getResources().getDrawable(p2));
        return;
    }

    public void setShadowResourceLeft(int p2)
    {
        this.setShadowDrawableLeft(this.getResources().getDrawable(p2));
        return;
    }

    public void setShadowResourceRight(int p2)
    {
        this.setShadowDrawableRight(this.getResources().getDrawable(p2));
        return;
    }

    public void setSliderFadeColor(int p1)
    {
        this.mSliderFadeColor = p1;
        return;
    }

    public void smoothSlideClosed()
    {
        this.closePane();
        return;
    }

    public void smoothSlideOpen()
    {
        this.openPane();
        return;
    }

    boolean smoothSlideTo(float p10, int p11)
    {
        int v5 = 0;
        if (this.mCanSlide) {
            int v4;
            android.support.v4.widget.SlidingPaneLayout$LayoutParams v2_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams());
            if (!this.isLayoutRtlSupport()) {
                v4 = ((int) (((float) (this.getPaddingLeft() + v2_1.leftMargin)) + (((float) this.mSlideRange) * p10)));
            } else {
                v4 = ((int) (((float) this.getWidth()) - ((((float) (this.getPaddingRight() + v2_1.rightMargin)) + (((float) this.mSlideRange) * p10)) + ((float) this.mSlideableView.getWidth()))));
            }
            if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, v4, this.mSlideableView.getTop())) {
                this.setAllChildrenVisible();
                android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this);
                v5 = 1;
            }
        }
        return v5;
    }

    void updateObscuredViewsVisibility(android.view.View p22)
    {
        int v15;
        boolean v12 = this.isLayoutRtlSupport();
        if (!v12) {
            v15 = this.getPaddingLeft();
        } else {
            v15 = (this.getWidth() - this.getPaddingRight());
        }
        int v10;
        if (!v12) {
            v10 = (this.getWidth() - this.getPaddingRight());
        } else {
            v10 = this.getPaddingLeft();
        }
        int v16;
        int v13;
        int v2;
        int v14;
        int v17 = this.getPaddingTop();
        int v3 = (this.getHeight() - this.getPaddingBottom());
        if ((p22 == null) || (!android.support.v4.widget.SlidingPaneLayout.viewIsOpaque(p22))) {
            v2 = 0;
            v16 = 0;
            v14 = 0;
            v13 = 0;
        } else {
            v13 = p22.getLeft();
            v14 = p22.getRight();
            v16 = p22.getTop();
            v2 = p22.getBottom();
        }
        int v11 = 0;
        int v5 = this.getChildCount();
        while (v11 < v5) {
            android.view.View v4 = this.getChildAt(v11);
            if (v4 == p22) {
                break;
            }
            int v19_3;
            if (!v12) {
                v19_3 = v15;
            } else {
                v19_3 = v10;
            }
            int v19_6;
            int v7 = Math.max(v19_3, v4.getLeft());
            int v9 = Math.max(v17, v4.getTop());
            if (!v12) {
                v19_6 = v10;
            } else {
                v19_6 = v15;
            }
            int v18;
            int v8 = Math.min(v19_6, v4.getRight());
            int vtmp25 = Math.min(v3, v4.getBottom());
            if ((v7 < v13) || ((v9 < v16) || ((v8 > v14) || (vtmp25 > v2)))) {
                v18 = 0;
            } else {
                v18 = 4;
            }
            v4.setVisibility(v18);
            v11++;
        }
        return;
    }
}
