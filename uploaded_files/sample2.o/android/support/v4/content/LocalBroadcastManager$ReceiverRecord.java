package android.support.v4.content;
 class LocalBroadcastManager$ReceiverRecord {
    boolean broadcasting;
    final android.content.IntentFilter filter;
    final android.content.BroadcastReceiver receiver;

    LocalBroadcastManager$ReceiverRecord(android.content.IntentFilter p1, android.content.BroadcastReceiver p2)
    {
        this.filter = p1;
        this.receiver = p2;
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(128);
        v0_1.append("Receiver{");
        v0_1.append(this.receiver);
        v0_1.append(" filter=");
        v0_1.append(this.filter);
        v0_1.append("}");
        return v0_1.toString();
    }
}
