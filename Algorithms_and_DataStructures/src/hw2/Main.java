package hw2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        double startTime;
        double endTime;



        MyArrayList<Integer> mal1 = new MyArrayList<>(10000);
        for (int i=0; i<10000; i++){
            mal1.add(rn.nextInt(99999));
        }
        startTime = System.nanoTime();
        mal1.bubbleSort();
        endTime = System.nanoTime();
        System.out.println("Bubble sort time: " + ((endTime - startTime)/3600));



        MyArrayList<Integer> mal2 = new MyArrayList<>(10000);
        for (int i=0; i<10000; i++){
            mal2.add(rn.nextInt(99999));
        }
        startTime = System.nanoTime();
        mal2.insertionSort();
        endTime = System.nanoTime();
        System.out.println("Insertion sort time: " + ((endTime - startTime)/3600));



        MyArrayList<Integer> mal3 = new MyArrayList<>(10000);
        for (int i=0; i<10000; i++){
            mal3.add(rn.nextInt(99999));
        }
        startTime = System.nanoTime();
        mal3.selectionSort();
        endTime = System.nanoTime();
        System.out.println("Selection sort time: " + ((endTime - startTime)/3600));



    }
}
