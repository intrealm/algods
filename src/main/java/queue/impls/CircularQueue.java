package src.main.java.queue.impls;

import src.main.java.queue.Queue;

import java.lang.reflect.Array;

public class CircularQueue<T > implements Queue<T>{

    private T arr[];

    private int MAX_SIZE;

    private int head;
    private int tail;

    private int size;

    public CircularQueue(int maxSize)
    {
        MAX_SIZE = maxSize;
        arr = (T[])new Object[maxSize];
        head=0;
        tail=0;
    }

    @Override
    public void enQueue(T o) {
        if(isFull())
            throw new RuntimeException("Overflow");
        arr[tail]=o;
        tail++;
        size++;
    }

    @Override
    public T deQueue() {
        if(isEmpty())
            throw new RuntimeException("Underflow");
        T val = arr[head];
        head++;
        size--;
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
        return this.size;
    }

    @Override
    public int getMaxSize() {
        return this.MAX_SIZE;
    }
}
