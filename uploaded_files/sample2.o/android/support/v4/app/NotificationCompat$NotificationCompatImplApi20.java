package android.support.v4.app;
 class NotificationCompat$NotificationCompatImplApi20 extends android.support.v4.app.NotificationCompat$NotificationCompatImplKitKat {

    NotificationCompat$NotificationCompatImplApi20()
    {
        return;
    }

    public android.app.Notification build(android.support.v4.app.NotificationCompat$Builder p24)
    {
        android.support.v4.app.NotificationCompatApi20$Builder v1_1 = new android.support.v4.app.NotificationCompatApi20$Builder(p24.mContext, p24.mNotification, p24.mContentTitle, p24.mContentText, p24.mContentInfo, p24.mTickerView, p24.mNumber, p24.mContentIntent, p24.mFullScreenIntent, p24.mLargeIcon, p24.mProgressMax, p24.mProgress, p24.mProgressIndeterminate, p24.mUseChronometer, p24.mPriority, p24.mSubText, p24.mLocalOnly, p24.mExtras, p24.mGroupKey, p24.mGroupSummary, p24.mSortKey);
        android.support.v4.app.NotificationCompat.access$000(v1_1, p24.mActions);
        android.support.v4.app.NotificationCompat.access$100(v1_1, p24.mStyle);
        return v1_1.build();
    }

    public android.support.v4.app.NotificationCompat$Action getAction(android.app.Notification p3, int p4)
    {
        return ((android.support.v4.app.NotificationCompat$Action) android.support.v4.app.NotificationCompatApi20.getAction(p3, p4, android.support.v4.app.NotificationCompat$Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY));
    }

    public android.support.v4.app.NotificationCompat$Action[] getActionsFromParcelableArrayList(java.util.ArrayList p3)
    {
        return ((android.support.v4.app.NotificationCompat$Action[]) ((android.support.v4.app.NotificationCompat$Action[]) android.support.v4.app.NotificationCompatApi20.getActionsFromParcelableArrayList(p3, android.support.v4.app.NotificationCompat$Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY)));
    }

    public String getGroup(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatApi20.getGroup(p2);
    }

    public boolean getLocalOnly(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatApi20.getLocalOnly(p2);
    }

    public java.util.ArrayList getParcelableArrayListForActions(android.support.v4.app.NotificationCompat$Action[] p2)
    {
        return android.support.v4.app.NotificationCompatApi20.getParcelableArrayListForActions(p2);
    }

    public String getSortKey(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatApi20.getSortKey(p2);
    }

    public boolean isGroupSummary(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatApi20.isGroupSummary(p2);
    }
}
