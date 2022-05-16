package sort.merge;


import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;
import java.util.Random;

import static util.SortingHelper.MERGE_SORT;

public class MergeSort<T> {

    private MergeSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
//        sortRecursion(arr, 0, arr.length - 1);
        sortRecursionDesc(arr, 0, arr.length - 1, 1);
    }

    private static <T extends Comparable<T>> void sortRecursion(T[] arr, int l, int r) {
        if (r - l == 0) return;
        int mid = (r + l) / 2;
        sortRecursion(arr, l, mid);
        sortRecursion(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static <T extends Comparable<T>> void sortRecursionDesc(T[] arr, int l, int r, int depth) {
        int label =  new Random().nextInt(10);
        System.out.print(generateDepthText(depth) + "LABEL->" +label);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
        if (r - l == 0) return;
        int mid = (r + l) / 2;
        sortRecursionDesc(arr, l, mid, depth + 1);
        sortRecursionDesc(arr, mid + 1, r, depth + 1);
        merge(arr, l, mid, r);
        System.out.print(generateDepthText(depth) + "LABEL->" +label);
        System.out.println("after merge : " + Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
    }

    private static String generateDepthText(int depth) {
        StringBuilder res = new StringBuilder();
        res.append("----".repeat(Math.max(0, depth)));
        return res.toString();
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
        int j = l;
        int k = mid + 1;
        T[] temp = Arrays.copyOfRange(arr, l, r + 1);
        for (int i = l; i <= r; i++) {
            if (j > mid) {
                arr[i] = temp[k - l];
                k++;
            } else if (k > r) {
                arr[i] = temp[j - l];
                j++;
            } else if (temp[j - l].compareTo(temp[k - l]) <= 0) {
                arr[i] = temp[j - l];
                j++;
            } else {
                arr[i] = temp[k - l];
                k++;
            }
        }
    }

    public static void main(String[] args) {

        int[] size = {5};
        for (int s : size) {
            Integer[] arr = ArrayGenerator.generatorRandomArray(s, s);
            SortingHelper.sortTest(MERGE_SORT, arr);
        }
    }
}
