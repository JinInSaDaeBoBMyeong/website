package android.support.v4.content;
 class IntentCompat$IntentCompatImplBase implements android.support.v4.content.IntentCompat$IntentCompatImpl {

    IntentCompat$IntentCompatImplBase()
    {
        return;
    }

    public android.content.Intent makeMainActivity(android.content.ComponentName p3)
    {
        android.content.Intent v0_1 = new android.content.Intent("android.intent.action.MAIN");
        v0_1.setComponent(p3);
        v0_1.addCategory("android.intent.category.LAUNCHER");
        return v0_1;
    }

    public android.content.Intent makeMainSelectorActivity(String p2, String p3)
    {
        android.content.Intent v0_1 = new android.content.Intent(p2);
        v0_1.addCategory(p3);
        return v0_1;
    }

    public android.content.Intent makeRestartActivityTask(android.content.ComponentName p3)
    {
        android.content.Intent v0 = this.makeMainActivity(p3);
        v0.addFlags(268468224);
        return v0;
    }
}
