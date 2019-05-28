package src.test.java.queue;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.queue.Queue;
import src.main.java.queue.impls.CircularQueue;
import src.main.java.queue.impls.LinkedListQueue;
import src.main.java.queue.impls.QueueOnStacks;

public class QueueTest {


    @Test
    public void test_circular_overflow_size() {

        Queue<Integer> queue = new CircularQueue<>(10);


//        Assert.assertEquals(0,queue.getSize());
        queue.enQueue(10);
   //     Assert.assertEquals(1,queue.getSize());

        queue.enQueue(10);//2
    //    Assert.assertEquals(2,queue.getSize());
        queue.enQueue(10);//3
    //    Assert.assertEquals(3,queue.getSize());
        queue.enQueue(10);//4
        queue.enQueue(10);
        queue.enQueue(10);
        queue.enQueue(10);//7

     //   Assert.assertEquals(7,queue.getSize());
        queue.deQueue();queue.deQueue();
     //   Assert.assertEquals(5,queue.getSize());
        queue.deQueue();queue.deQueue();

   //     Assert.assertEquals(4,queue.getSize());
        queue.enQueue(10);//4
        queue.enQueue(10);
        queue.enQueue(10);//6
        queue.enQueue(10);
        queue.enQueue(10);
        queue.enQueue(10);//9
       // Assert.assertEquals(9,queue.getSize());
      //  Assert.assertEquals(10,queue.getSize());
        Assert.assertEquals(Boolean.TRUE,queue.isFull());



    }


        @Test(expected = RuntimeException.class)
    public void test_circular_overflow()
    {

        Queue<Integer> queue = new CircularQueue<>(10);

        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);
        queue.enQueue(5);

    }
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

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60);
        queue.enQueue(70);
        queue.enQueue(80);
        queue.enQueue(90);
        queue.enQueue(100);

        Assert.assertEquals(Boolean.TRUE,queue.isFull());
        queue.offer(110);
        Assert.assertEquals(Boolean.TRUE,queue.isFull());
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


    @Test
    public void test_stack_qeueu()
    {
        Queue<Integer> queue = new QueueOnStacks<>(10);

        queue.enQueue(5);

        Assert.assertEquals(Integer.valueOf(5),queue.peek());

        queue.enQueue(10);

        Assert.assertEquals(Integer.valueOf(5),queue.peek());

        Assert.assertEquals(Integer.valueOf(5),queue.deQueue());

        Assert.assertEquals(Integer.valueOf(10),queue.peek());
        Assert.assertEquals(Integer.valueOf(10),queue.deQueue());
    }


    @Test(expected = RuntimeException.class)
    public void test_stack_qeueu_underflow()
    {
        Queue<Integer> queue = new QueueOnStacks<>(10);

        queue.deQueue();
    }

    @Test
    public void test_stack_qeueu_offer()
    {
        Queue<Integer> queue = new QueueOnStacks<>(10);

        queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);queue.offer(1);
        Assert.assertEquals(Boolean.FALSE,queue.offer(1));
        Assert.assertEquals((Object)Integer.valueOf(10),queue.getSize());
    }
}
