package org.webrtc;
 class NetworkMonitorAutoDetect$ConnectivityManagerDelegate {
    private final android.net.ConnectivityManager connectivityManager;

    NetworkMonitorAutoDetect$ConnectivityManagerDelegate()
    {
        this.connectivityManager = 0;
        return;
    }

    NetworkMonitorAutoDetect$ConnectivityManagerDelegate(android.content.Context p2)
    {
        this.connectivityManager = ((android.net.ConnectivityManager) p2.getSystemService("connectivity"));
        return;
    }

    static synthetic org.webrtc.NetworkMonitorAutoDetect$NetworkInformation access$300(org.webrtc.NetworkMonitorAutoDetect$ConnectivityManagerDelegate p1, android.net.Network p2)
    {
        return p1.networkToInfo(p2);
    }

    private org.webrtc.NetworkMonitorAutoDetect$NetworkInformation networkToInfo(android.net.Network p9)
    {
        org.webrtc.NetworkMonitorAutoDetect$NetworkInformation v1_0 = 0;
        android.net.LinkProperties v0 = this.connectivityManager.getLinkProperties(p9);
        if (v0 != null) {
            if (v0.getInterfaceName() != null) {
                org.webrtc.NetworkMonitorAutoDetect$NetworkState v7 = this.getNetworkState(p9);
                if ((org.webrtc.NetworkMonitorAutoDetect$NetworkState.access$400(v7)) && (v7.getNetworkType() == 17)) {
                    v7 = this.getNetworkState();
                }
                org.webrtc.NetworkMonitorAutoDetect$ConnectionType v3 = org.webrtc.NetworkMonitorAutoDetect.getConnectionType(v7);
                if (v3 != org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_NONE) {
                    if ((v3 == org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN) || (v3 == org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN_CELLULAR)) {
                        org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("Network ").append(p9.toString()).append(" connection type is ").append(v3).append(" because it has type ").append(v7.getNetworkType()).append(" and subtype ").append(v7.getNetworkSubType()).toString());
                    }
                    v1_0 = new org.webrtc.NetworkMonitorAutoDetect$NetworkInformation(v0.getInterfaceName(), v3, org.webrtc.NetworkMonitorAutoDetect.access$000(p9), this.getIPAddresses(v0));
                } else {
                    org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("Network ").append(p9.toString()).append(" is disconnected").toString());
                }
            } else {
                org.webrtc.Logging.w("NetworkMonitorAutoDetect", new StringBuilder().append("Null interface name for network ").append(p9.toString()).toString());
            }
        } else {
            org.webrtc.Logging.w("NetworkMonitorAutoDetect", new StringBuilder().append("Detected unknown network: ").append(p9.toString()).toString());
        }
        return v1_0;
    }

    java.util.List getActiveNetworkList()
    {
        java.util.ArrayList v1_0;
        if (this.supportNetworkCallback()) {
            v1_0 = new java.util.ArrayList();
            android.net.Network[] v4 = this.getAllNetworks();
            int v5 = v4.length;
            int v3_1 = 0;
            while (v3_1 < v5) {
                org.webrtc.NetworkMonitorAutoDetect$NetworkInformation v0 = this.networkToInfo(v4[v3_1]);
                if (v0 != null) {
                    v1_0.add(v0);
                }
                v3_1++;
            }
        } else {
            v1_0 = 0;
        }
        return v1_0;
    }

    android.net.Network[] getAllNetworks()
    {
        android.net.Network[] v0_2;
        if (this.connectivityManager != null) {
            v0_2 = this.connectivityManager.getAllNetworks();
        } else {
            v0_2 = new android.net.Network[0];
        }
        return v0_2;
    }

    long getDefaultNetId()
    {
        long v0;
        if (this.supportNetworkCallback()) {
            android.net.NetworkInfo v2 = this.connectivityManager.getActiveNetworkInfo();
            if (v2 != null) {
                android.net.Network[] v5 = this.getAllNetworks();
                v0 = -1;
                int v9 = v5.length;
                int v8_0 = 0;
                while (v8_0 < v9) {
                    android.net.Network v3 = v5[v8_0];
                    if (this.hasInternetCapability(v3)) {
                        android.net.NetworkInfo v4 = this.connectivityManager.getNetworkInfo(v3);
                        if ((v4 != null) && (v4.getType() == v2.getType())) {
                            if (v0 == -1) {
                                v0 = org.webrtc.NetworkMonitorAutoDetect.access$000(v3);
                            } else {
                                throw new RuntimeException("Multiple connected networks of same type are not supported.");
                            }
                        }
                    }
                    v8_0++;
                }
            } else {
                v0 = -1;
            }
        } else {
            v0 = -1;
        }
        return v0;
    }

    org.webrtc.NetworkMonitorAutoDetect$IPAddress[] getIPAddresses(android.net.LinkProperties p7)
    {
        org.webrtc.NetworkMonitorAutoDetect$IPAddress[] v1 = new org.webrtc.NetworkMonitorAutoDetect$IPAddress[p7.getLinkAddresses().size()];
        int v0 = 0;
        java.util.Iterator v3_3 = p7.getLinkAddresses().iterator();
        while (v3_3.hasNext()) {
            v1[v0] = new org.webrtc.NetworkMonitorAutoDetect$IPAddress(((android.net.LinkAddress) v3_3.next()).getAddress().getAddress());
            v0++;
        }
        return v1;
    }

    org.webrtc.NetworkMonitorAutoDetect$NetworkState getNetworkState()
    {
        org.webrtc.NetworkMonitorAutoDetect$NetworkState v0_1;
        if (this.connectivityManager != null) {
            v0_1 = this.getNetworkState(this.connectivityManager.getActiveNetworkInfo());
        } else {
            v0_1 = new org.webrtc.NetworkMonitorAutoDetect$NetworkState(0, -1, -1);
        }
        return v0_1;
    }

    org.webrtc.NetworkMonitorAutoDetect$NetworkState getNetworkState(android.net.Network p4)
    {
        org.webrtc.NetworkMonitorAutoDetect$NetworkState v0_1;
        if (this.connectivityManager != null) {
            v0_1 = this.getNetworkState(this.connectivityManager.getNetworkInfo(p4));
        } else {
            v0_1 = new org.webrtc.NetworkMonitorAutoDetect$NetworkState(0, -1, -1);
        }
        return v0_1;
    }

    org.webrtc.NetworkMonitorAutoDetect$NetworkState getNetworkState(android.net.NetworkInfo p5)
    {
        if ((p5 != null) && (p5.isConnected())) {
            org.webrtc.NetworkMonitorAutoDetect$NetworkState v0_0 = new org.webrtc.NetworkMonitorAutoDetect$NetworkState(1, p5.getType(), p5.getSubtype());
        } else {
            v0_0 = new org.webrtc.NetworkMonitorAutoDetect$NetworkState(0, -1, -1);
        }
        return v0_0;
    }

    boolean hasInternetCapability(android.net.Network p4)
    {
        int v1 = 0;
        if (this.connectivityManager != null) {
            android.net.NetworkCapabilities v0 = this.connectivityManager.getNetworkCapabilities(p4);
            if ((v0 != null) && (v0.hasCapability(12))) {
                v1 = 1;
            }
        }
        return v1;
    }

    public void registerNetworkCallback(android.net.ConnectivityManager$NetworkCallback p4)
    {
        this.connectivityManager.registerNetworkCallback(new android.net.NetworkRequest$Builder().addCapability(12).build(), p4);
        return;
    }

    public void releaseCallback(android.net.ConnectivityManager$NetworkCallback p3)
    {
        if (this.supportNetworkCallback()) {
            org.webrtc.Logging.d("NetworkMonitorAutoDetect", "Unregister network callback");
            this.connectivityManager.unregisterNetworkCallback(p3);
        }
        return;
    }

    public void requestMobileNetwork(android.net.ConnectivityManager$NetworkCallback p4)
    {
        android.net.NetworkRequest$Builder v0_1 = new android.net.NetworkRequest$Builder();
        v0_1.addCapability(12).addTransportType(0);
        this.connectivityManager.requestNetwork(v0_1.build(), p4);
        return;
    }

    public boolean supportNetworkCallback()
    {
        if ((android.os.Build$VERSION.SDK_INT < 21) || (this.connectivityManager == null)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }
}
