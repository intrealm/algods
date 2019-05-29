package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTree;

import java.util.List;
import java.util.function.Consumer;

public class BinaryTreeTest {

    @Test
    public void MirrorTest()
    {
        BinaryTree tree = new BinaryTree();

        tree.addValue(3);
        tree.addValue(9);
        tree.addValue(20);
        tree.addValue(15);
        tree.addValue(7);

        tree.addValue(5);
        tree.addValue(4);
        tree.addValue(22);
        tree.addValue(13);
        tree.addValue(70);
        tree.addValue(8);

        tree.mirror_the_tree();

        BinaryTree tree2 = new BinaryTree();

        tree2.addValue(3);
        tree2.addValue(9);
        tree2.addValue(20);
        tree2.addValue(15);
        tree2.addValue(7);

        tree2.addValue(5);
        tree2.addValue(4);
        tree2.addValue(22);
        tree2.addValue(13);
        tree2.addValue(70);
        tree2.addValue(8);

        Assert.assertEquals(tree2.getHead().getRight().getRight().getLeft().getLeft(),tree.getHead().getLeft().getLeft().getRight().getRight());
    }


    @Test
    public void getDepth()
    {
        BinaryTree tree = new BinaryTree();

        tree.addValue(3);
        tree.addValue(9);
        tree.addValue(20);
        tree.addValue(15);
        tree.addValue(7);

        tree.addValue(5);
        tree.addValue(4);
        tree.addValue(22);
        tree.addValue(13);
        tree.addValue(70);
        tree.addValue(8);

        Assert.assertEquals(4,tree.maxDepth());

        Assert.assertEquals(Integer.MIN_VALUE,new BinaryTree().maxDepth());
    }

    @Test
    public void testForInOrder()
    {
        BinaryTree tree = new BinaryTree();

        tree.addValue(3);
        tree.addValue(9);
        tree.addValue(20);
        tree.addValue(15);
        tree.addValue(7);

        tree.addValue(5);
        tree.addValue(4);
        tree.addValue(22);
        tree.addValue(13);
        tree.addValue(70);
        tree.addValue(8);

        //      3
        //        9
        //      7    20
        //    5  8  15   22
        //  4      13       70
        //
        //
        StringBuffer testString = new StringBuffer();
        Consumer con = System.out::print;
        Consumer con2 = (x)->{
            System.out.print(",");
            testString.append(x).append(",");
        };

        List<Integer> lst = tree.getInOrderedList();
        lst.forEach(con.andThen(con2));

        Assert.assertEquals("3,4,5,7,8,9,13,15,20,22,70,",testString.toString());

        testString.setLength(0);
        System.out.println();
        List<Integer> preOrder= tree.getPreOrderedList();
        preOrder.forEach(con.andThen(con2));

        Assert.assertEquals("3,9,7,5,4,8,20,15,13,22,70,",testString.toString());

        testString.setLength(0);
        System.out.println();
        List<Integer> postOrder= tree.getPostOrderedList();
        postOrder.forEach(con.andThen(con2));

        Assert.assertEquals("4,5,8,7,13,15,70,22,20,9,3,",testString.toString());

    }
}
