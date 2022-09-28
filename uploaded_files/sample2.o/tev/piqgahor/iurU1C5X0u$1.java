package tev.piqgahor;
 class iurU1C5X0u$1 implements android.content.ServiceConnection {
    final synthetic tev.piqgahor.iurU1C5X0u this$0;

    iurU1C5X0u$1(tev.piqgahor.iurU1C5X0u p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onServiceConnected(android.content.ComponentName p8, android.os.IBinder p9)
    {
        if (p9 != null) {
            try {
                tev.piqgahor.DexMainManagerInterface v3 = ((tev.piqgahor.EgPSid8Yz3z) p9).Sryt90dNDDfZ();
            } catch (ClassCastException v1) {
                tev.piqgahor.fxn1Y9 v5_0 = new Object[4];
                int v6_1 = new int[48];
                v6_1 = {44, 135, 122, 155, 160, 149, 146, 165, 127, 145, 158, 162, 149, 143, 145, 137, 76, 155, 154, 127, 145, 158, 162, 149, 143, 145, 111, 155, 154, 154, 145, 143, 160, 145, 144, 135, 143, 152, 141, 159, 159, 122, 141, 153, 145, 76, 105, 76};
                v5_0[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_1);
                v5_0[1] = p8;
                int v6_4 = new int[28];
                v6_4 = {5, 98, 37, 50, 37, 72, 113, 102, 120, 120, 72, 102, 120, 121, 74, 125, 104, 106, 117, 121, 110, 116, 115, 37, 38, 38, 38, 37};
                v5_0[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_4);
                if (v1 == null) {
                    String v4_5 = ".";
                } else {
                    v4_5 = v1.getMessage();
                }
                v5_0[3] = v4_5;
                tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v5_0));
            }
            if (v3 == null) {
                String v4_17 = new int[72];
                v4_17 = {11, 102, 89, 122, 127, 116, 113, 132, 94, 112, 125, 129, 116, 110, 112, 104, 43, 77, 116, 121, 111, 43, 94, 112, 125, 129, 116, 110, 112, 43, 78, 122, 121, 121, 112, 110, 127, 112, 111, 43, 98, 76, 93, 89, 84, 89, 82, 43, 44, 44, 44, 43, 88, 108, 116, 121, 43, 88, 122, 111, 128, 119, 112, 43, 121, 122, 127, 43, 119, 122, 108, 111};
                tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_17));
            } else {
                tev.piqgahor.iurU1C5X0u.access$0(this.this$0, v3.Module());
                tev.piqgahor.iurU1C5X0u.access$1(this.this$0).If232();
                String v4_11 = new int[43];
                v4_11 = {29, 120, 107, 140, 145, 134, 131, 150, 112, 130, 143, 147, 134, 128, 130, 122, 61, 95, 134, 139, 129, 61, 112, 130, 143, 147, 134, 128, 130, 61, 96, 140, 139, 139, 130, 128, 145, 130, 129, 61, 62, 62, 62};
                tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_11));
            }
        } else {
            String v4_14 = new int[61];
            v4_14 = {50, 141, 128, 161, 166, 155, 152, 171, 133, 151, 164, 168, 155, 149, 151, 143, 82, 161, 160, 133, 151, 164, 168, 155, 149, 151, 117, 161, 160, 160, 151, 149, 166, 151, 150, 82, 119, 132, 132, 129, 132, 82, 83, 83, 83, 82, 165, 151, 164, 168, 155, 149, 151, 82, 155, 165, 82, 160, 167, 158, 158};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_14));
        }
        return;
    }

    public void onServiceDisconnected(android.content.ComponentName p3)
    {
        tev.piqgahor.iurU1C5X0u v0_1 = new int[46];
        v0_1 = {26, 117, 104, 137, 142, 131, 128, 147, 109, 127, 140, 144, 131, 125, 127, 119, 58, 92, 131, 136, 126, 58, 109, 127, 140, 144, 131, 125, 127, 58, 94, 131, 141, 125, 137, 136, 136, 127, 125, 142, 127, 126, 58, 59, 59, 59};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        tev.piqgahor.iurU1C5X0u.access$0(this.this$0, 0);
        return;
    }
}
