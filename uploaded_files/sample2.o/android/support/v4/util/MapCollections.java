package android.support.v4.util;
abstract class MapCollections {
    android.support.v4.util.MapCollections$EntrySet mEntrySet;
    android.support.v4.util.MapCollections$KeySet mKeySet;
    android.support.v4.util.MapCollections$ValuesCollection mValues;

    MapCollections()
    {
        return;
    }

    public static boolean containsAllHelper(java.util.Map p2, java.util.Collection p3)
    {
        java.util.Iterator v0 = p3.iterator();
        while (v0.hasNext()) {
            if (!p2.containsKey(v0.next())) {
                int v1_0 = 0;
            }
            return v1_0;
        }
        v1_0 = 1;
        return v1_0;
    }

    public static boolean equalsSetHelper(java.util.Set p6, Object p7)
    {
        int v2 = 1;
        int v3 = 0;
        if (p6 != p7) {
            if ((p7 instanceof java.util.Set)) {
                try {
                    if ((p6.size() != ((java.util.Set) p7).size()) || (!p6.containsAll(((java.util.Set) p7)))) {
                        v2 = 0;
                    }
                } catch (ClassCastException v0) {
                } catch (ClassCastException v0) {
                }
                v3 = v2;
            }
        } else {
            v3 = 1;
        }
        return v3;
    }

    public static boolean removeAllHelper(java.util.Map p3, java.util.Collection p4)
    {
        int v1 = p3.size();
        java.util.Iterator v0 = p4.iterator();
        while (v0.hasNext()) {
            p3.remove(v0.next());
        }
        int v2_0;
        if (v1 == p3.size()) {
            v2_0 = 0;
        } else {
            v2_0 = 1;
        }
        return v2_0;
    }

    public static boolean retainAllHelper(java.util.Map p3, java.util.Collection p4)
    {
        int v1 = p3.size();
        java.util.Iterator v0 = p3.keySet().iterator();
        while (v0.hasNext()) {
            if (!p4.contains(v0.next())) {
                v0.remove();
            }
        }
        int v2_1;
        if (v1 == p3.size()) {
            v2_1 = 0;
        } else {
            v2_1 = 1;
        }
        return v2_1;
    }

    protected abstract void colClear();

    protected abstract Object colGetEntry();

    protected abstract java.util.Map colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey();

    protected abstract int colIndexOfValue();

    protected abstract void colPut();

    protected abstract void colRemoveAt();

    protected abstract Object colSetValue();

    public java.util.Set getEntrySet()
    {
        if (this.mEntrySet == null) {
            this.mEntrySet = new android.support.v4.util.MapCollections$EntrySet(this);
        }
        return this.mEntrySet;
    }

    public java.util.Set getKeySet()
    {
        if (this.mKeySet == null) {
            this.mKeySet = new android.support.v4.util.MapCollections$KeySet(this);
        }
        return this.mKeySet;
    }

    public java.util.Collection getValues()
    {
        if (this.mValues == null) {
            this.mValues = new android.support.v4.util.MapCollections$ValuesCollection(this);
        }
        return this.mValues;
    }

    public Object[] toArrayHelper(int p5)
    {
        int v0 = this.colGetSize();
        Object[] v2 = new Object[v0];
        int v1 = 0;
        while (v1 < v0) {
            v2[v1] = this.colGetEntry(v1, p5);
            v1++;
        }
        return v2;
    }

    public Object[] toArrayHelper(Object[] p5, int p6)
    {
        int v0 = this.colGetSize();
        if (p5.length < v0) {
            p5 = ((Object[]) ((Object[]) reflect.Array.newInstance(p5.getClass().getComponentType(), v0)));
        }
        int v1 = 0;
        while (v1 < v0) {
            p5[v1] = this.colGetEntry(v1, p6);
            v1++;
        }
        if (p5.length > v0) {
            p5[v0] = 0;
        }
        return p5;
    }
}
