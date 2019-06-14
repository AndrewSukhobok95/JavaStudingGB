package hw4;

public class MyLinkedList<T> {

    private class Node<T> {
        private Node next;
        private Node previous;
        private T value;

        public Node(T value) { this.value = value; }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue(){ return value; }

        public void setValue(T value) { this.value = value; }

        public Node getNext() { return next; }

        public void setNext(Node next) { this.next = next; }

        public Node getPrevious() { return previous; }

        public void setPrevious(Node previous) { this.previous = previous; }
    }


    private Node first;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last=null;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public void insertFirst(T value){
        Node newNode = new Node(value);
        newNode.setNext(first);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            newNode.setPrevious(first);
        }
    }
}
