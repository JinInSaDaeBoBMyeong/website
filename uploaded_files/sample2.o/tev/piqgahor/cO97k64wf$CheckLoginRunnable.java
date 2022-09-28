package tev.piqgahor;
 class cO97k64wf$CheckLoginRunnable implements java.lang.Runnable {
    private final android.os.Handler jhIodRFx1;
    private final String lBCSso510;
    private final String lxxvpG7029;

    public cO97k64wf$CheckLoginRunnable(String p1, String p2, android.os.Handler p3)
    {
        this.lxxvpG7029 = p1;
        this.lBCSso510 = p2;
        this.jhIodRFx1 = p3;
        return;
    }

    public void run()
    {
        int v3_4 = new int[50];
        v3_4 = {50, 141, 133, 151, 166, 166, 155, 160, 153, 165, 115, 149, 166, 155, 168, 155, 166, 171, 143, 82, 133, 166, 147, 164, 166, 82, 117, 154, 151, 149, 157, 82, 126, 161, 153, 155, 160, 82, 118, 151, 168, 155, 149, 151, 82, 155, 150, 82, 111, 82};
        tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_4))).append(this.lxxvpG7029).toString());
        String v0 = tev.piqgahor.bv55a2UiI.LwsJFOGCFaeM57984(this.lxxvpG7029, this.lBCSso510);
        android.os.Handler v2_5 = new Object[2];
        String v4_1 = new int[32];
        v4_1 = {20, 111, 103, 121, 136, 136, 125, 130, 123, 135, 85, 119, 136, 125, 138, 125, 136, 141, 113, 52, 87, 124, 121, 119, 127, 96, 131, 123, 125, 130, 78, 52};
        v2_5[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_1);
        v2_5[1] = v0;
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v2_5));
        if ((v0 != null) && (!v0.isEmpty())) {
            android.os.Message v1 = this.jhIodRFx1.obtainMessage();
            v1.arg1 = 1;
            v1.obj = v0;
            this.jhIodRFx1.sendMessage(v1);
        }
        return;
    }
}
