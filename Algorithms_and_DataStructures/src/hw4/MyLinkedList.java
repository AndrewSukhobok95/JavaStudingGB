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

    public boolean isEmpty() { return first==null; }

    public void insertFirst(T value){
        Node newNode = new Node(value);
        newNode.setNext(first);
        newNode.setPrevious(null);
        if (isEmpty()) {
            last = newNode;
        }else{
            first.setPrevious(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T value){
        Node newNode = new Node(value);
        newNode.setNext(null);
        newNode.setPrevious(last);
        if (isEmpty()) {
            first = newNode;
        }else{
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    public String toString() {
        Node current = first;
        String sep;
        String s = "";
        while (current != null) {
            if (current.getNext()==null){
                sep = "";
            }else{
                sep = ", ";
            }
            s += current.getValue() + sep;
            current = current.getNext();
        }
        return s;
    }
}
