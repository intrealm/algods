package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class NaryTree{


    static final String LINE_SERERATOR = System.getProperty("line.seperator");

    NaryTreeNode head;

    public NaryTree(NaryTreeNode head)
    {
        this.head= head;
    }

    public List<Integer> getPreOrderList()
    {
        if(this.head==null)
            return Collections.EMPTY_LIST;
        LinkedList list = new LinkedList<>();
        getPreOrderList(list,this.head);
        return list;
    }


    public List<Integer> getPostOrderList()
    {
        if(this.head==null)
            return Collections.EMPTY_LIST;
        LinkedList list = new LinkedList<>();
        getPreOrderList(list,this.head);
        return list;
    }

    private void getPreOrderList(List lst,NaryTreeNode node)
    {
        lst.add(node.getVal());
        if(node.getChildren()!=null)
            for(NaryTreeNode child: node.getChildren())
                getPreOrderList(lst,child);
    }

    private void getPostOrderList(List lst,NaryTreeNode node)
    {
        lst.add(node.getVal());
        if(node.getChildren()!=null)
            for(NaryTreeNode child: node.getChildren())
                getPostOrderList(lst,child);
    }

    public static String seriazedString(NaryTree tree)
    {
        return seriableString(tree.head).toString();
    }
    private static StringBuffer seriableString(NaryTreeNode tree)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(tree.getVal()+":");

        sb.append("[");
        if(tree.getChildren()!=null&& !tree.getChildren().isEmpty())
        {
            for(NaryTreeNode child:tree.getChildren())
            {
                sb.append(seriableString(child));
                sb.append(",");
            }
            sb.setLength(sb.length()-1);
        }
        sb.append("]");
        //start parameter  {
        //end parameter }
        //children :
        //{10:{
        //      20:{
        //          10:{
        //              5:{},
        //              4:{}},
        //          30:{}
        //          }
        //      60:{}
        //     }
        //}

        return sb;
    }

    public static NaryTree deseriazedString(String input)
    {
        NaryTreeNode head = deserializeChild(input);
        NaryTree tree = new NaryTree(head);
        return tree;
    }



    private static NaryTreeNode deserializeChild(final String withoutFillers)
    {
      int x = withoutFillers.indexOf(':');
      String valueStrin = withoutFillers.substring(0,x);
      int val = Integer.parseInt(valueStrin);
      NaryTreeNode currNode = new NaryTreeNode(val);
      //identify children [{a:[]},{b:[{}]}]
        //count children
        String childrenString = withoutFillers.substring(x+2,withoutFillers.length());
        //count for child
        if(childrenString.length()>=2)
        {
            // search divide for childrens
            List<NaryTreeNode> childNodes = currNode.getChildren();
            int openingBrac = 0;
            int startingPointForCurrChild = 0;
            for(int i=0;i<childrenString.length()-1;i++)
            {
                char currChar = childrenString.charAt(i);
                if(childrenString.charAt(i)=='[')
                {
                    openingBrac++;
                }
                else if(childrenString.charAt(i)==']')
                {
                    openingBrac--;
                    if(openingBrac==0)
                    {
                        String childString = childrenString.substring(startingPointForCurrChild,i+1);
                        childNodes.add(deserializeChild(childString));
                        startingPointForCurrChild=i+2;
                    }
                }
            }
        }
      return currNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaryTree)) return false;
        NaryTree naryTree = (NaryTree) o;

        NaryTreeNode otherNode =naryTree.head;
        NaryTreeNode node = this.head;
        if(otherNode!=null && node!=null)
            compareNodes(otherNode,node);
        return true;
    }

    private static boolean compareNodes( NaryTreeNode obj1, NaryTreeNode obj2)
    {
        if(obj1.getVal()!=obj2.getVal()
        || (Objects.isNull(obj1.getChildren()) && !Objects.isNull(obj2.getChildren()))
        || (!Objects.isNull(obj1.getChildren()) && Objects.isNull(obj2.getChildren()))
        ||(obj1.getChildren().size()==obj2.getChildren().size())
        )
            return false;
        List<NaryTreeNode> list1 = obj1.getChildren();
        List<NaryTreeNode> list2 = obj1.getChildren();
        int size = list1.size();
        for(int i=0;i<size;i++)
        {
            if(compareNodes(list1.get(i),list2.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

}
