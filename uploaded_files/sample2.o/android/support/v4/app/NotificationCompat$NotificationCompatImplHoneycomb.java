package android.support.v4.app;
 class NotificationCompat$NotificationCompatImplHoneycomb extends android.support.v4.app.NotificationCompat$NotificationCompatImplBase {

    NotificationCompat$NotificationCompatImplHoneycomb()
    {
        return;
    }

    public android.app.Notification build(android.support.v4.app.NotificationCompat$Builder p11)
    {
        return android.support.v4.app.NotificationCompatHoneycomb.add(p11.mContext, p11.mNotification, p11.mContentTitle, p11.mContentText, p11.mContentInfo, p11.mTickerView, p11.mNumber, p11.mContentIntent, p11.mFullScreenIntent, p11.mLargeIcon);
    }
}
