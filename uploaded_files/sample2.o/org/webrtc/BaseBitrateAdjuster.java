package org.webrtc;
 class BaseBitrateAdjuster implements org.webrtc.BitrateAdjuster {
    protected int targetBitrateBps;
    protected int targetFps;

    BaseBitrateAdjuster()
    {
        this.targetBitrateBps = 0;
        this.targetFps = 0;
        return;
    }

    public int getAdjustedBitrateBps()
    {
        return this.targetBitrateBps;
    }

    public int getAdjustedFramerate()
    {
        return this.targetFps;
    }

    public void reportEncodedFrame(int p1)
    {
        return;
    }

    public void setTargets(int p1, int p2)
    {
        this.targetBitrateBps = p1;
        this.targetFps = p2;
        return;
    }
}
