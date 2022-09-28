package android.support.v4.app;
 class NotificationCompat$NotificationCompatImplGingerbread extends android.support.v4.app.NotificationCompat$NotificationCompatImplBase {

    NotificationCompat$NotificationCompatImplGingerbread()
    {
        return;
    }

    public android.app.Notification build(android.support.v4.app.NotificationCompat$Builder p7)
    {
        android.app.Notification v0_0 = p7.mNotification;
        v0_0.setLatestEventInfo(p7.mContext, p7.mContentTitle, p7.mContentText, p7.mContentIntent);
        android.app.Notification v0_1 = android.support.v4.app.NotificationCompatGingerbread.add(v0_0, p7.mContext, p7.mContentTitle, p7.mContentText, p7.mContentIntent, p7.mFullScreenIntent);
        if (p7.mPriority > 0) {
            v0_1.flags = (v0_1.flags | 128);
        }
        return v0_1;
    }
}
