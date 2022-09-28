package android.support.v4.content;
final class AsyncTaskLoader$LoadTask extends android.support.v4.content.ModernAsyncTask implements java.lang.Runnable {
    private java.util.concurrent.CountDownLatch done;
    Object result;
    final synthetic android.support.v4.content.AsyncTaskLoader this$0;
    boolean waiting;

    AsyncTaskLoader$LoadTask(android.support.v4.content.AsyncTaskLoader p3)
    {
        this.this$0 = p3;
        this.done = new java.util.concurrent.CountDownLatch(1);
        return;
    }

    static synthetic java.util.concurrent.CountDownLatch access$000(android.support.v4.content.AsyncTaskLoader$LoadTask p1)
    {
        return p1.done;
    }

    protected bridge synthetic Object doInBackground(Object[] p2)
    {
        return this.doInBackground(((Void[]) p2));
    }

    protected varargs Object doInBackground(Void[] p2)
    {
        this.result = this.this$0.onLoadInBackground();
        return this.result;
    }

    protected void onCancelled()
    {
        try {
            this.this$0.dispatchOnCancelled(this, this.result);
            this.done.countDown();
            return;
        } catch (Throwable v0_2) {
            this.done.countDown();
            throw v0_2;
        }
    }

    protected void onPostExecute(Object p3)
    {
        try {
            this.this$0.dispatchOnLoadComplete(this, p3);
            this.done.countDown();
            return;
        } catch (Throwable v0_2) {
            this.done.countDown();
            throw v0_2;
        }
    }

    public void run()
    {
        this.waiting = 0;
        this.this$0.executePendingTask();
        return;
    }
}
