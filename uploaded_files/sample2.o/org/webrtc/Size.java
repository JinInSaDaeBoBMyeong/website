package org.webrtc;
public class Size {
    public int height;
    public int width;

    public Size(int p1, int p2)
    {
        this.width = p1;
        this.height = p2;
        return;
    }

    public boolean equals(Object p5)
    {
        int v1 = 0;
        if (((p5 instanceof org.webrtc.Size)) && ((this.width == ((org.webrtc.Size) p5).width) && (this.height == ((org.webrtc.Size) p5).height))) {
            v1 = 1;
        }
        return v1;
    }

    public int hashCode()
    {
        return (((65537 * this.width) + 1) + this.height);
    }

    public String toString()
    {
        return new StringBuilder().append(this.width).append("x").append(this.height).toString();
    }
}
