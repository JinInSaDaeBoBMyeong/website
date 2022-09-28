package android.support.v4.util;
public class LongSparseArray implements java.lang.Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static LongSparseArray()
    {
        android.support.v4.util.LongSparseArray.DELETED = new Object();
        return;
    }

    public LongSparseArray()
    {
        this(10);
        return;
    }

    public LongSparseArray(int p3)
    {
        this.mGarbage = 0;
        if (p3 != 0) {
            int v3_1 = android.support.v4.util.ContainerHelpers.idealLongArraySize(p3);
            Object[] v0_2 = new long[v3_1];
            this.mKeys = v0_2;
            Object[] v0_3 = new Object[v3_1];
            this.mValues = v0_3;
        } else {
            this.mKeys = android.support.v4.util.ContainerHelpers.EMPTY_LONGS;
            this.mValues = android.support.v4.util.ContainerHelpers.EMPTY_OBJECTS;
        }
        this.mSize = 0;
        return;
    }

    private void gc()
    {
        int v2 = this.mSize;
        int v3 = 0;
        long[] v1 = this.mKeys;
        Object[] v5 = this.mValues;
        int v0 = 0;
        while (v0 < v2) {
            Object v4 = v5[v0];
            if (v4 != android.support.v4.util.LongSparseArray.DELETED) {
                if (v0 != v3) {
                    v1[v3] = v1[v0];
                    v5[v3] = v4;
                    v5[v0] = 0;
                }
                v3++;
            }
            v0++;
        }
        this.mGarbage = 0;
        this.mSize = v3;
        return;
    }

    public void append(long p8, Object p10)
    {
        if ((this.mSize == 0) || (p8 > this.mKeys[(this.mSize - 1)])) {
            if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
                this.gc();
            }
            int v3 = this.mSize;
            if (v3 >= this.mKeys.length) {
                int v0 = android.support.v4.util.ContainerHelpers.idealLongArraySize((v3 + 1));
                long[] v1 = new long[v0];
                Object[] v2 = new Object[v0];
                System.arraycopy(this.mKeys, 0, v1, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, v2, 0, this.mValues.length);
                this.mKeys = v1;
                this.mValues = v2;
            }
            this.mKeys[v3] = p8;
            this.mValues[v3] = p10;
            this.mSize = (v3 + 1);
        } else {
            this.put(p8, p10);
        }
        return;
    }

    public void clear()
    {
        int v1 = this.mSize;
        int v0 = 0;
        while (v0 < v1) {
            this.mValues[v0] = 0;
            v0++;
        }
        this.mSize = 0;
        this.mGarbage = 0;
        return;
    }

    public android.support.v4.util.LongSparseArray clone()
    {
        try {
            android.support.v4.util.LongSparseArray v1 = ((android.support.v4.util.LongSparseArray) super.clone());
            v1.mKeys = ((long[]) this.mKeys.clone());
            v1.mValues = ((Object[]) this.mValues.clone());
        } catch (CloneNotSupportedException v2) {
        }
        return v1;
    }

    public bridge synthetic Object clone()
    {
        return this.clone();
    }

    public void delete(long p4)
    {
        int v0 = android.support.v4.util.ContainerHelpers.binarySearch(this.mKeys, this.mSize, p4);
        if ((v0 >= 0) && (this.mValues[v0] != android.support.v4.util.LongSparseArray.DELETED)) {
            this.mValues[v0] = android.support.v4.util.LongSparseArray.DELETED;
            this.mGarbage = 1;
        }
        return;
    }

    public Object get(long p2)
    {
        return this.get(p2, 0);
    }

    public Object get(long p4, Object p6)
    {
        int v0 = android.support.v4.util.ContainerHelpers.binarySearch(this.mKeys, this.mSize, p4);
        if ((v0 >= 0) && (this.mValues[v0] != android.support.v4.util.LongSparseArray.DELETED)) {
            p6 = this.mValues[v0];
        }
        return p6;
    }

    public int indexOfKey(long p4)
    {
        if (this.mGarbage) {
            this.gc();
        }
        return android.support.v4.util.ContainerHelpers.binarySearch(this.mKeys, this.mSize, p4);
    }

    public int indexOfValue(Object p3)
    {
        if (this.mGarbage) {
            this.gc();
        }
        int v0 = 0;
        while (v0 < this.mSize) {
            if (this.mValues[v0] != p3) {
                v0++;
            }
            return v0;
        }
        v0 = -1;
        return v0;
    }

    public long keyAt(int p3)
    {
        if (this.mGarbage) {
            this.gc();
        }
        return this.mKeys[p3];
    }

    public void put(long p10, Object p12)
    {
        int v0_1 = android.support.v4.util.ContainerHelpers.binarySearch(this.mKeys, this.mSize, p10);
        if (v0_1 < 0) {
            int v0_0 = (v0_1 ^ -1);
            if ((v0_0 >= this.mSize) || (this.mValues[v0_0] != android.support.v4.util.LongSparseArray.DELETED)) {
                if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
                    this.gc();
                    v0_0 = (android.support.v4.util.ContainerHelpers.binarySearch(this.mKeys, this.mSize, p10) ^ -1);
                }
                if (this.mSize >= this.mKeys.length) {
                    int v1 = android.support.v4.util.ContainerHelpers.idealLongArraySize((this.mSize + 1));
                    long[] v2 = new long[v1];
                    Object[] v3 = new Object[v1];
                    System.arraycopy(this.mKeys, 0, v2, 0, this.mKeys.length);
                    System.arraycopy(this.mValues, 0, v3, 0, this.mValues.length);
                    this.mKeys = v2;
                    this.mValues = v3;
                }
                if ((this.mSize - v0_0) != 0) {
                    System.arraycopy(this.mKeys, v0_0, this.mKeys, (v0_0 + 1), (this.mSize - v0_0));
                    System.arraycopy(this.mValues, v0_0, this.mValues, (v0_0 + 1), (this.mSize - v0_0));
                }
                this.mKeys[v0_0] = p10;
                this.mValues[v0_0] = p12;
                this.mSize = (this.mSize + 1);
            } else {
                this.mKeys[v0_0] = p10;
                this.mValues[v0_0] = p12;
            }
        } else {
            this.mValues[v0_1] = p12;
        }
        return;
    }

    public void remove(long p2)
    {
        this.delete(p2);
        return;
    }

    public void removeAt(int p3)
    {
        if (this.mValues[p3] != android.support.v4.util.LongSparseArray.DELETED) {
            this.mValues[p3] = android.support.v4.util.LongSparseArray.DELETED;
            this.mGarbage = 1;
        }
        return;
    }

    public void setValueAt(int p2, Object p3)
    {
        if (this.mGarbage) {
            this.gc();
        }
        this.mValues[p2] = p3;
        return;
    }

    public int size()
    {
        if (this.mGarbage) {
            this.gc();
        }
        return this.mSize;
    }

    public String toString()
    {
        String v5_3;
        if (this.size() > 0) {
            StringBuilder v0_1 = new StringBuilder((this.mSize * 28));
            v0_1.append(123);
            int v1 = 0;
            while (v1 < this.mSize) {
                if (v1 > 0) {
                    v0_1.append(", ");
                }
                v0_1.append(this.keyAt(v1));
                v0_1.append(61);
                Object v4 = this.valueAt(v1);
                if (v4 == this) {
                    v0_1.append("(this Map)");
                } else {
                    v0_1.append(v4);
                }
                v1++;
            }
            v0_1.append(125);
            v5_3 = v0_1.toString();
        } else {
            v5_3 = "{}";
        }
        return v5_3;
    }

    public Object valueAt(int p2)
    {
        if (this.mGarbage) {
            this.gc();
        }
        return this.mValues[p2];
    }
}
