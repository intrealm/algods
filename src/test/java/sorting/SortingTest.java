package src.test.java.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.main.java.sorting.Sort;
import src.main.java.sorting.impl.*;

import java.util.HashSet;
import java.util.Set;


public class SortingTest {


    public Set<Sort> setOfImplementations = new HashSet<>();

    @Before
    public void setup()
    {
        this.setOfImplementations.add(new BubbleSort());
        this.setOfImplementations.add(new ShellSort());
        this.setOfImplementations.add(new InsertionSort());
        this.setOfImplementations.add(new SelectionSort());
        this.setOfImplementations.add(new MergerSort());

       // this.setOfImplementations.clear();
       // this.setOfImplementations.add(new QuickSort());


        /*Stream.of(allImpls).map(fqNames).peek(System.out::println).map(fqn->{
            try{
                fqn = fqn;
                Object obj = Class.forName(fqn);
                return (Sort)obj;

            }).forEach(setOfImplementations::add);*/
    }


    @Test
    public void test_simple_selection()
    {
        for(Sort sortingImpl:this.setOfImplementations)
        {
        int arr[] = {37,18,73,10,5,2,15,0,17,22,43};
        final int expectedArr[] = {0,2,5,10,15,17,18,22,37,43,73};

        sortingImpl.sort(arr);

        Assert.assertArrayEquals(expectedArr,arr);

    }}

    @Test
    public void test_simple_selection_empty()
    {
        for(Sort sortingImpl:this.setOfImplementations)
        {
            int arr[] = {};
            final int expectedArr[] = {};

            sortingImpl.sort(arr);

            Assert.assertArrayEquals(expectedArr,arr);
        }
    }

    @Test
    public void test_simple_selection_repetive_values()
    {
        for(Sort sortingImpl:this.setOfImplementations)
        {
            int arr[] = {10,5,2,15,0,17,73,43,37,18,73};

            final int expectedArr[] = {0,2,5,10,15,17,18,37,43,73,73};

            sortingImpl.sort(arr);

            Assert.assertArrayEquals(expectedArr,arr);
        }
    }
}
