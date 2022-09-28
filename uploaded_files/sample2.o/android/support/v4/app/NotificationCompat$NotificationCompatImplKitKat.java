package android.support.v4.app;
 class NotificationCompat$NotificationCompatImplKitKat extends android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean {

    NotificationCompat$NotificationCompatImplKitKat()
    {
        return;
    }

    public android.app.Notification build(android.support.v4.app.NotificationCompat$Builder p24)
    {
        android.support.v4.app.NotificationCompatKitKat$Builder v1_1 = new android.support.v4.app.NotificationCompatKitKat$Builder(p24.mContext, p24.mNotification, p24.mContentTitle, p24.mContentText, p24.mContentInfo, p24.mTickerView, p24.mNumber, p24.mContentIntent, p24.mFullScreenIntent, p24.mLargeIcon, p24.mProgressMax, p24.mProgress, p24.mProgressIndeterminate, p24.mUseChronometer, p24.mPriority, p24.mSubText, p24.mLocalOnly, p24.mExtras, p24.mGroupKey, p24.mGroupSummary, p24.mSortKey);
        android.support.v4.app.NotificationCompat.access$000(v1_1, p24.mActions);
        android.support.v4.app.NotificationCompat.access$100(v1_1, p24.mStyle);
        return v1_1.build();
    }

    public android.support.v4.app.NotificationCompat$Action getAction(android.app.Notification p3, int p4)
    {
        return ((android.support.v4.app.NotificationCompat$Action) android.support.v4.app.NotificationCompatKitKat.getAction(p3, p4, android.support.v4.app.NotificationCompat$Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY));
    }

    public int getActionCount(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatKitKat.getActionCount(p2);
    }

    public android.os.Bundle getExtras(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatKitKat.getExtras(p2);
    }

    public String getGroup(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatKitKat.getGroup(p2);
    }

    public boolean getLocalOnly(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatKitKat.getLocalOnly(p2);
    }

    public String getSortKey(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatKitKat.getSortKey(p2);
    }

    public boolean isGroupSummary(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatKitKat.isGroupSummary(p2);
    }
}
