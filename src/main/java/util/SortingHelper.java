package util;

import sort.PartitionSort;
import sort.insert.InsertionSort;
import sort.merge.MergeSort;
import sort.selection.SelectionSort;

public class SortingHelper {
    public static final String SELECT_SORT = "SelectSort";
    public static final String INSERTION_SORT = "InsertionSort";
    public static final String INSERTION_SORT_2 = "InsertionSort2";
    public static final String INSERTION_SORT_3 = "InsertionSort3";

    public static final String MERGE_SORT = "MergeSort";
    public static final String MERGE_SORT2 = "MergeSort2";
    public static final String MERGE_SORT3 = "MergeSort3";
    public static final String PARTITION_SORT = "Partition";
    public static final String PARTITION_DOUBLE_SORT = "DoublePartition";
    public static final String PARTITION_THREE_SORT = "ThreePartition";

    private SortingHelper() {
    }

    /**
     * 检测选择排序结果是否正确
     *
     * @param data
     * @param <E>
     * @return true 正确  ; false 不正确
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] data) {
        long start = System.nanoTime();
        if (sortName.equals(SELECT_SORT)) {
            //实现方式1
            SelectionSort.sort(data);
            //实现方式2
//            SelectionSort.sort2(data);
        }
        else if (sortName.equals(INSERTION_SORT)){
            InsertionSort.sort(data);
        }
        else if (sortName.equals(INSERTION_SORT_2)){
            InsertionSort.sort2(data);
        }
        else if (sortName.equals(INSERTION_SORT_3)){
            InsertionSort.sort3(data);
        }
        else if (sortName.equals(MERGE_SORT)){
            MergeSort.sort(data);
        }
        else if (sortName.equals(MERGE_SORT2)){
            MergeSort.sort2(data);
        }
        else if (sortName.equals(MERGE_SORT3)){
            MergeSort.sort3(data);
        }else if (sortName.equals(PARTITION_SORT)){
            PartitionSort.sort(data);
        }else if (sortName.equals(PARTITION_DOUBLE_SORT)){
            PartitionSort.sort2(data);
        }else if (sortName.equals(PARTITION_THREE_SORT)){
            PartitionSort.sort3(data);
        }
        long end = System.nanoTime();
        boolean resultCheck = SortingHelper.isSorted(data);
        double time = (end - start) / 1000000000.0;
        String describe = String.format("%s ,size [%d] ,result [%b], time [%f s]", sortName,data.length, resultCheck, time);
        System.out.println(describe);
    }

}
