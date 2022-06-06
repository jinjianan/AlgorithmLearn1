package serach.binary;

public class BinaryUpperSearch {

    private BinaryUpperSearch() {
    }

    public static <E extends Comparable<E>> int upperSearch(E[] arr, E tar) {
        int res = searchR(arr, 0, arr.length, tar);
        return res == arr.length ? -1 : res;
    }

    public static <E extends Comparable<E>> int searchR(E[] arr, int l, int r, E tar) {
        if (r == l) return l;
        int mid = (r - l) / 2 + l;
        if (arr[mid].compareTo(tar) <= 0)
            return searchR(arr, mid + 1, r, tar);
        return searchR(arr, l, mid, tar);
    }

    // > target 返回最小值索引
    // == target 返回最大索引
    public static <E extends Comparable<E>> int ceilSearch(E[] arr, E tar) {
        int res = searchR(arr, 0, arr.length, tar);
        if (res - 1 > 0 && arr[res - 1].compareTo(tar) == 0)
            return res - 1;
        return res;
    }

    public static <E extends Comparable<E>> int lowerCeilSearch(E[] arr, E tar) {
        return lowerCeilSearchR(arr, 0, arr.length, tar);
    }

    public static <E extends Comparable<E>> int lowerCeilSearchR(E[] arr, int l, int r, E tar) {
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid].compareTo(tar) < 0)
                l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static <E extends Comparable<E>> int lowerBinarySearch(E[] arr, E tar) {
        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid].compareTo(tar) < 0) {
                if (l == mid) l++;
                else l = mid;
            } else r = mid - 1;
        }
        return l;
    }

    public static <E extends Comparable<E>> int lowerFloorBinarySearch(E[] arr, E tar) {
        int p = lowerBinarySearch(arr, tar);
        if (p + 1 < arr.length && arr[p + 1].compareTo(tar) == 0)
            return p + 1;
        return p;
    }

    public static <E extends Comparable<E>> int upperFloorBinarySearch(E[] arr, E tar) {
        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            if (arr[mid].compareTo(tar) <= 0) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public static <E extends Comparable<E>> int findElement(E[] arr, E tar) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l - r) / 2 + l;
            if (arr[mid].compareTo(tar) >= 0) r = mid;
            else l = mid + 1;
        }
        if(l < arr.length && arr[l].compareTo(tar) == 0)
            return l;
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.println(upperFloorBinarySearch(arr, i));
        }
    }
}
