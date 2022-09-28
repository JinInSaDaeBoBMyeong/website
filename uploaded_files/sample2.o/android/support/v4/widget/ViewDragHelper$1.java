package android.support.v4.widget;
final class ViewDragHelper$1 implements android.view.animation.Interpolator {

    ViewDragHelper$1()
    {
        return;
    }

    public float getInterpolation(float p3)
    {
        float v3_1 = (p3 - 1065353216);
        return (((((v3_1 * v3_1) * v3_1) * v3_1) * v3_1) + 1065353216);
    }
}
