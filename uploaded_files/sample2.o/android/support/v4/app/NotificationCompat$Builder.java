package android.support.v4.app;
public class NotificationCompat$Builder {
    java.util.ArrayList mActions;
    CharSequence mContentInfo;
    android.app.PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    android.content.Context mContext;
    android.os.Bundle mExtras;
    android.app.PendingIntent mFullScreenIntent;
    String mGroupKey;
    boolean mGroupSummary;
    android.graphics.Bitmap mLargeIcon;
    boolean mLocalOnly;
    android.app.Notification mNotification;
    int mNumber;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    String mSortKey;
    android.support.v4.app.NotificationCompat$Style mStyle;
    CharSequence mSubText;
    android.widget.RemoteViews mTickerView;
    boolean mUseChronometer;

    public NotificationCompat$Builder(android.content.Context p6)
    {
        this.mActions = new java.util.ArrayList();
        this.mLocalOnly = 0;
        this.mNotification = new android.app.Notification();
        this.mContext = p6;
        this.mNotification.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        return;
    }

    private void setFlag(int p4, boolean p5)
    {
        if (!p5) {
            android.app.Notification v0_0 = this.mNotification;
            v0_0.flags = (v0_0.flags & (p4 ^ -1));
        } else {
            android.app.Notification v0_1 = this.mNotification;
            v0_1.flags = (v0_1.flags | p4);
        }
        return;
    }

    public android.support.v4.app.NotificationCompat$Builder addAction(int p3, CharSequence p4, android.app.PendingIntent p5)
    {
        this.mActions.add(new android.support.v4.app.NotificationCompat$Action(p3, p4, p5));
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder addAction(android.support.v4.app.NotificationCompat$Action p2)
    {
        this.mActions.add(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder addExtras(android.os.Bundle p2)
    {
        if (p2 != null) {
            if (this.mExtras != null) {
                this.mExtras.putAll(p2);
            } else {
                this.mExtras = new android.os.Bundle(p2);
            }
        }
        return this;
    }

    public android.app.Notification build()
    {
        return android.support.v4.app.NotificationCompat.access$200().build(this);
    }

    public android.support.v4.app.NotificationCompat$Builder extend(android.support.v4.app.NotificationCompat$Extender p1)
    {
        p1.extend(this);
        return this;
    }

    public android.os.Bundle getExtras()
    {
        if (this.mExtras == null) {
            this.mExtras = new android.os.Bundle();
        }
        return this.mExtras;
    }

    public android.app.Notification getNotification()
    {
        return android.support.v4.app.NotificationCompat.access$200().build(this);
    }

    public android.support.v4.app.NotificationCompat$Builder setAutoCancel(boolean p2)
    {
        this.setFlag(16, p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setContent(android.widget.RemoteViews p2)
    {
        this.mNotification.contentView = p2;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setContentInfo(CharSequence p1)
    {
        this.mContentInfo = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setContentIntent(android.app.PendingIntent p1)
    {
        this.mContentIntent = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setContentText(CharSequence p1)
    {
        this.mContentText = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setContentTitle(CharSequence p1)
    {
        this.mContentTitle = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setDefaults(int p3)
    {
        this.mNotification.defaults = p3;
        if ((p3 & 4) != 0) {
            android.app.Notification v0_2 = this.mNotification;
            v0_2.flags = (v0_2.flags | 1);
        }
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setDeleteIntent(android.app.PendingIntent p2)
    {
        this.mNotification.deleteIntent = p2;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setExtras(android.os.Bundle p1)
    {
        this.mExtras = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setFullScreenIntent(android.app.PendingIntent p2, boolean p3)
    {
        this.mFullScreenIntent = p2;
        this.setFlag(128, p3);
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setGroup(String p1)
    {
        this.mGroupKey = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setGroupSummary(boolean p1)
    {
        this.mGroupSummary = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setLargeIcon(android.graphics.Bitmap p1)
    {
        this.mLargeIcon = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setLights(int p6, int p7, int p8)
    {
        int v0;
        int v1_0 = 1;
        this.mNotification.ledARGB = p6;
        this.mNotification.ledOnMS = p7;
        this.mNotification.ledOffMS = p8;
        if ((this.mNotification.ledOnMS == 0) || (this.mNotification.ledOffMS == 0)) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        if (v0 == 0) {
            v1_0 = 0;
        }
        this.mNotification.flags = (v1_0 | (this.mNotification.flags & -2));
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setLocalOnly(boolean p1)
    {
        this.mLocalOnly = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setNumber(int p1)
    {
        this.mNumber = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setOngoing(boolean p2)
    {
        this.setFlag(2, p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setOnlyAlertOnce(boolean p2)
    {
        this.setFlag(8, p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setPriority(int p1)
    {
        this.mPriority = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setProgress(int p1, int p2, boolean p3)
    {
        this.mProgressMax = p1;
        this.mProgress = p2;
        this.mProgressIndeterminate = p3;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setSmallIcon(int p2)
    {
        this.mNotification.icon = p2;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setSmallIcon(int p2, int p3)
    {
        this.mNotification.icon = p2;
        this.mNotification.iconLevel = p3;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setSortKey(String p1)
    {
        this.mSortKey = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setSound(android.net.Uri p3)
    {
        this.mNotification.sound = p3;
        this.mNotification.audioStreamType = -1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setSound(android.net.Uri p2, int p3)
    {
        this.mNotification.sound = p2;
        this.mNotification.audioStreamType = p3;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setStyle(android.support.v4.app.NotificationCompat$Style p2)
    {
        if (this.mStyle != p2) {
            this.mStyle = p2;
            if (this.mStyle != null) {
                this.mStyle.setBuilder(this);
            }
        }
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setSubText(CharSequence p1)
    {
        this.mSubText = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setTicker(CharSequence p2)
    {
        this.mNotification.tickerText = p2;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setTicker(CharSequence p2, android.widget.RemoteViews p3)
    {
        this.mNotification.tickerText = p2;
        this.mTickerView = p3;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setUsesChronometer(boolean p1)
    {
        this.mUseChronometer = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setVibrate(long[] p2)
    {
        this.mNotification.vibrate = p2;
        return this;
    }

    public android.support.v4.app.NotificationCompat$Builder setWhen(long p2)
    {
        this.mNotification.when = p2;
        return this;
    }
}
