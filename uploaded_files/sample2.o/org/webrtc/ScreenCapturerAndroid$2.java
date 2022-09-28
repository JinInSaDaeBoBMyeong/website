package org.webrtc;
 class ScreenCapturerAndroid$2 implements java.lang.Runnable {
    final synthetic org.webrtc.ScreenCapturerAndroid this$0;

    ScreenCapturerAndroid$2(org.webrtc.ScreenCapturerAndroid p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.ScreenCapturerAndroid.access$200(this.this$0).release();
        org.webrtc.ScreenCapturerAndroid.access$500(this.this$0);
        return;
    }
}
