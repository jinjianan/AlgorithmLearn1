package stackLearn;

public interface Stack<T> {

    void push(T t);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

}
