package linkedListLearn;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public class LinkedListWork1<E> {
    private int size;
    private Node head;

    public LinkedListWork1() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        size++;
        this.head = add(head, index, e);
    }

    private Node add(Node node, int index, E e) {
        if (index == 0) return new Node(e, node);
        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) return node.e;
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        set(head, index, e);
    }

    private void set(Node node, int index, E e) {
        if (index == 0) node.e = e;
        else set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node now, E e) {
        if (now == null) return false;
        if (now.e == e) return true;
        return contains(now.next, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getLeft();
        return res.getRight();
    }

    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) return new Pair<>() {
            @Override
            public Node getLeft() {
                return node.next;
            }

            @Override
            public E getRight() {
                return node.e;
            }

            @Override
            public E setValue(E value) {
                return null;
            }
        };
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getLeft();
        return new Pair<>() {
            @Override
            public Node getLeft() {
                return node;
            }

            @Override
            public E getRight() {
                return res.getRight();
            }

            @Override
            public E setValue(E value) {
                return null;
            }
        };
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList size %d \n", size));
        Node now = head;
        res.append("[");
        while (now != null) {
            res.append(now.e.toString()).append("-> ");
            now = now.next;
        }
        res.append("end]");
        return res.toString();
    }

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

}
