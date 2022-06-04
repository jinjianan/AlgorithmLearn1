package serach.linear_search;

import util.ArrayGenerator;

public class LinearSearch {

    private LinearSearch() {
    }

    /*
        线性查找
        返回目标在数组中的索引
        如果目标不存在，则返回-1
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
/*        Student[] data = {new Student("张三"),
                new Student("李四"),
                new Student("王五"),
        };
        int res = LinearSearch.search(data, new Student("张三"));
        System.out.println(res);
        int res1 = LinearSearch.search(data, new Student("哈哈"));
        System.out.println(res1);*/

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generatorSimpleLinearArray(n);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++)
                LinearSearch.search(data, n);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n= " + n + " , 100 runs :" + time + " s");
        }

    }
}
