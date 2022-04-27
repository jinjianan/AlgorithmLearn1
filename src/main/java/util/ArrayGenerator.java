package util;

public class ArrayGenerator {

    public static Integer[] generatorSimpleLinearArray(int n){
        Integer[] r = new Integer[n];
        for (int i = 0; i < r.length; i++) {
            r[i] = i;
        }
        return r;
    }

}
