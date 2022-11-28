package Pilha;

public class PilhaVetor<T> implements Pilha<T>{

    private int counter = -1;
    private static int tamanho = 10;
    private T[] vet;

    public PilhaVetor(int tamanho) {
        this.vet = (T[]) new Object[tamanho];
    }

    public PilhaVetor() {
        this(tamanho);
    }

    @Override
    public void push(T obj) throws Exception {
        if(this.counter < this.vet.length && !isFull()){
            this.vet[++this.counter] = obj;
        }
    }

    @Override
    public T pop() throws Exception {
        if(this.empty()){
            return null;
        }
        return this.vet[this.counter--];
    }

    public T top() throws Exception {
        if(this.empty()){
            return null;
        }
        return this.vet[this.counter];
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
            this.vet = null;
            this.counter = -1;
        }
    }

    @Override
    public boolean isFull() {
        return counter == vet.length-1;
    }
}
