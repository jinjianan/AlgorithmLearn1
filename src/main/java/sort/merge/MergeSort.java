package sort.merge;


import sort.insert.InsertionSort;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;
import java.util.Random;

import static util.SortingHelper.MERGE_SORT;
import static util.SortingHelper.MERGE_SORT2;

public class MergeSort<T> {

    private MergeSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        T[] temp = Arrays.copyOf(arr, arr.length);
        sortRecursion(arr, 0, arr.length - 1,temp);
//        sortRecursionDesc(arr, 0, arr.length - 1, 1);
    }

    /**
     * 归并排序迭代方法
     *
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void sortRecursion(T[] arr, int l, int r,T[] temp) {
        if (r - l == 0) return;
        int mid = (r + l) / 2;
        sortRecursion(arr, l, mid,temp);
        sortRecursion(arr, mid + 1, r,temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r,temp);
    }

    public static <T extends Comparable<T>> void sort2(T[] arr) {
        sortRecursion2(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序迭代方法
     *
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void sortRecursion2(T[] arr, int l, int r) {
        if (r - l == 0) return;
        int mid = (r + l) / 2;
        sortRecursion2(arr, l, mid);
        sortRecursion2(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    /**
     * 归并排序迭代方法 + depth调试
     *
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void sortRecursionDesc(T[] arr, int l, int r, int depth) {
        int label = new Random().nextInt(10);
        System.out.print(generateDepthText(depth) + "LABEL->" + label);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
        if (r - l == 0) return;
        int mid = (r + l) / 2;
        sortRecursionDesc(arr, l, mid, depth + 1);
        sortRecursionDesc(arr, mid + 1, r, depth + 1);
        merge(arr, l, mid, r);
        System.out.print(generateDepthText(depth) + "LABEL->" + label);
        System.out.println("after merge : " + Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
    }


    private static String generateDepthText(int depth) {
        StringBuilder res = new StringBuilder();
        res.append("----".repeat(Math.max(0, depth)));
        return res.toString();
    }
    private static <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r, T[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int j = l;
        int k = mid + 1;
        for (int i = l; i <= r; i++) {
            if (j > mid) {
                arr[i] = temp[k];
                k++;
            } else if (k > r) {
                arr[i] = temp[j];
                j++;
            } else if (temp[j].compareTo(temp[k]) <= 0) {
                arr[i] = temp[j];
                j++;
            } else {
                arr[i] = temp[k];
                k++;
            }
        }
    }
    private static <T extends Comparable<T>> void   merge(T[] arr, int l, int mid, int r) {
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

        int[] size = {5000000};
        for (int s : size) {
            Integer[] arr = ArrayGenerator.generatorRandomArray(s, s);
//            Integer[] arr = ArrayGenerator.generatorSimpleLinearArray(s);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(MERGE_SORT, arr);
            SortingHelper.sortTest(MERGE_SORT2, arr1);
        }
    }
}
