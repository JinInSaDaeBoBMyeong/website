package android.support.v4.app;
final class FragmentTabHost$TabInfo {
    private final android.os.Bundle args;
    private final Class clss;
    private android.support.v4.app.Fragment fragment;
    private final String tag;

    FragmentTabHost$TabInfo(String p1, Class p2, android.os.Bundle p3)
    {
        this.tag = p1;
        this.clss = p2;
        this.args = p3;
        return;
    }

    static synthetic android.support.v4.app.Fragment access$100(android.support.v4.app.FragmentTabHost$TabInfo p1)
    {
        return p1.fragment;
    }

    static synthetic android.support.v4.app.Fragment access$102(android.support.v4.app.FragmentTabHost$TabInfo p0, android.support.v4.app.Fragment p1)
    {
        p0.fragment = p1;
        return p1;
    }

    static synthetic String access$200(android.support.v4.app.FragmentTabHost$TabInfo p1)
    {
        return p1.tag;
    }

    static synthetic Class access$300(android.support.v4.app.FragmentTabHost$TabInfo p1)
    {
        return p1.clss;
    }

    static synthetic android.os.Bundle access$400(android.support.v4.app.FragmentTabHost$TabInfo p1)
    {
        return p1.args;
    }
}
