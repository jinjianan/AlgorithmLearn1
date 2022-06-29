package heap;

public class HeapSort {

    private HeapSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){
        MaxHeap<E> heap = new MaxHeap<>();
        for(var e : data)
            heap.add(e);

        for (int i = data.length - 1; i>=0; i--)
            data[i] = heap.extractMax();
    }

    public static <E extends Comparable<E>> void sort2(E[] data){
        MaxHeap<E> heap = new MaxHeap<>(data);

        for (int i = data.length - 1; i>=0; i--)
            data[i] = heap.extractMax();
    }
}
