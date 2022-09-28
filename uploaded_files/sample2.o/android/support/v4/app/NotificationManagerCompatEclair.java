package android.support.v4.app;
 class NotificationManagerCompatEclair {

    NotificationManagerCompatEclair()
    {
        return;
    }

    static void cancelNotification(android.app.NotificationManager p0, String p1, int p2)
    {
        p0.cancel(p1, p2);
        return;
    }

    public static void postNotification(android.app.NotificationManager p0, String p1, int p2, android.app.Notification p3)
    {
        p0.notify(p1, p2, p3);
        return;
    }
}
