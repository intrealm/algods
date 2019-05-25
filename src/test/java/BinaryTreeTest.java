import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testForInOrder()
    {
        BinaryTree tree = new BinaryTree();

        tree.addValue(3);
        tree.addValue(9);
        tree.addValue(20);
        tree.addValue(15);
        tree.addValue(7);

        System.out.println(tree);

    }
}
