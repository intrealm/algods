package src.main.java.graph;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class GNodeV2<T> {

    private T val;

    private Set<GNodeV2<T>> matchsTo;

    private GNodeV2<T> comesFrom;

    private boolean doesItMakeAnySense;

    public GNodeV2(T val)
    {
        this.val=val;
        this.matchsTo= new HashSet<>();
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Set<GNodeV2<T>> getMatchsTo() {
        return matchsTo;
    }

    public void setMatchsTo(Set<GNodeV2<T>> matchsTo) {
        this.matchsTo = matchsTo;
    }

    public GNodeV2<T> getComesFrom() {
        return comesFrom;
    }

    public void setComesFrom(GNodeV2<T> comesFrom) {
        this.comesFrom = comesFrom;
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
        GNodeV2<T> node = GNodeV2.this;
        Stack<String> stack  =new Stack<>();
        do {
            stack.push(node.getVal().toString());
            node=node.comesFrom;
        }
        while(node!=null);

        while(!stack.isEmpty())
            buff.append(stack.pop());
        return buff.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GNodeV2)) return false;
        GNodeV2<?> gNodeV2 = (GNodeV2<?>) o;
        return isDoesItMakeAnySense() == gNodeV2.isDoesItMakeAnySense() &&
                getVal().equals(gNodeV2.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal(), isDoesItMakeAnySense());
    }
}
