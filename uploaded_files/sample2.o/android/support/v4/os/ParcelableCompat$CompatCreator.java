package android.support.v4.os;
 class ParcelableCompat$CompatCreator implements android.os.Parcelable$Creator {
    final android.support.v4.os.ParcelableCompatCreatorCallbacks mCallbacks;

    public ParcelableCompat$CompatCreator(android.support.v4.os.ParcelableCompatCreatorCallbacks p1)
    {
        this.mCallbacks = p1;
        return;
    }

    public Object createFromParcel(android.os.Parcel p3)
    {
        return this.mCallbacks.createFromParcel(p3, 0);
    }

    public Object[] newArray(int p2)
    {
        return this.mCallbacks.newArray(p2);
    }
}
