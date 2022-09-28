package android.support.v4.view;
final class ViewPropertyAnimatorCompatICS$1 extends android.animation.AnimatorListenerAdapter {
    final synthetic android.support.v4.view.ViewPropertyAnimatorListener val$listener;
    final synthetic android.view.View val$view;

    ViewPropertyAnimatorCompatICS$1(android.support.v4.view.ViewPropertyAnimatorListener p1, android.view.View p2)
    {
        this.val$listener = p1;
        this.val$view = p2;
        return;
    }

    public void onAnimationCancel(android.animation.Animator p3)
    {
        this.val$listener.onAnimationCancel(this.val$view);
        return;
    }

    public void onAnimationEnd(android.animation.Animator p3)
    {
        this.val$listener.onAnimationEnd(this.val$view);
        return;
    }

    public void onAnimationStart(android.animation.Animator p3)
    {
        this.val$listener.onAnimationStart(this.val$view);
        return;
    }
}
