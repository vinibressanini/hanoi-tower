package Stack;

public class StackKnot<T> {
    private T obj;
    private StackKnot<T> next;

    public StackKnot(T obj, StackKnot<T> next) {
        this.obj = obj;
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public StackKnot<T> getNext() {
        return next;
    }

    public void setNext(StackKnot<T> next) {
        this.next = next;
    }
}

