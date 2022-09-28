package android.support.v4.util;
final class MapCollections$EntrySet implements java.util.Set {
    final synthetic android.support.v4.util.MapCollections this$0;

    MapCollections$EntrySet(android.support.v4.util.MapCollections p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic boolean add(Object p2)
    {
        return this.add(((java.util.Map$Entry) p2));
    }

    public boolean add(java.util.Map$Entry p2)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(java.util.Collection p7)
    {
        int v2 = this.this$0.colGetSize();
        java.util.Iterator v1 = p7.iterator();
        while (v1.hasNext()) {
            java.util.Map$Entry v0_1 = ((java.util.Map$Entry) v1.next());
            this.this$0.colPut(v0_1.getKey(), v0_1.getValue());
        }
        int v3_2;
        if (v2 == this.this$0.colGetSize()) {
            v3_2 = 0;
        } else {
            v3_2 = 1;
        }
        return v3_2;
    }

    public void clear()
    {
        this.this$0.colClear();
        return;
    }

    public boolean contains(Object p7)
    {
        boolean v3_0 = 0;
        if ((p7 instanceof java.util.Map$Entry)) {
            int v2 = this.this$0.colIndexOfKey(((java.util.Map$Entry) p7).getKey());
            if (v2 >= 0) {
                v3_0 = android.support.v4.util.ContainerHelpers.equal(this.this$0.colGetEntry(v2, 1), ((java.util.Map$Entry) p7).getValue());
            }
        }
        return v3_0;
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

    public boolean equals(Object p2)
    {
        return android.support.v4.util.MapCollections.equalsSetHelper(this, p2);
    }

    public int hashCode()
    {
        int v2 = 0;
        int v0 = (this.this$0.colGetSize() - 1);
        while (v0 >= 0) {
            int v6_1;
            Object v1 = this.this$0.colGetEntry(v0, 0);
            Object v3 = this.this$0.colGetEntry(v0, 1);
            if (v1 != null) {
                v6_1 = v1.hashCode();
            } else {
                v6_1 = 0;
            }
            int v4_3;
            if (v3 != null) {
                v4_3 = v3.hashCode();
            } else {
                v4_3 = 0;
            }
            v2 += (v4_3 ^ v6_1);
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
        return new android.support.v4.util.MapCollections$MapIterator(this.this$0);
    }

    public boolean remove(Object p2)
    {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException();
    }

    public int size()
    {
        return this.this$0.colGetSize();
    }

    public Object[] toArray()
    {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] p2)
    {
        throw new UnsupportedOperationException();
    }
}
