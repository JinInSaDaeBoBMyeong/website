package android.support.v4.app;
 class NotificationCompat$NotificationCompatImplIceCreamSandwich extends android.support.v4.app.NotificationCompat$NotificationCompatImplBase {

    NotificationCompat$NotificationCompatImplIceCreamSandwich()
    {
        return;
    }

    public android.app.Notification build(android.support.v4.app.NotificationCompat$Builder p14)
    {
        return android.support.v4.app.NotificationCompatIceCreamSandwich.add(p14.mContext, p14.mNotification, p14.mContentTitle, p14.mContentText, p14.mContentInfo, p14.mTickerView, p14.mNumber, p14.mContentIntent, p14.mFullScreenIntent, p14.mLargeIcon, p14.mProgressMax, p14.mProgress, p14.mProgressIndeterminate);
    }
}
