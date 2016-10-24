package leetcode.questions.bits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/7/2016.
 */
public class Single_Number_136_Test {

    @Test
    public void testSimple() {
        assertEquals(2, Single_Number_136.singleNumber(new int[] {1, 1, 3, 2, 3, 4, 5, 5, 4}));
    }

}
