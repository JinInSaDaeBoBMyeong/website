package org.webrtc;
public class Camera2Enumerator implements org.webrtc.CameraEnumerator {
    private static final double NANO_SECONDS_PER_SECOND = 1104006501;
    private static final String TAG = "Camera2Enumerator";
    private static final java.util.Map cachedSupportedFormats;
    final android.hardware.camera2.CameraManager cameraManager;
    final android.content.Context context;

    static Camera2Enumerator()
    {
        org.webrtc.Camera2Enumerator.cachedSupportedFormats = new java.util.HashMap();
        return;
    }

    public Camera2Enumerator(android.content.Context p2)
    {
        this.context = p2;
        this.cameraManager = ((android.hardware.camera2.CameraManager) p2.getSystemService("camera"));
        return;
    }

    static java.util.List convertFramerates(android.util.Range[] p7, int p8)
    {
        java.util.ArrayList v1_1 = new java.util.ArrayList();
        int v4 = p7.length;
        int v3 = 0;
        while (v3 < v4) {
            android.util.Range v0 = p7[v3];
            v1_1.add(new org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange((((Integer) v0.getLower()).intValue() * p8), (((Integer) v0.getUpper()).intValue() * p8)));
            v3++;
        }
        return v1_1;
    }

    private static java.util.List convertSizes(android.util.Size[] p7)
    {
        java.util.ArrayList v1_1 = new java.util.ArrayList();
        int v3 = p7.length;
        int v2 = 0;
        while (v2 < v3) {
            android.util.Size v0 = p7[v2];
            v1_1.add(new org.webrtc.Size(v0.getWidth(), v0.getHeight()));
            v2++;
        }
        return v1_1;
    }

    private android.hardware.camera2.CameraCharacteristics getCameraCharacteristics(String p5)
    {
        try {
            int v1_1 = this.cameraManager.getCameraCharacteristics(p5);
        } catch (android.util.AndroidException v0) {
            org.webrtc.Logging.e("Camera2Enumerator", new StringBuilder().append("Camera access exception: ").append(v0).toString());
            v1_1 = 0;
        }
        return v1_1;
    }

    static int getFpsUnitFactor(android.util.Range[] p2)
    {
        int v1 = 1000;
        if (p2.length != 0) {
            int v0_1;
            if (((Integer) p2[0].getUpper()).intValue() >= 1000) {
                v0_1 = 1;
            } else {
                v0_1 = 1000;
            }
            v1 = v0_1;
        }
        return v1;
    }

    static java.util.List getSupportedFormats(android.content.Context p1, String p2)
    {
        return org.webrtc.Camera2Enumerator.getSupportedFormats(((android.hardware.camera2.CameraManager) p1.getSystemService("camera")), p2);
    }

    static java.util.List getSupportedFormats(android.hardware.camera2.CameraManager p28, String p29)
    {
        try {
            java.util.ArrayList v21_1;
            if (!org.webrtc.Camera2Enumerator.cachedSupportedFormats.containsKey(p29)) {
                org.webrtc.Logging.d("Camera2Enumerator", new StringBuilder().append("Get supported formats for camera index ").append(p29).append(".").toString());
                long v18 = android.os.SystemClock.elapsedRealtime();
                android.hardware.camera2.CameraCharacteristics v4 = p28.getCameraCharacteristics(p29);
                android.hardware.camera2.params.StreamConfigurationMap v20_1 = ((android.hardware.camera2.params.StreamConfigurationMap) v4.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP));
                android.util.Range[] v10_1 = ((android.util.Range[]) v4.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
                java.util.List v12 = org.webrtc.Camera2Enumerator.convertFramerates(v10_1, org.webrtc.Camera2Enumerator.getFpsUnitFactor(v10_1));
                java.util.List v17 = org.webrtc.Camera2Enumerator.getSupportedSizes(v4);
                int v5 = 0;
                java.util.ArrayList v21_11 = v12.iterator();
                while (v21_11.hasNext()) {
                    v5 = Math.max(v5, ((org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange) v21_11.next()).max);
                }
                java.util.ArrayList v9_1 = new java.util.ArrayList();
                java.util.ArrayList v21_13 = v17.iterator();
                while (v21_13.hasNext()) {
                    org.webrtc.Size v16_1 = ((org.webrtc.Size) v21_13.next());
                    try {
                        long v14 = v20_1.getOutputMinFrameDuration(android.graphics.SurfaceTexture, new android.util.Size(v16_1.width, v16_1.height));
                    } catch (String v23) {
                    }
                    int v13;
                    if (v14 != 0) {
                        v13 = (((int) Math.round((1000000000.0 / ((double) v14)))) * 1000);
                    } else {
                        v13 = v5;
                    }
                    String v23_6 = new org.webrtc.CameraEnumerationAndroid$CaptureFormat;
                    v23_6(v16_1.width, v16_1.height, 0, v13);
                    v9_1.add(v23_6);
                    org.webrtc.Logging.d("Camera2Enumerator", new StringBuilder().append("Format: ").append(v16_1.width).append("x").append(v16_1.height).append("@").append(v13).toString());
                }
                org.webrtc.Camera2Enumerator.cachedSupportedFormats.put(p29, v9_1);
                org.webrtc.Logging.d("Camera2Enumerator", new StringBuilder().append("Get supported formats for camera index ").append(p29).append(" done. Time spent: ").append((android.os.SystemClock.elapsedRealtime() - v18)).append(" ms.").toString());
                v21_1 = v9_1;
            } else {
                v21_1 = ((java.util.List) org.webrtc.Camera2Enumerator.cachedSupportedFormats.get(p29));
            }
        } catch (java.util.ArrayList v21_4) {
            throw v21_4;
        }
        return v21_1;
    }

