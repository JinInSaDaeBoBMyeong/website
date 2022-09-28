package org.webrtc;
public class MediaConstraints {
    public final java.util.List mandatory;
    public final java.util.List optional;

    public MediaConstraints()
    {
        this.mandatory = new java.util.LinkedList();
        this.optional = new java.util.LinkedList();
        return;
    }

    private static String stringifyKeyValuePairList(java.util.List p5)
    {
        StringBuilder v0_1 = new StringBuilder("[");
        String v2_3 = p5.iterator();
        while (v2_3.hasNext()) {
            org.webrtc.MediaConstraints$KeyValuePair v1_1 = ((org.webrtc.MediaConstraints$KeyValuePair) v2_3.next());
            if (v0_1.length() > 1) {
                v0_1.append(", ");
            }
            v0_1.append(v1_1.toString());
        }
        return v0_1.append("]").toString();
    }

    public String toString()
    {
        return new StringBuilder().append("mandatory: ").append(org.webrtc.MediaConstraints.stringifyKeyValuePairList(this.mandatory)).append(", optional: ").append(org.webrtc.MediaConstraints.stringifyKeyValuePairList(this.optional)).toString();
    }
}
