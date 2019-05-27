package src.main.java.queue;


public interface Queue<T> {

    public void enQueue(T t);

    public T deQueue();

    public T peek();

    public boolean offer(T t);

    public int getSize();

    public int getMaxSize();

    default boolean isEmpty()
    {
        return getSize()==0;
    }

    default boolean isFull()
    {
        return getSize()==getMaxSize();
    }
}
