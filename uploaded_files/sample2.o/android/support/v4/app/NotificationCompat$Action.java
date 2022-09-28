package android.support.v4.app;
public class NotificationCompat$Action extends android.support.v4.app.NotificationCompatBase$Action {
    public static final android.support.v4.app.NotificationCompatBase$Action$Factory FACTORY;
    public android.app.PendingIntent actionIntent;
    public int icon;
    private final android.os.Bundle mExtras;
    private final android.support.v4.app.RemoteInput[] mRemoteInputs;
    public CharSequence title;

    static NotificationCompat$Action()
    {
        android.support.v4.app.NotificationCompat$Action.FACTORY = new android.support.v4.app.NotificationCompat$Action$1();
        return;
    }

    public NotificationCompat$Action(int p7, CharSequence p8, android.app.PendingIntent p9)
    {
        this(p7, p8, p9, new android.os.Bundle(), 0);
        return;
    }

    private NotificationCompat$Action(int p1, CharSequence p2, android.app.PendingIntent p3, android.os.Bundle p4, android.support.v4.app.RemoteInput[] p5)
    {
        this.icon = p1;
        this.title = p2;
        this.actionIntent = p3;
        if (p4 == null) {
            p4 = new android.os.Bundle();
        }
        this.mExtras = p4;
        this.mRemoteInputs = p5;
        return;
    }

    synthetic NotificationCompat$Action(int p1, CharSequence p2, android.app.PendingIntent p3, android.os.Bundle p4, android.support.v4.app.RemoteInput[] p5, android.support.v4.app.NotificationCompat$1 p6)
    {
        this(p1, p2, p3, p4, p5);
        return;
    }

    static synthetic android.os.Bundle access$300(android.support.v4.app.NotificationCompat$Action p1)
    {
        return p1.mExtras;
    }

    protected android.app.PendingIntent getActionIntent()
    {
        return this.actionIntent;
    }

    public android.os.Bundle getExtras()
    {
        return this.mExtras;
    }

    protected int getIcon()
    {
        return this.icon;
    }

    public android.support.v4.app.RemoteInput[] getRemoteInputs()
    {
        return this.mRemoteInputs;
    }

    public bridge synthetic android.support.v4.app.RemoteInputCompatBase$RemoteInput[] getRemoteInputs()
    {
        return this.getRemoteInputs();
    }

    protected CharSequence getTitle()
    {
        return this.title;
    }
}
