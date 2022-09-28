package android.support.v4.util;
 class ContainerHelpers {
    static final int[] EMPTY_INTS;
    static final long[] EMPTY_LONGS;
    static final Object[] EMPTY_OBJECTS;

    static ContainerHelpers()
    {
        Object[] v0_0 = new int[0];
        android.support.v4.util.ContainerHelpers.EMPTY_INTS = v0_0;
        Object[] v0_1 = new long[0];
        android.support.v4.util.ContainerHelpers.EMPTY_LONGS = v0_1;
        Object[] v0_2 = new Object[0];
        android.support.v4.util.ContainerHelpers.EMPTY_OBJECTS = v0_2;
        return;
    }

    ContainerHelpers()
    {
        return;
    }

    static int binarySearch(int[] p5, int p6, int p7)
    {
        int v1 = 0;
        int v0 = (p6 - 1);
        while (v1 <= v0) {
            int v2 = ((v1 + v0) >> 1);
            int v3 = p5[v2];
            if (v3 >= p7) {
                if (v3 > p7) {
                    v0 = (v2 - 1);
                }
            } else {
                v1 = (v2 + 1);
            }
            return v2;
        }
        v2 = (v1 ^ -1);
        return v2;
    }

    static int binarySearch(long[] p6, int p7, long p8)
    {
        int v1 = 0;
        int v0 = (p7 - 1);
        while (v1 <= v0) {
            int v2 = ((v1 + v0) >> 1);
            long v4 = p6[v2];
            if (v4 >= p8) {
                if (v4 > p8) {
                    v0 = (v2 - 1);
                }
            } else {
                v1 = (v2 + 1);
            }
            return v2;
        }
        v2 = (v1 ^ -1);
        return v2;
    }

    public static boolean equal(Object p1, Object p2)
    {
        if ((p1 != p2) && ((p1 == null) || (!p1.equals(p2)))) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static int idealByteArraySize(int p3)
    {
        int v0 = 4;
        while (v0 < 32) {
            if (p3 > ((1 << v0) - 12)) {
                v0++;
            } else {
                p3 = ((1 << v0) - 12);
                break;
            }
        }
        return p3;
    }

    public static int idealIntArraySize(int p1)
    {
        return (android.support.v4.util.ContainerHelpers.idealByteArraySize((p1 * 4)) / 4);
    }

    public static int idealLongArraySize(int p1)
    {
        return (android.support.v4.util.ContainerHelpers.idealByteArraySize((p1 * 8)) / 8);
    }
}
