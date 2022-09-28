package android.support.v4.app;
 class Fragment$1 implements android.support.v4.app.FragmentContainer {
    final synthetic android.support.v4.app.Fragment this$0;

    Fragment$1(android.support.v4.app.Fragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public android.view.View findViewById(int p3)
    {
        if (this.this$0.mView != null) {
            return this.this$0.mView.findViewById(p3);
        } else {
            throw new IllegalStateException("Fragment does not have a view");
        }
    }
}
