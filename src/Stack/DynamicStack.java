package Stack;

public class DynamicStack<T> implements IStack<T> {
    private StackNode<T> last;
    private int counter = 0;

    public DynamicStack() {}

    @Override
    public void push(T obj) {
        if(isEmpty()) {
            StackNode<T> item = new StackNode<T>(obj, null);
            last = item;
            counter++;
        } else {
            StackNode<T> item = new StackNode<T>(obj, last);
            last = item;
            counter++;
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T value = last.getObj();
            last = last.getNext();
            counter--;
            return value;
        }
        return null;
    }

    @Override
    public T top() {
        if (counter == 0) {
            return null;
        }
        return last.getObj();
    }

    @Override
    public int size()  {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public void clear() {
        last = null;
        counter = 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
