package android.support.v4.app;
public abstract class RemoteInputCompatBase$RemoteInput {

    public RemoteInputCompatBase$RemoteInput()
    {
        return;
    }

    protected abstract boolean getAllowFreeFormInput();

    protected abstract CharSequence[] getChoices();

    protected abstract android.os.Bundle getExtras();

    protected abstract CharSequence getLabel();

    protected abstract String getResultKey();
}
