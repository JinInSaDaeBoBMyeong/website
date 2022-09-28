package android.support.v4.view;
public class PagerTitleStrip extends android.view.ViewGroup implements android.support.v4.view.ViewPager$Decor {
    private static final int[] ATTRS = None;
    private static final android.support.v4.view.PagerTitleStrip$PagerTitleStripImpl IMPL = None;
    private static final float SIDE_ALPHA = 1058642330;
    private static final String TAG = "PagerTitleStrip";
    private static final int[] TEXT_ATTRS = None;
    private static final int TEXT_SPACING = 16;
    android.widget.TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    private float mLastKnownPositionOffset;
    android.widget.TextView mNextText;
    private int mNonPrimaryAlpha;
    private final android.support.v4.view.PagerTitleStrip$PageListener mPageListener;
    android.support.v4.view.ViewPager mPager;
    android.widget.TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private ref.WeakReference mWatchingAdapter;

    static PagerTitleStrip()
    {
        android.support.v4.view.PagerTitleStrip$PagerTitleStripImplBase v0_1 = new int[4];
        v0_1 = {16842804, 16842901, 16842904, 16842927};
        android.support.v4.view.PagerTitleStrip.ATTRS = v0_1;
        android.support.v4.view.PagerTitleStrip$PagerTitleStripImplBase v0_8 = new int[1];
        v0_8[0] = 16843660;
        android.support.v4.view.PagerTitleStrip.TEXT_ATTRS = v0_8;
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.view.PagerTitleStrip.IMPL = new android.support.v4.view.PagerTitleStrip$PagerTitleStripImplBase();
        } else {
            android.support.v4.view.PagerTitleStrip.IMPL = new android.support.v4.view.PagerTitleStrip$PagerTitleStripImplIcs();
        }
        return;
    }

    public PagerTitleStrip(android.content.Context p2)
    {
        this(p2, 0);
        return;
    }

    public PagerTitleStrip(android.content.Context p12, android.util.AttributeSet p13)
    {
        super(p12, p13);
        super.mLastKnownCurrentPage = -1;
        super.mLastKnownPositionOffset = -1082130432;
        super.mPageListener = new android.support.v4.view.PagerTitleStrip$PageListener(super, 0);
        int v7_4 = new android.widget.TextView(p12);
        super.mPrevText = v7_4;
        super.addView(v7_4);
        int v7_6 = new android.widget.TextView(p12);
        super.mCurrText = v7_6;
        super.addView(v7_6);
        int v7_8 = new android.widget.TextView(p12);
        super.mNextText = v7_8;
        super.addView(v7_8);
        android.content.res.TypedArray v0 = p12.obtainStyledAttributes(p13, android.support.v4.view.PagerTitleStrip.ATTRS);
        int v4 = v0.getResourceId(0, 0);
        if (v4 != 0) {
            super.mPrevText.setTextAppearance(p12, v4);
            super.mCurrText.setTextAppearance(p12, v4);
            super.mNextText.setTextAppearance(p12, v4);
        }
        int v6 = v0.getDimensionPixelSize(1, 0);
        if (v6 != 0) {
            super.setTextSize(0, ((float) v6));
        }
        if (v0.hasValue(2)) {
            int v5 = v0.getColor(2, 0);
            super.mPrevText.setTextColor(v5);
            super.mCurrText.setTextColor(v5);
            super.mNextText.setTextColor(v5);
        }
        super.mGravity = v0.getInteger(3, 80);
        v0.recycle();
        super.mTextColor = super.mCurrText.getTextColors().getDefaultColor();
        super.setNonPrimaryAlpha(1058642330);
        super.mPrevText.setEllipsize(android.text.TextUtils$TruncateAt.END);
        super.mCurrText.setEllipsize(android.text.TextUtils$TruncateAt.END);
        super.mNextText.setEllipsize(android.text.TextUtils$TruncateAt.END);
        boolean v1 = 0;
        if (v4 != 0) {
            android.content.res.TypedArray v3 = p12.obtainStyledAttributes(v4, android.support.v4.view.PagerTitleStrip.TEXT_ATTRS);
            v1 = v3.getBoolean(0, 0);
            v3.recycle();
        }
        if (!v1) {
            super.mPrevText.setSingleLine();
            super.mCurrText.setSingleLine();
            super.mNextText.setSingleLine();
        } else {
            android.support.v4.view.PagerTitleStrip.setSingleLineAllCaps(super.mPrevText);
            android.support.v4.view.PagerTitleStrip.setSingleLineAllCaps(super.mCurrText);
            android.support.v4.view.PagerTitleStrip.setSingleLineAllCaps(super.mNextText);
        }
        super.mScaledTextSpacing = ((int) (1098907648 * p12.getResources().getDisplayMetrics().density));
        return;
    }

    static synthetic float access$100(android.support.v4.view.PagerTitleStrip p1)
    {
        return p1.mLastKnownPositionOffset;
    }

    private static void setSingleLineAllCaps(android.widget.TextView p1)
    {
        android.support.v4.view.PagerTitleStrip.IMPL.setSingleLineAllCaps(p1);
        return;
    }

    int getMinHeight()
    {
        int v1 = 0;
        android.graphics.drawable.Drawable v0 = this.getBackground();
        if (v0 != null) {
            v1 = v0.getIntrinsicHeight();
        }
        return v1;
    }

    public int getTextSpacing()
    {
        return this.mScaledTextSpacing;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        android.view.ViewParent v2 = this.getParent();
        if ((v2 instanceof android.support.v4.view.ViewPager)) {
            int v3_2;
            android.support.v4.view.ViewPager v1_1 = ((android.support.v4.view.ViewPager) v2);
            android.support.v4.view.PagerAdapter v0 = v1_1.getAdapter();
            v1_1.setInternalPageChangeListener(this.mPageListener);
            v1_1.setOnAdapterChangeListener(this.mPageListener);
            this.mPager = v1_1;
            if (this.mWatchingAdapter == null) {
                v3_2 = 0;
            } else {
                v3_2 = ((android.support.v4.view.PagerAdapter) this.mWatchingAdapter.get());
            }
            this.updateAdapter(v3_2, v0);
            return;
        } else {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (this.mPager != null) {
            this.updateAdapter(this.mPager.getAdapter(), 0);
            this.mPager.setInternalPageChangeListener(0);
            this.mPager.setOnAdapterChangeListener(0);
            this.mPager = 0;
        }
        return;
    }

    protected void onLayout(boolean p4, int p5, int p6, int p7, int p8)
    {
        float v0 = 0;
        if (this.mPager != null) {
            if (this.mLastKnownPositionOffset >= 0) {
                v0 = this.mLastKnownPositionOffset;
            }
            this.updateTextPositions(this.mLastKnownCurrentPage, v0, 1);
        }
        return;
    }

    protected void onMeasure(int p13, int p14)
    {
        int v8 = android.view.View$MeasureSpec.getMode(p13);
        int v3 = android.view.View$MeasureSpec.getMode(p14);
        int v9 = android.view.View$MeasureSpec.getSize(p13);
        int v4 = android.view.View$MeasureSpec.getSize(p14);
        if (v8 == 1073741824) {
            int v0_0 = v4;
            int v5 = this.getMinHeight();
            int v6 = (this.getPaddingTop() + this.getPaddingBottom());
            int v0_1 = (v0_0 - v6);
            int v2 = android.view.View$MeasureSpec.makeMeasureSpec(((int) (((float) v9) * 1061997773)), -2147483648);
            int v1 = android.view.View$MeasureSpec.makeMeasureSpec(v0_1, -2147483648);
            this.mPrevText.measure(v2, v1);
            this.mCurrText.measure(v2, v1);
            this.mNextText.measure(v2, v1);
            if (v3 != 1073741824) {
                this.setMeasuredDimension(v9, Math.max(v5, (this.mCurrText.getMeasuredHeight() + v6)));
            } else {
                this.setMeasuredDimension(v9, v4);
            }
            return;
        } else {
            throw new IllegalStateException("Must measure with an exact width");
        }
    }

    public void requestLayout()
    {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
        return;
    }

    public void setGravity(int p1)
    {
        this.mGravity = p1;
        this.requestLayout();
        return;
    }

    public void setNonPrimaryAlpha(float p5)
    {
        this.mNonPrimaryAlpha = (((int) (1132396544 * p5)) & 255);
        int v0 = ((this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215));
        this.mPrevText.setTextColor(v0);
        this.mNextText.setTextColor(v0);
        return;
    }

    public void setTextColor(int p5)
    {
        this.mTextColor = p5;
        this.mCurrText.setTextColor(p5);
        int v0 = ((this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215));
        this.mPrevText.setTextColor(v0);
        this.mNextText.setTextColor(v0);
        return;
    }

    public void setTextSize(int p2, float p3)
    {
        this.mPrevText.setTextSize(p2, p3);
        this.mCurrText.setTextSize(p2, p3);
        this.mNextText.setTextSize(p2, p3);
        return;
    }

    public void setTextSpacing(int p1)
    {
        this.mScaledTextSpacing = p1;
        this.requestLayout();
        return;
    }

    void updateAdapter(android.support.v4.view.PagerAdapter p2, android.support.v4.view.PagerAdapter p3)
    {
        if (p2 != null) {
            p2.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = 0;
        }
        if (p3 != null) {
            p3.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new ref.WeakReference(p3);
        }
        if (this.mPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1082130432;
            this.updateText(this.mPager.getCurrentItem(), p3);
            this.requestLayout();
        }
        return;
    }

    void updateText(int p11, android.support.v4.view.PagerAdapter p12)
    {
        int v3;
        if (p12 == null) {
            v3 = 0;
        } else {
            v3 = p12.getCount();
        }
        this.mUpdatingText = 1;
        CharSequence v4_0 = 0;
        if ((p11 >= 1) && (p12 != null)) {
            v4_0 = p12.getPageTitle((p11 - 1));
        }
        float v7_3;
        this.mPrevText.setText(v4_0);
        int v8_0 = this.mCurrText;
        if ((p12 == null) || (p11 >= v3)) {
            v7_3 = 0;
        } else {
            v7_3 = p12.getPageTitle(p11);
        }
        v8_0.setText(v7_3);
        CharSequence v4_1 = 0;
        if (((p11 + 1) < v3) && (p12 != null)) {
            v4_1 = p12.getPageTitle((p11 + 1));
        }
        this.mNextText.setText(v4_1);
        int v5 = ((this.getWidth() - this.getPaddingLeft()) - this.getPaddingRight());
        int v0 = ((this.getHeight() - this.getPaddingTop()) - this.getPaddingBottom());
        int v2 = android.view.View$MeasureSpec.makeMeasureSpec(((int) (((float) v5) * 1061997773)), -2147483648);
        int v1 = android.view.View$MeasureSpec.makeMeasureSpec(v0, -2147483648);
        this.mPrevText.measure(v2, v1);
        this.mCurrText.measure(v2, v1);
        this.mNextText.measure(v2, v1);
        this.mLastKnownCurrentPage = p11;
        if (!this.mUpdatingPositions) {
            this.updateTextPositions(p11, this.mLastKnownPositionOffset, 0);
        }
        this.mUpdatingText = 0;
        return;
    }

    void updateTextPositions(int p46, float p47, boolean p48)
    {
        if (p46 == this.mLastKnownCurrentPage) {
            if ((p48) || (p47 != this.mLastKnownPositionOffset)) {
                this.mUpdatingPositions = 1;
                int v36 = this.mPrevText.getMeasuredWidth();
                int v18 = this.mCurrText.getMeasuredWidth();
                int v26 = this.mNextText.getMeasuredWidth();
                int v19 = (v18 / 2);
                int v38 = this.getWidth();
                int v37 = this.getHeight();
                int v29 = this.getPaddingLeft();
                int v30 = this.getPaddingRight();
                int v31 = this.getPaddingTop();
                int v28 = this.getPaddingBottom();
                int v40 = (v30 + v19);
                float v14 = (p47 + 1056964608);
                if (v14 > 1065353216) {
                    v14 -= 1065353216;
                }
                int v34;
                int v16;
                int v24;
                int v13 = (((v38 - v40) - ((int) (((float) ((v38 - (v29 + v19)) - v40)) * v14))) - (v18 / 2));
                int v15 = (v13 + v18);
                int v32 = this.mPrevText.getBaseline();
                int v11 = this.mCurrText.getBaseline();
                int v22 = this.mNextText.getBaseline();
                int v20 = Math.max(Math.max(v32, v11), v22);
                int v35 = (v20 - v32);
                int v17 = (v20 - v11);
                int v25 = (v20 - v22);
                int v21 = Math.max(Math.max((v35 + this.mPrevText.getMeasuredHeight()), (v17 + this.mCurrText.getMeasuredHeight())), (v25 + this.mNextText.getMeasuredHeight()));
                switch ((this.mGravity & 112)) {
                    case 16:
                        int v9 = ((((v37 - v31) - v28) - v21) / 2);
                        v34 = (v9 + v35);
                        v16 = (v9 + v17);
                        v24 = (v9 + v25);
                        break;
                    case 80:
                        int v8 = ((v37 - v28) - v21);
                        v34 = (v8 + v35);
                        v16 = (v8 + v17);
                        v24 = (v8 + v25);
                        break;
                    default:
                        v34 = (v31 + v35);
                        v16 = (v31 + v17);
                        v24 = (v31 + v25);
                }
                this.mCurrText.layout(v13, v16, v15, (this.mCurrText.getMeasuredHeight() + v16));
                int v33 = Math.min(v29, ((v13 - this.mScaledTextSpacing) - v36));
                this.mPrevText.layout(v33, v34, (v33 + v36), (this.mPrevText.getMeasuredHeight() + v34));
                int v23 = Math.max(((v38 - v30) - v26), (this.mScaledTextSpacing + v15));
                this.mNextText.layout(v23, v24, (v23 + v26), (this.mNextText.getMeasuredHeight() + v24));
                this.mLastKnownPositionOffset = p47;
                this.mUpdatingPositions = 0;
            }
        } else {
            this.updateText(p46, this.mPager.getAdapter());
        }
        return;
    }
}
