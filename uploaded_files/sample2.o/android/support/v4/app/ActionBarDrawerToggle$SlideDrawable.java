package android.support.v4.app;
 class ActionBarDrawerToggle$SlideDrawable extends android.graphics.drawable.InsetDrawable implements android.graphics.drawable.Drawable$Callback {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final android.graphics.Rect mTmpRect;
    final synthetic android.support.v4.app.ActionBarDrawerToggle this$0;

    private ActionBarDrawerToggle$SlideDrawable(android.support.v4.app.ActionBarDrawerToggle p4, android.graphics.drawable.Drawable p5)
    {
        android.graphics.Rect v0_0 = 0;
        this.this$0 = p4;
        super(p5, 0);
        if (android.os.Build$VERSION.SDK_INT > 18) {
            v0_0 = 1;
        }
        super.mHasMirroring = v0_0;
        super.mTmpRect = new android.graphics.Rect();
        return;
    }

    synthetic ActionBarDrawerToggle$SlideDrawable(android.support.v4.app.ActionBarDrawerToggle p1, android.graphics.drawable.Drawable p2, android.support.v4.app.ActionBarDrawerToggle$1 p3)
    {
        this(p1, p2);
        return;
    }

    public void draw(android.graphics.Canvas p7)
    {
        int v1;
        int v0 = 1;
        this.copyBounds(this.mTmpRect);
        p7.save();
        if (android.support.v4.view.ViewCompat.getLayoutDirection(android.support.v4.app.ActionBarDrawerToggle.access$400(this.this$0).getWindow().getDecorView()) != 1) {
            v1 = 0;
        } else {
            v1 = 1;
        }
        if (v1 != 0) {
            v0 = -1;
        }
        int v2 = this.mTmpRect.width();
        p7.translate(((((- this.mOffset) * ((float) v2)) * this.mPosition) * ((float) v0)), 0);
        if ((v1 != 0) && (!this.mHasMirroring)) {
            p7.translate(((float) v2), 0);
            p7.scale(-1082130432, 1065353216);
        }
        super.draw(p7);
        p7.restore();
        return;
    }

    public float getPosition()
    {
        return this.mPosition;
    }

    public void setOffset(float p1)
    {
        this.mOffset = p1;
        this.invalidateSelf();
        return;
    }

    public void setPosition(float p1)
    {
        this.mPosition = p1;
        this.invalidateSelf();
        return;
    }
}
