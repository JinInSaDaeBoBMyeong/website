package android.support.v4.app;
public class FragmentActivity extends android.app.Activity {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    android.support.v4.util.SimpleArrayMap mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    final android.support.v4.app.FragmentContainer mContainer;
    boolean mCreated;
    final android.support.v4.app.FragmentManagerImpl mFragments;
    final android.os.Handler mHandler;
    android.support.v4.app.LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    public FragmentActivity()
    {
        this.mHandler = new android.support.v4.app.FragmentActivity$1(this);
        this.mFragments = new android.support.v4.app.FragmentManagerImpl();
        this.mContainer = new android.support.v4.app.FragmentActivity$2(this);
        return;
    }

    private void dumpViewHierarchy(String p6, java.io.PrintWriter p7, android.view.View p8)
    {
        p7.print(p6);
        if (p8 != null) {
            p7.println(android.support.v4.app.FragmentActivity.viewToString(p8));
            if ((p8 instanceof android.view.ViewGroup)) {
                int v0 = ((android.view.ViewGroup) p8).getChildCount();
                if (v0 > 0) {
                    String v6_1 = new StringBuilder().append(p6).append("  ").toString();
                    int v2 = 0;
                    while (v2 < v0) {
                        this.dumpViewHierarchy(v6_1, p7, ((android.view.ViewGroup) p8).getChildAt(v2));
                        v2++;
                    }
                }
            }
        } else {
            p7.println("null");
        }
        return;
    }

    private static String viewToString(android.view.View p12)
    {
        int v7 = 70;
        int v8 = 46;
        StringBuilder v2_1 = new StringBuilder(128);
        v2_1.append(p12.getClass().getName());
        v2_1.append(123);
        v2_1.append(Integer.toHexString(System.identityHashCode(p12)));
        v2_1.append(32);
        switch (p12.getVisibility()) {
            case 0:
                v2_1.append(86);
                break;
            case 4:
                v2_1.append(73);
                break;
            case 8:
                v2_1.append(71);
                break;
            default:
                v2_1.append(46);
        }
        String v6_20;
        if (!p12.isFocusable()) {
            v6_20 = 46;
        } else {
            v6_20 = 70;
        }
        String v6_22;
        v2_1.append(v6_20);
        if (!p12.isEnabled()) {
            v6_22 = 46;
        } else {
            v6_22 = 69;
        }
        String v6_24;
        v2_1.append(v6_22);
        if (!p12.willNotDraw()) {
            v6_24 = 68;
        } else {
            v6_24 = 46;
        }
        String v6_26;
        v2_1.append(v6_24);
        if (!p12.isHorizontalScrollBarEnabled()) {
            v6_26 = 46;
        } else {
            v6_26 = 72;
        }
        String v6_28;
        v2_1.append(v6_26);
        if (!p12.isVerticalScrollBarEnabled()) {
            v6_28 = 46;
        } else {
            v6_28 = 86;
        }
        String v6_31;
        v2_1.append(v6_28);
        if (!p12.isClickable()) {
            v6_31 = 46;
        } else {
            v6_31 = 67;
        }
        String v6_33;
        v2_1.append(v6_31);
        if (!p12.isLongClickable()) {
            v6_33 = 46;
        } else {
            v6_33 = 76;
        }
        v2_1.append(v6_33);
        v2_1.append(32);
        if (!p12.isFocused()) {
            v7 = 46;
        }
        String v6_36;
        v2_1.append(v7);
        if (!p12.isSelected()) {
            v6_36 = 46;
        } else {
            v6_36 = 83;
        }
        v2_1.append(v6_36);
        if (p12.isPressed()) {
            v8 = 80;
        }
        v2_1.append(v8);
        v2_1.append(32);
        v2_1.append(p12.getLeft());
        v2_1.append(44);
        v2_1.append(p12.getTop());
        v2_1.append(45);
        v2_1.append(p12.getRight());
        v2_1.append(44);
        v2_1.append(p12.getBottom());
        int v1 = p12.getId();
        if (v1 != -1) {
            v2_1.append(" #");
            v2_1.append(Integer.toHexString(v1));
            android.content.res.Resources v4 = p12.getResources();
            if ((v1 != 0) && (v4 != null)) {
                try {
                    String v3;
                    switch ((-16777216 & v1)) {
                        case 16777216:
                            v3 = "android";
                            String v5 = v4.getResourceTypeName(v1);
                            String v0 = v4.getResourceEntryName(v1);
                            v2_1.append(" ");
                            v2_1.append(v3);
                            v2_1.append(":");
                            v2_1.append(v5);
                            v2_1.append("/");
                            v2_1.append(v0);
                            break;
                        case 2130706432:
                            v3 = "app";
                            break;
                        default:
                            v3 = v4.getResourcePackageName(v1);
                    }
                } catch (String v6) {
                }
            }
        }
        v2_1.append("}");
        return v2_1.toString();
    }

