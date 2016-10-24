package leetcode.questions.bits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Sang on 10/7/2016.
 */
public class Single_Number_II_137_Test {

    @Test
    public void testSimple() {
        assertEquals(2, Single_Number_II_137.singleNumber(new int[] {1, 2, 3, 4, 3, 4, 1, 1, 2, 3, 4}));
    }

}
