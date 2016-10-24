package leetcode.questions.test.number;

import leetcode.questions.number.Multiply_Strings_43;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/12/2016.
 */
public class Multiply_Strings_43_Test {

    @Test
    public void test0() {
        assertEquals(String.valueOf(0), Multiply_Strings_43.multiply("0", "123"));
        assertEquals(String.valueOf(0), Multiply_Strings_43.multiply("123", "0"));
        assertEquals(String.valueOf(0), Multiply_Strings_43.multiply("0", "0"));
    }

    @Test
    public void testSimple() {
        assertEquals(String.valueOf(5 * 5), Multiply_Strings_43.multiply("5", "5"));
    }

    @Test
    public void testComplex() {
        assertEquals(String.valueOf(123 * 123), Multiply_Strings_43.multiply("123", "123"));
    }

    @Test
    public void testComplex2() {
        assertEquals(String.valueOf(6 * 501), Multiply_Strings_43.multiply("6", "501"));
    }

}
