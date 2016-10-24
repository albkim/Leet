package leetcode.questions.test.number;

import leetcode.questions.number.Ugly_Number_263;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/15/2016.
 */
public class Ugly_Number_263_Test {

    @Test
    public void testSimple() {
        assertFalse(Ugly_Number_263.isUgly(-2147483648));
        assertFalse(Ugly_Number_263.isUgly(14));
        assertTrue(Ugly_Number_263.isUgly(6));
        assertTrue(Ugly_Number_263.isUgly(8));
    }

}
