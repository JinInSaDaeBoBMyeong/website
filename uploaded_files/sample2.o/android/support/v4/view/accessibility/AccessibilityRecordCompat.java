package android.support.v4.view.accessibility;
public class AccessibilityRecordCompat {
    private static final android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordImpl IMPL;
    private final Object mRecord;

    static AccessibilityRecordCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            if (android.os.Build$VERSION.SDK_INT < 15) {
                if (android.os.Build$VERSION.SDK_INT < 14) {
                    android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordStubImpl();
                } else {
                    android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordIcsImpl();
                }
            } else {
                android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordIcsMr1Impl();
            }
        } else {
            android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordJellyBeanImpl();
        }
        return;
    }

    public AccessibilityRecordCompat(Object p1)
    {
        this.mRecord = p1;
        return;
    }

    public static android.support.v4.view.accessibility.AccessibilityRecordCompat obtain()
    {
        return new android.support.v4.view.accessibility.AccessibilityRecordCompat(android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.obtain());
    }

    public static android.support.v4.view.accessibility.AccessibilityRecordCompat obtain(android.support.v4.view.accessibility.AccessibilityRecordCompat p3)
    {
        return new android.support.v4.view.accessibility.AccessibilityRecordCompat(android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.obtain(p3.mRecord));
    }

    public boolean equals(Object p6)
    {
        int v1 = 1;
        if (this != p6) {
            if (p6 != null) {
                if (this.getClass() == p6.getClass()) {
                    if (this.mRecord != null) {
                        if (!this.mRecord.equals(((android.support.v4.view.accessibility.AccessibilityRecordCompat) p6).mRecord)) {
                            v1 = 0;
                        }
                    } else {
                        if (((android.support.v4.view.accessibility.AccessibilityRecordCompat) p6).mRecord != null) {
                            v1 = 0;
                        }
                    }
                } else {
                    v1 = 0;
                }
            } else {
                v1 = 0;
            }
        }
        return v1;
    }

    public int getAddedCount()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getAddedCount(this.mRecord);
    }

    public CharSequence getBeforeText()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getBeforeText(this.mRecord);
    }

    public CharSequence getClassName()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getClassName(this.mRecord);
    }

    public CharSequence getContentDescription()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getContentDescription(this.mRecord);
    }

    public int getCurrentItemIndex()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getCurrentItemIndex(this.mRecord);
    }

    public int getFromIndex()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getFromIndex(this.mRecord);
    }

    public Object getImpl()
    {
        return this.mRecord;
    }

    public int getItemCount()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getItemCount(this.mRecord);
    }

    public int getMaxScrollX()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getMaxScrollX(this.mRecord);
    }

    public int getMaxScrollY()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getMaxScrollY(this.mRecord);
    }

    public android.os.Parcelable getParcelableData()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getParcelableData(this.mRecord);
    }

    public int getRemovedCount()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getRemovedCount(this.mRecord);
    }

    public int getScrollX()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getScrollX(this.mRecord);
    }

    public int getScrollY()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getScrollY(this.mRecord);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getSource()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getSource(this.mRecord);
    }

    public java.util.List getText()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getText(this.mRecord);
    }

    public int getToIndex()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getToIndex(this.mRecord);
    }

    public int getWindowId()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.getWindowId(this.mRecord);
    }

    public int hashCode()
    {
        int v0_2;
        if (this.mRecord != null) {
            v0_2 = this.mRecord.hashCode();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public boolean isChecked()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.isChecked(this.mRecord);
    }

    public boolean isEnabled()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.isEnabled(this.mRecord);
    }

    public boolean isFullScreen()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.isFullScreen(this.mRecord);
    }

    public boolean isPassword()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.isPassword(this.mRecord);
    }

    public boolean isScrollable()
    {
        return android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.isScrollable(this.mRecord);
    }

    public void recycle()
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.recycle(this.mRecord);
        return;
    }

    public void setAddedCount(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setAddedCount(this.mRecord, p3);
        return;
    }

    public void setBeforeText(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setBeforeText(this.mRecord, p3);
        return;
    }

    public void setChecked(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setChecked(this.mRecord, p3);
        return;
    }

    public void setClassName(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setClassName(this.mRecord, p3);
        return;
    }

    public void setContentDescription(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setContentDescription(this.mRecord, p3);
        return;
    }

    public void setCurrentItemIndex(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setCurrentItemIndex(this.mRecord, p3);
        return;
    }

    public void setEnabled(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setEnabled(this.mRecord, p3);
        return;
    }

    public void setFromIndex(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setFromIndex(this.mRecord, p3);
        return;
    }

    public void setFullScreen(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setFullScreen(this.mRecord, p3);
        return;
    }

    public void setItemCount(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setItemCount(this.mRecord, p3);
        return;
    }

    public void setMaxScrollX(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setMaxScrollX(this.mRecord, p3);
        return;
    }

    public void setMaxScrollY(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setMaxScrollY(this.mRecord, p3);
        return;
    }

    public void setParcelableData(android.os.Parcelable p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setParcelableData(this.mRecord, p3);
        return;
    }

    public void setPassword(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setPassword(this.mRecord, p3);
        return;
    }

    public void setRemovedCount(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setRemovedCount(this.mRecord, p3);
        return;
    }

    public void setScrollX(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setScrollX(this.mRecord, p3);
        return;
    }

    public void setScrollY(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setScrollY(this.mRecord, p3);
        return;
    }

    public void setScrollable(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setScrollable(this.mRecord, p3);
        return;
    }

    public void setSource(android.view.View p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setSource(this.mRecord, p3);
        return;
    }

    public void setSource(android.view.View p3, int p4)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setSource(this.mRecord, p3, p4);
        return;
    }

    public void setToIndex(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityRecordCompat.IMPL.setToIndex(this.mRecord, p3);
        return;
    }
}
