package org.webrtc;
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private static org.webrtc.NetworkMonitor instance;
    private org.webrtc.NetworkMonitorAutoDetect autoDetector;
    private org.webrtc.NetworkMonitorAutoDetect$ConnectionType currentConnectionType;
    private final java.util.ArrayList nativeNetworkObservers;
    private final java.util.ArrayList networkObservers;

    private NetworkMonitor()
    {
        this.currentConnectionType = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN;
        this.nativeNetworkObservers = new java.util.ArrayList();
        this.networkObservers = new java.util.ArrayList();
        return;
    }

    static synthetic void access$000(org.webrtc.NetworkMonitor p0, org.webrtc.NetworkMonitorAutoDetect$ConnectionType p1)
    {
        p0.updateCurrentConnectionType(p1);
        return;
    }

    static synthetic void access$100(org.webrtc.NetworkMonitor p0, org.webrtc.NetworkMonitorAutoDetect$NetworkInformation p1)
    {
        p0.notifyObserversOfNetworkConnect(p1);
        return;
    }

    static synthetic void access$200(org.webrtc.NetworkMonitor p1, long p2)
    {
        p1.notifyObserversOfNetworkDisconnect(p2);
        return;
    }

    public static void addNetworkObserver(org.webrtc.NetworkMonitor$NetworkObserver p1)
    {
        org.webrtc.NetworkMonitor.getInstance().addNetworkObserverInternal(p1);
        return;
    }

    private void addNetworkObserverInternal(org.webrtc.NetworkMonitor$NetworkObserver p2)
    {
        this.networkObservers.add(p2);
        return;
    }

    private static int androidSdkInt()
    {
        return android.os.Build$VERSION.SDK_INT;
    }

    private static void assertIsTrue(boolean p2)
    {
        if (p2) {
            return;
        } else {
            throw new AssertionError("Expected to be true");
        }
    }

    private void destroyAutoDetector()
    {
        if (this.autoDetector != null) {
            this.autoDetector.destroy();
            this.autoDetector = 0;
        }
        return;
    }

    public static org.webrtc.NetworkMonitorAutoDetect getAutoDetectorForTest()
    {
        return org.webrtc.NetworkMonitor.getInstance().autoDetector;
    }

    private org.webrtc.NetworkMonitorAutoDetect$ConnectionType getCurrentConnectionType()
    {
        return this.currentConnectionType;
    }

    private long getCurrentDefaultNetId()
    {
        long v0_2;
        if (this.autoDetector != null) {
            v0_2 = this.autoDetector.getDefaultNetId();
        } else {
            v0_2 = -1;
        }
        return v0_2;
    }

    public static org.webrtc.NetworkMonitor getInstance()
    {
        if (org.webrtc.NetworkMonitor.instance == null) {
            org.webrtc.NetworkMonitor.instance = new org.webrtc.NetworkMonitor();
        }
        return org.webrtc.NetworkMonitor.instance;
    }

    public static void init(android.content.Context p0)
    {
        return;
    }

    public static boolean isOnline()
    {
        int v1_2;
        if (org.webrtc.NetworkMonitor.getInstance().getCurrentConnectionType() == org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_NONE) {
            v1_2 = 0;
        } else {
            v1_2 = 1;
        }
        return v1_2;
    }

    private native void nativeNotifyConnectionTypeChanged();

    private native void nativeNotifyOfActiveNetworkList();

    private native void nativeNotifyOfNetworkConnect();

    private native void nativeNotifyOfNetworkDisconnect();

    private boolean networkBindingSupported()
    {
        if ((this.autoDetector == null) || (!this.autoDetector.supportNetworkCallback())) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    private void notifyObserversOfConnectionTypeChange(org.webrtc.NetworkMonitorAutoDetect$ConnectionType p6)
    {
        boolean v4_1 = this.nativeNetworkObservers.iterator();
        while (v4_1.hasNext()) {
            this.nativeNotifyConnectionTypeChanged(((Long) v4_1.next()).longValue());
        }
        java.util.Iterator v3_5 = this.networkObservers.iterator();
        while (v3_5.hasNext()) {
            ((org.webrtc.NetworkMonitor$NetworkObserver) v3_5.next()).onConnectionTypeChanged(p6);
        }
        return;
    }

    private void notifyObserversOfNetworkConnect(org.webrtc.NetworkMonitorAutoDetect$NetworkInformation p5)
    {
        java.util.Iterator v3 = this.nativeNetworkObservers.iterator();
        while (v3.hasNext()) {
            this.nativeNotifyOfNetworkConnect(((Long) v3.next()).longValue(), p5);
        }
        return;
    }

    private void notifyObserversOfNetworkDisconnect(long p6)
    {
        java.util.Iterator v3 = this.nativeNetworkObservers.iterator();
        while (v3.hasNext()) {
            this.nativeNotifyOfNetworkDisconnect(((Long) v3.next()).longValue(), p6);
        }
        return;
    }

    public static void removeNetworkObserver(org.webrtc.NetworkMonitor$NetworkObserver p1)
    {
        org.webrtc.NetworkMonitor.getInstance().removeNetworkObserverInternal(p1);
        return;
    }

    private void removeNetworkObserverInternal(org.webrtc.NetworkMonitor$NetworkObserver p2)
    {
        this.networkObservers.remove(p2);
        return;
    }

    static void resetInstanceForTests()
    {
        org.webrtc.NetworkMonitor.instance = new org.webrtc.NetworkMonitor();
        return;
    }

    public static void setAutoDetectConnectivityState(boolean p1)
    {
        org.webrtc.NetworkMonitor.getInstance().setAutoDetectConnectivityStateInternal(p1);
        return;
    }

    private void setAutoDetectConnectivityStateInternal(boolean p5)
    {
        if (p5) {
            if (this.autoDetector == null) {
                this.autoDetector = new org.webrtc.NetworkMonitorAutoDetect(new org.webrtc.NetworkMonitor$1(this), org.webrtc.ContextUtils.getApplicationContext());
                this.updateCurrentConnectionType(org.webrtc.NetworkMonitorAutoDetect.getConnectionType(this.autoDetector.getCurrentNetworkState()));
                this.updateActiveNetworkList();
            }
        } else {
            this.destroyAutoDetector();
        }
        return;
    }

    private void startMonitoring(long p4)
    {
        org.webrtc.Logging.d("NetworkMonitor", new StringBuilder().append("Start monitoring from native observer ").append(p4).toString());
        this.nativeNetworkObservers.add(Long.valueOf(p4));
        this.setAutoDetectConnectivityStateInternal(1);
        return;
    }

    private void stopMonitoring(long p4)
    {
        org.webrtc.Logging.d("NetworkMonitor", new StringBuilder().append("Stop monitoring from native observer ").append(p4).toString());
        this.setAutoDetectConnectivityStateInternal(0);
        this.nativeNetworkObservers.remove(Long.valueOf(p4));
        return;
    }

    private void updateActiveNetworkList()
    {
        java.util.List v2 = this.autoDetector.getActiveNetworkList();
        if ((v2 != null) && (v2.size() != 0)) {
            org.webrtc.NetworkMonitorAutoDetect$NetworkInformation[] v3_2 = new org.webrtc.NetworkMonitorAutoDetect$NetworkInformation[v2.size()];
            org.webrtc.NetworkMonitorAutoDetect$NetworkInformation[] v3_1 = ((org.webrtc.NetworkMonitorAutoDetect$NetworkInformation[]) v2.toArray(v3_2));
            java.util.Iterator v5 = this.nativeNetworkObservers.iterator();
            while (v5.hasNext()) {
                this.nativeNotifyOfActiveNetworkList(((Long) v5.next()).longValue(), v3_1);
            }
        }
        return;
    }

    private void updateCurrentConnectionType(org.webrtc.NetworkMonitorAutoDetect$ConnectionType p1)
    {
        this.currentConnectionType = p1;
        this.notifyObserversOfConnectionTypeChange(p1);
        return;
    }
}
