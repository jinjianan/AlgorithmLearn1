package sort.selection;

import util.ArrayGenerator;
import util.SortingHelper;

import static util.SortingHelper.SELECT_SORT;

public class SelectionSort {

    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0)
                    minIndex = j;
            }
            E temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

//        Integer[] data = {66, 1, 32, 45, 5};
//        Student[] data = {new Student("A",123),
//                new Student("B",342),
//                new Student("C",1245),
//                new Student("B",1)
//        };
//        Integer[data]
//        sort(data);
//        for (var i : data) {
//            System.out.println(i);
//        }

//        int[] size = {1000000,10000000,100000000};
        int[] size = {10000,100000};
        for (int s : size) {
            Integer[] arr = ArrayGenerator.generatorRandomArray(s,s);
//            System.out.println(Arrays.asList(arr));
            SortingHelper.sortTest(SELECT_SORT,arr);
//            System.out.println(Arrays.asList(arr));
        }

    }
}
