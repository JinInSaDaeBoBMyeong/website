package org.webrtc;
public class MediaConstraints$KeyValuePair {
    private final String key;
    private final String value;

    public MediaConstraints$KeyValuePair(String p1, String p2)
    {
        this.key = p1;
        this.value = p2;
        return;
    }

    public boolean equals(Object p6)
    {
        int v1 = 1;
        if (this != p6) {
            if ((p6 != null) && (this.getClass() == p6.getClass())) {
                if ((!this.key.equals(((org.webrtc.MediaConstraints$KeyValuePair) p6).key)) || (!this.value.equals(((org.webrtc.MediaConstraints$KeyValuePair) p6).value))) {
                    v1 = 0;
                }
            } else {
                v1 = 0;
            }
        }
        return v1;
    }

    public String getKey()
    {
        return this.key;
    }

    public String getValue()
    {
        return this.value;
    }

    public int hashCode()
    {
        return (this.key.hashCode() + this.value.hashCode());
    }

    public String toString()
    {
        return new StringBuilder().append(this.key).append(": ").append(this.value).toString();
    }
}
