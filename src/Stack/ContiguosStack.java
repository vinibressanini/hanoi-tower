package Stack;

public class ContiguosStack<T> implements IStack<T> {

    private int counter = -1;
    private static int stackSize = 10;
    private T[] array;

    public ContiguosStack(int stackSize) {
        this.array = (T[]) new Object[stackSize];
    }

    public ContiguosStack() {
        this(stackSize);
    }

    @Override
    public void push(T obj) throws Exception {
        if(this.counter < this.array.length && !isFull()){
            this.array[++this.counter] = obj;
        }
    }

    @Override
    public T pop() throws Exception {
        if(this.empty()){
            return null;
        }
        return this.array[this.counter--];
    }

    public T top() throws Exception {
        if(this.empty()){
            return null;
        }
        return this.array[this.counter];
    }

    public int size() throws Exception{
        if(this.empty()){
            return 0;
        }
        return this.counter+1;
    }

    @Override
    public boolean empty() {
        return this.counter == -1;
    }

    @Override
    public void release() {
        if (!this.empty()) {
            this.array = null;
            this.counter = -1;
        }
    }

    @Override
    public boolean isFull() {
        return counter == array.length-1;
    }
}
