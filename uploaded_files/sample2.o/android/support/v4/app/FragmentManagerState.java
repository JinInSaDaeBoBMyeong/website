package android.support.v4.app;
final class FragmentManagerState implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    android.support.v4.app.FragmentState[] mActive;
    int[] mAdded;
    android.support.v4.app.BackStackState[] mBackStack;

    static FragmentManagerState()
    {
        android.support.v4.app.FragmentManagerState.CREATOR = new android.support.v4.app.FragmentManagerState$1();
        return;
    }

    public FragmentManagerState()
    {
        return;
    }

    public FragmentManagerState(android.os.Parcel p2)
    {
        this.mActive = ((android.support.v4.app.FragmentState[]) p2.createTypedArray(android.support.v4.app.FragmentState.CREATOR));
        this.mAdded = p2.createIntArray();
        this.mBackStack = ((android.support.v4.app.BackStackState[]) p2.createTypedArray(android.support.v4.app.BackStackState.CREATOR));
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        p2.writeTypedArray(this.mActive, p3);
        p2.writeIntArray(this.mAdded);
        p2.writeTypedArray(this.mBackStack, p3);
        return;
    }
}
