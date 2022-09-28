package android.support.v4.widget;
 class SlidingPaneLayout$SlidingPanelLayoutImplJB extends android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase {
    private reflect.Method mGetDisplayList;
    private reflect.Field mRecreateDisplayList;

    SlidingPaneLayout$SlidingPanelLayoutImplJB()
    {
        try {
            this.mGetDisplayList = android.view.View.getDeclaredMethod("getDisplayList", ((Class[]) 0));
            try {
                this.mRecreateDisplayList = android.view.View.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(1);
            } catch (NoSuchFieldException v0_0) {
                android.util.Log.e("SlidingPaneLayout", "Couldn\'t fetch mRecreateDisplayList field; dimming will be slow.", v0_0);
            }
            return;
        } catch (NoSuchFieldException v0_1) {
            android.util.Log.e("SlidingPaneLayout", "Couldn\'t fetch getDisplayList method; dimming won\'t work right.", v0_1);
        }
    }

    public void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout p4, android.view.View p5)
    {
        if ((this.mGetDisplayList == null) || (this.mRecreateDisplayList == null)) {
            p5.invalidate();
        } else {
            try {
                this.mRecreateDisplayList.setBoolean(p5, 1);
                this.mGetDisplayList.invoke(p5, ((Object[]) 0));
            } catch (Exception v0) {
                android.util.Log.e("SlidingPaneLayout", "Error refreshing display list state", v0);
            }
            super.invalidateChildRegion(p4, p5);
        }
        return;
    }
}
