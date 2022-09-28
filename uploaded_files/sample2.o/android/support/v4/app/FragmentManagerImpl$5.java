package android.support.v4.app;
 class FragmentManagerImpl$5 implements android.view.animation.Animation$AnimationListener {
    final synthetic android.support.v4.app.FragmentManagerImpl this$0;
    final synthetic android.support.v4.app.Fragment val$fragment;

    FragmentManagerImpl$5(android.support.v4.app.FragmentManagerImpl p1, android.support.v4.app.Fragment p2)
    {
        this.this$0 = p1;
        this.val$fragment = p2;
        return;
    }

    public void onAnimationEnd(android.view.animation.Animation p7)
    {
        if (this.val$fragment.mAnimatingAway != null) {
            this.val$fragment.mAnimatingAway = 0;
            this.this$0.moveToState(this.val$fragment, this.val$fragment.mStateAfterAnimating, 0, 0, 0);
        }
        return;
    }

    public void onAnimationRepeat(android.view.animation.Animation p1)
    {
        return;
    }

    public void onAnimationStart(android.view.animation.Animation p1)
    {
        return;
    }
}
