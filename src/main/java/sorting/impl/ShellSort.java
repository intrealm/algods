package src.main.java.sorting.impl;

import src.main.java.sorting.Sort;

import java.util.Arrays;


//See insertionSort
public class ShellSort implements Sort {

    @Override
    public void sort(int[] arr) {

       // modifiedInsertinoSort(arr,0,3);
       // modifiedInsertinoSort(arr,1,3);
       // modifiedInsertinoSort(arr,2,3);



        //startIdx can be determined by checking till what index the list is not sorted

        int increment =arr.length/2;
        //sorting in part
        while(increment>0)
        {
            for(int i=0;i<increment;i++)
                modifiedInsertionSort(arr,i,increment);
            increment/=2;
        }

        //since insertion sort works faster for nearly sorted
        //passing increment as 1

    }

    private void modifiedInsertionSort(int arr[],int startIdx,int increment)
    {
        for(int i=startIdx;i<arr.length;i=i+increment)
        {
            for(int j=Math.min(i+increment,arr.length-1);j-increment>=0;j=j-increment)
            {
                if(arr[j]<arr[j-increment])
                    swap(arr,j,j-increment);
                else
                    break;
            }
            System.out.println(Arrays.toString(arr));

        }
    }
}
