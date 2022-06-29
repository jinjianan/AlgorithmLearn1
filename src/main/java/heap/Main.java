package heap;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 0; i < n - 1; i++)
            if (arr[i] < arr[i+1])
                throw new IllegalArgumentException("error");

        System.out.println("success");

    }
}
