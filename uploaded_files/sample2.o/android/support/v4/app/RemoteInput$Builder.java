package android.support.v4.app;
public final class RemoteInput$Builder {
    private boolean mAllowFreeFormInput;
    private CharSequence[] mChoices;
    private android.os.Bundle mExtras;
    private CharSequence mLabel;
    private final String mResultKey;

    public RemoteInput$Builder(String p3)
    {
        this.mAllowFreeFormInput = 1;
        this.mExtras = new android.os.Bundle();
        if (p3 != null) {
            this.mResultKey = p3;
            return;
        } else {
            throw new IllegalArgumentException("Result key can\'t be null");
        }
    }

    public android.support.v4.app.RemoteInput$Builder addExtras(android.os.Bundle p2)
    {
        if (p2 != null) {
            this.mExtras.putAll(p2);
        }
        return this;
    }

    public android.support.v4.app.RemoteInput build()
    {
        return new android.support.v4.app.RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
    }

    public android.os.Bundle getExtras()
    {
        return this.mExtras;
    }

    public android.support.v4.app.RemoteInput$Builder setAllowFreeFormInput(boolean p1)
    {
        this.mAllowFreeFormInput = p1;
        return this;
    }

    public android.support.v4.app.RemoteInput$Builder setChoices(CharSequence[] p1)
    {
        this.mChoices = p1;
        return this;
    }

    public android.support.v4.app.RemoteInput$Builder setLabel(CharSequence p1)
    {
        this.mLabel = p1;
        return this;
    }
}
