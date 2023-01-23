package code;

import utility.OnlineDictionary;

public class Dictionary {

    /**
     * Method in charge of comparing the given word and comparing
     * it with each of those in the dictionary to determine if it
     * is an English word or not
     *
     * @param word It is the word that we are going to look up
     *             in the dictionary to know if it is a word in English
     * @return The method returns if the word entered is in English or not
     */
    public static boolean isEnglishWord(String word) {
        if (OnlineDictionary.wordsSet.contains(word)) {
            return true;
        }
        return false;
    }
}
