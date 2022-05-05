package queueLearn;

public class Deque<T> {

    private Object[] data;

    private int front, last;
    private int fTail, lTail;

    private int size;

    private int capacity;

    private static final int MIN_CAPACITY = 5;

    public Deque(int capacity) {
        data = new Object[Math.max(capacity, MIN_CAPACITY)];
        front = last = lTail = fTail = 0;
        size = 0;
        this.capacity = data.length;
    }

    public Deque() {
        this(MIN_CAPACITY);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % capacity];
        }
        data = newData;
        front = 0;
        fTail = newCapacity - 1;
        last = size - 1;
        lTail = size;
        this.capacity = newCapacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void addFront(T t) {
        if (isFull())
            resize(capacity * 2);
        data[fTail] = t;
        front = fTail;
        if (front == lTail) lTail = (lTail + 1) % capacity;
        fTail = front - 1 < 0 ? capacity - 1 : front - 1;
        size++;
    }

    public void addLast(T t) {
        if (isFull())
            resize(capacity * 2);
        data[lTail] = t;
        last = lTail;
        if (last == fTail) fTail = front - 1 < 0 ? capacity - 1 : front - 1;
        lTail = (lTail + 1) % capacity;
        size++;
    }

    public T removeFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列空");
        T t = element(data[front]);
        data[front] = null;
        front = (front + 1) % capacity;
        fTail = front - 1 < 0 ? capacity - 1 : front - 1;
        size--;
        if (size == capacity / 4 && capacity / 2 > MIN_CAPACITY)
            resize(capacity / 2);
        return t;
    }

    public T removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("队列空");
        T t = element(data[last]);
        data[last] = null;
        last = last - 1 < 0 ? capacity - 1 : last - 1;
        lTail = (last + 1) % capacity;
        size--;
        if (size == capacity / 4 && capacity / 2 > MIN_CAPACITY)
            resize(capacity / 2);
        return t;
    }

    @SuppressWarnings("unchecked")
    private T element(Object o) {
        return (T) o;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque size: %d, capacity: %d \n", size, capacity));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(front + i) % capacity]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] last\n");
        res.append(String.format("info front: %d, ftail: %d, last: %d, ltail: %d\n", front, fTail, last, lTail));
        return res.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> q = new Deque<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                q.addFront(i);
            else
                q.addLast(i);
            System.out.println(q);
        }

        for (int i = 0; i < q.size; i++) {
            if (i % 2 == 0)
                q.removeFront();
            else
                q.removeLast();
            System.out.println(q);
        }
    }
}
