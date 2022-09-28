package android.support.v4.content;
 class IntentCompat$IntentCompatImplHC extends android.support.v4.content.IntentCompat$IntentCompatImplBase {

    IntentCompat$IntentCompatImplHC()
    {
        return;
    }

    public android.content.Intent makeMainActivity(android.content.ComponentName p2)
    {
        return android.support.v4.content.IntentCompatHoneycomb.makeMainActivity(p2);
    }

    public android.content.Intent makeRestartActivityTask(android.content.ComponentName p2)
    {
        return android.support.v4.content.IntentCompatHoneycomb.makeRestartActivityTask(p2);
    }
}
