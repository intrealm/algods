package src.test.java.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.main.java.sorting.Sort;
import src.main.java.sorting.impl.BubbleSort;
import src.main.java.sorting.impl.InsertionSort;
import src.main.java.sorting.impl.SelectionSort;
import src.main.java.sorting.impl.ShellSort;

public class SortingTest {

    Sort sortingImpl;
    @Before
    public void setup()
    {
        //sortingImpl = new BubbleSort();
        //sortingImpl = new SelectionSort();
        sortingImpl = new InsertionSort();
       // sortingImpl = new ShellSort();
        //switch here
    }

    @Test
    public void test_simple_selection()
    {
        int arr[] = {37,18,73,10,5,2,15,0,17,22,43,};
        final int expectedArr[] = {0,2,5,10,15,17,18,22,37,43,73};

        sortingImpl.sort(arr);

        Assert.assertArrayEquals(expectedArr,arr);
    }

    @Test
    public void test_simple_selection_empty()
    {
        int arr[] = {};
        final int expectedArr[] = {};

        sortingImpl.sort(arr);

        Assert.assertArrayEquals(expectedArr,arr);
    }

    @Test
    public void test_simple_selection_repetive_values()
    {
        int arr[] = {10,5,2,15,0,17,73,43,37,18,73};
        final int expectedArr[] = {0,2,5,10,15,17,18,37,43,73,73};

        sortingImpl.sort(arr);

        Assert.assertArrayEquals(expectedArr,arr);
    }
}
