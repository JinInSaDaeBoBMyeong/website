package org.webrtc;
public class VideoEncoder$BitrateAllocation {
    public final int[][] bitratesBbs;

    public VideoEncoder$BitrateAllocation(int[][] p1)
    {
        this.bitratesBbs = p1;
        return;
    }

    public int getSum()
    {
        int v2 = 0;
        int[][] v6 = this.bitratesBbs;
        int v5 = 0;
        while (v5 < v6.length) {
            int[] v1 = v6[v5];
            int v3_1 = 0;
            while (v3_1 < v1.length) {
                v2 += v1[v3_1];
                v3_1++;
            }
            v5++;
        }
        return v2;
    }
}
