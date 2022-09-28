package android.support.v4.app;
 class RemoteInputCompatApi20 {

    RemoteInputCompatApi20()
    {
        return;
    }

    static void addResultsToIntent(android.support.v4.app.RemoteInputCompatBase$RemoteInput[] p1, android.content.Intent p2, android.os.Bundle p3)
    {
        android.app.RemoteInput.addResultsToIntent(android.support.v4.app.RemoteInputCompatApi20.fromCompat(p1), p2, p3);
        return;
    }

    static android.app.RemoteInput[] fromCompat(android.support.v4.app.RemoteInputCompatBase$RemoteInput[] p5)
    {
        android.app.RemoteInput[] v1;
        if (p5 != null) {
            v1 = new android.app.RemoteInput[p5.length];
            int v0 = 0;
            while (v0 < p5.length) {
                android.support.v4.app.RemoteInputCompatBase$RemoteInput v2 = p5[v0];
                v1[v0] = new android.app.RemoteInput$Builder(v2.getResultKey()).setLabel(v2.getLabel()).setChoices(v2.getChoices()).setAllowFreeFormInput(v2.getAllowFreeFormInput()).addExtras(v2.getExtras()).build();
                v0++;
            }
        } else {
            v1 = 0;
        }
        return v1;
    }

    static android.os.Bundle getResultsFromIntent(android.content.Intent p1)
    {
        return android.app.RemoteInput.getResultsFromIntent(p1);
    }

    static android.support.v4.app.RemoteInputCompatBase$RemoteInput[] toCompat(android.app.RemoteInput[] p9, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p10)
    {
        android.support.v4.app.RemoteInputCompatBase$RemoteInput[] v7;
        if (p9 != null) {
            v7 = p10.newArray(p9.length);
            int v6 = 0;
            while (v6 < p9.length) {
                android.app.RemoteInput v8 = p9[v6];
                v7[v6] = p10.build(v8.getResultKey(), v8.getLabel(), v8.getChoices(), v8.getAllowFreeFormInput(), v8.getExtras());
                v6++;
            }
        } else {
            v7 = 0;
        }
        return v7;
    }
}
