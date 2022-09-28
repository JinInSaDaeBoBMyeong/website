package android.support.v4.os;
public class ParcelableCompat {

    public ParcelableCompat()
    {
        return;
    }

    public static android.os.Parcelable$Creator newCreator(android.support.v4.os.ParcelableCompatCreatorCallbacks p2)
    {
        if (android.os.Build$VERSION.SDK_INT >= 13) {
            android.support.v4.os.ParcelableCompatCreatorHoneycombMR2Stub.instantiate(p2);
        }
        return new android.support.v4.os.ParcelableCompat$CompatCreator(p2);
    }
}
