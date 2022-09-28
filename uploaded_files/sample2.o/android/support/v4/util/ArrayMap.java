package android.support.v4.util;
public class ArrayMap extends android.support.v4.util.SimpleArrayMap implements java.util.Map {
    android.support.v4.util.MapCollections mCollections;

    public ArrayMap()
    {
        return;
    }

    public ArrayMap(int p1)
    {
        super(p1);
        return;
    }

    public ArrayMap(android.support.v4.util.SimpleArrayMap p1)
    {
        super(p1);
        return;
    }

    private android.support.v4.util.MapCollections getCollection()
    {
        if (this.mCollections == null) {
            this.mCollections = new android.support.v4.util.ArrayMap$1(this);
        }
        return this.mCollections;
    }

    public boolean containsAll(java.util.Collection p2)
    {
        return android.support.v4.util.MapCollections.containsAllHelper(this, p2);
    }

    public java.util.Set entrySet()
    {
        return this.getCollection().getEntrySet();
    }

    public java.util.Set keySet()
    {
        return this.getCollection().getKeySet();
    }

    public void putAll(java.util.Map p5)
    {
        this.ensureCapacity((this.mSize + p5.size()));
        java.util.Iterator v1 = p5.entrySet().iterator();
        while (v1.hasNext()) {
            java.util.Map$Entry v0_1 = ((java.util.Map$Entry) v1.next());
            this.put(v0_1.getKey(), v0_1.getValue());
        }
        return;
    }

    public boolean removeAll(java.util.Collection p2)
    {
        return android.support.v4.util.MapCollections.removeAllHelper(this, p2);
    }

    public boolean retainAll(java.util.Collection p2)
    {
        return android.support.v4.util.MapCollections.retainAllHelper(this, p2);
    }

    public java.util.Collection values()
    {
        return this.getCollection().getValues();
    }
}
