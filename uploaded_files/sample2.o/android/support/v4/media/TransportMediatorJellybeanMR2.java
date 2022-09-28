package android.support.v4.media;
 class TransportMediatorJellybeanMR2 implements android.media.RemoteControlClient$OnGetPlaybackPositionListener, android.media.RemoteControlClient$OnPlaybackPositionUpdateListener {
    android.media.AudioManager$OnAudioFocusChangeListener mAudioFocusChangeListener;
    boolean mAudioFocused;
    final android.media.AudioManager mAudioManager;
    final android.content.Context mContext;
    boolean mFocused;
    final android.content.Intent mIntent;
    final android.content.BroadcastReceiver mMediaButtonReceiver;
    android.app.PendingIntent mPendingIntent;
    int mPlayState;
    final String mReceiverAction;
    final android.content.IntentFilter mReceiverFilter;
    android.media.RemoteControlClient mRemoteControl;
    final android.view.View mTargetView;
    final android.support.v4.media.TransportMediatorCallback mTransportCallback;
    final android.view.ViewTreeObserver$OnWindowAttachListener mWindowAttachListener;
    final android.view.ViewTreeObserver$OnWindowFocusChangeListener mWindowFocusListener;

    public TransportMediatorJellybeanMR2(android.content.Context p3, android.media.AudioManager p4, android.view.View p5, android.support.v4.media.TransportMediatorCallback p6)
    {
        this.mWindowAttachListener = new android.support.v4.media.TransportMediatorJellybeanMR2$1(this);
        this.mWindowFocusListener = new android.support.v4.media.TransportMediatorJellybeanMR2$2(this);
        this.mMediaButtonReceiver = new android.support.v4.media.TransportMediatorJellybeanMR2$3(this);
        this.mAudioFocusChangeListener = new android.support.v4.media.TransportMediatorJellybeanMR2$4(this);
        this.mPlayState = 0;
        this.mContext = p3;
        this.mAudioManager = p4;
        this.mTargetView = p5;
        this.mTransportCallback = p6;
        this.mReceiverAction = new StringBuilder().append(p3.getPackageName()).append(":transport:").append(System.identityHashCode(this)).toString();
        this.mIntent = new android.content.Intent(this.mReceiverAction);
        this.mIntent.setPackage(p3.getPackageName());
        this.mReceiverFilter = new android.content.IntentFilter();
        this.mReceiverFilter.addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
        return;
    }

    public void destroy()
    {
        this.windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
        return;
    }

    void dropAudioFocus()
    {
        if (this.mAudioFocused) {
            this.mAudioFocused = 0;
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
        return;
    }

    void gainFocus()
    {
        if (!this.mFocused) {
            this.mFocused = 1;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if (this.mPlayState == 3) {
                this.takeAudioFocus();
            }
        }
        return;
    }

    public Object getRemoteControlClient()
    {
        return this.mRemoteControl;
    }

    void loseFocus()
    {
        this.dropAudioFocus();
        if (this.mFocused) {
            this.mFocused = 0;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
        return;
    }

    public long onGetPlaybackPosition()
    {
        return this.mTransportCallback.getPlaybackPosition();
    }

    public void onPlaybackPositionUpdate(long p2)
    {
        this.mTransportCallback.playbackPositionUpdate(p2);
        return;
    }

    public void pausePlaying()
    {
        if (this.mPlayState == 3) {
            this.mPlayState = 2;
            this.mRemoteControl.setPlaybackState(2);
        }
        this.dropAudioFocus();
        return;
    }

    public void refreshState(boolean p5, long p6, int p8)
    {
        if (this.mRemoteControl != null) {
            int v1;
            if (!p5) {
                v1 = 1;
            } else {
                v1 = 3;
            }
            android.media.RemoteControlClient v0_1;
            if (!p5) {
                v0_1 = 0;
            } else {
                v0_1 = 1065353216;
            }
            this.mRemoteControl.setPlaybackState(v1, p6, v0_1);
            this.mRemoteControl.setTransportControlFlags(p8);
        }
        return;
    }

    public void startPlaying()
    {
        if (this.mPlayState != 3) {
            this.mPlayState = 3;
            this.mRemoteControl.setPlaybackState(3);
        }
        if (this.mFocused) {
            this.takeAudioFocus();
        }
        return;
    }

    public void stopPlaying()
    {
        if (this.mPlayState != 1) {
            this.mPlayState = 1;
            this.mRemoteControl.setPlaybackState(1);
        }
        this.dropAudioFocus();
        return;
    }

    void takeAudioFocus()
    {
        if (!this.mAudioFocused) {
            this.mAudioFocused = 1;
            this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
        return;
    }

    void windowAttached()
    {
        this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = android.app.PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        this.mRemoteControl = new android.media.RemoteControlClient(this.mPendingIntent);
        this.mRemoteControl.setOnGetPlaybackPositionListener(this);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this);
        return;
    }

    void windowDetached()
    {
        this.loseFocus();
        if (this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = 0;
            this.mRemoteControl = 0;
        }
        return;
    }
}
