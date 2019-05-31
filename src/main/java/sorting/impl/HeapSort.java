package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

public class HeapSort implements Sort{

    @Override
    public void sort(int[] arr) {

        if(arr.length<1)
            return;
        heapify(arr);

        sortTheHeap(arr);
    }



    public void sortTheHeap(int []arr) {
        int x = arr.length - 1;
        while (x > 0)
        {
            swap(arr,0,x);
            x--;
            perculateDown(arr,0,x);
        }
    }

    private void heapify(int arr[])
    {
        //check if has children
        int lastParentIndex = this.getParentIndex(arr.length-1,arr.length-1);
        while(lastParentIndex>=0)
        {
            perculateDown(arr,lastParentIndex,arr.length-1);
            lastParentIndex--;
        }
    }
    private void perculateDown(int arr[],int indexToPerculate,int maxIndex)
    {
        int leftIdx= getLeftNodeIndex(indexToPerculate,maxIndex);
        int rightIdx= getRightNodeIndex(indexToPerculate,maxIndex);

        if( leftIdx!=-1 && arr[indexToPerculate]<arr[leftIdx])
        {
            swap(arr,leftIdx,indexToPerculate);
            perculateDown(arr,leftIdx,maxIndex);
        }

        if( rightIdx!=-1 && arr[indexToPerculate]<arr[rightIdx])
        {
            swap(arr,rightIdx,indexToPerculate);
            perculateDown(arr,rightIdx,maxIndex);
        }
    }


    private int getLeftNodeIndex(int currIndex,int maxIndex)
    {
        if(currIndex<0 || currIndex>maxIndex)
            return -1;
        int index = currIndex*2+1;
        if(index>maxIndex)
            return -1;
        return index;
    }

    private int getParentIndex(int currIndex,int maxIndex)
    {
        if(currIndex<1)
            return -1;
        return (currIndex-1)/2;
    }

    private int getRightNodeIndex(int currIndex,int maxIndex)
    {
        if(currIndex<0 || currIndex>maxIndex)
            return -1;
        int index = currIndex*2+2;
        if(index>maxIndex)
            return -1;
        return index;
    }

    //utility Methods
}
