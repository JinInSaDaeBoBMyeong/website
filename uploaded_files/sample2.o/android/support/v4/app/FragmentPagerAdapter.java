package android.support.v4.app;
public abstract class FragmentPagerAdapter extends android.support.v4.view.PagerAdapter {
    private static final boolean DEBUG = False;
    private static final String TAG = "FragmentPagerAdapter";
    private android.support.v4.app.FragmentTransaction mCurTransaction;
    private android.support.v4.app.Fragment mCurrentPrimaryItem;
    private final android.support.v4.app.FragmentManager mFragmentManager;

    public FragmentPagerAdapter(android.support.v4.app.FragmentManager p2)
    {
        this.mCurTransaction = 0;
        this.mCurrentPrimaryItem = 0;
        this.mFragmentManager = p2;
        return;
    }

    private static String makeFragmentName(int p3, long p4)
    {
        return new StringBuilder().append("android:switcher:").append(p3).append(":").append(p4).toString();
    }

    public void destroyItem(android.view.ViewGroup p2, int p3, Object p4)
    {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.detach(((android.support.v4.app.Fragment) p4));
        return;
    }

    public void finishUpdate(android.view.ViewGroup p2)
    {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.commitAllowingStateLoss();
            this.mCurTransaction = 0;
            this.mFragmentManager.executePendingTransactions();
        }
        return;
    }

    public abstract android.support.v4.app.Fragment getItem();

    public long getItemId(int p3)
    {
        return ((long) p3);
    }

    public Object instantiateItem(android.view.ViewGroup p9, int p10)
    {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        long v2 = this.getItemId(p10);
        android.support.v4.app.Fragment v0 = this.mFragmentManager.findFragmentByTag(android.support.v4.app.FragmentPagerAdapter.makeFragmentName(p9.getId(), v2));
        if (v0 == null) {
            v0 = this.getItem(p10);
            this.mCurTransaction.add(p9.getId(), v0, android.support.v4.app.FragmentPagerAdapter.makeFragmentName(p9.getId(), v2));
        } else {
            this.mCurTransaction.attach(v0);
        }
        if (v0 != this.mCurrentPrimaryItem) {
            v0.setMenuVisibility(0);
            v0.setUserVisibleHint(0);
        }
        return v0;
    }

    public boolean isViewFromObject(android.view.View p2, Object p3)
    {
        int v0_1;
        if (((android.support.v4.app.Fragment) p3).getView() != p2) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public void restoreState(android.os.Parcelable p1, ClassLoader p2)
    {
        return;
    }

    public android.os.Parcelable saveState()
    {
        return 0;
    }

    public void setPrimaryItem(android.view.ViewGroup p5, int p6, Object p7)
    {
        if (((android.support.v4.app.Fragment) p7) != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(0);
                this.mCurrentPrimaryItem.setUserVisibleHint(0);
            }
            if (((android.support.v4.app.Fragment) p7) != null) {
                ((android.support.v4.app.Fragment) p7).setMenuVisibility(1);
                ((android.support.v4.app.Fragment) p7).setUserVisibleHint(1);
            }
            this.mCurrentPrimaryItem = ((android.support.v4.app.Fragment) p7);
        }
        return;
    }

    public void startUpdate(android.view.ViewGroup p1)
    {
        return;
    }
}