    void doReallyStop(boolean p3)
    {
        if (!this.mReallyStopped) {
            this.mReallyStopped = 1;
            this.mRetaining = p3;
            this.mHandler.removeMessages(1);
            this.onReallyStop();
        }
        return;
    }

    public void dump(String p5, java.io.FileDescriptor p6, java.io.PrintWriter p7, String[] p8)
    {
        // Both branches of the condition point to the same code.
        // if (android.os.Build$VERSION.SDK_INT < 11) {
            p7.print(p5);
            p7.print("Local FragmentActivity ");
            p7.print(Integer.toHexString(System.identityHashCode(this)));
            p7.println(" State:");
            String v0 = new StringBuilder().append(p5).append("  ").toString();
            p7.print(v0);
            p7.print("mCreated=");
            p7.print(this.mCreated);
            p7.print("mResumed=");
            p7.print(this.mResumed);
            p7.print(" mStopped=");
            p7.print(this.mStopped);
            p7.print(" mReallyStopped=");
            p7.println(this.mReallyStopped);
            p7.print(v0);
            p7.print("mLoadersStarted=");
            p7.println(this.mLoadersStarted);
            if (this.mLoaderManager != null) {
                p7.print(p5);
                p7.print("Loader Manager ");
                p7.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
                p7.println(":");
                this.mLoaderManager.dump(new StringBuilder().append(p5).append("  ").toString(), p6, p7, p8);
            }
            this.mFragments.dump(p5, p6, p7, p8);
            p7.print(p5);
            p7.println("View Hierarchy:");
            this.dumpViewHierarchy(new StringBuilder().append(p5).append("  ").toString(), p7, this.getWindow().getDecorView());
            return;
        // }
    }

    public Object getLastCustomNonConfigurationInstance()
    {
        int v1;
        android.support.v4.app.FragmentActivity$NonConfigurationInstances v0_1 = ((android.support.v4.app.FragmentActivity$NonConfigurationInstances) this.getLastNonConfigurationInstance());
        if (v0_1 == null) {
            v1 = 0;
        } else {
            v1 = v0_1.custom;
        }
        return v1;
    }

    android.support.v4.app.LoaderManagerImpl getLoaderManager(String p3, boolean p4, boolean p5)
    {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new android.support.v4.util.SimpleArrayMap();
        }
        android.support.v4.app.LoaderManagerImpl v0_1 = ((android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.get(p3));
        if (v0_1 != null) {
            v0_1.updateActivity(this);
        } else {
            if (p5) {
                v0_1 = new android.support.v4.app.LoaderManagerImpl(p3, this, p4);
                this.mAllLoaderManagers.put(p3, v0_1);
            }
        }
        return v0_1;
    }

    public android.support.v4.app.FragmentManager getSupportFragmentManager()
    {
        return this.mFragments;
    }

