package src.main.java.sorting;

public interface Sort {

    void sort(int arr[]);

    default void swap(int arr[],int x,int y)
    {
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
