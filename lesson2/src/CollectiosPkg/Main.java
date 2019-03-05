package CollectiosPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // First Task
        ArrayList<String> wordsArray = new ArrayList<>(
                Arrays.asList("a", "b", "c", "d", "a", "e", "f", "f", "f", "g", "h", "b", "i", "j", "i"));
        HashMap<String, Integer> wordsCountMap = processArray(wordsArray);
        System.out.println("Words Count Map is " + wordsCountMap.toString());
        System.out.println();

        // Second Task
        TelephoneBook tb = new TelephoneBook();
        tb.add("Petrov", "1234567");
        tb.add("Petrov", "1234568");
        tb.add("Sidorov", "1234567");

        ArrayList petrovPhones = tb.get("Petrov");
        System.out.println("Petrov phones is " + petrovPhones.toString());

        HashMap book = tb.getBook();
        System.out.println(book.toString());
    }

    public static HashMap<String, Integer> processArray(ArrayList<String> wordsArray) {
        HashSet<String> uniqueWords = new HashSet<>(wordsArray);
        System.out.println("Unique words are: " + uniqueWords.toString().replace("[", "").replace("]", ""));

        HashMap<String, Integer> wordsCountMap = new HashMap<>();
        for(String word: wordsArray){
            if(wordsCountMap.containsKey(word)){
                wordsCountMap.put(word, wordsCountMap.get(word)+1);
            }else{
                wordsCountMap.put(word, 1);
            }
        }
        return wordsCountMap;
    }
}
