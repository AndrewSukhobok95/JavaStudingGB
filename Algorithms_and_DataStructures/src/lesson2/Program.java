package lesson2;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
//        int[] array1 = new int[10];
//        String[] stringArray;
//        stringArray = new String[10];
//
//        for (int i = 0; i < array1.length; i++) {
//            array1[i] = i;
//        }
//        System.out.println(Arrays.toString(array1));
//
//        for (int i = 0; i < array1.length; i++) {
//            if (array1[i] % 2 != 0){
//                array1[i]*=2;
//            }
//        }
//        for (int i = 0; i < array1.length ; i++) {
//            System.out.print(array1[i]+" ");
//        }
//        System.out.println();
//
//        for (Integer element:array1 ) {
//            System.out.print(element+" ");
//        }

        ArrayList<Integer> al = new ArrayList<>();
        al.add(4);
        al.add(3);
        al.add(8);
        al.add(7, 111);
        System.out.println(al);
        al.remove(3);
//        al.set(1,44);
//        System.out.println(al);
//        al.remove(0);
//        System.out.println(al);


    }
}
