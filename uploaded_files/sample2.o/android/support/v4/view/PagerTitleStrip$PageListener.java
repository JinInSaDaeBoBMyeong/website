package android.support.v4.view;
 class PagerTitleStrip$PageListener extends android.database.DataSetObserver implements android.support.v4.view.ViewPager$OnPageChangeListener, android.support.v4.view.ViewPager$OnAdapterChangeListener {
    private int mScrollState;
    final synthetic android.support.v4.view.PagerTitleStrip this$0;

    private PagerTitleStrip$PageListener(android.support.v4.view.PagerTitleStrip p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic PagerTitleStrip$PageListener(android.support.v4.view.PagerTitleStrip p1, android.support.v4.view.PagerTitleStrip$1 p2)
    {
        this(p1);
        return;
    }

    public void onAdapterChanged(android.support.v4.view.PagerAdapter p2, android.support.v4.view.PagerAdapter p3)
    {
        this.this$0.updateAdapter(p2, p3);
        return;
    }

    public void onChanged()
    {
        float v0 = 0;
        this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
        if (android.support.v4.view.PagerTitleStrip.access$100(this.this$0) >= 0) {
            v0 = android.support.v4.view.PagerTitleStrip.access$100(this.this$0);
        }
        this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), v0, 1);
        return;
    }

    public void onPageScrollStateChanged(int p1)
    {
        this.mScrollState = p1;
        return;
    }

    public void onPageScrolled(int p3, float p4, int p5)
    {
        if (p4 > 1056964608) {
            p3++;
        }
        this.this$0.updateTextPositions(p3, p4, 0);
        return;
    }

    public void onPageSelected(int p5)
    {
        float v0 = 0;
        if (this.mScrollState == 0) {
            this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            if (android.support.v4.view.PagerTitleStrip.access$100(this.this$0) >= 0) {
                v0 = android.support.v4.view.PagerTitleStrip.access$100(this.this$0);
            }
            this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), v0, 1);
        }
        return;
    }
}
