package src.main.java.heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinHeap<T extends Comparable> extends Heap<T>{

    public MinHeap(Class<T> clz)
    {
        super(clz);
    }

    public MinHeap(Class clz,int size)
    {
        super(clz,size);
    }

    public static MinHeap getKHighestElements(Class clszz, Comparable arr[],int k)
    {
        MinHeap heap = new MinHeap(clszz,k);
        for(int i=0;i<arr.length;i++)
        {
            if(heap.getSize()<k)
                heap.insertPriorityNode(arr[i]);
            else if(heap.accessHighestPriority().compareTo(arr[i])<0)
            {
                heap.removeHighestPriority();
                heap.insertPriorityNode(arr[i]);
            }
        }
        return heap;
    }

    public T getMaxElement()
    {
        int x = this.getSize();
        if(x==1)
            return arr[x-1];
        int parentIdx = getParentIdx(x-1);

        int maxValueIndex = parentIdx;
        for(int i=parentIdx+2;i<x;i++)
        {
            if(arr[i].compareTo(arr[maxValueIndex])>0)
                maxValueIndex=i;
        }
        return arr[maxValueIndex];
    }



    public void insertPriorityNode(T obj)
    {
        if(obj!=null)
        {

            this.arr[count] = obj;
            this.siftUp(count);
            count++;
        }
        //
    }


    public int getSize()
    {
        return this.count;
    }
    public boolean isEmpty()
    {
        return this.count==0;
    }

    public T accessHighestPriority()
    {
        if(count==0)
            throw new RuntimeException("HeadEmpryexception");
        return this.arr[0];
    }
    public T removeHighestPriority()
    {
        if(count !=-1)
        {
            T ret= this.arr[0];
            arr[0]=arr[count-1];
            count--;
            this.siftDown(0);
            return ret;
        }
        //or throw underflow
        return null;

    }


    public void siftDown(int idx)
    {
        int lidx = this.getLeftIdx(idx);
        int ridx = this.getRightIdx(idx);
        int smallest=-1;

        //compare curr with left/right
        if(lidx>-1 && ridx>-1)
        {
            if(arr[lidx].compareTo(arr[ridx])<0)
            {
                smallest=lidx;
            }
            else
            {
                smallest=ridx;
            }
        }
        else if(lidx>-1)
        {
            smallest=lidx;
        }
        else if(ridx>-1)
        {
            smallest=ridx;
        }
        else
            return;

        if(arr[smallest].compareTo(arr[idx])<=0)
        {
            swap(smallest,idx);
            siftDown(smallest);
        }
    }


    public void siftUp(int idx)
    {
        int pidx = this.getParentIdx(idx);
        if(pidx!=-1 && arr[idx].compareTo(arr[pidx])<=0)
        {
            swap(pidx,idx);
            siftUp(pidx);
        }
    }

    public String toString()
    {
        return Arrays.toString(this.arr);
    }
}
