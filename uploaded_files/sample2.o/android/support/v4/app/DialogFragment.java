package android.support.v4.app;
public class DialogFragment extends android.support.v4.app.Fragment implements android.content.DialogInterface$OnCancelListener, android.content.DialogInterface$OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    int mBackStackId;
    boolean mCancelable;
    android.app.Dialog mDialog;
    boolean mDismissed;
    boolean mShownByMe;
    boolean mShowsDialog;
    int mStyle;
    int mTheme;
    boolean mViewDestroyed;

    public DialogFragment()
    {
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = 1;
        this.mShowsDialog = 1;
        this.mBackStackId = -1;
        return;
    }

    public void dismiss()
    {
        this.dismissInternal(0);
        return;
    }

    public void dismissAllowingStateLoss()
    {
        this.dismissInternal(1);
        return;
    }

    void dismissInternal(boolean p5)
    {
        if (!this.mDismissed) {
            this.mDismissed = 1;
            this.mShownByMe = 0;
            if (this.mDialog != null) {
                this.mDialog.dismiss();
                this.mDialog = 0;
            }
            this.mViewDestroyed = 1;
            if (this.mBackStackId < 0) {
                android.support.v4.app.FragmentTransaction v0 = this.getFragmentManager().beginTransaction();
                v0.remove(this);
                if (!p5) {
                    v0.commit();
                } else {
                    v0.commitAllowingStateLoss();
                }
            } else {
                this.getFragmentManager().popBackStack(this.mBackStackId, 1);
                this.mBackStackId = -1;
            }
        }
        return;
    }

    public android.app.Dialog getDialog()
    {
        return this.mDialog;
    }

    public android.view.LayoutInflater getLayoutInflater(android.os.Bundle p3)
    {
        android.view.LayoutInflater v0_5;
        if (this.mShowsDialog) {
            this.mDialog = this.onCreateDialog(p3);
            switch (this.mStyle) {
                case 1:
                case 2:
                    this.mDialog.requestWindowFeature(1);
                    break;
                case 3:
                    this.mDialog.getWindow().addFlags(24);
                    break;
            }
            if (this.mDialog == null) {
                v0_5 = ((android.view.LayoutInflater) this.mActivity.getSystemService("layout_inflater"));
            } else {
                v0_5 = ((android.view.LayoutInflater) this.mDialog.getContext().getSystemService("layout_inflater"));
            }
        } else {
            v0_5 = super.getLayoutInflater(p3);
        }
        return v0_5;
    }

    public boolean getShowsDialog()
    {
        return this.mShowsDialog;
    }

    public int getTheme()
    {
        return this.mTheme;
    }

    public boolean isCancelable()
    {
        return this.mCancelable;
    }

    public void onActivityCreated(android.os.Bundle p5)
    {
        super.onActivityCreated(p5);
        if (this.mShowsDialog) {
            android.view.View v1 = this.getView();
            if (v1 != null) {
                if (v1.getParent() == null) {
                    this.mDialog.setContentView(v1);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            this.mDialog.setOwnerActivity(this.getActivity());
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnCancelListener(this);
            this.mDialog.setOnDismissListener(this);
            if (p5 != null) {
                android.os.Bundle v0 = p5.getBundle("android:savedDialogState");
                if (v0 != null) {
                    this.mDialog.onRestoreInstanceState(v0);
                }
            }
        }
        return;
    }

    public void onAttach(android.app.Activity p2)
    {
        super.onAttach(p2);
        if (!this.mShownByMe) {
            this.mDismissed = 0;
        }
        return;
    }

    public void onCancel(android.content.DialogInterface p1)
    {
        return;
    }

    public void onCreate(android.os.Bundle p4)
    {
        int v0_10;
        super.onCreate(p4);
        if (this.mContainerId != 0) {
            v0_10 = 0;
        } else {
            v0_10 = 1;
        }
        this.mShowsDialog = v0_10;
        if (p4 != null) {
            this.mStyle = p4.getInt("android:style", 0);
            this.mTheme = p4.getInt("android:theme", 0);
            this.mCancelable = p4.getBoolean("android:cancelable", 1);
            this.mShowsDialog = p4.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = p4.getInt("android:backStackId", -1);
        }
        return;
    }

    public android.app.Dialog onCreateDialog(android.os.Bundle p4)
    {
        return new android.app.Dialog(this.getActivity(), this.getTheme());
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (this.mDialog != null) {
            this.mViewDestroyed = 1;
            this.mDialog.dismiss();
            this.mDialog = 0;
        }
        return;
    }

    public void onDetach()
    {
        super.onDetach();
        if ((!this.mShownByMe) && (!this.mDismissed)) {
            this.mDismissed = 1;
        }
        return;
    }

    public void onDismiss(android.content.DialogInterface p2)
    {
        if (!this.mViewDestroyed) {
            this.dismissInternal(1);
        }
        return;
    }

    public void onSaveInstanceState(android.os.Bundle p4)
    {
        super.onSaveInstanceState(p4);
        if (this.mDialog != null) {
            android.os.Bundle v0 = this.mDialog.onSaveInstanceState();
            if (v0 != null) {
                p4.putBundle("android:savedDialogState", v0);
            }
        }
        if (this.mStyle != 0) {
            p4.putInt("android:style", this.mStyle);
        }
        if (this.mTheme != 0) {
            p4.putInt("android:theme", this.mTheme);
        }
        if (!this.mCancelable) {
            p4.putBoolean("android:cancelable", this.mCancelable);
        }
        if (!this.mShowsDialog) {
            p4.putBoolean("android:showsDialog", this.mShowsDialog);
        }
        if (this.mBackStackId != -1) {
            p4.putInt("android:backStackId", this.mBackStackId);
        }
        return;
    }

    public void onStart()
    {
        super.onStart();
        if (this.mDialog != null) {
            this.mViewDestroyed = 0;
            this.mDialog.show();
        }
        return;
    }

    public void onStop()
    {
        super.onStop();
        if (this.mDialog != null) {
            this.mDialog.hide();
        }
        return;
    }

    public void setCancelable(boolean p2)
    {
        this.mCancelable = p2;
        if (this.mDialog != null) {
            this.mDialog.setCancelable(p2);
        }
        return;
    }

    public void setShowsDialog(boolean p1)
    {
        this.mShowsDialog = p1;
        return;
    }

    public void setStyle(int p3, int p4)
    {
        this.mStyle = p3;
        if ((this.mStyle == 2) || (this.mStyle == 3)) {
            this.mTheme = 16973913;
        }
        if (p4 != 0) {
            this.mTheme = p4;
        }
        return;
    }

    public int show(android.support.v4.app.FragmentTransaction p3, String p4)
    {
        this.mDismissed = 0;
        this.mShownByMe = 1;
        p3.add(this, p4);
        this.mViewDestroyed = 0;
        this.mBackStackId = p3.commit();
        return this.mBackStackId;
    }

    public void show(android.support.v4.app.FragmentManager p3, String p4)
    {
        this.mDismissed = 0;
        this.mShownByMe = 1;
        android.support.v4.app.FragmentTransaction v0 = p3.beginTransaction();
        v0.add(this, p4);
        v0.commit();
        return;
    }
}
