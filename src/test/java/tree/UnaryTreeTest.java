package tree;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;
import java.util.function.Consumer;

public class UnaryTreeTest {


    @Test
    public void serialize_the_unaryTree()
    {
        NaryTreeNode ten = new NaryTreeNode(10);
        NaryTreeNode ttwnety = new NaryTreeNode(20);
        NaryTreeNode ftin = new NaryTreeNode(15);
        NaryTreeNode five = new NaryTreeNode(5);
        NaryTreeNode four = new NaryTreeNode(4);
        NaryTreeNode thrty = new NaryTreeNode(30);
        NaryTreeNode st = new NaryTreeNode(60);

        ten.getChildren().add(ttwnety);ten.getChildren().add(st);
            ttwnety.getChildren().add(ftin);ttwnety.getChildren().add(thrty);
                ftin.getChildren().add(five);ftin.getChildren().add(four);

        NaryTree tree = new NaryTree(ten);

        String serializedStringb= NaryTree.seriazedString(tree);

        NaryTree clonedTree = NaryTree.deseriazedString(serializedStringb);

        String clonedStringdb = NaryTree.seriazedString(clonedTree);

        Assert.assertEquals(clonedStringdb,serializedStringb);
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
