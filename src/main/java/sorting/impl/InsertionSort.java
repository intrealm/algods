package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

import java.util.Arrays;

public class InsertionSort implements Sort {

    @Override
    public void sort(int arr[])
    {

        for(int i=1;i<arr.length;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                    swap(arr,j,j-1);
                else
                    break;
                }
            System.out.println(Arrays.toString(arr));

        }

    }
}
