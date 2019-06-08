package hw3;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- MyStack realization check (task 1 and 4) --");
        checkMyStack();
        System.out.println();

        System.out.println("-- MyQueue realization check (task 1 and 5) --");
        checkMyQueue();
        System.out.println();

        System.out.println("-- ReverseStringTask check (task 2) --");
        checkReverseStringTask();
        System.out.println();

        System.out.println("-- MyDeque realization check (task 3) --");
        checkMyDeque();
        System.out.println();



    }

    public static void checkMyStack(){
        MyStack<Integer> ms = new MyStack<>(3);
        for (int i=0; i<7; i++){
            System.out.println("capacity = " + ms.getCapacity());
            System.out.println(i);
            ms.push(i);
            System.out.println("+++");
        }
        int curSize = ms.getSize();
        for (int i=0; i<curSize; i++){
            System.out.println("getSize = " + ms.getSize());
            System.out.println("current element = " + ms.pop());
            System.out.println("===");
        }
    }

    public static void checkReverseStringTask(){
        String s = "abcde123";
        ReverseStringRow rsr = new ReverseStringRow(s);
        System.out.println(rsr.getReversedString());
    }

    public static void checkMyQueue(){
        MyQueue<Integer> mq = new MyQueue<>(3);

        mq.insert(1);
        System.out.println(mq);
        mq.insert(2);
        System.out.println(mq);
        mq.remove();
        System.out.println(mq);
        mq.insert(3);
        System.out.println(mq);
        mq.insert(4);
        System.out.println(mq);
        mq.insert(5);
        System.out.println(mq);
        mq.insert(6);
        System.out.println(mq);
        mq.insert(7);
        System.out.println(mq);
        mq.remove();
        System.out.println(mq);
        mq.remove();
        System.out.println(mq);
        mq.remove();
        System.out.println(mq);
        mq.insert(8);
        System.out.println(mq);
        mq.insert(9);
        System.out.println(mq);
        mq.insert(10);
        System.out.println(mq);
        mq.insert(11);
        System.out.println(mq);
    }

    public static void checkMyDeque() {
        MyDeque<Integer> md = new MyDeque<>(4);

        md.insertLeft(1);
        System.out.println(md);
        md.insertLeft(2);
        System.out.println(md);
        md.insertLeft(3);
        System.out.println(md);
        md.insertLeft(4);
        System.out.println(md);
        md.insertLeft(5);
        System.out.println(md);

        md.removeRight();
        System.out.println(md);
        md.removeLeft();
        System.out.println(md);

        md.insertLeft(6);
        System.out.println(md);
        md.insertLeft(7);
        System.out.println(md);

        md.removeRight();
        System.out.println(md);

        md.insertLeft(8);
        System.out.println(md);
    }
}
