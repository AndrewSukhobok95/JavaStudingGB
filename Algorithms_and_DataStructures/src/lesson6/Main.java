package lesson6;

public class Main {
    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();

        bst.put(5,"five");
        bst.put(1,"one");
        bst.put(3,"three");
        bst.put(2,"two");
        System.out.println(bst);

        System.out.println(bst.get(2));
        bst.put(2,"два");

        System.out.println(bst);
//        System.out.println(bst.get(2));

//        System.out.println(bst.min());
//        System.out.println(bst.max());
        bst.put(4,"four");
        bst.put(6,"six");
        System.out.println(bst);

        bst.delete(3);
        System.out.println(bst);

    }
}
