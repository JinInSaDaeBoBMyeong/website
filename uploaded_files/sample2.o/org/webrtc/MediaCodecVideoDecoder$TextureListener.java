package org.webrtc;
 class MediaCodecVideoDecoder$TextureListener implements org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener {
    private org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer bufferToRender;
    private final Object newFrameLock;
    private org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer renderedBuffer;
    private final org.webrtc.SurfaceTextureHelper surfaceTextureHelper;

    public MediaCodecVideoDecoder$TextureListener(org.webrtc.SurfaceTextureHelper p2)
    {
        this.newFrameLock = new Object();
        this.surfaceTextureHelper = p2;
        p2.startListening(this);
        return;
    }

    public void addBufferToRender(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p3)
    {
        if (this.bufferToRender == null) {
            this.bufferToRender = p3;
            return;
        } else {
            org.webrtc.Logging.e("MediaCodecVideoDecoder", "Unexpected addBufferToRender() called while waiting for a texture.");
            throw new IllegalStateException("Waiting for a texture.");
        }
    }

    public org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer dequeueTextureBuffer(int p7)
    {
        try {
            if ((this.renderedBuffer == null) && ((p7 > 0) && (this.isWaitingForTexture()))) {
                this.newFrameLock.wait(((long) p7));
            }
        } catch (Thread v2_3) {
            throw v2_3;
        }
        org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer v1 = this.renderedBuffer;
        this.renderedBuffer = 0;
        return v1;
    }

    public boolean isWaitingForTexture()
    {
        try {
            int v0_1;
            if (this.bufferToRender == null) {
                v0_1 = 0;
            } else {
                v0_1 = 1;
            }
        } catch (int v0_2) {
            throw v0_2;
        }
        return v0_1;
    }

    public void onTextureFrameAvailable(int p16, float[] p17, long p18)
    {
        try {
            if (this.renderedBuffer == null) {
                this.renderedBuffer = new org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer(p16, p17, org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$100(this.bufferToRender), org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$200(this.bufferToRender), org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$300(this.bufferToRender), org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$400(this.bufferToRender), (android.os.SystemClock.elapsedRealtime() - org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$500(this.bufferToRender)));
                this.bufferToRender = 0;
                this.newFrameLock.notifyAll();
                return;
            } else {
                org.webrtc.Logging.e("MediaCodecVideoDecoder", "Unexpected onTextureFrameAvailable() called while already holding a texture.");
                throw new IllegalStateException("Already holding a texture.");
            }
        } catch (Object v0_9) {
            throw v0_9;
        }
    }

    public void release()
    {
        this.surfaceTextureHelper.stopListening();
        try {
            if (this.renderedBuffer != null) {
                this.surfaceTextureHelper.returnTextureFrame();
                this.renderedBuffer = 0;
            }
        } catch (int v0_1) {
            throw v0_1;
        }
        return;
    }
}
