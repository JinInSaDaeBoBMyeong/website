package android.support.v4.view;
final class ViewPager$2 implements android.view.animation.Interpolator {

    ViewPager$2()
    {
        return;
    }

    public float getInterpolation(float p3)
    {
        float v3_1 = (p3 - 1065353216);
        return (((((v3_1 * v3_1) * v3_1) * v3_1) * v3_1) + 1065353216);
    }
}
