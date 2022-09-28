package android.support.v4.util;
public class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray()
    {
        this(8);
        return;
    }

    public CircularArray(int p4)
    {
        if (p4 > 0) {
            int v0 = p4;
            if (Integer.bitCount(p4) != 1) {
                v0 = (1 << (Integer.highestOneBit(p4) + 1));
            }
            this.mCapacityBitmask = (v0 - 1);
            Object[] v1_1 = new Object[v0];
            this.mElements = ((Object[]) v1_1);
            return;
        } else {
            throw new IllegalArgumentException("capacity must be positive");
        }
    }

    private void doubleCapacity()
    {
        int v1 = this.mElements.length;
        int v3 = (v1 - this.mHead);
        int v2 = (v1 << 1);
        if (v2 >= 0) {
            Object[] v0_1 = new Object[v2];
            System.arraycopy(this.mElements, this.mHead, v0_1, 0, v3);
            System.arraycopy(this.mElements, 0, v0_1, v3, this.mHead);
            this.mElements = ((Object[]) v0_1);
            this.mHead = 0;
            this.mTail = v1;
            this.mCapacityBitmask = (v2 - 1);
            return;
        } else {
            throw new RuntimeException("Too big");
        }
    }

    public final void addFirst(Object p3)
    {
        this.mHead = ((this.mHead - 1) & this.mCapacityBitmask);
        this.mElements[this.mHead] = p3;
        if (this.mHead == this.mTail) {
            this.doubleCapacity();
        }
        return;
    }

    public final void addLast(Object p3)
    {
        this.mElements[this.mTail] = p3;
        this.mTail = ((this.mTail + 1) & this.mCapacityBitmask);
        if (this.mTail == this.mHead) {
            this.doubleCapacity();
        }
        return;
    }

    public final Object get(int p4)
    {
        if ((p4 >= 0) && (p4 < this.size())) {
            return this.mElements[((this.mHead + p4) & this.mCapacityBitmask)];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final Object getFirst()
    {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final Object getLast()
    {
        if (this.mHead != this.mTail) {
            return this.mElements[((this.mTail - 1) & this.mCapacityBitmask)];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final boolean isEmpty()
    {
        int v0_1;
        if (this.mHead != this.mTail) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public final Object popFirst()
    {
        if (this.mHead != this.mTail) {
            Object v0 = this.mElements[this.mHead];
            this.mElements[this.mHead] = 0;
            this.mHead = ((this.mHead + 1) & this.mCapacityBitmask);
            return v0;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final Object popLast()
    {
        if (this.mHead != this.mTail) {
            int v1 = ((this.mTail - 1) & this.mCapacityBitmask);
            Object v0 = this.mElements[v1];
            this.mElements[v1] = 0;
            this.mTail = v1;
            return v0;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final int size()
    {
        return ((this.mTail - this.mHead) & this.mCapacityBitmask);
    }
}
