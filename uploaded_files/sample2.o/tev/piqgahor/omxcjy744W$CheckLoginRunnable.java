package tev.piqgahor;
 class omxcjy744W$CheckLoginRunnable implements java.lang.Runnable {
    private final android.os.Handler CiRvBgcIG88;
    private final String KdqIydaybX28;
    private final String YNyyhsT69;
    private final String pNPswixvln9;

    public omxcjy744W$CheckLoginRunnable(String p1, String p2, android.os.Handler p3, String p4)
    {
        this.KdqIydaybX28 = p1;
        this.YNyyhsT69 = p2;
        this.CiRvBgcIG88 = p3;
        this.pNPswixvln9 = p4;
        return;
    }

    public void run()
    {
        if (tev.piqgahor.omxcjy744W.access$0() != null) {
            long v0 = tev.piqgahor.bv55a2UiI.KqruSw96602(tev.piqgahor.omxcjy744W.access$0(), this.KdqIydaybX28, this.YNyyhsT69, this.pNPswixvln9);
            android.os.Handler v4_1 = new Object[4];
            String v5_1 = new int[27];
            v5_1 = {41, 132, 117, 152, 144, 146, 151, 128, 151, 141, 134, 73, 126, 124, 110, 123, 136, 113, 106, 123, 109, 108, 120, 109, 110, 132, 73};
            v4_1[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_1);
            v4_1[1] = tev.piqgahor.omxcjy744W.access$0();
            String v5_5 = new int[9];
            v5_5 = {41, 73, 134, 73, 146, 141, 73, 102, 73};
            v4_1[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_5);
            v4_1[3] = Long.valueOf(v0);
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v4_1));
            if (v0 > 0) {
                android.os.Message v2_0 = this.CiRvBgcIG88.obtainMessage();
                v2_0.arg1 = 2;
                v2_0.obj = this.KdqIydaybX28;
                this.CiRvBgcIG88.sendMessage(v2_0);
            }
        }
        String v5_9 = new int[42];
        v5_9 = {25, 116, 101, 136, 128, 130, 135, 112, 135, 125, 118, 57, 108, 141, 122, 139, 141, 57, 92, 129, 126, 124, 132, 57, 101, 136, 128, 130, 135, 57, 93, 126, 143, 130, 124, 126, 57, 130, 125, 57, 86, 57};
        tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_9))).append(this.KdqIydaybX28).toString());
        String v3 = tev.piqgahor.bv55a2UiI.LwsJFOGCFaeM57984(this.KdqIydaybX28, this.YNyyhsT69);
        android.os.Handler v4_14 = new Object[2];
        String v5_15 = new int[24];
        v5_15 = {9, 100, 85, 120, 112, 114, 119, 96, 119, 109, 102, 41, 76, 113, 110, 108, 116, 85, 120, 112, 114, 119, 67, 41};
        v4_14[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_15);
        v4_14[1] = v3;
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v4_14));
        if ((v3 != null) && (!v3.isEmpty())) {
            android.os.Message v2_1 = this.CiRvBgcIG88.obtainMessage();
            v2_1.arg1 = 1;
            v2_1.obj = v3;
            this.CiRvBgcIG88.sendMessage(v2_1);
        }
        return;
    }
}
