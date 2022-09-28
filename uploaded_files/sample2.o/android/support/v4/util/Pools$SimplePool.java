package android.support.v4.util;
public class Pools$SimplePool implements android.support.v4.util.Pools$Pool {
    private final Object[] mPool;
    private int mPoolSize;

    public Pools$SimplePool(int p3)
    {
        if (p3 > 0) {
            Object[] v0_0 = new Object[p3];
            this.mPool = v0_0;
            return;
        } else {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    private boolean isInPool(Object p3)
    {
        int v0 = 0;
        while (v0 < this.mPoolSize) {
            if (this.mPool[v0] != p3) {
                v0++;
            } else {
                int v1_1 = 1;
            }
            return v1_1;
        }
        v1_1 = 0;
        return v1_1;
    }

    public Object acquire()
    {
        int v0;
        if (this.mPoolSize <= 0) {
            v0 = 0;
        } else {
            int v1 = (this.mPoolSize - 1);
            v0 = this.mPool[v1];
            this.mPool[v1] = 0;
            this.mPoolSize = (this.mPoolSize - 1);
        }
        return v0;
    }

    public boolean release(Object p3)
    {
        if (!this.isInPool(p3)) {
            int v0_3;
            if (this.mPoolSize >= this.mPool.length) {
                v0_3 = 0;
            } else {
                this.mPool[this.mPoolSize] = p3;
                this.mPoolSize = (this.mPoolSize + 1);
                v0_3 = 1;
            }
            return v0_3;
        } else {
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
