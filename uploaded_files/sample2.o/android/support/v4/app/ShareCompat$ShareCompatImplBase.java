package android.support.v4.app;
 class ShareCompat$ShareCompatImplBase implements android.support.v4.app.ShareCompat$ShareCompatImpl {

    ShareCompat$ShareCompatImplBase()
    {
        return;
    }

    private static void withinStyle(StringBuilder p5, CharSequence p6, int p7, int p8)
    {
        int v1 = p7;
        while (v1 < p8) {
            char v0 = p6.charAt(v1);
            if (v0 != 60) {
                if (v0 != 62) {
                    if (v0 != 38) {
                        if ((v0 <= 126) && (v0 >= 32)) {
                            if (v0 != 32) {
                                p5.append(v0);
                                v1++;
                            }
                            while (((v1 + 1) < p8) && (p6.charAt((v1 + 1)) == 32)) {
                                p5.append("&nbsp;");
                                v1++;
                            }
                            p5.append(32);
                        } else {
                            p5.append(new StringBuilder().append("&#").append(v0).append(";").toString());
                        }
                    } else {
                        p5.append("&amp;");
                    }
                } else {
                    p5.append("&gt;");
                }
            } else {
                p5.append("&lt;");
            }
        }
        return;
    }

    public void configureMenuItem(android.view.MenuItem p2, android.support.v4.app.ShareCompat$IntentBuilder p3)
    {
        p2.setIntent(p3.createChooserIntent());
        return;
    }

    public String escapeHtml(CharSequence p4)
    {
        StringBuilder v0_1 = new StringBuilder();
        android.support.v4.app.ShareCompat$ShareCompatImplBase.withinStyle(v0_1, p4, 0, p4.length());
        return v0_1.toString();
    }
}
