package android.support.v4.app;
final class RemoteInput$1 implements android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory {

    RemoteInput$1()
    {
        return;
    }

    public android.support.v4.app.RemoteInput build(String p7, CharSequence p8, CharSequence[] p9, boolean p10, android.os.Bundle p11)
    {
        return new android.support.v4.app.RemoteInput(p7, p8, p9, p10, p11);
    }

    public bridge synthetic android.support.v4.app.RemoteInputCompatBase$RemoteInput build(String p2, CharSequence p3, CharSequence[] p4, boolean p5, android.os.Bundle p6)
    {
        return this.build(p2, p3, p4, p5, p6);
    }

    public android.support.v4.app.RemoteInput[] newArray(int p2)
    {
        android.support.v4.app.RemoteInput[] v0 = new android.support.v4.app.RemoteInput[p2];
        return v0;
    }

    public bridge synthetic android.support.v4.app.RemoteInputCompatBase$RemoteInput[] newArray(int p2)
    {
        return this.newArray(p2);
    }
}
