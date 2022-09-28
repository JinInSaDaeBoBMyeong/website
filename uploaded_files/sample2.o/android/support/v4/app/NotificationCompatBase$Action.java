package android.support.v4.app;
public abstract class NotificationCompatBase$Action {

    public NotificationCompatBase$Action()
    {
        return;
    }

    protected abstract android.app.PendingIntent getActionIntent();

    protected abstract android.os.Bundle getExtras();

    protected abstract int getIcon();

    protected abstract android.support.v4.app.RemoteInputCompatBase$RemoteInput[] getRemoteInputs();

    protected abstract CharSequence getTitle();
}
