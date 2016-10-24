package leetcode.questions.test.number;

import leetcode.questions.number.Integer_English_Words_273;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/16/2016.
 */
public class Integer_English_Words_273_Test {

    @Test
    public void testSimple() {
        assertEquals("One Hundred Twenty Three", Integer_English_Words_273.numberToWords(123));
        assertEquals("Twelve Thousand Three Hundred Forty Five", Integer_English_Words_273.numberToWords(12345));
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", Integer_English_Words_273.numberToWords(1234567));
    }

    @Test
    public void testEdge() {
        assertEquals("Thirty", Integer_English_Words_273.numberToWords(30));
        assertEquals("Zero", Integer_English_Words_273.numberToWords(0));
        assertEquals("One Hundred", Integer_English_Words_273.numberToWords(100));
    }

}
