package android.support.v4.widget;
final class SwipeProgressBar {
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = 3003121664;
    private static final int COLOR2 = 2147483648;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final android.view.animation.Interpolator INTERPOLATOR;
    private android.graphics.Rect mBounds;
    private final android.graphics.RectF mClipRect;
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final android.graphics.Paint mPaint;
    private android.view.View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;

    static SwipeProgressBar()
    {
        android.support.v4.widget.SwipeProgressBar.INTERPOLATOR = android.support.v4.widget.BakedBezierInterpolator.getInstance();
        return;
    }

    public SwipeProgressBar(android.view.View p2)
    {
        this.mPaint = new android.graphics.Paint();
        this.mClipRect = new android.graphics.RectF();
        this.mBounds = new android.graphics.Rect();
        this.mParent = p2;
        this.mColor1 = -1291845632;
        this.mColor2 = -2147483648;
        this.mColor3 = 1291845632;
        this.mColor4 = 436207616;
        return;
    }

    private void drawCircle(android.graphics.Canvas p4, float p5, float p6, int p7, float p8)
    {
        this.mPaint.setColor(p7);
        p4.save();
        p4.translate(p5, p6);
        p4.scale(android.support.v4.widget.SwipeProgressBar.INTERPOLATOR.getInterpolation(p8), android.support.v4.widget.SwipeProgressBar.INTERPOLATOR.getInterpolation(p8));
        p4.drawCircle(0, 0, p5, this.mPaint);
        p4.restore();
        return;
    }

    private void drawTrigger(android.graphics.Canvas p5, int p6, int p7)
    {
        this.mPaint.setColor(this.mColor1);
        p5.drawCircle(((float) p6), ((float) p7), (((float) p6) * this.mTriggerPercentage), this.mPaint);
        return;
    }

    void draw(android.graphics.Canvas p26)
    {
        int v24 = this.mBounds.width();
        int v17 = this.mBounds.height();
        int v9 = (v24 / 2);
        int v10 = (v17 / 2);
        int v11 = 0;
        int v23 = p26.save();
        p26.clipRect(this.mBounds);
        if ((!this.mRunning) && (this.mFinishTime <= 0)) {
            if ((this.mTriggerPercentage <= 0) || (((double) this.mTriggerPercentage) > 1.0)) {
                p26.restoreToCount(v23);
            } else {
                this.drawTrigger(p26, v9, v10);
            }
        } else {
            long v20 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            long v18 = ((v20 - this.mStartTime) / 2000);
            float v22 = (((float) ((v20 - this.mStartTime) % 2000)) / 1101004800);
            if (!this.mRunning) {
                if ((v20 - this.mFinishTime) < 1000) {
                    float v8 = (((float) (v24 / 2)) * android.support.v4.widget.SwipeProgressBar.INTERPOLATOR.getInterpolation(((((float) ((v20 - this.mFinishTime) % 1000)) / 1092616192) / 1120403456)));
                    this.mClipRect.set((((float) v9) - v8), 0, (((float) v9) + v8), ((float) v17));
                    p26.saveLayerAlpha(this.mClipRect, 0, 0);
                    v11 = 1;
                } else {
                    this.mFinishTime = 0;
                    return;
                }
            }
            if (v18 != 0) {
                if ((v22 < 0) || (v22 >= 1103626240)) {
                    if ((v22 < 1103626240) || (v22 >= 1112014848)) {
                        if ((v22 < 1112014848) || (v22 >= 1117126656)) {
                            p26.drawColor(this.mColor3);
                        } else {
                            p26.drawColor(this.mColor2);
                        }
                    } else {
                        p26.drawColor(this.mColor1);
                    }
                } else {
                    p26.drawColor(this.mColor4);
                }
            } else {
                p26.drawColor(this.mColor1);
            }
            if ((v22 >= 0) && (v22 <= 1103626240)) {
                this.drawCircle(p26, ((float) v9), ((float) v10), this.mColor1, (((1103626240 + v22) * 1073741824) / 1120403456));
            }
            if ((v22 >= 0) && (v22 <= 1112014848)) {
                this.drawCircle(p26, ((float) v9), ((float) v10), this.mColor2, ((1073741824 * v22) / 1120403456));
            }
            if ((v22 >= 1103626240) && (v22 <= 1117126656)) {
                this.drawCircle(p26, ((float) v9), ((float) v10), this.mColor3, (((v22 - 1103626240) * 1073741824) / 1120403456));
            }
            if ((v22 >= 1112014848) && (v22 <= 1120403456)) {
                this.drawCircle(p26, ((float) v9), ((float) v10), this.mColor4, (((v22 - 1112014848) * 1073741824) / 1120403456));
            }
            if ((v22 >= 1117126656) && (v22 <= 1120403456)) {
                this.drawCircle(p26, ((float) v9), ((float) v10), this.mColor1, (((v22 - 1117126656) * 1073741824) / 1120403456));
            }
            if ((this.mTriggerPercentage > 0) && (v11 != 0)) {
                p26.restoreToCount(v23);
                v23 = p26.save();
                p26.clipRect(this.mBounds);
                this.drawTrigger(p26, v9, v10);
            }
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this.mParent);
        }
        return;
    }

    boolean isRunning()
    {
        if ((!this.mRunning) && (this.mFinishTime <= 0)) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    void setBounds(int p2, int p3, int p4, int p5)
    {
        this.mBounds.left = p2;
        this.mBounds.top = p3;
        this.mBounds.right = p4;
        this.mBounds.bottom = p5;
        return;
    }

    void setColorScheme(int p1, int p2, int p3, int p4)
    {
        this.mColor1 = p1;
        this.mColor2 = p2;
        this.mColor3 = p3;
        this.mColor4 = p4;
        return;
    }

    void setTriggerPercentage(float p3)
    {
        this.mTriggerPercentage = p3;
        this.mStartTime = 0;
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this.mParent);
        return;
    }

    void start()
    {
        if (!this.mRunning) {
            this.mTriggerPercentage = 0;
            this.mStartTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = 1;
            this.mParent.postInvalidate();
        }
        return;
    }

    void stop()
    {
        if (this.mRunning) {
            this.mTriggerPercentage = 0;
            this.mFinishTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = 0;
            this.mParent.postInvalidate();
        }
        return;
    }
}
