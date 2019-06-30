package hw4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Check MyLinkedList");

        MyLinkedList<Integer> mll = new MyLinkedList<>();

        System.out.println("\nInsert First and Last check");
        mll.insertLast(3);
        mll.insertFirst(2);
        mll.insertLast(4);
        mll.insertFirst(1);
        System.out.println(mll);

        System.out.println("\nDelete First and Last check");
        System.out.println(mll.deleteLast());
        System.out.println(mll.deleteFirst());
        System.out.println(mll.deleteLast());
        System.out.println(mll.deleteFirst());
        System.out.println(mll.deleteLast());
        System.out.println(mll);

        System.out.println("\nIndex Of check");
        mll.insertLast(3);
        mll.insertFirst(2);
        mll.insertLast(4);
        mll.insertFirst(1);
        System.out.println(mll.indexOf(1));
        System.out.println(mll.indexOf(2));
        System.out.println(mll.indexOf(3));
        System.out.println(mll.indexOf(4));
        System.out.println(mll.indexOf(10));

        System.out.println("\nContains check");
        System.out.println(mll.contains(3));
        System.out.println(mll.contains(5));

        System.out.println("\nInsert check");
        System.out.println(mll);
        mll.insert(9, 0);
        mll.insert(10, 2);
        mll.insert(12, 10);
        System.out.println(mll);

        System.out.println("\nDelete check");
        System.out.println(mll);
        System.out.println(mll.delete(0));
        System.out.println(mll);
        System.out.println(mll.delete(10));
        System.out.println(mll);
        System.out.println(mll.delete(1));
        System.out.println(mll);


        System.out.println("==================");
    }
}
