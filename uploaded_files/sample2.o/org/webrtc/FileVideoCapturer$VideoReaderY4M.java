package org.webrtc;
 class FileVideoCapturer$VideoReaderY4M implements org.webrtc.FileVideoCapturer$VideoReader {
    private static final String TAG = "VideoReaderY4M";
    private static final String Y4M_FRAME_DELIMETER = "FRAME";
    private final int frameHeight;
    private final int frameSize;
    private final int frameWidth;
    private final java.io.RandomAccessFile mediaFileStream;
    private final long videoStart;

    public FileVideoCapturer$VideoReaderY4M(String p14)
    {
        this.mediaFileStream = new java.io.RandomAccessFile(p14, "r");
        StringBuilder v0_1 = new StringBuilder();
        while(true) {
            char v1_0 = this.mediaFileStream.read();
            if (v1_0 != -1) {
                if (v1_0 == 10) {
                    break;
                }
                v0_1.append(((char) v1_0));
            } else {
                throw new RuntimeException(new StringBuilder().append("Found end of file before end of header for file: ").append(p14).toString());
            }
        }
        this.videoStart = this.mediaFileStream.getFilePointer();
        String[] v5 = v0_1.toString().split("[ ]");
        int v7 = 0;
        int v3 = 0;
        String v2 = "";
        int v10_2 = v5.length;
        String v8_0 = 0;
        while (v8_0 < v10_2) {
            String v6 = v5[v8_0];
            switch (v6.charAt(0)) {
                case 67:
                    v2 = v6.substring(1);
                    break;
                case 72:
                    v3 = Integer.parseInt(v6.substring(1));
                    break;
                case 87:
                    v7 = Integer.parseInt(v6.substring(1));
                    break;
            }
            v8_0++;
        }
        org.webrtc.Logging.d("VideoReaderY4M", new StringBuilder().append("Color space: ").append(v2).toString());
        if ((v2.equals("420")) || (v2.equals("420mpeg2"))) {
            if (((v7 % 2) != 1) && ((v3 % 2) != 1)) {
                this.frameWidth = v7;
                this.frameHeight = v3;
                this.frameSize = (((v7 * v3) * 3) / 2);
                org.webrtc.Logging.d("VideoReaderY4M", new StringBuilder().append("frame dim: (").append(v7).append(", ").append(v3).append(") frameSize: ").append(this.frameSize).toString());
                return;
            } else {
                throw new IllegalArgumentException("Does not support odd width or height");
            }
        } else {
            throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
        }
    }

    public void close()
    {
        try {
            this.mediaFileStream.close();
        } catch (java.io.IOException v0) {
            org.webrtc.Logging.e("VideoReaderY4M", "Problem closing file", v0);
        }
        return;
    }

    public int getFrameHeight()
    {
        return this.frameHeight;
    }

    public int getFrameWidth()
    {
        return this.frameWidth;
    }

    public byte[] getNextFrame()
    {
        byte[] v1 = new byte[this.frameSize];
        try {
            byte[] v2 = new byte[("FRAME".length() + 1)];
        } catch (java.io.IOException v0) {
            throw new RuntimeException(v0);
        }
        if (this.mediaFileStream.read(v2) < v2.length) {
            this.mediaFileStream.seek(this.videoStart);
            if (this.mediaFileStream.read(v2) < v2.length) {
                throw new RuntimeException("Error looping video");
            }
        }
        String v3_1 = new String(v2);
        if (v3_1.equals("FRAME\n")) {
            this.mediaFileStream.readFully(v1);
            byte[] v4 = new byte[this.frameSize];
            org.webrtc.FileVideoCapturer.nativeI420ToNV21(v1, this.frameWidth, this.frameHeight, v4);
            return v4;
        } else {
            throw new RuntimeException(new StringBuilder().append("Frames should be delimited by FRAME plus newline, found delimter was: \'").append(v3_1).append("\'").toString());
        }
    }
}
