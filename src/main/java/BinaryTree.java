
import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTree {

    private BinaryTreeNode head;

    public void addValue(int value)
    {
        BinaryTreeNode node = createNode(value);
        if(head==null)
        {
            head = node;
        }
        else
        {
            addNewNode(head,node);
        }
    }


    protected void addNewNode(BinaryTreeNode currentNode, BinaryTreeNode newNode)
    {
        //return node = currentNude;
        if(currentNode.getVal()>newNode.getVal() )
        {
            //check left
            if(Objects.isNull(currentNode.getLeft()))
            {
                currentNode.setLeft(newNode);
            }
            else
            addNewNode(currentNode.getLeft(),newNode );
        }
        else if(currentNode.getVal()<newNode.getVal() )
        {
            //check left
            if(Objects.isNull(currentNode.getRight()))
            {
                currentNode.setRight(newNode);
            }
            else
            addNewNode(currentNode.getRight(),newNode );
        }


    }

    protected BinaryTreeNode createNode(int value)
    {
        return new BinaryTreeNode(value);
    }

    private List<Integer> getorderedList(@NotNull BinaryTreeNode currNode,LinkedList<Integer> list)
    {

        //navigateLeft
        if(!Objects.isNull(currNode.getLeft()))
        {
            getorderedList(currNode.getLeft(),list);
        }
        list.add(currNode.getVal());

        if(!Objects.isNull(currNode.getRight()))
        {
            getorderedList(currNode.getRight(),list);
        }


        //middle

        //right

    }

    public List<Integer> getInOrderedList()
    {
        if(head==null)
            return Collections.EMPTY_LIST;
        List<Integer> list = getorderedList(this.head,new LinkedList<Integer>());
        return list;
    }

    public void printPreOrder()
    {

    }


    public void printPostOrder()
    {

    }

    public void zigZagOrder()
    {

    }


    public String toString()
    {
        List<Integer> list = getInOrderedList();

        StringBuffer sb = new StringBuffer();

        list.forEach(str ->
                sb.append("--"+str)
        );
        sb.toString();
    }
}
