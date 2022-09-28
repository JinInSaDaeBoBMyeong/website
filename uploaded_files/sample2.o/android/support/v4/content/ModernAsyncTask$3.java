package android.support.v4.content;
 class ModernAsyncTask$3 extends java.util.concurrent.FutureTask {
    final synthetic android.support.v4.content.ModernAsyncTask this$0;

    ModernAsyncTask$3(android.support.v4.content.ModernAsyncTask p1, java.util.concurrent.Callable p2)
    {
        this.this$0 = p1;
        super(p2);
        return;
    }

    protected void done()
    {
        try {
            android.support.v4.content.ModernAsyncTask.access$400(this.this$0, this.get());
        } catch (java.util.concurrent.CancellationException v0_1) {
            android.util.Log.w("AsyncTask", v0_1);
        } catch (java.util.concurrent.CancellationException v0_0) {
            throw new RuntimeException("An error occured while executing doInBackground()", v0_0.getCause());
        } catch (java.util.concurrent.CancellationException v0) {
            android.support.v4.content.ModernAsyncTask.access$400(this.this$0, 0);
        } catch (Throwable v2) {
            throw new RuntimeException("An error occured while executing doInBackground()", v2);
        }
        return;
    }
}
