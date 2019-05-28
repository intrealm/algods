package src.main.java.graph;

import java.util.*;

public class GNodeV3<T> {

    private T val;

    private Map<T,GNodeV3<T>> leadsTo;

    private GNodeV3<T> leadFrom;

    private boolean doesItMakeAnySense;

    public GNodeV3(T val)
    {
        this.val=val;
        this.leadsTo= new HashMap();
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Map<T, GNodeV3<T>> getLeadsTo() {
        return leadsTo;
    }

    public void setLeadsTo(Map<T, GNodeV3<T>> leadsTo) {
        this.leadsTo = leadsTo;
    }

    public GNodeV3<T> getLeadFrom() {
        return leadFrom;
    }

    public void setLeadFrom(GNodeV3<T> leadFrom) {
        this.leadFrom = leadFrom;
    }

    public boolean isDoesItMakeAnySense() {
        return doesItMakeAnySense;
    }

    public void setDoesItMakeAnySense(boolean doesItMakeAnySense) {
        this.doesItMakeAnySense = doesItMakeAnySense;
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        GNodeV3<T> node = GNodeV3.this;
        Stack<String> stack  =new Stack<>();
        do {
            stack.push(node.getVal().toString());
            node=node.leadFrom;
        }
        while(node!=null);
        while(!stack.isEmpty())
            buff.append(stack.pop());
        return buff.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GNodeV3)) return false;
        GNodeV3<?> gNodeV2 = (GNodeV3<?>) o;
        return isDoesItMakeAnySense() == gNodeV2.isDoesItMakeAnySense() &&
                getVal().equals(gNodeV2.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal(), isDoesItMakeAnySense());
    }
}
