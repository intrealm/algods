package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

import java.util.Arrays;

public class SelectionSort implements Sort {

    @Override
    public void sort(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                    swap(arr,i,j);
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
