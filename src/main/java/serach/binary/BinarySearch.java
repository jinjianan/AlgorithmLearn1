package serach.binary;

public class BinarySearch {

    private BinarySearch() {
    }

    public static <T extends Comparable<T>> int search(T[] arr, T t) {
        return searchRecursion(arr, 0, arr.length - 1, t);
    }

    public static <T extends Comparable<T>> int searchRecursion(T[] arr, int l, int r, T t) {
        if (r < l) return -1;
        int mid = (r - l) / 2 + l;
        if (arr[mid].compareTo(t) == 0) return mid;
        else if (arr[mid].compareTo(t) > 0) return searchRecursion(arr, l, mid - 1, t);
        else return searchRecursion(arr, mid + 1, r, t);
    }

    public static <T extends Comparable<T>> int search2(T[] arr, T t) {

        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int mid = (r - l) / 2;
            if (arr[mid].compareTo(t) == 0) return mid;
            if (arr[mid].compareTo(t) > 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

}
