package linkedListLearn;

import stackLearn.Stack;

public class LinkedListStack<T> implements Stack<T> {

    LinkedList<T> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(T t) {
        linkedList.addFirst(t);
    }

    @Override
    public T pop() {
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        return linkedList.getFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
