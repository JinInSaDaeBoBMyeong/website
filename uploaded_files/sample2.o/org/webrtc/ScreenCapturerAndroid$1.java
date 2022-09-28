package org.webrtc;
 class ScreenCapturerAndroid$1 implements java.lang.Runnable {
    final synthetic org.webrtc.ScreenCapturerAndroid this$0;

    ScreenCapturerAndroid$1(org.webrtc.ScreenCapturerAndroid p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.ScreenCapturerAndroid.access$000(this.this$0).stopListening();
        org.webrtc.ScreenCapturerAndroid.access$100(this.this$0).onCapturerStopped();
        if (org.webrtc.ScreenCapturerAndroid.access$200(this.this$0) != null) {
            org.webrtc.ScreenCapturerAndroid.access$200(this.this$0).release();
            org.webrtc.ScreenCapturerAndroid.access$202(this.this$0, 0);
        }
        if (org.webrtc.ScreenCapturerAndroid.access$300(this.this$0) != null) {
            org.webrtc.ScreenCapturerAndroid.access$300(this.this$0).unregisterCallback(org.webrtc.ScreenCapturerAndroid.access$400(this.this$0));
            org.webrtc.ScreenCapturerAndroid.access$300(this.this$0).stop();
            org.webrtc.ScreenCapturerAndroid.access$302(this.this$0, 0);
        }
        return;
    }
}
