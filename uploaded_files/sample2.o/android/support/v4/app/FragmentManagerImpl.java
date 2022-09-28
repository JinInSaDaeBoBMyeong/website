package android.support.v4.app;
final class FragmentManagerImpl extends android.support.v4.app.FragmentManager {
    static final android.view.animation.Interpolator ACCELERATE_CUBIC = None;
    static final android.view.animation.Interpolator ACCELERATE_QUINT = None;
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = False;
    static final android.view.animation.Interpolator DECELERATE_CUBIC = None;
    static final android.view.animation.Interpolator DECELERATE_QUINT = None;
    static final boolean HONEYCOMB = False;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    java.util.ArrayList mActive;
    android.support.v4.app.FragmentActivity mActivity;
    java.util.ArrayList mAdded;
    java.util.ArrayList mAvailBackStackIndices;
    java.util.ArrayList mAvailIndices;
    java.util.ArrayList mBackStack;
    java.util.ArrayList mBackStackChangeListeners;
    java.util.ArrayList mBackStackIndices;
    android.support.v4.app.FragmentContainer mContainer;
    java.util.ArrayList mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    android.support.v4.app.Fragment mParent;
    java.util.ArrayList mPendingActions;
    android.util.SparseArray mStateArray;
    android.os.Bundle mStateBundle;
    boolean mStateSaved;
    Runnable[] mTmpActions;

    static FragmentManagerImpl()
    {
        android.view.animation.AccelerateInterpolator v0_0 = 0;
        android.support.v4.app.FragmentManagerImpl.DEBUG = 0;
        if (android.os.Build$VERSION.SDK_INT >= 11) {
            v0_0 = 1;
        }
        android.support.v4.app.FragmentManagerImpl.HONEYCOMB = v0_0;
        android.support.v4.app.FragmentManagerImpl.DECELERATE_QUINT = new android.view.animation.DecelerateInterpolator(1075838976);
        android.support.v4.app.FragmentManagerImpl.DECELERATE_CUBIC = new android.view.animation.DecelerateInterpolator(1069547520);
        android.support.v4.app.FragmentManagerImpl.ACCELERATE_QUINT = new android.view.animation.AccelerateInterpolator(1075838976);
        android.support.v4.app.FragmentManagerImpl.ACCELERATE_CUBIC = new android.view.animation.AccelerateInterpolator(1069547520);
        return;
    }

    FragmentManagerImpl()
    {
        this.mCurState = 0;
        this.mStateBundle = 0;
        this.mStateArray = 0;
        this.mExecCommit = new android.support.v4.app.FragmentManagerImpl$1(this);
        return;
    }

    private void checkStateLoss()
    {
        if (!this.mStateSaved) {
            if (this.mNoTransactionsBecause == null) {
                return;
            } else {
                throw new IllegalStateException(new StringBuilder().append("Can not perform this action inside of ").append(this.mNoTransactionsBecause).toString());
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    static android.view.animation.Animation makeFadeAnimation(android.content.Context p4, float p5, float p6)
    {
        android.view.animation.AlphaAnimation v0_1 = new android.view.animation.AlphaAnimation(p5, p6);
        v0_1.setInterpolator(android.support.v4.app.FragmentManagerImpl.DECELERATE_CUBIC);
        v0_1.setDuration(220);
        return v0_1;
    }

    static android.view.animation.Animation makeOpenCloseAnimation(android.content.Context p11, float p12, float p13, float p14, float p15)
    {
        android.view.animation.AnimationSet v10_1 = new android.view.animation.AnimationSet(0);
        android.view.animation.ScaleAnimation v0_0 = new android.view.animation.ScaleAnimation(p12, p13, p12, p13, 1, 1056964608, 1, 1056964608);
        v0_0.setInterpolator(android.support.v4.app.FragmentManagerImpl.DECELERATE_QUINT);
        v0_0.setDuration(220);
        v10_1.addAnimation(v0_0);
        android.view.animation.AlphaAnimation v9_1 = new android.view.animation.AlphaAnimation(p14, p15);
        v9_1.setInterpolator(android.support.v4.app.FragmentManagerImpl.DECELERATE_CUBIC);
        v9_1.setDuration(220);
        v10_1.addAnimation(v9_1);
        return v10_1;
    }

    public static int reverseTransit(int p1)
    {
        int v0 = 0;
        switch (p1) {
            case 4097:
                v0 = 8194;
                break;
            case 4099:
                v0 = 4099;
                break;
            case 8194:
                v0 = 4097;
                break;
        }
        return v0;
    }

    private void throwException(RuntimeException p8)
    {
        android.util.Log.e("FragmentManager", p8.getMessage());
        android.util.Log.e("FragmentManager", "Activity state:");
        java.io.PrintWriter v2_1 = new java.io.PrintWriter(new android.support.v4.util.LogWriter("FragmentManager"));
        if (this.mActivity == null) {
            try {
                String[] v5_1 = new String[0];
                this.dump("  ", 0, v2_1, v5_1);
            } catch (Exception v0_0) {
                android.util.Log.e("FragmentManager", "Failed dumping state", v0_0);
            }
        } else {
            try {
                String[] v6_1 = new String[0];
                this.mActivity.dump("  ", 0, v2_1, v6_1);
            } catch (Exception v0_1) {
                android.util.Log.e("FragmentManager", "Failed dumping state", v0_1);
            }
        }
        throw p8;
    }

    public static int transitToStyleIndex(int p1, boolean p2)
    {
        int v0 = -1;
        switch (p1) {
            case 4097:
                if (!p2) {
                    v0 = 2;
                } else {
                    v0 = 1;
                }
                break;
            case 4099:
                if (!p2) {
                    v0 = 6;
                } else {
                    v0 = 5;
                }
                break;
            case 8194:
                if (!p2) {
                    v0 = 4;
                } else {
                    v0 = 3;
                }
                break;
        }
        return v0;
    }

    void addBackStackState(android.support.v4.app.BackStackRecord p2)
    {
        if (this.mBackStack == null) {
            this.mBackStack = new java.util.ArrayList();
        }
        this.mBackStack.add(p2);
        this.reportBackStackChanged();
        return;
    }

    public void addFragment(android.support.v4.app.Fragment p5, boolean p6)
    {
        if (this.mAdded == null) {
            this.mAdded = new java.util.ArrayList();
        }
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("add: ").append(p5).toString());
        }
        this.makeActive(p5);
        if (!p5.mDetached) {
            if (!this.mAdded.contains(p5)) {
                this.mAdded.add(p5);
                p5.mAdded = 1;
                p5.mRemoving = 0;
                if ((p5.mHasMenu) && (p5.mMenuVisible)) {
                    this.mNeedMenuInvalidate = 1;
                }
                if (p6) {
                    this.moveToState(p5);
                }
            } else {
                throw new IllegalStateException(new StringBuilder().append("Fragment already added: ").append(p5).toString());
            }
        }
        return;
    }

    public void addOnBackStackChangedListener(android.support.v4.app.FragmentManager$OnBackStackChangedListener p2)
    {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new java.util.ArrayList();
        }
        this.mBackStackChangeListeners.add(p2);
        return;
    }

