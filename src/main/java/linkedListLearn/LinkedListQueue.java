package linkedListLearn;
import queueLearn.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = tail = null;
        size = 0;
    }

    private void addLast(E e) {
        if (size == 0) head = tail = new Node(e);
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    private E getFirst() {
        if (size == 0) throw new IllegalArgumentException("队列为空");
        return head.e;
    }

    private E removeFirst() {
        if (size == 0) throw new IllegalArgumentException("队列为空");
        Node t = head;
        head = head.next;
        t.next = null;
        if (head == null)
            tail = null;
        size--;
        return t.e;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedListQueue size %d \n", size));
        Node now =head;
        res.append("front[");
        while (now != null) {
            res.append(now.e.toString()).append("-> ");
            now = now.next;
        }
        res.append("end]");
        return res.toString();
    }

    @Override
    public void enqueue(E t) {
        this.addLast(t);
    }

    @Override
    public E dequeue() {
        return this.removeFirst();
    }

    @Override
    public E getFront() {
        return this.getFirst();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
        System.out.println();
    }
}
