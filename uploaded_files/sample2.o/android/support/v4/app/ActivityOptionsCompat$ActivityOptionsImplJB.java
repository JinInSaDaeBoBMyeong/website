package android.support.v4.app;
 class ActivityOptionsCompat$ActivityOptionsImplJB extends android.support.v4.app.ActivityOptionsCompat {
    private final android.support.v4.app.ActivityOptionsCompatJB mImpl;

    ActivityOptionsCompat$ActivityOptionsImplJB(android.support.v4.app.ActivityOptionsCompatJB p1)
    {
        this.mImpl = p1;
        return;
    }

    public android.os.Bundle toBundle()
    {
        return this.mImpl.toBundle();
    }

    public void update(android.support.v4.app.ActivityOptionsCompat p4)
    {
        if ((p4 instanceof android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB)) {
            this.mImpl.update(((android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB) p4).mImpl);
        }
        return;
    }
}
