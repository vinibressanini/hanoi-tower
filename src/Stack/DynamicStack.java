package Stack;

public class DynamicStack<T> implements IStack<T> {
    private StackKnot<T> last;
    private int counter = 0;

    @Override
    public void push(T obj) {
        if(empty()) {
            StackKnot<T> item = new StackKnot<T>(obj, null);
            last = item;
            counter++;
        } else {
            StackKnot<T> item = new StackKnot<T>(obj, last);
            last = item;
            counter++;
        }
    }

    @Override
    public T pop() {
        T value = last.getObj();
        last = last.getNext();
        counter--;
        return value;
    }

    @Override
    public T top() {
        return last.getObj();
    }

    @Override
    public int size()  {
        return counter;
    }

    @Override
    public boolean empty() {
        return counter == 0;
    }

    @Override
    public void release() {
        last = null;
        counter = 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
