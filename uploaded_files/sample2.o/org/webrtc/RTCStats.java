package org.webrtc;
public class RTCStats {
    private final String id;
    private final java.util.Map members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long p2, String p4, String p5, java.util.Map p6)
    {
        this.timestampUs = p2;
        this.type = p4;
        this.id = p5;
        this.members = p6;
        return;
    }

    private static void appendValue(StringBuilder p4, Object p5)
    {
        if (!(p5 instanceof Object[])) {
            if (!(p5 instanceof String)) {
                p4.append(p5);
            } else {
                p4.append(34).append(p5).append(34);
            }
        } else {
            p4.append(91);
            int v1 = 0;
            while (v1 < ((Object[]) ((Object[]) p5)).length) {
                if (v1 != 0) {
                    p4.append(", ");
                }
                org.webrtc.RTCStats.appendValue(p4, ((Object[]) ((Object[]) p5))[v1]);
                v1++;
            }
            p4.append(93);
        }
        return;
    }

    public String getId()
    {
        return this.id;
    }

    public java.util.Map getMembers()
    {
        return this.members;
    }

    public double getTimestampUs()
    {
        return ((double) this.timestampUs);
    }

    public String getType()
    {
        return this.type;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("{ timestampUs: ").append(this.timestampUs).append(", type: ").append(this.type).append(", id: ").append(this.id);
        java.util.Iterator v4_3 = this.members.entrySet().iterator();
        while (v4_3.hasNext()) {
            java.util.Map$Entry v1_1 = ((java.util.Map$Entry) v4_3.next());
            v0_1.append(", ").append(((String) v1_1.getKey())).append(": ");
            org.webrtc.RTCStats.appendValue(v0_1, v1_1.getValue());
        }
        v0_1.append(" }");
        return v0_1.toString();
    }
}
