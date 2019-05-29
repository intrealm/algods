package src.main.java.tree;

import java.util.Objects;

public class GenericBinaryNode<T extends Comparable> implements  Comparable<GenericBinaryNode>{

    private T val;

    private GenericBinaryNode<T> left;

    private GenericBinaryNode<T> right;

    public GenericBinaryNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public GenericBinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(GenericBinaryNode<T> left) {
        this.left = left;
    }

    public GenericBinaryNode<T> getRight() {
        return right;
    }

    public void setRight(GenericBinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericBinaryNode)) return false;
        GenericBinaryNode<?> that = (GenericBinaryNode<?>) o;
        return Objects.equals(getVal(), that.getVal());
    }

    @Override
    public String toString()
    {
        return this.val.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }

    @Override
    public int compareTo(GenericBinaryNode o) {
        return this.val.compareTo(o.val);
    }
}
