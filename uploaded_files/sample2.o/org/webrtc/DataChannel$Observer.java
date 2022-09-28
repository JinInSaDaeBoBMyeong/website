package org.webrtc;
public interface DataChannel$Observer {

    public abstract void onBufferedAmountChange();

    public abstract void onMessage();

    public abstract void onStateChange();
}
