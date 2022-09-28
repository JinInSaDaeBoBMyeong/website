package android.support.v4.app;
final class FragmentState implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    final android.os.Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final int mIndex;
    android.support.v4.app.Fragment mInstance;
    final boolean mRetainInstance;
    android.os.Bundle mSavedFragmentState;
    final String mTag;

    static FragmentState()
    {
        android.support.v4.app.FragmentState.CREATOR = new android.support.v4.app.FragmentState$1();
        return;
    }

    public FragmentState(android.os.Parcel p4)
    {
        android.os.Bundle v0_1;
        int v1 = 1;
        this.mClassName = p4.readString();
        this.mIndex = p4.readInt();
        if (p4.readInt() == 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        android.os.Bundle v0_6;
        this.mFromLayout = v0_1;
        this.mFragmentId = p4.readInt();
        this.mContainerId = p4.readInt();
        this.mTag = p4.readString();
        if (p4.readInt() == 0) {
            v0_6 = 0;
        } else {
            v0_6 = 1;
        }
        this.mRetainInstance = v0_6;
        if (p4.readInt() == 0) {
            v1 = 0;
        }
        this.mDetached = v1;
        this.mArguments = p4.readBundle();
        this.mSavedFragmentState = p4.readBundle();
        return;
    }

    public FragmentState(android.support.v4.app.Fragment p2)
    {
        this.mClassName = p2.getClass().getName();
        this.mIndex = p2.mIndex;
        this.mFromLayout = p2.mFromLayout;
        this.mFragmentId = p2.mFragmentId;
        this.mContainerId = p2.mContainerId;
        this.mTag = p2.mTag;
        this.mRetainInstance = p2.mRetainInstance;
        this.mDetached = p2.mDetached;
        this.mArguments = p2.mArguments;
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public android.support.v4.app.Fragment instantiate(android.support.v4.app.FragmentActivity p4, android.support.v4.app.Fragment p5)
    {
        android.support.v4.app.Fragment v0_18;
        if (this.mInstance == null) {
            if (this.mArguments != null) {
                this.mArguments.setClassLoader(p4.getClassLoader());
            }
            this.mInstance = android.support.v4.app.Fragment.instantiate(p4, this.mClassName, this.mArguments);
            if (this.mSavedFragmentState != null) {
                this.mSavedFragmentState.setClassLoader(p4.getClassLoader());
                this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
            }
            this.mInstance.setIndex(this.mIndex, p5);
            this.mInstance.mFromLayout = this.mFromLayout;
            this.mInstance.mRestored = 1;
            this.mInstance.mFragmentId = this.mFragmentId;
            this.mInstance.mContainerId = this.mContainerId;
            this.mInstance.mTag = this.mTag;
            this.mInstance.mRetainInstance = this.mRetainInstance;
            this.mInstance.mDetached = this.mDetached;
            this.mInstance.mFragmentManager = p4.mFragments;
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", new StringBuilder().append("Instantiated fragment ").append(this.mInstance).toString());
            }
            v0_18 = this.mInstance;
        } else {
            v0_18 = this.mInstance;
        }
        return v0_18;
    }

    public void writeToParcel(android.os.Parcel p4, int p5)
    {
        android.os.Bundle v0_11;
        int v1 = 1;
        p4.writeString(this.mClassName);
        p4.writeInt(this.mIndex);
        if (!this.mFromLayout) {
            v0_11 = 0;
        } else {
            v0_11 = 1;
        }
        android.os.Bundle v0_4;
        p4.writeInt(v0_11);
        p4.writeInt(this.mFragmentId);
        p4.writeInt(this.mContainerId);
        p4.writeString(this.mTag);
        if (!this.mRetainInstance) {
            v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        p4.writeInt(v0_4);
        if (!this.mDetached) {
            v1 = 0;
        }
        p4.writeInt(v1);
        p4.writeBundle(this.mArguments);
        p4.writeBundle(this.mSavedFragmentState);
        return;
    }
}
