package android.support.v4.app;
public class Fragment implements android.content.ComponentCallbacks, android.view.View$OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    private static final android.support.v4.util.SimpleArrayMap sClassMap;
    android.support.v4.app.FragmentActivity mActivity;
    boolean mAdded;
    android.view.View mAnimatingAway;
    android.os.Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    android.support.v4.app.FragmentManagerImpl mChildFragmentManager;
    android.view.ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    android.support.v4.app.FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mInLayout;
    int mIndex;
    android.view.View mInnerView;
    android.support.v4.app.LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    int mNextAnim;
    android.support.v4.app.Fragment mParentFragment;
    boolean mRemoving;
    boolean mRestored;
    boolean mResumed;
    boolean mRetainInstance;
    boolean mRetaining;
    android.os.Bundle mSavedFragmentState;
    android.util.SparseArray mSavedViewState;
    int mState;
    int mStateAfterAnimating;
    String mTag;
    android.support.v4.app.Fragment mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    android.view.View mView;
    String mWho;

    static Fragment()
    {
        android.support.v4.app.Fragment.sClassMap = new android.support.v4.util.SimpleArrayMap();
        return;
    }

    public Fragment()
    {
        this.mState = 0;
        this.mIndex = -1;
        this.mTargetIndex = -1;
        this.mMenuVisible = 1;
        this.mUserVisibleHint = 1;
        return;
    }

    public static android.support.v4.app.Fragment instantiate(android.content.Context p1, String p2)
    {
        return android.support.v4.app.Fragment.instantiate(p1, p2, 0);
    }

    public static android.support.v4.app.Fragment instantiate(android.content.Context p6, String p7, android.os.Bundle p8)
    {
        try {
            Class v0_1 = ((Class) android.support.v4.app.Fragment.sClassMap.get(p7));
        } catch (IllegalAccessException v1_2) {
            throw new android.support.v4.app.Fragment$InstantiationException(new StringBuilder().append("Unable to instantiate fragment ").append(p7).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), v1_2);
        } catch (IllegalAccessException v1_1) {
            throw new android.support.v4.app.Fragment$InstantiationException(new StringBuilder().append("Unable to instantiate fragment ").append(p7).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), v1_1);
        } catch (IllegalAccessException v1_0) {
            throw new android.support.v4.app.Fragment$InstantiationException(new StringBuilder().append("Unable to instantiate fragment ").append(p7).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), v1_0);
        }
        if (v0_1 == null) {
            v0_1 = p6.getClassLoader().loadClass(p7);
            android.support.v4.app.Fragment.sClassMap.put(p7, v0_1);
        }
        android.support.v4.app.Fragment v2_1 = ((android.support.v4.app.Fragment) v0_1.newInstance());
        if (p8 != null) {
            p8.setClassLoader(v2_1.getClass().getClassLoader());
            v2_1.mArguments = p8;
        }
        return v2_1;
    }

    static boolean isSupportFragmentClass(android.content.Context p3, String p4)
    {
        try {
            Class v0_1 = ((Class) android.support.v4.app.Fragment.sClassMap.get(p4));
        } catch (ClassNotFoundException v1) {
            boolean v2_1 = 0;
            return v2_1;
        }
        if (v0_1 == null) {
            v0_1 = p3.getClassLoader().loadClass(p4);
            android.support.v4.app.Fragment.sClassMap.put(p4, v0_1);
        }
        v2_1 = android.support.v4.app.Fragment.isAssignableFrom(v0_1);
        return v2_1;
    }

    public void dump(String p4, java.io.FileDescriptor p5, java.io.PrintWriter p6, String[] p7)
    {
        p6.print(p4);
        p6.print("mFragmentId=#");
        p6.print(Integer.toHexString(this.mFragmentId));
        p6.print(" mContainerId=#");
        p6.print(Integer.toHexString(this.mContainerId));
        p6.print(" mTag=");
        p6.println(this.mTag);
        p6.print(p4);
        p6.print("mState=");
        p6.print(this.mState);
        p6.print(" mIndex=");
        p6.print(this.mIndex);
        p6.print(" mWho=");
        p6.print(this.mWho);
        p6.print(" mBackStackNesting=");
        p6.println(this.mBackStackNesting);
        p6.print(p4);
        p6.print("mAdded=");
        p6.print(this.mAdded);
        p6.print(" mRemoving=");
        p6.print(this.mRemoving);
        p6.print(" mResumed=");
        p6.print(this.mResumed);
        p6.print(" mFromLayout=");
        p6.print(this.mFromLayout);
        p6.print(" mInLayout=");
        p6.println(this.mInLayout);
        p6.print(p4);
        p6.print("mHidden=");
        p6.print(this.mHidden);
        p6.print(" mDetached=");
        p6.print(this.mDetached);
        p6.print(" mMenuVisible=");
        p6.print(this.mMenuVisible);
        p6.print(" mHasMenu=");
        p6.println(this.mHasMenu);
        p6.print(p4);
        p6.print("mRetainInstance=");
        p6.print(this.mRetainInstance);
        p6.print(" mRetaining=");
        p6.print(this.mRetaining);
        p6.print(" mUserVisibleHint=");
        p6.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            p6.print(p4);
            p6.print("mFragmentManager=");
            p6.println(this.mFragmentManager);
        }
        if (this.mActivity != null) {
            p6.print(p4);
            p6.print("mActivity=");
            p6.println(this.mActivity);
        }
        if (this.mParentFragment != null) {
            p6.print(p4);
            p6.print("mParentFragment=");
            p6.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            p6.print(p4);
            p6.print("mArguments=");
            p6.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            p6.print(p4);
            p6.print("mSavedFragmentState=");
            p6.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            p6.print(p4);
            p6.print("mSavedViewState=");
            p6.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            p6.print(p4);
            p6.print("mTarget=");
            p6.print(this.mTarget);
            p6.print(" mTargetRequestCode=");
            p6.println(this.mTargetRequestCode);
        }
        if (this.mNextAnim != 0) {
            p6.print(p4);
            p6.print("mNextAnim=");
            p6.println(this.mNextAnim);
        }
        if (this.mContainer != null) {
            p6.print(p4);
            p6.print("mContainer=");
            p6.println(this.mContainer);
        }
        if (this.mView != null) {
            p6.print(p4);
            p6.print("mView=");
            p6.println(this.mView);
        }
        if (this.mInnerView != null) {
            p6.print(p4);
            p6.print("mInnerView=");
            p6.println(this.mView);
        }
        if (this.mAnimatingAway != null) {
            p6.print(p4);
            p6.print("mAnimatingAway=");
            p6.println(this.mAnimatingAway);
            p6.print(p4);
            p6.print("mStateAfterAnimating=");
            p6.println(this.mStateAfterAnimating);
        }
        if (this.mLoaderManager != null) {
            p6.print(p4);
            p6.println("Loader Manager:");
            this.mLoaderManager.dump(new StringBuilder().append(p4).append("  ").toString(), p5, p6, p7);
        }
        if (this.mChildFragmentManager != null) {
            p6.print(p4);
            p6.println(new StringBuilder().append("Child ").append(this.mChildFragmentManager).append(":").toString());
            this.mChildFragmentManager.dump(new StringBuilder().append(p4).append("  ").toString(), p5, p6, p7);
        }
        return;
    }

    public final boolean equals(Object p2)
    {
        return super.equals(p2);
    }

    android.support.v4.app.Fragment findFragmentByWho(String p2)
    {
        if (!p2.equals(this.mWho)) {
            if (this.mChildFragmentManager == null) {
                this = 0;
            } else {
                this = this.mChildFragmentManager.findFragmentByWho(p2);
            }
        }
        return this;
    }

    public final android.support.v4.app.FragmentActivity getActivity()
    {
        return this.mActivity;
    }

    public final android.os.Bundle getArguments()
    {
        return this.mArguments;
    }

    public final android.support.v4.app.FragmentManager getChildFragmentManager()
    {
        if (this.mChildFragmentManager == null) {
            this.instantiateChildFragmentManager();
            if (this.mState < 5) {
                if (this.mState < 4) {
                    if (this.mState < 2) {
                        if (this.mState >= 1) {
                            this.mChildFragmentManager.dispatchCreate();
                        }
                    } else {
                        this.mChildFragmentManager.dispatchActivityCreated();
                    }
                } else {
                    this.mChildFragmentManager.dispatchStart();
                }
            } else {
                this.mChildFragmentManager.dispatchResume();
            }
        }
        return this.mChildFragmentManager;
    }

    public final android.support.v4.app.FragmentManager getFragmentManager()
    {
        return this.mFragmentManager;
    }

    public final int getId()
    {
        return this.mFragmentId;
    }

    public android.view.LayoutInflater getLayoutInflater(android.os.Bundle p2)
    {
        return this.mActivity.getLayoutInflater();
    }

    public android.support.v4.app.LoaderManager getLoaderManager()
    {
        android.support.v4.app.LoaderManagerImpl v0_2;
        if (this.mLoaderManager == null) {
            if (this.mActivity != null) {
                this.mCheckedForLoaderManager = 1;
                this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, 1);
                v0_2 = this.mLoaderManager;
            } else {
                throw new IllegalStateException(new StringBuilder().append("Fragment ").append(this).append(" not attached to Activity").toString());
            }
        } else {
            v0_2 = this.mLoaderManager;
        }
        return v0_2;
    }

    public final android.support.v4.app.Fragment getParentFragment()
    {
        return this.mParentFragment;
    }

    public final android.content.res.Resources getResources()
    {
        if (this.mActivity != null) {
            return this.mActivity.getResources();
        } else {
            throw new IllegalStateException(new StringBuilder().append("Fragment ").append(this).append(" not attached to Activity").toString());
        }
    }

    public final boolean getRetainInstance()
    {
        return this.mRetainInstance;
    }

    public final String getString(int p2)
    {
        return this.getResources().getString(p2);
    }

    public final varargs String getString(int p2, Object[] p3)
    {
        return this.getResources().getString(p2, p3);
    }

    public final String getTag()
    {
        return this.mTag;
    }

    public final android.support.v4.app.Fragment getTargetFragment()
    {
        return this.mTarget;
    }

    public final int getTargetRequestCode()
    {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int p2)
    {
        return this.getResources().getText(p2);
    }

    public boolean getUserVisibleHint()
    {
        return this.mUserVisibleHint;
    }

    public android.view.View getView()
    {
        return this.mView;
    }

    public final boolean hasOptionsMenu()
    {
        return this.mHasMenu;
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    void initState()
    {
        this.mIndex = -1;
        this.mWho = 0;
        this.mAdded = 0;
        this.mRemoving = 0;
        this.mResumed = 0;
        this.mFromLayout = 0;
        this.mInLayout = 0;
        this.mRestored = 0;
        this.mBackStackNesting = 0;
        this.mFragmentManager = 0;
        this.mChildFragmentManager = 0;
        this.mActivity = 0;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = 0;
        this.mHidden = 0;
        this.mDetached = 0;
        this.mRetaining = 0;
        this.mLoaderManager = 0;
        this.mLoadersStarted = 0;
        this.mCheckedForLoaderManager = 0;
        return;
    }

    void instantiateChildFragmentManager()
    {
        this.mChildFragmentManager = new android.support.v4.app.FragmentManagerImpl();
        this.mChildFragmentManager.attachActivity(this.mActivity, new android.support.v4.app.Fragment$1(this), this);
        return;
    }

    public final boolean isAdded()
    {
        if ((this.mActivity == null) || (!this.mAdded)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public final boolean isDetached()
    {
        return this.mDetached;
    }

    public final boolean isHidden()
    {
        return this.mHidden;
    }

    final boolean isInBackStack()
    {
        int v0_1;
        if (this.mBackStackNesting <= 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public final boolean isInLayout()
    {
        return this.mInLayout;
    }

    public final boolean isMenuVisible()
    {
        return this.mMenuVisible;
    }

    public final boolean isRemoving()
    {
        return this.mRemoving;
    }

    public final boolean isResumed()
    {
        return this.mResumed;
    }

    public final boolean isVisible()
    {
        if ((!this.isAdded()) || ((this.isHidden()) || ((this.mView == null) || ((this.mView.getWindowToken() == null) || (this.mView.getVisibility() != 0))))) {
            int v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        return v0_4;
    }

    public void onActivityCreated(android.os.Bundle p2)
    {
        this.mCalled = 1;
        return;
    }

    public void onActivityResult(int p1, int p2, android.content.Intent p3)
    {
        return;
    }

    public void onAttach(android.app.Activity p2)
    {
        this.mCalled = 1;
        return;
    }

    public void onConfigurationChanged(android.content.res.Configuration p2)
    {
        this.mCalled = 1;
        return;
    }

    public boolean onContextItemSelected(android.view.MenuItem p2)
    {
        return 0;
    }

    public void onCreate(android.os.Bundle p2)
    {
        this.mCalled = 1;
        return;
    }

    public android.view.animation.Animation onCreateAnimation(int p2, boolean p3, int p4)
    {
        return 0;
    }

    public void onCreateContextMenu(android.view.ContextMenu p2, android.view.View p3, android.view.ContextMenu$ContextMenuInfo p4)
    {
        this.getActivity().onCreateContextMenu(p2, p3, p4);
        return;
    }

    public void onCreateOptionsMenu(android.view.Menu p1, android.view.MenuInflater p2)
    {
        return;
    }

    public android.view.View onCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        return 0;
    }

    public void onDestroy()
    {
        this.mCalled = 1;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = 1;
            this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, 0);
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
        return;
    }

    public void onDestroyOptionsMenu()
    {
        return;
    }

    public void onDestroyView()
    {
        this.mCalled = 1;
        return;
    }

    public void onDetach()
    {
        this.mCalled = 1;
        return;
    }

    public void onHiddenChanged(boolean p1)
    {
        return;
    }

    public void onInflate(android.app.Activity p2, android.util.AttributeSet p3, android.os.Bundle p4)
    {
        this.mCalled = 1;
        return;
    }

    public void onLowMemory()
    {
        this.mCalled = 1;
        return;
    }

    public boolean onOptionsItemSelected(android.view.MenuItem p2)
    {
        return 0;
    }

    public void onOptionsMenuClosed(android.view.Menu p1)
    {
        return;
    }

    public void onPause()
    {
        this.mCalled = 1;
        return;
    }

    public void onPrepareOptionsMenu(android.view.Menu p1)
    {
        return;
    }

    public void onResume()
    {
        this.mCalled = 1;
        return;
    }

    public void onSaveInstanceState(android.os.Bundle p1)
    {
        return;
    }

    public void onStart()
    {
        this.mCalled = 1;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = 1;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = 1;
                this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, 0);
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.doStart();
            }
        }
        return;
    }

    public void onStop()
    {
        this.mCalled = 1;
        return;
    }

    public void onViewCreated(android.view.View p1, android.os.Bundle p2)
    {
        return;
    }

    public void onViewStateRestored(android.os.Bundle p2)
    {
        this.mCalled = 1;
        return;
    }

    void performActivityCreated(android.os.Bundle p4)
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mCalled = 0;
        this.onActivityCreated(p4);
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.dispatchActivityCreated();
            }
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onActivityCreated()").toString());
        }
    }

    void performConfigurationChanged(android.content.res.Configuration p2)
    {
        this.onConfigurationChanged(p2);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchConfigurationChanged(p2);
        }
        return;
    }

    boolean performContextItemSelected(android.view.MenuItem p3)
    {
        int v0 = 1;
        if ((this.mHidden) || ((!this.onContextItemSelected(p3)) && ((this.mChildFragmentManager == null) || (!this.mChildFragmentManager.dispatchContextItemSelected(p3))))) {
            v0 = 0;
        }
        return v0;
    }

    void performCreate(android.os.Bundle p5)
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mCalled = 0;
        this.onCreate(p5);
        if (this.mCalled) {
            if (p5 != null) {
                android.os.Parcelable v0 = p5.getParcelable("android:support:fragments");
                if (v0 != null) {
                    if (this.mChildFragmentManager == null) {
                        this.instantiateChildFragmentManager();
                    }
                    this.mChildFragmentManager.restoreAllState(v0, 0);
                    this.mChildFragmentManager.dispatchCreate();
                }
            }
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onCreate()").toString());
        }
    }

    boolean performCreateOptionsMenu(android.view.Menu p3, android.view.MenuInflater p4)
    {
        int v0 = 0;
        if (!this.mHidden) {
            if ((this.mHasMenu) && (this.mMenuVisible)) {
                v0 = 1;
                this.onCreateOptionsMenu(p3, p4);
            }
            if (this.mChildFragmentManager != null) {
                v0 |= this.mChildFragmentManager.dispatchCreateOptionsMenu(p3, p4);
            }
        }
        return v0;
    }

    android.view.View performCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        return this.onCreateView(p2, p3, p4);
    }

    void performDestroy()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroy();
        }
        this.mCalled = 0;
        this.onDestroy();
        if (this.mCalled) {
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onDestroy()").toString());
        }
    }

    void performDestroyView()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroyView();
        }
        this.mCalled = 0;
        this.onDestroyView();
        if (this.mCalled) {
            if (this.mLoaderManager != null) {
                this.mLoaderManager.doReportNextStart();
            }
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onDestroyView()").toString());
        }
    }

    void performLowMemory()
    {
        this.onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchLowMemory();
        }
        return;
    }

    boolean performOptionsItemSelected(android.view.MenuItem p3)
    {
        int v0 = 1;
        if ((this.mHidden) || (((!this.mHasMenu) || ((!this.mMenuVisible) || (!this.onOptionsItemSelected(p3)))) && ((this.mChildFragmentManager == null) || (!this.mChildFragmentManager.dispatchOptionsItemSelected(p3))))) {
            v0 = 0;
        }
        return v0;
    }

    void performOptionsMenuClosed(android.view.Menu p2)
    {
        if (!this.mHidden) {
            if ((this.mHasMenu) && (this.mMenuVisible)) {
                this.onOptionsMenuClosed(p2);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.dispatchOptionsMenuClosed(p2);
            }
        }
        return;
    }

    void performPause()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchPause();
        }
        this.mCalled = 0;
        this.onPause();
        if (this.mCalled) {
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onPause()").toString());
        }
    }

    boolean performPrepareOptionsMenu(android.view.Menu p3)
    {
        int v0 = 0;
        if (!this.mHidden) {
            if ((this.mHasMenu) && (this.mMenuVisible)) {
                v0 = 1;
                this.onPrepareOptionsMenu(p3);
            }
            if (this.mChildFragmentManager != null) {
                v0 |= this.mChildFragmentManager.dispatchPrepareOptionsMenu(p3);
            }
        }
        return v0;
    }

    void performReallyStop()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchReallyStop();
        }
        if (this.mLoadersStarted) {
            this.mLoadersStarted = 0;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = 1;
                this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, 0);
            }
            if (this.mLoaderManager != null) {
                if (this.mActivity.mRetaining) {
                    this.mLoaderManager.doRetain();
                } else {
                    this.mLoaderManager.doStop();
                }
            }
        }
        return;
    }

    void performResume()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mCalled = 0;
        this.onResume();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.dispatchResume();
                this.mChildFragmentManager.execPendingActions();
            }
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onResume()").toString());
        }
    }

    void performSaveInstanceState(android.os.Bundle p3)
    {
        this.onSaveInstanceState(p3);
        if (this.mChildFragmentManager != null) {
            android.os.Parcelable v0 = this.mChildFragmentManager.saveAllState();
            if (v0 != null) {
                p3.putParcelable("android:support:fragments", v0);
            }
        }
        return;
    }

    void performStart()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mCalled = 0;
        this.onStart();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.dispatchStart();
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.doReportStart();
            }
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onStart()").toString());
        }
    }

    void performStop()
    {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStop();
        }
        this.mCalled = 0;
        this.onStop();
        if (this.mCalled) {
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onStop()").toString());
        }
    }

    public void registerForContextMenu(android.view.View p1)
    {
        p1.setOnCreateContextMenuListener(this);
        return;
    }

    final void restoreViewState(android.os.Bundle p4)
    {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = 0;
        }
        this.mCalled = 0;
        this.onViewStateRestored(p4);
        if (this.mCalled) {
            return;
        } else {
            throw new android.support.v4.app.SuperNotCalledException(new StringBuilder().append("Fragment ").append(this).append(" did not call through to super.onViewStateRestored()").toString());
        }
    }

    public void setArguments(android.os.Bundle p3)
    {
        if (this.mIndex < 0) {
            this.mArguments = p3;
            return;
        } else {
            throw new IllegalStateException("Fragment already active");
        }
    }

    public void setHasOptionsMenu(boolean p2)
    {
        if (this.mHasMenu != p2) {
            this.mHasMenu = p2;
            if ((this.isAdded()) && (!this.isHidden())) {
                this.mActivity.supportInvalidateOptionsMenu();
            }
        }
        return;
    }

    final void setIndex(int p3, android.support.v4.app.Fragment p4)
    {
        this.mIndex = p3;
        if (p4 == null) {
            this.mWho = new StringBuilder().append("android:fragment:").append(this.mIndex).toString();
        } else {
            this.mWho = new StringBuilder().append(p4.mWho).append(":").append(this.mIndex).toString();
        }
        return;
    }

    public void setInitialSavedState(android.support.v4.app.Fragment$SavedState p3)
    {
        if (this.mIndex < 0) {
            if ((p3 == null) || (p3.mState == null)) {
                android.os.Bundle v0_3 = 0;
            } else {
                v0_3 = p3.mState;
            }
            this.mSavedFragmentState = v0_3;
            return;
        } else {
            throw new IllegalStateException("Fragment already active");
        }
    }

    public void setMenuVisibility(boolean p2)
    {
        if (this.mMenuVisible != p2) {
            this.mMenuVisible = p2;
            if ((this.mHasMenu) && ((this.isAdded()) && (!this.isHidden()))) {
                this.mActivity.supportInvalidateOptionsMenu();
            }
        }
        return;
    }

    public void setRetainInstance(boolean p3)
    {
        if ((!p3) || (this.mParentFragment == null)) {
            this.mRetainInstance = p3;
            return;
        } else {
            throw new IllegalStateException("Can\'t retain fragements that are nested in other fragments");
        }
    }

    public void setTargetFragment(android.support.v4.app.Fragment p1, int p2)
    {
        this.mTarget = p1;
        this.mTargetRequestCode = p2;
        return;
    }

    public void setUserVisibleHint(boolean p3)
    {
        if ((!this.mUserVisibleHint) && ((p3) && (this.mState < 4))) {
            this.mFragmentManager.performPendingDeferredStart(this);
        }
        android.support.v4.app.FragmentManagerImpl v0_1;
        this.mUserVisibleHint = p3;
        if (p3) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        this.mDeferStart = v0_1;
        return;
    }

    public void startActivity(android.content.Intent p4)
    {
        if (this.mActivity != null) {
            this.mActivity.startActivityFromFragment(this, p4, -1);
            return;
        } else {
            throw new IllegalStateException(new StringBuilder().append("Fragment ").append(this).append(" not attached to Activity").toString());
        }
    }

    public void startActivityForResult(android.content.Intent p4, int p5)
    {
        if (this.mActivity != null) {
            this.mActivity.startActivityFromFragment(this, p4, p5);
            return;
        } else {
            throw new IllegalStateException(new StringBuilder().append("Fragment ").append(this).append(" not attached to Activity").toString());
        }
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(128);
        android.support.v4.util.DebugUtils.buildShortClassTag(this, v0_1);
        if (this.mIndex >= 0) {
            v0_1.append(" #");
            v0_1.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            v0_1.append(" id=0x");
            v0_1.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            v0_1.append(" ");
            v0_1.append(this.mTag);
        }
        v0_1.append(125);
        return v0_1.toString();
    }

    public void unregisterForContextMenu(android.view.View p2)
    {
        p2.setOnCreateContextMenuListener(0);
        return;
    }
}
