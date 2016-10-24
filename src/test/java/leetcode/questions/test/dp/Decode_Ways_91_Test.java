package leetcode.questions.test.dp;

import leetcode.questions.dp.Decode_Ways_91;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/27/2016.
 */
public class Decode_Ways_91_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Decode_Ways_91.numDecodings(""));
        assertEquals(0, Decode_Ways_91.numDecodings("0"));
    }

    @Test
    public void testEdge2() {
        assertEquals(1, Decode_Ways_91.numDecodings("10"));
        assertEquals(0, Decode_Ways_91.numDecodings("00"));
        assertEquals(0, Decode_Ways_91.numDecodings("01"));
    }

    @Test
    public void testSimple() {
        assertEquals(2, Decode_Ways_91.numDecodings("12"));
    }

    @Test
    public void testComplex() {
        //(1, 26), (12, 6), (1, 2, 6)
        assertEquals(3, Decode_Ways_91.numDecodings("126"));
    }

}
