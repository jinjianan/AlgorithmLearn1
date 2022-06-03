package sort;

import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

import static util.SortingHelper.*;

public class PartitionSort {

    private PartitionSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        partitionRecursion(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void partitionRecursion(T[] arr, int l, int r) {
        if (r - l <= 0) return;
        int mid = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                mid++;
                if (mid != i) swap(arr, i, mid);
            }
        }
        swap(arr, l, mid);

        partitionRecursion(arr, l, mid - 1);
        partitionRecursion(arr, mid + 1, r);

    }

    public static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        T temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int[] size = {10000000};
        for (int s : size) {
            Integer[] arr = ArrayGenerator.generatorRandomArray(s, s);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(PARTITION_SORT, arr);
            SortingHelper.sortTest(MERGE_SORT3, arr1);
        }
    }

}
