package android.support.v4.os;
 class ParcelableCompatCreatorHoneycombMR2 implements android.os.Parcelable$ClassLoaderCreator {
    private final android.support.v4.os.ParcelableCompatCreatorCallbacks mCallbacks;

    public ParcelableCompatCreatorHoneycombMR2(android.support.v4.os.ParcelableCompatCreatorCallbacks p1)
    {
        this.mCallbacks = p1;
        return;
    }

    public Object createFromParcel(android.os.Parcel p3)
    {
        return this.mCallbacks.createFromParcel(p3, 0);
    }

    public Object createFromParcel(android.os.Parcel p2, ClassLoader p3)
    {
        return this.mCallbacks.createFromParcel(p2, p3);
    }

    public Object[] newArray(int p2)
    {
        return this.mCallbacks.newArray(p2);
    }
}
