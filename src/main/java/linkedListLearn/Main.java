package linkedListLearn;

import linkedListLearn.LinkedList;

public class Main {

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        LinkedListWork<Integer> linkedList = new LinkedListWork<>();
        LinkedListWork1<Integer> linkedList = new LinkedListWork1<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 555);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
