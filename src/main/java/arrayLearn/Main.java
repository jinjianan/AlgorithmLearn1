package arrayLearn;

public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);
        arr.add(2,132);
        System.out.println(arr);
        arr.addFirst(32);
        System.out.println(arr);

        System.out.println(arr.indexOf(2));

        arr.remove(2);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
        arr.removeElement(132);
        System.out.println(arr);
    }

}
