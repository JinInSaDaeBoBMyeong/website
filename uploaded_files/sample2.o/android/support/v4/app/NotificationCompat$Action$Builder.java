package android.support.v4.app;
public final class NotificationCompat$Action$Builder {
    private final android.os.Bundle mExtras;
    private final int mIcon;
    private final android.app.PendingIntent mIntent;
    private java.util.ArrayList mRemoteInputs;
    private final CharSequence mTitle;

    public NotificationCompat$Action$Builder(int p2, CharSequence p3, android.app.PendingIntent p4)
    {
        this(p2, p3, p4, new android.os.Bundle());
        return;
    }

    private NotificationCompat$Action$Builder(int p1, CharSequence p2, android.app.PendingIntent p3, android.os.Bundle p4)
    {
        this.mIcon = p1;
        this.mTitle = p2;
        this.mIntent = p3;
        this.mExtras = p4;
        return;
    }

    public NotificationCompat$Action$Builder(android.support.v4.app.NotificationCompat$Action p6)
    {
        this(p6.icon, p6.title, p6.actionIntent, new android.os.Bundle(android.support.v4.app.NotificationCompat$Action.access$300(p6)));
        return;
    }

    public android.support.v4.app.NotificationCompat$Action$Builder addExtras(android.os.Bundle p2)
    {
        if (p2 != null) {
            this.mExtras.putAll(p2);
        }
        return this;
    }

    public android.support.v4.app.NotificationCompat$Action$Builder addRemoteInput(android.support.v4.app.RemoteInput p2)
    {
        if (this.mRemoteInputs == null) {
            this.mRemoteInputs = new java.util.ArrayList();
        }
        this.mRemoteInputs.add(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$Action build()
    {
        int v5;
        if (this.mRemoteInputs == null) {
            v5 = 0;
        } else {
            int v1_3 = new android.support.v4.app.RemoteInput[this.mRemoteInputs.size()];
            v5 = ((android.support.v4.app.RemoteInput[]) this.mRemoteInputs.toArray(v1_3));
        }
        return new android.support.v4.app.NotificationCompat$Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, v5, 0);
    }

    public android.support.v4.app.NotificationCompat$Action$Builder extend(android.support.v4.app.NotificationCompat$Action$Extender p1)
    {
        p1.extend(this);
        return this;
    }

    public android.os.Bundle getExtras()
    {
        return this.mExtras;
    }
}
