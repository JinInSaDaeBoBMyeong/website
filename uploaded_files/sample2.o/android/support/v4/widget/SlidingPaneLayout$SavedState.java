package android.support.v4.widget;
 class SlidingPaneLayout$SavedState extends android.view.View$BaseSavedState {
    public static final android.os.Parcelable$Creator CREATOR;
    boolean isOpen;

    static SlidingPaneLayout$SavedState()
    {
        android.support.v4.widget.SlidingPaneLayout$SavedState.CREATOR = new android.support.v4.widget.SlidingPaneLayout$SavedState$1();
        return;
    }

    private SlidingPaneLayout$SavedState(android.os.Parcel p2)
    {
        int v0_1;
        super(p2);
        if (p2.readInt() == 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        super.isOpen = v0_1;
        return;
    }

    synthetic SlidingPaneLayout$SavedState(android.os.Parcel p1, android.support.v4.widget.SlidingPaneLayout$1 p2)
    {
        this(p1);
        return;
    }

    SlidingPaneLayout$SavedState(android.os.Parcelable p1)
    {
        super(p1);
        return;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        int v0_1;
        super.writeToParcel(p2, p3);
        if (!this.isOpen) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        p2.writeInt(v0_1);
        return;
    }
}
