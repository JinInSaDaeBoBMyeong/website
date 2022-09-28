package android.support.v4.view;
final class ViewPager$1 implements java.util.Comparator {

    ViewPager$1()
    {
        return;
    }

    public int compare(android.support.v4.view.ViewPager$ItemInfo p3, android.support.v4.view.ViewPager$ItemInfo p4)
    {
        return (p3.position - p4.position);
    }

    public bridge synthetic int compare(Object p2, Object p3)
    {
        return this.compare(((android.support.v4.view.ViewPager$ItemInfo) p2), ((android.support.v4.view.ViewPager$ItemInfo) p3));
    }
}
