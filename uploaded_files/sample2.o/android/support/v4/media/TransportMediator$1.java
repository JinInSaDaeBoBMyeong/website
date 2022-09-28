package android.support.v4.media;
 class TransportMediator$1 implements android.support.v4.media.TransportMediatorCallback {
    final synthetic android.support.v4.media.TransportMediator this$0;

    TransportMediator$1(android.support.v4.media.TransportMediator p1)
    {
        this.this$0 = p1;
        return;
    }

    public long getPlaybackPosition()
    {
        return this.this$0.mCallbacks.onGetCurrentPosition();
    }

    public void handleAudioFocusChange(int p2)
    {
        this.this$0.mCallbacks.onAudioFocusChange(p2);
        return;
    }

    public void handleKey(android.view.KeyEvent p2)
    {
        p2.dispatch(this.this$0.mKeyEventCallback);
        return;
    }

    public void playbackPositionUpdate(long p2)
    {
        this.this$0.mCallbacks.onSeekTo(p2);
        return;
    }
}
