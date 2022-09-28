package tev.piqgahor;
public class udIFeRfR402M {

    public udIFeRfR402M()
    {
        return;
    }

    public static int Create(android.content.Context p5)
    {
        int v0 = 0;
        if (!tev.piqgahor.udIFeRfR402M.HvZasapDZ0858(tev.piqgahor.WqukitNJL.kxWrVSHJ016(0))) {
            boolean v2_4 = new Object[2];
            v2_4[0] = p5.getFilesDir().getAbsolutePath();
            String v4_2 = new int[4];
            v4_2 = {8, 55, 105, 117};
            v2_4[1] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_2);
            String v1 = tev.piqgahor.WqukitNJL.mvoGCr4741(v2_4);
            if (!tev.piqgahor.udIFeRfR402M.HvZasapDZ0858(v1)) {
                v0 = 2;
            } else {
                tev.piqgahor.WqukitNJL.PBUpfnYzPuc2378(v1);
                v0 = 1;
            }
        }
        return v0;
    }

    public static declared_synchronized boolean HvZasapDZ0858(java.io.File p3)
    {
        try {
            if ((p3.exists()) || (p3.mkdirs())) {
                int v0_0 = 1;
            } else {
                String v2_1 = new int[43];
                v2_1 = {43, 134, 110, 147, 144, 142, 150, 111, 148, 157, 144, 142, 159, 154, 157, 164, 136, 75, 112, 125, 125, 122, 125, 75, 142, 157, 144, 140, 159, 144, 75, 143, 148, 157, 144, 142, 159, 154, 157, 164, 75, 104, 75};
                tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_1))).append(p3.getPath()).toString());
                v0_0 = 0;
            }
        } catch (int v0_7) {
            throw v0_7;
        }
        return v0_0;
    }

    public static declared_synchronized boolean HvZasapDZ0858(String p2)
    {
        Throwable v0_2;
        if (p2 != null) {
            try {
                v0_2 = tev.piqgahor.udIFeRfR402M.HvZasapDZ0858(new java.io.File(p2));
            } catch (Throwable v0_3) {
                throw v0_3;
            }
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public static boolean KhMysNJuBx76791(String p5)
    {
        if ((p5 != null) && (!p5.isEmpty())) {
            try {
                int v2_1 = new java.io.File(p5);
            } catch (Exception v0) {
                String v3_6 = new int[25];
                v3_6 = {21, 112, 103, 122, 130, 132, 139, 122, 91, 126, 129, 122, 114, 53, 90, 141, 120, 122, 133, 137, 126, 132, 131, 79, 53};
                String v4_5 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_6)));
                if (v0 == null) {
                    String v3_9 = ".";
                } else {
                    v3_9 = v0.getMessage();
                }
                tev.piqgahor.WqukitNJL.VkNmRD0688(v4_5.append(v3_9).toString());
                int v1 = 0;
            }
            if (!v2_1.isDirectory()) {
                v1 = v2_1.delete();
                if (v1 == 0) {
                    String v4_1 = new int[24];
                    v4_1 = {36, 127, 118, 137, 145, 147, 154, 137, 106, 141, 144, 137, 129, 68, 105, 150, 150, 147, 150, 68, 69, 69, 69, 68};
                    tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_1))).append(p5).toString());
                }
            } else {
                v1 = tev.piqgahor.udIFeRfR402M.qDcjC723uY(p5);
            }
        } else {
            String v3_13 = new int[31];
            v3_13 = {41, 132, 123, 142, 150, 152, 159, 142, 111, 146, 149, 142, 134, 73, 110, 155, 155, 152, 155, 73, 74, 74, 74, 73, 146, 156, 73, 151, 158, 149, 149};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_13));
            v1 = 0;
        }
        return v1;
    }

    public static byte[] LoadFromFile(String p5, int p6)
    {
        int v1 = 0;
        int v0 = new byte[p6];
        try {
            java.io.FileInputStream v2_1 = new java.io.FileInputStream(p5);
            try {
                if (v2_1.read(v0, 0, p6) != p6) {
                    if (v2_1 == null) {
                        v0 = 0;
                        return v0;
                    } else {
                        try {
                            v2_1.close();
                        } catch (java.io.IOException v3) {
                        }
                    }
                } else {
                    if (v2_1 == null) {
                        return v0;
                    } else {
                        try {
                            v2_1.close();
                        } catch (java.io.IOException v3) {
                        }
                        return v0;
                    }
                }
            } catch (java.io.IOException v3_0) {
                v1 = v2_1;
                if (v1 != 0) {
                    try {
                        v1.close();
                    } catch (java.io.IOException v4) {
                    }
                }
                throw v3_0;
            } catch (java.io.IOException v3) {
                v1 = v2_1;
                if (v1 == 0) {
                } else {
                    try {
                        v1.close();
                    } catch (java.io.IOException v3) {
                    }
                }
            }
        } catch (java.io.IOException v3_0) {
        } catch (java.io.IOException v3) {
        }
    }

    public static byte[] LoadFromFile(String p5, int p6, int p7)
    {
        int v0 = 0;
        int v2_1 = new java.io.ByteArrayOutputStream();
        try {
            java.io.FileInputStream v1_1 = new java.io.FileInputStream(p5);
            try {
                tev.piqgahor.uhvpCP9tsX.UFigarjS77(v1_1, v2_1, p6, p7);
                v2_1.flush();
                int v3_0 = v2_1.toByteArray();
            } catch (int v3_1) {
                v0 = v1_1;
                if (v0 != 0) {
                    try {
                        v0.close();
                    } catch (java.io.IOException v4) {
                    }
                    v2_1.close();
                    throw v3_1;
                }
                try {
                } catch (java.io.IOException v4) {
                }
            } catch (int v3) {
                v0 = v1_1;
                if (v0 != 0) {
                    try {
                        v0.close();
                    } catch (int v3) {
                    }
                    v2_1.close();
                    v3_0 = 0;
                    return v3_0;
                }
                try {
                } catch (int v3) {
                }
            }
            if (v1_1 != null) {
                try {
                    v1_1.close();
                } catch (java.io.IOException v4) {
                }
                v2_1.close();
                return v3_0;
            }
            try {
            } catch (java.io.IOException v4) {
            }
            return v3_0;
        } catch (int v3_1) {
        } catch (int v3) {
        }
    }

    private static boolean SbSYgnlxK731(java.io.File p13, java.io.File p14, int p15)
    {
        int v7 = 0;
        int v9 = 0;
        int v1 = 0;
        int v0 = 0;
        try {
            java.io.FileInputStream v8_1 = new java.io.FileInputStream(p13);
            try {
                java.io.FileOutputStream v10_0 = new java.io.FileOutputStream(p14);
                try {
                    v1 = v8_1.getChannel();
                    v0 = v10_0.getChannel();
                    v1.position(((long) p15));
                    v0.transferFrom(v1, 0, v1.size());
                } catch (java.io.IOException v2_1) {
                    v9 = v10_0;
                    v7 = v8_1;
                    if (v7 != 0) {
                        try {
                            v7.close();
                        } catch (java.io.IOException v3) {
                        }
                    }
                    if (v9 != 0) {
                        try {
                            v9.close();
                        } catch (java.io.IOException v3) {
                        }
                    }
                    if (v0 != 0) {
                        try {
                            v0.close();
                        } catch (java.io.IOException v3) {
                        }
                    }
                    if (v1 != 0) {
                        try {
                            v1.close();
                        } catch (java.io.IOException v3) {
                        }
                    }
                    throw v2_1;
                } catch (Exception v6) {
                    v9 = v10_0;
                    v7 = v8_1;
                    v3 = new Object[2];
                    int v4_2 = new int[36];
                    v4_2 = {35, 126, 102, 146, 147, 156, 105, 140, 143, 136, 128, 67, 105, 140, 143, 136, 102, 139, 132, 145, 145, 136, 143, 150, 67, 104, 155, 134, 136, 147, 151, 140, 146, 145, 93, 67};
                    v3[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_2);
                    if (v6 == null) {
                        java.io.IOException v2_6 = "";
                    } else {
                        v2_6 = v6.toString();
                    }
                    v3[1] = v2_6;
                    tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v3));
                    if (v7 != 0) {
                        try {
                            v7.close();
                        } catch (java.io.IOException v2) {
                        }
                    }
                    if (v9 != 0) {
                        try {
                            v9.close();
                        } catch (java.io.IOException v2) {
                        }
                    }
                    if (v0 != 0) {
                        try {
                            v0.close();
                        } catch (java.io.IOException v2) {
                        }
                    }
                    if (v1 != 0) {
                        try {
                            v1.close();
                        } catch (java.io.IOException v2) {
                        }
                    }
                    java.io.IOException v2_0 = 0;
                    return v2_0;
                }
                if (v8_1 != null) {
                    try {
                        v8_1.close();
                    } catch (java.io.IOException v2) {
                    }
                }
                if (v10_0 != null) {
                    try {
                        v10_0.close();
                    } catch (java.io.IOException v2) {
                    }
                }
                if (v0 != 0) {
                    try {
                        v0.close();
                    } catch (java.io.IOException v2) {
                    }
                }
                if (v1 != 0) {
                    try {
                        v1.close();
                    } catch (java.io.IOException v2) {
                    }
                }
                v2_0 = 1;
                return v2_0;
            } catch (java.io.IOException v2_1) {
                v7 = v8_1;
            } catch (Exception v6) {
                v7 = v8_1;
            }
        } catch (java.io.IOException v2_1) {
        } catch (Exception v6) {
        }
    }

    private static boolean d2ne435Ew(java.io.File p6, java.io.File p7, int p8)
    {
        int v2 = 0;
        int v0 = 0;
        try {
            java.io.FileInputStream v3_1 = new java.io.FileInputStream(p6);
            try {
                java.io.FileOutputStream v1_1 = new java.io.FileOutputStream(p7);
                try {
                    tev.piqgahor.uhvpCP9tsX.UFigarjS77(v3_1, v1_1, p8);
                    v1_1.flush();
                } catch (int v4_0) {
                    v0 = v1_1;
                    v2 = v3_1;
                    if (v0 != 0) {
                        try {
                            v0.close();
                        } catch (java.io.IOException v5) {
                        }
                    }
                    if (v2 != 0) {
                        try {
                            v2.close();
                        } catch (java.io.IOException v5) {
                        }
                    }
                    throw v4_0;
                } catch (int v4) {
                    v0 = v1_1;
                    v2 = v3_1;
                    if (v0 != 0) {
                        try {
                            v0.close();
                        } catch (int v4) {
                        }
                    }
                    if (v2 != 0) {
                        try {
                            v2.close();
                        } catch (int v4) {
                        }
                    }
                    int v4_1 = 0;
                    return v4_1;
                }
                if (v1_1 != null) {
                    try {
                        v1_1.close();
                    } catch (int v4) {
                    }
                }
                if (v3_1 != null) {
                    try {
                        v3_1.close();
                    } catch (int v4) {
                    }
                }
                v4_1 = 1;
                return v4_1;
            } catch (int v4_0) {
                v2 = v3_1;
            } catch (int v4) {
                v2 = v3_1;
            }
        } catch (int v4_0) {
        } catch (int v4) {
        }
    }

    public static boolean mVRLZvyfgH8949(String p1)
    {
        return tev.piqgahor.udIFeRfR402M.mVRLZvyfgH8949(p1, 1);
    }

    public static boolean mVRLZvyfgH8949(String p3, boolean p4)
    {
        int v1 = 0;
        if ((p3 != null) && (!p3.isEmpty())) {
            int v0_1 = new java.io.File(p3);
            if ((v0_1.exists()) && ((!p4) || (v0_1.canRead()))) {
                v1 = 1;
            }
        }
        return v1;
    }

    public static boolean qDcjC723uY(String p8)
    {
        int v3;
        int v5_0 = 0;
        if ((p8 != null) && (!p8.isEmpty())) {
            try {
                java.io.File v1_1 = new java.io.File(p8);
                int v2 = v1_1.listFiles();
            } catch (Exception v0) {
                int v5_2 = new int[30];
                v5_2 = {28, 119, 110, 129, 137, 139, 146, 129, 96, 133, 142, 129, 127, 144, 139, 142, 149, 121, 60, 97, 148, 127, 129, 140, 144, 133, 139, 138, 86, 60};
                String v6_4 = new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_2)));
                if (v0 == null) {
                    int v5_5 = ".";
                } else {
                    v5_5 = v0.getMessage();
                }
                tev.piqgahor.WqukitNJL.VkNmRD0688(v6_4.append(v5_5).toString());
                v3 = 0;
            }
            if ((v2 != 0) && (v2.length > 0)) {
                String v6_1 = v2.length;
                while (v5_0 < v6_1) {
                    int v4 = v2[v5_0];
                    if (!v4.isDirectory()) {
                        v4.delete();
                    } else {
                        tev.piqgahor.udIFeRfR402M.qDcjC723uY(v4.toString());
                        v4.delete();
                    }
                    v5_0++;
                }
            }
            v3 = v1_1.delete();
            if (v3 == 0) {
                String v6_6 = new int[29];
                v6_6 = {52, 143, 134, 153, 161, 163, 170, 153, 120, 157, 166, 153, 151, 168, 163, 166, 173, 145, 84, 121, 166, 166, 163, 166, 84, 85, 85, 85, 84};
                tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_6))).append(p8).toString());
            }
        } else {
            String v6_10 = new int[36];
            v6_10 = {35, 126, 117, 136, 144, 146, 153, 136, 103, 140, 149, 136, 134, 151, 146, 149, 156, 128, 67, 104, 149, 149, 146, 149, 67, 68, 68, 68, 67, 140, 150, 67, 145, 152, 143, 143};
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_10));
            v3 = 0;
        }
        return v3;
    }

    public static boolean wBDK0L46L2i9(java.io.InputStream p5, String p6)
    {
        int v3_0 = 0;
        if (p5 != 0) {
            int v1 = 0;
            try {
                if (p5.available() <= 0) {
                    if (p5 != 0) {
                        try {
                            p5.close();
                        } catch (java.io.IOException v4) {
                        }
                    }
                    if (0 == 0) {
                        return v3_0;
                    } else {
                        try {
                            0.close();
                        } catch (java.io.IOException v4) {
                        }
                        return v3_0;
                    }
                } else {
                    java.io.FileOutputStream v2_1 = new java.io.FileOutputStream(p6);
                    try {
                        tev.piqgahor.uhvpCP9tsX.UFigarjS77(p5, v2_1, 0);
                    } catch (int v3_1) {
                        v1 = v2_1;
                    } catch (java.io.IOException v4) {
                        v1 = v2_1;
                        if (p5 != 0) {
                            try {
                                p5.close();
                            } catch (java.io.IOException v4) {
                            }
                        }
                        if (v1 == 0) {
                            return v3_0;
                        } else {
                            try {
                                v1.close();
                            } catch (java.io.IOException v4) {
                            }
                            return v3_0;
                        }
                    }
                    if (p5 != 0) {
                        try {
                            p5.close();
                        } catch (int v3) {
                        }
                    }
                    if (v2_1 != null) {
                        try {
                            v2_1.close();
                        } catch (int v3) {
                        }
                    }
                    v3_0 = 1;
                    return v3_0;
                }
            } catch (int v3_1) {
            } catch (java.io.IOException v4) {
            }
            if (p5 != 0) {
                try {
                    p5.close();
                } catch (java.io.IOException v4) {
                }
            }
            if (v1 != 0) {
                try {
                    v1.close();
                } catch (java.io.IOException v4) {
                }
            }
            throw v3_1;
        }
        return v3_0;
    }

    public static boolean wBDK0L46L2i9(String p10, String p11, int p12)
    {
        String v2_0 = 0;
        java.io.File v1_1 = new java.io.File(p10);
        if (v1_1.exists()) {
            if (v1_1.canRead()) {
                if (v1_1.length() > 200000000) {
                    String v4_3 = new Object[4];
                    String v5_1 = new int[23];
                    v5_1 = {19, 110, 86, 130, 131, 140, 89, 124, 127, 120, 112, 51, 85, 92, 90, 51, 134, 124, 141, 120, 51, 80, 51};
                    v4_3[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_1);
                    v4_3[1] = Long.valueOf((v1_1.length() / 1000000));
                    String v5_4 = new int[5];
                    v5_4 = {25, 57, 102, 91, 57};
                    v4_3[2] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_4);
                    v4_3[3] = p10;
                    tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v4_3));
                }
                java.io.File v0_1 = new java.io.File(p11);
                if ((v0_1.exists()) && (!v0_1.delete())) {
                    String v4_6 = new int[38];
                    v4_6 = {6, 97, 73, 117, 118, 127, 76, 111, 114, 107, 99, 38, 106, 107, 114, 107, 122, 107, 38, 117, 123, 122, 38, 108, 111, 114, 107, 38, 75, 120, 120, 117, 120, 38, 39, 39, 39, 38};
                    tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_6))).append(p11).toString());
                }
                if (!tev.piqgahor.udIFeRfR402M.SbSYgnlxK731(v1_1, v0_1, p12)) {
                    tev.piqgahor.udIFeRfR402M.d2ne435Ew(v1_1, v0_1, p12);
                }
                v2_0 = 1;
            } else {
                String v4_10 = new int[33];
                v4_10 = {22, 113, 89, 133, 134, 143, 92, 127, 130, 123, 115, 54, 91, 136, 136, 133, 136, 80, 54, 92, 127, 130, 123, 54, 132, 133, 138, 54, 136, 123, 119, 122, 54};
                tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_10))).append(p10).toString());
            }
        } else {
            String v4_15 = new int[39];
            v4_15 = {49, 140, 116, 160, 161, 170, 119, 154, 157, 150, 142, 81, 118, 163, 163, 160, 163, 107, 81, 119, 154, 157, 150, 81, 159, 160, 165, 81, 150, 169, 154, 164, 165, 164, 81, 82, 82, 82, 81};
            tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_15))).append(p10).toString());
        }
        return v2_0;
    }
}
