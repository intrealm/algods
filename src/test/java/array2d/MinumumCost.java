package array2d;

import org.junit.Assert;
import org.junit.Test;

public class MinumumCost {

    @Test
    public void getMinimumCost_base_version()
    {
        //0  1  5 7 9
        //45 5  2 1 13
        //0  3  1 4 9
        //4  7  2 7 1
        //1  2 20 1 2

        Array2D arr = new Array2D(5);
        arr.setValueAtPos(0,0,0);arr.setValueAtPos(0,1,1);arr.setValueAtPos(0,2,5);arr.setValueAtPos(0,3,7);arr.setValueAtPos(0,4,9);
        arr.setValueAtPos(1,0,45);arr.setValueAtPos(1,1,5);arr.setValueAtPos(1,2,2);arr.setValueAtPos(1,3,1);arr.setValueAtPos(1,4,13);
        arr.setValueAtPos(2,0,0);arr.setValueAtPos(2,1,3);arr.setValueAtPos(2,2,1);arr.setValueAtPos(2,3,4);arr.setValueAtPos(2,4,9);
        arr.setValueAtPos(3,0,4);arr.setValueAtPos(3,1,7);arr.setValueAtPos(3,2,2);arr.setValueAtPos(3,3,7);arr.setValueAtPos(3,4,1);
        arr.setValueAtPos(4,0,1);arr.setValueAtPos(4,1,2);arr.setValueAtPos(4,2,20);arr.setValueAtPos(4,3,1);arr.setValueAtPos(4,4,2);

        Assert.assertEquals(arr.minimumCost(),21);
      }


    @Test
    public void getMinimumCost_blockers()
    {
        //0 -1  5 7 9
        //45 5 -2 1 13
        //0  3 -1 4 9
        //4  7  2 7 1
        //1  2 20 1 2

        Array2D arr = new Array2D(5);
        arr.setValueAtPos(0,0,0);arr.setValueAtPos(0,1,-1);arr.setValueAtPos(0,2,5);arr.setValueAtPos(0,3,7);arr.setValueAtPos(0,4,9);
        arr.setValueAtPos(1,0,45);arr.setValueAtPos(1,1,5);arr.setValueAtPos(1,2,-2);arr.setValueAtPos(1,3,1);arr.setValueAtPos(1,4,13);
        arr.setValueAtPos(2,0,0);arr.setValueAtPos(2,1,3);arr.setValueAtPos(2,2,-1);arr.setValueAtPos(2,3,4);arr.setValueAtPos(2,4,9);
        arr.setValueAtPos(3,0,4);arr.setValueAtPos(3,1,7);arr.setValueAtPos(3,2,2);arr.setValueAtPos(3,3,7);arr.setValueAtPos(3,4,1);
        arr.setValueAtPos(4,0,1);arr.setValueAtPos(4,1,2);arr.setValueAtPos(4,2,20);arr.setValueAtPos(4,3,1);arr.setValueAtPos(4,4,2);

        Assert.assertEquals(arr.minimumCost(),67);
    }
}
