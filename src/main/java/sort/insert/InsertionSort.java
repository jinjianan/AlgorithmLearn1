package sort.insert;

import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        //多次swap
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j - 1 >= 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
                swap(data, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        for (int i = 0; i < data.length; i++) {
            E o = data[i];
            int j;
            for (j = i; j - 1 >= 0 && o.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = o;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data, int l, int r) {

        for (int i = l; i <= r; i++) {
            E o = data[i];
            int j;
            for (j = i; j - 1 >= l && o.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = o;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {

        for (int i = data.length - 1; i >= 0; i--) {
            E o = data[i];
            int j;
            for (j = i; j + 1 < data.length && o.compareTo(data[j + 1]) > 0; j++) {
                data[j] = data[j + 1];
            }
            data[j] = o;
        }

    }

    private static <E> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] size = {10000, 100000};
        for (int i : size) {
            Integer[] data = ArrayGenerator.generatorRandomArray(i, i);
            Integer[] data2 = Arrays.copyOf(data, data.length);
            Integer[] data3 = Arrays.copyOf(data, data.length);
//            SortingHelper.sortTest(SortingHelper.INSERTION_SORT, data);
            SortingHelper.sortTest(SortingHelper.INSERTION_SORT_2, data2);
            SortingHelper.sortTest(SortingHelper.INSERTION_SORT_3, data3);
        }
    }
}
