package hw3;

public class MyDeque<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 5;
    private int capacity = DEFAULT_CAPACITY;
    private int begin = 0;
    private int end = 0;

    public MyDeque(){
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyDeque(int capacity){
        if(capacity <=0 ){
            ensureCapacity();
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public void insertLeft(T item){
        if (isFull()){
            ensureCapacity();
        }
        size++;
        list[end]=item;
        end = nextLeftIndex(end);
    }

    public T removeRight(){
        T value = list[begin];
        size--;
        list[begin] = null;
        begin = nextLeftIndex(begin);
        return value;
    }

    private int nextLeftIndex(int index) {
        return (index + 1) % capacity;
    }


    public void insertRight(T item){
        if (isFull()){
            throw new StackOverflowError("stack full");
        }
        size++;
        begin = nextRightIndex(begin);
        list[begin]=item;
    }

    public T removeLeft(){
        end = nextRightIndex(end);
        T value = list[end];
        size--;
        list[end] = null;
        return value;
    }

    private int nextRightIndex(int index) {
        return (capacity + index - 1) % capacity;
    }

    private void ensureCapacity(){
        int newCapacity = capacity + DEFAULT_CAPACITY;
        T[] tempArr = (T[]) new Object[newCapacity];
        if (begin>end-1){
            System.arraycopy(list, begin, tempArr, 0, capacity-begin);
            System.arraycopy(list, 0, tempArr, capacity-begin, end);
        }else{
            System.arraycopy(list, begin, tempArr, 0, size);
        }
        begin = 0;
        end = size;
        capacity = newCapacity;
        list = tempArr;
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

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < capacity ; i++) {
            s+= list[i] +" ";
        }
        return s;
    }
}
