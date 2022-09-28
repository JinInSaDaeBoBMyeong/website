package android.support.v4.app;
 class ShareCompatICS {
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    ShareCompatICS()
    {
        return;
    }

    public static void configureMenuItem(android.view.MenuItem p4, android.app.Activity p5, android.content.Intent p6)
    {
        android.widget.ShareActionProvider v1_1;
        android.view.ActionProvider v0 = p4.getActionProvider();
        if ((v0 instanceof android.widget.ShareActionProvider)) {
            v1_1 = ((android.widget.ShareActionProvider) v0);
        } else {
            v1_1 = new android.widget.ShareActionProvider(p5);
        }
        v1_1.setShareHistoryFileName(new StringBuilder().append(".sharecompat_").append(p5.getClass().getName()).toString());
        v1_1.setShareIntent(p6);
        p4.setActionProvider(v1_1);
        return;
    }
}
