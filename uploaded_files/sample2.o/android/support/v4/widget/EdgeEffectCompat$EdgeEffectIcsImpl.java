package android.support.v4.widget;
 class EdgeEffectCompat$EdgeEffectIcsImpl implements android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl {

    EdgeEffectCompat$EdgeEffectIcsImpl()
    {
        return;
    }

    public boolean draw(Object p2, android.graphics.Canvas p3)
    {
        return android.support.v4.widget.EdgeEffectCompatIcs.draw(p2, p3);
    }

    public void finish(Object p1)
    {
        android.support.v4.widget.EdgeEffectCompatIcs.finish(p1);
        return;
    }

    public boolean isFinished(Object p2)
    {
        return android.support.v4.widget.EdgeEffectCompatIcs.isFinished(p2);
    }

    public Object newEdgeEffect(android.content.Context p2)
    {
        return android.support.v4.widget.EdgeEffectCompatIcs.newEdgeEffect(p2);
    }

    public boolean onAbsorb(Object p2, int p3)
    {
        return android.support.v4.widget.EdgeEffectCompatIcs.onAbsorb(p2, p3);
    }

    public boolean onPull(Object p2, float p3)
    {
        return android.support.v4.widget.EdgeEffectCompatIcs.onPull(p2, p3);
    }

    public boolean onRelease(Object p2)
    {
        return android.support.v4.widget.EdgeEffectCompatIcs.onRelease(p2);
    }

    public void setSize(Object p1, int p2, int p3)
    {
        android.support.v4.widget.EdgeEffectCompatIcs.setSize(p1, p2, p3);
        return;
    }
}
