package android.support.v4.app;
 class LoaderManagerImpl extends android.support.v4.app.LoaderManager {
    static boolean DEBUG = False;
    static final String TAG = "LoaderManager";
    android.support.v4.app.FragmentActivity mActivity;
    boolean mCreatingLoader;
    final android.support.v4.util.SparseArrayCompat mInactiveLoaders;
    final android.support.v4.util.SparseArrayCompat mLoaders;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;

    static LoaderManagerImpl()
    {
        android.support.v4.app.LoaderManagerImpl.DEBUG = 0;
        return;
    }

    LoaderManagerImpl(String p2, android.support.v4.app.FragmentActivity p3, boolean p4)
    {
        this.mLoaders = new android.support.v4.util.SparseArrayCompat();
        this.mInactiveLoaders = new android.support.v4.util.SparseArrayCompat();
        this.mWho = p2;
        this.mActivity = p3;
        this.mStarted = p4;
        return;
    }

    private android.support.v4.app.LoaderManagerImpl$LoaderInfo createAndInstallLoader(int p4, android.os.Bundle p5, android.support.v4.app.LoaderManager$LoaderCallbacks p6)
    {
        try {
            this.mCreatingLoader = 1;
            android.support.v4.app.LoaderManagerImpl$LoaderInfo v0 = this.createLoader(p4, p5, p6);
            this.installLoader(v0);
            this.mCreatingLoader = 0;
            return v0;
        } catch (Throwable v1_1) {
            this.mCreatingLoader = 0;
            throw v1_1;
        }
    }

    private android.support.v4.app.LoaderManagerImpl$LoaderInfo createLoader(int p3, android.os.Bundle p4, android.support.v4.app.LoaderManager$LoaderCallbacks p5)
    {
        android.support.v4.app.LoaderManagerImpl$LoaderInfo v0_1 = new android.support.v4.app.LoaderManagerImpl$LoaderInfo(this, p3, p4, p5);
        v0_1.mLoader = p5.onCreateLoader(p3, p4);
        return v0_1;
    }

    public void destroyLoader(int p6)
    {
        if (!this.mCreatingLoader) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("destroyLoader in ").append(this).append(" of ").append(p6).toString());
            }
            int v0_0 = this.mLoaders.indexOfKey(p6);
            if (v0_0 >= 0) {
                android.support.v4.app.LoaderManagerImpl$LoaderInfo v1_1 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v0_0));
                this.mLoaders.removeAt(v0_0);
                v1_1.destroy();
            }
            int v0_1 = this.mInactiveLoaders.indexOfKey(p6);
            if (v0_1 >= 0) {
                android.support.v4.app.LoaderManagerImpl$LoaderInfo v1_3 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mInactiveLoaders.valueAt(v0_1));
                this.mInactiveLoaders.removeAt(v0_1);
                v1_3.destroy();
            }
            if ((this.mActivity != null) && (!this.hasRunningLoaders())) {
                this.mActivity.mFragments.startPendingDeferredFragments();
            }
            return;
        } else {
            throw new IllegalStateException("Called while creating a loader");
        }
    }

    void doDestroy()
    {
        if (!this.mRetaining) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("Destroying Active in ").append(this).toString());
            }
            int v0_0 = (this.mLoaders.size() - 1);
            while (v0_0 >= 0) {
                ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v0_0)).destroy();
                v0_0--;
            }
            this.mLoaders.clear();
        }
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("Destroying Inactive in ").append(this).toString());
        }
        int v0_1 = (this.mInactiveLoaders.size() - 1);
        while (v0_1 >= 0) {
            ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mInactiveLoaders.valueAt(v0_1)).destroy();
            v0_1--;
        }
        this.mInactiveLoaders.clear();
        return;
    }

    void doReportNextStart()
    {
        int v0 = (this.mLoaders.size() - 1);
        while (v0 >= 0) {
            ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v0)).mReportNextStart = 1;
            v0--;
        }
        return;
    }

    void doReportStart()
    {
        int v0 = (this.mLoaders.size() - 1);
        while (v0 >= 0) {
            ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v0)).reportStart();
            v0--;
        }
        return;
    }

    void doRetain()
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("Retaining in ").append(this).toString());
        }
        if (this.mStarted) {
            this.mRetaining = 1;
            this.mStarted = 0;
            int v1 = (this.mLoaders.size() - 1);
            while (v1 >= 0) {
                ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v1)).retain();
                v1--;
            }
        } else {
            RuntimeException v0_1 = new RuntimeException("here");
            v0_1.fillInStackTrace();
            android.util.Log.w("LoaderManager", new StringBuilder().append("Called doRetain when not started: ").append(this).toString(), v0_1);
        }
        return;
    }

    void doStart()
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("Starting in ").append(this).toString());
        }
        if (!this.mStarted) {
            this.mStarted = 1;
            int v1 = (this.mLoaders.size() - 1);
            while (v1 >= 0) {
                ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v1)).start();
                v1--;
            }
        } else {
            RuntimeException v0_1 = new RuntimeException("here");
            v0_1.fillInStackTrace();
            android.util.Log.w("LoaderManager", new StringBuilder().append("Called doStart when already started: ").append(this).toString(), v0_1);
        }
        return;
    }

    void doStop()
    {
        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
            android.util.Log.v("LoaderManager", new StringBuilder().append("Stopping in ").append(this).toString());
        }
        if (this.mStarted) {
            int v1 = (this.mLoaders.size() - 1);
            while (v1 >= 0) {
                ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v1)).stop();
                v1--;
            }
            this.mStarted = 0;
        } else {
            RuntimeException v0_1 = new RuntimeException("here");
            v0_1.fillInStackTrace();
            android.util.Log.w("LoaderManager", new StringBuilder().append("Called doStop when not started: ").append(this).toString(), v0_1);
        }
        return;
    }

    public void dump(String p6, java.io.FileDescriptor p7, java.io.PrintWriter p8, String[] p9)
    {
        if (this.mLoaders.size() > 0) {
            p8.print(p6);
            p8.println("Active Loaders:");
            String v1_0 = new StringBuilder().append(p6).append("    ").toString();
            int v0_0 = 0;
            while (v0_0 < this.mLoaders.size()) {
                android.support.v4.app.LoaderManagerImpl$LoaderInfo v2_3 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v0_0));
                p8.print(p6);
                p8.print("  #");
                p8.print(this.mLoaders.keyAt(v0_0));
                p8.print(": ");
                p8.println(v2_3.toString());
                v2_3.dump(v1_0, p7, p8, p9);
                v0_0++;
            }
        }
        if (this.mInactiveLoaders.size() > 0) {
            p8.print(p6);
            p8.println("Inactive Loaders:");
            String v1_1 = new StringBuilder().append(p6).append("    ").toString();
            int v0_1 = 0;
            while (v0_1 < this.mInactiveLoaders.size()) {
                android.support.v4.app.LoaderManagerImpl$LoaderInfo v2_1 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mInactiveLoaders.valueAt(v0_1));
                p8.print(p6);
                p8.print("  #");
                p8.print(this.mInactiveLoaders.keyAt(v0_1));
                p8.print(": ");
                p8.println(v2_1.toString());
                v2_1.dump(v1_1, p7, p8, p9);
                v0_1++;
            }
        }
        return;
    }

    void finishRetain()
    {
        if (this.mRetaining) {
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("Finished Retaining in ").append(this).toString());
            }
            this.mRetaining = 0;
            int v0 = (this.mLoaders.size() - 1);
            while (v0 >= 0) {
                ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v0)).finishRetain();
                v0--;
            }
        }
        return;
    }

    public android.support.v4.content.Loader getLoader(int p4)
    {
        if (!this.mCreatingLoader) {
            android.support.v4.content.Loader v1_1;
            android.support.v4.app.LoaderManagerImpl$LoaderInfo v0_1 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.get(p4));
            if (v0_1 == null) {
                v1_1 = 0;
            } else {
                if (v0_1.mPendingLoader == null) {
                    v1_1 = v0_1.mLoader;
                } else {
                    v1_1 = v0_1.mPendingLoader.mLoader;
                }
            }
            return v1_1;
        } else {
            throw new IllegalStateException("Called while creating a loader");
        }
    }

    public boolean hasRunningLoaders()
    {
        int v3 = 0;
        int v0 = this.mLoaders.size();
        int v1 = 0;
        while (v1 < v0) {
            int v4_3;
            android.support.v4.app.LoaderManagerImpl$LoaderInfo v2_0 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.valueAt(v1));
            if ((!v2_0.mStarted) || (v2_0.mDeliveredData)) {
                v4_3 = 0;
            } else {
                v4_3 = 1;
            }
            v3 |= v4_3;
            v1++;
        }
        return v3;
    }

    public android.support.v4.content.Loader initLoader(int p5, android.os.Bundle p6, android.support.v4.app.LoaderManager$LoaderCallbacks p7)
    {
        if (!this.mCreatingLoader) {
            android.support.v4.app.LoaderManagerImpl$LoaderInfo v0_1 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.get(p5));
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("initLoader in ").append(this).append(": args=").append(p6).toString());
            }
            if (v0_1 != null) {
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v("LoaderManager", new StringBuilder().append("  Re-using existing loader ").append(v0_1).toString());
                }
                v0_1.mCallbacks = p7;
            } else {
                v0_1 = this.createAndInstallLoader(p5, p6, p7);
                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                    android.util.Log.v("LoaderManager", new StringBuilder().append("  Created new loader ").append(v0_1).toString());
                }
            }
            if ((v0_1.mHaveData) && (this.mStarted)) {
                v0_1.callOnLoadFinished(v0_1.mLoader, v0_1.mData);
            }
            return v0_1.mLoader;
        } else {
            throw new IllegalStateException("Called while creating a loader");
        }
    }

    void installLoader(android.support.v4.app.LoaderManagerImpl$LoaderInfo p3)
    {
        this.mLoaders.put(p3.mId, p3);
        if (this.mStarted) {
            p3.start();
        }
        return;
    }

    public android.support.v4.content.Loader restartLoader(int p7, android.os.Bundle p8, android.support.v4.app.LoaderManager$LoaderCallbacks p9)
    {
        if (!this.mCreatingLoader) {
            android.support.v4.app.LoaderManagerImpl$LoaderInfo v1_2 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mLoaders.get(p7));
            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                android.util.Log.v("LoaderManager", new StringBuilder().append("restartLoader in ").append(this).append(": args=").append(p8).toString());
            }
            android.support.v4.content.Loader v2_4;
            if (v1_2 == null) {
                v2_4 = this.createAndInstallLoader(p7, p8, p9).mLoader;
            } else {
                android.support.v4.app.LoaderManagerImpl$LoaderInfo v0_1 = ((android.support.v4.app.LoaderManagerImpl$LoaderInfo) this.mInactiveLoaders.get(p7));
                if (v0_1 == null) {
                    if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                        android.util.Log.v("LoaderManager", new StringBuilder().append("  Making last loader inactive: ").append(v1_2).toString());
                    }
                    v1_2.mLoader.abandon();
                    this.mInactiveLoaders.put(p7, v1_2);
                } else {
                    if (!v1_2.mHaveData) {
                        if (v1_2.mStarted) {
                            if (v1_2.mPendingLoader != null) {
                                if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                                    android.util.Log.v("LoaderManager", new StringBuilder().append("  Removing pending loader: ").append(v1_2.mPendingLoader).toString());
                                }
                                v1_2.mPendingLoader.destroy();
                                v1_2.mPendingLoader = 0;
                            }
                            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                                android.util.Log.v("LoaderManager", "  Enqueuing as new pending loader");
                            }
                            v1_2.mPendingLoader = this.createLoader(p7, p8, p9);
                            v2_4 = v1_2.mPendingLoader.mLoader;
                        } else {
                            if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                                android.util.Log.v("LoaderManager", "  Current loader is stopped; replacing");
                            }
                            this.mLoaders.put(p7, 0);
                            v1_2.destroy();
                        }
                    } else {
                        if (android.support.v4.app.LoaderManagerImpl.DEBUG) {
                            android.util.Log.v("LoaderManager", new StringBuilder().append("  Removing last inactive loader: ").append(v1_2).toString());
                        }
                        v0_1.mDeliveredData = 0;
                        v0_1.destroy();
                        v1_2.mLoader.abandon();
                        this.mInactiveLoaders.put(p7, v1_2);
                    }
                }
            }
            return v2_4;
        } else {
            throw new IllegalStateException("Called while creating a loader");
        }
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(128);
        v0_1.append("LoaderManager{");
        v0_1.append(Integer.toHexString(System.identityHashCode(this)));
        v0_1.append(" in ");
        android.support.v4.util.DebugUtils.buildShortClassTag(this.mActivity, v0_1);
        v0_1.append("}}");
        return v0_1.toString();
    }

    void updateActivity(android.support.v4.app.FragmentActivity p1)
    {
        this.mActivity = p1;
        return;
    }
}
