package android.support.v4.app;
 class FragmentTabHost$DummyTabFactory implements android.widget.TabHost$TabContentFactory {
    private final android.content.Context mContext;

    public FragmentTabHost$DummyTabFactory(android.content.Context p1)
    {
        this.mContext = p1;
        return;
    }

    public android.view.View createTabContent(String p4)
    {
        android.view.View v0_1 = new android.view.View(this.mContext);
        v0_1.setMinimumWidth(0);
        v0_1.setMinimumHeight(0);
        return v0_1;
    }
}
