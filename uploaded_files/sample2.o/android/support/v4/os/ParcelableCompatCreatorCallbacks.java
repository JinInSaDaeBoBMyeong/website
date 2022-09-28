package android.support.v4.os;
public interface ParcelableCompatCreatorCallbacks {

    public abstract Object createFromParcel();

    public abstract Object[] newArray();
}
