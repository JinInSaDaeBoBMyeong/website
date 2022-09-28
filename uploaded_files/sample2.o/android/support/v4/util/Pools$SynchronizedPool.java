package android.support.v4.util;
public class Pools$SynchronizedPool extends android.support.v4.util.Pools$SimplePool {
    private final Object mLock;

    public Pools$SynchronizedPool(int p2)
    {
        super(p2);
        super.mLock = new Object();
        return;
    }

    public Object acquire()
    {
        try {
            return super.acquire();
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public boolean release(Object p3)
    {
        try {
            return super.release(p3);
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }
}
