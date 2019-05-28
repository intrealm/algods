package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

import java.util.Arrays;

public class NoSpaceMergeSortInProgress implements Sort {

    @Override
    public void sort(int arr[])
    {
sort(arr,0,arr.length-1);
//        mergeAndSort(arr,0,arr.length-1);
    }

    public void mergeAndSort(int arr[],int i, int j) {
        //divide
        System.out.println(i);
        System.out.println(j);
        System.out.println(Arrays.toString(arr));
        split(arr,i,j);

        //sort(conquer)
        sort(arr,i,j);
    }

    private void split(int arr[],int i,int j)
    {
        if(j-i>1)
        {
            int pos = (i + j) / 2;
            mergeAndSort(arr,i,pos-1);
            mergeAndSort(arr,pos,j);
        }
    }

    private void sort(int arr[],int start,int end)
    {
        for(int i=start;i<end;i++)
        {
            for(int j=end;j>i;j--)
            {
                if(arr[j]<arr[j-1])
                    swap(arr,j,j-1);
                else
                    break;
            }
         //   System.out.println(Arrays.toString(arr));
        }
    }
}
