package org.webrtc;
 class DynamicBitrateAdjuster extends org.webrtc.BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 16400;
    private static final double BITRATE_ADJUSTMENT_SEC = 16392;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 16416;
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    DynamicBitrateAdjuster()
    {
        this.deviationBytes = 0;
        this.timeSinceLastAdjustmentMs = 0;
        this.bitrateAdjustmentScaleExp = 0;
        return;
    }

    public int getAdjustedBitrateBps()
    {
        return ((int) (((double) this.targetBitrateBps) * Math.pow(4.0, (((double) this.bitrateAdjustmentScaleExp) / 20.0))));
    }

    public void reportEncodedFrame(int p15)
    {
        if (this.targetFps != 0) {
            this.deviationBytes = (this.deviationBytes + (((double) p15) - ((((double) this.targetBitrateBps) / 8.0) / ((double) this.targetFps))));
            this.timeSinceLastAdjustmentMs = (this.timeSinceLastAdjustmentMs + (1000.0 / ((double) this.targetFps)));
            double v4 = (((double) this.targetBitrateBps) / 8.0);
            double v2 = (3.0 * v4);
            this.deviationBytes = Math.min(this.deviationBytes, v2);
            this.deviationBytes = Math.max(this.deviationBytes, (- v2));
            if (this.timeSinceLastAdjustmentMs > 3000.0) {
                if (this.deviationBytes <= v4) {
                    if (this.deviationBytes < (- v4)) {
                        this.bitrateAdjustmentScaleExp = (this.bitrateAdjustmentScaleExp + ((int) (((- this.deviationBytes) / v4) + 0.5)));
                        this.bitrateAdjustmentScaleExp = Math.min(this.bitrateAdjustmentScaleExp, 20);
                        this.deviationBytes = (- v4);
                    }
                } else {
                    this.bitrateAdjustmentScaleExp = (this.bitrateAdjustmentScaleExp - ((int) ((this.deviationBytes / v4) + 0.5)));
                    this.bitrateAdjustmentScaleExp = Math.max(this.bitrateAdjustmentScaleExp, -20);
                    this.deviationBytes = v4;
                }
                this.timeSinceLastAdjustmentMs = 0;
            }
        }
        return;
    }

    public void setTargets(int p5, int p6)
    {
        if ((this.targetBitrateBps > 0) && (p5 < this.targetBitrateBps)) {
            this.deviationBytes = ((this.deviationBytes * ((double) p5)) / ((double) this.targetBitrateBps));
        }
        super.setTargets(p5, p6);
        return;
    }
}
