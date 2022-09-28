package org.webrtc;
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final org.webrtc.StatsReport$Value[] values;

    public StatsReport(String p2, String p3, double p4, org.webrtc.StatsReport$Value[] p6)
    {
        this.id = p2;
        this.type = p3;
        this.timestamp = p4;
        this.values = p6;
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("id: ").append(this.id).append(", type: ").append(this.type).append(", timestamp: ").append(this.timestamp).append(", values: ");
        int v1 = 0;
        while (v1 < this.values.length) {
            v0_1.append(this.values[v1].toString()).append(", ");
            v1++;
        }
        return v0_1.toString();
    }
}
