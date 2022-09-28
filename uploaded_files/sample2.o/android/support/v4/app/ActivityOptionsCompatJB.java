package android.support.v4.app;
 class ActivityOptionsCompatJB {
    private final android.app.ActivityOptions mActivityOptions;

    private ActivityOptionsCompatJB(android.app.ActivityOptions p1)
    {
        this.mActivityOptions = p1;
        return;
    }

    public static android.support.v4.app.ActivityOptionsCompatJB makeCustomAnimation(android.content.Context p2, int p3, int p4)
    {
        return new android.support.v4.app.ActivityOptionsCompatJB(android.app.ActivityOptions.makeCustomAnimation(p2, p3, p4));
    }

    public static android.support.v4.app.ActivityOptionsCompatJB makeScaleUpAnimation(android.view.View p2, int p3, int p4, int p5, int p6)
    {
        return new android.support.v4.app.ActivityOptionsCompatJB(android.app.ActivityOptions.makeScaleUpAnimation(p2, p3, p4, p5, p6));
    }

    public static android.support.v4.app.ActivityOptionsCompatJB makeThumbnailScaleUpAnimation(android.view.View p2, android.graphics.Bitmap p3, int p4, int p5)
    {
        return new android.support.v4.app.ActivityOptionsCompatJB(android.app.ActivityOptions.makeThumbnailScaleUpAnimation(p2, p3, p4, p5));
    }

    public android.os.Bundle toBundle()
    {
        return this.mActivityOptions.toBundle();
    }

    public void update(android.support.v4.app.ActivityOptionsCompatJB p3)
    {
        this.mActivityOptions.update(p3.mActivityOptions);
        return;
    }
}
