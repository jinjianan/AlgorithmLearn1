package MapLearn;

public class Main {

    public static void main(String[] args) {
        Map<String , Integer> map = new BSTMap<>();
        map.add("a",1);
        map.add("b",2);
        map.add("c",3);
        System.out.println(map.getSize());

        map.remove("c");
        System.out.println(map.getSize());

        map.remove("a");
        System.out.println(map.getSize());
        System.out.println(map.get("b"));
    }

}
