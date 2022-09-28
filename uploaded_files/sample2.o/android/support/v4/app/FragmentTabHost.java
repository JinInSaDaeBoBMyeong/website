package android.support.v4.app;
public class FragmentTabHost extends android.widget.TabHost implements android.widget.TabHost$OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private android.content.Context mContext;
    private android.support.v4.app.FragmentManager mFragmentManager;
    private android.support.v4.app.FragmentTabHost$TabInfo mLastTab;
    private android.widget.TabHost$OnTabChangeListener mOnTabChangeListener;
    private android.widget.FrameLayout mRealTabContent;
    private final java.util.ArrayList mTabs;

    public FragmentTabHost(android.content.Context p3)
    {
        super(p3, 0);
        super.mTabs = new java.util.ArrayList();
        super.initFragmentTabHost(p3, 0);
        return;
    }

    public FragmentTabHost(android.content.Context p2, android.util.AttributeSet p3)
    {
        super(p2, p3);
        super.mTabs = new java.util.ArrayList();
        super.initFragmentTabHost(p2, p3);
        return;
    }

    private android.support.v4.app.FragmentTransaction doTabChanged(String p7, android.support.v4.app.FragmentTransaction p8)
    {
        android.support.v4.app.FragmentTabHost$TabInfo v1 = 0;
        int v0 = 0;
        while (v0 < this.mTabs.size()) {
            android.support.v4.app.FragmentTabHost$TabInfo v2_1 = ((android.support.v4.app.FragmentTabHost$TabInfo) this.mTabs.get(v0));
            if (android.support.v4.app.FragmentTabHost$TabInfo.access$200(v2_1).equals(p7)) {
                v1 = v2_1;
            }
            v0++;
        }
        if (v1 != null) {
            if (this.mLastTab != v1) {
                if (p8 == null) {
                    p8 = this.mFragmentManager.beginTransaction();
                }
                if ((this.mLastTab != null) && (android.support.v4.app.FragmentTabHost$TabInfo.access$100(this.mLastTab) != null)) {
                    p8.detach(android.support.v4.app.FragmentTabHost$TabInfo.access$100(this.mLastTab));
                }
                if (v1 != null) {
                    if (android.support.v4.app.FragmentTabHost$TabInfo.access$100(v1) != null) {
                        p8.attach(android.support.v4.app.FragmentTabHost$TabInfo.access$100(v1));
                    } else {
                        android.support.v4.app.FragmentTabHost$TabInfo.access$102(v1, android.support.v4.app.Fragment.instantiate(this.mContext, android.support.v4.app.FragmentTabHost$TabInfo.access$300(v1).getName(), android.support.v4.app.FragmentTabHost$TabInfo.access$400(v1)));
                        p8.add(this.mContainerId, android.support.v4.app.FragmentTabHost$TabInfo.access$100(v1), android.support.v4.app.FragmentTabHost$TabInfo.access$200(v1));
                    }
                }
                this.mLastTab = v1;
            }
            return p8;
        } else {
            throw new IllegalStateException(new StringBuilder().append("No tab known for tag ").append(p7).toString());
        }
    }

    private void ensureContent()
    {
        if (this.mRealTabContent == null) {
            this.mRealTabContent = ((android.widget.FrameLayout) this.findViewById(this.mContainerId));
            if (this.mRealTabContent == null) {
                throw new IllegalStateException(new StringBuilder().append("No tab content FrameLayout found for id ").append(this.mContainerId).toString());
            }
        }
        return;
    }

    private void ensureHierarchy(android.content.Context p9)
    {
        if (this.findViewById(16908307) == null) {
            android.widget.LinearLayout v1_1 = new android.widget.LinearLayout(p9);
            v1_1.setOrientation(1);
            this.addView(v1_1, new android.widget.FrameLayout$LayoutParams(-1, -1));
            android.widget.TabWidget v2_1 = new android.widget.TabWidget(p9);
            v2_1.setId(16908307);
            v2_1.setOrientation(0);
            v1_1.addView(v2_1, new android.widget.LinearLayout$LayoutParams(-1, -2, 0));
            android.widget.FrameLayout v0_1 = new android.widget.FrameLayout(p9);
            v0_1.setId(16908305);
            v1_1.addView(v0_1, new android.widget.LinearLayout$LayoutParams(0, 0, 0));
            android.widget.FrameLayout v0_3 = new android.widget.FrameLayout(p9);
            this.mRealTabContent = v0_3;
            this.mRealTabContent.setId(this.mContainerId);
            v1_1.addView(v0_3, new android.widget.LinearLayout$LayoutParams(-1, 0, 1065353216));
        }
        return;
    }

    private void initFragmentTabHost(android.content.Context p5, android.util.AttributeSet p6)
    {
        int v1_1 = new int[1];
        v1_1[0] = 16842995;
        android.content.res.TypedArray v0 = p5.obtainStyledAttributes(p6, v1_1, 0, 0);
        this.mContainerId = v0.getResourceId(0, 0);
        v0.recycle();
        super.setOnTabChangedListener(this);
        return;
    }

    public void addTab(android.widget.TabHost$TabSpec p6, Class p7, android.os.Bundle p8)
    {
        p6.setContent(new android.support.v4.app.FragmentTabHost$DummyTabFactory(this.mContext));
        String v2 = p6.getTag();
        android.support.v4.app.FragmentTabHost$TabInfo v1_1 = new android.support.v4.app.FragmentTabHost$TabInfo(v2, p7, p8);
        if (this.mAttached) {
            android.support.v4.app.FragmentTabHost$TabInfo.access$102(v1_1, this.mFragmentManager.findFragmentByTag(v2));
            if ((android.support.v4.app.FragmentTabHost$TabInfo.access$100(v1_1) != null) && (!android.support.v4.app.FragmentTabHost$TabInfo.access$100(v1_1).isDetached())) {
                android.support.v4.app.FragmentTransaction v0 = this.mFragmentManager.beginTransaction();
                v0.detach(android.support.v4.app.FragmentTabHost$TabInfo.access$100(v1_1));
                v0.commit();
            }
        }
        this.mTabs.add(v1_1);
        this.addTab(p6);
        return;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String v0 = this.getCurrentTabTag();
        android.support.v4.app.FragmentTransaction v1_1 = 0;
        int v2 = 0;
        while (v2 < this.mTabs.size()) {
            android.support.v4.app.FragmentTabHost$TabInfo v3_1 = ((android.support.v4.app.FragmentTabHost$TabInfo) this.mTabs.get(v2));
            android.support.v4.app.FragmentTabHost$TabInfo.access$102(v3_1, this.mFragmentManager.findFragmentByTag(android.support.v4.app.FragmentTabHost$TabInfo.access$200(v3_1)));
            if ((android.support.v4.app.FragmentTabHost$TabInfo.access$100(v3_1) != null) && (!android.support.v4.app.FragmentTabHost$TabInfo.access$100(v3_1).isDetached())) {
                if (!android.support.v4.app.FragmentTabHost$TabInfo.access$200(v3_1).equals(v0)) {
                    if (v1_1 == null) {
                        v1_1 = this.mFragmentManager.beginTransaction();
                    }
                    v1_1.detach(android.support.v4.app.FragmentTabHost$TabInfo.access$100(v3_1));
                } else {
                    this.mLastTab = v3_1;
                }
            }
            v2++;
        }
        this.mAttached = 1;
        android.support.v4.app.FragmentTransaction v1_0 = this.doTabChanged(v0, v1_1);
        if (v1_0 != null) {
            v1_0.commit();
            this.mFragmentManager.executePendingTransactions();
        }
        return;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        this.mAttached = 0;
        return;
    }

    protected void onRestoreInstanceState(android.os.Parcelable p3)
    {
        super.onRestoreInstanceState(((android.support.v4.app.FragmentTabHost$SavedState) p3).getSuperState());
        this.setCurrentTabByTag(((android.support.v4.app.FragmentTabHost$SavedState) p3).curTab);
        return;
    }

    protected android.os.Parcelable onSaveInstanceState()
    {
        android.support.v4.app.FragmentTabHost$SavedState v0_1 = new android.support.v4.app.FragmentTabHost$SavedState(super.onSaveInstanceState());
        v0_1.curTab = this.getCurrentTabTag();
        return v0_1;
    }

    public void onTabChanged(String p3)
    {
        if (this.mAttached) {
            android.support.v4.app.FragmentTransaction v0 = this.doTabChanged(p3, 0);
            if (v0 != null) {
                v0.commit();
            }
        }
        if (this.mOnTabChangeListener != null) {
            this.mOnTabChangeListener.onTabChanged(p3);
        }
        return;
    }

    public void setOnTabChangedListener(android.widget.TabHost$OnTabChangeListener p1)
    {
        this.mOnTabChangeListener = p1;
        return;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(android.content.Context p1, android.support.v4.app.FragmentManager p2)
    {
        this.ensureHierarchy(p1);
        super.setup();
        this.mContext = p1;
        this.mFragmentManager = p2;
        this.ensureContent();
        return;
    }

    public void setup(android.content.Context p3, android.support.v4.app.FragmentManager p4, int p5)
    {
        this.ensureHierarchy(p3);
        super.setup();
        this.mContext = p3;
        this.mFragmentManager = p4;
        this.mContainerId = p5;
        this.ensureContent();
        this.mRealTabContent.setId(p5);
        if (this.getId() == -1) {
            this.setId(16908306);
        }
        return;
    }
}
