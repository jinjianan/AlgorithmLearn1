package sort;

import sort.insert.InsertionSort;
import sort.selection.SelectionSort;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;
import java.util.Random;

import static util.SortingHelper.*;

public class PartitionSort {

    private PartitionSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        Random random = new Random();
        partitionRecursion(arr, 0, arr.length - 1, random);
    }

    public static <T extends Comparable<T>> void partitionRecursion(T[] arr, int l, int r, Random random) {
        if (r <= l) return;
        int mid = l;
        swap(arr, l, l + random.nextInt(r - l + 1));
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                mid++;
                if (mid != i) swap(arr, i, mid);
            }
        }
        swap(arr, l, mid);

        partitionRecursion(arr, l, mid - 1, random);
        partitionRecursion(arr, mid + 1, r, random);

    }

    public static <T extends Comparable<T>> void sort2(T[] arr) {
        partitionRecursion2(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void partitionRecursion2(T[] arr, int l, int r) {
        if (r <= l) return;
        int i = l + 1;
        int j = r;
        swap(arr, l, l + new Random().nextInt(r - l + 1));
        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0)
                i++;

            while (j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;

            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        partitionRecursion2(arr, l, j - 1);
        partitionRecursion2(arr, j + 1, r);

    }

    public static <T extends Comparable<T>> void sort3(T[] arr) {
        partitionRecursion3(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void partitionRecursion3(T[] arr, int l, int r) {
        if (r <= l) return;
        int i = l + 1;
        int lt = l;
        int gt = r + 1;
        swap(arr, l, l + new Random().nextInt(r - l + 1));
        while (i < gt) {
            if (arr[l].compareTo(arr[i]) > 0) {
                lt++;
                if (lt != i)swap(arr,lt,i);
                i++;
            } else if (arr[l].compareTo(arr[i]) < 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }

        swap(arr, l, lt);
        partitionRecursion3(arr, l, lt - 1);
        partitionRecursion3(arr, gt, r);

    }

    public static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int[] size = {100000};
        for (int s : size) {
            Integer[] arr;
//            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//            SortingHelper.sortTest(PARTITION_SORT, arr);
//            SortingHelper.sortTest(PARTITION_DOUBLE_SORT, arr2);
//
//            arr = ArrayGenerator.generatorSimpleLinearArray(s);
//            arr2 = Arrays.copyOf(arr, arr.length);
//            SortingHelper.sortTest(PARTITION_SORT, arr);
//            SortingHelper.sortTest(PARTITION_DOUBLE_SORT, arr2);
//
//            arr = ArrayGenerator.generatorRandomArray(s, 1);
//            arr2 = Arrays.copyOf(arr, arr.length);
////            SortingHelper.sortTest(PARTITION_SORT, arr);
//            SortingHelper.sortTest(PARTITION_DOUBLE_SORT, arr2);

            arr = ArrayGenerator.generatorRandomArray(s, s);
            SortingHelper.sortTest(PARTITION_THREE_SORT, arr);

        }
    }

}
