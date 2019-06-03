package hw2;

public class MyArrayList<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity is less then 0");
        } else {
            list = (T[]) new Comparable[capacity];
            this.capacity = capacity;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size - 1; i++) {
            s += list[i] + ", ";
        }
        s += list[size - 1] + "]";
        return s;
    }

    public int getSize() { return size; }

    public int getCapacity() { return capacity; }

    private boolean checkCapacityAvailable() {
        return size >= capacity;
    }

    private void ensureCapacity() {
        T[] tmpList = (T[]) new Comparable[list.length + DEFAULT_CAPACITY];
        capacity = list.length + DEFAULT_CAPACITY;
        System.arraycopy(list, 0, tmpList, 0, list.length);
        this.list = tmpList;
    }

    public void set(int index, T element) {
        list[index] = element;
    }

    public T get(int index) {
        return list[index];
    }

    public boolean add(T element) {
        if (checkCapacityAvailable()) {
            ensureCapacity();
        }
        list[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, T element) {
        if (checkCapacityAvailable()) {
            ensureCapacity();
        }
        if (index < 0){
            index = 0;
        }
        if (index > size){
            index = size;
        }
        for (int i=size; i>index; i--){
            list[i] = list[i-1];
        }
        list[index] = element;
        size++;
        return true;
    }

    public boolean deleteElementByIndex(int index) {
        if (index < 0) {index = 0;}
        if (index >= size) {index = size-1;}
        for (int j=index; j<size-1; j++){
            list[j] = list[j+1];
        }
        list[size] = null;
        size--;
        return true;
    }

    public boolean deleteElement(T element) {
        int dropIndex = -1;
        for (int i=size-1; i>=0; i--){
            if (list[i].equals(element)){
                dropIndex = i;
                break;
            }
        }
        if (dropIndex>=0){
            deleteElementByIndex(dropIndex);
            return true;
        }
        return false;
    }

    public boolean find(T element){
        for (int i=0; i<size; i++){
            if (list[i].equals(element)){return true;}
        }
        return false;
    }

    private boolean E1moreE2(T e1, T e2){
        return e1.compareTo(e2)>0;
    }

    private void swapElements(int index1, int index2){
        T tmp1 = this.list[index1];
        list[index1] = list[index2];
        list[index2] = tmp1;
    }

    public boolean bubbleSort(){
        for (int outer=size-1; outer>0; outer--){
            boolean wasSwaped = false;
            for (int inner=0; inner<outer; inner++){
                if (E1moreE2(list[inner], list[inner+1])){
                    swapElements(inner, inner+1);
                    wasSwaped = true;
                }
            }
            if (!wasSwaped){break;}
        }
        return true;
    }

    public void insertionSort() {
        T marker;
        int inner;
        for (int outer = 0; outer < size; outer++) {
            inner = outer;
            marker = list[outer];
            while (inner > 0 && E1moreE2(list[inner-1], marker)) {
                list[inner] = list[inner - 1];
                inner--;
            }
            list[inner] = marker;
        }
    }

    public void selectionSort() {
        for (int left = 0; left < size - 1; left++) {
            int minIndex = left;
            for (int right = left + 1; right < size; right++) {
                if (E1moreE2(list[minIndex], list[right])) {
                    minIndex = right;
                }
            }
            swapElements(left, minIndex);
        }
    }

}
