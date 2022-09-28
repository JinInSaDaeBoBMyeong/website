package android.support.v4.app;
public abstract class FragmentStatePagerAdapter extends android.support.v4.view.PagerAdapter {
    private static final boolean DEBUG = False;
    private static final String TAG = "FragmentStatePagerAdapter";
    private android.support.v4.app.FragmentTransaction mCurTransaction;
    private android.support.v4.app.Fragment mCurrentPrimaryItem;
    private final android.support.v4.app.FragmentManager mFragmentManager;
    private java.util.ArrayList mFragments;
    private java.util.ArrayList mSavedState;

    public FragmentStatePagerAdapter(android.support.v4.app.FragmentManager p3)
    {
        this.mCurTransaction = 0;
        this.mSavedState = new java.util.ArrayList();
        this.mFragments = new java.util.ArrayList();
        this.mCurrentPrimaryItem = 0;
        this.mFragmentManager = p3;
        return;
    }

    public void destroyItem(android.view.ViewGroup p5, int p6, Object p7)
    {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= p6) {
            this.mSavedState.add(0);
        }
        this.mSavedState.set(p6, this.mFragmentManager.saveFragmentInstanceState(((android.support.v4.app.Fragment) p7)));
        this.mFragments.set(p6, 0);
        this.mCurTransaction.remove(((android.support.v4.app.Fragment) p7));
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

    public Object instantiateItem(android.view.ViewGroup p7, int p8)
    {
        android.support.v4.app.Fragment v0_0;
        if (this.mFragments.size() <= p8) {
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }
            android.support.v4.app.Fragment v1 = this.getItem(p8);
            if (this.mSavedState.size() > p8) {
                android.support.v4.app.Fragment$SavedState v2_1 = ((android.support.v4.app.Fragment$SavedState) this.mSavedState.get(p8));
                if (v2_1 != null) {
                    v1.setInitialSavedState(v2_1);
                }
            }
            while (this.mFragments.size() <= p8) {
                this.mFragments.add(0);
            }
            v1.setMenuVisibility(0);
            v1.setUserVisibleHint(0);
            this.mFragments.set(p8, v1);
            this.mCurTransaction.add(p7.getId(), v1);
            v0_0 = v1;
        } else {
            v0_0 = ((android.support.v4.app.Fragment) this.mFragments.get(p8));
            if (v0_0 == null) {
            }
        }
        return v0_0;
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

    public void restoreState(android.os.Parcelable p12, ClassLoader p13)
    {
        if (p12 != null) {
            ((android.os.Bundle) p12).setClassLoader(p13);
            android.os.Parcelable[] v2 = ((android.os.Bundle) p12).getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (v2 != null) {
                int v3 = 0;
                while (v3 < v2.length) {
                    this.mSavedState.add(((android.support.v4.app.Fragment$SavedState) v2[v3]));
                    v3++;
                }
            }
            java.util.Iterator v4 = ((android.os.Bundle) p12).keySet().iterator();
            while (v4.hasNext()) {
                String v6_1 = ((String) v4.next());
                if (v6_1.startsWith("f")) {
                    int v5 = Integer.parseInt(v6_1.substring(1));
                    android.support.v4.app.Fragment v1 = this.mFragmentManager.getFragment(((android.os.Bundle) p12), v6_1);
                    if (v1 == null) {
                        android.util.Log.w("FragmentStatePagerAdapter", new StringBuilder().append("Bad fragment at key ").append(v6_1).toString());
                    }
                    while (this.mFragments.size() <= v5) {
                        this.mFragments.add(0);
                    }
                    v1.setMenuVisibility(0);
                    this.mFragments.set(v5, v1);
                }
            }
        }
        return;
    }

    public android.os.Parcelable saveState()
    {
        android.os.Bundle v4_0 = 0;
        if (this.mSavedState.size() > 0) {
            v4_0 = new android.os.Bundle();
            android.support.v4.app.Fragment$SavedState[] v1 = new android.support.v4.app.Fragment$SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(v1);
            v4_0.putParcelableArray("states", v1);
        }
        int v2 = 0;
        while (v2 < this.mFragments.size()) {
            android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mFragments.get(v2));
            if (v0_1 != null) {
                if (v4_0 == null) {
                    v4_0 = new android.os.Bundle();
                }
                this.mFragmentManager.putFragment(v4_0, new StringBuilder().append("f").append(v2).toString(), v0_1);
            }
            v2++;
        }
        return v4_0;
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
