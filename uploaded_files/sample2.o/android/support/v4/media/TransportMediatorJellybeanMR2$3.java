package android.support.v4.media;
 class TransportMediatorJellybeanMR2$3 extends android.content.BroadcastReceiver {
    final synthetic android.support.v4.media.TransportMediatorJellybeanMR2 this$0;

    TransportMediatorJellybeanMR2$3(android.support.v4.media.TransportMediatorJellybeanMR2 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onReceive(android.content.Context p4, android.content.Intent p5)
    {
        try {
            this.this$0.mTransportCallback.handleKey(((android.view.KeyEvent) p5.getParcelableExtra("android.intent.extra.KEY_EVENT")));
        } catch (ClassCastException v0) {
            android.util.Log.w("TransportController", v0);
        }
        return;
    }
}
