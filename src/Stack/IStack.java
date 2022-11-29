package Stack;

public interface IStack<T> {
    void push(T obj);
    T pop () ;
    T top () ;
    int size();
    boolean empty();
    void release();
    boolean isFull();
}

