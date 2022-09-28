package android.support.v4.widget;
public class DrawerLayout$SavedState extends android.view.View$BaseSavedState {
    public static final android.os.Parcelable$Creator CREATOR;
    int lockModeLeft;
    int lockModeRight;
    int openDrawerGravity;

    static DrawerLayout$SavedState()
    {
        android.support.v4.widget.DrawerLayout$SavedState.CREATOR = new android.support.v4.widget.DrawerLayout$SavedState$1();
        return;
    }

    public DrawerLayout$SavedState(android.os.Parcel p2)
    {
        super(p2);
        super.openDrawerGravity = 0;
        super.lockModeLeft = 0;
        super.lockModeRight = 0;
        super.openDrawerGravity = p2.readInt();
        return;
    }

    public DrawerLayout$SavedState(android.os.Parcelable p2)
    {
        super(p2);
        super.openDrawerGravity = 0;
        super.lockModeLeft = 0;
        super.lockModeRight = 0;
        return;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        super.writeToParcel(p2, p3);
        p2.writeInt(this.openDrawerGravity);
        return;
    }
}
