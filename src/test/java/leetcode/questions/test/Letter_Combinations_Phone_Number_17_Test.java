package leetcode.questions.test;

import leetcode.questions.Letter_Combinations_Phone_Number_17;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Letter_Combinations_Phone_Number_17_Test {

    @Test
    public void testSimple() {
        List<String> result = Letter_Combinations_Phone_Number_17.letterCombinations("23");

        assertEquals(9, result.size());
        assertEquals("ad", result.get(0));
        assertEquals("ae", result.get(1));
        assertEquals("af", result.get(2));
        assertEquals("bd", result.get(3));
        assertEquals("be", result.get(4));
        assertEquals("bf", result.get(5));
        assertEquals("cd", result.get(6));
        assertEquals("ce", result.get(7));
        assertEquals("cf", result.get(8));
    }

}
