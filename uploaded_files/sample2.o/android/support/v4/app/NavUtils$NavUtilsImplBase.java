package android.support.v4.app;
 class NavUtils$NavUtilsImplBase implements android.support.v4.app.NavUtils$NavUtilsImpl {

    NavUtils$NavUtilsImplBase()
    {
        return;
    }

    public android.content.Intent getParentActivityIntent(android.app.Activity p9)
    {
        android.content.Intent v2 = 0;
        String v3 = android.support.v4.app.NavUtils.getParentActivityName(p9);
        if (v3 != null) {
            android.content.ComponentName v4_1 = new android.content.ComponentName(p9, v3);
            try {
                if (android.support.v4.app.NavUtils.getParentActivityName(p9, v4_1) != null) {
                    v2 = new android.content.Intent().setComponent(v4_1);
                } else {
                    v2 = android.support.v4.content.IntentCompat.makeMainActivity(v4_1);
                }
            } catch (android.content.pm.PackageManager$NameNotFoundException v0) {
                android.util.Log.e("NavUtils", new StringBuilder().append("getParentActivityIntent: bad parentActivityName \'").append(v3).append("\' in manifest").toString());
            }
        }
        return v2;
    }

    public String getParentActivityName(android.content.Context p5, android.content.pm.ActivityInfo p6)
    {
        String v0;
        if (p6.metaData != null) {
            v0 = p6.metaData.getString("android.support.PARENT_ACTIVITY");
            if (v0 != null) {
                if (v0.charAt(0) == 46) {
                    v0 = new StringBuilder().append(p5.getPackageName()).append(v0).toString();
                }
            } else {
                v0 = 0;
            }
        } else {
            v0 = 0;
        }
        return v0;
    }

    public void navigateUpTo(android.app.Activity p2, android.content.Intent p3)
    {
        p3.addFlags(67108864);
        p2.startActivity(p3);
        p2.finish();
        return;
    }

    public boolean shouldUpRecreateTask(android.app.Activity p3, android.content.Intent p4)
    {
        int v1_1;
        String v0 = p3.getIntent().getAction();
        if ((v0 == null) || (v0.equals("android.intent.action.MAIN"))) {
            v1_1 = 0;
        } else {
            v1_1 = 1;
        }
        return v1_1;
    }
}
