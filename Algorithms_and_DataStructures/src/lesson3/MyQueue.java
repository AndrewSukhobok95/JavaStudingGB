package lesson3;

public class MyQueue<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private  int begin = 0;
    private  int end = 0;

    public MyQueue(int capacity) {
        if(capacity <=0 ){
            throw new IllegalArgumentException("bad capacity "+ capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyQueue() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }
    // 0 1 2 3 4
    // b
    //   e
    // 7 8

    public void insert(Item item){
        if (isFull()){
            throw new StackOverflowError();
        }
        size++;
        list[end]=item;
        end = nextIndex(end);
    }

    public Item remove(){
        Item value = peek();
        size--;
        list[begin]=null;
        begin = nextIndex(begin);
        return value;
    }

    public Item peek(){
        if (isEmpty()){
            throw new StackOverflowError("stack empty ");
        }
        return list[begin];
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
        System.arraycopy(list,0,tempArr,0,list.length);
        list = tempArr;
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length ; i++) {
            s+= list[i] +" ";
        }
        return s;
    }
}
