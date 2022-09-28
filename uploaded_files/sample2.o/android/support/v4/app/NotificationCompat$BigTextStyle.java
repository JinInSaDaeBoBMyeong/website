package android.support.v4.app;
public class NotificationCompat$BigTextStyle extends android.support.v4.app.NotificationCompat$Style {
    CharSequence mBigText;

    public NotificationCompat$BigTextStyle()
    {
        return;
    }

    public NotificationCompat$BigTextStyle(android.support.v4.app.NotificationCompat$Builder p1)
    {
        this.setBuilder(p1);
        return;
    }

    public android.support.v4.app.NotificationCompat$BigTextStyle bigText(CharSequence p1)
    {
        this.mBigText = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$BigTextStyle setBigContentTitle(CharSequence p1)
    {
        this.mBigContentTitle = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$BigTextStyle setSummaryText(CharSequence p2)
    {
        this.mSummaryText = p2;
        this.mSummaryTextSet = 1;
        return this;
    }
}
