package leetcode.questions.test.bits;

import leetcode.questions.bits.Excel_Sheet_Column_Title_168;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Excel_Sheet_Column_Title_168_Test {

    @Test
    public void testSimple() {
        assertEquals("AZ", Excel_Sheet_Column_Title_168.convertToTitle(52));
        assertEquals("C", Excel_Sheet_Column_Title_168.convertToTitle(3));
        assertEquals("BA", Excel_Sheet_Column_Title_168.convertToTitle(53));
    }

}
