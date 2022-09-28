package android.support.v4.app;
public abstract class NotificationCompat$Style {
    CharSequence mBigContentTitle;
    android.support.v4.app.NotificationCompat$Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet;

    public NotificationCompat$Style()
    {
        this.mSummaryTextSet = 0;
        return;
    }

    public android.app.Notification build()
    {
        android.app.Notification v0 = 0;
        if (this.mBuilder != null) {
            v0 = this.mBuilder.build();
        }
        return v0;
    }

    public void setBuilder(android.support.v4.app.NotificationCompat$Builder p2)
    {
        if (this.mBuilder != p2) {
            this.mBuilder = p2;
            if (this.mBuilder != null) {
                this.mBuilder.setStyle(this);
            }
        }
        return;
    }
}
