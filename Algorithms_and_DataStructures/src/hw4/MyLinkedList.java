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

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

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

    public T deleteFirst() {
        if (isEmpty()) {
            last = null;
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        }else{
            first.setPrevious(null);
        }
        size--;
        return (T) oldFirst.getValue();
    }

    public T deleteLast() {
        if (isEmpty()) {
            first = null;
            return null;
        }
        Node oldLast = last;
        last = last.getPrevious();
        if (last==null) {
            first=null;
        }else{
            last.setNext(null);
        }
        size--;
        return (T) oldLast.getValue();
    }

    public int indexOf(T value) {
        Node currentElement = first;
        int index = 0;
        while (currentElement.getValue() != value) {
            index++;
            currentElement = currentElement.getNext();
            if (index==size) {
                return -1;
            }
        }
        return index;
    }

    public boolean contains(T value) {
        return indexOf(value) > -1;
    }

    public void insert(T value, int index) {
        Node newNode = new Node(value);
        Node currentElement = first;

        if (index <= 0) {
            insertFirst(value);
            return;
        }
        if (index >= size-1) {
            insertLast(value);
            return;
        }

        for (int i=0; i<index; i++) {
            currentElement = currentElement.getNext();
        }
        Node prevElement = currentElement.getPrevious();

        prevElement.setNext(newNode);
        currentElement.setPrevious(newNode);
        newNode.setPrevious(prevElement);
        newNode.setNext(currentElement);
        size++;
    }

    public boolean delete(int index) {
        if (isEmpty()) {
            return false;
        }
        if (index <= 0) {
            deleteFirst();
            return true;
        }
        if (index >= size-1) {
            deleteLast();
            return true;
        }
        Node currentElement = first;
        for (int i=0; i<index; i++) {
            currentElement = currentElement.getNext();
        }

        currentElement.getPrevious().setNext(currentElement.getNext());
        currentElement.getNext().setPrevious(currentElement.getPrevious());

        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        String sep;
        String s = "[";
        while (current != null) {
            if (current.getNext()==null){
                sep = "";
            }else{
                sep = ", ";
            }
            s += current.getValue() + sep;
            current = current.getNext();
        }
        return s + "]";
    }
}
