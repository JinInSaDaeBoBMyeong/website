package org.webrtc;
interface FileVideoCapturer$VideoReader {

    public abstract void close();

    public abstract int getFrameHeight();

    public abstract int getFrameWidth();

    public abstract byte[] getNextFrame();
}
