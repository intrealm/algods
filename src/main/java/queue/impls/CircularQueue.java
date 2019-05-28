package src.main.java.queue.impls;

import src.main.java.queue.Queue;

import java.lang.reflect.Array;

public class CircularQueue<T> implements Queue<T>{

    private T arr[];

    private int MAX_SIZE;

    private int head;
    private int tail;

    public CircularQueue(int maxSize)
    {
        MAX_SIZE = maxSize;
        arr = (T[])new Object[maxSize];
        head=-1;
        tail=-1;
    }

    @Override
    public void enQueue(T o) {
        if(isFull())
            throw new RuntimeException("Overflow");
        this.tail= this.getNextTailIndex();
        arr[this.tail]=o;
        if(head==-1)
            head=tail;
    }

    @Override
    public T deQueue() {
        if(isEmpty())
            throw new RuntimeException("Underflow");
        T val = arr[head];
        if(head==tail)
            head=-1;
        else
            head=getNextHeadIndex();
     //   arr[head]=null; //check if really necessary
        return val;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Underflow");
        T val = arr[head];
        return val;
    }

    @Override
    public boolean offer(T o) {
        try{
            enQueue(o);
        }
        catch(RuntimeException e) //must catch overflow exception
        {
            return false;
        }
        return true;
    }

    @Override
    public int getSize() {
        return -1;
    }

    @Override
    public int getMaxSize() {
        return this.MAX_SIZE;
    }

    @Override
    public boolean isEmpty()
    {
        return this.head==-1;
    }

    @Override
    public boolean isFull()
    {
        return getNextTailIndex()==this.head;
    }

    private int getNextTailIndex()
    {
        return (this.tail+1)%this.MAX_SIZE;
    }

    private int getNextHeadIndex()
    {
        return (this.head+1)%this.MAX_SIZE;
    }
}
