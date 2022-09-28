package org.webrtc;
 class FramerateBitrateAdjuster extends org.webrtc.BaseBitrateAdjuster {
    private static final int INITIAL_FPS = 30;

    FramerateBitrateAdjuster()
    {
        return;
    }

    public void setTargets(int p4, int p5)
    {
        if (this.targetFps == 0) {
            p5 = 30;
        }
        super.setTargets(p4, p5);
        this.targetBitrateBps = (this.targetBitrateBps * (30 / this.targetFps));
        return;
    }
}
