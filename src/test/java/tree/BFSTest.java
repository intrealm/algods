package src.test.java.tree;

import org.junit.Test;
import src.main.java.tree.BreadthFirstTraversal;
import src.main.java.tree.GenericBinaryNode;

public class BFSTest {

    @Test
    public void bfs_check()
    {
        GenericBinaryNode<Integer> node1 = new GenericBinaryNode<>(1);
            GenericBinaryNode<Integer> node2 = new GenericBinaryNode<>(2);
                GenericBinaryNode<Integer> node7 = new GenericBinaryNode<>(7);
                    GenericBinaryNode<Integer> node8 = new GenericBinaryNode<>(8);
            GenericBinaryNode<Integer> node3 = new GenericBinaryNode<>(3);
                GenericBinaryNode<Integer> node4 = new GenericBinaryNode<>(4);
                GenericBinaryNode<Integer> node5 = new GenericBinaryNode<>(5);
                    GenericBinaryNode<Integer> node6 = new GenericBinaryNode<>(6);

            node1.setLeft(node2);node1.setRight(node3);
                node3.setLeft(node4);node3.setRight(node5);
                    node5.setLeft(node6);

                    node2.setLeft(node7);
                        node7.setLeft(node8);

        BreadthFirstTraversal breadthFirstTraversal = new BreadthFirstTraversal();
        breadthFirstTraversal.setRoot(node1);

        breadthFirstTraversal.treeToList().forEach(
                System.out::println
        );


    }

}
