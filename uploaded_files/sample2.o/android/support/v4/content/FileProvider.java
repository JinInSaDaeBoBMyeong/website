package android.support.v4.content;
public class FileProvider extends android.content.ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = None;
    private static final java.io.File DEVICE_ROOT = None;
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static java.util.HashMap sCache;
    private android.support.v4.content.FileProvider$PathStrategy mStrategy;

    static FileProvider()
    {
        java.util.HashMap v0_1 = new String[2];
        v0_1[0] = "_display_name";
        v0_1[1] = "_size";
        android.support.v4.content.FileProvider.COLUMNS = v0_1;
        android.support.v4.content.FileProvider.DEVICE_ROOT = new java.io.File("/");
        android.support.v4.content.FileProvider.sCache = new java.util.HashMap();
        return;
    }

    public FileProvider()
    {
        return;
    }

    private static varargs java.io.File buildPath(java.io.File p6, String[] p7)
    {
        int v4 = p7.length;
        int v3 = 0;
        java.io.File v2 = p6;
        while (v3 < v4) {
            java.io.File v1_2;
            String v5 = p7[v3];
            if (v5 == null) {
                v1_2 = v2;
            } else {
                v1_2 = new java.io.File(v2, v5);
            }
            v3++;
            v2 = v1_2;
        }
        return v2;
    }

    private static Object[] copyOf(Object[] p2, int p3)
    {
        Object[] v0 = new Object[p3];
        System.arraycopy(p2, 0, v0, 0, p3);
        return v0;
    }

    private static String[] copyOf(String[] p2, int p3)
    {
        String[] v0 = new String[p3];
        System.arraycopy(p2, 0, v0, 0, p3);
        return v0;
    }

    private static android.support.v4.content.FileProvider$PathStrategy getPathStrategy(android.content.Context p5, String p6)
    {
        try {
            android.support.v4.content.FileProvider$PathStrategy v1_1 = ((android.support.v4.content.FileProvider$PathStrategy) android.support.v4.content.FileProvider.sCache.get(p6));
        } catch (IllegalArgumentException v2_5) {
            throw v2_5;
        }
        if (v1_1 == null) {
            try {
                v1_1 = android.support.v4.content.FileProvider.parsePathStrategy(p5, p6);
            } catch (org.xmlpull.v1.XmlPullParserException v0_1) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", v0_1);
            }
            android.support.v4.content.FileProvider.sCache.put(p6, v1_1);
        }
        return v1_1;
    }

    public static android.net.Uri getUriForFile(android.content.Context p2, String p3, java.io.File p4)
    {
        return android.support.v4.content.FileProvider.getPathStrategy(p2, p3).getUriForFile(p4);
    }

    private static int modeToMode(String p4)
    {
        int v0;
        if (!"r".equals(p4)) {
            if ((!"w".equals(p4)) && (!"wt".equals(p4))) {
                if (!"wa".equals(p4)) {
                    if (!"rw".equals(p4)) {
                        if (!"rwt".equals(p4)) {
                            throw new IllegalArgumentException(new StringBuilder().append("Invalid mode: ").append(p4).toString());
                        } else {
                            v0 = 1006632960;
                        }
                    } else {
                        v0 = 939524096;
                    }
                } else {
                    v0 = 704643072;
                }
            } else {
                v0 = 738197504;
            }
        } else {
            v0 = 268435456;
        }
        return v0;
    }

    private static android.support.v4.content.FileProvider$PathStrategy parsePathStrategy(android.content.Context p13, String p14)
    {
        android.support.v4.content.FileProvider$SimplePathStrategy v4_1 = new android.support.v4.content.FileProvider$SimplePathStrategy(p14);
        android.content.res.XmlResourceParser v0 = p13.getPackageManager().resolveContentProvider(p14, 128).loadXmlMetaData(p13.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (v0 == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while(true) {
            int v7 = v0.next();
            if (v7 == 1) {
                break;
            }
            if (v7 == 2) {
                String v5 = v0.getName();
                String v2 = v0.getAttributeValue(0, "name");
                String v3 = v0.getAttributeValue(0, "path");
                java.io.File v6 = 0;
                if (!"root-path".equals(v5)) {
                    if (!"files-path".equals(v5)) {
                        if (!"cache-path".equals(v5)) {
                            if ("external-path".equals(v5)) {
                                java.io.File v8_12 = android.os.Environment.getExternalStorageDirectory();
                                String[] v9_1 = new String[1];
                                v9_1[0] = v3;
                                v6 = android.support.v4.content.FileProvider.buildPath(v8_12, v9_1);
                            }
                        } else {
                            java.io.File v8_13 = p13.getCacheDir();
                            String[] v9_2 = new String[1];
                            v9_2[0] = v3;
                            v6 = android.support.v4.content.FileProvider.buildPath(v8_13, v9_2);
                        }
                    } else {
                        java.io.File v8_15 = p13.getFilesDir();
                        String[] v9_3 = new String[1];
                        v9_3[0] = v3;
                        v6 = android.support.v4.content.FileProvider.buildPath(v8_15, v9_3);
                    }
                } else {
                    String[] v9_4 = new String[1];
                    v9_4[0] = v3;
                    v6 = android.support.v4.content.FileProvider.buildPath(android.support.v4.content.FileProvider.DEVICE_ROOT, v9_4);
                }
                if (v6 != null) {
                    v4_1.addRoot(v2, v6);
                }
            }
        }
        return v4_1;
    }

    public void attachInfo(android.content.Context p3, android.content.pm.ProviderInfo p4)
    {
        super.attachInfo(p3, p4);
        if (!p4.exported) {
            if (p4.grantUriPermissions) {
                this.mStrategy = android.support.v4.content.FileProvider.getPathStrategy(p3, p4.authority);
                return;
            } else {
                throw new SecurityException("Provider must grant uri permissions");
            }
        } else {
            throw new SecurityException("Provider must not be exported");
        }
    }

    public int delete(android.net.Uri p3, String p4, String[] p5)
    {
        int v1_2;
        if (!this.mStrategy.getFileForUri(p3).delete()) {
            v1_2 = 0;
        } else {
            v1_2 = 1;
        }
        return v1_2;
    }

    public String getType(android.net.Uri p7)
    {
        String v3;
        java.io.File v1 = this.mStrategy.getFileForUri(p7);
        int v2 = v1.getName().lastIndexOf(46);
        if (v2 < 0) {
            v3 = "application/octet-stream";
        } else {
            v3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(v1.getName().substring((v2 + 1)));
            if (v3 == null) {
            }
        }
        return v3;
    }

    public android.net.Uri insert(android.net.Uri p3, android.content.ContentValues p4)
    {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate()
    {
        return 1;
    }

    public android.os.ParcelFileDescriptor openFile(android.net.Uri p4, String p5)
    {
        return android.os.ParcelFileDescriptor.open(this.mStrategy.getFileForUri(p4), android.support.v4.content.FileProvider.modeToMode(p5));
    }

    public android.database.Cursor query(android.net.Uri p13, String[] p14, String p15, String[] p16, String p17)
    {
        java.io.File v4 = this.mStrategy.getFileForUri(p13);
        if (p14 == null) {
            p14 = android.support.v4.content.FileProvider.COLUMNS;
        }
        String[] v2_1 = new String[p14.length];
        Object[] v9_1 = new Object[p14.length];
        int v8 = p14.length;
        int v7 = 0;
        int v6 = 0;
        while (v7 < v8) {
            int v5_0;
            String v1 = p14[v7];
            if (!"_display_name".equals(v1)) {
                if (!"_size".equals(v1)) {
                    v5_0 = v6;
                } else {
                    v2_1[v6] = "_size";
                    v5_0 = (v6 + 1);
                    v9_1[v6] = Long.valueOf(v4.length());
                }
            } else {
                v2_1[v6] = "_display_name";
                v5_0 = (v6 + 1);
                v9_1[v6] = v4.getName();
            }
            v7++;
            v6 = v5_0;
        }
        String[] v2_0 = android.support.v4.content.FileProvider.copyOf(v2_1, v6);
        Object[] v9_0 = android.support.v4.content.FileProvider.copyOf(v9_1, v6);
        android.database.MatrixCursor v3_1 = new android.database.MatrixCursor(v2_0, 1);
        v3_1.addRow(v9_0);
        return v3_1;
    }

    public int update(android.net.Uri p3, android.content.ContentValues p4, String p5, String[] p6)
    {
        throw new UnsupportedOperationException("No external updates");
    }
}
