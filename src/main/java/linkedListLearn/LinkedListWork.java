package linkedListLearn;

public class LinkedListWork<E> {
    private int size;

    private Node dummyHead;

    public LinkedListWork() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node findNode(Node head, int index) {
        if (head == null) throw new IllegalArgumentException("index wrong");
        if (index == 0) return head;
        return findNode(head.next, index - 1);
    }

    public void add(int index, E e) {
        Node prev = findNode(dummyHead, index);
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        return findNode(dummyHead.next, index).e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        findNode(dummyHead.next, index).e = e;
    }

    public boolean contains(E e) {
        return contains(dummyHead.next, e);
    }

    private boolean contains(Node now, E e) {
        if (now == null) return false;
        if (now.e == e) return true;
        return contains(now.next, e);
    }

    public E remove(int index) {
        Node prev = findNode(dummyHead, index);
        if (prev.next == null)
            throw new IllegalArgumentException("wrong index");
        Node next = prev.next;
        prev.next = next.next;
        size--;
        return next.e;
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
        Node now = dummyHead.next;
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
