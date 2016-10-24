package leetcode.questions.test.binary_search;

import leetcode.questions.bits.Find_Duplicate_Number_287;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/17/2016.
 */
public class Find_Duplicate_Number_287_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Find_Duplicate_Number_287.findDuplicate(new int[] {1,1,2}));
    }

    @Test
    public void testSimple1() {
        assertEquals(2, Find_Duplicate_Number_287.findDuplicate(new int[] {1,2,2}));
    }

}
