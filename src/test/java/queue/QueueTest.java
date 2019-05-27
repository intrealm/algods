package src.test.java.queue;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.queue.Queue;
import src.main.java.queue.impls.CircularQueue;
import src.main.java.queue.impls.LinkedListQueue;

public class QueueTest {


    @Test
    public void test_circular_qeueu()
    {
        Queue<Integer> queue = new CircularQueue<>(10);

        queue.enQueue(5);

        Assert.assertEquals(Integer.valueOf(5),queue.peek());

        queue.enQueue(10);

        Assert.assertEquals(Integer.valueOf(5),queue.peek());

        Assert.assertEquals(Integer.valueOf(5),queue.deQueue());

        Assert.assertEquals(Integer.valueOf(10),queue.peek());
        Assert.assertEquals(Integer.valueOf(10),queue.deQueue());
    }

    @Test(expected = RuntimeException.class)
    public void test_circular_qeueu_underflow()
    {
        Queue<Integer> queue = new CircularQueue<>(10);

        queue.deQueue();
    }

    @Test
    public void test_circular_qeueu_offer()
    {
        Queue<Integer> queue = new CircularQueue<>(10);

        queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);
        Assert.assertEquals(Boolean.FALSE,queue.offer(1));
        Assert.assertEquals((Object)Integer.valueOf(10),queue.getSize());
    }

    @Test
    public void test_linkedlist_qeueu()
    {
        Queue<Integer> queue = new LinkedListQueue<>(10);

        queue.enQueue(5);

        Assert.assertEquals(Integer.valueOf(5),queue.peek());

        queue.enQueue(10);

        Assert.assertEquals(Integer.valueOf(5),queue.peek());

        Assert.assertEquals(Integer.valueOf(5),queue.deQueue());

        Assert.assertEquals(Integer.valueOf(10),queue.peek());
        Assert.assertEquals(Integer.valueOf(10),queue.deQueue());
    }


    @Test(expected = RuntimeException.class)
    public void test_linkedlist_qeueu_underflow()
    {
        Queue<Integer> queue = new LinkedListQueue<>(10);

        queue.deQueue();
    }

    @Test
    public void test_linkedlist_qeueu_offer()
    {
        Queue<Integer> queue = new LinkedListQueue<>(10);

        queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);
        Assert.assertEquals(Boolean.FALSE,queue.offer(1));
        Assert.assertEquals((Object)Integer.valueOf(10),queue.getSize());
    }
}
