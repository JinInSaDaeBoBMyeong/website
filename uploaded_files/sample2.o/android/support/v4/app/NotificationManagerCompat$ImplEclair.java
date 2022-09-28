package android.support.v4.app;
 class NotificationManagerCompat$ImplEclair extends android.support.v4.app.NotificationManagerCompat$ImplBase {

    NotificationManagerCompat$ImplEclair()
    {
        return;
    }

    public void cancelNotification(android.app.NotificationManager p1, String p2, int p3)
    {
        android.support.v4.app.NotificationManagerCompatEclair.cancelNotification(p1, p2, p3);
        return;
    }

    public void postNotification(android.app.NotificationManager p1, String p2, int p3, android.app.Notification p4)
    {
        android.support.v4.app.NotificationManagerCompatEclair.postNotification(p1, p2, p3, p4);
        return;
    }
}
