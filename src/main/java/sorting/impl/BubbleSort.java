package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

import java.util.Arrays;

public class BubbleSort implements Sort {

    @Override
    public void sort(int arr[])
    {
        boolean swap=false;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=arr.length-1;j>i;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    swap=true;
                    swap(arr,j,j-1);
                }
            }
            if(!swap)
                return;
            swap=false;
        }
    }
}
