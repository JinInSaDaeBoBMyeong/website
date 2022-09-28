package org.webrtc;
public class Camera1Enumerator implements org.webrtc.CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static java.util.List cachedSupportedFormats;
    private final boolean captureToTexture;

    public Camera1Enumerator()
    {
        this(1);
        return;
    }

    public Camera1Enumerator(boolean p1)
    {
        this.captureToTexture = p1;
        return;
    }

    static java.util.List convertFramerates(java.util.List p6)
    {
        java.util.ArrayList v1_1 = new java.util.ArrayList();
        java.util.Iterator v2 = p6.iterator();
        while (v2.hasNext()) {
            int[] v0_0 = ((int[]) v2.next());
            v1_1.add(new org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange(v0_0[0], v0_0[1]));
        }
        return v1_1;
    }

    static java.util.List convertSizes(java.util.List p6)
    {
        java.util.ArrayList v1_1 = new java.util.ArrayList();
        java.util.Iterator v2 = p6.iterator();
        while (v2.hasNext()) {
            android.hardware.Camera$Size v0_0 = ((android.hardware.Camera$Size) v2.next());
            v1_1.add(new org.webrtc.Size(v0_0.width, v0_0.height));
        }
        return v1_1;
    }

    private static java.util.List enumerateFormats(int p22)
    {
        org.webrtc.Logging.d("Camera1Enumerator", new StringBuilder().append("Get supported formats for camera index ").append(p22).append(".").toString());
        long v16 = android.os.SystemClock.elapsedRealtime();
        try {
            org.webrtc.Logging.d("Camera1Enumerator", new StringBuilder().append("Opening camera with index ").append(p22).toString());
            android.hardware.Camera v4 = android.hardware.Camera.open(p22);
            android.hardware.Camera$Parameters v12 = v4.getParameters();
        } catch (Exception v5_0) {
            org.webrtc.Logging.e("Camera1Enumerator", new StringBuilder().append("Open camera failed on camera index ").append(p22).toString(), v5_0);
            java.util.ArrayList v8_1 = new java.util.ArrayList();
            if (v4 == null) {
                return v8_1;
            } else {
                v4.release();
                return v8_1;
            }
        } catch (String v15_4) {
            if (v4 != null) {
                v4.release();
            }
            throw v15_4;
        }
        if (v4 != null) {
            v4.release();
        }
        v8_1 = new java.util.ArrayList();
        int v11 = 0;
        int v10 = 0;
        try {
            java.util.List v9 = v12.getSupportedPreviewFpsRange();
        } catch (Exception v5_1) {
            org.webrtc.Logging.e("Camera1Enumerator", new StringBuilder().append("getSupportedFormats() failed on camera index ").append(p22).toString(), v5_1);
            org.webrtc.Logging.d("Camera1Enumerator", new StringBuilder().append("Get supported formats for camera index ").append(p22).append(" done. Time spent: ").append((android.os.SystemClock.elapsedRealtime() - v16)).append(" ms.").toString());
            return v8_1;
        }
        if (v9 != null) {
            int[] v13_1 = ((int[]) v9.get((v9.size() - 1)));
            v11 = v13_1[0];
            v10 = v13_1[1];
        }
        String v15_10 = v12.getSupportedPreviewSizes().iterator();
        while (v15_10.hasNext()) {
            android.hardware.Camera$Size v14_1 = ((android.hardware.Camera$Size) v15_10.next());
            org.webrtc.CameraEnumerationAndroid$CaptureFormat v18_10 = new org.webrtc.CameraEnumerationAndroid$CaptureFormat;
            v18_10(v14_1.width, v14_1.height, v11, v10);
            v8_1.add(v18_10);
        }
    }

    static int getCameraIndex(String p4)
    {
        org.webrtc.Logging.d("Camera1Enumerator", new StringBuilder().append("getCameraIndex: ").append(p4).toString());
        int v0 = 0;
        while (v0 < android.hardware.Camera.getNumberOfCameras()) {
            if (!p4.equals(org.webrtc.Camera1Enumerator.getDeviceName(v0))) {
                v0++;
            } else {
                return v0;
            }
        }
        throw new IllegalArgumentException(new StringBuilder().append("No such camera: ").append(p4).toString());
    }

    private static android.hardware.Camera$CameraInfo getCameraInfo(int p5)
    {
        int v1_1 = new android.hardware.Camera$CameraInfo();
        try {
            android.hardware.Camera.getCameraInfo(p5, v1_1);
        } catch (Exception v0) {
            org.webrtc.Logging.e("Camera1Enumerator", new StringBuilder().append("getCameraInfo failed on index ").append(p5).toString(), v0);
            v1_1 = 0;
        }
        return v1_1;
    }

    static String getDeviceName(int p4)
    {
        String v2_6;
        android.hardware.Camera$CameraInfo v1 = org.webrtc.Camera1Enumerator.getCameraInfo(p4);
        if (v1 != null) {
            String v0;
            if (v1.facing != 1) {
                v0 = "back";
            } else {
                v0 = "front";
            }
            v2_6 = new StringBuilder().append("Camera ").append(p4).append(", Facing ").append(v0).append(", Orientation ").append(v1.orientation).toString();
        } else {
            v2_6 = 0;
        }
        return v2_6;
    }

    static declared_synchronized java.util.List getSupportedFormats(int p4)
    {
        try {
            if (org.webrtc.Camera1Enumerator.cachedSupportedFormats == null) {
                org.webrtc.Camera1Enumerator.cachedSupportedFormats = new java.util.ArrayList();
                int v0 = 0;
                while (v0 < android.hardware.Camera.getNumberOfCameras()) {
                    org.webrtc.Camera1Enumerator.cachedSupportedFormats.add(org.webrtc.Camera1Enumerator.enumerateFormats(v0));
                    v0++;
                }
            }
        } catch (java.util.List v1_5) {
            throw v1_5;
        }
        return ((java.util.List) org.webrtc.Camera1Enumerator.cachedSupportedFormats.get(p4));
    }

    public org.webrtc.CameraVideoCapturer createCapturer(String p3, org.webrtc.CameraVideoCapturer$CameraEventsHandler p4)
    {
        return new org.webrtc.Camera1Capturer(p3, p4, this.captureToTexture);
    }

    public String[] getDeviceNames()
    {
        java.util.ArrayList v3_1 = new java.util.ArrayList();
        int v0 = 0;
        while (v0 < android.hardware.Camera.getNumberOfCameras()) {
            String v1 = org.webrtc.Camera1Enumerator.getDeviceName(v0);
            if (v1 == null) {
                org.webrtc.Logging.e("Camera1Enumerator", new StringBuilder().append("Index: ").append(v0).append(". Failed to query camera name.").toString());
            } else {
                v3_1.add(v1);
                org.webrtc.Logging.d("Camera1Enumerator", new StringBuilder().append("Index: ").append(v0).append(". ").append(v1).toString());
            }
            v0++;
        }
        String[] v2 = new String[v3_1.size()];
        return ((String[]) v3_1.toArray(v2));
    }

    public java.util.List getSupportedFormats(String p2)
    {
        return org.webrtc.Camera1Enumerator.getSupportedFormats(org.webrtc.Camera1Enumerator.getCameraIndex(p2));
    }

    public boolean isBackFacing(String p3)
    {
        int v1_2;
        android.hardware.Camera$CameraInfo v0 = org.webrtc.Camera1Enumerator.getCameraInfo(org.webrtc.Camera1Enumerator.getCameraIndex(p3));
        if ((v0 == null) || (v0.facing != 0)) {
            v1_2 = 0;
        } else {
            v1_2 = 1;
        }
        return v1_2;
    }

    public boolean isFrontFacing(String p4)
    {
        int v1 = 1;
        android.hardware.Camera$CameraInfo v0 = org.webrtc.Camera1Enumerator.getCameraInfo(org.webrtc.Camera1Enumerator.getCameraIndex(p4));
        if ((v0 == null) || (v0.facing != 1)) {
            v1 = 0;
        }
        return v1;
    }
}
