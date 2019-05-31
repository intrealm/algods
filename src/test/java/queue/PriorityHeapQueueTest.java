package src.test.java.queue;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.heap.Heap;
import src.main.java.heap.MinHeap;

public class PriorityHeapQueueTest {

    @Test
    public void test_max_k_values_inHeap() {

        Integer arr[]={1,2,3,8,43,4,35,4,5,36,5,76,7,73,88798,9,8,32,343,2};
        MinHeap<Integer> heap = MinHeap.getKHighestElements(Integer.class,arr,4);

        Assert.assertEquals(Integer.valueOf(73),heap.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(76),heap.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(343),heap.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(88798),heap.removeHighestPriority());

        }

    @Test
    public void test_max_value_in_minHeap()
    {

        MinHeap<Integer> queue = new MinHeap(Integer.class);

        queue.insertPriorityNode(100);
        queue.insertPriorityNode(20);
        queue.insertPriorityNode(200);
        queue.insertPriorityNode(150);
        queue.insertPriorityNode(15);
        queue.insertPriorityNode(25);

        Assert.assertEquals(Integer.valueOf(200),queue.getMaxElement());
    }

    @Test
    public void test_simple()
    {
        MinHeap<Integer> queue = new MinHeap(Integer.class);

        queue.insertPriorityNode(100);
        queue.insertPriorityNode(20);
        queue.insertPriorityNode(200);
        queue.insertPriorityNode(150);
        queue.insertPriorityNode(15);
        queue.insertPriorityNode(25);

        Assert.assertEquals(Integer.valueOf(15),queue.accessHighestPriority());
        Assert.assertEquals(Integer.valueOf(15),queue.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(20),queue.accessHighestPriority());
        Assert.assertEquals(Integer.valueOf(20),queue.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(25),queue.accessHighestPriority());
        Assert.assertEquals(Integer.valueOf(25),queue.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(100),queue.accessHighestPriority());
        Assert.assertEquals(Integer.valueOf(100),queue.accessHighestPriority());
        Assert.assertEquals(Integer.valueOf(100),queue.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(150),queue.removeHighestPriority());
        Assert.assertEquals(Integer.valueOf(200),queue.removeHighestPriority());

        Assert.assertEquals(0,queue.getSize());

    }
}
