package org.webrtc;
public class NetworkMonitorAutoDetect extends android.content.BroadcastReceiver {
    static final long INVALID_NET_ID = 255;
    private static final String TAG = "NetworkMonitorAutoDetect";
    private final android.net.ConnectivityManager$NetworkCallback allNetworkCallback;
    private org.webrtc.NetworkMonitorAutoDetect$ConnectionType connectionType;
    private org.webrtc.NetworkMonitorAutoDetect$ConnectivityManagerDelegate connectivityManagerDelegate;
    private final android.content.Context context;
    private final android.content.IntentFilter intentFilter;
    private boolean isRegistered;
    private final android.net.ConnectivityManager$NetworkCallback mobileNetworkCallback;
    private final org.webrtc.NetworkMonitorAutoDetect$Observer observer;
    private org.webrtc.NetworkMonitorAutoDetect$WifiDirectManagerDelegate wifiDirectManagerDelegate;
    private org.webrtc.NetworkMonitorAutoDetect$WifiManagerDelegate wifiManagerDelegate;
    private String wifiSSID;

    public NetworkMonitorAutoDetect(org.webrtc.NetworkMonitorAutoDetect$Observer p7, android.content.Context p8)
    {
        this.observer = p7;
        this.context = p8;
        this.connectivityManagerDelegate = new org.webrtc.NetworkMonitorAutoDetect$ConnectivityManagerDelegate(p8);
        this.wifiManagerDelegate = new org.webrtc.NetworkMonitorAutoDetect$WifiManagerDelegate(p8);
        org.webrtc.NetworkMonitorAutoDetect$NetworkState v1 = this.connectivityManagerDelegate.getNetworkState();
        this.connectionType = org.webrtc.NetworkMonitorAutoDetect.getConnectionType(v1);
        this.wifiSSID = this.getWifiSSID(v1);
        this.intentFilter = new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (org.webrtc.PeerConnectionFactory.fieldTrialsFindFullName("IncludeWifiDirect").equals("Enabled")) {
            this.wifiDirectManagerDelegate = new org.webrtc.NetworkMonitorAutoDetect$WifiDirectManagerDelegate(p7, p8);
        }
        this.registerReceiver();
        if (!this.connectivityManagerDelegate.supportNetworkCallback()) {
            this.mobileNetworkCallback = 0;
            this.allNetworkCallback = 0;
        } else {
            int v2_1 = new android.net.ConnectivityManager$NetworkCallback();
            try {
                this.connectivityManagerDelegate.requestMobileNetwork(v2_1);
            } catch (SecurityException v0) {
                org.webrtc.Logging.w("NetworkMonitorAutoDetect", "Unable to obtain permission to request a cellular network.");
                v2_1 = 0;
            }
            this.mobileNetworkCallback = v2_1;
            this.allNetworkCallback = new org.webrtc.NetworkMonitorAutoDetect$SimpleNetworkCallback(this, 0);
            this.connectivityManagerDelegate.registerNetworkCallback(this.allNetworkCallback);
        }
        return;
    }

    static synthetic long access$000(android.net.Network p2)
    {
        return org.webrtc.NetworkMonitorAutoDetect.networkToNetId(p2);
    }

    static synthetic org.webrtc.NetworkMonitorAutoDetect$Observer access$100(org.webrtc.NetworkMonitorAutoDetect p1)
    {
        return p1.observer;
    }

    static synthetic org.webrtc.NetworkMonitorAutoDetect$ConnectivityManagerDelegate access$200(org.webrtc.NetworkMonitorAutoDetect p1)
    {
        return p1.connectivityManagerDelegate;
    }

