package hw3;

import javax.swing.*;

public class MyQueue<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 3;
    private  int capacity = DEFAULT_CAPACITY;
    private  int begin = 0;
    private  int end = 0;

    public MyQueue(int capacity) {
        if(capacity <=0 ){
            throw new IllegalArgumentException("bad capacity "+ capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }



    public void insert(T item){
        if (isFull()){
            ensureCapacity();
        }
        size++;
        list[end]=item;
        end = nextIndex(end);
    }

    public T peek(){
        if (isEmpty()){
            throw new StackOverflowError("stack empty ");
        }
        return list[begin];
    }

    public T remove(){
        T value = peek();
        size--;
        list[begin]=null;
        begin = nextIndex(begin);
        return value;
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

    private int nextIndex(int index){
        return (index + 1) % list.length;
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

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < capacity ; i++) {
            s+= list[i] +" ";
        }
        return s;
    }
}
