package android.support.v4.app;
public class ShareCompat$IntentReader {
    private static final String TAG = "IntentReader";
    private android.app.Activity mActivity;
    private android.content.ComponentName mCallingActivity;
    private String mCallingPackage;
    private android.content.Intent mIntent;
    private java.util.ArrayList mStreams;

    private ShareCompat$IntentReader(android.app.Activity p2)
    {
        this.mActivity = p2;
        this.mIntent = p2.getIntent();
        this.mCallingPackage = android.support.v4.app.ShareCompat.getCallingPackage(p2);
        this.mCallingActivity = android.support.v4.app.ShareCompat.getCallingActivity(p2);
        return;
    }

    public static android.support.v4.app.ShareCompat$IntentReader from(android.app.Activity p1)
    {
        return new android.support.v4.app.ShareCompat$IntentReader(p1);
    }

    public android.content.ComponentName getCallingActivity()
    {
        return this.mCallingActivity;
    }

    public android.graphics.drawable.Drawable getCallingActivityIcon()
    {
        android.graphics.drawable.Drawable v2 = 0;
        if (this.mCallingActivity != null) {
            try {
                v2 = this.mActivity.getPackageManager().getActivityIcon(this.mCallingActivity);
            } catch (android.content.pm.PackageManager$NameNotFoundException v0) {
                android.util.Log.e("IntentReader", "Could not retrieve icon for calling activity", v0);
            }
        }
        return v2;
    }

    public android.graphics.drawable.Drawable getCallingApplicationIcon()
    {
        android.graphics.drawable.Drawable v2 = 0;
        if (this.mCallingPackage != null) {
            try {
                v2 = this.mActivity.getPackageManager().getApplicationIcon(this.mCallingPackage);
            } catch (android.content.pm.PackageManager$NameNotFoundException v0) {
                android.util.Log.e("IntentReader", "Could not retrieve icon for calling application", v0);
            }
        }
        return v2;
    }

    public CharSequence getCallingApplicationLabel()
    {
        CharSequence v2 = 0;
        if (this.mCallingPackage != null) {
            android.content.pm.PackageManager v1 = this.mActivity.getPackageManager();
            try {
                v2 = v1.getApplicationLabel(v1.getApplicationInfo(this.mCallingPackage, 0));
            } catch (android.content.pm.PackageManager$NameNotFoundException v0) {
                android.util.Log.e("IntentReader", "Could not retrieve label for calling application", v0);
            }
        }
        return v2;
    }

    public String getCallingPackage()
    {
        return this.mCallingPackage;
    }

    public String[] getEmailBcc()
    {
        return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }

    public String[] getEmailCc()
    {
        return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }

    public String[] getEmailTo()
    {
        return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }

    public String getHtmlText()
    {
        String v0 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
        if (v0 == null) {
            android.text.Spanned v1_1 = this.getText();
            if (!(v1_1 instanceof android.text.Spanned)) {
                if (v1_1 != null) {
                    v0 = android.support.v4.app.ShareCompat.access$000().escapeHtml(v1_1);
                }
            } else {
                v0 = android.text.Html.toHtml(((android.text.Spanned) v1_1));
            }
        }
        return v0;
    }

    public android.net.Uri getStream()
    {
        return ((android.net.Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM"));
    }

    public android.net.Uri getStream(int p4)
    {
        if ((this.mStreams == null) && (this.isMultipleShare())) {
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        IndexOutOfBoundsException v0_7;
        if (this.mStreams == null) {
            if (p4 != 0) {
                throw new IndexOutOfBoundsException(new StringBuilder().append("Stream items available: ").append(this.getStreamCount()).append(" index requested: ").append(p4).toString());
            } else {
                v0_7 = ((android.net.Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM"));
            }
        } else {
            v0_7 = ((android.net.Uri) this.mStreams.get(p4));
        }
        return v0_7;
    }

    public int getStreamCount()
    {
        if ((this.mStreams == null) && (this.isMultipleShare())) {
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        int v0_4;
        if (this.mStreams == null) {
            if (!this.mIntent.hasExtra("android.intent.extra.STREAM")) {
                v0_4 = 0;
            } else {
                v0_4 = 1;
            }
        } else {
            v0_4 = this.mStreams.size();
        }
        return v0_4;
    }

    public String getSubject()
    {
        return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }

    public CharSequence getText()
    {
        return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }

    public String getType()
    {
        return this.mIntent.getType();
    }

    public boolean isMultipleShare()
    {
        return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
    }

    public boolean isShareIntent()
    {
        int v1_1;
        String v0 = this.mIntent.getAction();
        if ((!"android.intent.action.SEND".equals(v0)) && (!"android.intent.action.SEND_MULTIPLE".equals(v0))) {
            v1_1 = 0;
        } else {
            v1_1 = 1;
        }
        return v1_1;
    }

    public boolean isSingleShare()
    {
        return "android.intent.action.SEND".equals(this.mIntent.getAction());
    }
}
