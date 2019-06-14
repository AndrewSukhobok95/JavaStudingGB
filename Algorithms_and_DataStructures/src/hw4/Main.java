package hw4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Check MyLinkedList");

        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.insertLast(4);
        mll.insertFirst(3);
        mll.insertFirst(2);
        mll.insertFirst(1);
        mll.insertLast(5);
        mll.insertFirst(0);
        mll.insertLast(6);

        System.out.println(mll);

        System.out.println("==================");
    }
}
