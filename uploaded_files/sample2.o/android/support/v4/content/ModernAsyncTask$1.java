package android.support.v4.content;
final class ModernAsyncTask$1 implements java.util.concurrent.ThreadFactory {
    private final java.util.concurrent.atomic.AtomicInteger mCount;

    ModernAsyncTask$1()
    {
        this.mCount = new java.util.concurrent.atomic.AtomicInteger(1);
        return;
    }

    public Thread newThread(Runnable p4)
    {
        return new Thread(p4, new StringBuilder().append("ModernAsyncTask #").append(this.mCount.getAndIncrement()).toString());
    }
}
