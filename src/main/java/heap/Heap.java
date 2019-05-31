package src.main.java.heap;

public abstract class Heap<T extends Comparable> {

    protected T[] arr;
    private static final int MAX_SIZE = 1024;
    private int size;
    protected int count;

    public Heap(Class clazz)
    {
        this(clazz,MAX_SIZE);
    }
    public Heap(Class clazz,int size)
    {
        arr = (T[]) new Comparable[size];
        this.size=size;
    }

    public int getParentIdx(int idx)
    {
        if(idx<1 || idx>count)
            return -1;
        return (idx-1)/2;
    }

    public int getRightIdx(int idx)
    {
        if(idx<0 || idx>count)
            return -1;
        int rightIdx = idx*2+2;
        if(rightIdx>count-1)
            return -1;
        return rightIdx;
    }

    public int getLeftIdx(int idx)
    {
        if(idx<0 || idx>count)
            return -1; //current Idx is incorrent or out of bound
        int leftIdx = idx*2+1;
        if(leftIdx>count-1)
            return -1; //no position allocated for the leftidx
        return leftIdx;
    }

    public boolean isEmpty()
    {
        return this.size==0;
    }


    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void swap(int from,int to)
    {
        T tmep = arr[from];
        arr[from]=arr[to];
        arr[to]=tmep;
    }
}
