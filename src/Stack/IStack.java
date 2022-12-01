package Stack;

public interface IStack<T> {
    void push(T obj);
    T pop () ;
    T top () ;
    int size();
    boolean isEmpty();
    void clear();
    boolean isFull();
}

