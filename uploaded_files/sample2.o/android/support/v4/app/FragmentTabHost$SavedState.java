package android.support.v4.app;
 class FragmentTabHost$SavedState extends android.view.View$BaseSavedState {
    public static final android.os.Parcelable$Creator CREATOR;
    String curTab;

    static FragmentTabHost$SavedState()
    {
        android.support.v4.app.FragmentTabHost$SavedState.CREATOR = new android.support.v4.app.FragmentTabHost$SavedState$1();
        return;
    }

    private FragmentTabHost$SavedState(android.os.Parcel p2)
    {
        super(p2);
        super.curTab = p2.readString();
        return;
    }

    synthetic FragmentTabHost$SavedState(android.os.Parcel p1, android.support.v4.app.FragmentTabHost$1 p2)
    {
        this(p1);
        return;
    }

    FragmentTabHost$SavedState(android.os.Parcelable p1)
    {
        super(p1);
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(this.curTab).append("}").toString();
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        super.writeToParcel(p2, p3);
        p2.writeString(this.curTab);
        return;
    }
}
