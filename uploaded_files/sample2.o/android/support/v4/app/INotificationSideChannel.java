package android.support.v4.app;
public interface INotificationSideChannel implements android.os.IInterface {

    public abstract void cancel();

    public abstract void cancelAll();

    public abstract void notify();
}
