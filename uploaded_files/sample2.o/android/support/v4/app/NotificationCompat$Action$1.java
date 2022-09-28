package android.support.v4.app;
final class NotificationCompat$Action$1 implements android.support.v4.app.NotificationCompatBase$Action$Factory {

    NotificationCompat$Action$1()
    {
        return;
    }

    public android.support.v4.app.NotificationCompat$Action build(int p8, CharSequence p9, android.app.PendingIntent p10, android.os.Bundle p11, android.support.v4.app.RemoteInputCompatBase$RemoteInput[] p12)
    {
        return new android.support.v4.app.NotificationCompat$Action(p8, p9, p10, p11, ((android.support.v4.app.RemoteInput[]) ((android.support.v4.app.RemoteInput[]) p12)), 0);
    }

    public bridge synthetic android.support.v4.app.NotificationCompatBase$Action build(int p2, CharSequence p3, android.app.PendingIntent p4, android.os.Bundle p5, android.support.v4.app.RemoteInputCompatBase$RemoteInput[] p6)
    {
        return this.build(p2, p3, p4, p5, p6);
    }

    public android.support.v4.app.NotificationCompat$Action[] newArray(int p2)
    {
        android.support.v4.app.NotificationCompat$Action[] v0 = new android.support.v4.app.NotificationCompat$Action[p2];
        return v0;
    }

    public bridge synthetic android.support.v4.app.NotificationCompatBase$Action[] newArray(int p2)
    {
        return this.newArray(p2);
    }
}
