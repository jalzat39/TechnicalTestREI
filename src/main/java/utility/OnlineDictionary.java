package utility;

import java.io.*;
import java.util.*;

public class OnlineDictionary {

    public static List<String> dictionaryList = new ArrayList<>();

    public static List<String> createDictionaryArray() throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(
                "src/main/java/resources/EnglishWords.txt"));
        String words;
        while(scanner.hasNext()){
            words = scanner.next();
            dictionaryList.add(words);
        }
        return dictionaryList;
    }
}
