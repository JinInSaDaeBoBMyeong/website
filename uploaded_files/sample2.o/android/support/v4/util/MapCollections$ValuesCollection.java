package android.support.v4.util;
final class MapCollections$ValuesCollection implements java.util.Collection {
    final synthetic android.support.v4.util.MapCollections this$0;

    MapCollections$ValuesCollection(android.support.v4.util.MapCollections p1)
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
        if (this.this$0.colIndexOfValue(p2) < 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean containsAll(java.util.Collection p3)
    {
        java.util.Iterator v0 = p3.iterator();
        while (v0.hasNext()) {
            if (!this.contains(v0.next())) {
                int v1_0 = 0;
            }
            return v1_0;
        }
        v1_0 = 1;
        return v1_0;
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
        return new android.support.v4.util.MapCollections$ArrayIterator(this.this$0, 1);
    }

    public boolean remove(Object p3)
    {
        int v1_1;
        int v0 = this.this$0.colIndexOfValue(p3);
        if (v0 < 0) {
            v1_1 = 0;
        } else {
            this.this$0.colRemoveAt(v0);
            v1_1 = 1;
        }
        return v1_1;
    }

    public boolean removeAll(java.util.Collection p7)
    {
        int v0 = this.this$0.colGetSize();
        int v1 = 0;
        int v3 = 0;
        while (v3 < v0) {
            if (p7.contains(this.this$0.colGetEntry(v3, 1))) {
                this.this$0.colRemoveAt(v3);
                v3--;
                v0--;
                v1 = 1;
            }
            v3++;
        }
        return v1;
    }

    public boolean retainAll(java.util.Collection p7)
    {
        int v0 = this.this$0.colGetSize();
        int v1 = 0;
        int v3 = 0;
        while (v3 < v0) {
            if (!p7.contains(this.this$0.colGetEntry(v3, 1))) {
                this.this$0.colRemoveAt(v3);
                v3--;
                v0--;
                v1 = 1;
            }
            v3++;
        }
        return v1;
    }

    public int size()
    {
        return this.this$0.colGetSize();
    }

    public Object[] toArray()
    {
        return this.this$0.toArrayHelper(1);
    }

    public Object[] toArray(Object[] p3)
    {
        return this.this$0.toArrayHelper(p3, 1);
    }
}
