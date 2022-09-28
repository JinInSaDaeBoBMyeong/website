package android.support.v4.app;
public class NotificationCompat$InboxStyle extends android.support.v4.app.NotificationCompat$Style {
    java.util.ArrayList mTexts;

    public NotificationCompat$InboxStyle()
    {
        this.mTexts = new java.util.ArrayList();
        return;
    }

    public NotificationCompat$InboxStyle(android.support.v4.app.NotificationCompat$Builder p2)
    {
        this.mTexts = new java.util.ArrayList();
        this.setBuilder(p2);
        return;
    }

    public android.support.v4.app.NotificationCompat$InboxStyle addLine(CharSequence p2)
    {
        this.mTexts.add(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$InboxStyle setBigContentTitle(CharSequence p1)
    {
        this.mBigContentTitle = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$InboxStyle setSummaryText(CharSequence p2)
    {
        this.mSummaryText = p2;
        this.mSummaryTextSet = 1;
        return this;
    }
}
