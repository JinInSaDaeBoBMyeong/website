package org.webrtc;
abstract class CameraEnumerationAndroid$ClosestComparator implements java.util.Comparator {

    private CameraEnumerationAndroid$ClosestComparator()
    {
        return;
    }

    synthetic CameraEnumerationAndroid$ClosestComparator(org.webrtc.CameraEnumerationAndroid$1 p1)
    {
        return;
    }

    public int compare(Object p3, Object p4)
    {
        return (this.diff(p3) - this.diff(p4));
    }

    abstract int diff();
}
