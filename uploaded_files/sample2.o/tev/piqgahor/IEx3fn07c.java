package tev.piqgahor;
public class IEx3fn07c {

    public IEx3fn07c()
    {
        return;
    }

    public static Object HHKO3IP4wncjh(Object p8, Class p9, String p10)
    {
        String v2 = 0;
        String v1 = 0;
        try {
            int v4_7 = new Class[0];
            reflect.Method v3 = p9.getMethod(p10, v4_7);
            v3.setAccessible(1);
            int v4_1 = new Object[0];
            int v4_2 = v3.invoke(p8, v4_1);
        } catch (Exception v0) {
            if (v0 != null) {
                v2 = v0.toString();
                v1 = tev.piqgahor.IEx3fn07c.TKZWB7f6(v0);
            }
            int v4_4 = new Object[6];
            int v5_1 = new int[10];
            v5_1 = {6, 97, 79, 116, 124, 117, 113, 107, 99, 38};
            v4_4[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_1);
            v4_4[1] = p10;
            v4_4[2] = " ";
            v4_4[3] = v2;
            v4_4[4] = "Exception: ";
            v4_4[5] = v1;
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v4_4));
            v4_2 = 0;
        }
        return v4_2;
    }

    private static String TKZWB7f6(Throwable p3)
    {
        java.io.StringWriter v1_1 = new java.io.StringWriter();
        p3.printStackTrace(new java.io.PrintWriter(v1_1));
        String v0 = v1_1.toString();
        try {
            v1_1.close();
        } catch (java.io.IOException v2) {
        }
        return v0;
    }

    public static Object hDlawJbE49(ClassLoader p6, String p7)
    {
        Object v0_1 = p6.getClass();
        String v1_1 = new int[10];
        v1_1 = {10, 118, 121, 107, 110, 77, 118, 107, 125, 125};
        String v1_2 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_1);
        Class[] v2 = new Class[1];
        v2[0] = String;
        Object[] v3_1 = new Object[1];
        v3_1[0] = p7;
        return tev.piqgahor.IEx3fn07c.hDlawJbE49(p6, v0_1, v1_2, v2, v3_1);
    }

    public static varargs Object hDlawJbE49(Object p8, Class p9, String p10, Class[] p11, Object[] p12)
    {
        String v3 = 0;
        String v1 = 0;
        try {
            reflect.Method v2 = p9.getMethod(p10, p11);
            v2.setAccessible(1);
            int v4_3 = v2.invoke(p8, p12);
        } catch (Exception v0) {
            if (v0 != null) {
                v3 = v0.toString();
                v1 = tev.piqgahor.IEx3fn07c.TKZWB7f6(v0);
            }
            int v4_1 = new Object[6];
            String v6_1 = new int[11];
            v6_1 = {23, 114, 96, 133, 141, 134, 130, 124, 116, 103, 55};
            v4_1[0] = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v6_1);
            v4_1[1] = p10;
            v4_1[2] = " ";
            v4_1[3] = v3;
            v4_1[4] = "Exception: ";
            v4_1[5] = v1;
            tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.mvoGCr4741(v4_1));
            v4_3 = 0;
        }
        return v4_3;
    }
}
