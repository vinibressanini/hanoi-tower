package Stack;

public class ContiguosStack<T> implements IStack<T> {

    private int counter = 0, size;
    private T[] array;

    public ContiguosStack(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    @Override
    public void push(T obj) {
        if (!isFull()) {
            this.array[counter] = obj;
            counter++;
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            counter--;
            T obj = this.array[counter];
            this.array[counter] = null;
            return obj;
        }
        return null;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return this.array[counter - 1];
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean isFull() {
        return counter == size;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[this.size];
        counter = 0;
    }
}