    static java.util.List getSupportedSizes(android.hardware.camera2.CameraCharacteristics p11)
    {
        java.util.ArrayList v1_0;
        android.hardware.camera2.params.StreamConfigurationMap v5_1 = ((android.hardware.camera2.params.StreamConfigurationMap) p11.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP));
        int v6 = ((Integer) p11.get(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        java.util.List v4 = org.webrtc.Camera2Enumerator.convertSizes(v5_1.getOutputSizes(android.graphics.SurfaceTexture));
        if ((android.os.Build$VERSION.SDK_INT >= 22) || (v6 != 2)) {
            v1_0 = v4;
        } else {
            android.graphics.Rect v0_1 = ((android.graphics.Rect) p11.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
            v1_0 = new java.util.ArrayList();
            java.util.Iterator v7_5 = v4.iterator();
            while (v7_5.hasNext()) {
                org.webrtc.Size v3_1 = ((org.webrtc.Size) v7_5.next());
                if ((v0_1.width() * v3_1.height) == (v0_1.height() * v3_1.width)) {
                    v1_0.add(v3_1);
                }
            }
        }
        return v1_0;
    }

    public static boolean isSupported(android.content.Context p10)
    {
        int v5_2;
        if (android.os.Build$VERSION.SDK_INT >= 21) {
            android.hardware.camera2.CameraManager v1_1 = ((android.hardware.camera2.CameraManager) p10.getSystemService("camera"));
            try {
                String[] v0 = v1_1.getCameraIdList();
                int v7_0 = 0;
            } catch (android.util.AndroidException v3) {
                org.webrtc.Logging.e("Camera2Enumerator", new StringBuilder().append("Camera access exception: ").append(v3).toString());
                v5_2 = 0;
            }
            while (v7_0 < v0.length) {
                if (((Integer) v1_1.getCameraCharacteristics(v0[v7_0]).get(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() != 2) {
                    v7_0++;
                } else {
                    v5_2 = 0;
                }
            }
            v5_2 = 1;
        } else {
            v5_2 = 0;
        }
        return v5_2;
    }

    public org.webrtc.CameraVideoCapturer createCapturer(String p3, org.webrtc.CameraVideoCapturer$CameraEventsHandler p4)
    {
        return new org.webrtc.Camera2Capturer(this.context, p3, p4);
    }

    public String[] getDeviceNames()
    {
        try {
            String[] v1_2 = this.cameraManager.getCameraIdList();
        } catch (android.util.AndroidException v0) {
            org.webrtc.Logging.e("Camera2Enumerator", new StringBuilder().append("Camera access exception: ").append(v0).toString());
            v1_2 = new String[0];
        }
        return v1_2;
    }

    public java.util.List getSupportedFormats(String p2)
    {
        return org.webrtc.Camera2Enumerator.getSupportedFormats(this.context, p2);
    }

    public boolean isBackFacing(String p4)
    {
        int v1_0;
        android.hardware.camera2.CameraCharacteristics v0 = this.getCameraCharacteristics(p4);
        if ((v0 == null) || (((Integer) v0.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING)).intValue() != 1)) {
            v1_0 = 0;
        } else {
            v1_0 = 1;
        }
        return v1_0;
    }

    public boolean isFrontFacing(String p3)
    {
        int v1_0;
        android.hardware.camera2.CameraCharacteristics v0 = this.getCameraCharacteristics(p3);
        if ((v0 == null) || (((Integer) v0.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING)).intValue() != 0)) {
            v1_0 = 0;
        } else {
            v1_0 = 1;
        }
        return v1_0;
    }
}
