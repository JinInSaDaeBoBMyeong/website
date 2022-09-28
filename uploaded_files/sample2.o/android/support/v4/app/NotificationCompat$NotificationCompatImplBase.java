package android.support.v4.app;
 class NotificationCompat$NotificationCompatImplBase implements android.support.v4.app.NotificationCompat$NotificationCompatImpl {

    NotificationCompat$NotificationCompatImplBase()
    {
        return;
    }

    public android.app.Notification build(android.support.v4.app.NotificationCompat$Builder p6)
    {
        android.app.Notification v0 = p6.mNotification;
        v0.setLatestEventInfo(p6.mContext, p6.mContentTitle, p6.mContentText, p6.mContentIntent);
        if (p6.mPriority > 0) {
            v0.flags = (v0.flags | 128);
        }
        return v0;
    }

    public android.support.v4.app.NotificationCompat$Action getAction(android.app.Notification p2, int p3)
    {
        return 0;
    }

    public int getActionCount(android.app.Notification p2)
    {
        return 0;
    }

    public android.support.v4.app.NotificationCompat$Action[] getActionsFromParcelableArrayList(java.util.ArrayList p2)
    {
        return 0;
    }

    public android.os.Bundle getExtras(android.app.Notification p2)
    {
        return 0;
    }

    public String getGroup(android.app.Notification p2)
    {
        return 0;
    }

    public boolean getLocalOnly(android.app.Notification p2)
    {
        return 0;
    }

    public java.util.ArrayList getParcelableArrayListForActions(android.support.v4.app.NotificationCompat$Action[] p2)
    {
        return 0;
    }

    public String getSortKey(android.app.Notification p2)
    {
        return 0;
    }

    public boolean isGroupSummary(android.app.Notification p2)
    {
        return 0;
    }
}
