package code;

import utility.OnlineDictionary;

public class Dictionary {
    public static boolean isEnglishWord(String word){
        if(OnlineDictionary.wordsSet.contains(word)){
            return true;
        }
        return false;
    }
}
