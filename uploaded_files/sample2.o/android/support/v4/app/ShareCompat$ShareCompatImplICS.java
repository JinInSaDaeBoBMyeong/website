package android.support.v4.app;
 class ShareCompat$ShareCompatImplICS extends android.support.v4.app.ShareCompat$ShareCompatImplBase {

    ShareCompat$ShareCompatImplICS()
    {
        return;
    }

    public void configureMenuItem(android.view.MenuItem p3, android.support.v4.app.ShareCompat$IntentBuilder p4)
    {
        android.support.v4.app.ShareCompatICS.configureMenuItem(p3, p4.getActivity(), p4.getIntent());
        if (this.shouldAddChooserIntent(p3)) {
            p3.setIntent(p4.createChooserIntent());
        }
        return;
    }

    boolean shouldAddChooserIntent(android.view.MenuItem p2)
    {
        int v0_1;
        if (p2.hasSubMenu()) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }
}
