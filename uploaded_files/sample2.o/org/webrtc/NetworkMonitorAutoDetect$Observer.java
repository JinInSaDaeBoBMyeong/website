package org.webrtc;
public interface NetworkMonitorAutoDetect$Observer {

    public abstract void onConnectionTypeChanged();

    public abstract void onNetworkConnect();

    public abstract void onNetworkDisconnect();
}
