package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

public class MergerSort implements Sort {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr);
    }

    private void mergeSort(int[] arr)
    {
        //
        if(arr.length<=1)
            return;

        int midPoint = arr.length/2+arr.length%2;
        // 5/2=3    0,1,2 and 3,4
        // 6/2=3    0,1,2,3 and 3,4
        int[] arrFirst = new int[midPoint];
        int[] arrSecond = new int[arr.length-midPoint];

        split(arr,arrFirst,arrSecond);


        mergeSort(arrFirst);
        mergeSort(arrSecond);

        merge(arr,arrFirst,arrSecond);
    }

    public void merge(int arr[],int firstArr[],int secondArr[])
    {                       //5         /3//////////        2
        int i=0;
        int j=0;
        int idx=0;
        while(firstArr.length>i && secondArr.length>j)
        {
            if (firstArr[i] < secondArr[j]) {
                arr[idx++] = firstArr[i++];
            } else {
                arr[idx++] = secondArr[j++];
            }
        }
                while(secondArr.length>j)
                {
                    arr[idx++] = secondArr[j++];
                }
                while(firstArr.length>i)
                {
                    arr[idx++] = firstArr[i++];
                }
        }

    public void split(int arr[],int firstArr[],int secondArr[]) {
        int midPoint = firstArr.length;
        int x = arr.length;
        int z = secondArr.length;
        for (int i = 0; i < arr.length; i++)
        {
            if(i<midPoint)
            {
                firstArr[i]=arr[i];
            }
            else
            {
                secondArr[i-midPoint]=arr[i];
            }

        }
    }
}
