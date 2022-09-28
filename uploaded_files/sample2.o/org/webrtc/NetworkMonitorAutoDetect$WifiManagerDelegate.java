package org.webrtc;
 class NetworkMonitorAutoDetect$WifiManagerDelegate {
    private final android.content.Context context;

    NetworkMonitorAutoDetect$WifiManagerDelegate()
    {
        this.context = 0;
        return;
    }

    NetworkMonitorAutoDetect$WifiManagerDelegate(android.content.Context p1)
    {
        this.context = p1;
        return;
    }

    String getWifiSSID()
    {
        String v1;
        android.content.Intent v0 = this.context.registerReceiver(0, new android.content.IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (v0 == null) {
            v1 = "";
        } else {
            android.net.wifi.WifiInfo v2_1 = ((android.net.wifi.WifiInfo) v0.getParcelableExtra("wifiInfo"));
            if (v2_1 == null) {
            } else {
                v1 = v2_1.getSSID();
                if (v1 == null) {
                }
            }
        }
        return v1;
    }
}
