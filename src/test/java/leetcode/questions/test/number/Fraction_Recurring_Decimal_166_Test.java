package leetcode.questions.test.number;

import leetcode.questions.number.Fraction_Recurring_Decimal_166;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Fraction_Recurring_Decimal_166_Test {

    @Test
    public void testSimple() {
        assertEquals("0.(01)", Fraction_Recurring_Decimal_166.fractionToDecimal(1, 99));
        assertEquals("0.1(6)", Fraction_Recurring_Decimal_166.fractionToDecimal(1, 6));
        assertEquals("0.(6)", Fraction_Recurring_Decimal_166.fractionToDecimal(2,3));
        assertEquals("0.5", Fraction_Recurring_Decimal_166.fractionToDecimal(1,2));
        assertEquals("2", Fraction_Recurring_Decimal_166.fractionToDecimal(2,1));
    }

    @Test
    public void testNegative() {
        assertEquals("-6.25", Fraction_Recurring_Decimal_166.fractionToDecimal(-50, 8));
    }

    @Test
    public void testOverflow() {
        assertEquals("0.0000000004656612873077392578125", Fraction_Recurring_Decimal_166.fractionToDecimal(-1, -2147483648));
    }

}
