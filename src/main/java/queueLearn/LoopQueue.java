package queueLearn;

public class LoopQueue<T> implements Queue<T> {

    private Object[] data;
    private int front;
    private int tail;
    private int size;
    private int capacity;

    private static final int MIN_CAPACITY = 5;

    public LoopQueue(int newCapacity) {
        capacity = Math.max(newCapacity, MIN_CAPACITY);
        data = new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(MIN_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public T element(Object o) {
        return (T) o;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        front = 0;
        tail = size;
        capacity = newCapacity;
        data = newData;
    }

    @Override
    public void enqueue(T t) {
        if (isFull()) resize(capacity * 2);

        data[tail] = t;
        size++;
        tail = (tail + 1) % data.length;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("队列空");
        T t = element(data[front]);
        data[front] = null;
        front =  (front + 1) % data.length;;
        size--;
        if (size == capacity / 4 && capacity / 2 >= MIN_CAPACITY) resize(capacity / 2);
        return t;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列空");
        return element(data[front]);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail - front == 0;
    }

    private boolean isFull() {
//        return (tail + 1)% capacity == front;
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size %d , capacity = %d \n", size, capacity));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(front+i)%data.length].toString());
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
//        ArrayQueue<Integer> queue = new ArrayQueue<>();
        LoopQueue<Integer> queue = new LoopQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

/*            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }*/
        }
        System.out.println();
    }
}
