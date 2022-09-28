package org.webrtc;
public class DataChannel {
    private final long nativeDataChannel;
    private long nativeObserver;

    public DataChannel(long p2)
    {
        this.nativeDataChannel = p2;
        return;
    }

    private native long registerObserverNative();

    private native boolean sendNative();

    private native void unregisterObserverNative();

    public native long bufferedAmount();

    public native void close();

    public native void dispose();

    public native int id();

    public native String label();

    public void registerObserver(org.webrtc.DataChannel$Observer p5)
    {
        if (this.nativeObserver != 0) {
            this.unregisterObserverNative(this.nativeObserver);
        }
        this.nativeObserver = this.registerObserverNative(p5);
        return;
    }

    public boolean send(org.webrtc.DataChannel$Buffer p3)
    {
        byte[] v0 = new byte[p3.data.remaining()];
        p3.data.get(v0);
        return this.sendNative(v0, p3.binary);
    }

    public native org.webrtc.DataChannel$State state();

    public void unregisterObserver()
    {
        this.unregisterObserverNative(this.nativeObserver);
        return;
    }
}
