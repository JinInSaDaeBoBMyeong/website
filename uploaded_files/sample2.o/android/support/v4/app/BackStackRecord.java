package android.support.v4.app;
final class BackStackRecord extends android.support.v4.app.FragmentTransaction implements android.support.v4.app.FragmentManager$BackStackEntry, java.lang.Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    android.support.v4.app.BackStackRecord$Op mHead;
    int mIndex;
    final android.support.v4.app.FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    android.support.v4.app.BackStackRecord$Op mTail;
    int mTransition;
    int mTransitionStyle;

    public BackStackRecord(android.support.v4.app.FragmentManagerImpl p2)
    {
        this.mAllowAddToBackStack = 1;
        this.mIndex = -1;
        this.mManager = p2;
        return;
    }

    private void doAddOp(int p5, android.support.v4.app.Fragment p6, String p7, int p8)
    {
        p6.mFragmentManager = this.mManager;
        if (p7 != null) {
            if ((p6.mTag == null) || (p7.equals(p6.mTag))) {
                p6.mTag = p7;
            } else {
                throw new IllegalStateException(new StringBuilder().append("Can\'t change tag of fragment ").append(p6).append(": was ").append(p6.mTag).append(" now ").append(p7).toString());
            }
        }
        if (p5 != 0) {
            if ((p6.mFragmentId == 0) || (p6.mFragmentId == p5)) {
                p6.mFragmentId = p5;
                p6.mContainerId = p5;
            } else {
                throw new IllegalStateException(new StringBuilder().append("Can\'t change container ID of fragment ").append(p6).append(": was ").append(p6.mFragmentId).append(" now ").append(p5).toString());
            }
        }
        android.support.v4.app.BackStackRecord$Op v0_1 = new android.support.v4.app.BackStackRecord$Op();
        v0_1.cmd = p8;
        v0_1.fragment = p6;
        this.addOp(v0_1);
        return;
    }

    public android.support.v4.app.FragmentTransaction add(int p3, android.support.v4.app.Fragment p4)
    {
        this.doAddOp(p3, p4, 0, 1);
        return this;
    }

    public android.support.v4.app.FragmentTransaction add(int p2, android.support.v4.app.Fragment p3, String p4)
    {
        this.doAddOp(p2, p3, p4, 1);
        return this;
    }

    public android.support.v4.app.FragmentTransaction add(android.support.v4.app.Fragment p3, String p4)
    {
        this.doAddOp(0, p3, p4, 1);
        return this;
    }

    void addOp(android.support.v4.app.BackStackRecord$Op p2)
    {
        if (this.mHead != null) {
            p2.prev = this.mTail;
            this.mTail.next = p2;
            this.mTail = p2;
        } else {
            this.mTail = p2;
            this.mHead = p2;
        }
        p2.enterAnim = this.mEnterAnim;
        p2.exitAnim = this.mExitAnim;
        p2.popEnterAnim = this.mPopEnterAnim;
        p2.popExitAnim = this.mPopExitAnim;
        this.mNumOp = (this.mNumOp + 1);
        return;
    }

    public android.support.v4.app.FragmentTransaction addToBackStack(String p3)
    {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = 1;
            this.mName = p3;
            return this;
        } else {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
    }

    public android.support.v4.app.FragmentTransaction attach(android.support.v4.app.Fragment p3)
    {
        android.support.v4.app.BackStackRecord$Op v0_1 = new android.support.v4.app.BackStackRecord$Op();
        v0_1.cmd = 7;
        v0_1.fragment = p3;
        this.addOp(v0_1);
        return this;
    }

    void bumpBackStackNesting(int p7)
    {
        if (this.mAddToBackStack) {
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Bump nesting in ").append(this).append(" by ").append(p7).toString());
            }
            android.support.v4.app.BackStackRecord$Op v1 = this.mHead;
            while (v1 != null) {
                if (v1.fragment != null) {
                    String v3_3 = v1.fragment;
                    v3_3.mBackStackNesting = (v3_3.mBackStackNesting + p7);
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("Bump nesting of ").append(v1.fragment).append(" to ").append(v1.fragment.mBackStackNesting).toString());
                    }
                }
                if (v1.removed != null) {
                    int v0 = (v1.removed.size() - 1);
                    while (v0 >= 0) {
                        android.support.v4.app.Fragment v2_1 = ((android.support.v4.app.Fragment) v1.removed.get(v0));
                        v2_1.mBackStackNesting = (v2_1.mBackStackNesting + p7);
                        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                            android.util.Log.v("FragmentManager", new StringBuilder().append("Bump nesting of ").append(v2_1).append(" to ").append(v2_1.mBackStackNesting).toString());
                        }
                        v0--;
                    }
                }
                v1 = v1.next;
            }
        }
        return;
    }

    public int commit()
    {
        return this.commitInternal(0);
    }

    public int commitAllowingStateLoss()
    {
        return this.commitInternal(1);
    }

    int commitInternal(boolean p7)
    {
        if (!this.mCommitted) {
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Commit: ").append(this).toString());
                this.dump("  ", 0, new java.io.PrintWriter(new android.support.v4.util.LogWriter("FragmentManager")), 0);
            }
            this.mCommitted = 1;
            if (!this.mAddToBackStack) {
                this.mIndex = -1;
            } else {
                this.mIndex = this.mManager.allocBackStackIndex(this);
            }
            this.mManager.enqueueAction(this, p7);
            return this.mIndex;
        } else {
            throw new IllegalStateException("commit already called");
        }
    }

    public android.support.v4.app.FragmentTransaction detach(android.support.v4.app.Fragment p3)
    {
        android.support.v4.app.BackStackRecord$Op v0_1 = new android.support.v4.app.BackStackRecord$Op();
        v0_1.cmd = 6;
        v0_1.fragment = p3;
        this.addOp(v0_1);
        return this;
    }

    public android.support.v4.app.FragmentTransaction disallowAddToBackStack()
    {
        if (!this.mAddToBackStack) {
            this.mAllowAddToBackStack = 0;
            return this;
        } else {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
    }

    public void dump(String p2, java.io.FileDescriptor p3, java.io.PrintWriter p4, String[] p5)
    {
        this.dump(p2, p4, 1);
        return;
    }

    public void dump(String p8, java.io.PrintWriter p9, boolean p10)
    {
        if (p10) {
            p9.print(p8);
            p9.print("mName=");
            p9.print(this.mName);
            p9.print(" mIndex=");
            p9.print(this.mIndex);
            p9.print(" mCommitted=");
            p9.println(this.mCommitted);
            if (this.mTransition != 0) {
                p9.print(p8);
                p9.print("mTransition=#");
                p9.print(Integer.toHexString(this.mTransition));
                p9.print(" mTransitionStyle=#");
                p9.println(Integer.toHexString(this.mTransitionStyle));
            }
            if ((this.mEnterAnim != 0) || (this.mExitAnim != 0)) {
                p9.print(p8);
                p9.print("mEnterAnim=#");
                p9.print(Integer.toHexString(this.mEnterAnim));
                p9.print(" mExitAnim=#");
                p9.println(Integer.toHexString(this.mExitAnim));
            }
            if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0)) {
                p9.print(p8);
                p9.print("mPopEnterAnim=#");
                p9.print(Integer.toHexString(this.mPopEnterAnim));
                p9.print(" mPopExitAnim=#");
                p9.println(Integer.toHexString(this.mPopExitAnim));
            }
            if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null)) {
                p9.print(p8);
                p9.print("mBreadCrumbTitleRes=#");
                p9.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                p9.print(" mBreadCrumbTitleText=");
                p9.println(this.mBreadCrumbTitleText);
            }
            if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null)) {
                p9.print(p8);
                p9.print("mBreadCrumbShortTitleRes=#");
                p9.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                p9.print(" mBreadCrumbShortTitleText=");
                p9.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mHead != null) {
            p9.print(p8);
            p9.println("Operations:");
            String v2 = new StringBuilder().append(p8).append("    ").toString();
            android.support.v4.app.BackStackRecord$Op v4 = this.mHead;
            int v3 = 0;
            while (v4 != null) {
                String v0;
                switch (v4.cmd) {
                    case 0:
                        v0 = "NULL";
                        break;
                    case 1:
                        v0 = "ADD";
                        break;
                    case 2:
                        v0 = "REPLACE";
                        break;
                    case 3:
                        v0 = "REMOVE";
                        break;
                    case 4:
                        v0 = "HIDE";
                        break;
                    case 5:
                        v0 = "SHOW";
                        break;
                    case 6:
                        v0 = "DETACH";
                        break;
                    case 7:
                        v0 = "ATTACH";
                        break;
                    default:
                        v0 = new StringBuilder().append("cmd=").append(v4.cmd).toString();
                }
                p9.print(p8);
                p9.print("  Op #");
                p9.print(v3);
                p9.print(": ");
                p9.print(v0);
                p9.print(" ");
                p9.println(v4.fragment);
                if (p10) {
                    if ((v4.enterAnim != 0) || (v4.exitAnim != 0)) {
                        p9.print(p8);
                        p9.print("enterAnim=#");
                        p9.print(Integer.toHexString(v4.enterAnim));
                        p9.print(" exitAnim=#");
                        p9.println(Integer.toHexString(v4.exitAnim));
                    }
                    if ((v4.popEnterAnim != 0) || (v4.popExitAnim != 0)) {
                        p9.print(p8);
                        p9.print("popEnterAnim=#");
                        p9.print(Integer.toHexString(v4.popEnterAnim));
                        p9.print(" popExitAnim=#");
                        p9.println(Integer.toHexString(v4.popExitAnim));
                    }
                }
                if ((v4.removed != null) && (v4.removed.size() > 0)) {
                    int v1 = 0;
                    while (v1 < v4.removed.size()) {
                        p9.print(v2);
                        if (v4.removed.size() != 1) {
                            if (v1 == 0) {
                                p9.println("Removed:");
                            }
                            p9.print(v2);
                            p9.print("  #");
                            p9.print(v1);
                            p9.print(": ");
                        } else {
                            p9.print("Removed: ");
                        }
                        p9.println(v4.removed.get(v1));
                        v1++;
                    }
                }
                v4 = v4.next;
                v3++;
            }
        }
        return;
    }

    public CharSequence getBreadCrumbShortTitle()
    {
        CharSequence v0_1;
        if (this.mBreadCrumbShortTitleRes == 0) {
            v0_1 = this.mBreadCrumbShortTitleText;
        } else {
            v0_1 = this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes);
        }
        return v0_1;
    }

    public int getBreadCrumbShortTitleRes()
    {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle()
    {
        CharSequence v0_1;
        if (this.mBreadCrumbTitleRes == 0) {
            v0_1 = this.mBreadCrumbTitleText;
        } else {
            v0_1 = this.mManager.mActivity.getText(this.mBreadCrumbTitleRes);
        }
        return v0_1;
    }

    public int getBreadCrumbTitleRes()
    {
        return this.mBreadCrumbTitleRes;
    }

    public int getId()
    {
        return this.mIndex;
    }

    public String getName()
    {
        return this.mName;
    }

    public int getTransition()
    {
        return this.mTransition;
    }

    public int getTransitionStyle()
    {
        return this.mTransitionStyle;
    }

    public android.support.v4.app.FragmentTransaction hide(android.support.v4.app.Fragment p3)
    {
        android.support.v4.app.BackStackRecord$Op v0_1 = new android.support.v4.app.BackStackRecord$Op();
        v0_1.cmd = 4;
        v0_1.fragment = p3;
        this.addOp(v0_1);
        return this;
    }

    public boolean isAddToBackStackAllowed()
    {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty()
    {
        int v0_1;
        if (this.mNumOp != 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public void popFromBackStack(boolean p13)
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("popFromBackStack: ").append(this).toString());
            this.dump("  ", 0, new java.io.PrintWriter(new android.support.v4.util.LogWriter("FragmentManager")), 0);
        }
        this.bumpBackStackNesting(-1);
        android.support.v4.app.BackStackRecord$Op v4 = this.mTail;
        while (v4 != null) {
            switch (v4.cmd) {
                case 1:
                    android.support.v4.app.Fragment v0_0 = v4.fragment;
                    v0_0.mNextAnim = v4.popExitAnim;
                    this.mManager.removeFragment(v0_0, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 2:
                    android.support.v4.app.Fragment v0_6 = v4.fragment;
                    if (v0_6 != null) {
                        v0_6.mNextAnim = v4.popExitAnim;
                        this.mManager.removeFragment(v0_6, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    }
                    if (v4.removed == null) {
                    } else {
                        int v1 = 0;
                        while (v1 < v4.removed.size()) {
                            android.support.v4.app.Fragment v3_1 = ((android.support.v4.app.Fragment) v4.removed.get(v1));
                            v3_1.mNextAnim = v4.popEnterAnim;
                            this.mManager.addFragment(v3_1, 0);
                            v1++;
                        }
                    }
                    break;
                case 3:
                    android.support.v4.app.Fragment v0_5 = v4.fragment;
                    v0_5.mNextAnim = v4.popEnterAnim;
                    this.mManager.addFragment(v0_5, 0);
                    break;
                case 4:
                    android.support.v4.app.Fragment v0_4 = v4.fragment;
                    v0_4.mNextAnim = v4.popEnterAnim;
                    this.mManager.showFragment(v0_4, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 5:
                    android.support.v4.app.Fragment v0_3 = v4.fragment;
                    v0_3.mNextAnim = v4.popExitAnim;
                    this.mManager.hideFragment(v0_3, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 6:
                    android.support.v4.app.Fragment v0_2 = v4.fragment;
                    v0_2.mNextAnim = v4.popEnterAnim;
                    this.mManager.attachFragment(v0_2, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 7:
                    android.support.v4.app.Fragment v0_1 = v4.fragment;
                    v0_1.mNextAnim = v4.popEnterAnim;
                    this.mManager.detachFragment(v0_1, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException(new StringBuilder().append("Unknown cmd: ").append(v4.cmd).toString());
            }
            v4 = v4.prev;
        }
        if (p13) {
            this.mManager.moveToState(this.mManager.mCurState, android.support.v4.app.FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle, 1);
        }
        if (this.mIndex >= 0) {
            this.mManager.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
        return;
    }

    public android.support.v4.app.FragmentTransaction remove(android.support.v4.app.Fragment p3)
    {
        android.support.v4.app.BackStackRecord$Op v0_1 = new android.support.v4.app.BackStackRecord$Op();
        v0_1.cmd = 3;
        v0_1.fragment = p3;
        this.addOp(v0_1);
        return this;
    }

    public android.support.v4.app.FragmentTransaction replace(int p2, android.support.v4.app.Fragment p3)
    {
        return this.replace(p2, p3, 0);
    }

    public android.support.v4.app.FragmentTransaction replace(int p3, android.support.v4.app.Fragment p4, String p5)
    {
        if (p3 != 0) {
            this.doAddOp(p3, p4, p5, 2);
            return this;
        } else {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
    }

    public void run()
    {
        if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
            android.util.Log.v("FragmentManager", new StringBuilder().append("Run: ").append(this).toString());
        }
        if ((!this.mAddToBackStack) || (this.mIndex >= 0)) {
            this.bumpBackStackNesting(1);
            android.support.v4.app.BackStackRecord$Op v3 = this.mHead;
            while (v3 != null) {
                switch (v3.cmd) {
                    case 1:
                        int v0_1 = v3.fragment;
                        v0_1.mNextAnim = v3.enterAnim;
                        this.mManager.addFragment(v0_1, 0);
                        break;
                    case 2:
                        int v0_0 = v3.fragment;
                        if (this.mManager.mAdded != null) {
                            int v1 = 0;
                            while (v1 < this.mManager.mAdded.size()) {
                                android.support.v4.app.Fragment v2_1 = ((android.support.v4.app.Fragment) this.mManager.mAdded.get(v1));
                                if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                    android.util.Log.v("FragmentManager", new StringBuilder().append("OP_REPLACE: adding=").append(v0_0).append(" old=").append(v2_1).toString());
                                }
                                if ((v0_0 == 0) || (v2_1.mContainerId == v0_0.mContainerId)) {
                                    if (v2_1 != v0_0) {
                                        if (v3.removed == null) {
                                            v3.removed = new java.util.ArrayList();
                                        }
                                        v3.removed.add(v2_1);
                                        v2_1.mNextAnim = v3.exitAnim;
                                        if (this.mAddToBackStack) {
                                            v2_1.mBackStackNesting = (v2_1.mBackStackNesting + 1);
                                            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                                                android.util.Log.v("FragmentManager", new StringBuilder().append("Bump nesting of ").append(v2_1).append(" to ").append(v2_1.mBackStackNesting).toString());
                                            }
                                        }
                                        this.mManager.removeFragment(v2_1, this.mTransition, this.mTransitionStyle);
                                    } else {
                                        v0_0 = 0;
                                        v3.fragment = 0;
                                    }
                                }
                                v1++;
                            }
                        }
                        if (v0_0 == 0) {
                        } else {
                            v0_0.mNextAnim = v3.enterAnim;
                            this.mManager.addFragment(v0_0, 0);
                        }
                        break;
                    case 3:
                        int v0_6 = v3.fragment;
                        v0_6.mNextAnim = v3.exitAnim;
                        this.mManager.removeFragment(v0_6, this.mTransition, this.mTransitionStyle);
                        break;
                    case 4:
                        int v0_5 = v3.fragment;
                        v0_5.mNextAnim = v3.exitAnim;
                        this.mManager.hideFragment(v0_5, this.mTransition, this.mTransitionStyle);
                        break;
                    case 5:
                        int v0_4 = v3.fragment;
                        v0_4.mNextAnim = v3.enterAnim;
                        this.mManager.showFragment(v0_4, this.mTransition, this.mTransitionStyle);
                        break;
                    case 6:
                        int v0_3 = v3.fragment;
                        v0_3.mNextAnim = v3.exitAnim;
                        this.mManager.detachFragment(v0_3, this.mTransition, this.mTransitionStyle);
                        break;
                    case 7:
                        int v0_2 = v3.fragment;
                        v0_2.mNextAnim = v3.enterAnim;
                        this.mManager.attachFragment(v0_2, this.mTransition, this.mTransitionStyle);
                        break;
                    default:
                        throw new IllegalArgumentException(new StringBuilder().append("Unknown cmd: ").append(v3.cmd).toString());
                }
                v3 = v3.next;
            }
            this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, 1);
            if (this.mAddToBackStack) {
                this.mManager.addBackStackState(this);
            }
            return;
        } else {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
    }

    public android.support.v4.app.FragmentTransaction setBreadCrumbShortTitle(int p2)
    {
        this.mBreadCrumbShortTitleRes = p2;
        this.mBreadCrumbShortTitleText = 0;
        return this;
    }

    public android.support.v4.app.FragmentTransaction setBreadCrumbShortTitle(CharSequence p2)
    {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = p2;
        return this;
    }

    public android.support.v4.app.FragmentTransaction setBreadCrumbTitle(int p2)
    {
        this.mBreadCrumbTitleRes = p2;
        this.mBreadCrumbTitleText = 0;
        return this;
    }

    public android.support.v4.app.FragmentTransaction setBreadCrumbTitle(CharSequence p2)
    {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = p2;
        return this;
    }

    public android.support.v4.app.FragmentTransaction setCustomAnimations(int p2, int p3)
    {
        return this.setCustomAnimations(p2, p3, 0, 0);
    }

    public android.support.v4.app.FragmentTransaction setCustomAnimations(int p1, int p2, int p3, int p4)
    {
        this.mEnterAnim = p1;
        this.mExitAnim = p2;
        this.mPopEnterAnim = p3;
        this.mPopExitAnim = p4;
        return this;
    }

    public android.support.v4.app.FragmentTransaction setTransition(int p1)
    {
        this.mTransition = p1;
        return this;
    }

    public android.support.v4.app.FragmentTransaction setTransitionStyle(int p1)
    {
        this.mTransitionStyle = p1;
        return this;
    }

    public android.support.v4.app.FragmentTransaction show(android.support.v4.app.Fragment p3)
    {
        android.support.v4.app.BackStackRecord$Op v0_1 = new android.support.v4.app.BackStackRecord$Op();
        v0_1.cmd = 5;
        v0_1.fragment = p3;
        this.addOp(v0_1);
        return this;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(128);
        v0_1.append("BackStackEntry{");
        v0_1.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            v0_1.append(" #");
            v0_1.append(this.mIndex);
        }
        if (this.mName != null) {
            v0_1.append(" ");
            v0_1.append(this.mName);
        }
        v0_1.append("}");
        return v0_1.toString();
    }
}
