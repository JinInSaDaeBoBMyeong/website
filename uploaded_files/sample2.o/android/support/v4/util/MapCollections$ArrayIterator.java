package android.support.v4.util;
final class MapCollections$ArrayIterator implements java.util.Iterator {
    boolean mCanRemove;
    int mIndex;
    final int mOffset;
    int mSize;
    final synthetic android.support.v4.util.MapCollections this$0;

    MapCollections$ArrayIterator(android.support.v4.util.MapCollections p2, int p3)
    {
        this.this$0 = p2;
        this.mCanRemove = 0;
        this.mOffset = p3;
        this.mSize = p2.colGetSize();
        return;
    }

    public boolean hasNext()
    {
        int v0_1;
        if (this.mIndex >= this.mSize) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public Object next()
    {
        Object v0 = this.this$0.colGetEntry(this.mIndex, this.mOffset);
        this.mIndex = (this.mIndex + 1);
        this.mCanRemove = 1;
        return v0;
    }

    public void remove()
    {
        if (this.mCanRemove) {
            this.mIndex = (this.mIndex - 1);
            this.mSize = (this.mSize - 1);
            this.mCanRemove = 0;
            this.this$0.colRemoveAt(this.mIndex);
            return;
        } else {
            throw new IllegalStateException();
        }
    }
}
