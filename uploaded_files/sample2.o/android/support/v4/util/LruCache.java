package android.support.v4.util;
public class LruCache {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final java.util.LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int p5)
    {
        if (p5 > 0) {
            this.maxSize = p5;
            this.map = new java.util.LinkedHashMap(0, 1061158912, 1);
            return;
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    private int safeSizeOf(Object p5, Object p6)
    {
        int v0 = this.sizeOf(p5, p6);
        if (v0 >= 0) {
            return v0;
        } else {
            throw new IllegalStateException(new StringBuilder().append("Negative size: ").append(p5).append("=").append(p6).toString());
        }
    }

    protected Object create(Object p2)
    {
        return 0;
    }

    public final declared_synchronized int createCount()
    {
        try {
            return this.createCount;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    protected void entryRemoved(boolean p1, Object p2, Object p3, Object p4)
    {
        return;
    }

    public final void evictAll()
    {
        this.trimToSize(-1);
        return;
    }

    public final declared_synchronized int evictionCount()
    {
        try {
            return this.evictionCount;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final Object get(Object p5)
    {
        if (p5 != null) {
            Object v0;
            Object v1_1 = this.map.get(p5);
            if (v1_1 == null) {
                this.missCount = (this.missCount + 1);
                v0 = this.create(p5);
                if (v0 != null) {
                    try {
                        this.createCount = (this.createCount + 1);
                        Object v1_0 = this.map.put(p5, v0);
                    } catch (int v2_7) {
                        throw v2_7;
                    }
                    if (v1_0 == null) {
                        this.size = (this.size + this.safeSizeOf(p5, v0));
                    } else {
                        this.map.put(p5, v1_0);
                    }
                    if (v1_0 == null) {
                        this.trimToSize(this.maxSize);
                    } else {
                        this.entryRemoved(0, p5, v0, v1_0);
                        v0 = v1_0;
                    }
                } else {
                    v0 = 0;
                }
            } else {
                this.hitCount = (this.hitCount + 1);
                v0 = v1_1;
            }
            return v0;
        } else {
            throw new NullPointerException("key == null");
        }
    }

    public final declared_synchronized int hitCount()
    {
        try {
            return this.hitCount;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final declared_synchronized int maxSize()
    {
        try {
            return this.maxSize;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final declared_synchronized int missCount()
    {
        try {
            return this.missCount;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final Object put(Object p4, Object p5)
    {
        if ((p4 != null) && (p5 != null)) {
            this.putCount = (this.putCount + 1);
            this.size = (this.size + this.safeSizeOf(p4, p5));
            Object v0 = this.map.put(p4, p5);
            if (v0 != null) {
                this.size = (this.size - this.safeSizeOf(p4, v0));
            }
            if (v0 != null) {
                this.entryRemoved(0, p4, v0, p5);
            }
            this.trimToSize(this.maxSize);
            return v0;
        } else {
            throw new NullPointerException("key == null || value == null");
        }
    }

    public final declared_synchronized int putCount()
    {
        try {
            return this.putCount;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final Object remove(Object p4)
    {
        if (p4 != null) {
            Object v0 = this.map.remove(p4);
            if (v0 != null) {
                this.size = (this.size - this.safeSizeOf(p4, v0));
            }
            if (v0 != null) {
                this.entryRemoved(0, p4, v0, 0);
            }
            return v0;
        } else {
            throw new NullPointerException("key == null");
        }
    }

    public final declared_synchronized int size()
    {
        try {
            return this.size;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    protected int sizeOf(Object p2, Object p3)
    {
        return 1;
    }

    public final declared_synchronized java.util.Map snapshot()
    {
        try {
            return new java.util.LinkedHashMap(this.map);
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }

    public final declared_synchronized String toString()
    {
        int v1 = 0;
        try {
            int v0 = (this.hitCount + this.missCount);
        } catch (String v2_5) {
            throw v2_5;
        }
        if (v0 != 0) {
            v1 = ((this.hitCount * 100) / v0);
        }
        Object[] v3_1 = new Object[4];
        v3_1[0] = Integer.valueOf(this.maxSize);
        v3_1[1] = Integer.valueOf(this.hitCount);
        v3_1[2] = Integer.valueOf(this.missCount);
        v3_1[3] = Integer.valueOf(v1);
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", v3_1);
    }

    public void trimToSize(int p7)
    {
        try {
            while ((this.size >= 0) && ((!this.map.isEmpty()) || (this.size == 0))) {
                if ((this.size > p7) && (!this.map.isEmpty())) {
                    java.util.Map$Entry v1_1 = ((java.util.Map$Entry) this.map.entrySet().iterator().next());
                    Object v0 = v1_1.getKey();
                    Object v2 = v1_1.getValue();
                    this.map.remove(v0);
                    this.size = (this.size - this.safeSizeOf(v0, v2));
                    this.evictionCount = (this.evictionCount + 1);
                    this.entryRemoved(1, v0, v2, 0);
                } else {
                    return;
                }
            }
        } catch (int v3_16) {
            throw v3_16;
        }
        throw new IllegalStateException(new StringBuilder().append(this.getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
    }
}
