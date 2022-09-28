package android.support.v4.util;
public class SimpleArrayMap {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = False;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap()
    {
        this.mHashes = android.support.v4.util.ContainerHelpers.EMPTY_INTS;
        this.mArray = android.support.v4.util.ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
        return;
    }

    public SimpleArrayMap(int p2)
    {
        if (p2 != 0) {
            this.allocArrays(p2);
        } else {
            this.mHashes = android.support.v4.util.ContainerHelpers.EMPTY_INTS;
            this.mArray = android.support.v4.util.ContainerHelpers.EMPTY_OBJECTS;
        }
        this.mSize = 0;
        return;
    }

    public SimpleArrayMap(android.support.v4.util.SimpleArrayMap p1)
    {
        if (p1 != null) {
            this.putAll(p1);
        }
        return;
    }

    private void allocArrays(int p6)
    {
        if (p6 != 8) {
            if (p6 != 4) {
                int v1_14 = new int[p6];
                this.mHashes = v1_14;
                int v1_16 = new Object[(p6 << 1)];
                this.mArray = v1_16;
            } else {
                try {
                    if (android.support.v4.util.SimpleArrayMap.mBaseCache == null) {
                    } else {
                        Object[] v0_1 = android.support.v4.util.SimpleArrayMap.mBaseCache;
                        this.mArray = v0_1;
                        android.support.v4.util.SimpleArrayMap.mBaseCache = ((Object[]) ((Object[]) v0_1[0]));
                        this.mHashes = ((int[]) ((int[]) v0_1[1]));
                        v0_1[1] = 0;
                        v0_1[0] = 0;
                        android.support.v4.util.SimpleArrayMap.mBaseCacheSize = (android.support.v4.util.SimpleArrayMap.mBaseCacheSize - 1);
                    }
                } catch (int v1_12) {
                    throw v1_12;
                }
            }
        } else {
            if (android.support.v4.util.SimpleArrayMap.mTwiceBaseCache == null) {
            } else {
                Object[] v0_0 = android.support.v4.util.SimpleArrayMap.mTwiceBaseCache;
                this.mArray = v0_0;
                android.support.v4.util.SimpleArrayMap.mTwiceBaseCache = ((Object[]) ((Object[]) v0_0[0]));
                this.mHashes = ((int[]) ((int[]) v0_0[1]));
                v0_0[1] = 0;
                v0_0[0] = 0;
                android.support.v4.util.SimpleArrayMap.mTwiceBaseCacheSize = (android.support.v4.util.SimpleArrayMap.mTwiceBaseCacheSize - 1);
            }
        }
        return;
    }

    private static void freeArrays(int[] p5, Object[] p6, int p7)
    {
        try {
            if (p5.length != 8) {
                if (p5.length == 4) {
                    try {
                        if (android.support.v4.util.SimpleArrayMap.mBaseCacheSize < 10) {
                            p6[0] = android.support.v4.util.SimpleArrayMap.mBaseCache;
                            p6[1] = p5;
                            int v0_0 = ((p7 << 1) - 1);
                            while (v0_0 >= 2) {
                                p6[v0_0] = 0;
                                v0_0--;
                            }
                            android.support.v4.util.SimpleArrayMap.mBaseCache = p6;
                            android.support.v4.util.SimpleArrayMap.mBaseCacheSize = (android.support.v4.util.SimpleArrayMap.mBaseCacheSize + 1);
                        }
                    } catch (int v1_7) {
                        throw v1_7;
                    }
                }
            } else {
                if (android.support.v4.util.SimpleArrayMap.mTwiceBaseCacheSize < 10) {
                    p6[0] = android.support.v4.util.SimpleArrayMap.mTwiceBaseCache;
                    p6[1] = p5;
                    int v0_1 = ((p7 << 1) - 1);
                    while (v0_1 >= 2) {
                        p6[v0_1] = 0;
                        v0_1--;
                    }
                    android.support.v4.util.SimpleArrayMap.mTwiceBaseCache = p6;
                    android.support.v4.util.SimpleArrayMap.mTwiceBaseCacheSize = (android.support.v4.util.SimpleArrayMap.mTwiceBaseCacheSize + 1);
                }
            }
        } catch (int v1_15) {
            throw v1_15;
        }
        return;
    }

