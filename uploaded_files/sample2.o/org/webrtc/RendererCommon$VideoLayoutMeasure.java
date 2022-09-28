package org.webrtc;
public class RendererCommon$VideoLayoutMeasure {
    private org.webrtc.RendererCommon$ScalingType scalingTypeMatchOrientation;
    private org.webrtc.RendererCommon$ScalingType scalingTypeMismatchOrientation;

    public RendererCommon$VideoLayoutMeasure()
    {
        this.scalingTypeMatchOrientation = org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_BALANCED;
        this.scalingTypeMismatchOrientation = org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_BALANCED;
        return;
    }

    public android.graphics.Point measure(int p9, int p10, int p11, int p12)
    {
        android.graphics.Point v2_0;
        int v4 = android.view.View.getDefaultSize(2147483647, p9);
        int v3 = android.view.View.getDefaultSize(2147483647, p10);
        if ((p11 != 0) && ((p12 != 0) && ((v4 != 0) && (v3 != 0)))) {
            int v7_2;
            float v1 = (((float) p11) / ((float) p12));
            if (v1 <= 1065353216) {
                v7_2 = 0;
            } else {
                v7_2 = 1;
            }
            int v6_9;
            if ((((float) v4) / ((float) v3)) <= 1065353216) {
                v6_9 = 0;
            } else {
                v6_9 = 1;
            }
            org.webrtc.RendererCommon$ScalingType v5;
            if (v7_2 != v6_9) {
                v5 = this.scalingTypeMismatchOrientation;
            } else {
                v5 = this.scalingTypeMatchOrientation;
            }
            v2_0 = org.webrtc.RendererCommon.getDisplaySize(v5, v1, v4, v3);
            if (android.view.View$MeasureSpec.getMode(p9) == 1073741824) {
                v2_0.x = v4;
            }
            if (android.view.View$MeasureSpec.getMode(p10) == 1073741824) {
                v2_0.y = v3;
            }
        } else {
            v2_0 = new android.graphics.Point(v4, v3);
        }
        return v2_0;
    }

    public void setScalingType(org.webrtc.RendererCommon$ScalingType p1)
    {
        this.scalingTypeMatchOrientation = p1;
        this.scalingTypeMismatchOrientation = p1;
        return;
    }

    public void setScalingType(org.webrtc.RendererCommon$ScalingType p1, org.webrtc.RendererCommon$ScalingType p2)
    {
        this.scalingTypeMatchOrientation = p1;
        this.scalingTypeMismatchOrientation = p2;
        return;
    }
}
