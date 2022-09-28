package org.webrtc;
public class ThreadUtils {

    public ThreadUtils()
    {
        return;
    }

    public static void awaitUninterruptibly(java.util.concurrent.CountDownLatch p1)
    {
        org.webrtc.ThreadUtils.executeUninterruptibly(new org.webrtc.ThreadUtils$2(p1));
        return;
    }

    public static boolean awaitUninterruptibly(java.util.concurrent.CountDownLatch p13, long p14)
    {
        long v4 = android.os.SystemClock.elapsedRealtime();
        long v6 = p14;
        int v8 = 0;
        try {
            do {
                boolean v1 = p13.await(v6, java.util.concurrent.TimeUnit.MILLISECONDS);
                break;
            } while(v6 > 0);
        } catch (InterruptedException v0) {
            v8 = 1;
            v6 = (p14 - (android.os.SystemClock.elapsedRealtime() - v4));
            if (v6 > 0) {
            }
        }
        if (v8 != 0) {
            Thread.currentThread().interrupt();
        }
        return v1;
    }

    public static void checkIsOnMainThread()
    {
        if (Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            return;
        } else {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    static StackTraceElement[] concatStackTraces(StackTraceElement[] p4, StackTraceElement[] p5)
    {
        StackTraceElement[] v0 = new StackTraceElement[(p4.length + p5.length)];
        System.arraycopy(p4, 0, v0, 0, p4.length);
        System.arraycopy(p5, 0, v0, p4.length, p5.length);
        return v0;
    }

    public static void executeUninterruptibly(org.webrtc.ThreadUtils$BlockingOperation p3)
    {
        int v1 = 0;
        try {
            while(true) {
                p3.run();
                v1 = 1;
            }
        } catch (InterruptedException v0) {
        }
        if (v1 != 0) {
            Thread.currentThread().interrupt();
        }
        return;
    }

    public static Object invokeAtFrontUninterruptibly(android.os.Handler p7, java.util.concurrent.Callable p8)
    {
        Object v5_5;
        if (p7.getLooper().getThread() != Thread.currentThread()) {
            org.webrtc.ThreadUtils$1Result v3_1 = new org.webrtc.ThreadUtils$1Result();
            org.webrtc.ThreadUtils$1CaughtException v1_0 = new org.webrtc.ThreadUtils$1CaughtException();
            java.util.concurrent.CountDownLatch v0_1 = new java.util.concurrent.CountDownLatch(1);
            p7.post(new org.webrtc.ThreadUtils$4(v3_1, p8, v1_0, v0_1));
            org.webrtc.ThreadUtils.awaitUninterruptibly(v0_1);
            if (v1_0.e == null) {
                v5_5 = v3_1.value;
            } else {
                RuntimeException v4_1 = new RuntimeException(v1_0.e);
                v4_1.setStackTrace(org.webrtc.ThreadUtils.concatStackTraces(v1_0.e.getStackTrace(), v4_1.getStackTrace()));
                throw v4_1;
            }
        } else {
            try {
                v5_5 = p8.call();
            } catch (Exception v2) {
                throw new RuntimeException(v2);
            }
        }
        return v5_5;
    }

    public static void invokeAtFrontUninterruptibly(android.os.Handler p1, Runnable p2)
    {
        org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(p1, new org.webrtc.ThreadUtils$5(p2));
        return;
    }

    public static void joinUninterruptibly(Thread p1)
    {
        org.webrtc.ThreadUtils.executeUninterruptibly(new org.webrtc.ThreadUtils$1(p1));
        return;
    }

    public static boolean joinUninterruptibly(Thread p11, long p12)
    {
        long v4 = android.os.SystemClock.elapsedRealtime();
        long v6 = p12;
        int v1 = 0;
        while (v6 > 0) {
            try {
                p11.join(v6);
                break;
            } catch (InterruptedException v0) {
                v1 = 1;
                v6 = (p12 - (android.os.SystemClock.elapsedRealtime() - v4));
            }
        }
        if (v1 != 0) {
            Thread.currentThread().interrupt();
        }
        int v8_3;
        if (p11.isAlive()) {
            v8_3 = 0;
        } else {
            v8_3 = 1;
        }
        return v8_3;
    }

    public static void waitUninterruptibly(Object p1)
    {
        org.webrtc.ThreadUtils.executeUninterruptibly(new org.webrtc.ThreadUtils$3(p1));
        return;
    }
}
