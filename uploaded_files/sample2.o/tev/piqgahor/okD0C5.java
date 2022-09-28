package tev.piqgahor;
public class okD0C5 extends android.app.Activity {
    private org.webrtc.SurfaceViewRenderer ISUNYW6708;
    private org.webrtc.EglBase wrBSKPe267;

    public okD0C5()
    {
        return;
    }

    private static int yNo4PmqIBfjy()
    {
        int v0 = 6;
        if (android.os.Build$VERSION.SDK_INT >= 19) {
            v0 = (6 | 4096);
        }
        return v0;
    }

    protected void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        this.requestWindowFeature(1);
        this.getWindow().addFlags(6816896);
        this.setContentView(2130903042);
        if (android.os.Build$VERSION.SDK_INT < 30) {
            this.getWindow().getDecorView().setSystemUiVisibility(tev.piqgahor.okD0C5.yNo4PmqIBfjy());
        } else {
            this.getWindow().setDecorFitsSystemWindows(0);
            if (this.getWindow().getInsetsController() != null) {
                this.getWindow().getInsetsController().hide((android.view.WindowInsets$Type.statusBars() | android.view.WindowInsets$Type.navigationBars()));
                this.getWindow().getInsetsController().setSystemBarsBehavior(2);
            }
        }
        String v0_11 = new int[23];
        v0_11 = {9, 100, 96, 110, 107, 91, 125, 108, 96, 119, 109, 102, 41, 76, 123, 110, 106, 125, 110, 41, 42, 42, 42};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_11));
        this.ISUNYW6708 = ((org.webrtc.SurfaceViewRenderer) this.findViewById(2131230753));
        this.wrBSKPe267 = org.webrtc.EglBase.create();
        this.ISUNYW6708.init(this.wrBSKPe267.getEglBaseContext(), 0);
        this.ISUNYW6708.setScalingType(org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FILL);
        this.ISUNYW6708.setEnableHardwareScaler(1);
        if (!tev.piqgahor.zh7eZ9E.CVMRpM090()) {
            String v0_23 = new int[41];
            v0_23 = {8, 99, 95, 109, 106, 90, 124, 107, 95, 118, 108, 101, 40, 75, 122, 109, 105, 124, 109, 40, 77, 90, 90, 87, 90, 40, 41, 41, 41, 40, 118, 119, 40, 113, 118, 123, 124, 105, 118, 123, 109};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_23));
            this.finish();
        } else {
            tev.piqgahor.zh7eZ9E.QCNZ4fl6z106(1);
            tev.piqgahor.zh7eZ9E.scjlrpZJCgn(this.ISUNYW6708, this.wrBSKPe267.getEglBaseContext(), 1);
        }
        return;
    }

    public void onDestroy()
    {
        if (tev.piqgahor.zh7eZ9E.CVMRpM090()) {
            tev.piqgahor.zh7eZ9E.QCNZ4fl6z106(0);
            tev.piqgahor.zh7eZ9E.scjlrpZJCgn(0, 0, 0);
        }
        if (this.ISUNYW6708 != null) {
            this.ISUNYW6708.release();
            this.ISUNYW6708 = 0;
        }
        this.wrBSKPe267.release();
        String v0_2 = new int[24];
        v0_2 = {51, 142, 138, 152, 149, 133, 167, 150, 138, 161, 151, 144, 83, 119, 152, 166, 167, 165, 162, 172, 83, 84, 84, 84};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
        super.onDestroy();
        return;
    }

    protected void onNewIntent(android.content.Intent p5)
    {
        super.onNewIntent(p5);
        if (p5 != null) {
            android.os.Bundle v0 = p5.getExtras();
            if (v0 != null) {
                String v2_5 = new int[5];
                v2_5 = {35, 142, 136, 136, 147};
                boolean v1 = v0.getBoolean(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_5), 1);
                String v3_2 = new int[31];
                v3_2 = {11, 102, 98, 112, 109, 93, 127, 110, 98, 121, 111, 104, 43, 89, 112, 130, 84, 121, 127, 112, 121, 127, 55, 43, 118, 112, 112, 123, 43, 72, 43};
                tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_2))).append(String.valueOf(v1)).toString());
                if (!v1) {
                    this.finish();
                }
            }
        }
        return;
    }

    protected void onResume()
    {
        super.onResume();
        org.webrtc.SurfaceViewRenderer v0_3 = new int[23];
        v0_3 = {32, 123, 119, 133, 130, 114, 148, 131, 119, 142, 132, 125, 64, 114, 133, 147, 149, 141, 133, 64, 65, 65, 65};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_3));
        if (tev.piqgahor.zh7eZ9E.CVMRpM090()) {
            tev.piqgahor.zh7eZ9E.QCNZ4fl6z106(1);
            tev.piqgahor.zh7eZ9E.scjlrpZJCgn(this.ISUNYW6708, this.wrBSKPe267.getEglBaseContext(), 0);
        }
        return;
    }

    public void onStop()
    {
        int v0_2 = new int[21];
        v0_2 = {26, 117, 113, 127, 124, 108, 142, 125, 113, 136, 126, 119, 58, 109, 142, 137, 138, 58, 59, 59, 59};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
        if (tev.piqgahor.zh7eZ9E.CVMRpM090()) {
            tev.piqgahor.zh7eZ9E.scjlrpZJCgn(0, 0, 0);
        }
        super.onStop();
        return;
    }
}
