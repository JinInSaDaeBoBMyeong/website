package org.webrtc;
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION;

    static RendererCommon()
    {
        org.webrtc.RendererCommon.BALANCED_VISIBLE_FRACTION = 1058013184;
        return;
    }

    public RendererCommon()
    {
        return;
    }

    private static void adjustOrigin(float[] p6)
    {
        int v4 = 12;
        p6[12] = (p6[12] - ((p6[0] + p6[4]) * 1056964608));
        p6[13] = (p6[int v5] - ((p6[1] + p6[5]) * 1056964608));
        p6[v4] = (p6[v4] + 1056964608);
        p6[13] = (p6[13] + 1056964608);
        return;
    }

    private static float convertScalingTypeToVisibleFraction(org.webrtc.RendererCommon$ScalingType p2)
    {
        float v0_3;
        switch (org.webrtc.RendererCommon$1.$SwitchMap$org$webrtc$RendererCommon$ScalingType[p2.ordinal()]) {
            case 1:
                v0_3 = 1065353216;
                break;
            case 2:
                v0_3 = 0;
                break;
            case 3:
                v0_3 = org.webrtc.RendererCommon.BALANCED_VISIBLE_FRACTION;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return v0_3;
    }

    private static android.graphics.Point getDisplaySize(float p4, float p5, int p6, int p7)
    {
        if ((p4 != 0) && (p5 != 0)) {
            android.graphics.Point v2_6 = new android.graphics.Point(Math.min(p6, Math.round(((((float) p7) / p4) * p5))), Math.min(p7, Math.round(((((float) p6) / p4) / p5))));
        } else {
            v2_6 = new android.graphics.Point(p6, p7);
        }
        return v2_6;
    }

    public static android.graphics.Point getDisplaySize(org.webrtc.RendererCommon$ScalingType p1, float p2, int p3, int p4)
    {
        return org.webrtc.RendererCommon.getDisplaySize(org.webrtc.RendererCommon.convertScalingTypeToVisibleFraction(p1), p2, p3, p4);
    }

    public static float[] getLayoutMatrix(boolean p5, float p6, float p7)
    {
        float v1 = 1065353216;
        float v2 = 1065353216;
        if (p7 <= p6) {
            v1 = (p7 / p6);
        } else {
            v2 = (p6 / p7);
        }
        if (p5) {
            v1 *= -1082130432;
        }
        float[] v0 = new float[16];
        android.opengl.Matrix.setIdentityM(v0, 0);
        android.opengl.Matrix.scaleM(v0, 0, v1, v2, 1065353216);
        org.webrtc.RendererCommon.adjustOrigin(v0);
        return v0;
    }

    public static final float[] horizontalFlipMatrix()
    {
        float[] v0_1 = new float[16];
        v0_1 = {-1082130432, 0, 0, 0, 0, 1065353216, 0, 0, 0, 0, 1065353216, 0, 1065353216, 0, 0, 1065353216};
        return v0_1;
    }

    public static final float[] identityMatrix()
    {
        float[] v0_1 = new float[16];
        v0_1 = {1065353216, 0, 0, 0, 0, 1065353216, 0, 0, 0, 0, 1065353216, 0, 0, 0, 0, 1065353216};
        return v0_1;
    }

    public static float[] multiplyMatrices(float[] p6, float[] p7)
    {
        float[] v0 = new float[16];
        android.opengl.Matrix.multiplyMM(v0, 0, p6, 0, p7, 0);
        return v0;
    }

    public static float[] rotateTextureMatrix(float[] p6, float p7)
    {
        float[] v0 = new float[16];
        android.opengl.Matrix.setRotateM(v0, 0, p7, 0, 0, 1065353216);
        org.webrtc.RendererCommon.adjustOrigin(v0);
        return org.webrtc.RendererCommon.multiplyMatrices(p6, v0);
    }

    public static final float[] verticalFlipMatrix()
    {
        float[] v0_1 = new float[16];
        v0_1 = {1065353216, 0, 0, 0, 0, -1082130432, 0, 0, 0, 0, 1065353216, 0, 0, 1065353216, 0, 1065353216};
        return v0_1;
    }
}
