package CollectiosPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TelephoneBook {
    private HashMap<String, ArrayList<String>> book = new HashMap<>();

    public HashMap<String, ArrayList<String>> getBook() {
        return book;
    }

    public void add(String surname, String phoneNumber){
        if(book.containsKey(surname)){
            book.get(surname).add(phoneNumber);
        }else{
            book.put(surname, new ArrayList<>());
            book.get(surname).add(phoneNumber);
        }
    }

    public ArrayList get(String surname) throws RuntimeException{
        if(!this.book.containsKey(surname)){
            throw new RuntimeException("There is no such surname in the telephone book.");
        }
        return this.book.get(surname);
    }
}
