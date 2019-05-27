package src.main.java.queue.impls;

import src.main.java.queue.Queue;

public class LinkedListQueue<T > implements Queue<T>{


    private int MAX_SIZE;

    private Node<T> head;

    private Node<T> tail;

    private int size;

    public LinkedListQueue(int maxSize)
    {
        MAX_SIZE = maxSize;
    }

    @Override
    public void enQueue(T o) {
        if(isFull())
            throw new RuntimeException("Overflow");
        Node node= new Node(o);
        if(isEmpty())
        {
            head = node;
        }
        else
        {
            tail.setNext(node);
        }
        tail=node;
        size++;
    }

    @Override
    public T deQueue() {
        if(isEmpty())
            throw new RuntimeException("underFlow");
        Node<T> node = this.head;
        this.head=head.next;
        size--;
        return node.getVal();
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("underFlow");
        Node<T> node = this.head;
        return node.getVal();
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

    //holder Node
    class Node<T>
    {
        private T val;
        private Node next;

        public Node(T val)
        {
            this.val=val;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
