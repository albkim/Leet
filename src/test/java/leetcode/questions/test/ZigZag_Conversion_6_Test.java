package leetcode.questions.test;

import leetcode.questions.ZigZag_Conversion_6;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/1/2016.
 */
public class ZigZag_Conversion_6_Test {

    @Test
    public void testSample() {
        assertEquals("PAHNAPLSIIGYIR", ZigZag_Conversion_6.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void testLengthEqualsNumRows() {
        assertEquals("A", ZigZag_Conversion_6.convert("A", 1));
        assertEquals("ABC", ZigZag_Conversion_6.convert("ABC", 3));
    }

    @Test
    public void testLengthLessNumRows() {
        assertEquals("A", ZigZag_Conversion_6.convert("A", 2));
        assertEquals("ABC", ZigZag_Conversion_6.convert("ABC", 4));
    }

    @Test
    public void testNumRowsEquals1() {
        assertEquals("ABC", ZigZag_Conversion_6.convert("ABC", 1));
    }

    @Test
    public void testNumRowsEquals2() {
        assertEquals("ACB", ZigZag_Conversion_6.convert("ABC", 2));
    }

    @Test
    public void test4() {
        /*
        P  I   N
        A LS  IG
        YA HR
        P  I
         */
        assertEquals("PINALSIGYAHRPI", ZigZag_Conversion_6.convert("PAYPALISHIRING", 4));
    }

}
