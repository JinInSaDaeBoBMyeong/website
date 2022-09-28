package org.webrtc;
public class StatsReport$Value {
    public final String name;
    public final String value;

    public StatsReport$Value(String p1, String p2)
    {
        this.name = p1;
        this.value = p2;
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("[").append(this.name).append(": ").append(this.value).append("]");
        return v0_1.toString();
    }
}
