package utility;

import code.Dictionary;

import java.util.HashSet;
import java.util.Set;

public class Search {

    private final Set<String> wordFound = new HashSet<>();

    public Set<String> covertWord(String word){
        if(!word.matches("^[A-Za-z]*$") || word.isEmpty()){
            throw new RuntimeException("The word only have alphabet character");
        }
        finder(word.toLowerCase().split(""), "", word.length() + 1, word.length());
        return wordFound;
    }

    private void finder(String[] element, String actual, int n, int r){
        if (n == 0) {
        } else {
            for (int i = 0; i < r; i++) {
                if (!actual.contains(element[i])) {
                    finder(element, actual + element[i], n - 1, r);
                }
            }
            if (Dictionary.isEnglishWord(actual)){
                wordFound.add(actual);
            }
        }
    }
}
