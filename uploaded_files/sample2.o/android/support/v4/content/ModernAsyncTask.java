package android.support.v4.content;
abstract class ModernAsyncTask {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final java.util.concurrent.Executor THREAD_POOL_EXECUTOR;
    private static volatile java.util.concurrent.Executor sDefaultExecutor;
    private static final android.support.v4.content.ModernAsyncTask$InternalHandler sHandler;
    private static final java.util.concurrent.BlockingQueue sPoolWorkQueue;
    private static final java.util.concurrent.ThreadFactory sThreadFactory;
    private final java.util.concurrent.FutureTask mFuture;
    private volatile android.support.v4.content.ModernAsyncTask$Status mStatus;
    private final java.util.concurrent.atomic.AtomicBoolean mTaskInvoked;
    private final android.support.v4.content.ModernAsyncTask$WorkerRunnable mWorker;

    static ModernAsyncTask()
    {
        android.support.v4.content.ModernAsyncTask.sThreadFactory = new android.support.v4.content.ModernAsyncTask$1();
        android.support.v4.content.ModernAsyncTask.sPoolWorkQueue = new java.util.concurrent.LinkedBlockingQueue(10);
        android.support.v4.content.ModernAsyncTask.THREAD_POOL_EXECUTOR = new java.util.concurrent.ThreadPoolExecutor(5, 128, 1, java.util.concurrent.TimeUnit.SECONDS, android.support.v4.content.ModernAsyncTask.sPoolWorkQueue, android.support.v4.content.ModernAsyncTask.sThreadFactory);
        android.support.v4.content.ModernAsyncTask.sHandler = new android.support.v4.content.ModernAsyncTask$InternalHandler(0);
        android.support.v4.content.ModernAsyncTask.sDefaultExecutor = android.support.v4.content.ModernAsyncTask.THREAD_POOL_EXECUTOR;
        return;
    }

    public ModernAsyncTask()
    {
        this.mStatus = android.support.v4.content.ModernAsyncTask$Status.PENDING;
        this.mTaskInvoked = new java.util.concurrent.atomic.AtomicBoolean();
        this.mWorker = new android.support.v4.content.ModernAsyncTask$2(this);
        this.mFuture = new android.support.v4.content.ModernAsyncTask$3(this, this.mWorker);
        return;
    }

    static synthetic java.util.concurrent.atomic.AtomicBoolean access$200(android.support.v4.content.ModernAsyncTask p1)
    {
        return p1.mTaskInvoked;
    }

    static synthetic Object access$300(android.support.v4.content.ModernAsyncTask p1, Object p2)
    {
        return p1.postResult(p2);
    }

    static synthetic void access$400(android.support.v4.content.ModernAsyncTask p0, Object p1)
    {
        p0.postResultIfNotInvoked(p1);
        return;
    }

    static synthetic void access$500(android.support.v4.content.ModernAsyncTask p0, Object p1)
    {
        p0.finish(p1);
        return;
    }

    public static void execute(Runnable p1)
    {
        android.support.v4.content.ModernAsyncTask.sDefaultExecutor.execute(p1);
        return;
    }

    private void finish(Object p2)
    {
        if (!this.isCancelled()) {
            this.onPostExecute(p2);
        } else {
            this.onCancelled(p2);
        }
        this.mStatus = android.support.v4.content.ModernAsyncTask$Status.FINISHED;
        return;
    }

    public static void init()
    {
        android.support.v4.content.ModernAsyncTask.sHandler.getLooper();
        return;
    }

    private Object postResult(Object p7)
    {
        Object[] v3 = new Object[1];
        v3[0] = p7;
        android.support.v4.content.ModernAsyncTask.sHandler.obtainMessage(1, new android.support.v4.content.ModernAsyncTask$AsyncTaskResult(this, v3)).sendToTarget();
        return p7;
    }

    private void postResultIfNotInvoked(Object p3)
    {
        if (!this.mTaskInvoked.get()) {
            this.postResult(p3);
        }
        return;
    }

    public static void setDefaultExecutor(java.util.concurrent.Executor p0)
    {
        android.support.v4.content.ModernAsyncTask.sDefaultExecutor = p0;
        return;
    }

    public final boolean cancel(boolean p2)
    {
        return this.mFuture.cancel(p2);
    }

    protected abstract varargs Object doInBackground();

    public final varargs android.support.v4.content.ModernAsyncTask execute(Object[] p2)
    {
        return this.executeOnExecutor(android.support.v4.content.ModernAsyncTask.sDefaultExecutor, p2);
    }

    public final varargs android.support.v4.content.ModernAsyncTask executeOnExecutor(java.util.concurrent.Executor p3, Object[] p4)
    {
        if (this.mStatus != android.support.v4.content.ModernAsyncTask$Status.PENDING) {
            switch (android.support.v4.content.ModernAsyncTask$4.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[this.mStatus.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                    break;
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    break;
            }
        }
        this.mStatus = android.support.v4.content.ModernAsyncTask$Status.RUNNING;
        this.onPreExecute();
        this.mWorker.mParams = p4;
        p3.execute(this.mFuture);
        return this;
    }

    public final Object get()
    {
        return this.mFuture.get();
    }

    public final Object get(long p2, java.util.concurrent.TimeUnit p4)
    {
        return this.mFuture.get(p2, p4);
    }

    public final android.support.v4.content.ModernAsyncTask$Status getStatus()
    {
        return this.mStatus;
    }

    public final boolean isCancelled()
    {
        return this.mFuture.isCancelled();
    }

    protected void onCancelled()
    {
        return;
    }

    protected void onCancelled(Object p1)
    {
        this.onCancelled();
        return;
    }

    protected void onPostExecute(Object p1)
    {
        return;
    }

    protected void onPreExecute()
    {
        return;
    }

    protected varargs void onProgressUpdate(Object[] p1)
    {
        return;
    }

    protected final varargs void publishProgress(Object[] p4)
    {
        if (!this.isCancelled()) {
            android.support.v4.content.ModernAsyncTask.sHandler.obtainMessage(2, new android.support.v4.content.ModernAsyncTask$AsyncTaskResult(this, p4)).sendToTarget();
        }
        return;
    }
}
