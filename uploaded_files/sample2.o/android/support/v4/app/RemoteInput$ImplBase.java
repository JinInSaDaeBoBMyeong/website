package android.support.v4.app;
 class RemoteInput$ImplBase implements android.support.v4.app.RemoteInput$Impl {

    RemoteInput$ImplBase()
    {
        return;
    }

    public void addResultsToIntent(android.support.v4.app.RemoteInput[] p3, android.content.Intent p4, android.os.Bundle p5)
    {
        android.util.Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return;
    }

    public android.os.Bundle getResultsFromIntent(android.content.Intent p3)
    {
        android.util.Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return 0;
    }
}
