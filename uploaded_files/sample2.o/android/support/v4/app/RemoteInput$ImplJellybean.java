package android.support.v4.app;
 class RemoteInput$ImplJellybean implements android.support.v4.app.RemoteInput$Impl {

    RemoteInput$ImplJellybean()
    {
        return;
    }

    public void addResultsToIntent(android.support.v4.app.RemoteInput[] p1, android.content.Intent p2, android.os.Bundle p3)
    {
        android.support.v4.app.RemoteInputCompatJellybean.addResultsToIntent(p1, p2, p3);
        return;
    }

    public android.os.Bundle getResultsFromIntent(android.content.Intent p2)
    {
        return android.support.v4.app.RemoteInputCompatJellybean.getResultsFromIntent(p2);
    }
}
