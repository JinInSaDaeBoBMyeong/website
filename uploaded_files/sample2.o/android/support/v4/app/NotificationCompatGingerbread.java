package android.support.v4.app;
 class NotificationCompatGingerbread {

    NotificationCompatGingerbread()
    {
        return;
    }

    public static android.app.Notification add(android.app.Notification p0, android.content.Context p1, CharSequence p2, CharSequence p3, android.app.PendingIntent p4, android.app.PendingIntent p5)
    {
        p0.setLatestEventInfo(p1, p2, p3, p4);
        p0.fullScreenIntent = p5;
        return p0;
    }
}
