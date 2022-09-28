package android.support.v4.app;
public class ShareCompat$IntentBuilder {
    private android.app.Activity mActivity;
    private java.util.ArrayList mBccAddresses;
    private java.util.ArrayList mCcAddresses;
    private CharSequence mChooserTitle;
    private android.content.Intent mIntent;
    private java.util.ArrayList mStreams;
    private java.util.ArrayList mToAddresses;

    private ShareCompat$IntentBuilder(android.app.Activity p4)
    {
        this.mActivity = p4;
        this.mIntent = new android.content.Intent().setAction("android.intent.action.SEND");
        this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", p4.getPackageName());
        this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", p4.getComponentName());
        this.mIntent.addFlags(524288);
        return;
    }

    private void combineArrayExtra(String p6, java.util.ArrayList p7)
    {
        int v1;
        String[] v0 = this.mIntent.getStringArrayExtra(p6);
        if (v0 == null) {
            v1 = 0;
        } else {
            v1 = v0.length;
        }
        String[] v2 = new String[(p7.size() + v1)];
        p7.toArray(v2);
        if (v0 != null) {
            System.arraycopy(v0, 0, v2, p7.size(), v1);
        }
        this.mIntent.putExtra(p6, v2);
        return;
    }

    private void combineArrayExtra(String p7, String[] p8)
    {
        int v2;
        android.content.Intent v0 = this.getIntent();
        String[] v1 = v0.getStringArrayExtra(p7);
        if (v1 == null) {
            v2 = 0;
        } else {
            v2 = v1.length;
        }
        String[] v3 = new String[(p8.length + v2)];
        if (v1 != null) {
            System.arraycopy(v1, 0, v3, 0, v2);
        }
        System.arraycopy(p8, 0, v3, v2, p8.length);
        v0.putExtra(p7, v3);
        return;
    }

    public static android.support.v4.app.ShareCompat$IntentBuilder from(android.app.Activity p1)
    {
        return new android.support.v4.app.ShareCompat$IntentBuilder(p1);
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addEmailBcc(String p2)
    {
        if (this.mBccAddresses == null) {
            this.mBccAddresses = new java.util.ArrayList();
        }
        this.mBccAddresses.add(p2);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addEmailBcc(String[] p2)
    {
        this.combineArrayExtra("android.intent.extra.BCC", p2);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addEmailCc(String p2)
    {
        if (this.mCcAddresses == null) {
            this.mCcAddresses = new java.util.ArrayList();
        }
        this.mCcAddresses.add(p2);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addEmailCc(String[] p2)
    {
        this.combineArrayExtra("android.intent.extra.CC", p2);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addEmailTo(String p2)
    {
        if (this.mToAddresses == null) {
            this.mToAddresses = new java.util.ArrayList();
        }
        this.mToAddresses.add(p2);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addEmailTo(String[] p2)
    {
        this.combineArrayExtra("android.intent.extra.EMAIL", p2);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder addStream(android.net.Uri p4)
    {
        android.net.Uri v0_1 = ((android.net.Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM"));
        if (v0_1 != null) {
            if (this.mStreams == null) {
                this.mStreams = new java.util.ArrayList();
            }
            if (v0_1 != null) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                this.mStreams.add(v0_1);
            }
            this.mStreams.add(p4);
        } else {
            this = this.setStream(p4);
        }
        return this;
    }

    public android.content.Intent createChooserIntent()
    {
        return android.content.Intent.createChooser(this.getIntent(), this.mChooserTitle);
    }

    android.app.Activity getActivity()
    {
        return this.mActivity;
    }

    public android.content.Intent getIntent()
    {
        int v1 = 1;
        if (this.mToAddresses != null) {
            this.combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
            this.mToAddresses = 0;
        }
        if (this.mCcAddresses != null) {
            this.combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
            this.mCcAddresses = 0;
        }
        if (this.mBccAddresses != null) {
            this.combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
            this.mBccAddresses = 0;
        }
        if ((this.mStreams == null) || (this.mStreams.size() <= 1)) {
            v1 = 0;
        }
        boolean v0 = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if ((v1 == 0) && (v0)) {
            this.mIntent.setAction("android.intent.action.SEND");
            if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
            } else {
                this.mIntent.putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) this.mStreams.get(0)));
            }
            this.mStreams = 0;
        }
        if ((v1 != 0) && (!v0)) {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
            } else {
                this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            }
        }
        return this.mIntent;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setChooserTitle(int p2)
    {
        return this.setChooserTitle(this.mActivity.getText(p2));
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setChooserTitle(CharSequence p1)
    {
        this.mChooserTitle = p1;
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setEmailBcc(String[] p3)
    {
        this.mIntent.putExtra("android.intent.extra.BCC", p3);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setEmailCc(String[] p3)
    {
        this.mIntent.putExtra("android.intent.extra.CC", p3);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setEmailTo(String[] p3)
    {
        if (this.mToAddresses != null) {
            this.mToAddresses = 0;
        }
        this.mIntent.putExtra("android.intent.extra.EMAIL", p3);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setHtmlText(String p3)
    {
        this.mIntent.putExtra("android.intent.extra.HTML_TEXT", p3);
        if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
            this.setText(android.text.Html.fromHtml(p3));
        }
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setStream(android.net.Uri p3)
    {
        if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
            this.mIntent.setAction("android.intent.action.SEND");
        }
        this.mStreams = 0;
        this.mIntent.putExtra("android.intent.extra.STREAM", p3);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setSubject(String p3)
    {
        this.mIntent.putExtra("android.intent.extra.SUBJECT", p3);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setText(CharSequence p3)
    {
        this.mIntent.putExtra("android.intent.extra.TEXT", p3);
        return this;
    }

    public android.support.v4.app.ShareCompat$IntentBuilder setType(String p2)
    {
        this.mIntent.setType(p2);
        return this;
    }

    public void startChooser()
    {
        this.mActivity.startActivity(this.createChooserIntent());
        return;
    }
}
