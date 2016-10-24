package leetcode.questions.test.bits;

import leetcode.questions.bits.Excel_Sheet_Column_Number_171;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/10/2016.
 */
public class Excel_Sheet_Column_Number_171_Test {

    @Test
    public void testSimple() {
        assertEquals(52, Excel_Sheet_Column_Number_171.titleToNumber("AZ"));
        assertEquals(3, Excel_Sheet_Column_Number_171.titleToNumber("C"));
        assertEquals(53, Excel_Sheet_Column_Number_171.titleToNumber("BA"));
    }

}
