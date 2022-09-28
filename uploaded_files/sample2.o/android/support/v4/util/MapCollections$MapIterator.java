package android.support.v4.util;
final class MapCollections$MapIterator implements java.util.Iterator, java.util.Map$Entry {
    int mEnd;
    boolean mEntryValid;
    int mIndex;
    final synthetic android.support.v4.util.MapCollections this$0;

    MapCollections$MapIterator(android.support.v4.util.MapCollections p2)
    {
        this.this$0 = p2;
        this.mEntryValid = 0;
        this.mEnd = (p2.colGetSize() - 1);
        this.mIndex = -1;
        return;
    }

    public final boolean equals(Object p7)
    {
        String v1_0 = 1;
        String v2_0 = 0;
        if (this.mEntryValid) {
            if ((p7 instanceof java.util.Map$Entry)) {
                if ((!android.support.v4.util.ContainerHelpers.equal(((java.util.Map$Entry) p7).getKey(), this.this$0.colGetEntry(this.mIndex, 0))) || (!android.support.v4.util.ContainerHelpers.equal(((java.util.Map$Entry) p7).getValue(), this.this$0.colGetEntry(this.mIndex, 1)))) {
                    v1_0 = 0;
                }
                v2_0 = v1_0;
            }
            return v2_0;
        } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
    }

    public Object getKey()
    {
        if (this.mEntryValid) {
            return this.this$0.colGetEntry(this.mIndex, 0);
        } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
    }

    public Object getValue()
    {
        if (this.mEntryValid) {
            return this.this$0.colGetEntry(this.mIndex, 1);
        } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
    }

    public boolean hasNext()
    {
        int v0_1;
        if (this.mIndex >= this.mEnd) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public final int hashCode()
    {
        int v2_0 = 0;
        if (this.mEntryValid) {
            int v3_1;
            Object v0 = this.this$0.colGetEntry(this.mIndex, 0);
            Object v1 = this.this$0.colGetEntry(this.mIndex, 1);
            if (v0 != null) {
                v3_1 = v0.hashCode();
            } else {
                v3_1 = 0;
            }
            if (v1 != null) {
                v2_0 = v1.hashCode();
            }
            return (v2_0 ^ v3_1);
        } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
    }

    public bridge synthetic Object next()
    {
        return this.next();
    }

    public java.util.Map$Entry next()
    {
        this.mIndex = (this.mIndex + 1);
        this.mEntryValid = 1;
        return this;
    }

    public void remove()
    {
        if (this.mEntryValid) {
            this.this$0.colRemoveAt(this.mIndex);
            this.mIndex = (this.mIndex - 1);
            this.mEnd = (this.mEnd - 1);
            this.mEntryValid = 0;
            return;
        } else {
            throw new IllegalStateException();
        }
    }

    public Object setValue(Object p3)
    {
        if (this.mEntryValid) {
            return this.this$0.colSetValue(this.mIndex, p3);
        } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
    }

    public final String toString()
    {
        return new StringBuilder().append(this.getKey()).append("=").append(this.getValue()).toString();
    }
}
