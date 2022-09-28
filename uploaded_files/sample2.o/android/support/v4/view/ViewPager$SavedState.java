package android.support.v4.view;
public class ViewPager$SavedState extends android.view.View$BaseSavedState {
    public static final android.os.Parcelable$Creator CREATOR;
    android.os.Parcelable adapterState;
    ClassLoader loader;
    int position;

    static ViewPager$SavedState()
    {
        android.support.v4.view.ViewPager$SavedState.CREATOR = android.support.v4.os.ParcelableCompat.newCreator(new android.support.v4.view.ViewPager$SavedState$1());
        return;
    }

    ViewPager$SavedState(android.os.Parcel p2, ClassLoader p3)
    {
        super(p2);
        if (p3 == null) {
            p3 = super.getClass().getClassLoader();
        }
        super.position = p2.readInt();
        super.adapterState = p2.readParcelable(p3);
        super.loader = p3;
        return;
    }

    public ViewPager$SavedState(android.os.Parcelable p1)
    {
        super(p1);
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("FragmentPager.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(this.position).append("}").toString();
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        super.writeToParcel(p2, p3);
        p2.writeInt(this.position);
        p2.writeParcelable(this.adapterState, p3);
        return;
    }
}
