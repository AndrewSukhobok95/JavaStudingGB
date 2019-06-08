package hw3;



public class MyStack<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;

    public MyStack(int capacity) {
        if(capacity <=0 ){
            throw new IllegalArgumentException("bad capacity "+ capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[this.capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item){
        if(isFull()){
            ensureCapacity();
        }
        list[size] = item;
        size++;
    }

    public T pop(){
        T temp = peek();
        if (isEmpty()){
            throw new StackOverflowError("stack empty ");
        }
        size--;
        list[size] = null;
        return temp;
    }

    public T peek(){
        if (isEmpty()){
            throw new StackOverflowError("stack empty ");
        }
        return list[size-1];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() { return capacity; }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    private void ensureCapacity() {
        int newCapacity = capacity + DEFAULT_CAPACITY;
        T[] tmpList = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tmpList, 0, capacity);
        this.list = tmpList;
        this.capacity = newCapacity;
    }
}
