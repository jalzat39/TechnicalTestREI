package code;

import utility.OnlineDictionary;

public class Dictionary {

    public static boolean isEnglishWord(String word){
        if(OnlineDictionary.dictionaryList.contains(word)){
            return true;
        }
        return false;
    }
}
