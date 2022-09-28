package android.support.v4.view;
 class ViewPager$ViewPositionComparator implements java.util.Comparator {

    ViewPager$ViewPositionComparator()
    {
        return;
    }

    public int compare(android.view.View p5, android.view.View p6)
    {
        int v2_0;
        android.support.v4.view.ViewPager$LayoutParams v0_1 = ((android.support.v4.view.ViewPager$LayoutParams) p5.getLayoutParams());
        android.support.v4.view.ViewPager$LayoutParams v1_1 = ((android.support.v4.view.ViewPager$LayoutParams) p6.getLayoutParams());
        if (v0_1.isDecor == v1_1.isDecor) {
            v2_0 = (v0_1.position - v1_1.position);
        } else {
            if (!v0_1.isDecor) {
                v2_0 = -1;
            } else {
                v2_0 = 1;
            }
        }
        return v2_0;
    }

    public bridge synthetic int compare(Object p2, Object p3)
    {
        return this.compare(((android.view.View) p2), ((android.view.View) p3));
    }
}
