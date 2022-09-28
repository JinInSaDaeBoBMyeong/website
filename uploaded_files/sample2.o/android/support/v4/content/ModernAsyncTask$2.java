package android.support.v4.content;
 class ModernAsyncTask$2 extends android.support.v4.content.ModernAsyncTask$WorkerRunnable {
    final synthetic android.support.v4.content.ModernAsyncTask this$0;

    ModernAsyncTask$2(android.support.v4.content.ModernAsyncTask p2)
    {
        this.this$0 = p2;
        super(0);
        return;
    }

    public Object call()
    {
        android.support.v4.content.ModernAsyncTask.access$200(this.this$0).set(1);
        android.os.Process.setThreadPriority(10);
        return android.support.v4.content.ModernAsyncTask.access$300(this.this$0, this.this$0.doInBackground(this.mParams));
    }
}
