package hw3;

public class ReverseStringRow {
    private String s;
    private MyStack<Character> ms = new MyStack<>();

    public ReverseStringRow(String s){
        this.s = s;
    }

    public String getReversedString() {
        String sReversed = "";
        for (int i=0; i<s.length(); i++) {
            ms.push(s.charAt(i));
        }
        for (int i=0; i<s.length(); i++) {
            Character lastChar = ms.pop();
            sReversed += lastChar;
        }
        return sReversed;
    }

}
