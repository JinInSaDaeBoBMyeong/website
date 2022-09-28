package android.support.v4.widget;
 class AutoScrollHelper$ClampedScroller {
    private long mDeltaTime;
    private int mDeltaX;
    private int mDeltaY;
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private long mStartTime;
    private long mStopTime;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;

    public AutoScrollHelper$ClampedScroller()
    {
        this.mStartTime = -0.0;
        this.mStopTime = -1;
        this.mDeltaTime = 0;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
        return;
    }

    private float getValueAt(long p12)
    {
        float v4_0 = 0;
        if (p12 >= this.mStartTime) {
            if ((this.mStopTime >= 0) && (p12 >= this.mStopTime)) {
                v4_0 = ((android.support.v4.widget.AutoScrollHelper.access$900((((float) (p12 - this.mStopTime)) / ((float) this.mEffectiveRampDown)), 0, 1065353216) * this.mStopValue) + (1065353216 - this.mStopValue));
            } else {
                v4_0 = (android.support.v4.widget.AutoScrollHelper.access$900((((float) (p12 - this.mStartTime)) / ((float) this.mRampUpDuration)), 0, 1065353216) * 1056964608);
            }
        }
        return v4_0;
    }

    private float interpolateValue(float p3)
    {
        return (((-1065353216 * p3) * p3) + (1082130432 * p3));
    }

    public void computeScrollDelta()
    {
        if (this.mDeltaTime != 0) {
            long v0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            float v4 = this.interpolateValue(this.getValueAt(v0));
            long v2 = (v0 - this.mDeltaTime);
            this.mDeltaTime = v0;
            this.mDeltaX = ((int) ((((float) v2) * v4) * this.mTargetVelocityX));
            this.mDeltaY = ((int) ((((float) v2) * v4) * this.mTargetVelocityY));
            return;
        } else {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
    }

    public int getDeltaX()
    {
        return this.mDeltaX;
    }

    public int getDeltaY()
    {
        return this.mDeltaY;
    }

    public int getHorizontalDirection()
    {
        return ((int) (this.mTargetVelocityX / Math.abs(this.mTargetVelocityX)));
    }

    public int getVerticalDirection()
    {
        return ((int) (this.mTargetVelocityY / Math.abs(this.mTargetVelocityY)));
    }

    public boolean isFinished()
    {
        if ((this.mStopTime <= 0) || (android.view.animation.AnimationUtils.currentAnimationTimeMillis() <= (this.mStopTime + ((long) this.mEffectiveRampDown)))) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public void requestStop()
    {
        long v0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        this.mEffectiveRampDown = android.support.v4.widget.AutoScrollHelper.access$800(((int) (v0 - this.mStartTime)), 0, this.mRampDownDuration);
        this.mStopValue = this.getValueAt(v0);
        this.mStopTime = v0;
        return;
    }

    public void setRampDownDuration(int p1)
    {
        this.mRampDownDuration = p1;
        return;
    }

    public void setRampUpDuration(int p1)
    {
        this.mRampUpDuration = p1;
        return;
    }

    public void setTargetVelocity(float p1, float p2)
    {
        this.mTargetVelocityX = p1;
        this.mTargetVelocityY = p2;
        return;
    }

    public void start()
    {
        this.mStartTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        this.mStopTime = -1;
        this.mDeltaTime = this.mStartTime;
        this.mStopValue = 1056964608;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
        return;
    }
}
