package tree;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTree {

    private tree.BinaryTreeNode head;

    public void addValue(int value)
    {
        tree.BinaryTreeNode node = createNode(value);
        if(head==null)
        {
            head = node;
        }
        else
        {
            addNewNode(head,node);
        }
    }

    public int maxDepth()
    {
        if(this.head!=null)
        return maxDepth(this.head,0);
        return Integer.MIN_VALUE;
    }
    private int maxDepth(tree.BinaryTreeNode node,int h)
    {
        if(node.getLeft()!=null && node.getRight()!=null)
            return Math.max(maxDepth(node.getLeft(),h+1),maxDepth(node.getRight(),h+1));
        if(node.getLeft()!=null)
            return maxDepth(node.getLeft(),h+1);
        if(node.getRight()!=null)
            return maxDepth(node.getRight(),h+1);
        return h;
    }

    public void mirror_the_tree()
    {
        if(this.head!=null)
            mirrorTheNode(this.head);
    }

    private void mirrorTheNode(tree.BinaryTreeNode node)
    {
        tree.BinaryTreeNode left = node.getLeft();
         tree.BinaryTreeNode right=node.getRight();
        if(left!=null)
        {
            mirrorTheNode(left);
            node.setRight(left);
        }
        if(right!=null)
        {
            mirrorTheNode(right);
            node.setLeft(right);
        }

    }


    protected void addNewNode(tree.BinaryTreeNode currentNode, tree.BinaryTreeNode newNode)
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

    protected tree.BinaryTreeNode createNode(int value)
    {
        return new tree.BinaryTreeNode(value);
    }

    private void getorderedList(tree.BinaryTreeNode currNode, LinkedList<Integer> list)
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

    private void getPostorderedList(tree.BinaryTreeNode currNode, LinkedList<Integer> list)
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
    private void getPreorderedList(tree.BinaryTreeNode currNode, LinkedList<Integer> list)
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

    private void getTwistedOrderedList(tree.BinaryTreeNode currNode, LinkedList<Integer> list, boolean twist)
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
        tree.BinaryTreeNode node = this.head;
        StringBuffer sb = new StringBuffer();

        if(node!=null)
        publishToBuffer(node,sb);
                return sb.toString();
    }

    final String seperator = System.getProperty("line.separator");

    void publishToBuffer(tree.BinaryTreeNode node, StringBuffer sb)
    {
        sb.append(seperator);
        sb.append(node.getVal());
        if(node.getLeft()!=null)
        publishToBuffer(node.getLeft(),sb);
        if(node.getRight()!=null)
        publishToBuffer(node.getRight(),sb);
    }


    public tree.BinaryTreeNode getHead() {
        return head;
    }

    public void setHead(tree.BinaryTreeNode head) {
        this.head = head;
    }

    public String toString()
    {
     return  actualTrueTreeFormed();
    }
}
