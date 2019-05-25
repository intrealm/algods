package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class NaryTreeNode {

    int val;

    List<NaryTreeNode> children;

    public NaryTreeNode(int val) {
        this.val = val;
        this.children= new LinkedList<>();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<NaryTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<NaryTreeNode> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaryTreeNode)) return false;
        NaryTreeNode that = (NaryTreeNode) o;
        return getVal() == that.getVal() && Objects.equals(getChildren(), that.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal(), getChildren()!=null?getChildren().size():0);
    }

    @Override
    public String toString() {
        return "NaryTreeNode{" +
                "val=" + val +
                '}';
    }
}
