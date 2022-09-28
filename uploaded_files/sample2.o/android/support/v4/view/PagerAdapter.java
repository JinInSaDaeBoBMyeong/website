package android.support.v4.view;
public abstract class PagerAdapter {
    public static final int POSITION_NONE = 254;
    public static final int POSITION_UNCHANGED = 255;
    private android.database.DataSetObservable mObservable;

    public PagerAdapter()
    {
        this.mObservable = new android.database.DataSetObservable();
        return;
    }

    public void destroyItem(android.view.View p3, int p4, Object p5)
    {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void destroyItem(android.view.ViewGroup p1, int p2, Object p3)
    {
        this.destroyItem(p1, p2, p3);
        return;
    }

    public void finishUpdate(android.view.View p1)
    {
        return;
    }

    public void finishUpdate(android.view.ViewGroup p1)
    {
        this.finishUpdate(p1);
        return;
    }

    public abstract int getCount();

    public int getItemPosition(Object p2)
    {
        return -1;
    }

    public CharSequence getPageTitle(int p2)
    {
        return 0;
    }

    public float getPageWidth(int p2)
    {
        return 1065353216;
    }

    public Object instantiateItem(android.view.View p3, int p4)
    {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object instantiateItem(android.view.ViewGroup p2, int p3)
    {
        return this.instantiateItem(p2, p3);
    }

    public abstract boolean isViewFromObject();

    public void notifyDataSetChanged()
    {
        this.mObservable.notifyChanged();
        return;
    }

    public void registerDataSetObserver(android.database.DataSetObserver p2)
    {
        this.mObservable.registerObserver(p2);
        return;
    }

    public void restoreState(android.os.Parcelable p1, ClassLoader p2)
    {
        return;
    }

    public android.os.Parcelable saveState()
    {
        return 0;
    }

    public void setPrimaryItem(android.view.View p1, int p2, Object p3)
    {
        return;
    }

    public void setPrimaryItem(android.view.ViewGroup p1, int p2, Object p3)
    {
        this.setPrimaryItem(p1, p2, p3);
        return;
    }

    public void startUpdate(android.view.View p1)
    {
        return;
    }

    public void startUpdate(android.view.ViewGroup p1)
    {
        this.startUpdate(p1);
        return;
    }

    public void unregisterDataSetObserver(android.database.DataSetObserver p2)
    {
        this.mObservable.unregisterObserver(p2);
        return;
    }
}
