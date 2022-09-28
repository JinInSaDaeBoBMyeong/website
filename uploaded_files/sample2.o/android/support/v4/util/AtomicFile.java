package android.support.v4.util;
public class AtomicFile {
    private final java.io.File mBackupName;
    private final java.io.File mBaseName;

    public AtomicFile(java.io.File p4)
    {
        this.mBaseName = p4;
        this.mBackupName = new java.io.File(new StringBuilder().append(p4.getPath()).append(".bak").toString());
        return;
    }

    static boolean sync(java.io.FileOutputStream p1)
    {
        if (p1 == null) {
            int v0_1 = 1;
        } else {
            try {
                p1.getFD().sync();
            } catch (int v0) {
                v0_1 = 0;
            }
        }
        return v0_1;
    }

    public void delete()
    {
        this.mBaseName.delete();
        this.mBackupName.delete();
        return;
    }

    public void failWrite(java.io.FileOutputStream p4)
    {
        if (p4 != null) {
            android.support.v4.util.AtomicFile.sync(p4);
            try {
                p4.close();
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            } catch (java.io.IOException v0) {
                android.util.Log.w("AtomicFile", "failWrite: Got exception:", v0);
            }
        }
        return;
    }

    public void finishWrite(java.io.FileOutputStream p4)
    {
        if (p4 != null) {
            android.support.v4.util.AtomicFile.sync(p4);
            try {
                p4.close();
                this.mBackupName.delete();
            } catch (java.io.IOException v0) {
                android.util.Log.w("AtomicFile", "finishWrite: Got exception:", v0);
            }
        }
        return;
    }

    public java.io.File getBaseFile()
    {
        return this.mBaseName;
    }

    public java.io.FileInputStream openRead()
    {
        if (this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }
        return new java.io.FileInputStream(this.mBaseName);
    }

    public byte[] readFully()
    {
        java.io.FileInputStream v5 = this.openRead();
        int v4 = 0;
        try {
            byte[] v2 = new byte[v5.available()];
        } catch (int v6_2) {
            v5.close();
            throw v6_2;
        }
        do {
            int v0 = v5.read(v2, v4, (v2.length - v4));
            if (v0 > 0) {
                v4 += v0;
                int v1_0 = v5.available();
            } else {
                v5.close();
                return v2;
            }
        } while(v1_0 <= (v2.length - v4));
        byte[] v3 = new byte[(v4 + v1_0)];
        System.arraycopy(v2, 0, v3, 0, v4);
        v2 = v3;
    }

    public java.io.FileOutputStream startWrite()
    {
        if (this.mBaseName.exists()) {
            if (this.mBackupName.exists()) {
                this.mBaseName.delete();
            } else {
                if (!this.mBaseName.renameTo(this.mBackupName)) {
                    android.util.Log.w("AtomicFile", new StringBuilder().append("Couldn\'t rename file ").append(this.mBaseName).append(" to backup file ").append(this.mBackupName).toString());
                }
            }
        }
        try {
            java.io.FileOutputStream v3_1 = new java.io.FileOutputStream(this.mBaseName);
        } catch (java.io.FileNotFoundException v0) {
            if (this.mBaseName.getParentFile().mkdir()) {
                try {
                    v3_1 = new java.io.FileOutputStream(this.mBaseName);
                } catch (java.io.FileNotFoundException v1) {
                    throw new java.io.IOException(new StringBuilder().append("Couldn\'t create ").append(this.mBaseName).toString());
                }
            } else {
                throw new java.io.IOException(new StringBuilder().append("Couldn\'t create directory ").append(this.mBaseName).toString());
            }
        }
        return v3_1;
    }
}
