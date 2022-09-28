package android.support.v4.widget;
final class BakedBezierInterpolator implements android.view.animation.Interpolator {
    private static final android.support.v4.widget.BakedBezierInterpolator INSTANCE;
    private static final float STEP_SIZE;
    private static final float[] VALUES;

    static BakedBezierInterpolator()
    {
        android.support.v4.widget.BakedBezierInterpolator.INSTANCE = new android.support.v4.widget.BakedBezierInterpolator();
        float v0_4 = new float[101];
        v0_4 = {0, 961656599, 980151802, 989399404, 996929018, 1002525898, 1007478532, 1011021880, 1015061833, 1017853562, 1020430542, 1023638346, 1025544238, 1027611191, 1030215015, 1032214859, 1033718098, 1035315288, 1037274867, 1039328399, 1040851770, 1041992620, 1043180447, 1044737373, 1046032574, 1047703585, 1049002141, 1049891334, 1050619465, 1051548923, 1052491802, 1053448104, 1054417827, 1055199645, 1056179434, 1056964608, 1057357195, 1057749782, 1058140691, 1058529922, 1058867144, 1059201011, 1059533200, 1059813379, 1060137180, 1060410648, 1060679084, 1060900543, 1061162267, 1061377016, 1061588409, 1061794768, 1061997773, 1062177289, 1062353450, 1062544710, 1062694027, 1062841667, 1062984273, 1063125202, 1063262775, 1063395315, 1063526177, 1063636907, 1063744281, 1063865077, 1063952318, 1064064726, 1064146934, 1064225787, 1064316384, 1064403626, 1064474090, 1064544554, 1064609985, 1064675416, 1064735814, 1064786146, 1064841511, 1064886809, 1064938819, 1064979084, 1065026060, 1065061292, 1065096525, 1065128401, 1065158600, 1065187122, 1065213965, 1065237453, 1065259264, 1065277719, 1065292818, 1065307918, 1065321339, 1065329728, 1065339794, 1065344827, 1065349861, 1065353216, 1065353216};
        android.support.v4.widget.BakedBezierInterpolator.VALUES = v0_4;
        android.support.v4.widget.BakedBezierInterpolator.STEP_SIZE = (1065353216 / ((float) (android.support.v4.widget.BakedBezierInterpolator.VALUES.length - 1)));
        return;
    }

    private BakedBezierInterpolator()
    {
        return;
    }

    public static final android.support.v4.widget.BakedBezierInterpolator getInstance()
    {
        return android.support.v4.widget.BakedBezierInterpolator.INSTANCE;
    }

    public float getInterpolation(float p8)
    {
        float v4_0 = 1065353216;
        if (p8 < 1065353216) {
            if (p8 > 0) {
                int v1 = Math.min(((int) (((float) (android.support.v4.widget.BakedBezierInterpolator.VALUES.length - 1)) * p8)), (android.support.v4.widget.BakedBezierInterpolator.VALUES.length - 2));
                v4_0 = (android.support.v4.widget.BakedBezierInterpolator.VALUES[v1] + ((android.support.v4.widget.BakedBezierInterpolator.VALUES[(v1 + 1)] - android.support.v4.widget.BakedBezierInterpolator.VALUES[v1]) * ((p8 - (((float) v1) * android.support.v4.widget.BakedBezierInterpolator.STEP_SIZE)) / android.support.v4.widget.BakedBezierInterpolator.STEP_SIZE)));
            } else {
                v4_0 = 0;
            }
        }
        return v4_0;
    }
}
