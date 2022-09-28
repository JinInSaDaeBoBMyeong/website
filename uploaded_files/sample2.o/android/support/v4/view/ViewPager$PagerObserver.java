package android.support.v4.view;
 class ViewPager$PagerObserver extends android.database.DataSetObserver {
    final synthetic android.support.v4.view.ViewPager this$0;

    private ViewPager$PagerObserver(android.support.v4.view.ViewPager p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic ViewPager$PagerObserver(android.support.v4.view.ViewPager p1, android.support.v4.view.ViewPager$1 p2)
    {
        this(p1);
        return;
    }

    public void onChanged()
    {
        this.this$0.dataSetChanged();
        return;
    }

    public void onInvalidated()
    {
        this.this$0.dataSetChanged();
        return;
    }
}
