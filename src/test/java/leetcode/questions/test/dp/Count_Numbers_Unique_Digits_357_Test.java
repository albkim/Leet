package leetcode.test.questions.dp;

import leetcode.questions.dp.Count_Numbers_Unique_Digits_357;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 9/20/16.
 */
public class Count_Numbers_Unique_Digits_357_Test {

    @Test
    public void testSimple() {
        assertEquals(91, Count_Numbers_Unique_Digits_357.countNumbersWithUniqueDigits(2));
    }

    @Test
    public void testComplex() {
        assertEquals(739, Count_Numbers_Unique_Digits_357.countNumbersWithUniqueDigits(3));
    }

}
