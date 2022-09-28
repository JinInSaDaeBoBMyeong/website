package org.webrtc;
interface BitrateAdjuster {

    public abstract int getAdjustedBitrateBps();

    public abstract int getAdjustedFramerate();

    public abstract void reportEncodedFrame();

    public abstract void setTargets();
}
