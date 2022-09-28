package android.support.v4.util;
 class ArrayMap$1 extends android.support.v4.util.MapCollections {
    final synthetic android.support.v4.util.ArrayMap this$0;

    ArrayMap$1(android.support.v4.util.ArrayMap p1)
    {
        this.this$0 = p1;
        return;
    }

    protected void colClear()
    {
        this.this$0.clear();
        return;
    }

    protected Object colGetEntry(int p3, int p4)
    {
        return this.this$0.mArray[((p3 << 1) + p4)];
    }

    protected java.util.Map colGetMap()
    {
        return this.this$0;
    }

    protected int colGetSize()
    {
        return this.this$0.mSize;
    }

    protected int colIndexOfKey(Object p3)
    {
        int v0_1;
        if (p3 != null) {
            v0_1 = this.this$0.indexOf(p3, p3.hashCode());
        } else {
            v0_1 = this.this$0.indexOfNull();
        }
        return v0_1;
    }

    protected int colIndexOfValue(Object p2)
    {
        return this.this$0.indexOfValue(p2);
    }

    protected void colPut(Object p2, Object p3)
    {
        this.this$0.put(p2, p3);
        return;
    }

    protected void colRemoveAt(int p2)
    {
        this.this$0.removeAt(p2);
        return;
    }

    protected Object colSetValue(int p2, Object p3)
    {
        return this.this$0.setValueAt(p2, p3);
    }
}
