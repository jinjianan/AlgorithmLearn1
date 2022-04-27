package util;

import java.util.Random;

public class ArrayGenerator {

    public static Integer[] generatorSimpleLinearArray(int n) {
        Integer[] r = new Integer[n];
        for (int i = 0; i < r.length; i++) {
            r[i] = i;
        }
        return r;
    }

    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] r = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < r.length; i++) {
            r[i] = random.nextInt(bound);
        }
        return r;
    }

}
