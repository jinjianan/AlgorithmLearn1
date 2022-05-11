package queueLearn;

import linkedListLearn.LinkedListQueue;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue Time : " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue Time : " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(loopQueue,opCount);
        System.out.println("LinkedListQueue Time : " + time3 + " s");
    }


    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();
        Random r = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(r.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }



}
