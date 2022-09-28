package android.support.v4.app;
public class NotificationCompat$BigPictureStyle extends android.support.v4.app.NotificationCompat$Style {
    android.graphics.Bitmap mBigLargeIcon;
    boolean mBigLargeIconSet;
    android.graphics.Bitmap mPicture;

    public NotificationCompat$BigPictureStyle()
    {
        return;
    }

    public NotificationCompat$BigPictureStyle(android.support.v4.app.NotificationCompat$Builder p1)
    {
        this.setBuilder(p1);
        return;
    }

    public android.support.v4.app.NotificationCompat$BigPictureStyle bigLargeIcon(android.graphics.Bitmap p2)
    {
        this.mBigLargeIcon = p2;
        this.mBigLargeIconSet = 1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$BigPictureStyle bigPicture(android.graphics.Bitmap p1)
    {
        this.mPicture = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$BigPictureStyle setBigContentTitle(CharSequence p1)
    {
        this.mBigContentTitle = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$BigPictureStyle setSummaryText(CharSequence p2)
    {
        this.mSummaryText = p2;
        this.mSummaryTextSet = 1;
        return this;
    }
}
