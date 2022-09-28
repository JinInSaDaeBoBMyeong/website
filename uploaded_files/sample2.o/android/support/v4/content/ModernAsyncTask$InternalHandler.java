package android.support.v4.content;
 class ModernAsyncTask$InternalHandler extends android.os.Handler {

    private ModernAsyncTask$InternalHandler()
    {
        return;
    }

    synthetic ModernAsyncTask$InternalHandler(android.support.v4.content.ModernAsyncTask$1 p1)
    {
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        android.support.v4.content.ModernAsyncTask$AsyncTaskResult v0_1 = ((android.support.v4.content.ModernAsyncTask$AsyncTaskResult) p5.obj);
        switch (p5.what) {
            case 1:
                android.support.v4.content.ModernAsyncTask.access$500(v0_1.mTask, v0_1.mData[0]);
                break;
            case 2:
                v0_1.mTask.onProgressUpdate(v0_1.mData);
                break;
        }
        return;
    }
}
