package android.support.v4.util;
final class MapCollections$KeySet implements java.util.Set {
    final synthetic android.support.v4.util.MapCollections this$0;

    MapCollections$KeySet(android.support.v4.util.MapCollections p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean add(Object p2)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        this.this$0.colClear();
        return;
    }

    public boolean contains(Object p2)
    {
        int v0_2;
        if (this.this$0.colIndexOfKey(p2) < 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean containsAll(java.util.Collection p2)
    {
        return android.support.v4.util.MapCollections.containsAllHelper(this.this$0.colGetMap(), p2);
    }

    public boolean equals(Object p2)
    {
        return android.support.v4.util.MapCollections.equalsSetHelper(this, p2);
    }

    public int hashCode()
    {
        int v2 = 0;
        int v0 = (this.this$0.colGetSize() - 1);
        while (v0 >= 0) {
            int v3_0;
            Object v1 = this.this$0.colGetEntry(v0, 0);
            if (v1 != null) {
                v3_0 = v1.hashCode();
            } else {
                v3_0 = 0;
            }
            v2 += v3_0;
            v0--;
        }
        return v2;
    }

    public boolean isEmpty()
    {
        int v0_2;
        if (this.this$0.colGetSize() != 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public java.util.Iterator iterator()
    {
        return new android.support.v4.util.MapCollections$ArrayIterator(this.this$0, 0);
    }

    public boolean remove(Object p3)
    {
        int v1_1;
        int v0 = this.this$0.colIndexOfKey(p3);
        if (v0 < 0) {
            v1_1 = 0;
        } else {
            this.this$0.colRemoveAt(v0);
            v1_1 = 1;
        }
        return v1_1;
    }

    public boolean removeAll(java.util.Collection p2)
    {
        return android.support.v4.util.MapCollections.removeAllHelper(this.this$0.colGetMap(), p2);
    }

    public boolean retainAll(java.util.Collection p2)
    {
        return android.support.v4.util.MapCollections.retainAllHelper(this.this$0.colGetMap(), p2);
    }

    public int size()
    {
        return this.this$0.colGetSize();
    }

    public Object[] toArray()
    {
        return this.this$0.toArrayHelper(0);
    }

    public Object[] toArray(Object[] p3)
    {
        return this.this$0.toArrayHelper(p3, 0);
    }
}
