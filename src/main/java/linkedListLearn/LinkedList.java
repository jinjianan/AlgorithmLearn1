package linkedListLearn;

public class LinkedList<E> {

    private int size;

    private Node dummyHead;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException("越界");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
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
        if (index < 0 || index > size) throw new IllegalArgumentException("越界");
        Node now = dummyHead.next;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return now.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException("越界");
        Node now = dummyHead.next;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        now.e = e;
    }

    public boolean contains(E e) {
        Node now = dummyHead;
        while (now != null) {
            if (now.e.equals(e)) return true;
            else now = now.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("越界");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node now = prev.next;
        prev.next = now.next;
        now.next = null;
        size--;
        return now.e;
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
