package org.webrtc;
final class CameraEnumerationAndroid$2 extends org.webrtc.CameraEnumerationAndroid$ClosestComparator {
    final synthetic int val$requestedHeight;
    final synthetic int val$requestedWidth;

    CameraEnumerationAndroid$2(int p2, int p3)
    {
        this.val$requestedWidth = p2;
        this.val$requestedHeight = p3;
        super(0);
        return;
    }

    bridge synthetic int diff(Object p2)
    {
        return this.diff(((org.webrtc.Size) p2));
    }

    int diff(org.webrtc.Size p4)
    {
        return (Math.abs((this.val$requestedWidth - p4.width)) + Math.abs((this.val$requestedHeight - p4.height)));
    }
}
