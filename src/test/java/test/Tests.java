package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utility.Search;

public class Tests {

    private Search search;

    @Before
    public void upSet() {
        search = new Search();
    }

    @Test
    public void testContainLastWord() {
        Assert.assertTrue(search.covertWord("ilikesamsung").contains("sung"));
    }

    /**
     * Second test, which checks, given a word in English and may contain within
     * it another word in English and this located at the beginning of the word.
     */
    @Test
    public void testContainFirstWord() {
        Assert.assertTrue(search.covertWord("ilikesamsung").contains("like"));
    }

    /**
     * Third test, check that, given a word in English, to be able to show the words
     * in English that it contains.
     */
    @Test
    public void testShowWordsWorking() {
        Assert.assertTrue(search.covertWord("working").contains("row"));
    }

    /**
     * Forth test, check that, given a word in English, you can find other words in
     * English by changing the order of the letters.
     */
    @Test
    public void testWordsExchanged() {
        Assert.assertTrue(search.covertWord("working").contains("working"));
    }

    /**
     * Fifth test, validate that, given a word in English and within it the same word
     * in English can be twice, only save one word in English.
     */
    @Test
    public void testDontRepeatWords() {
        Assert.assertEquals(1, search.covertWord("workingring").stream().filter(i -> i.equals("ring")).count());
    }

    /**
     * Sixth test, validate that, when a word in English does not appear in the dictionary,
     * it marks it as false.
     */
    @Test
    public void testWordDoesntAppear() {
        Assert.assertTrue(search.covertWord("banana").isEmpty());
    }

    /**
     * Seven test, check that, given a very long English word, the system can respond quickly
     */
    @Test(timeout = 5000)
    public void testLargeWords() {
        Assert.assertTrue(search.covertWord("workingRingWorkingRingWorkingRing").contains("ring"));
    }

    /**
     * Eighth test, validate that, given a word in English with changes in uppercase and lowercase
     * letters, the program can work correctly.
     */
    @Test
    public void testUpperLowerWords() {
        Assert.assertTrue(search.covertWord("WoRKiNg").contains("ring"));
    }

    /**
     * Ninth test, validate that, given a word in English that is empty.
     */
    @Test
    public void testEmptyWords() {
        try {
            Assert.assertFalse(search.covertWord("").isEmpty());
        } catch (Exception e) {
            System.out.println(e);
            Assert.assertEquals("java.lang.RuntimeException: The word only have alphabet character", e.toString());
        }
    }

    /**
     * Tenth test, validate that, given a word in English with blank space.
     */
    @Test
    public void testBlankSpace() {
        try {
            Assert.assertFalse(search.covertWord("Working Ring").isEmpty());
        } catch (Exception e) {
            System.out.println(e);
            Assert.assertEquals("java.lang.RuntimeException: The word only have alphabet character", e.toString());
        }
    }
}