    private void connectionTypeChanged(org.webrtc.NetworkMonitorAutoDetect$NetworkState p6)
    {
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType v0 = org.webrtc.NetworkMonitorAutoDetect.getConnectionType(p6);
        String v1 = this.getWifiSSID(p6);
        if ((v0 != this.connectionType) || (!v1.equals(this.wifiSSID))) {
            this.connectionType = v0;
            this.wifiSSID = v1;
            org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("Network connectivity changed, type is: ").append(this.connectionType).toString());
            this.observer.onConnectionTypeChanged(v0);
        }
        return;
    }

    public static org.webrtc.NetworkMonitorAutoDetect$ConnectionType getConnectionType(org.webrtc.NetworkMonitorAutoDetect$NetworkState p1)
    {
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType v0_2;
        if (p1.isConnected()) {
            switch (p1.getNetworkType()) {
                case 0:
                    switch (p1.getNetworkSubType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_2G;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_3G;
                            break;
                        case 13:
                            v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_4G;
                            break;
                        default:
                            v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
                    }
                    break;
                case 1:
                    v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_WIFI;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                default:
                    v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN;
                    break;
                case 6:
                    v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_4G;
                    break;
                case 7:
                    v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_BLUETOOTH;
                    break;
                case 9:
                    v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_ETHERNET;
                    break;
            }
        } else {
            v0_2 = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_NONE;
        }
        return v0_2;
    }

    private String getWifiSSID(org.webrtc.NetworkMonitorAutoDetect$NetworkState p3)
    {
        String v0_2;
        if (org.webrtc.NetworkMonitorAutoDetect.getConnectionType(p3) == org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_WIFI) {
            v0_2 = this.wifiManagerDelegate.getWifiSSID();
        } else {
            v0_2 = "";
        }
        return v0_2;
    }

    private static long networkToNetId(android.net.Network p2)
    {
        long v0_3;
        if (android.os.Build$VERSION.SDK_INT < 23) {
            v0_3 = ((long) Integer.parseInt(p2.toString()));
        } else {
            v0_3 = p2.getNetworkHandle();
        }
        return v0_3;
    }

    private void registerReceiver()
    {
        if (!this.isRegistered) {
            this.isRegistered = 1;
            this.context.registerReceiver(this, this.intentFilter);
        }
        return;
    }

    private void unregisterReceiver()
    {
        if (this.isRegistered) {
            this.isRegistered = 0;
            this.context.unregisterReceiver(this);
        }
        return;
    }

    public void destroy()
    {
        if (this.allNetworkCallback != null) {
            this.connectivityManagerDelegate.releaseCallback(this.allNetworkCallback);
        }
        if (this.mobileNetworkCallback != null) {
            this.connectivityManagerDelegate.releaseCallback(this.mobileNetworkCallback);
        }
        if (this.wifiDirectManagerDelegate != null) {
            this.wifiDirectManagerDelegate.release();
        }
        this.unregisterReceiver();
        return;
    }

    java.util.List getActiveNetworkList()
    {
        java.util.ArrayList v1_0;
        java.util.List v0 = this.connectivityManagerDelegate.getActiveNetworkList();
        if (v0 != null) {
            v1_0 = new java.util.ArrayList(v0);
            if (this.wifiDirectManagerDelegate != null) {
                v1_0.addAll(this.wifiDirectManagerDelegate.getActiveNetworkList());
            }
        } else {
            v1_0 = 0;
        }
        return v1_0;
    }

    public org.webrtc.NetworkMonitorAutoDetect$NetworkState getCurrentNetworkState()
    {
        return this.connectivityManagerDelegate.getNetworkState();
    }

    public long getDefaultNetId()
    {
        return this.connectivityManagerDelegate.getDefaultNetId();
    }

    boolean isReceiverRegisteredForTesting()
    {
        return this.isRegistered;
    }

    public void onReceive(android.content.Context p4, android.content.Intent p5)
    {
        org.webrtc.NetworkMonitorAutoDetect$NetworkState v0 = this.getCurrentNetworkState();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(p5.getAction())) {
            this.connectionTypeChanged(v0);
        }
        return;
    }

    void setConnectivityManagerDelegateForTests(org.webrtc.NetworkMonitorAutoDetect$ConnectivityManagerDelegate p1)
    {
        this.connectivityManagerDelegate = p1;
        return;
    }

    void setWifiManagerDelegateForTests(org.webrtc.NetworkMonitorAutoDetect$WifiManagerDelegate p1)
    {
        this.wifiManagerDelegate = p1;
        return;
    }

    public boolean supportNetworkCallback()
    {
        return this.connectivityManagerDelegate.supportNetworkCallback();
    }
}
