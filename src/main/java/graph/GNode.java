package src.main.java.graph;

import java.util.ArrayList;
import java.util.Collection;

public class GNode {

    private int val;

    private Collection<GNode> nexts;

    public GNode(int val)
    {
        this.val=val;
        nexts=new ArrayList<>();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Collection<GNode> getNexts() {
        return nexts;
    }

}
