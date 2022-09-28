package android.support.v4.content;
public abstract class AsyncTaskLoader extends android.support.v4.content.Loader {
    static final boolean DEBUG = False;
    static final String TAG = "AsyncTaskLoader";
    volatile android.support.v4.content.AsyncTaskLoader$LoadTask mCancellingTask;
    android.os.Handler mHandler;
    long mLastLoadCompleteTime;
    volatile android.support.v4.content.AsyncTaskLoader$LoadTask mTask;
    long mUpdateThrottle;

    public AsyncTaskLoader(android.content.Context p3)
    {
        super(p3);
        super.mLastLoadCompleteTime = -10000;
        return;
    }

    public boolean cancelLoad()
    {
        boolean v0 = 0;
        if (this.mTask != null) {
            if (this.mCancellingTask == null) {
                if (!this.mTask.waiting) {
                    v0 = this.mTask.cancel(0);
                    if (v0) {
                        this.mCancellingTask = this.mTask;
                    }
                    this.mTask = 0;
                } else {
                    this.mTask.waiting = 0;
                    this.mHandler.removeCallbacks(this.mTask);
                    this.mTask = 0;
                }
            } else {
                if (this.mTask.waiting) {
                    this.mTask.waiting = 0;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = 0;
            }
        }
        return v0;
    }

    void dispatchOnCancelled(android.support.v4.content.AsyncTaskLoader$LoadTask p3, Object p4)
    {
        this.onCanceled(p4);
        if (this.mCancellingTask == p3) {
            this.rollbackContentChanged();
            this.mLastLoadCompleteTime = android.os.SystemClock.uptimeMillis();
            this.mCancellingTask = 0;
            this.executePendingTask();
        }
        return;
    }

    void dispatchOnLoadComplete(android.support.v4.content.AsyncTaskLoader$LoadTask p3, Object p4)
    {
        if (this.mTask == p3) {
            if (!this.isAbandoned()) {
                this.commitContentChanged();
                this.mLastLoadCompleteTime = android.os.SystemClock.uptimeMillis();
                this.mTask = 0;
                this.deliverResult(p4);
            } else {
                this.onCanceled(p4);
            }
        } else {
            this.dispatchOnCancelled(p3, p4);
        }
        return;
    }

    public void dump(String p5, java.io.FileDescriptor p6, java.io.PrintWriter p7, String[] p8)
    {
        super.dump(p5, p6, p7, p8);
        if (this.mTask != null) {
            p7.print(p5);
            p7.print("mTask=");
            p7.print(this.mTask);
            p7.print(" waiting=");
            p7.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            p7.print(p5);
            p7.print("mCancellingTask=");
            p7.print(this.mCancellingTask);
            p7.print(" waiting=");
            p7.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0) {
            p7.print(p5);
            p7.print("mUpdateThrottle=");
            android.support.v4.util.TimeUtils.formatDuration(this.mUpdateThrottle, p7);
            p7.print(" mLastLoadCompleteTime=");
            android.support.v4.util.TimeUtils.formatDuration(this.mLastLoadCompleteTime, android.os.SystemClock.uptimeMillis(), p7);
            p7.println();
        }
        return;
    }

    void executePendingTask()
    {
        if ((this.mCancellingTask == null) && (this.mTask != null)) {
            if (this.mTask.waiting) {
                this.mTask.waiting = 0;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if ((this.mUpdateThrottle <= 0) || (android.os.SystemClock.uptimeMillis() >= (this.mLastLoadCompleteTime + this.mUpdateThrottle))) {
                this.mTask.executeOnExecutor(android.support.v4.content.ModernAsyncTask.THREAD_POOL_EXECUTOR, ((Void[]) 0));
            } else {
                this.mTask.waiting = 1;
                this.mHandler.postAtTime(this.mTask, (this.mLastLoadCompleteTime + this.mUpdateThrottle));
            }
        }
        return;
    }

    public abstract Object loadInBackground();

    public void onCanceled(Object p1)
    {
        return;
    }

    protected void onForceLoad()
    {
        super.onForceLoad();
        this.cancelLoad();
        this.mTask = new android.support.v4.content.AsyncTaskLoader$LoadTask(this);
        this.executePendingTask();
        return;
    }

    protected Object onLoadInBackground()
    {
        return this.loadInBackground();
    }

    public void setUpdateThrottle(long p4)
    {
        this.mUpdateThrottle = p4;
        if (p4 != 0) {
            this.mHandler = new android.os.Handler();
        }
        return;
    }

    public void waitForLoader()
    {
        android.support.v4.content.AsyncTaskLoader$LoadTask v0 = this.mTask;
        if (v0 != null) {
            try {
                android.support.v4.content.AsyncTaskLoader$LoadTask.access$000(v0).await();
            } catch (InterruptedException v1) {
            }
        }
        return;
    }
}
