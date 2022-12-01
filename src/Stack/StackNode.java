package Stack;

public class StackNode<T> {
    private T obj;
    private StackNode<T> next;

    public StackNode() {
    }

    public StackNode(StackNode<T> next) {
        this.next = next;
    }

    public StackNode(T obj, StackNode<T> next) {
        this.obj = obj;
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}

