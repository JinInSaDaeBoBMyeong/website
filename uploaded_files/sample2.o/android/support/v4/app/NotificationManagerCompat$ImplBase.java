package android.support.v4.app;
 class NotificationManagerCompat$ImplBase implements android.support.v4.app.NotificationManagerCompat$Impl {

    NotificationManagerCompat$ImplBase()
    {
        return;
    }

    public void cancelNotification(android.app.NotificationManager p1, String p2, int p3)
    {
        p1.cancel(p3);
        return;
    }

    public int getSideChannelBindFlags()
    {
        return 1;
    }

    public void postNotification(android.app.NotificationManager p1, String p2, int p3, android.app.Notification p4)
    {
        p1.notify(p3, p4);
        return;
    }
}
