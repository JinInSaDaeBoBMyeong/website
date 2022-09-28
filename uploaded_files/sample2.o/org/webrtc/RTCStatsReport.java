package org.webrtc;
public class RTCStatsReport {
    private final java.util.Map stats;
    private final long timestampUs;

    public RTCStatsReport(long p2, java.util.Map p4)
    {
        this.timestampUs = p2;
        this.stats = p4;
        return;
    }

    public java.util.Map getStatsMap()
    {
        return this.stats;
    }

    public double getTimestampUs()
    {
        return ((double) this.timestampUs);
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("{ timestampUs: ").append(this.timestampUs).append(", stats: [\n");
        int v1 = 1;
        String v3_2 = this.stats.values().iterator();
        while (v3_2.hasNext()) {
            org.webrtc.RTCStats v2_1 = ((org.webrtc.RTCStats) v3_2.next());
            if (v1 == 0) {
                v0_1.append(",\n");
            }
            v0_1.append(v2_1);
            v1 = 0;
        }
        v0_1.append(" ] }");
        return v0_1.toString();
    }
}
