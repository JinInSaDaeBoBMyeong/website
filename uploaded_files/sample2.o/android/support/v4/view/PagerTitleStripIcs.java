package android.support.v4.view;
 class PagerTitleStripIcs {

    PagerTitleStripIcs()
    {
        return;
    }

    public static void setSingleLineAllCaps(android.widget.TextView p2)
    {
        p2.setTransformationMethod(new android.support.v4.view.PagerTitleStripIcs$SingleLineAllCapsTransform(p2.getContext()));
        return;
    }
}
