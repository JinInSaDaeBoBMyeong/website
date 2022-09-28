package android.support.v4.app;
final class LoaderManagerImpl$LoaderInfo implements android.support.v4.content.Loader$OnLoadCompleteListener {
    final android.os.Bundle mArgs;
    android.support.v4.app.LoaderManager$LoaderCallbacks mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    android.support.v4.content.Loader mLoader;
    android.support.v4.app.LoaderManagerImpl$LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final synthetic android.support.v4.app.LoaderManagerImpl this$0;

    public LoaderManagerImpl$LoaderInfo(android.support.v4.app.LoaderManagerImpl p1, int p2, android.os.Bundle p3, android.support.v4.app.LoaderManager$LoaderCallbacks p4)
    {
        this.this$0 = p1;
        this.mId = p2;
        this.mArgs = p3;
        this.mCallbacks = p4;
        return;
    }

    void callOnLoadFinished(android.support.v4.content.Loader p5, Object p6)
    {
        if (this.mCallbacks != null) {
            String v0 = 0;
            if (this.this$0.mActivity != null) {
                v0 = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
                this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
            }
            try {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v("LoaderManager", new StringBuilder().append("  onLoadFinished in ").append(p5).append(": ").append(p5.dataToString(p6)).toString());
                }
            } catch (int v1_7) {
                if (this.this$0.mActivity != null) {
                    this.this$0.mActivity.mFragments.mNoTransactionsBecause = v0;
                }
                throw v1_7;
            }
            this.mCallbacks.onLoadFinished(p5, p6);
            if (this.this$0.mActivity != null) {
                this.this$0.mActivity.mFragments.mNoTransactionsBecause = v0;
            }
            this.mDeliveredData = 1;
        }
        return;
    }

    void destroy()
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("  Destroying: ").append(this).toString());
        }
        this.mDestroyed = 1;
        boolean v1 = this.mDeliveredData;
        this.mDeliveredData = 0;
        if ((this.mCallbacks != null) && ((this.mLoader != null) && ((this.mHaveData) && (v1)))) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("  Reseting: ").append(this).toString());
            }
            String v0 = 0;
            if (this.this$0.mActivity != null) {
                v0 = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
                this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
            }
            try {
                this.mCallbacks.onLoaderReset(this.mLoader);
            } catch (android.support.v4.app.FragmentManagerImpl v2_19) {
                if (this.this$0.mActivity != null) {
                    this.this$0.mActivity.mFragments.mNoTransactionsBecause = v0;
                }
                throw v2_19;
            }
            if (this.this$0.mActivity != null) {
                this.this$0.mActivity.mFragments.mNoTransactionsBecause = v0;
            }
        }
        this.mCallbacks = 0;
        this.mData = 0;
        this.mHaveData = 0;
        if (this.mLoader != null) {
            if (this.mListenerRegistered) {
                this.mListenerRegistered = 0;
                this.mLoader.unregisterListener(this);
            }
            this.mLoader.reset();
        }
        if (this.mPendingLoader != null) {
            this.mPendingLoader.destroy();
        }
        return;
    }

    public void dump(String p4, java.io.FileDescriptor p5, java.io.PrintWriter p6, String[] p7)
    {
        p6.print(p4);
        p6.print("mId=");
        p6.print(this.mId);
        p6.print(" mArgs=");
        p6.println(this.mArgs);
        p6.print(p4);
        p6.print("mCallbacks=");
        p6.println(this.mCallbacks);
        p6.print(p4);
        p6.print("mLoader=");
        p6.println(this.mLoader);
        if (this.mLoader != null) {
            this.mLoader.dump(new StringBuilder().append(p4).append("  ").toString(), p5, p6, p7);
        }
        if ((this.mHaveData) || (this.mDeliveredData)) {
            p6.print(p4);
            p6.print("mHaveData=");
            p6.print(this.mHaveData);
            p6.print("  mDeliveredData=");
            p6.println(this.mDeliveredData);
            p6.print(p4);
            p6.print("mData=");
            p6.println(this.mData);
        }
        p6.print(p4);
        p6.print("mStarted=");
        p6.print(this.mStarted);
        p6.print(" mReportNextStart=");
        p6.print(this.mReportNextStart);
        p6.print(" mDestroyed=");
        p6.println(this.mDestroyed);
        p6.print(p4);
        p6.print("mRetaining=");
        p6.print(this.mRetaining);
        p6.print(" mRetainingStarted=");
        p6.print(this.mRetainingStarted);
        p6.print(" mListenerRegistered=");
        p6.println(this.mListenerRegistered);
        if (this.mPendingLoader != null) {
            p6.print(p4);
            p6.println("Pending Loader ");
            p6.print(this.mPendingLoader);
            p6.println(":");
            this.mPendingLoader.dump(new StringBuilder().append(p4).append("  ").toString(), p5, p6, p7);
        }
        return;
    }

    void finishRetain()
    {
        if (this.mRetaining) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("  Finished Retaining: ").append(this).toString());
            }
            this.mRetaining = 0;
            if ((this.mStarted != this.mRetainingStarted) && (!this.mStarted)) {
                this.stop();
            }
        }
        if ((this.mStarted) && ((this.mHaveData) && (!this.mReportNextStart))) {
            this.callOnLoadFinished(this.mLoader, this.mData);
        }
        return;
    }

    public void onLoadComplete(android.support.v4.content.Loader p7, Object p8)
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("onLoadComplete: ").append(this).toString());
        }
        if (!this.mDestroyed) {
            if (this.this$0.mLoaders.get(this.mId) == this) {
                android.support.v4.app.LoaderManagerImpl$LoaderInfo v1 = this.mPendingLoader;
                if (v1 == null) {
                    if ((this.mData != p8) || (!this.mHaveData)) {
                        this.mData = p8;
                        this.mHaveData = 1;
                        if (this.mStarted) {
                            this.callOnLoadFinished(p7, p8);
                        }
                    }
                    android.support.v4.app.LoaderManagerImpl$LoaderInfo v0_1 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.this$0.mInactiveLoaders.get(this.mId));
                    if ((v0_1 != null) && (v0_1 != this)) {
                        v0_1.mDeliveredData = 0;
                        v0_1.destroy();
                        this.this$0.mInactiveLoaders.remove(this.mId);
                    }
                    if ((this.this$0.mActivity != null) && (!this.this$0.hasRunningLoaders())) {
                        this.this$0.mActivity.mFragments.startPendingDeferredFragments();
                    }
                } else {
                    if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                        android.util.Log.v("LoaderManager", new StringBuilder().append("  Switching to pending loader: ").append(v1).toString());
                    }
                    this.mPendingLoader = 0;
                    this.this$0.mLoaders.put(this.mId, 0);
                    this.destroy();
                    this.this$0.installLoader(v1);
                }
            } else {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v("LoaderManager", "  Ignoring load complete -- not active");
                }
            }
        } else {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        }
        return;
    }

    void reportStart()
    {
        if ((this.mStarted) && (this.mReportNextStart)) {
            this.mReportNextStart = 0;
            if (this.mHaveData) {
                this.callOnLoadFinished(this.mLoader, this.mData);
            }
        }
        return;
    }

    void retain()
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("  Retaining: ").append(this).toString());
        }
        this.mRetaining = 1;
        this.mRetainingStarted = this.mStarted;
        this.mStarted = 0;
        this.mCallbacks = 0;
        return;
    }

    void start()
    {
        if ((!this.mRetaining) || (!this.mRetainingStarted)) {
            if (!this.mStarted) {
                this.mStarted = 1;
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v("LoaderManager", new StringBuilder().append("  Starting: ").append(this).toString());
                }
                if ((this.mLoader == null) && (this.mCallbacks != null)) {
                    this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
                }
                if (this.mLoader != null) {
                    if ((!this.mLoader.getClass().isMemberClass()) || (reflect.Modifier.isStatic(this.mLoader.getClass().getModifiers()))) {
                        if (!this.mListenerRegistered) {
                            this.mLoader.registerListener(this.mId, this);
                            this.mListenerRegistered = 1;
                        }
                        this.mLoader.startLoading();
                    } else {
                        throw new IllegalArgumentException(new StringBuilder().append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(this.mLoader).toString());
                    }
                }
            }
        } else {
            this.mStarted = 1;
        }
        return;
    }

    void stop()
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("  Stopping: ").append(this).toString());
        }
        this.mStarted = 0;
        if ((!this.mRetaining) && ((this.mLoader != null) && (this.mListenerRegistered))) {
            this.mListenerRegistered = 0;
            this.mLoader.unregisterListener(this);
            this.mLoader.stopLoading();
        }
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(64);
        v0_1.append("LoaderInfo{");
        v0_1.append(Integer.toHexString(System.identityHashCode(this)));
        v0_1.append(" #");
        v0_1.append(this.mId);
        v0_1.append(" : ");
        android.support.v4.util.DebugUtils.buildShortClassTag(this.mLoader, v0_1);
        v0_1.append("}}");
        return v0_1.toString();
    }
}
