package lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>();

        mal.add(5);
        mal.add(6);
        mal.add(7);

        System.out.println(mal);
        mal.add(2,99);
        System.out.println(mal);
//
//        mal.delete(9999);
//        System.out.println(mal);
//
//        System.out.println(mal.find(77));

//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
//        msal.add(6);
//        msal.add(2);
//        msal.add(9);
//        msal.add(3);
//        msal.add(4);
//        System.out.println(msal);
//        System.out.println(msal.binaryFind(48));




//

    }
}
