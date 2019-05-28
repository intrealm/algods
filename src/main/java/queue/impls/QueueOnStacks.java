package src.main.java.queue.impls;

import src.main.java.queue.Queue;

import java.util.Stack;

public class QueueOnStacks<T> implements Queue<T> {

    Stack<T> stackOne = new Stack<>();

    Stack<T> stackTwo = new Stack<>();

    int size;

    int MAX_SIZE;

    public QueueOnStacks(int size)
    {
        this.MAX_SIZE=size;
    }

    @Override
    public void enQueue(T t) {
        if(isFull())
            throw new RuntimeException("overflow");
        if(stackOne.isEmpty())
            while(!stackTwo.isEmpty())
                stackOne.push(stackTwo.pop());
        stackOne.push(t);
        size++;
    }

    @Override
    public T deQueue() {
        if(isEmpty())
            throw new RuntimeException("underflow");
        if(stackTwo.isEmpty())
            while(!stackOne.isEmpty())
                stackTwo.push(stackOne.pop());
        T val = stackTwo.pop();
        size--;

        return val;
    }

    private void moveBackToStackOne()
    {
        QueueOnStacks.fillAnother(this.stackTwo,this.stackOne);
    }

    private void moveToStackTwo()
    {
        QueueOnStacks.fillAnother(this.stackOne,this.stackTwo);
    }

    private static void fillAnother(Stack source,Stack target)
    {
        while(!source.isEmpty())
        {
            target.push(source.pop());
        }

    }


    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("underflow");

        if(stackTwo.isEmpty())
            while(!stackOne.isEmpty())
                stackTwo.push(stackOne.pop());
        T val = stackTwo.peek();
        return val;
    }

    @Override
    public boolean offer(T t) {

        try{
            enQueue(t);
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
