package android.support.v4.view;
public class PagerTabStrip extends android.support.v4.view.PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final android.graphics.Paint mTabPaint;
    private final android.graphics.Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public PagerTabStrip(android.content.Context p8, android.util.AttributeSet p9)
    {
        super(p8, p9);
        super.mTabPaint = new android.graphics.Paint();
        super.mTempRect = new android.graphics.Rect();
        super.mTabAlpha = 255;
        super.mDrawFullUnderline = 0;
        super.mDrawFullUnderlineSet = 0;
        super.mIndicatorColor = super.mTextColor;
        super.mTabPaint.setColor(super.mIndicatorColor);
        float v0 = p8.getResources().getDisplayMetrics().density;
        super.mIndicatorHeight = ((int) ((1077936128 * v0) + 1056964608));
        super.mMinPaddingBottom = ((int) ((1086324736 * v0) + 1056964608));
        super.mMinTextSpacing = ((int) (1115684864 * v0));
        super.mTabPadding = ((int) ((1098907648 * v0) + 1056964608));
        super.mFullUnderlineHeight = ((int) ((1065353216 * v0) + 1056964608));
        super.mMinStripHeight = ((int) ((1107296256 * v0) + 1056964608));
        super.mTouchSlop = android.view.ViewConfiguration.get(p8).getScaledTouchSlop();
        super.setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        super.setTextSpacing(super.getTextSpacing());
        super.setWillNotDraw(0);
        super.mPrevText.setFocusable(1);
        super.mPrevText.setOnClickListener(new android.support.v4.view.PagerTabStrip$1(super));
        super.mNextText.setFocusable(1);
        super.mNextText.setOnClickListener(new android.support.v4.view.PagerTabStrip$2(super));
        if (super.getBackground() == null) {
            super.mDrawFullUnderline = 1;
        }
        return;
    }

    public boolean getDrawFullUnderline()
    {
        return this.mDrawFullUnderline;
    }

    int getMinHeight()
    {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    public int getTabIndicatorColor()
    {
        return this.mIndicatorColor;
    }

    protected void onDraw(android.graphics.Canvas p13)
    {
        super.onDraw(p13);
        int v7 = this.getHeight();
        int v6 = v7;
        int v8 = (this.mCurrText.getLeft() - this.mTabPadding);
        int v9 = (this.mCurrText.getRight() + this.mTabPadding);
        int v10 = (v6 - this.mIndicatorHeight);
        this.mTabPaint.setColor(((this.mTabAlpha << 24) | (this.mIndicatorColor & 16777215)));
        p13.drawRect(((float) v8), ((float) v10), ((float) v9), ((float) v6), this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((-16777216 | (this.mIndicatorColor & 16777215)));
            p13.drawRect(((float) this.getPaddingLeft()), ((float) (v7 - this.mFullUnderlineHeight)), ((float) (this.getWidth() - this.getPaddingRight())), ((float) v7), this.mTabPaint);
        }
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p7)
    {
        android.support.v4.view.ViewPager v3_0 = 0;
        int v0 = p7.getAction();
        if ((v0 == 0) || (!this.mIgnoreTap)) {
            float v1 = p7.getX();
            float v2 = p7.getY();
            switch (v0) {
                case 0:
                    this.mInitialMotionX = v1;
                    this.mInitialMotionY = v2;
                    this.mIgnoreTap = 0;
                    break;
                case 1:
                    if (v1 >= ((float) (this.mCurrText.getLeft() - this.mTabPadding))) {
                        if (v1 <= ((float) (this.mCurrText.getRight() + this.mTabPadding))) {
                        } else {
                            this.mPager.setCurrentItem((this.mPager.getCurrentItem() + 1));
                        }
                    } else {
                        this.mPager.setCurrentItem((this.mPager.getCurrentItem() - 1));
                    }
                    break;
                case 2:
                    if ((Math.abs((v1 - this.mInitialMotionX)) <= ((float) this.mTouchSlop)) && (Math.abs((v2 - this.mInitialMotionY)) <= ((float) this.mTouchSlop))) {
                    } else {
                        this.mIgnoreTap = 1;
                    }
                    break;
            }
            v3_0 = 1;
        }
        return v3_0;
    }

    public void setBackgroundColor(int p2)
    {
        super.setBackgroundColor(p2);
        if (!this.mDrawFullUnderlineSet) {
            int v0_3;
            if ((-16777216 & p2) != 0) {
                v0_3 = 0;
            } else {
                v0_3 = 1;
            }
            this.mDrawFullUnderline = v0_3;
        }
        return;
    }

    public void setBackgroundDrawable(android.graphics.drawable.Drawable p2)
    {
        super.setBackgroundDrawable(p2);
        if (!this.mDrawFullUnderlineSet) {
            int v0_1;
            if (p2 != null) {
                v0_1 = 0;
            } else {
                v0_1 = 1;
            }
            this.mDrawFullUnderline = v0_1;
        }
        return;
    }

    public void setBackgroundResource(int p2)
    {
        super.setBackgroundResource(p2);
        if (!this.mDrawFullUnderlineSet) {
            int v0_1;
            if (p2 != 0) {
                v0_1 = 0;
            } else {
                v0_1 = 1;
            }
            this.mDrawFullUnderline = v0_1;
        }
        return;
    }

    public void setDrawFullUnderline(boolean p2)
    {
        this.mDrawFullUnderline = p2;
        this.mDrawFullUnderlineSet = 1;
        this.invalidate();
        return;
    }

    public void setPadding(int p2, int p3, int p4, int p5)
    {
        if (p5 < this.mMinPaddingBottom) {
            p5 = this.mMinPaddingBottom;
        }
        super.setPadding(p2, p3, p4, p5);
        return;
    }

    public void setTabIndicatorColor(int p3)
    {
        this.mIndicatorColor = p3;
        this.mTabPaint.setColor(this.mIndicatorColor);
        this.invalidate();
        return;
    }

    public void setTabIndicatorColorResource(int p2)
    {
        this.setTabIndicatorColor(this.getContext().getResources().getColor(p2));
        return;
    }

    public void setTextSpacing(int p2)
    {
        if (p2 < this.mMinTextSpacing) {
            p2 = this.mMinTextSpacing;
        }
        super.setTextSpacing(p2);
        return;
    }

    void updateTextPositions(int p8, float p9, boolean p10)
    {
        android.graphics.Rect v2 = this.mTempRect;
        int v0 = this.getHeight();
        int v4 = (v0 - this.mIndicatorHeight);
        v2.set((this.mCurrText.getLeft() - this.mTabPadding), v4, (this.mCurrText.getRight() + this.mTabPadding), v0);
        super.updateTextPositions(p8, p9, p10);
        this.mTabAlpha = ((int) ((Math.abs((p9 - 1056964608)) * 1073741824) * 1132396544));
        v2.union((this.mCurrText.getLeft() - this.mTabPadding), v4, (this.mCurrText.getRight() + this.mTabPadding), v0);
        this.invalidate(v2);
        return;
    }
}