    public android.support.v4.app.LoaderManager getSupportLoaderManager()
    {
        android.support.v4.app.LoaderManagerImpl v0_1;
        if (this.mLoaderManager == null) {
            this.mCheckedForLoaderManager = 1;
            this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, 1);
            v0_1 = this.mLoaderManager;
        } else {
            v0_1 = this.mLoaderManager;
        }
        return v0_1;
    }

    void invalidateSupportFragment(String p3)
    {
        if (this.mAllLoaderManagers != null) {
            android.support.v4.app.LoaderManagerImpl v0_1 = ((android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.get(p3));
            if ((v0_1 != null) && (!v0_1.mRetaining)) {
                v0_1.doDestroy();
                this.mAllLoaderManagers.remove(p3);
            }
        }
        return;
    }

    protected void onActivityResult(int p6, int p7, android.content.Intent p8)
    {
        this.mFragments.noteStateNotSaved();
        int v1_0 = (p6 >> 16);
        if (v1_0 == 0) {
            super.onActivityResult(p6, p7, p8);
        } else {
            int v1_1 = (v1_0 - 1);
            if ((this.mFragments.mActive != null) && ((v1_1 >= 0) && (v1_1 < this.mFragments.mActive.size()))) {
                android.support.v4.app.Fragment v0_1 = ((android.support.v4.app.Fragment) this.mFragments.mActive.get(v1_1));
                if (v0_1 != null) {
                    v0_1.onActivityResult((65535 & p6), p7, p8);
                } else {
                    android.util.Log.w("FragmentActivity", new StringBuilder().append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(p6)).toString());
                }
            } else {
                android.util.Log.w("FragmentActivity", new StringBuilder().append("Activity result fragment index out of range: 0x").append(Integer.toHexString(p6)).toString());
            }
        }
        return;
    }

    public void onAttachFragment(android.support.v4.app.Fragment p1)
    {
        return;
    }

    public void onBackPressed()
    {
        if (!this.mFragments.popBackStackImmediate()) {
            this.finish();
        }
        return;
    }

    public void onConfigurationChanged(android.content.res.Configuration p2)
    {
        super.onConfigurationChanged(p2);
        this.mFragments.dispatchConfigurationChanged(p2);
        return;
    }

    protected void onCreate(android.os.Bundle p6)
    {
        java.util.ArrayList v2_0 = 0;
        this.mFragments.attachActivity(this, this.mContainer, 0);
        if (this.getLayoutInflater().getFactory() == null) {
            this.getLayoutInflater().setFactory(this);
        }
        super.onCreate(p6);
        android.support.v4.app.FragmentActivity$NonConfigurationInstances v0_1 = ((android.support.v4.app.FragmentActivity$NonConfigurationInstances) this.getLastNonConfigurationInstance());
        if (v0_1 != null) {
            this.mAllLoaderManagers = v0_1.loaders;
        }
        if (p6 != null) {
            android.os.Parcelable vtmp5 = p6.getParcelable("android:support:fragments");
            if (v0_1 != null) {
                v2_0 = v0_1.fragments;
            }
            this.mFragments.restoreAllState(vtmp5, v2_0);
        }
        this.mFragments.dispatchCreate();
        return;
    }

    public boolean onCreatePanelMenu(int p4, android.view.Menu p5)
    {
        int v0_0;
        if (p4 != 0) {
            v0_0 = super.onCreatePanelMenu(p4, p5);
        } else {
            v0_0 = (super.onCreatePanelMenu(p4, p5) | this.mFragments.dispatchCreateOptionsMenu(p5, this.getMenuInflater()));
            if (android.os.Build$VERSION.SDK_INT < 11) {
                v0_0 = 1;
            }
        }
        return v0_0;
    }

    public android.view.View onCreateView(String p12, android.content.Context p13, android.util.AttributeSet p14)
    {
        android.view.View v7_11;
        android.support.v4.app.Fragment v3 = 0;
        int v1 = 0;
        if ("fragment".equals(p12)) {
            String v2 = p14.getAttributeValue(0, "class");
            android.content.res.TypedArray v0 = p13.obtainStyledAttributes(p14, android.support.v4.app.FragmentActivity$FragmentTag.Fragment);
            if (v2 == null) {
                v2 = v0.getString(0);
            }
            int v4 = v0.getResourceId(1, -1);
            String v6 = v0.getString(2);
            v0.recycle();
            if (android.support.v4.app.Fragment.isSupportFragmentClass(this, v2)) {
                if (0 != 0) {
                    v1 = 0.getId();
                }
                if ((v1 != -1) || ((v4 != -1) || (v6 != null))) {
                    if (v4 != -1) {
                        v3 = this.mFragments.findFragmentById(v4);
                    }
                    if ((v3 == null) && (v6 != null)) {
                        v3 = this.mFragments.findFragmentByTag(v6);
                    }
                    if ((v3 == null) && (v1 != -1)) {
                        v3 = this.mFragments.findFragmentById(v1);
                    }
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentActivity", new StringBuilder().append("onCreateView: id=0x").append(Integer.toHexString(v4)).append(" fname=").append(v2).append(" existing=").append(v3).toString());
                    }
                    if (v3 != null) {
                        if (!v3.mInLayout) {
                            v3.mInLayout = 1;
                            if (!v3.mRetaining) {
                                v3.onInflate(this, p14, v3.mSavedFragmentState);
                            }
                            this.mFragments.moveToState(v3);
                        } else {
                            throw new IllegalArgumentException(new StringBuilder().append(p14.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(v4)).append(", tag ").append(v6).append(", or parent id 0x").append(Integer.toHexString(v1)).append(" with another fragment for ").append(v2).toString());
                        }
                    } else {
                        android.view.View v7_2;
                        v3 = android.support.v4.app.Fragment.instantiate(this, v2);
                        v3.mFromLayout = 1;
                        if (v4 == 0) {
                            v7_2 = v1;
                        } else {
                            v7_2 = v4;
                        }
                        v3.mFragmentId = v7_2;
                        v3.mContainerId = v1;
                        v3.mTag = v6;
                        v3.mInLayout = 1;
                        v3.mFragmentManager = this.mFragments;
                        v3.onInflate(this, p14, v3.mSavedFragmentState);
                        this.mFragments.addFragment(v3, 1);
                    }
                    if (v3.mView != null) {
                        if (v4 != 0) {
                            v3.mView.setId(v4);
                        }
                        if (v3.mView.getTag() == null) {
                            v3.mView.setTag(v6);
                        }
                        v7_11 = v3.mView;
                    } else {
                        throw new IllegalStateException(new StringBuilder().append("Fragment ").append(v2).append(" did not create a view.").toString());
                    }
                } else {
                    throw new IllegalArgumentException(new StringBuilder().append(p14.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(v2).toString());
                }
            } else {
                v7_11 = super.onCreateView(p12, p13, p14);
            }
        } else {
            v7_11 = super.onCreateView(p12, p13, p14);
        }
        return v7_11;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        this.doReallyStop(0);
        this.mFragments.dispatchDestroy();
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
        return;
    }

    public boolean onKeyDown(int p3, android.view.KeyEvent p4)
    {
        if ((android.os.Build$VERSION.SDK_INT >= 5) || ((p3 != 4) || (p4.getRepeatCount() != 0))) {
            int v0_1 = super.onKeyDown(p3, p4);
        } else {
            this.onBackPressed();
            v0_1 = 1;
        }
        return v0_1;
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
        return;
    }

    public boolean onMenuItemSelected(int p2, android.view.MenuItem p3)
    {
        boolean v0_1;
        if (!super.onMenuItemSelected(p2, p3)) {
            switch (p2) {
                case 0:
                    v0_1 = this.mFragments.dispatchOptionsItemSelected(p3);
                    break;
                case 6:
                    v0_1 = this.mFragments.dispatchContextItemSelected(p3);
                    break;
                default:
                    v0_1 = 0;
            }
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    protected void onNewIntent(android.content.Intent p2)
    {
        super.onNewIntent(p2);
        this.mFragments.noteStateNotSaved();
        return;
    }

    public void onPanelClosed(int p2, android.view.Menu p3)
    {
        switch (p2) {
            case 0:
                this.mFragments.dispatchOptionsMenuClosed(p3);
                break;
        }
        super.onPanelClosed(p2, p3);
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mResumed = 0;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            this.onResumeFragments();
        }
        this.mFragments.dispatchPause();
        return;
    }

    protected void onPostResume()
    {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        this.onResumeFragments();
        this.mFragments.execPendingActions();
        return;
    }

    protected boolean onPrepareOptionsPanel(android.view.View p2, android.view.Menu p3)
    {
        return super.onPreparePanel(0, p2, p3);
    }

    public boolean onPreparePanel(int p3, android.view.View p4, android.view.Menu p5)
    {
        if ((p3 != 0) || (p5 == null)) {
            int v0_1 = super.onPreparePanel(p3, p4, p5);
        } else {
            if (this.mOptionsMenuInvalidated) {
                this.mOptionsMenuInvalidated = 0;
                p5.clear();
                this.onCreatePanelMenu(p3, p5);
            }
            v0_1 = (this.onPrepareOptionsPanel(p4, p5) | this.mFragments.dispatchPrepareOptionsMenu(p5));
        }
        return v0_1;
    }

    void onReallyStop()
    {
        if (this.mLoadersStarted) {
            this.mLoadersStarted = 0;
            if (this.mLoaderManager != null) {
                if (this.mRetaining) {
                    this.mLoaderManager.doRetain();
                } else {
                    this.mLoaderManager.doStop();
                }
            }
        }
        this.mFragments.dispatchReallyStop();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = 1;
        this.mFragments.execPendingActions();
        return;
    }

    protected void onResumeFragments()
    {
        this.mFragments.dispatchResume();
        return;
    }

    public Object onRetainCustomNonConfigurationInstance()
    {
        return 0;
    }

    public final Object onRetainNonConfigurationInstance()
    {
        if (this.mStopped) {
            this.doReallyStop(1);
        }
        Object v1 = this.onRetainCustomNonConfigurationInstance();
        java.util.ArrayList v2 = this.mFragments.retainNonConfig();
        int v7 = 0;
        if (this.mAllLoaderManagers != null) {
            int v0 = this.mAllLoaderManagers.size();
            android.support.v4.app.LoaderManagerImpl[] v5 = new android.support.v4.app.LoaderManagerImpl[v0];
            int v3_0 = (v0 - 1);
            while (v3_0 >= 0) {
                v5[v3_0] = ((android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.valueAt(v3_0));
                v3_0--;
            }
            int v3_1 = 0;
            while (v3_1 < v0) {
                android.support.v4.app.LoaderManagerImpl v4 = v5[v3_1];
                if (!v4.mRetaining) {
                    v4.doDestroy();
                    this.mAllLoaderManagers.remove(v4.mWho);
                } else {
                    v7 = 1;
                }
                v3_1++;
            }
        }
        if ((v2 != null) || ((v7 != 0) || (v1 != null))) {
            int v6_1 = new android.support.v4.app.FragmentActivity$NonConfigurationInstances();
            v6_1.activity = 0;
            v6_1.custom = v1;
            v6_1.children = 0;
            v6_1.fragments = v2;
            v6_1.loaders = this.mAllLoaderManagers;
        } else {
            v6_1 = 0;
        }
        return v6_1;
    }

    protected void onSaveInstanceState(android.os.Bundle p3)
    {
        super.onSaveInstanceState(p3);
        android.os.Parcelable v0 = this.mFragments.saveAllState();
        if (v0 != null) {
            p3.putParcelable("android:support:fragments", v0);
        }
        return;
    }

    protected void onStart()
    {
        super.onStart();
        this.mStopped = 0;
        this.mReallyStopped = 0;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = 1;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = 1;
            if (this.mLoaderManager == null) {
                if (!this.mCheckedForLoaderManager) {
                    this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, 0);
                    if ((this.mLoaderManager != null) && (!this.mLoaderManager.mStarted)) {
                        this.mLoaderManager.doStart();
                    }
                }
            } else {
                this.mLoaderManager.doStart();
            }
            this.mCheckedForLoaderManager = 1;
        }
        this.mFragments.dispatchStart();
        if (this.mAllLoaderManagers != null) {
            int v0 = this.mAllLoaderManagers.size();
            android.support.v4.app.LoaderManagerImpl[] v3 = new android.support.v4.app.LoaderManagerImpl[v0];
            int v1_0 = (v0 - 1);
            while (v1_0 >= 0) {
                v3[v1_0] = ((android.support.v4.app.LoaderManagerImpl) this.mAllLoaderManagers.valueAt(v1_0));
                v1_0--;
            }
            int v1_1 = 0;
            while (v1_1 < v0) {
                android.support.v4.app.LoaderManagerImpl v2 = v3[v1_1];
                v2.finishRetain();
                v2.doReportStart();
                v1_1++;
            }
        }
        return;
    }

    protected void onStop()
    {
        super.onStop();
        this.mStopped = 1;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.dispatchStop();
        return;
    }

    public void startActivityForResult(android.content.Intent p3, int p4)
    {
        if ((p4 == -1) || ((-65536 & p4) == 0)) {
            super.startActivityForResult(p3, p4);
            return;
        } else {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void startActivityFromFragment(android.support.v4.app.Fragment p3, android.content.Intent p4, int p5)
    {
        if (p5 != -1) {
            if ((-65536 & p5) == 0) {
                super.startActivityForResult(p4, (((p3.mIndex + 1) << 16) + (65535 & p5)));
            } else {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
        } else {
            super.startActivityForResult(p4, -1);
        }
        return;
    }

    public void supportInvalidateOptionsMenu()
    {
        if (android.os.Build$VERSION.SDK_INT < 11) {
            this.mOptionsMenuInvalidated = 1;
        } else {
            android.support.v4.app.ActivityCompatHoneycomb.invalidateOptionsMenu(this);
        }
        return;
    }
}
