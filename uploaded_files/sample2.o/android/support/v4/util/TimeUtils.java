package android.support.v4.util;
public class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;

    static TimeUtils()
    {
        android.support.v4.util.TimeUtils.sFormatSync = new Object();
        char[] v0_3 = new char[24];
        android.support.v4.util.TimeUtils.sFormatStr = v0_3;
        return;
    }

    public TimeUtils()
    {
        return;
    }

    private static int accumField(int p1, int p2, boolean p3, int p4)
    {
        if ((p1 <= 99) && ((!p3) || (p4 < 3))) {
            if ((p1 <= 9) && ((!p3) || (p4 < 2))) {
                if ((!p3) && (p1 <= 0)) {
                    int v0_1 = 0;
                } else {
                    v0_1 = (p2 + 1);
                }
            } else {
                v0_1 = (p2 + 2);
            }
        } else {
            v0_1 = (p2 + 3);
        }
        return v0_1;
    }

    public static void formatDuration(long p4, long p6, java.io.PrintWriter p8)
    {
        if (p4 != 0) {
            android.support.v4.util.TimeUtils.formatDuration((p4 - p6), p8, 0);
        } else {
            p8.print("--");
        }
        return;
    }

    public static void formatDuration(long p2, java.io.PrintWriter p4)
    {
        android.support.v4.util.TimeUtils.formatDuration(p2, p4, 0);
        return;
    }

    public static void formatDuration(long p6, java.io.PrintWriter p8, int p9)
    {
        try {
            p8.print(new String(android.support.v4.util.TimeUtils.sFormatStr, 0, android.support.v4.util.TimeUtils.formatDurationLocked(p6, p9)));
            return;
        } catch (Throwable v1_2) {
            throw v1_2;
        }
    }

    public static void formatDuration(long p4, StringBuilder p6)
    {
        try {
            p6.append(android.support.v4.util.TimeUtils.sFormatStr, 0, android.support.v4.util.TimeUtils.formatDurationLocked(p4, 0));
            return;
        } catch (Throwable v1_2) {
            throw v1_2;
        }
    }

    private static int formatDurationLocked(long p20, int p22)
    {
        if (android.support.v4.util.TimeUtils.sFormatStr.length < p22) {
            int v4_16 = new char[p22];
            android.support.v4.util.TimeUtils.sFormatStr = v4_16;
        }
        int v4_5;
        char[] v2 = android.support.v4.util.TimeUtils.sFormatStr;
        if (p20 != 0) {
            int v16;
            if (p20 <= 0) {
                v16 = 45;
                p20 = (- p20);
            } else {
                v16 = 43;
            }
            int v13 = ((int) (p20 % 1000));
            int v17 = ((int) Math.floor(((double) (p20 / 1000))));
            int v3 = 0;
            int v12 = 0;
            int v14 = 0;
            if (v17 > 86400) {
                v3 = (v17 / 86400);
                v17 -= (86400 * v3);
            }
            if (v17 > 3600) {
                v12 = (v17 / 3600);
                v17 -= (v12 * 3600);
            }
            if (v17 > 60) {
                v14 = (v17 / 60);
                v17 -= (v14 * 60);
            }
            int v5_5 = 0;
            if (p22 != 0) {
                int v4_19;
                int v15_1 = android.support.v4.util.TimeUtils.accumField(v3, 1, 0, 0);
                if (v15_1 <= 0) {
                    v4_19 = 0;
                } else {
                    v4_19 = 1;
                }
                int v4_21;
                int v15_2 = (v15_1 + android.support.v4.util.TimeUtils.accumField(v12, 1, v4_19, 2));
                if (v15_2 <= 0) {
                    v4_21 = 0;
                } else {
                    v4_21 = 1;
                }
                int v4_23;
                int v15_3 = (v15_2 + android.support.v4.util.TimeUtils.accumField(v14, 1, v4_21, 2));
                if (v15_3 <= 0) {
                    v4_23 = 0;
                } else {
                    v4_23 = 1;
                }
                int v4_25;
                int v15_4 = (v15_3 + android.support.v4.util.TimeUtils.accumField(v17, 1, v4_23, 2));
                if (v15_4 <= 0) {
                    v4_25 = 0;
                } else {
                    v4_25 = 3;
                }
                int v15_0 = (v15_4 + (android.support.v4.util.TimeUtils.accumField(v13, 2, 1, v4_25) + 1));
                while (v15_0 < p22) {
                    v2[v5_5] = 32;
                    v5_5++;
                    v15_0++;
                }
            }
            int v19;
            v2[v5_5] = v16;
            int v5_7 = (v5_5 + 1);
            int v18 = v5_7;
            if (p22 == 0) {
                v19 = 0;
            } else {
                v19 = 1;
            }
            int v10_0;
            int v5_0 = android.support.v4.util.TimeUtils.printField(v2, v3, 100, v5_7, 0, 0);
            if (v5_0 == v18) {
                v10_0 = 0;
            } else {
                v10_0 = 1;
            }
            int v11_0;
            if (v19 == 0) {
                v11_0 = 0;
            } else {
                v11_0 = 2;
            }
            int v10_1;
            int v5_1 = android.support.v4.util.TimeUtils.printField(v2, v12, 104, v5_0, v10_0, v11_0);
            if (v5_1 == v18) {
                v10_1 = 0;
            } else {
                v10_1 = 1;
            }
            int v11_1;
            if (v19 == 0) {
                v11_1 = 0;
            } else {
                v11_1 = 2;
            }
            int v10_2;
            int v5_2 = android.support.v4.util.TimeUtils.printField(v2, v14, 109, v5_1, v10_1, v11_1);
            if (v5_2 == v18) {
                v10_2 = 0;
            } else {
                v10_2 = 1;
            }
            int v11_2;
            if (v19 == 0) {
                v11_2 = 0;
            } else {
                v11_2 = 2;
            }
            int v11_3;
            int v5_3 = android.support.v4.util.TimeUtils.printField(v2, v17, 115, v5_2, v10_2, v11_2);
            if ((v19 == 0) || (v5_3 == v18)) {
                v11_3 = 0;
            } else {
                v11_3 = 3;
            }
            int v5_4 = android.support.v4.util.TimeUtils.printField(v2, v13, 109, v5_3, 1, v11_3);
            v2[v5_4] = 115;
            v4_5 = (v5_4 + 1);
        } else {
            int v22_1 = (p22 - 1);
            while (0 < v22_1) {
                v2[0] = 32;
            }
            v2[0] = 48;
            v4_5 = 1;
        }
        return v4_5;
    }

    private static int printField(char[] p3, int p4, char p5, int p6, boolean p7, int p8)
    {
        if ((p7) || (p4 > 0)) {
            if (((p7) && (p8 >= 3)) || (p4 > 99)) {
                int v0_1 = (p4 / 100);
                p3[p6] = ((char) (v0_1 + 48));
                p6++;
                p4 -= (v0_1 * 100);
            }
            if (((p7) && (p8 >= 2)) || ((p4 > 9) || (p6 != p6))) {
                int v0_0 = (p4 / 10);
                p3[p6] = ((char) (v0_0 + 48));
                p6++;
                p4 -= (v0_0 * 10);
            }
            p3[p6] = ((char) (p4 + 48));
            int v6_1 = (p6 + 1);
            p3[v6_1] = p5;
            p6 = (v6_1 + 1);
        }
        return p6;
    }
}
