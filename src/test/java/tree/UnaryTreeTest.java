package tree;

import org.junit.Assert;
import org.junit.Test;

public class UnaryTreeTest {


    @Test
    public void serialize_the_unaryTree()
    {
        NaryTreeNode ten = new NaryTreeNode(10);
        NaryTreeNode twenty = new NaryTreeNode(20);
        NaryTreeNode fifteen = new NaryTreeNode(15);
        NaryTreeNode five = new NaryTreeNode(5);
        NaryTreeNode four = new NaryTreeNode(4);
        NaryTreeNode thirty = new NaryTreeNode(30);
        NaryTreeNode sixty = new NaryTreeNode(60);

        ten.getChildren().add(twenty);ten.getChildren().add(sixty);
            twenty.getChildren().add(fifteen);twenty.getChildren().add(thirty);
                fifteen.getChildren().add(five);fifteen.getChildren().add(four);

        NaryTree tree = new NaryTree(ten);

        String serializedTree= NaryTree.seriazedString(tree);

        NaryTree clonedTree = NaryTree.deseriazedString(serializedTree);

        String seriablizedClonedTree = NaryTree.seriazedString(clonedTree);

        Assert.assertEquals(seriablizedClonedTree,serializedTree);
        Assert.assertFalse(tree == clonedTree);
        Assert.assertEquals( tree , clonedTree );

    }

    @Test
    public void string_operation_test()
    {
        String dummy  = "abcdef";
        Assert.assertEquals("abcdef",dummy);
        Assert.assertEquals("cdef",dummy.substring(2));

        String dummy2  = "10:asdf";
        int x = dummy2.indexOf(':');
        Assert.assertEquals(dummy2.substring(x+1),"asdf");
    }
}
