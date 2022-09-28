package org.webrtc;
public class VideoRenderer$I420Frame {
    public final int height;
    private long nativeFramePointer;
    public int rotationDegree;
    public final float[] samplingMatrix;
    public int textureId;
    public final int width;
    public final boolean yuvFrame;
    public java.nio.ByteBuffer[] yuvPlanes;
    public final int[] yuvStrides;

    public VideoRenderer$I420Frame(int p5, int p6, int p7, int p8, float[] p9, long p10)
    {
        this.width = p5;
        this.height = p6;
        this.yuvStrides = 0;
        this.yuvPlanes = 0;
        this.samplingMatrix = p9;
        this.textureId = p8;
        this.yuvFrame = 0;
        this.rotationDegree = p7;
        this.nativeFramePointer = p10;
        if ((p7 % 90) == 0) {
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Rotation degree not multiple of 90: ").append(p7).toString());
        }
    }

    public VideoRenderer$I420Frame(int p9, int p10, int p11, float[] p12, org.webrtc.VideoFrame$Buffer p13, long p14)
    {
        this.width = p9;
        this.height = p10;
        this.rotationDegree = p11;
        if ((p11 % 90) == 0) {
            if (!(p13 instanceof org.webrtc.VideoFrame$TextureBuffer)) {
                org.webrtc.VideoFrame$I420Buffer v0 = p13.toI420();
                this.yuvFrame = 1;
                float[] v2_1 = new int[3];
                v2_1[0] = v0.getStrideY();
                v2_1[1] = v0.getStrideU();
                v2_1[2] = v0.getStrideV();
                this.yuvStrides = v2_1;
                float[] v2_2 = new java.nio.ByteBuffer[3];
                v2_2[0] = v0.getDataY();
                v2_2[1] = v0.getDataU();
                v2_2[2] = v0.getDataV();
                this.yuvPlanes = v2_2;
                this.samplingMatrix = org.webrtc.RendererCommon.multiplyMatrices(p12, org.webrtc.RendererCommon.verticalFlipMatrix());
                this.textureId = 0;
            } else {
                this.yuvFrame = 0;
                this.textureId = ((org.webrtc.VideoFrame$TextureBuffer) p13).getTextureId();
                this.samplingMatrix = p12;
                this.yuvStrides = 0;
                this.yuvPlanes = 0;
            }
            this.nativeFramePointer = p14;
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Rotation degree not multiple of 90: ").append(p11).toString());
        }
    }

    public VideoRenderer$I420Frame(int p5, int p6, int p7, int[] p8, java.nio.ByteBuffer[] p9, long p10)
    {
        this.width = p5;
        this.height = p6;
        this.yuvStrides = p8;
        this.yuvPlanes = p9;
        this.yuvFrame = 1;
        this.rotationDegree = p7;
        this.nativeFramePointer = p10;
        if ((p7 % 90) == 0) {
            this.samplingMatrix = org.webrtc.RendererCommon.verticalFlipMatrix();
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Rotation degree not multiple of 90: ").append(p7).toString());
        }
    }

    static synthetic long access$000(org.webrtc.VideoRenderer$I420Frame p2)
    {
        return p2.nativeFramePointer;
    }

    static synthetic long access$002(org.webrtc.VideoRenderer$I420Frame p1, long p2)
    {
        p1.nativeFramePointer = p2;
        return p2;
    }

    public int rotatedHeight()
    {
        int v0_2;
        if ((this.rotationDegree % 180) != 0) {
            v0_2 = this.width;
        } else {
            v0_2 = this.height;
        }
        return v0_2;
    }

    public int rotatedWidth()
    {
        int v0_2;
        if ((this.rotationDegree % 180) != 0) {
            v0_2 = this.height;
        } else {
            v0_2 = this.width;
        }
        return v0_2;
    }

    public String toString()
    {
        return new StringBuilder().append(this.width).append("x").append(this.height).append(":").append(this.yuvStrides[0]).append(":").append(this.yuvStrides[1]).append(":").append(this.yuvStrides[2]).toString();
    }
}
