package utility;

import code.Dictionary;

import java.util.HashSet;
import java.util.Set;

public class Search {

    /**
     * Set where each of the words found is stored
     */
    private final Set<String> wordFound = new HashSet<>();

    /**
     * Primary method in charge of verifying if the word contains only
     * letters of the alphabet and if it is not null, it initializes
     * the method that generates all the combinations of the chain and
     * returns in a Set all the words found without repeating.
     *
     * @param word Receive a string given by the user
     * @return This method returns a set that contains all the
     * English words of the word given by the user
     */
    public Set<String> covertWord(String word) {
        if (!word.matches("^[A-Za-z]*$") || word.isEmpty()) {
            throw new RuntimeException("The word only have alphabet character");
        }
        finder(word.toLowerCase().split(""), "", word.length() + 1, word.length());
        return wordFound;
    }

    /**
     * Recursive method in charge of generating all the combinations with each of the letters that
     * are obtained from the word that the user gives us, at the same time it sends isEnglishWord
     * to know if the word is an English word or not and thus add it to the Set wordFound.
     *
     * @param element It is an Array that contains all the letters of the string given by the user
     * @param actual  It is the current string to which more letters will be added as an option
     * @param n       It is the number of iterations that we want to do, usually it is one more than the size of elements
     * @param r       Is the length of the element
     */
    private void finder(String[] element, String actual, int n, int r) {
        if (n == 0) {
        } else {
            for (int i = 0; i < r; i++) {
                if (!actual.contains(element[i])) {
                    finder(element, actual + element[i], n - 1, r);
                }
            }
            if (Dictionary.isEnglishWord(actual)) {
                wordFound.add(actual);
            }
        }
    }
}
