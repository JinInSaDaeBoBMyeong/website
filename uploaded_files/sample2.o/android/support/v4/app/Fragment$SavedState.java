package android.support.v4.app;
public class Fragment$SavedState implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    final android.os.Bundle mState;

    static Fragment$SavedState()
    {
        android.support.v4.app.Fragment$SavedState.CREATOR = new android.support.v4.app.Fragment$SavedState$1();
        return;
    }

    Fragment$SavedState(android.os.Bundle p1)
    {
        this.mState = p1;
        return;
    }

    Fragment$SavedState(android.os.Parcel p2, ClassLoader p3)
    {
        this.mState = p2.readBundle();
        if ((p3 != null) && (this.mState != null)) {
            this.mState.setClassLoader(p3);
        }
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        p2.writeBundle(this.mState);
        return;
    }
}