    public int allocBackStackIndex(android.support.v4.app.BackStackRecord p6)
    {
        try {
            if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0)) {
                int v0_0 = ((Integer) this.mAvailBackStackIndices.remove((this.mAvailBackStackIndices.size() - 1))).intValue();
                if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                    android.util.Log.v("FragmentManager", new StringBuilder().append("Adding back stack index ").append(v0_0).append(" with ").append(p6).toString());
                }
                this.mBackStackIndices.set(v0_0, p6);
                int v1 = v0_0;
            } else {
                if (this.mBackStackIndices == null) {
                    this.mBackStackIndices = new java.util.ArrayList();
                }
                int v0_1 = this.mBackStackIndices.size();
                if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                    android.util.Log.v("FragmentManager", new StringBuilder().append("Setting back stack index ").append(v0_1).append(" to ").append(p6).toString());
                }
                this.mBackStackIndices.add(p6);
                v1 = v0_1;
            }
        } catch (java.util.ArrayList v2_16) {
            throw v2_16;
        }
        return v1;
    }

    public void attachActivity(android.support.v4.app.FragmentActivity p3, android.support.v4.app.FragmentContainer p4, android.support.v4.app.Fragment p5)
    {
        if (this.mActivity == null) {
            this.mActivity = p3;
            this.mContainer = p4;
            this.mParent = p5;
            return;
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void attachFragment(android.support.v4.app.Fragment p7, int p8, int p9)
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("attach: ").append(p7).toString());
        }
        if (p7.mDetached) {
            p7.mDetached = 0;
            if (!p7.mAdded) {
                if (this.mAdded == null) {
                    this.mAdded = new java.util.ArrayList();
                }
                if (!this.mAdded.contains(p7)) {
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("add from attach: ").append(p7).toString());
                    }
                    this.mAdded.add(p7);
                    p7.mAdded = 1;
                    if ((p7.mHasMenu) && (p7.mMenuVisible)) {
                        this.mNeedMenuInvalidate = 1;
                    }
                    this.moveToState(p7, this.mCurState, p8, p9, 0);
                } else {
                    throw new IllegalStateException(new StringBuilder().append("Fragment already added: ").append(p7).toString());
                }
            }
        }
        return;
    }

    public android.support.v4.app.FragmentTransaction beginTransaction()
    {
        return new android.support.v4.app.BackStackRecord(this);
    }

    public void detachFragment(android.support.v4.app.Fragment p7, int p8, int p9)
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("detach: ").append(p7).toString());
        }
        if (!p7.mDetached) {
            p7.mDetached = 1;
            if (p7.mAdded) {
                if (this.mAdded != null) {
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("remove from detach: ").append(p7).toString());
                    }
                    this.mAdded.remove(p7);
                }
                if ((p7.mHasMenu) && (p7.mMenuVisible)) {
                    this.mNeedMenuInvalidate = 1;
                }
                p7.mAdded = 0;
                this.moveToState(p7, 1, p8, p9, 0);
            }
        }
        return;
    }

    public void dispatchActivityCreated()
    {
        this.mStateSaved = 0;
        this.moveToState(2, 0);
        return;
    }

    public void dispatchConfigurationChanged(android.content.res.Configuration p4)
    {
        if (this.mAdded != null) {
            int v1 = 0;
            while (v1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mAdded.get(v1));
                if (v0_1 != null) {
                    v0_1.performConfigurationChanged(p4);
                }
                v1++;
            }
        }
        return;
    }

    public boolean dispatchContextItemSelected(android.view.MenuItem p4)
    {
        int v2_2;
        if (this.mAdded == null) {
            v2_2 = 0;
        } else {
            int v1 = 0;
            while (v1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mAdded.get(v1));
                if ((v0_1 == null) || (!v0_1.performContextItemSelected(p4))) {
                    v1++;
                } else {
                    v2_2 = 1;
                }
            }
        }
        return v2_2;
    }

    public void dispatchCreate()
    {
        this.mStateSaved = 0;
        this.moveToState(1, 0);
        return;
    }

    public boolean dispatchCreateOptionsMenu(android.view.Menu p6, android.view.MenuInflater p7)
    {
        int v3 = 0;
        java.util.ArrayList v2_0 = 0;
        if (this.mAdded != null) {
            int v1_1 = 0;
            while (v1_1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_3 = ((android.support.v4.app.Fragment) this.mAdded.get(v1_1));
                if ((v0_3 != null) && (v0_3.performCreateOptionsMenu(p6, p7))) {
                    v3 = 1;
                    if (v2_0 == null) {
                        v2_0 = new java.util.ArrayList();
                    }
                    v2_0.add(v0_3);
                }
                v1_1++;
            }
        }
        if (this.mCreatedMenus != null) {
            int v1_0 = 0;
            while (v1_0 < this.mCreatedMenus.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mCreatedMenus.get(v1_0));
                if ((v2_0 == null) || (!v2_0.contains(v0_1))) {
                    v0_1.onDestroyOptionsMenu();
                }
                v1_0++;
            }
        }
        this.mCreatedMenus = v2_0;
        return v3;
    }

    public void dispatchDestroy()
    {
        this.mDestroyed = 1;
        this.execPendingActions();
        this.moveToState(0, 0);
        this.mActivity = 0;
        this.mContainer = 0;
        this.mParent = 0;
        return;
    }

    public void dispatchDestroyView()
    {
        this.moveToState(1, 0);
        return;
    }

    public void dispatchLowMemory()
    {
        if (this.mAdded != null) {
            int v1 = 0;
            while (v1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mAdded.get(v1));
                if (v0_1 != null) {
                    v0_1.performLowMemory();
                }
                v1++;
            }
        }
        return;
    }

    public boolean dispatchOptionsItemSelected(android.view.MenuItem p4)
    {
        int v2_2;
        if (this.mAdded == null) {
            v2_2 = 0;
        } else {
            int v1 = 0;
            while (v1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mAdded.get(v1));
                if ((v0_1 == null) || (!v0_1.performOptionsItemSelected(p4))) {
                    v1++;
                } else {
                    v2_2 = 1;
                }
            }
        }
        return v2_2;
    }

    public void dispatchOptionsMenuClosed(android.view.Menu p4)
    {
        if (this.mAdded != null) {
            int v1 = 0;
            while (v1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mAdded.get(v1));
                if (v0_1 != null) {
                    v0_1.performOptionsMenuClosed(p4);
                }
                v1++;
            }
        }
        return;
    }

    public void dispatchPause()
    {
        this.moveToState(4, 0);
        return;
    }

    public boolean dispatchPrepareOptionsMenu(android.view.Menu p5)
    {
        int v2 = 0;
        if (this.mAdded != null) {
            int v1 = 0;
            while (v1 < this.mAdded.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mAdded.get(v1));
                if ((v0_1 != null) && (v0_1.performPrepareOptionsMenu(p5))) {
                    v2 = 1;
                }
                v1++;
            }
        }
        return v2;
    }

    public void dispatchReallyStop()
    {
        this.moveToState(2, 0);
        return;
    }

    public void dispatchResume()
    {
        this.mStateSaved = 0;
        this.moveToState(5, 0);
        return;
    }

    public void dispatchStart()
    {
        this.mStateSaved = 0;
        this.moveToState(4, 0);
        return;
    }

    public void dispatchStop()
    {
        this.mStateSaved = 1;
        this.moveToState(3, 0);
        return;
    }

    public void dump(String p9, java.io.FileDescriptor p10, java.io.PrintWriter p11, String[] p12)
    {
        String v4 = new StringBuilder().append(p9).append("    ").toString();
        if (this.mActive != null) {
            int v0_0 = this.mActive.size();
            if (v0_0 > 0) {
                p11.print(p9);
                p11.print("Active Fragments in ");
                p11.print(Integer.toHexString(System.identityHashCode(this)));
                p11.println(":");
                int v3_5 = 0;
                while (v3_5 < v0_0) {
                    android.support.v4.app.Fragment v2_5 = ((android.support.v4.app.Fragment) this.mActive.get(v3_5));
                    p11.print(p9);
                    p11.print("  #");
                    p11.print(v3_5);
                    p11.print(": ");
                    p11.println(v2_5);
                    if (v2_5 != null) {
                        v2_5.dump(v4, p10, p11, p12);
                    }
                    v3_5++;
                }
            }
        }
        if (this.mAdded != null) {
            int v0_1 = this.mAdded.size();
            if (v0_1 > 0) {
                p11.print(p9);
                p11.println("Added Fragments:");
                int v3_4 = 0;
                while (v3_4 < v0_1) {
                    android.support.v4.app.Fragment v2_3 = ((android.support.v4.app.Fragment) this.mAdded.get(v3_4));
                    p11.print(p9);
                    p11.print("  #");
                    p11.print(v3_4);
                    p11.print(": ");
                    p11.println(v2_3.toString());
                    v3_4++;
                }
            }
        }
        if (this.mCreatedMenus != null) {
            int v0_2 = this.mCreatedMenus.size();
            if (v0_2 > 0) {
                p11.print(p9);
                p11.println("Fragments Created Menus:");
                int v3_3 = 0;
                while (v3_3 < v0_2) {
                    android.support.v4.app.Fragment v2_1 = ((android.support.v4.app.Fragment) this.mCreatedMenus.get(v3_3));
                    p11.print(p9);
                    p11.print("  #");
                    p11.print(v3_3);
                    p11.print(": ");
                    p11.println(v2_1.toString());
                    v3_3++;
                }
            }
        }
        if (this.mBackStack != null) {
            int v0_3 = this.mBackStack.size();
            if (v0_3 > 0) {
                p11.print(p9);
                p11.println("Back Stack:");
                int v3_2 = 0;
                while (v3_2 < v0_3) {
                    android.support.v4.app.BackStackRecord v1_3 = ((android.support.v4.app.BackStackRecord) this.mBackStack.get(v3_2));
                    p11.print(p9);
                    p11.print("  #");
                    p11.print(v3_2);
                    p11.print(": ");
                    p11.println(v1_3.toString());
                    v1_3.dump(v4, p10, p11, p12);
                    v3_2++;
                }
            }
        }
        if (this.mBackStackIndices != null) {
            int v0_4 = this.mBackStackIndices.size();
            if (v0_4 > 0) {
                p11.print(p9);
                p11.println("Back Stack Indices:");
                int v3_1 = 0;
                while (v3_1 < v0_4) {
                    android.support.v4.app.BackStackRecord v1_1 = ((android.support.v4.app.BackStackRecord) this.mBackStackIndices.get(v3_1));
                    p11.print(p9);
                    p11.print("  #");
                    p11.print(v3_1);
                    p11.print(": ");
                    p11.println(v1_1);
                    v3_1++;
                }
            }
        }
        if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0)) {
            p11.print(p9);
            p11.print("mAvailBackStackIndices: ");
            p11.println(java.util.Arrays.toString(this.mAvailBackStackIndices.toArray()));
        }
        if (this.mPendingActions != null) {
            int v0_5 = this.mPendingActions.size();
            if (v0_5 > 0) {
                p11.print(p9);
                p11.println("Pending Actions:");
                int v3_0 = 0;
                while (v3_0 < v0_5) {
                    Runnable v5_1 = ((Runnable) this.mPendingActions.get(v3_0));
                    p11.print(p9);
                    p11.print("  #");
                    p11.print(v3_0);
                    p11.print(": ");
                    p11.println(v5_1);
                    v3_0++;
                }
            }
        }
        p11.print(p9);
        p11.println("FragmentManager misc state:");
        p11.print(p9);
        p11.print("  mActivity=");
        p11.println(this.mActivity);
        p11.print(p9);
        p11.print("  mContainer=");
        p11.println(this.mContainer);
        if (this.mParent != null) {
            p11.print(p9);
            p11.print("  mParent=");
            p11.println(this.mParent);
        }
        p11.print(p9);
        p11.print("  mCurState=");
        p11.print(this.mCurState);
        p11.print(" mStateSaved=");
        p11.print(this.mStateSaved);
        p11.print(" mDestroyed=");
        p11.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            p11.print(p9);
            p11.print("  mNeedMenuInvalidate=");
            p11.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            p11.print(p9);
            p11.print("  mNoTransactionsBecause=");
            p11.println(this.mNoTransactionsBecause);
        }
        if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0)) {
            p11.print(p9);
            p11.print("  mAvailIndices: ");
            p11.println(java.util.Arrays.toString(this.mAvailIndices.toArray()));
        }
        return;
    }

    public void enqueueAction(Runnable p3, boolean p4)
    {
        if (!p4) {
            this.checkStateLoss();
        }
        try {
            if ((!this.mDestroyed) && (this.mActivity != null)) {
                if (this.mPendingActions == null) {
                    this.mPendingActions = new java.util.ArrayList();
                }
                this.mPendingActions.add(p3);
                if (this.mPendingActions.size() == 1) {
                    this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
                    this.mActivity.mHandler.post(this.mExecCommit);
                }
                return;
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        } catch (android.os.Handler v0_10) {
            throw v0_10;
        }
    }

    public boolean execPendingActions()
    {
        if (!this.mExecutingActions) {
            if (android.os.Looper.myLooper() == this.mActivity.mHandler.getLooper()) {
                int v0 = 0;
                while ((this.mPendingActions != null) && (this.mPendingActions.size() != 0)) {
                    int v4 = this.mPendingActions.size();
                    if ((this.mTmpActions == null) || (this.mTmpActions.length < v4)) {
                        boolean v5_8 = new Runnable[v4];
                        this.mTmpActions = v5_8;
                    }
                    this.mPendingActions.toArray(this.mTmpActions);
                    this.mPendingActions.clear();
                    this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
                    this.mExecutingActions = 1;
                    int v2_0 = 0;
                    while (v2_0 < v4) {
                        this.mTmpActions[v2_0].run();
                        this.mTmpActions[v2_0] = 0;
                        v2_0++;
                    }
                    this.mExecutingActions = 0;
                    v0 = 1;
                }
                if (this.mHavePendingDeferredStart) {
                    int v3 = 0;
                    int v2_1 = 0;
                    while (v2_1 < this.mActive.size()) {
                        android.support.v4.app.Fragment v1_1 = ((android.support.v4.app.Fragment) this.mActive.get(v2_1));
                        if ((v1_1 != null) && (v1_1.mLoaderManager != null)) {
                            v3 |= v1_1.mLoaderManager.hasRunningLoaders();
                        }
                        v2_1++;
                    }
                    if (v3 == 0) {
                        this.mHavePendingDeferredStart = 0;
                        this.startPendingDeferredFragments();
                    }
                }
                return v0;
            } else {
                throw new IllegalStateException("Must be called from main thread of process");
            }
        } else {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
    }

    public boolean executePendingTransactions()
    {
        return this.execPendingActions();
    }

    public android.support.v4.app.Fragment findFragmentById(int p4)
    {
        android.support.v4.app.Fragment v0_0;
        if (this.mAdded == null) {
            if (this.mActive != null) {
                int v1_0 = (this.mActive.size() - 1);
                while (v1_0 >= 0) {
                    v0_0 = ((android.support.v4.app.Fragment) this.mActive.get(v1_0));
                    if ((v0_0 != null) && (v0_0.mFragmentId == p4)) {
                        return v0_0;
                    } else {
                        v1_0--;
                    }
                }
            }
            v0_0 = 0;
        } else {
            int v1_1 = (this.mAdded.size() - 1);
            while (v1_1 >= 0) {
                v0_0 = ((android.support.v4.app.Fragment) this.mAdded.get(v1_1));
                if ((v0_0 == null) || (v0_0.mFragmentId != p4)) {
                    v1_1--;
                }
            }
        }
        return v0_0;
    }

    public android.support.v4.app.Fragment findFragmentByTag(String p4)
    {
        if ((this.mAdded == null) || (p4 == null)) {
            if ((this.mActive != null) && (p4 != null)) {
                int v1_0 = (this.mActive.size() - 1);
                while (v1_0 >= 0) {
                    android.support.v4.app.Fragment v0_0 = ((android.support.v4.app.Fragment) this.mActive.get(v1_0));
                    if ((v0_0 != null) && (p4.equals(v0_0.mTag))) {
                        return v0_0;
                    } else {
                        v1_0--;
                    }
                }
            }
            v0_0 = 0;
        } else {
            int v1_1 = (this.mAdded.size() - 1);
            while (v1_1 >= 0) {
                v0_0 = ((android.support.v4.app.Fragment) this.mAdded.get(v1_1));
                if ((v0_0 == null) || (!p4.equals(v0_0.mTag))) {
                    v1_1--;
                }
            }
        }
        return v0_0;
    }

    public android.support.v4.app.Fragment findFragmentByWho(String p4)
    {
        if ((this.mActive == null) || (p4 == null)) {
            android.support.v4.app.Fragment v0_2 = 0;
        } else {
            int v1 = (this.mActive.size() - 1);
            while (v1 >= 0) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mActive.get(v1));
                if (v0_1 != null) {
                    v0_2 = v0_1.findFragmentByWho(p4);
                    if (v0_2 != null) {
                        return v0_2;
                    }
                }
                v1--;
            }
        }
        return v0_2;
    }

    public void freeBackStackIndex(int p4)
    {
        try {
            this.mBackStackIndices.set(p4, 0);
        } catch (java.util.ArrayList v0_3) {
            throw v0_3;
        }
        if (this.mAvailBackStackIndices == null) {
            this.mAvailBackStackIndices = new java.util.ArrayList();
        }
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("Freeing back stack index ").append(p4).toString());
        }
        this.mAvailBackStackIndices.add(Integer.valueOf(p4));
        return;
    }

    public android.support.v4.app.FragmentManager$BackStackEntry getBackStackEntryAt(int p2)
    {
        return ((android.support.v4.app.FragmentManager$BackStackEntry) this.mBackStack.get(p2));
    }

    public int getBackStackEntryCount()
    {
        int v0_1;
        if (this.mBackStack == null) {
            v0_1 = 0;
        } else {
            v0_1 = this.mBackStack.size();
        }
        return v0_1;
    }

    public android.support.v4.app.Fragment getFragment(android.os.Bundle p6, String p7)
    {
        android.support.v4.app.Fragment v0_1;
        int v1 = p6.getInt(p7, -1);
        if (v1 != -1) {
            if (v1 >= this.mActive.size()) {
                this.throwException(new IllegalStateException(new StringBuilder().append("Fragment no longer exists for key ").append(p7).append(": index ").append(v1).toString()));
            }
            v0_1 = ((android.support.v4.app.Fragment) this.mActive.get(v1));
            if (v0_1 == null) {
                this.throwException(new IllegalStateException(new StringBuilder().append("Fragment no longer exists for key ").append(p7).append(": index ").append(v1).toString()));
            }
        } else {
            v0_1 = 0;
        }
        return v0_1;
    }

    public java.util.List getFragments()
    {
        return this.mActive;
    }

    public void hideFragment(android.support.v4.app.Fragment p6, int p7, int p8)
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("hide: ").append(p6).toString());
        }
        if (!p6.mHidden) {
            p6.mHidden = 1;
            if (p6.mView != null) {
                android.view.animation.Animation v0 = this.loadAnimation(p6, p7, 0, p8);
                if (v0 != null) {
                    p6.mView.startAnimation(v0);
                }
                p6.mView.setVisibility(8);
            }
            if ((p6.mAdded) && ((p6.mHasMenu) && (p6.mMenuVisible))) {
                this.mNeedMenuInvalidate = 1;
            }
            p6.onHiddenChanged(1);
        }
        return;
    }

    public boolean isDestroyed()
    {
        return this.mDestroyed;
    }

    android.view.animation.Animation loadAnimation(android.support.v4.app.Fragment p10, int p11, boolean p12, int p13)
    {
        android.support.v4.app.FragmentActivity v1 = p10.onCreateAnimation(p11, p12, p10.mNextAnim);
        if (v1 == null) {
            if (p10.mNextAnim != 0) {
                android.view.animation.Animation v0 = android.view.animation.AnimationUtils.loadAnimation(this.mActivity, p10.mNextAnim);
                if (v0 != null) {
                    v1 = v0;
                    return v1;
                }
            }
            if (p11 != 0) {
                int v2 = android.support.v4.app.FragmentManagerImpl.transitToStyleIndex(p11, p12);
                if (v2 >= 0) {
                    switch (v2) {
                        case 1:
                            v1 = android.support.v4.app.FragmentManagerImpl.makeOpenCloseAnimation(this.mActivity, 1066401792, 1065353216, 0, 1065353216);
                        case 2:
                            v1 = android.support.v4.app.FragmentManagerImpl.makeOpenCloseAnimation(this.mActivity, 1065353216, 1064933786, 1065353216, 0);
                            break;
                        case 3:
                            v1 = android.support.v4.app.FragmentManagerImpl.makeOpenCloseAnimation(this.mActivity, 1064933786, 1065353216, 0, 1065353216);
                            break;
                        case 4:
                            v1 = android.support.v4.app.FragmentManagerImpl.makeOpenCloseAnimation(this.mActivity, 1065353216, 1065982362, 1065353216, 0);
                            break;
                        case 5:
                            v1 = android.support.v4.app.FragmentManagerImpl.makeFadeAnimation(this.mActivity, 0, 1065353216);
                            break;
                        case 6:
                            v1 = android.support.v4.app.FragmentManagerImpl.makeFadeAnimation(this.mActivity, 1065353216, 0);
                            break;
                        default:
                            if (p13 != 0) {
                                if (p13 != 0) {
                                    v1 = 0;
                                } else {
                                    v1 = 0;
                                }
                            } else {
                                if (this.mActivity.getWindow() == null) {
                                } else {
                                    p13 = this.mActivity.getWindow().getAttributes().windowAnimations;
                                }
                            }
                    }
                } else {
                    v1 = 0;
                }
            } else {
                v1 = 0;
            }
        }
        return v1;
    }

    void makeActive(android.support.v4.app.Fragment p4)
    {
        if (p4.mIndex < 0) {
            if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0)) {
                p4.setIndex(((Integer) this.mAvailIndices.remove((this.mAvailIndices.size() - 1))).intValue(), this.mParent);
                this.mActive.set(p4.mIndex, p4);
            } else {
                if (this.mActive == null) {
                    this.mActive = new java.util.ArrayList();
                }
                p4.setIndex(this.mActive.size(), this.mParent);
                this.mActive.add(p4);
            }
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Allocated fragment index ").append(p4).toString());
            }
        }
        return;
    }

    void makeInactive(android.support.v4.app.Fragment p4)
    {
        if (p4.mIndex >= 0) {
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Freeing fragment index ").append(p4).toString());
            }
            this.mActive.set(p4.mIndex, 0);
            if (this.mAvailIndices == null) {
                this.mAvailIndices = new java.util.ArrayList();
            }
            this.mAvailIndices.add(Integer.valueOf(p4.mIndex));
            this.mActivity.invalidateSupportFragment(p4.mWho);
            p4.initState();
        }
        return;
    }

    void moveToState(int p9, int p10, int p11, boolean p12)
    {
        if ((this.mActivity != null) || (p9 == 0)) {
            if ((p12) || (this.mCurState != p9)) {
                this.mCurState = p9;
                if (this.mActive != null) {
                    int v7 = 0;
                    int v6 = 0;
                    while (v6 < this.mActive.size()) {
                        android.support.v4.app.Fragment v1_1 = ((android.support.v4.app.Fragment) this.mActive.get(v6));
                        if (v1_1 != null) {
                            this.moveToState(v1_1, p9, p10, p11, 0);
                            if (v1_1.mLoaderManager != null) {
                                v7 |= v1_1.mLoaderManager.hasRunningLoaders();
                            }
                        }
                        v6++;
                    }
                    if (v7 == 0) {
                        this.startPendingDeferredFragments();
                    }
                    if ((this.mNeedMenuInvalidate) && ((this.mActivity != null) && (this.mCurState == 5))) {
                        this.mActivity.supportInvalidateOptionsMenu();
                        this.mNeedMenuInvalidate = 0;
                    }
                }
            }
            return;
        } else {
            throw new IllegalStateException("No activity");
        }
    }

    void moveToState(int p2, boolean p3)
    {
        this.moveToState(p2, 0, 0, p3);
        return;
    }

    void moveToState(android.support.v4.app.Fragment p7)
    {
        this.moveToState(p7, this.mCurState, 0, 0, 0);
        return;
    }

    void moveToState(android.support.v4.app.Fragment p11, int p12, int p13, int p14, boolean p15)
    {
        if (((!p11.mAdded) || (p11.mDetached)) && (p12 > 1)) {
            p12 = 1;
        }
        if ((p11.mRemoving) && (p12 > p11.mState)) {
            p12 = p11.mState;
        }
        if ((p11.mDeferStart) && ((p11.mState < 4) && (p12 > 3))) {
            p12 = 3;
        }
        if (p11.mState >= p12) {
            if (p11.mState <= p12) {
                p11.mState = p12;
            } else {
                switch (p11.mState) {
                    case 1:
                        break;
                    case 2:
                        if (p12 >= 2) {
                        } else {
                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                android.util.Log.v("FragmentManager", new StringBuilder().append("movefrom ACTIVITY_CREATED: ").append(p11).toString());
                            }
                            if ((p11.mView != null) && ((!this.mActivity.isFinishing()) && (p11.mSavedViewState == null))) {
                                this.saveFragmentViewState(p11);
                            }
                            p11.performDestroyView();
                            if ((p11.mView != null) && (p11.mContainer != null)) {
                                android.view.animation.Animation v6_0 = 0;
                                if ((this.mCurState > 0) && (!this.mDestroyed)) {
                                    v6_0 = this.loadAnimation(p11, p13, 0, p14);
                                }
                                if (v6_0 != null) {
                                    p11.mAnimatingAway = p11.mView;
                                    p11.mStateAfterAnimating = p12;
                                    v6_0.setAnimationListener(new android.support.v4.app.FragmentManagerImpl$5(this, p11));
                                    p11.mView.startAnimation(v6_0);
                                }
                                p11.mContainer.removeView(p11.mView);
                            }
                            p11.mContainer = 0;
                            p11.mView = 0;
                            p11.mInnerView = 0;
                        }
                        break;
                    case 3:
                        if (p12 >= 3) {
                        } else {
                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                android.util.Log.v("FragmentManager", new StringBuilder().append("movefrom STOPPED: ").append(p11).toString());
                            }
                            p11.performReallyStop();
                        }
                        break;
                    case 4:
                        if (p12 >= 4) {
                        } else {
                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                android.util.Log.v("FragmentManager", new StringBuilder().append("movefrom STARTED: ").append(p11).toString());
                            }
                            p11.performStop();
                        }
                        break;
                    case 5:
                        if (p12 >= 5) {
                        } else {
                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                android.util.Log.v("FragmentManager", new StringBuilder().append("movefrom RESUMED: ").append(p11).toString());
                            }
                            p11.performPause();
                            p11.mResumed = 0;
                        }
                        break;
                    default:
                }
                if (p12 >= 1) {
                } else {
                    if ((this.mDestroyed) && (p11.mAnimatingAway != null)) {
                        android.view.View v9 = p11.mAnimatingAway;
                        p11.mAnimatingAway = 0;
                        v9.clearAnimation();
                    }
                    if (p11.mAnimatingAway == null) {
                        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                            android.util.Log.v("FragmentManager", new StringBuilder().append("movefrom CREATED: ").append(p11).toString());
                        }
                        if (!p11.mRetaining) {
                            p11.performDestroy();
                        }
                        p11.mCalled = 0;
                        p11.onDetach();
                        if (p11.mCalled) {
                            if (p15) {
                            } else {
                                if (p11.mRetaining) {
                                    p11.mActivity = 0;
                                    p11.mParentFragment = 0;
                                    p11.mFragmentManager = 0;
                                    p11.mChildFragmentManager = 0;
                                } else {
                                    this.makeInactive(p11);
                                }
                            }
                        } else {
                            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(p11).append(" did not call through to super.onDetach()").toString());
                        }
                    } else {
                        p11.mStateAfterAnimating = p12;
                        p12 = 1;
                    }
                }
            }
        } else {
            if ((!p11.mFromLayout) || (p11.mInLayout)) {
                if (p11.mAnimatingAway != null) {
                    p11.mAnimatingAway = 0;
                    this.moveToState(p11, p11.mStateAfterAnimating, 0, 0, 1);
                }
                switch (p11.mState) {
                    case 0:
                        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                            android.util.Log.v("FragmentManager", new StringBuilder().append("moveto CREATED: ").append(p11).toString());
                        }
                        if (p11.mSavedFragmentState != null) {
                            p11.mSavedViewState = p11.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            p11.mTarget = this.getFragment(p11.mSavedFragmentState, "android:target_state");
                            if (p11.mTarget != null) {
                                p11.mTargetRequestCode = p11.mSavedFragmentState.getInt("android:target_req_state", 0);
                            }
                            p11.mUserVisibleHint = p11.mSavedFragmentState.getBoolean("android:user_visible_hint", 1);
                            if (!p11.mUserVisibleHint) {
                                p11.mDeferStart = 1;
                                if (p12 > 3) {
                                    p12 = 3;
                                }
                            }
                        }
                        android.view.View v0_64;
                        p11.mActivity = this.mActivity;
                        p11.mParentFragment = this.mParent;
                        if (this.mParent == null) {
                            v0_64 = this.mActivity.mFragments;
                        } else {
                            v0_64 = this.mParent.mChildFragmentManager;
                        }
                        p11.mFragmentManager = v0_64;
                        p11.mCalled = 0;
                        p11.onAttach(this.mActivity);
                        if (p11.mCalled) {
                            if (p11.mParentFragment == null) {
                                this.mActivity.onAttachFragment(p11);
                            }
                            if (!p11.mRetaining) {
                                p11.performCreate(p11.mSavedFragmentState);
                            }
                            p11.mRetaining = 0;
                            if (p11.mFromLayout) {
                                p11.mView = p11.performCreateView(p11.getLayoutInflater(p11.mSavedFragmentState), 0, p11.mSavedFragmentState);
                                if (p11.mView == null) {
                                    p11.mInnerView = 0;
                                } else {
                                    p11.mInnerView = p11.mView;
                                    p11.mView = android.support.v4.app.NoSaveStateFrameLayout.wrap(p11.mView);
                                    if (p11.mHidden) {
                                        p11.mView.setVisibility(8);
                                    }
                                    p11.onViewCreated(p11.mView, p11.mSavedFragmentState);
                                }
                            } else {
                                if (p12 <= 1) {
                                    if (p12 <= 3) {
                                        if (p12 <= 4) {
                                        } else {
                                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                                android.util.Log.v("FragmentManager", new StringBuilder().append("moveto RESUMED: ").append(p11).toString());
                                            }
                                            p11.mResumed = 1;
                                            p11.performResume();
                                            p11.mSavedFragmentState = 0;
                                            p11.mSavedViewState = 0;
                                        }
                                    } else {
                                        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                            android.util.Log.v("FragmentManager", new StringBuilder().append("moveto STARTED: ").append(p11).toString());
                                        }
                                        p11.performStart();
                                    }
                                } else {
                                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                        android.util.Log.v("FragmentManager", new StringBuilder().append("moveto ACTIVITY_CREATED: ").append(p11).toString());
                                    }
                                    if (!p11.mFromLayout) {
                                        android.view.ViewGroup v7_0 = 0;
                                        if (p11.mContainerId != 0) {
                                            v7_0 = ((android.view.ViewGroup) this.mContainer.findViewById(p11.mContainerId));
                                            if ((v7_0 == null) && (!p11.mRestored)) {
                                                this.throwException(new IllegalArgumentException(new StringBuilder().append("No view found for id 0x").append(Integer.toHexString(p11.mContainerId)).append(" (").append(p11.getResources().getResourceName(p11.mContainerId)).append(") for fragment ").append(p11).toString()));
                                            }
                                        }
                                        p11.mContainer = v7_0;
                                        p11.mView = p11.performCreateView(p11.getLayoutInflater(p11.mSavedFragmentState), v7_0, p11.mSavedFragmentState);
                                        if (p11.mView == null) {
                                            p11.mInnerView = 0;
                                        } else {
                                            p11.mInnerView = p11.mView;
                                            p11.mView = android.support.v4.app.NoSaveStateFrameLayout.wrap(p11.mView);
                                            if (v7_0 != null) {
                                                android.view.animation.Animation v6_1 = this.loadAnimation(p11, p13, 1, p14);
                                                if (v6_1 != null) {
                                                    p11.mView.startAnimation(v6_1);
                                                }
                                                v7_0.addView(p11.mView);
                                            }
                                            if (p11.mHidden) {
                                                p11.mView.setVisibility(8);
                                            }
                                            p11.onViewCreated(p11.mView, p11.mSavedFragmentState);
                                        }
                                    }
                                    p11.performActivityCreated(p11.mSavedFragmentState);
                                    if (p11.mView != null) {
                                        p11.restoreViewState(p11.mSavedFragmentState);
                                    }
                                    p11.mSavedFragmentState = 0;
                                }
                            }
                        } else {
                            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(p11).append(" did not call through to super.onAttach()").toString());
                        }
                    default:
                }
            }
        }
        return;
    }

    public void noteStateNotSaved()
    {
        this.mStateSaved = 0;
        return;
    }

    public void performPendingDeferredStart(android.support.v4.app.Fragment p7)
    {
        if (p7.mDeferStart) {
            if (!this.mExecutingActions) {
                p7.mDeferStart = 0;
                this.moveToState(p7, this.mCurState, 0, 0, 0);
            } else {
                this.mHavePendingDeferredStart = 1;
            }
        }
        return;
    }

    public void popBackStack()
    {
        this.enqueueAction(new android.support.v4.app.FragmentManagerImpl$2(this), 0);
        return;
    }

    public void popBackStack(int p4, int p5)
    {
        if (p4 >= 0) {
            this.enqueueAction(new android.support.v4.app.FragmentManagerImpl$4(this, p4, p5), 0);
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Bad id: ").append(p4).toString());
        }
    }

    public void popBackStack(String p3, int p4)
    {
        this.enqueueAction(new android.support.v4.app.FragmentManagerImpl$3(this, p3, p4), 0);
        return;
    }

    public boolean popBackStackImmediate()
    {
        this.checkStateLoss();
        this.executePendingTransactions();
        return this.popBackStackState(this.mActivity.mHandler, 0, -1, 0);
    }

    public boolean popBackStackImmediate(int p4, int p5)
    {
        this.checkStateLoss();
        this.executePendingTransactions();
        if (p4 >= 0) {
            return this.popBackStackState(this.mActivity.mHandler, 0, p4, p5);
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Bad id: ").append(p4).toString());
        }
    }

    public boolean popBackStackImmediate(String p3, int p4)
    {
        this.checkStateLoss();
        this.executePendingTransactions();
        return this.popBackStackState(this.mActivity.mHandler, p3, -1, p4);
    }

    boolean popBackStackState(android.os.Handler p12, String p13, int p14, int p15)
    {
        int v9 = 0;
        if (this.mBackStack != null) {
            if ((p13 != null) || ((p14 >= 0) || ((p15 & 1) != 0))) {
                int v3 = -1;
                if ((p13 != null) || (p14 >= 0)) {
                    v3 = (this.mBackStack.size() - 1);
                    while (v3 >= 0) {
                        android.support.v4.app.BackStackRecord v1_3 = ((android.support.v4.app.BackStackRecord) this.mBackStack.get(v3));
                        if (((p13 != null) && (p13.equals(v1_3.getName()))) || ((p14 >= 0) && (p14 == v1_3.mIndex))) {
                            break;
                        }
                        v3--;
                    }
                    if (v3 < 0) {
                        return v9;
                    } else {
                        if ((p15 & 1) != 0) {
                            v3--;
                            while (v3 >= 0) {
                                android.support.v4.app.BackStackRecord v1_5 = ((android.support.v4.app.BackStackRecord) this.mBackStack.get(v3));
                                if (((p13 == null) || (!p13.equals(v1_5.getName()))) && ((p14 < 0) || (p14 != v1_5.mIndex))) {
                                    break;
                                }
                                v3--;
                            }
                        }
                    }
                }
                if (v3 == (this.mBackStack.size() - 1)) {
                    return v9;
                } else {
                    java.util.ArrayList v5_1 = new java.util.ArrayList();
                    int v2_0 = (this.mBackStack.size() - 1);
                    while (v2_0 > v3) {
                        v5_1.add(this.mBackStack.remove(v2_0));
                        v2_0--;
                    }
                    int v0 = (v5_1.size() - 1);
                    int v2_1 = 0;
                    while (v2_1 <= v0) {
                        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                            android.util.Log.v("FragmentManager", new StringBuilder().append("Popping back stack state: ").append(v5_1.get(v2_1)).toString());
                        }
                        int v7_5;
                        int v6_22 = v5_1.get(v2_1);
                        if (v2_1 != v0) {
                            v7_5 = 0;
                        } else {
                            v7_5 = 1;
                        }
                        ((android.support.v4.app.BackStackRecord) v6_22).popFromBackStack(v7_5);
                        v2_1++;
                    }
                    this.reportBackStackChanged();
                }
            } else {
                int v4 = (this.mBackStack.size() - 1);
                if (v4 < 0) {
                    return v9;
                } else {
                    ((android.support.v4.app.BackStackRecord) this.mBackStack.remove(v4)).popFromBackStack(1);
                    this.reportBackStackChanged();
                }
            }
            v9 = 1;
        }
        return v9;
    }

    public void putFragment(android.os.Bundle p4, String p5, android.support.v4.app.Fragment p6)
    {
        if (p6.mIndex < 0) {
            this.throwException(new IllegalStateException(new StringBuilder().append("Fragment ").append(p6).append(" is not currently in the FragmentManager").toString()));
        }
        p4.putInt(p5, p6.mIndex);
        return;
    }

    public void removeFragment(android.support.v4.app.Fragment p8, int p9, int p10)
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("remove: ").append(p8).append(" nesting=").append(p8.mBackStackNesting).toString());
        }
        int v6;
        if (p8.isInBackStack()) {
            v6 = 0;
        } else {
            v6 = 1;
        }
        if ((!p8.mDetached) || (v6 != 0)) {
            if (this.mAdded != null) {
                this.mAdded.remove(p8);
            }
            if ((p8.mHasMenu) && (p8.mMenuVisible)) {
                this.mNeedMenuInvalidate = 1;
            }
            int v2_4;
            p8.mAdded = 0;
            p8.mRemoving = 1;
            if (v6 == 0) {
                v2_4 = 1;
            } else {
                v2_4 = 0;
            }
            this.moveToState(p8, v2_4, p9, p10, 0);
        }
        return;
    }

    public void removeOnBackStackChangedListener(android.support.v4.app.FragmentManager$OnBackStackChangedListener p2)
    {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(p2);
        }
        return;
    }

    void reportBackStackChanged()
    {
        if (this.mBackStackChangeListeners != null) {
            int v0 = 0;
            while (v0 < this.mBackStackChangeListeners.size()) {
                ((android.support.v4.app.FragmentManager$OnBackStackChangedListener) this.mBackStackChangeListeners.get(v0)).onBackStackChanged();
                v0++;
            }
        }
        return;
    }

    void restoreAllState(android.os.Parcelable p13, java.util.ArrayList p14)
    {
        if ((p13 != null) && (((android.support.v4.app.FragmentManagerState) p13).mActive != null)) {
            if (p14 != null) {
                int v4_3 = 0;
                while (v4_3 < p14.size()) {
                    android.support.v4.app.Fragment v1_6 = ((android.support.v4.app.Fragment) p14.get(v4_3));
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("restoreAllState: re-attaching retained ").append(v1_6).toString());
                    }
                    android.support.v4.app.FragmentState v3_1 = ((android.support.v4.app.FragmentManagerState) p13).mActive[v1_6.mIndex];
                    v3_1.mInstance = v1_6;
                    v1_6.mSavedViewState = 0;
                    v1_6.mBackStackNesting = 0;
                    v1_6.mInLayout = 0;
                    v1_6.mAdded = 0;
                    v1_6.mTarget = 0;
                    if (v3_1.mSavedFragmentState != null) {
                        v3_1.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
                        v1_6.mSavedViewState = v3_1.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    }
                    v4_3++;
                }
            }
            this.mActive = new java.util.ArrayList(((android.support.v4.app.FragmentManagerState) p13).mActive.length);
            if (this.mAvailIndices != null) {
                this.mAvailIndices.clear();
            }
            int v4_2 = 0;
            while (v4_2 < ((android.support.v4.app.FragmentManagerState) p13).mActive.length) {
                android.support.v4.app.FragmentState v3_0 = ((android.support.v4.app.FragmentManagerState) p13).mActive[v4_2];
                if (v3_0 == null) {
                    this.mActive.add(0);
                    if (this.mAvailIndices == null) {
                        this.mAvailIndices = new java.util.ArrayList();
                    }
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("restoreAllState: avail #").append(v4_2).toString());
                    }
                    this.mAvailIndices.add(Integer.valueOf(v4_2));
                } else {
                    android.support.v4.app.Fragment v1_4 = v3_0.instantiate(this.mActivity, this.mParent);
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("restoreAllState: active #").append(v4_2).append(": ").append(v1_4).toString());
                    }
                    this.mActive.add(v1_4);
                    v3_0.mInstance = 0;
                }
                v4_2++;
            }
            if (p14 != null) {
                int v4_1 = 0;
                while (v4_1 < p14.size()) {
                    android.support.v4.app.Fragment v1_3 = ((android.support.v4.app.Fragment) p14.get(v4_1));
                    if (v1_3.mTargetIndex >= 0) {
                        if (v1_3.mTargetIndex >= this.mActive.size()) {
                            android.util.Log.w("FragmentManager", new StringBuilder().append("Re-attaching retained fragment ").append(v1_3).append(" target no longer exists: ").append(v1_3.mTargetIndex).toString());
                            v1_3.mTarget = 0;
                        } else {
                            v1_3.mTarget = ((android.support.v4.app.Fragment) this.mActive.get(v1_3.mTargetIndex));
                        }
                    }
                    v4_1++;
                }
            }
            if (((android.support.v4.app.FragmentManagerState) p13).mAdded == null) {
                this.mAdded = 0;
            } else {
                this.mAdded = new java.util.ArrayList(((android.support.v4.app.FragmentManagerState) p13).mAdded.length);
                int v4_0 = 0;
                while (v4_0 < ((android.support.v4.app.FragmentManagerState) p13).mAdded.length) {
                    android.support.v4.app.Fragment v1_1 = ((android.support.v4.app.Fragment) this.mActive.get(((android.support.v4.app.FragmentManagerState) p13).mAdded[v4_0]));
                    if (v1_1 == null) {
                        this.throwException(new IllegalStateException(new StringBuilder().append("No instantiated fragment for index #").append(((android.support.v4.app.FragmentManagerState) p13).mAdded[v4_0]).toString()));
                    }
                    v1_1.mAdded = 1;
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("restoreAllState: added #").append(v4_0).append(": ").append(v1_1).toString());
                    }
                    if (!this.mAdded.contains(v1_1)) {
                        this.mAdded.add(v1_1);
                        v4_0++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                }
            }
            if (((android.support.v4.app.FragmentManagerState) p13).mBackStack == null) {
                this.mBackStack = 0;
            } else {
                this.mBackStack = new java.util.ArrayList(((android.support.v4.app.FragmentManagerState) p13).mBackStack.length);
                int v4_4 = 0;
                while (v4_4 < ((android.support.v4.app.FragmentManagerState) p13).mBackStack.length) {
                    android.support.v4.app.BackStackRecord v0 = ((android.support.v4.app.FragmentManagerState) p13).mBackStack[v4_4].instantiate(this);
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("restoreAllState: back stack #").append(v4_4).append(" (index ").append(v0.mIndex).append("): ").append(v0).toString());
                        v0.dump("  ", new java.io.PrintWriter(new android.support.v4.util.LogWriter("FragmentManager")), 0);
                    }
                    this.mBackStack.add(v0);
                    if (v0.mIndex >= 0) {
                        this.setBackStackIndex(v0.mIndex, v0);
                    }
                    v4_4++;
                }
            }
        }
        return;
    }

    java.util.ArrayList retainNonConfig()
    {
        java.util.ArrayList v1_0 = 0;
        if (this.mActive != null) {
            int v2 = 0;
            while (v2 < this.mActive.size()) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mActive.get(v2));
                if ((v0_1 != null) && (v0_1.mRetainInstance)) {
                    if (v1_0 == null) {
                        v1_0 = new java.util.ArrayList();
                    }
                    String v3_4;
                    v1_0.add(v0_1);
                    v0_1.mRetaining = 1;
                    if (v0_1.mTarget == null) {
                        v3_4 = -1;
                    } else {
                        v3_4 = v0_1.mTarget.mIndex;
                    }
                    v0_1.mTargetIndex = v3_4;
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("retainNonConfig: keeping retained ").append(v0_1).toString());
                    }
                }
                v2++;
            }
        }
        return v1_0;
    }

    android.os.Parcelable saveAllState()
    {
        android.support.v4.app.FragmentManagerState v5_0 = 0;
        this.execPendingActions();
        if (android.support.v4.app.FragmentManagerImpl.HONEYCOMB) {
            this.mStateSaved = 1;
        }
        if ((this.mActive != null) && (this.mActive.size() > 0)) {
            int v0_0 = this.mActive.size();
            android.support.v4.app.FragmentState[] v1 = new android.support.v4.app.FragmentState[v0_0];
            int v7 = 0;
            int v8_1 = 0;
            while (v8_1 < v0_0) {
                android.support.v4.app.Fragment v4_1 = ((android.support.v4.app.Fragment) this.mActive.get(v8_1));
                if (v4_1 != null) {
                    if (v4_1.mIndex < 0) {
                        this.throwException(new IllegalStateException(new StringBuilder().append("Failure saving state: active ").append(v4_1).append(" has cleared index: ").append(v4_1.mIndex).toString()));
                    }
                    v7 = 1;
                    android.support.v4.app.FragmentState v6_1 = new android.support.v4.app.FragmentState(v4_1);
                    v1[v8_1] = v6_1;
                    if ((v4_1.mState <= 0) || (v6_1.mSavedFragmentState != null)) {
                        v6_1.mSavedFragmentState = v4_1.mSavedFragmentState;
                    } else {
                        v6_1.mSavedFragmentState = this.saveFragmentBasicState(v4_1);
                        if (v4_1.mTarget != null) {
                            if (v4_1.mTarget.mIndex < 0) {
                                this.throwException(new IllegalStateException(new StringBuilder().append("Failure saving state: ").append(v4_1).append(" has target not in fragment manager: ").append(v4_1.mTarget).toString()));
                            }
                            if (v6_1.mSavedFragmentState == null) {
                                v6_1.mSavedFragmentState = new android.os.Bundle();
                            }
                            this.putFragment(v6_1.mSavedFragmentState, "android:target_state", v4_1.mTarget);
                            if (v4_1.mTargetRequestCode != 0) {
                                v6_1.mSavedFragmentState.putInt("android:target_req_state", v4_1.mTargetRequestCode);
                            }
                        }
                    }
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("Saved state of ").append(v4_1).append(": ").append(v6_1.mSavedFragmentState).toString());
                    }
                }
                v8_1++;
            }
            if (v7 != 0) {
                int[] v2 = 0;
                android.support.v4.app.BackStackState[] v3 = 0;
                if (this.mAdded != null) {
                    int v0_1 = this.mAdded.size();
                    if (v0_1 > 0) {
                        v2 = new int[v0_1];
                        int v8_0 = 0;
                        while (v8_0 < v0_1) {
                            v2[v8_0] = ((android.support.v4.app.Fragment) this.mAdded.get(v8_0)).mIndex;
                            if (v2[v8_0] < 0) {
                                this.throwException(new IllegalStateException(new StringBuilder().append("Failure saving state: active ").append(this.mAdded.get(v8_0)).append(" has cleared index: ").append(v2[v8_0]).toString()));
                            }
                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                android.util.Log.v("FragmentManager", new StringBuilder().append("saveAllState: adding fragment #").append(v8_0).append(": ").append(this.mAdded.get(v8_0)).toString());
                            }
                            v8_0++;
                        }
                    }
                }
                if (this.mBackStack != null) {
                    int v0_2 = this.mBackStack.size();
                    if (v0_2 > 0) {
                        v3 = new android.support.v4.app.BackStackState[v0_2];
                        int v8_2 = 0;
                        while (v8_2 < v0_2) {
                            v3[v8_2] = new android.support.v4.app.BackStackState(this, ((android.support.v4.app.BackStackRecord) this.mBackStack.get(v8_2)));
                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                android.util.Log.v("FragmentManager", new StringBuilder().append("saveAllState: adding back stack #").append(v8_2).append(": ").append(this.mBackStack.get(v8_2)).toString());
                            }
                            v8_2++;
                        }
                    }
                }
                v5_0 = new android.support.v4.app.FragmentManagerState();
                v5_0.mActive = v1;
                v5_0.mAdded = v2;
                v5_0.mBackStack = v3;
            } else {
                if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                    android.util.Log.v("FragmentManager", "saveAllState: no fragments!");
                }
            }
        }
        return v5_0;
    }

    android.os.Bundle saveFragmentBasicState(android.support.v4.app.Fragment p4)
    {
        android.os.Bundle v0_0 = 0;
        if (this.mStateBundle == null) {
            this.mStateBundle = new android.os.Bundle();
        }
        p4.performSaveInstanceState(this.mStateBundle);
        if (!this.mStateBundle.isEmpty()) {
            v0_0 = this.mStateBundle;
            this.mStateBundle = 0;
        }
        if (p4.mView != null) {
            this.saveFragmentViewState(p4);
        }
        if (p4.mSavedViewState != null) {
            if (v0_0 == null) {
                v0_0 = new android.os.Bundle();
            }
            v0_0.putSparseParcelableArray("android:view_state", p4.mSavedViewState);
        }
        if (!p4.mUserVisibleHint) {
            if (v0_0 == null) {
                v0_0 = new android.os.Bundle();
            }
            v0_0.putBoolean("android:user_visible_hint", p4.mUserVisibleHint);
        }
        return v0_0;
    }

    public android.support.v4.app.Fragment$SavedState saveFragmentInstanceState(android.support.v4.app.Fragment p6)
    {
        android.support.v4.app.Fragment$SavedState v1_0 = 0;
        if (p6.mIndex < 0) {
            this.throwException(new IllegalStateException(new StringBuilder().append("Fragment ").append(p6).append(" is not currently in the FragmentManager").toString()));
        }
        if (p6.mState > 0) {
            android.os.Bundle v0 = this.saveFragmentBasicState(p6);
            if (v0 != null) {
                v1_0 = new android.support.v4.app.Fragment$SavedState(v0);
            }
        }
        return v1_0;
    }

    void saveFragmentViewState(android.support.v4.app.Fragment p3)
    {
        if (p3.mInnerView != null) {
            if (this.mStateArray != null) {
                this.mStateArray.clear();
            } else {
                this.mStateArray = new android.util.SparseArray();
            }
            p3.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                p3.mSavedViewState = this.mStateArray;
                this.mStateArray = 0;
            }
        }
        return;
    }

    public void setBackStackIndex(int p5, android.support.v4.app.BackStackRecord p6)
    {
        try {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new java.util.ArrayList();
            }
        } catch (java.util.ArrayList v1_17) {
            throw v1_17;
        }
        int v0 = this.mBackStackIndices.size();
        if (p5 >= v0) {
            while (v0 < p5) {
                this.mBackStackIndices.add(0);
                if (this.mAvailBackStackIndices == null) {
                    this.mAvailBackStackIndices = new java.util.ArrayList();
                }
                if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                    android.util.Log.v("FragmentManager", new StringBuilder().append("Adding available back stack index ").append(v0).toString());
                }
                this.mAvailBackStackIndices.add(Integer.valueOf(v0));
                v0++;
            }
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Adding back stack index ").append(p5).append(" with ").append(p6).toString());
            }
            this.mBackStackIndices.add(p6);
        } else {
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Setting back stack index ").append(p5).append(" to ").append(p6).toString());
            }
            this.mBackStackIndices.set(p5, p6);
        }
        return;
    }

    public void showFragment(android.support.v4.app.Fragment p7, int p8, int p9)
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("show: ").append(p7).toString());
        }
        if (p7.mHidden) {
            p7.mHidden = 0;
            if (p7.mView != null) {
                android.view.animation.Animation v0 = this.loadAnimation(p7, p8, 1, p9);
                if (v0 != null) {
                    p7.mView.startAnimation(v0);
                }
                p7.mView.setVisibility(0);
            }
            if ((p7.mAdded) && ((p7.mHasMenu) && (p7.mMenuVisible))) {
                this.mNeedMenuInvalidate = 1;
            }
            p7.onHiddenChanged(0);
        }
        return;
    }

    void startPendingDeferredFragments()
    {
        if (this.mActive != null) {
            int v1 = 0;
            while (v1 < this.mActive.size()) {
                android.support.v4.app.Fragment v0_0 = ((android.support.v4.app.Fragment) this.mActive.get(v1));
                if (v0_0 != null) {
                    this.performPendingDeferredStart(v0_0);
                }
                v1++;
            }
        }
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(128);
        v0_1.append("FragmentManager{");
        v0_1.append(Integer.toHexString(System.identityHashCode(this)));
        v0_1.append(" in ");
        if (this.mParent == null) {
            android.support.v4.util.DebugUtils.buildShortClassTag(this.mActivity, v0_1);
        } else {
            android.support.v4.util.DebugUtils.buildShortClassTag(this.mParent, v0_1);
        }
        v0_1.append("}}");
        return v0_1.toString();
    }
}
