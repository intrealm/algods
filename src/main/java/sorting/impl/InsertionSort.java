package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

import java.util.Arrays;

public class InsertionSort implements Sort {

    @Override
    public void sort(int arr[])
    {

       /* if(true)
        {
            modifiedInsertionSort(arr,0,1);
            return;
        }*/

        //Originla login
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

    public void modifiedInsertionSort(int arr[],int startIdx,int incremnt)
    {
        for(int i=startIdx+incremnt;i<arr.length;i=i+incremnt) //increases ahead
        {
            for(int j=Math.min(i,arr.length);j>0;j=j-incremnt)  //reduces
            {
                if(arr[j]<arr[j-incremnt])
                    swap(arr,j,j-incremnt);
                else
                    break;
            }
            System.out.println(Arrays.toString(arr));

        }
    }
}
