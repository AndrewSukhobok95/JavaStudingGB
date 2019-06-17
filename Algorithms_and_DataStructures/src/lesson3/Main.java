package lesson3;

public class Main {
    public static void main(String[] args) {
////        MyStack<Integer> myStack = new MyStack(8);
////        myStack.push(1);
////        myStack.push(2);
////        myStack.push(3);
////        myStack.push(4);
////        myStack.push(5);
////        myStack.push(6);
////        for (int i = 0; i < 6; i++) {
////            System.out.println(myStack.pop());
////        }
//
////        Expression e = new Expression("(4-6)+[34+{2*5}]");
////        System.out.println(e.checkBracket());
//
////        MyQueue<Integer> myQueue = new MyQueue<>(5);
////        myQueue.insert(1);
////        myQueue.insert(2);
////        myQueue.insert(3);
////        System.out.println(myQueue);
////
////        System.out.println(myQueue.remove());
////        System.out.println(myQueue.remove());
////        System.out.println(myQueue);
////
////        myQueue.insert(11);
////        myQueue.insert(12);
////        myQueue.insert(13);
////        System.out.println(myQueue);
//
////        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>();
////        mpq.insert(5);
////        System.out.println(mpq);
////        mpq.insert(3);
////        System.out.println(mpq);
////        mpq.insert(4);
////        System.out.println(mpq);
////        mpq.insert(1);
////        System.out.println(mpq);
////        mpq.insert(8);
////        System.out.println(mpq);
////
////        System.out.println(mpq.remove());
////        System.out.println(mpq.remove());
////        System.out.println(mpq);
//
////        MyDeque<String> myDeque = new MyDeque<>();
        System.out.println(reverseString("qwerty"));

    }

    public static String reverseString(String s){
//        StringBuilder sb = new StringBuilder(s);
//        return sb.reverse().toString();
    MyStack<Character> stack = new MyStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        String str="";
        for (int i = 0; i < s.length(); i++) {
            str+= stack.pop();
        }
        return str;
    }
}
