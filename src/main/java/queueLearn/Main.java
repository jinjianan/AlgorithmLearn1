package queueLearn;

public class Main {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.enqueue(32);
        queue.enqueue(32);
        queue.enqueue(32);

        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue);
    }

}