    public void clear()
    {
        if (this.mSize != 0) {
            android.support.v4.util.SimpleArrayMap.freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = android.support.v4.util.ContainerHelpers.EMPTY_INTS;
            this.mArray = android.support.v4.util.ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
        return;
    }

    public boolean containsKey(Object p4)
    {
        int v0 = 1;
        if (p4 != null) {
            if (this.indexOf(p4, p4.hashCode()) < 0) {
                v0 = 0;
            }
        } else {
            if (this.indexOfNull() < 0) {
                v0 = 0;
            }
        }
        return v0;
    }

    public boolean containsValue(Object p2)
    {
        int v0_1;
        if (this.indexOfValue(p2) < 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public void ensureCapacity(int p6)
    {
        if (this.mHashes.length < p6) {
            int[] v1 = this.mHashes;
            Object[] v0 = this.mArray;
            this.allocArrays(p6);
            if (this.mSize > 0) {
                System.arraycopy(v1, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(v0, 0, this.mArray, 0, (this.mSize << 1));
            }
            android.support.v4.util.SimpleArrayMap.freeArrays(v1, v0, this.mSize);
        }
        return;
    }

    public boolean equals(Object p11)
    {
        int v6 = 1;
        if (this != p11) {
            if (!(p11 instanceof java.util.Map)) {
                v6 = 0;
            } else {
                if (this.size() == ((java.util.Map) p11).size()) {
                    int v0 = 0;
                    try {
                        while (v0 < this.mSize) {
                            Object v2 = this.keyAt(v0);
                            Object v4 = this.valueAt(v0);
                            Object v5 = ((java.util.Map) p11).get(v2);
                            if (v4 != null) {
                                if (!v4.equals(v5)) {
                                    v6 = 0;
                                    break;
                                }
                            } else {
                                if ((v5 != null) || (!((java.util.Map) p11).containsKey(v2))) {
                                    v6 = 0;
                                    break;
                                }
                            }
                            v0++;
                        }
                    } catch (ClassCastException v1) {
                        v6 = 0;
                    } catch (ClassCastException v1) {
                        v6 = 0;
                    }
                } else {
                    v6 = 0;
                }
            }
        }
        return v6;
    }

    public Object get(Object p4)
    {
        int v0;
        if (p4 != null) {
            v0 = this.indexOf(p4, p4.hashCode());
        } else {
            v0 = this.indexOfNull();
        }
        int v1_0;
        if (v0 < 0) {
            v1_0 = 0;
        } else {
            v1_0 = this.mArray[((v0 << 1) + 1)];
        }
        return v1_0;
    }

    public int hashCode()
    {
        int[] v1 = this.mHashes;
        Object[] v0 = this.mArray;
        int v3 = 0;
        int v2 = 0;
        int v5 = 1;
        int v4 = this.mSize;
        while (v2 < v4) {
            int v7_0;
            Object v6 = v0[v5];
            int v8 = v1[v2];
            if (v6 != null) {
                v7_0 = v6.hashCode();
            } else {
                v7_0 = 0;
            }
            v3 += (v7_0 ^ v8);
            v2++;
            v5 += 2;
        }
        return v3;
    }

    int indexOf(Object p7, int p8)
    {
        int v3;
        int v0 = this.mSize;
        if (v0 != 0) {
            v3 = android.support.v4.util.ContainerHelpers.binarySearch(this.mHashes, v0, p8);
            if ((v3 >= 0) && (!p7.equals(this.mArray[(v3 << 1)]))) {
                int v1 = (v3 + 1);
                while ((v1 < v0) && (this.mHashes[v1] == p8)) {
                    if (!p7.equals(this.mArray[(v1 << 1)])) {
                        v1++;
                    } else {
                        v3 = v1;
                    }
                }
                int v2 = (v3 - 1);
                while ((v2 >= 0) && (this.mHashes[v2] == p8)) {
                    if (!p7.equals(this.mArray[(v2 << 1)])) {
                        v2--;
                    } else {
                        v3 = v2;
                    }
                }
                v3 = (v1 ^ -1);
            }
        } else {
            v3 = -1;
        }
        return v3;
    }

    int indexOfNull()
    {
        int v3;
        int v0 = this.mSize;
        if (v0 != 0) {
            v3 = android.support.v4.util.ContainerHelpers.binarySearch(this.mHashes, v0, 0);
            if ((v3 >= 0) && (this.mArray[(v3 << 1)] != null)) {
                int v1 = (v3 + 1);
                while ((v1 < v0) && (this.mHashes[v1] == 0)) {
                    if (this.mArray[(v1 << 1)] != null) {
                        v1++;
                    } else {
                        v3 = v1;
                    }
                }
                int v2 = (v3 - 1);
                while ((v2 >= 0) && (this.mHashes[v2] == 0)) {
                    if (this.mArray[(v2 << 1)] != null) {
                        v2--;
                    } else {
                        v3 = v2;
                    }
                }
                v3 = (v1 ^ -1);
            }
        } else {
            v3 = -1;
        }
        return v3;
    }

    int indexOfValue(Object p5)
    {
        int v3_1;
        int v0 = (this.mSize * 2);
        Object[] v1 = this.mArray;
        if (p5 != null) {
            int v2_0 = 1;
            while (v2_0 < v0) {
                if (!p5.equals(v1[v2_0])) {
                    v2_0 += 2;
                } else {
                    v3_1 = (v2_0 >> 1);
                }
            }
            v3_1 = -1;
        } else {
            int v2_1 = 1;
            while (v2_1 < v0) {
                if (v1[v2_1] != null) {
                    v2_1 += 2;
                } else {
                    v3_1 = (v2_1 >> 1);
                }
            }
        }
        return v3_1;
    }

    public boolean isEmpty()
    {
        int v0_1;
        if (this.mSize > 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public Object keyAt(int p3)
    {
        return this.mArray[(p3 << 1)];
    }

    public Object put(Object p12, Object p13)
    {
        int v1_0;
        int v0;
        int v2 = 8;
        if (p12 != null) {
            v0 = p12.hashCode();
            v1_0 = this.indexOf(p12, v0);
        } else {
            v0 = 0;
            v1_0 = this.indexOfNull();
        }
        int v5;
        if (v1_0 < 0) {
            int v1_1 = (v1_0 ^ -1);
            if (this.mSize >= this.mHashes.length) {
                if (this.mSize < 8) {
                    if (this.mSize < 4) {
                        v2 = 4;
                    }
                } else {
                    v2 = (this.mSize + (this.mSize >> 1));
                }
                int[] v4 = this.mHashes;
                Object[] v3 = this.mArray;
                this.allocArrays(v2);
                if (this.mHashes.length > 0) {
                    System.arraycopy(v4, 0, this.mHashes, 0, v4.length);
                    System.arraycopy(v3, 0, this.mArray, 0, v3.length);
                }
                android.support.v4.util.SimpleArrayMap.freeArrays(v4, v3, this.mSize);
            }
            if (v1_1 < this.mSize) {
                System.arraycopy(this.mHashes, v1_1, this.mHashes, (v1_1 + 1), (this.mSize - v1_1));
                System.arraycopy(this.mArray, (v1_1 << 1), this.mArray, ((v1_1 + 1) << 1), ((this.mSize - v1_1) << 1));
            }
            this.mHashes[v1_1] = v0;
            this.mArray[(v1_1 << 1)] = p12;
            this.mArray[((v1_1 << 1) + 1)] = p13;
            this.mSize = (this.mSize + 1);
            v5 = 0;
        } else {
            int v1_2 = ((v1_0 << 1) + 1);
            v5 = this.mArray[v1_2];
            this.mArray[v1_2] = p13;
        }
        return v5;
    }

    public void putAll(android.support.v4.util.SimpleArrayMap p7)
    {
        int v0 = p7.mSize;
        this.ensureCapacity((this.mSize + v0));
        if (this.mSize != 0) {
            int v1 = 0;
            while (v1 < v0) {
                this.put(p7.keyAt(v1), p7.valueAt(v1));
                v1++;
            }
        } else {
            if (v0 > 0) {
                System.arraycopy(p7.mHashes, 0, this.mHashes, 0, v0);
                System.arraycopy(p7.mArray, 0, this.mArray, 0, (v0 << 1));
                this.mSize = v0;
            }
        }
        return;
    }

    public Object remove(Object p3)
    {
        int v0;
        if (p3 != null) {
            v0 = this.indexOf(p3, p3.hashCode());
        } else {
            v0 = this.indexOfNull();
        }
        int v1_0;
        if (v0 < 0) {
            v1_0 = 0;
        } else {
            v1_0 = this.removeAt(v0);
        }
        return v1_0;
    }

    public Object removeAt(int p11)
    {
        int v0 = 8;
        Object v3 = this.mArray[((p11 << 1) + 1)];
        if (this.mSize > 1) {
            if ((this.mHashes.length <= 8) || (this.mSize >= (this.mHashes.length / 3))) {
                this.mSize = (this.mSize - 1);
                if (p11 < this.mSize) {
                    System.arraycopy(this.mHashes, (p11 + 1), this.mHashes, p11, (this.mSize - p11));
                    System.arraycopy(this.mArray, ((p11 + 1) << 1), this.mArray, (p11 << 1), ((this.mSize - p11) << 1));
                }
                this.mArray[(this.mSize << 1)] = 0;
                this.mArray[((this.mSize << 1) + 1)] = 0;
            } else {
                if (this.mSize > 8) {
                    v0 = (this.mSize + (this.mSize >> 1));
                }
                int[] v2 = this.mHashes;
                Object[] v1 = this.mArray;
                this.allocArrays(v0);
                this.mSize = (this.mSize - 1);
                if (p11 > 0) {
                    System.arraycopy(v2, 0, this.mHashes, 0, p11);
                    System.arraycopy(v1, 0, this.mArray, 0, (p11 << 1));
                }
                if (p11 < this.mSize) {
                    System.arraycopy(v2, (p11 + 1), this.mHashes, p11, (this.mSize - p11));
                    System.arraycopy(v1, ((p11 + 1) << 1), this.mArray, (p11 << 1), ((this.mSize - p11) << 1));
                }
            }
        } else {
            android.support.v4.util.SimpleArrayMap.freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = android.support.v4.util.ContainerHelpers.EMPTY_INTS;
            this.mArray = android.support.v4.util.ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
        return v3;
    }

    public Object setValueAt(int p3, Object p4)
    {
        int v3_1 = ((p3 << 1) + 1);
        Object v0 = this.mArray[v3_1];
        this.mArray[v3_1] = p4;
        return v0;
    }

    public int size()
    {
        return this.mSize;
    }

    public String toString()
    {
        String v4_3;
        if (!this.isEmpty()) {
            StringBuilder v0_1 = new StringBuilder((this.mSize * 28));
            v0_1.append(123);
            int v1 = 0;
            while (v1 < this.mSize) {
                if (v1 > 0) {
                    v0_1.append(", ");
                }
                Object v2 = this.keyAt(v1);
                if (v2 == this) {
                    v0_1.append("(this Map)");
                } else {
                    v0_1.append(v2);
                }
                v0_1.append(61);
                Object v3 = this.valueAt(v1);
                if (v3 == this) {
                    v0_1.append("(this Map)");
                } else {
                    v0_1.append(v3);
                }
                v1++;
            }
            v0_1.append(125);
            v4_3 = v0_1.toString();
        } else {
            v4_3 = "{}";
        }
        return v4_3;
    }

    public Object valueAt(int p3)
    {
        return this.mArray[((p3 << 1) + 1)];
    }
}
