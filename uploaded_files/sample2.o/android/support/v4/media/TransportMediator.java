package android.support.v4.media;
public class TransportMediator extends android.support.v4.media.TransportController {
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    final android.media.AudioManager mAudioManager;
    final android.support.v4.media.TransportPerformer mCallbacks;
    final android.content.Context mContext;
    final android.support.v4.media.TransportMediatorJellybeanMR2 mController;
    final Object mDispatcherState;
    final android.view.KeyEvent$Callback mKeyEventCallback;
    final java.util.ArrayList mListeners;
    final android.support.v4.media.TransportMediatorCallback mTransportKeyCallback;
    final android.view.View mView;

    public TransportMediator(android.app.Activity p2, android.support.v4.media.TransportPerformer p3)
    {
        this(p2, 0, p3);
        return;
    }

    private TransportMediator(android.app.Activity p6, android.view.View p7, android.support.v4.media.TransportPerformer p8)
    {
        int v0_1;
        this.mListeners = new java.util.ArrayList();
        this.mTransportKeyCallback = new android.support.v4.media.TransportMediator$1(this);
        this.mKeyEventCallback = new android.support.v4.media.TransportMediator$2(this);
        if (p6 == null) {
            v0_1 = p7.getContext();
        } else {
            v0_1 = p6;
        }
        this.mContext = v0_1;
        this.mCallbacks = p8;
        this.mAudioManager = ((android.media.AudioManager) this.mContext.getSystemService("audio"));
        if (p6 != null) {
            p7 = p6.getWindow().getDecorView();
        }
        this.mView = p7;
        this.mDispatcherState = android.support.v4.view.KeyEventCompat.getKeyDispatcherState(this.mView);
        if (android.os.Build$VERSION.SDK_INT < 18) {
            this.mController = 0;
        } else {
            this.mController = new android.support.v4.media.TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback);
        }
        return;
    }

    public TransportMediator(android.view.View p2, android.support.v4.media.TransportPerformer p3)
    {
        this(0, p2, p3);
        return;
    }

    private android.support.v4.media.TransportStateListener[] getListeners()
    {
        android.support.v4.media.TransportStateListener[] v0;
        if (this.mListeners.size() > 0) {
            v0 = new android.support.v4.media.TransportStateListener[this.mListeners.size()];
            this.mListeners.toArray(v0);
        } else {
            v0 = 0;
        }
        return v0;
    }

    static boolean isMediaKey(int p1)
    {
        int v0;
        switch (p1) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 130:
                v0 = 1;
                break;
            default:
                v0 = 0;
        }
        return v0;
    }

    private void pushControllerState()
    {
        if (this.mController != null) {
            this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
        }
        return;
    }

    private void reportPlayingChanged()
    {
        android.support.v4.media.TransportStateListener[] v4 = this.getListeners();
        if (v4 != null) {
            android.support.v4.media.TransportStateListener[] v0 = v4;
            int v2 = v0.length;
            int v1 = 0;
            while (v1 < v2) {
                v0[v1].onPlayingChanged(this);
                v1++;
            }
        }
        return;
    }

    private void reportTransportControlsChanged()
    {
        android.support.v4.media.TransportStateListener[] v4 = this.getListeners();
        if (v4 != null) {
            android.support.v4.media.TransportStateListener[] v0 = v4;
            int v2 = v0.length;
            int v1 = 0;
            while (v1 < v2) {
                v0[v1].onTransportControlsChanged(this);
                v1++;
            }
        }
        return;
    }

    public void destroy()
    {
        this.mController.destroy();
        return;
    }

    public boolean dispatchKeyEvent(android.view.KeyEvent p3)
    {
        return android.support.v4.view.KeyEventCompat.dispatch(p3, this.mKeyEventCallback, this.mDispatcherState, this);
    }

    public int getBufferPercentage()
    {
        return this.mCallbacks.onGetBufferPercentage();
    }

    public long getCurrentPosition()
    {
        return this.mCallbacks.onGetCurrentPosition();
    }

    public long getDuration()
    {
        return this.mCallbacks.onGetDuration();
    }

    public Object getRemoteControlClient()
    {
        int v0_1;
        if (this.mController == null) {
            v0_1 = 0;
        } else {
            v0_1 = this.mController.getRemoteControlClient();
        }
        return v0_1;
    }

    public int getTransportControlFlags()
    {
        return this.mCallbacks.onGetTransportControlFlags();
    }

    public boolean isPlaying()
    {
        return this.mCallbacks.onIsPlaying();
    }

    public void pausePlaying()
    {
        if (this.mController != null) {
            this.mController.pausePlaying();
        }
        this.mCallbacks.onPause();
        this.pushControllerState();
        this.reportPlayingChanged();
        return;
    }

    public void refreshState()
    {
        this.pushControllerState();
        this.reportPlayingChanged();
        this.reportTransportControlsChanged();
        return;
    }

    public void registerStateListener(android.support.v4.media.TransportStateListener p2)
    {
        this.mListeners.add(p2);
        return;
    }

    public void seekTo(long p2)
    {
        this.mCallbacks.onSeekTo(p2);
        return;
    }

    public void startPlaying()
    {
        if (this.mController != null) {
            this.mController.startPlaying();
        }
        this.mCallbacks.onStart();
        this.pushControllerState();
        this.reportPlayingChanged();
        return;
    }

    public void stopPlaying()
    {
        if (this.mController != null) {
            this.mController.stopPlaying();
        }
        this.mCallbacks.onStop();
        this.pushControllerState();
        this.reportPlayingChanged();
        return;
    }

    public void unregisterStateListener(android.support.v4.media.TransportStateListener p2)
    {
        this.mListeners.remove(p2);
        return;
    }
}
