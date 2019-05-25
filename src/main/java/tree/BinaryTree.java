package tree;

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

    private void getorderedList(@NotNull BinaryTreeNode currNode,LinkedList<Integer> list)
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
    }

    private void getPostorderedList(@NotNull BinaryTreeNode currNode,LinkedList<Integer> list)
    {

        //navigateLeft
        if(!Objects.isNull(currNode.getLeft()))
        {
            getPostorderedList(currNode.getLeft(),list);
        }
        if(!Objects.isNull(currNode.getRight()))
        {
            getPostorderedList(currNode.getRight(),list);
        }
        list.add(currNode.getVal());
    }
    private void getPreorderedList(@NotNull BinaryTreeNode currNode,LinkedList<Integer> list)
    {
        list.add(currNode.getVal());
        //navigateLeft
        if(!Objects.isNull(currNode.getLeft()))
        {
            getPreorderedList(currNode.getLeft(),list);
        }
        if(!Objects.isNull(currNode.getRight()))
        {
            getPreorderedList(currNode.getRight(),list);
        }
    }

    private void getTwistedOrderedList(@NotNull BinaryTreeNode currNode,LinkedList<Integer> list,boolean twist)
    {
        list.add(currNode.getVal());
        if(!twist)
        {
            if(!Objects.isNull(currNode.getLeft()))
            {
                getTwistedOrderedList(currNode.getLeft(),list, true);
            }

            if(!Objects.isNull(currNode.getRight()))
            {
                getTwistedOrderedList(currNode.getRight(),list,true);
            }
        }
        else
        {
            if(!Objects.isNull(currNode.getRight()))
            {
                getTwistedOrderedList(currNode.getRight(),list,false);
            }
            if(!Objects.isNull(currNode.getLeft()))
            {
                getTwistedOrderedList(currNode.getLeft(),list,false);
            }
        }
    }

    public List<Integer> getInOrderedList()
    {
        if(head==null)
            return Collections.EMPTY_LIST;
        LinkedList<Integer> list = new LinkedList<Integer>();
                getorderedList(this.head,list);
        return list;
    }

    public List<Integer> getTwistedOrderedList()
    {
        if(head==null)
            return Collections.EMPTY_LIST;
        LinkedList<Integer> list = new LinkedList<Integer>();
        getTwistedOrderedList(this.head,list,false);
        return list;
    }

    public List<Integer> getPreOrderedList() {
        if(head==null)
            return Collections.EMPTY_LIST;
        LinkedList<Integer> list = new LinkedList<Integer>();
        getPreorderedList(this.head,list);
        return list;
    }

    public List<Integer> getPostOrderedList()
    {
        if(head==null)
            return Collections.EMPTY_LIST;
        LinkedList<Integer> list = new LinkedList<Integer>();
        getPostorderedList(this.head,list);
        return list;

    }

    public void zigZagOrder()
    {

    }

    String actualTrueTreeFormed()
    {
        BinaryTreeNode node = this.head;
        StringBuffer sb = new StringBuffer();

        if(node!=null)
        publishToBuffer(node,sb);
                return sb.toString();
    }

    final String seperator = System.getProperty("line.separator");

    void publishToBuffer(BinaryTreeNode node,StringBuffer sb)
    {
        sb.append(seperator);
        sb.append(node.getVal());
        if(node.getLeft()!=null)
        publishToBuffer(node.getLeft(),sb);
        if(node.getRight()!=null)
        publishToBuffer(node.getRight(),sb);
    }



    public String toString()
    {
     return  actualTrueTreeFormed();
    }
}
