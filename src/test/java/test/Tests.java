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
    public void testInvertedWord() {
        Assert.assertTrue(search.covertWord("working").contains("row"));
    }

    @Test
    public void testWordsExchanged() {
        Assert.assertTrue(search.covertWord("working").contains("working"));
    }

    @Test
    public void testDontRepeatWords() {
        Assert.assertEquals(1, search.covertWord("workingring").stream().filter(i -> i.equals("ring")).count());
    }

    @Test
    public void testWordDoesntAppear() {
        Assert.assertTrue(search.covertWord("banana").isEmpty());
    }

    @Test(timeout = 5000)
    public void testLargeWords() {
        Assert.assertTrue(search.covertWord("workingRingWorkingRingWorkingRing").contains("ring"));
    }

    @Test
    public void testUpperLowerWords() {
        Assert.assertTrue(search.covertWord("WoRKiNg").contains("ring"));
    }

    @Test
    public void testOnlyLetters(){
        try {
            Assert.assertFalse(search.covertWord("Hello123").isEmpty());
        } catch (Exception e) {
            System.out.println(e);
            Assert.assertEquals("java.lang.RuntimeException: The word only have alphabet character", e.toString());
        }
    }

    @Test
    public void testEmptyWords() {
        try {
            Assert.assertFalse(search.covertWord("").isEmpty());
        } catch (Exception e) {
            System.out.println(e);
            Assert.assertEquals("java.lang.RuntimeException: The word only have alphabet character", e.toString());
        }
    }

    @Test
    public void testWithsRepeatLetters(){
        Assert.assertTrue(search.covertWord("cartoon").contains("cartoon"));
    }
}
