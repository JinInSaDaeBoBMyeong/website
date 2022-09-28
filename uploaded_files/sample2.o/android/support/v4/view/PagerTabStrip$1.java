package android.support.v4.view;
 class PagerTabStrip$1 implements android.view.View$OnClickListener {
    final synthetic android.support.v4.view.PagerTabStrip this$0;

    PagerTabStrip$1(android.support.v4.view.PagerTabStrip p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.view.View p3)
    {
        this.this$0.mPager.setCurrentItem((this.this$0.mPager.getCurrentItem() - 1));
        return;
    }
}
