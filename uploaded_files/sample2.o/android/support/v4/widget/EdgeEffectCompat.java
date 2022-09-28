package android.support.v4.widget;
public class EdgeEffectCompat {
    private static final android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl IMPL;
    private Object mEdgeEffect;

    static EdgeEffectCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.widget.EdgeEffectCompat.IMPL = new android.support.v4.widget.EdgeEffectCompat$BaseEdgeEffectImpl();
        } else {
            android.support.v4.widget.EdgeEffectCompat.IMPL = new android.support.v4.widget.EdgeEffectCompat$EdgeEffectIcsImpl();
        }
        return;
    }

    public EdgeEffectCompat(android.content.Context p2)
    {
        this.mEdgeEffect = android.support.v4.widget.EdgeEffectCompat.IMPL.newEdgeEffect(p2);
        return;
    }

    public boolean draw(android.graphics.Canvas p3)
    {
        return android.support.v4.widget.EdgeEffectCompat.IMPL.draw(this.mEdgeEffect, p3);
    }

    public void finish()
    {
        android.support.v4.widget.EdgeEffectCompat.IMPL.finish(this.mEdgeEffect);
        return;
    }

    public boolean isFinished()
    {
        return android.support.v4.widget.EdgeEffectCompat.IMPL.isFinished(this.mEdgeEffect);
    }

    public boolean onAbsorb(int p3)
    {
        return android.support.v4.widget.EdgeEffectCompat.IMPL.onAbsorb(this.mEdgeEffect, p3);
    }

    public boolean onPull(float p3)
    {
        return android.support.v4.widget.EdgeEffectCompat.IMPL.onPull(this.mEdgeEffect, p3);
    }

    public boolean onRelease()
    {
        return android.support.v4.widget.EdgeEffectCompat.IMPL.onRelease(this.mEdgeEffect);
    }

    public void setSize(int p3, int p4)
    {
        android.support.v4.widget.EdgeEffectCompat.IMPL.setSize(this.mEdgeEffect, p3, p4);
        return;
    }
}
