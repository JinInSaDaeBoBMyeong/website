package android.support.v4.app;
final class BackStackState implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final int mTransition;
    final int mTransitionStyle;

    static BackStackState()
    {
        android.support.v4.app.BackStackState.CREATOR = new android.support.v4.app.BackStackState$1();
        return;
    }

    public BackStackState(android.os.Parcel p2)
    {
        this.mOps = p2.createIntArray();
        this.mTransition = p2.readInt();
        this.mTransitionStyle = p2.readInt();
        this.mName = p2.readString();
        this.mIndex = p2.readInt();
        this.mBreadCrumbTitleRes = p2.readInt();
        this.mBreadCrumbTitleText = ((CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(p2));
        this.mBreadCrumbShortTitleRes = p2.readInt();
        this.mBreadCrumbShortTitleText = ((CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(p2));
        return;
    }

    public BackStackState(android.support.v4.app.FragmentManagerImpl p9, android.support.v4.app.BackStackRecord p10)
    {
        int v2 = 0;
        android.support.v4.app.BackStackRecord$Op v3_1 = p10.mHead;
        while (v3_1 != null) {
            if (v3_1.removed != null) {
                v2 += v3_1.removed.size();
            }
            v3_1 = v3_1.next;
        }
        int v6_23 = new int[((p10.mNumOp * 7) + v2)];
        this.mOps = v6_23;
        if (p10.mAddToBackStack) {
            android.support.v4.app.BackStackRecord$Op v3_0 = p10.mHead;
            int v5_0 = 0;
            while (v3_0 != null) {
                int v6_11;
                int v4_1 = (v5_0 + 1);
                this.mOps[v5_0] = v3_0.cmd;
                int v5_1 = (v4_1 + 1);
                if (v3_0.fragment == null) {
                    v6_11 = -1;
                } else {
                    v6_11 = v3_0.fragment.mIndex;
                }
                int v4_4;
                this.mOps[v4_1] = v6_11;
                int v4_2 = (v5_1 + 1);
                this.mOps[v5_1] = v3_0.enterAnim;
                int v5_2 = (v4_2 + 1);
                this.mOps[v4_2] = v3_0.exitAnim;
                int v4_3 = (v5_2 + 1);
                this.mOps[v5_2] = v3_0.popEnterAnim;
                int v5_3 = (v4_3 + 1);
                this.mOps[v4_3] = v3_0.popExitAnim;
                if (v3_0.removed == null) {
                    v4_4 = (v5_3 + 1);
                    this.mOps[v5_3] = 0;
                } else {
                    int v0 = v3_0.removed.size();
                    int v4_5 = (v5_3 + 1);
                    this.mOps[v5_3] = v0;
                    int v1 = 0;
                    int v5_4 = v4_5;
                    while (v1 < v0) {
                        int v4_6 = (v5_4 + 1);
                        this.mOps[v5_4] = ((android.support.v4.app.Fragment) v3_0.removed.get(v1)).mIndex;
                        v1++;
                        v5_4 = v4_6;
                    }
                    v4_4 = v5_4;
                }
                v3_0 = v3_0.next;
                v5_0 = v4_4;
            }
            this.mTransition = p10.mTransition;
            this.mTransitionStyle = p10.mTransitionStyle;
            this.mName = p10.mName;
            this.mIndex = p10.mIndex;
            this.mBreadCrumbTitleRes = p10.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = p10.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = p10.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = p10.mBreadCrumbShortTitleText;
            return;
        } else {
            throw new IllegalStateException("Not on back stack");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public android.support.v4.app.BackStackRecord instantiate(android.support.v4.app.FragmentManagerImpl p15)
    {
        android.support.v4.app.BackStackRecord v1_1 = new android.support.v4.app.BackStackRecord(p15);
        int v7_1 = 0;
        int v5 = 0;
        while (v7_1 < this.mOps.length) {
            android.support.v4.app.BackStackRecord$Op v6_1 = new android.support.v4.app.BackStackRecord$Op();
            int v8_1 = (v7_1 + 1);
            v6_1.cmd = this.mOps[v7_1];
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Instantiate ").append(v1_1).append(" op #").append(v5).append(" base fragment #").append(this.mOps[v8_1]).toString());
            }
            int v7_2 = (v8_1 + 1);
            int v3 = this.mOps[v8_1];
            if (v3 < 0) {
                v6_1.fragment = 0;
            } else {
                v6_1.fragment = ((android.support.v4.app.Fragment) p15.mActive.get(v3));
            }
            int v8_2 = (v7_2 + 1);
            v6_1.enterAnim = this.mOps[v7_2];
            int v7_3 = (v8_2 + 1);
            v6_1.exitAnim = this.mOps[v8_2];
            int v8_3 = (v7_3 + 1);
            v6_1.popEnterAnim = this.mOps[v7_3];
            int v7_4 = (v8_3 + 1);
            v6_1.popExitAnim = this.mOps[v8_3];
            int v8_0 = (v7_4 + 1);
            int v0 = this.mOps[v7_4];
            if (v0 > 0) {
                v6_1.removed = new java.util.ArrayList(v0);
                int v4 = 0;
                while (v4 < v0) {
                    if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                        android.util.Log.v("FragmentManager", new StringBuilder().append("Instantiate ").append(v1_1).append(" set remove fragment #").append(this.mOps[v8_0]).toString());
                    }
                    int v7_0 = (v8_0 + 1);
                    v6_1.removed.add(((android.support.v4.app.Fragment) p15.mActive.get(this.mOps[v8_0])));
                    v4++;
                    v8_0 = v7_0;
                }
            }
            v7_1 = v8_0;
            v1_1.addOp(v6_1);
            v5++;
        }
        v1_1.mTransition = this.mTransition;
        v1_1.mTransitionStyle = this.mTransitionStyle;
        v1_1.mName = this.mName;
        v1_1.mIndex = this.mIndex;
        v1_1.mAddToBackStack = 1;
        v1_1.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        v1_1.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        v1_1.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        v1_1.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        v1_1.bumpBackStackNesting(1);
        return v1_1;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeIntArray(this.mOps);
        p3.writeInt(this.mTransition);
        p3.writeInt(this.mTransitionStyle);
        p3.writeString(this.mName);
        p3.writeInt(this.mIndex);
        p3.writeInt(this.mBreadCrumbTitleRes);
        android.text.TextUtils.writeToParcel(this.mBreadCrumbTitleText, p3, 0);
        p3.writeInt(this.mBreadCrumbShortTitleRes);
        android.text.TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, p3, 0);
        return;
    }
}
