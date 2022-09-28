package org.webrtc;
public class VideoFileRenderer implements org.webrtc.VideoRenderer$Callbacks {
    private static final String TAG = "VideoFileRenderer";
    private org.webrtc.EglBase eglBase;
    private final Object handlerLock;
    private final int outputFileHeight;
    private final String outputFileName;
    private final int outputFileWidth;
    private final java.nio.ByteBuffer outputFrameBuffer;
    private final int outputFrameSize;
    private java.util.ArrayList rawFrames;
    private final android.os.HandlerThread renderThread;
    private final android.os.Handler renderThreadHandler;
    private final java.io.FileOutputStream videoOutFile;
    private org.webrtc.YuvConverter yuvConverter;

    static VideoFileRenderer()
    {
        System.loadLibrary("jingle_peerconnection_so");
        return;
    }

    public VideoFileRenderer(String p4, int p5, int p6, org.webrtc.EglBase$Context p7)
    {
        this.handlerLock = new Object();
        this.rawFrames = new java.util.ArrayList();
        if (((p5 % 2) != 1) && ((p6 % 2) != 1)) {
            this.outputFileName = p4;
            this.outputFileWidth = p5;
            this.outputFileHeight = p6;
            this.outputFrameSize = (((p5 * p6) * 3) / 2);
            this.outputFrameBuffer = java.nio.ByteBuffer.allocateDirect(this.outputFrameSize);
            this.videoOutFile = new java.io.FileOutputStream(p4);
            this.videoOutFile.write(new StringBuilder().append("YUV4MPEG2 C420 W").append(p5).append(" H").append(p6).append(" Ip F30:1 A1:1\n").toString().getBytes());
            this.renderThread = new android.os.HandlerThread("VideoFileRenderer");
            this.renderThread.start();
            this.renderThreadHandler = new android.os.Handler(this.renderThread.getLooper());
            org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, new org.webrtc.VideoFileRenderer$1(this, p7));
            return;
        } else {
            throw new IllegalArgumentException("Does not support uneven width or height");
        }
    }

    static synthetic org.webrtc.EglBase access$000(org.webrtc.VideoFileRenderer p1)
    {
        return p1.eglBase;
    }

    static synthetic org.webrtc.EglBase access$002(org.webrtc.VideoFileRenderer p0, org.webrtc.EglBase p1)
    {
        p0.eglBase = p1;
        return p1;
    }

    static synthetic org.webrtc.YuvConverter access$100(org.webrtc.VideoFileRenderer p1)
    {
        return p1.yuvConverter;
    }

    static synthetic org.webrtc.YuvConverter access$102(org.webrtc.VideoFileRenderer p0, org.webrtc.YuvConverter p1)
    {
        p0.yuvConverter = p1;
        return p1;
    }

    static synthetic void access$200(org.webrtc.VideoFileRenderer p0, org.webrtc.VideoRenderer$I420Frame p1)
    {
        p0.renderFrameOnRenderThread(p1);
        return;
    }

    static synthetic android.os.HandlerThread access$300(org.webrtc.VideoFileRenderer p1)
    {
        return p1.renderThread;
    }

    public static native java.nio.ByteBuffer nativeCreateNativeByteBuffer();

    public static native void nativeFreeNativeByteBuffer();

    public static native void nativeI420Scale();

    private void renderFrameOnRenderThread(org.webrtc.VideoRenderer$I420Frame p30)
    {
        float[] v9 = org.webrtc.RendererCommon.multiplyMatrices(org.webrtc.RendererCommon.rotateTextureMatrix(p30.samplingMatrix, ((float) p30.rotationDegree)), org.webrtc.RendererCommon.getLayoutMatrix(0, (((float) p30.rotatedWidth()) / ((float) p30.rotatedHeight())), (((float) this.outputFileWidth) / ((float) this.outputFileHeight))));
        try {
            java.nio.ByteBuffer v21 = org.webrtc.VideoFileRenderer.nativeCreateNativeByteBuffer(this.outputFrameSize);
        } catch (int v3_18) {
            org.webrtc.VideoRenderer.renderFrameDone(p30);
            throw v3_18;
        }
        if (p30.yuvFrame) {
            org.webrtc.VideoFileRenderer.nativeI420Scale(p30.yuvPlanes[0], p30.yuvStrides[0], p30.yuvPlanes[1], p30.yuvStrides[1], p30.yuvPlanes[2], p30.yuvStrides[2], p30.width, p30.height, this.outputFrameBuffer, this.outputFileWidth, this.outputFileHeight);
            v21.put(this.outputFrameBuffer.array(), this.outputFrameBuffer.arrayOffset(), this.outputFrameSize);
        } else {
            this.yuvConverter.convert(this.outputFrameBuffer, this.outputFileWidth, this.outputFileHeight, this.outputFileWidth, p30.textureId, v9);
            int v28 = this.outputFileWidth;
            byte[] v22 = this.outputFrameBuffer.array();
            int v25 = this.outputFrameBuffer.arrayOffset();
            v21.put(v22, v25, (this.outputFileWidth * this.outputFileHeight));
            int v26_0 = this.outputFileHeight;
            while (v26_0 < ((this.outputFileHeight * 3) / 2)) {
                v21.put(v22, ((v26_0 * v28) + v25), (v28 / 2));
                v26_0++;
            }
            int v26_1 = this.outputFileHeight;
            while (v26_1 < ((this.outputFileHeight * 3) / 2)) {
                v21.put(v22, (((v26_1 * v28) + v25) + (v28 / 2)), (v28 / 2));
                v26_1++;
            }
        }
        v21.rewind();
        this.rawFrames.add(v21);
        org.webrtc.VideoRenderer.renderFrameDone(p30);
        return;
    }

    public void release()
    {
        java.util.concurrent.CountDownLatch v1_1 = new java.util.concurrent.CountDownLatch(1);
        this.renderThreadHandler.post(new org.webrtc.VideoFileRenderer$3(this, v1_1));
        org.webrtc.ThreadUtils.awaitUninterruptibly(v1_1);
        try {
            String v4_1 = this.rawFrames.iterator();
        } catch (java.io.IOException v3) {
            org.webrtc.Logging.e("VideoFileRenderer", "Error writing video to disk", v3);
            return;
        }
        while (v4_1.hasNext()) {
            java.nio.ByteBuffer v0_1 = ((java.nio.ByteBuffer) v4_1.next());
            this.videoOutFile.write("FRAME\n".getBytes());
            byte[] v2 = new byte[this.outputFrameSize];
            v0_1.get(v2);
            this.videoOutFile.write(v2);
            org.webrtc.VideoFileRenderer.nativeFreeNativeByteBuffer(v0_1);
        }
        this.videoOutFile.close();
        org.webrtc.Logging.d("VideoFileRenderer", new StringBuilder().append("Video written to disk as ").append(this.outputFileName).append(". Number frames are ").append(this.rawFrames.size()).append(" and the dimension of the frames are ").append(this.outputFileWidth).append("x").append(this.outputFileHeight).append(".").toString());
        return;
    }

    public void renderFrame(org.webrtc.VideoRenderer$I420Frame p3)
    {
        this.renderThreadHandler.post(new org.webrtc.VideoFileRenderer$2(this, p3));
        return;
    }
}
