package lesson3;

public class MyStack<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if(capacity <=0 ){
            throw new IllegalArgumentException("bad capacity "+ capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyStack() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(Item item){
        if(isFull()){
//            throw new StackOverflowError("stack full");
            resize(size*2);
        }
        list[size] = item;
        size++;
    }

    public Item pop(){
        Item temp = peek();
        size--;
        list[size] = null;
        if (size < list.length * 0.25 ){
            resize(size / 2);
        }
        return temp;
    }

    public Item peek(){
        if (isEmpty()){
            throw new StackOverflowError("stack empty ");
        }
        return list[size-1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }

    private void resize(int newSize){
        Item[] tempArr = (Item[]) new Object[newSize];
//        System.arraycopy(list,0,tempArr,0,Math.min(list.length, newSize));
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
    }
}
