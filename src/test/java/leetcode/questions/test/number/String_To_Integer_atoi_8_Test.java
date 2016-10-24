package leetcode.questions.test.number;

import leetcode.questions.number.String_To_Integer_atoi_8;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/1/2016.
 */
public class String_To_Integer_atoi_8_Test {

    @Test
    public void testNull() {
        assertEquals(0, String_To_Integer_atoi_8.myAtoi(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(0, String_To_Integer_atoi_8.myAtoi(""));
    }

    @Test
    public void testSignNegative() {
        assertEquals(-1, String_To_Integer_atoi_8.myAtoi("-1"));
    }

    @Test
    public void testSignPositive() {
        assertEquals(1, String_To_Integer_atoi_8.myAtoi("+1"));
    }

    @Test
    public void testInvalidMultipleSign() {
        assertEquals(0, String_To_Integer_atoi_8.myAtoi("-+1"));
    }

    @Test
    public void testInvalidSignPosition() {
        assertEquals(0, String_To_Integer_atoi_8.myAtoi("1+"));
    }

    @Test
    public void testNumber() {
        assertEquals(12345, String_To_Integer_atoi_8.myAtoi("12345"));
    }

    @Test
    public void testOverflowOverMax() {
        assertEquals(Integer.MAX_VALUE, String_To_Integer_atoi_8.myAtoi("2147483648"));
    }

    @Test
    public void testOverflowBelowMin() {
        assertEquals(Integer.MIN_VALUE, String_To_Integer_atoi_8.myAtoi("-2147483648"));
    }

    @Test
    public void testOverflowReallyBig() {
        assertEquals(Integer.MAX_VALUE, String_To_Integer_atoi_8.myAtoi("9223372036854775809"));
    }

    @Test
    public void testSpace() {
        assertEquals(10, String_To_Integer_atoi_8.myAtoi("  10  "));
    }

    @Test
    public void testSpace2() {
        assertEquals(1, String_To_Integer_atoi_8.myAtoi("  1 4 6 0  "));
    }

    @Test
    public void testSpace3() {
        assertEquals(0, String_To_Integer_atoi_8.myAtoi("  - 1 4 6 0  "));
    }

    @Test
    public void testSignNegativeWithSpace() {
        assertEquals(-1, String_To_Integer_atoi_8.myAtoi("    -1"));
    }

    @Test
    public void testBreakOnInvalidChars() {
        assertEquals(-12, String_To_Integer_atoi_8.myAtoi("  -0012a42"));
    }

    @Test
    public void testBreakOnSpaceInTheMiddle() {
        assertEquals(0, String_To_Integer_atoi_8.myAtoi("   +0 123"));
    }

}
