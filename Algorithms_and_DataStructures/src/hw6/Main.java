package hw6;

import java.util.Random;

import lesson6.BST;



public class Main {
        public static void main(String[] args) {

            // Check isBalanced method
            BST<Integer, String> bst = new BST<>();
            bst.put(5, "v");
            bst.put(3, "v");
            bst.put(7, "v");
            bst.put(2, "v");
            bst.put(4, "v");
            bst.put(6, "v");
            bst.put(8, "v");
            System.out.println(bst.isBalanced());



            //Task 1 and Task 2
            Random rn = new Random();
            int maximum = 100;
            int minimum = -100;
            int range = maximum - minimum + 1;

            BST<Integer, Integer>[] BstArray = new BST[20];

            float nTrees = 0;
            float nBalancedTrees = 0;

            for (int i=0; i<20; i++) {

                BstArray[i] = new BST<>();
                for (int j=0; j<63; j++) {
                    int newKey = rn.nextInt(range) + minimum;
                    int newVal = rn.nextInt(range) + minimum;
                    BstArray[i].put(newKey, newVal);
                }

                nTrees += 1;
                if (BstArray[i].isBalanced()) {
                    nBalancedTrees += 1;
                }
            }

            System.out.println(nBalancedTrees / nTrees);

        }
}
