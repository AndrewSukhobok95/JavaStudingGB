package lesson4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();

        mll.insertFirst("Katia");
        mll.insertFirst("Petia");
        mll.insertFirst("Sania");
        System.out.println(mll);

        mll.insert(2, "Maria");
        System.out.println(mll);

        System.out.println(mll.delete("Maria"));
        System.out.println(mll);

//        System.out.println(mll.indexOf("Sania"));
//        System.out.println(mll.contains("Petia"));

//        System.out.println(mll.deleteFirst());
//        System.out.println(mll);
//        System.out.println(mll.deleteLast());
//        System.out.println(mll);

//        for (Node node : mll) {
//            System.out.print(node.getValue() + ", ");
//        }
//        Iterator<Node<String>> iterator = mll.iterator();
//        while(iterator.hasNext()){
//            System.out.print(iterator.next().getValue()+", ");
//        }


        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i <10 ; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(myStack.pop()+" ");
        }

        System.out.println("\nmyQueue");
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i <10 ; i++) {
            myQueue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(myQueue.dequeue()+" ");
        }




    }

}
