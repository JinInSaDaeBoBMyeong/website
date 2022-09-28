package tev.piqgahor;
public class WqukitNJL {
    private static String BDuJoAUs = "";
    private static String CM3VsH7 = "";
    private static final java.text.SimpleDateFormat FdAYGNXa014 = None;
    private static String Ot1o8oBy = "";
    private static final String TonMS2977 = "";
    private static long ZUt0Ztsbd1Q2 = 0;
    private static final String drBuZ0660 = "";
    private static final String flvZzU25 = "";
    public static final int g_prog_build_date = 20220901;
    public static final long g_prog_compile_date = 202209120541;
    private static String ifTWgWOI1286;
    private static final String tPoyEaXm8;
    private static final String wqDYbk162;

    static WqukitNJL()
    {
        long v0_0 = new int[5];
        v0_0 = {9, 56, 55, 106, 118};
        tev.piqgahor.WqukitNJL.TonMS2977 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_0);
        long v0_15 = new int[8];
        v0_15 = {17, 125, 128, 120, 63, 133, 137, 133};
        tev.piqgahor.WqukitNJL.flvZzU25 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_15);
        String v1_1 = new int[20];
        v1_1 = {44, 144, 144, 90, 121, 121, 90, 165, 165, 165, 165, 76, 116, 116, 102, 153, 153, 102, 159, 159};
        tev.piqgahor.WqukitNJL.FdAYGNXa014 = new java.text.SimpleDateFormat(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_1), java.util.Locale.US);
        long v0_5 = new int[3];
        v0_5 = {5, 63, 63};
        tev.piqgahor.WqukitNJL.wqDYbk162 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_5);
        long v0_7 = new int[5];
        v0_7 = {45, 103, 103, 103, 77};
        tev.piqgahor.WqukitNJL.drBuZ0660 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_7);
        tev.piqgahor.WqukitNJL.tPoyEaXm8 = String.valueOf((System.currentTimeMillis() % 1000));
        tev.piqgahor.WqukitNJL.ZUt0Ztsbd1Q2 = -1;
        return;
    }

    public WqukitNJL()
    {
        return;
    }

    private static String FQi9ReZTn4()
    {
        if (tev.piqgahor.WqukitNJL.BDuJoAUs == null) {
            tev.piqgahor.WqukitNJL.BDuJoAUs = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return tev.piqgahor.WqukitNJL.BDuJoAUs;
    }

    public static String GetLogFileName()
    {
        if (tev.piqgahor.WqukitNJL.CM3VsH7 == null) {
            tev.piqgahor.WqukitNJL.CM3VsH7 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.kxWrVSHJ016())).append(tev.piqgahor.WqukitNJL.flvZzU25).toString();
        }
        return tev.piqgahor.WqukitNJL.CM3VsH7;
    }

    public static void PBUpfnYzPuc2378(String p2)
    {
        tev.piqgahor.WqukitNJL.ifTWgWOI1286 = p2;
        tev.piqgahor.WqukitNJL.Ot1o8oBy = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ifTWgWOI1286)).append("/").toString();
        return;
    }

    public static void VkNmRD0688(String p1)
    {
        tev.piqgahor.WqukitNJL.VkNmRD0688(p1, 0);
        return;
    }

    public static declared_synchronized void VkNmRD0688(String p14, boolean p15)
    {
        try {
            java.io.File v1_1 = new java.io.File(tev.piqgahor.WqukitNJL.GetLogFileName());
        } catch (String v7_8) {
            throw v7_8;
        } catch (String v7) {
            return;
        }
        if (!v1_1.exists()) {
            int v0_0 = new java.io.File(tev.piqgahor.WqukitNJL.kxWrVSHJ016());
            if ((v0_0.exists()) || (v0_0.mkdirs())) {
                try {
                    v1_1.createNewFile();
                } catch (String v7) {
                }
            }
        }
        int v4 = 0;
        try {
            java.io.BufferedWriter v5_1 = new java.io.BufferedWriter(new java.io.FileWriter(v1_1, 1));
            try {
                tev.piqgahor.WqukitNJL.YOBCjUR390(v5_1);
                v5_1.append(p14);
                v5_1.newLine();
                v5_1.close();
                v4 = 0;
            } catch (String v7) {
                v4 = v5_1;
            }
            if (v4 != 0) {
                v4.close();
            }
            if (!p15) {
                return;
            } else {
                long v2 = System.currentTimeMillis();
                if (tev.piqgahor.WqukitNJL.ZUt0Ztsbd1Q2 < 0) {
                    tev.piqgahor.WqukitNJL.ZUt0Ztsbd1Q2 = v2;
                }
                if (tev.piqgahor.WqukitNJL.ZUt0Ztsbd1Q2 >= (v2 - 86400000)) {
                    return;
                } else {
                    tev.piqgahor.WqukitNJL.ZUt0Ztsbd1Q2 = v2;
                    String v7_10 = new Object[4];
                    v7_10[0] = tev.piqgahor.WqukitNJL.kxWrVSHJ016();
                    String v10_4 = new int[5];
                    v10_4 = {26, 134, 137, 129, 121};
                    v7_10[1] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v10_4);
                    v7_10[2] = Long.valueOf(v2);
                    String v10_8 = new int[5];
                    v10_8 = {24, 70, 140, 144, 140};
                    v7_10[3] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v10_8);
                    v1_1.renameTo(new java.io.File(tev.piqgahor.WqukitNJL.mvoGCr4741(v7_10)));
                    return;
                }
            }
        } catch (String v7) {
        }
    }

    private static String YKQRJWP5()
    {
        return tev.piqgahor.WqukitNJL.FdAYGNXa014.format(new java.util.Date());
    }

    private static void YOBCjUR390(java.io.BufferedWriter p2)
    {
        p2.append(tev.piqgahor.WqukitNJL.YKQRJWP5()).append(tev.piqgahor.WqukitNJL.wqDYbk162).append(tev.piqgahor.WqukitNJL.tPoyEaXm8).append(tev.piqgahor.WqukitNJL.wqDYbk162).append(Thread.currentThread().getName()).append(tev.piqgahor.WqukitNJL.drBuZ0660);
        return;
    }

    public static varargs String ZkeTGysUO016(int[] p7)
    {
        int v4_1;
        int v3 = p7.length;
        if (v3 >= 2) {
            char[] v0 = new char[(v3 - 1)];
            int v1 = 1;
            while (v1 < v3) {
                v0[(v1 - 1)] = ((char) (((p7[v1] + 128) - (p7[0] % 128)) % 128));
                v1++;
            }
            v4_1 = String.valueOf(v0);
        } else {
            v4_1 = 0;
        }
        return v4_1;
    }

    public static void bVpVznHRcz6937()
    {
        java.io.File v2_1 = new java.io.File(tev.piqgahor.WqukitNJL.kxWrVSHJ016());
        if (v2_1.exists()) {
            java.io.File v1_0 = new java.io.File(v2_1, tev.piqgahor.WqukitNJL.flvZzU25);
            if (v1_0.exists()) {
                String v3_2 = new Object[3];
                String v5_0 = new int[5];
                v5_0 = {31, 139, 142, 134, 126};
                v3_2[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_0);
                v3_2[1] = Long.valueOf(tev.piqgahor.WqukitNJL.cjUErzxQO836());
                String v5_3 = new int[5];
                v5_3 = {43, 89, 159, 163, 159};
                v3_2[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_3);
                v1_0.renameTo(new java.io.File(v2_1, tev.piqgahor.WqukitNJL.mvoGCr4741(v3_2)));
            }
        }
        return;
    }

    public static long cjUErzxQO836()
    {
        long v0 = System.currentTimeMillis();
        if (v0 <= 0) {
            v0 = java.util.Calendar.getInstance().getTimeInMillis();
        }
        return v0;
    }

    public static void csjoTSWLw325(android.content.Context p0, String p1, boolean p2)
    {
        tev.piqgahor.ttnC03lWapO.Ywa694JVQq = p1;
        return;
    }

    public static String kxWrVSHJ016()
    {
        return tev.piqgahor.WqukitNJL.kxWrVSHJ016(1);
    }

    public static String kxWrVSHJ016(boolean p2)
    {
        if (tev.piqgahor.WqukitNJL.Ot1o8oBy == null) {
            tev.piqgahor.WqukitNJL.ifTWgWOI1286 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.FQi9ReZTn4())).append(tev.piqgahor.WqukitNJL.TonMS2977).toString();
            tev.piqgahor.WqukitNJL.Ot1o8oBy = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ifTWgWOI1286)).append("/").toString();
        }
        String v0_8;
        if (!p2) {
            v0_8 = tev.piqgahor.WqukitNJL.ifTWgWOI1286;
        } else {
            v0_8 = tev.piqgahor.WqukitNJL.Ot1o8oBy;
        }
        return v0_8;
    }

    public static varargs String mvoGCr4741(Object[] p4)
    {
        OutOfMemoryError v3_4;
        int v0 = p4.length;
        if (v0 != 0) {
            StringBuilder v2_1 = new StringBuilder(64);
            int v1 = 0;
            while (v1 < v0) {
                if ((!(p4[v1] instanceof String)) || (!((String) p4[v1]).isEmpty())) {
                    try {
                        v2_1.append(p4[v1]);
                    } catch (OutOfMemoryError v3) {
                        break;
                    }
                }
                v1++;
            }
            v3_4 = v2_1.toString();
        } else {
            v3_4 = 0;
        }
        return v3_4;
    }
}
