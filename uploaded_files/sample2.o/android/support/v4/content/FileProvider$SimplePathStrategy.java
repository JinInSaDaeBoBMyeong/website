package android.support.v4.content;
 class FileProvider$SimplePathStrategy implements android.support.v4.content.FileProvider$PathStrategy {
    private final String mAuthority;
    private final java.util.HashMap mRoots;

    public FileProvider$SimplePathStrategy(String p2)
    {
        this.mRoots = new java.util.HashMap();
        this.mAuthority = p2;
        return;
    }

    public void addRoot(String p5, java.io.File p6)
    {
        if (!android.text.TextUtils.isEmpty(p5)) {
            try {
                java.io.File v6_1 = p6.getCanonicalFile();
                this.mRoots.put(p5, v6_1);
                return;
            } catch (java.io.IOException v0) {
                throw new IllegalArgumentException(new StringBuilder().append("Failed to resolve canonical path for ").append(v6_1).toString(), v0);
            }
        } else {
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    public java.io.File getFileForUri(android.net.Uri p10)
    {
        String v2_1 = p10.getEncodedPath();
        int v4 = v2_1.indexOf(47, 1);
        String v5 = android.net.Uri.decode(v2_1.substring(1, v4));
        String vtmp6 = android.net.Uri.decode(v2_1.substring((v4 + 1)));
        java.io.File v3_1 = ((java.io.File) this.mRoots.get(v5));
        if (v3_1 != null) {
            try {
                java.io.File v1_2 = new java.io.File(v3_1, vtmp6).getCanonicalFile();
            } catch (java.io.IOException v0) {
                throw new IllegalArgumentException(new StringBuilder().append("Failed to resolve canonical path for ").append(v1_2).toString());
            }
            if (v1_2.getPath().startsWith(v3_1.getPath())) {
                return v1_2;
            } else {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Unable to find configured root for ").append(p10).toString());
        }
    }

    public android.net.Uri getUriForFile(java.io.File p10)
    {
        try {
            String v3_0 = p10.getCanonicalPath();
            java.util.Map$Entry v2 = 0;
            java.util.Iterator v1 = this.mRoots.entrySet().iterator();
        } catch (java.io.IOException v0) {
            throw new IllegalArgumentException(new StringBuilder().append("Failed to resolve canonical path for ").append(p10).toString());
        }
        while (v1.hasNext()) {
            java.util.Map$Entry v4_1 = ((java.util.Map$Entry) v1.next());
            String v5_1 = ((java.io.File) v4_1.getValue()).getPath();
            if ((v3_0.startsWith(v5_1)) && ((v2 == null) || (v5_1.length() > ((java.io.File) v2.getValue()).getPath().length()))) {
                v2 = v4_1;
            }
        }
        if (v2 != null) {
            String v3_1;
            String v5_0 = ((java.io.File) v2.getValue()).getPath();
            if (!v5_0.endsWith("/")) {
                v3_1 = v3_0.substring((v5_0.length() + 1));
            } else {
                v3_1 = v3_0.substring(v5_0.length());
            }
            return new android.net.Uri$Builder().scheme("content").authority(this.mAuthority).encodedPath(new StringBuilder().append(android.net.Uri.encode(((String) v2.getKey()))).append(47).append(android.net.Uri.encode(v3_1, "/")).toString()).build();
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Failed to find configured root that contains ").append(v3_0).toString());
        }
    }
}
