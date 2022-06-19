package tree;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (var num : nums){
            bst.add(num);
        }

        bst.levelOrder();
        bst.removeElement(3);
        System.out.println();
        bst.levelOrder();

    }

}
