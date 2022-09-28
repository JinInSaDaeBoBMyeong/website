package org.webrtc;
 class NetworkMonitorAutoDetect$WifiDirectManagerDelegate extends android.content.BroadcastReceiver {
    private static final int WIFI_P2P_NETWORK_HANDLE;
    private final android.content.Context context;
    private final org.webrtc.NetworkMonitorAutoDetect$Observer observer;
    private org.webrtc.NetworkMonitorAutoDetect$NetworkInformation wifiP2pNetworkInfo;

    NetworkMonitorAutoDetect$WifiDirectManagerDelegate(org.webrtc.NetworkMonitorAutoDetect$Observer p3, android.content.Context p4)
    {
        this.wifiP2pNetworkInfo = 0;
        this.context = p4;
        this.observer = p3;
        android.content.IntentFilter v0_1 = new android.content.IntentFilter();
        v0_1.addAction("android.net.wifi.p2p.STATE_CHANGED");
        v0_1.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        p4.registerReceiver(this, v0_1);
        return;
    }

    private void onWifiP2pGroupChange(android.net.wifi.p2p.WifiP2pGroup p11)
    {
        if ((p11 != null) && (p11.getInterface() != null)) {
            try {
                java.util.ArrayList v8 = java.util.Collections.list(java.net.NetworkInterface.getByName(p11.getInterface()).getInetAddresses());
                org.webrtc.NetworkMonitorAutoDetect$IPAddress[] v6 = new org.webrtc.NetworkMonitorAutoDetect$IPAddress[v8.size()];
                int v7 = 0;
            } catch (java.net.SocketException v0) {
                org.webrtc.Logging.e("NetworkMonitorAutoDetect", "Unable to get WifiP2p network interface", v0);
            }
            while (v7 < v8.size()) {
                v6[v7] = new org.webrtc.NetworkMonitorAutoDetect$IPAddress(((java.net.InetAddress) v8.get(v7)).getAddress());
                v7++;
            }
            this.wifiP2pNetworkInfo = new org.webrtc.NetworkMonitorAutoDetect$NetworkInformation(p11.getInterface(), org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_WIFI, 0, v6);
            this.observer.onNetworkConnect(this.wifiP2pNetworkInfo);
        }
        return;
    }

    private void onWifiP2pStateChange(int p5)
    {
        if (p5 == 1) {
            this.wifiP2pNetworkInfo = 0;
            this.observer.onNetworkDisconnect(0);
        }
        return;
    }

    public java.util.List getActiveNetworkList()
    {
        java.util.List v0_1;
        if (this.wifiP2pNetworkInfo == null) {
            v0_1 = java.util.Collections.emptyList();
        } else {
            v0_1 = java.util.Collections.singletonList(this.wifiP2pNetworkInfo);
        }
        return v0_1;
    }

    public void onReceive(android.content.Context p5, android.content.Intent p6)
    {
        if (!"android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(p6.getAction())) {
            if ("android.net.wifi.p2p.STATE_CHANGED".equals(p6.getAction())) {
                this.onWifiP2pStateChange(p6.getIntExtra("wifi_p2p_state", 0));
            }
        } else {
            this.onWifiP2pGroupChange(((android.net.wifi.p2p.WifiP2pGroup) p6.getParcelableExtra("p2pGroupInfo")));
        }
        return;
    }

    public void release()
    {
        this.context.unregisterReceiver(this);
        return;
    }
}
