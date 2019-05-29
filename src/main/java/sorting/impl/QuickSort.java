package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {

        //quickSort(arr);

        //partition(arr,o,arr.length)
    }

    private int partition(int arr[],int low,int high)
    {
        //find pivot
        //move elements to before or after the pivot
        int pivot = arr[low];
        //index pivot could be anything/random
        int l=low;
        int h=high;
        while(l<h)
        {
            while(arr[l]<=pivot && l<h)
            {
                l++;
            }
            while(arr[h]>pivot)
            {
                h--;
            }
            if(l<h)
                swap(arr,l,h);
        }
        swap(arr,low,h);
        return h;
    }

    void quickSorT()
    {
        //recursive callto sort the subList
    }
}
