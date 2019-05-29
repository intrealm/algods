package src.main.java.tree;

import src.main.java.queue.Queue;
import src.main.java.queue.impls.QueueOnStacks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BreadthFirstTraversal<T extends Comparable> {

    private GenericBinaryNode<T> root;

    public List treeToList()
    {
    List<GenericBinaryNode> list = new LinkedList<>();

        if(this.root!=null)
        {
            Queue<GenericBinaryNode> queue = new QueueOnStacks(1000);
            GenericBinaryNode<T> node = this.root;

            queue.enQueue(node);
            while(!queue.isEmpty())
            {
                node = queue.deQueue();
                list.add(node);
                if(node.getLeft()!=null)
                {
                    queue.enQueue(node.getLeft());
                }
                if(node.getRight()!=null)
                {
                    queue.enQueue(node.getRight());
                }
            }
        }
        return list;
    }

    public List treeToList_with_depth_info(GenericBinaryNode findMe)
    {
        List<GenericBinaryNode> list = new LinkedList<>();

        if(this.root!=null)
        {
            Queue<GenericBinaryNode> queue = new QueueOnStacks(1000);
            GenericBinaryNode<T> node = this.root;
            int x=0;
            queue.enQueue(node);
            while(!queue.isEmpty())
            {
                //find
                node =queue.deQueue();
                x++;
                list.add(node);

                if(node.getLeft()!=null)
                {
                    x--;
                  queue.enQueue(node.getLeft());
                }
                if(node.getRight()!=null)
                {
                    x++;
                   queue.enQueue(node.getRight());
                }
            }
        }
        return list;
    }

    public GenericBinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(GenericBinaryNode<T> root) {
        this.root = root;
    }
}
