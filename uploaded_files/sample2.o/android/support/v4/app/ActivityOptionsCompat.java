package android.support.v4.app;
public class ActivityOptionsCompat {

    protected ActivityOptionsCompat()
    {
        return;
    }

    public static android.support.v4.app.ActivityOptionsCompat makeCustomAnimation(android.content.Context p2, int p3, int p4)
    {
        android.support.v4.app.ActivityOptionsCompat v0_2;
        if (android.os.Build$VERSION.SDK_INT < 16) {
            v0_2 = new android.support.v4.app.ActivityOptionsCompat();
        } else {
            v0_2 = new android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB(android.support.v4.app.ActivityOptionsCompatJB.makeCustomAnimation(p2, p3, p4));
        }
        return v0_2;
    }

    public static android.support.v4.app.ActivityOptionsCompat makeScaleUpAnimation(android.view.View p2, int p3, int p4, int p5, int p6)
    {
        android.support.v4.app.ActivityOptionsCompat v0_2;
        if (android.os.Build$VERSION.SDK_INT < 16) {
            v0_2 = new android.support.v4.app.ActivityOptionsCompat();
        } else {
            v0_2 = new android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB(android.support.v4.app.ActivityOptionsCompatJB.makeScaleUpAnimation(p2, p3, p4, p5, p6));
        }
        return v0_2;
    }

    public static android.support.v4.app.ActivityOptionsCompat makeThumbnailScaleUpAnimation(android.view.View p2, android.graphics.Bitmap p3, int p4, int p5)
    {
        android.support.v4.app.ActivityOptionsCompat v0_2;
        if (android.os.Build$VERSION.SDK_INT < 16) {
            v0_2 = new android.support.v4.app.ActivityOptionsCompat();
        } else {
            v0_2 = new android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB(android.support.v4.app.ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(p2, p3, p4, p5));
        }
        return v0_2;
    }

    public android.os.Bundle toBundle()
    {
        return 0;
    }

    public void update(android.support.v4.app.ActivityOptionsCompat p1)
    {
        return;
    }
}
