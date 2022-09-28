package android.support.v4.app;
public class RemoteInput extends android.support.v4.app.RemoteInputCompatBase$RemoteInput {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory FACTORY = None;
    private static final android.support.v4.app.RemoteInput$Impl IMPL = None;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final android.os.Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    static RemoteInput()
    {
        if (android.os.Build$VERSION.SDK_INT < 20) {
            if (android.os.Build$VERSION.SDK_INT < 16) {
                android.support.v4.app.RemoteInput.IMPL = new android.support.v4.app.RemoteInput$ImplBase();
            } else {
                android.support.v4.app.RemoteInput.IMPL = new android.support.v4.app.RemoteInput$ImplJellybean();
            }
        } else {
            android.support.v4.app.RemoteInput.IMPL = new android.support.v4.app.RemoteInput$ImplApi20();
        }
        android.support.v4.app.RemoteInput.FACTORY = new android.support.v4.app.RemoteInput$1();
        return;
    }

    RemoteInput(String p1, CharSequence p2, CharSequence[] p3, boolean p4, android.os.Bundle p5)
    {
        this.mResultKey = p1;
        this.mLabel = p2;
        this.mChoices = p3;
        this.mAllowFreeFormInput = p4;
        this.mExtras = p5;
        return;
    }

    public static void addResultsToIntent(android.support.v4.app.RemoteInput[] p1, android.content.Intent p2, android.os.Bundle p3)
    {
        android.support.v4.app.RemoteInput.IMPL.addResultsToIntent(p1, p2, p3);
        return;
    }

    public static android.os.Bundle getResultsFromIntent(android.content.Intent p1)
    {
        return android.support.v4.app.RemoteInput.IMPL.getResultsFromIntent(p1);
    }

    public boolean getAllowFreeFormInput()
    {
        return this.mAllowFreeFormInput;
    }

    public CharSequence[] getChoices()
    {
        return this.mChoices;
    }

    public android.os.Bundle getExtras()
    {
        return this.mExtras;
    }

    public CharSequence getLabel()
    {
        return this.mLabel;
    }

    public String getResultKey()
    {
        return this.mResultKey;
    }
}
