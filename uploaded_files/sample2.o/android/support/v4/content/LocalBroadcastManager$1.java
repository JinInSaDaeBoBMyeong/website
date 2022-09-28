package android.support.v4.content;
 class LocalBroadcastManager$1 extends android.os.Handler {
    final synthetic android.support.v4.content.LocalBroadcastManager this$0;

    LocalBroadcastManager$1(android.support.v4.content.LocalBroadcastManager p1, android.os.Looper p2)
    {
        this.this$0 = p1;
        super(p2);
        return;
    }

    public void handleMessage(android.os.Message p2)
    {
        switch (p2.what) {
            case 1:
                android.support.v4.content.LocalBroadcastManager.access$000(this.this$0);
                break;
            default:
                super.handleMessage(p2);
        }
        return;
    }
}
