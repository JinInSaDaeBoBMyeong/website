package android.support.v4.view;
public class ViewPropertyAnimatorCompat {
    static final android.support.v4.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl IMPL = None;
    private static final String TAG = "ViewAnimatorCompat";
    private ref.WeakReference mView;

    static ViewPropertyAnimatorCompat()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 18) {
            if (v0 < 16) {
                if (v0 < 14) {
                    android.support.v4.view.ViewPropertyAnimatorCompat.IMPL = new android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl();
                } else {
                    android.support.v4.view.ViewPropertyAnimatorCompat.IMPL = new android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl();
                }
            } else {
                android.support.v4.view.ViewPropertyAnimatorCompat.IMPL = new android.support.v4.view.ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl();
            }
        } else {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL = new android.support.v4.view.ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl();
        }
        return;
    }

    ViewPropertyAnimatorCompat(android.view.View p2)
    {
        this.mView = new ref.WeakReference(p2);
        return;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat alpha(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.alpha(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat alphaBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.alphaBy(v0_1, p3);
        }
        return this;
    }

    public void cancel()
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.cancel(v0_1);
        }
        return;
    }

    public long getDuration()
    {
        long v2;
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 == null) {
            v2 = 0;
        } else {
            v2 = android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.getDuration(v0_1);
        }
        return v2;
    }

    public android.view.animation.Interpolator getInterpolator()
    {
        int v1_1;
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 == null) {
            v1_1 = 0;
        } else {
            v1_1 = android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.getInterpolator(v0_1);
        }
        return v1_1;
    }

    public long getStartDelay()
    {
        long v2;
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 == null) {
            v2 = 0;
        } else {
            v2 = android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.getStartDelay(v0_1);
        }
        return v2;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat rotation(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.rotation(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat rotationBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.rotationBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat rotationX(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.rotationX(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat rotationXBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.rotationXBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat rotationY(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.rotationY(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat rotationYBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.rotationYBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat scaleX(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.scaleX(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat scaleXBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.scaleXBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat scaleY(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.scaleY(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat scaleYBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.scaleYBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat setDuration(long p4)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.setDuration(v0_1, p4);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat setInterpolator(android.view.animation.Interpolator p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.setInterpolator(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat setListener(android.support.v4.view.ViewPropertyAnimatorListener p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.setListener(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat setStartDelay(long p4)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.setStartDelay(v0_1, p4);
        }
        return this;
    }

    public void start()
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.start(v0_1);
        }
        return;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat translationX(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.translationX(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat translationXBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.translationXBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat translationY(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.translationY(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat translationYBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.translationYBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat withEndAction(Runnable p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.withEndAction(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat withLayer()
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.withLayer(v0_1);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat withStartAction(Runnable p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.withStartAction(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat x(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.x(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat xBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.xBy(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat y(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.y(v0_1, p3);
        }
        return this;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat yBy(float p3)
    {
        android.view.View v0_1 = ((android.view.View) this.mView.get());
        if (v0_1 != null) {
            android.support.v4.view.ViewPropertyAnimatorCompat.IMPL.yBy(v0_1, p3);
        }
        return this;
    }
}
